#!/bin/sh -ex

export JAVA_HOME=/opt/jdk/jdk1.8.0_201
# export JAVA_HOME=/usr

export PATH=${JAVA_HOME}/bin:${JAVA_HOME}/jre/bin:${PATH}

# mvn clean verify -B -V -Dspotbugs.skip=true -DskipTests -Dmaven.test.skip 1> .build.stdout 2> .build.stderr

if [ -d bundles ]
then
    cd bundles/org.openhab.binding.pushbullet
fi

perl -w ../../extract4xlation.pl

cat \
    src/main/resources/ESH-INF/i18n/pushbullet_en.head.properties \
    src/main/resources/ESH-INF/i18n/pushbullet_en.extracted.properties \
    src/main/resources/ESH-INF/i18n/pushbullet_en.tail.properties \
    > src/main/resources/ESH-INF/i18n/pushbullet_en.properties


OFFLINE=${1:-yes}

if [ "${OFFLINE}" = "yes" ]
then
    OFFLINE=-o
else
    OFFLINE=
fi

mvn clean verify ${OFFLINE} -s ~/.m2/settings-nonexus.xml -B -V -Dsat.version=0.7.0-SNAPSHOT -Dspotbugs.skip=true -DskipTests -Dmaven.test.skip 1> .build.stdout 2> .build.stderr

cat .build.stdout
cat .build.stderr

mkdir -p ~/src/openhab/bundles

cp \
    target/*-SNAPSHOT.jar \
    ~/src/openhab/addons

# cp \
#     extensions/binding/org.eclipse.smarthome.binding.astro/target/*-SNAPSHOT.jar \
#     /home/openhab-tr/addons/

# docker stop openhab

case $(hostname -s) in
    sortarius-cms)
        # check for cmsblade01
        ping -W 1 -c 1 10.109.78.21 && REACHABLE=1 || REACHABLE=0
        if [ ${REACHABLE} = 1 ]
        then
            :
            scp target/*-SNAPSHOT.jar tandogah@cmsblade01:src/openhab/addons
            ssh tandogah@cmsblade01 "docker stop openhab || true"
        fi
        
        # check for wallaby
        ping -W 1 -c 1 192.168.42.42 && REACHABLE=1 || REACHABLE=0
        if [ ${REACHABLE} = 1 ]
        then
            :
            scp target/*-SNAPSHOT.jar hakan@home.gurkensalat.com:src/openhab/addons
            ssh hakan@home.gurkensalat.com "docker stop openhab || true"
        fi

        scp target/*-SNAPSHOT.jar jenkins-oh@home.gurkensalat.com:/home/jenkins-oh/.m2/repository/org/openhab/binding/org.openhab.binding.pushbullet/2.5.0-SNAPSHOT
    ;;

    *)
    ;;
esac
