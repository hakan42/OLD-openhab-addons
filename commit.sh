#!/bin/sh -ex

# HASH=932f48645901d68fae3737eb6aba417b33677420
# HASH=90ecdec735076e4b860cb111e24a7a05af880baf
HASH=7e08b2b17e922c99d36085d7c3c09df135da302b

#
# commit our binding
#
# git checkout withings-binding

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
    bundles/org.openhab.binding.withings \
    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings*.properties \

#    features/karaf/openhab-addons/src/main/feature/feature.xml \
    
git reset HEAD bundles/org.openhab.binding.withings/.build.*
git reset HEAD bundles/org.openhab.binding.withings/.idea
git reset HEAD bundles/org.openhab.binding.withings/*.x

git reset HEAD bundles/org.openhab.binding.withings/foo.src

# cp bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties \
#    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties.template

# : > bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties

# head -n 4 bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties.template \
#      >> bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties

# tail -n 11 bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties.template \
#      >> bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties

# git add bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties

git reset HEAD bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.*.properties

git reset HEAD bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_de.properties
git reset HEAD bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_tr.properties

cat \
    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.head.properties \
    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.tail.properties \
    > bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties \

git add bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.properties

git commit \
    -m "[withings] reimplementation for openHAB2" \
    CODEOWNERS \
    bom/openhab-addons/pom.xml \
    bundles/pom.xml \
    bundles/org.openhab.binding.withings \
    # features/karaf/openhab-addons/src/main/feature \
    # bundles/org.openhab.binding.withings/README.md \
    # bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/thing \
    # bundles/org.openhab.binding.withings/META-INF \
    # bundles/org.openhab.binding.withings/src \

# git commit \
#     -m "[withings] tests for reimplementation for openHAB2" \
#     bundles/org.openhab.binding.withings.test \

cat \
    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.head.properties \
    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.extracted.properties \
    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.tail.properties \
    > bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.template.properties \

#
#
#

git add bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_de.properties

git commit \
    -s -m "[withings] [i18n] Translate withings binding to german" \
    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_de.properties \

git add bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_tr.properties

git commit \
    -s -m "[withings] [i18n] Translate withings binding to turkish" \
    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_tr.properties \

git add bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.*.properties

git commit \
    -s -m "[withings] [i18n] Withings translation template" \
    bundles/org.openhab.binding.withings/src/main/resources/ESH-INF/i18n/withings_en.*.properties

# git commit \
#     -m "[withings] [WIP] Tools to support withings UOM / translation" \
#     .gitignore \
#     .tx/config \
#     build-vm.sh \
#     build-284.sh \
#     commit.sh \
#     data.sh \
#     fetch.sh \

git add bundles/org.openhab.binding.withings/foo.src

git commit \
    -m "[withings] [WIP] Old stuff to be kept safe" \
    bundles/org.openhab.binding.withings/foo.src

git commit \
    -m "[withings] [WIP] Tools to support withings reimplementation" \
    .gitignore \
    .tx/config \
    build.sh \
    commit.sh \
    extract4xlation.pl \
    tx-pull.sh \
    tx-push.sh \

git push \
    --force \
    --set-upstream origin withings-binding-dev
