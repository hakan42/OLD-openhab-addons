#!/bin/sh -ex

# HASH=aa3f18980fda134cc41a571cddb398e82f7dfd13
HASH=9bb69719f8b68897779b5a42a28f659edbc3a941

#
# commit our binding
#
# git checkout sensebox-binding

git reset ${HASH}

git add \
    .gitignore \
    .tx/config \
    build.sh \
    commit.sh \
    extract4xlation.pl \
    tx-pull.sh \
    tx-push.sh \
    CODEOWNERS \
    bom/openhab-addons/pom.xml \
    bundles/pom.xml \
    bundles/org.openhab.binding.pushbullet \
    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet*.properties \

#    features/karaf/openhab-addons/src/main/feature/feature.xml \
    
git reset HEAD bundles/org.openhab.binding.pushbullet/.build.*
git reset HEAD bundles/org.openhab.binding.pushbullet/.idea
git reset HEAD bundles/org.openhab.binding.pushbullet/*.x

# cp bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties \
#    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties.template

# : > bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties

# head -n 4 bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties.template \
#      >> bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties

# tail -n 11 bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties.template \
#      >> bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties

# git add bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties

git reset HEAD bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.*.properties

git reset HEAD bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_de.properties
git reset HEAD bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_tr.properties

cat \
    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.head.properties \
    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.tail.properties \
    > bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties \

git add bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.properties

git commit \
    -s -m "[pushbullet] reimplementation for openHAB2" \
    CODEOWNERS \
    bom/openhab-addons/pom.xml \
    bundles/pom.xml \
    bundles/org.openhab.binding.pushbullet \
    # features/karaf/openhab-addons/src/main/feature \
    # bundles/org.openhab.binding.pushbullet/README.md \
    # bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/thing \
    # bundles/org.openhab.binding.pushbullet/META-INF \
    # bundles/org.openhab.binding.pushbullet/src \

# git commit \
#     -s -m "[pushbullet] tests for reimplementation for openHAB2" \
#     bundles/org.openhab.binding.pushbullet.test \

cat \
    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.head.properties \
    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.extracted.properties \
    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.tail.properties \
    > bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.template.properties \

#
#
#

git add bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_de.properties

git commit \
    -s -m "[pushbullet] [i18n] Translate pushbullet binding to german" \
    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_de.properties \

git add bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_tr.properties

git commit \
    -s -m "[pushbullet] [i18n] Translate pushbullet binding to turkish" \
    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_tr.properties \

git add bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.*.properties

git commit \
    -s -m "[pushbullet] [i18n] Pushbullet translation template" \
    bundles/org.openhab.binding.pushbullet/src/main/resources/ESH-INF/i18n/pushbullet_en.*.properties

# git commit \
#     -s -m "[pushbullet] [WIP] Tools to support pushbullet UOM / translation" \
#     .gitignore \
#     .tx/config \
#     build-vm.sh \
#     build-284.sh \
#     commit.sh \
#     data.sh \
#     fetch.sh \

git commit \
    -s -m "[pushbullet] [WIP] Tools to support pushbullet reimplementation" \
    .gitignore \
    .tx/config \
    build.sh \
    commit.sh \
    extract4xlation.pl \
    tx-pull.sh \
    tx-push.sh \

git push \
    --force \
    --set-upstream origin pushbullet-binding-dev
