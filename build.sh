#!/bin/sh -ex

export JAVA_HOME=/opt/jdk/jdk1.8.0_121
# export JAVA_HOME=/usr

export PATH=${JAVA_HOME}/bin:${JAVA_HOME}/jre/bin:${PATH}

# mvn clean verify -B -V -Dspotbugs.skip=true -DskipTests -Dmaven.test.skip 1> .build.stdout 2> .build.stderr

cd addons/binding/org.openhab.binding.nanoleaf
mvn clean verify -o -s ~/.m2/settings-nonexus.xml -B -V -Dspotbugs.skip=true -DskipTests -Dmaven.test.skip 1> .build.stdout 2> .build.stderr

cat .build.stdout
cat .build.stderr

mkdir -p ~/src/openhab/addons

cp \
    target/*-SNAPSHOT.jar \
    ~/src/openhab/addons

# cp \
#     extensions/binding/org.eclipse.smarthome.binding.astro/target/*-SNAPSHOT.jar \
#     /home/openhab-tr/addons/

# docker stop openhab

case $(hostname -s) in
    sortarius-cms)
	scp target/*-SNAPSHOT.jar hakan@home.gurkensalat.com:src/openhab/addons
	scp target/*-SNAPSHOT.jar jenkins-oh@home.gurkensalat.com:/home/jenkins-oh/.m2/repository/org/openhab/binding/org.openhab.binding.nanoleaf/2.5.0-SNAPSHOT
	ssh hakan@home.gurkensalat.com "docker stop openhab || true"
    ;;

    *)
    ;;
esac
