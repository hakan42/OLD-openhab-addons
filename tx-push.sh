#!/bin/sh -x

TOKEN=$(grep token ${HOME}/.transifexrc | sed -e 's|token\s=\s||')

HERE=$(realpath $(dirname $0))

# docker run \
#        --rm \
#        --name ci-transifex \
#        -e TX_TOKEN=${TOKEN} \
#        -v ${HERE}:/project \
#        ci-transifex \
#        tx -d push --source --root /project

if [ -d ${HERE}/bundles ]
then
    cd ${HERE}/bundles/org.openhab.binding.withings

    perl -w ${HERE}/extract4xlation.pl

    cat \
        src/main/resources/ESH-INF/i18n/withings_en.head.properties \
        src/main/resources/ESH-INF/i18n/withings_en.extracted.properties \
        src/main/resources/ESH-INF/i18n/withings_en.tail.properties \
        > src/main/resources/ESH-INF/i18n/withings_en.properties

    cd ${HERE}
fi

tx -d push --source --root ${HERE}
