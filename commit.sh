#!/bin/sh -ex

HASH=4fafd788f2a9fcbb0e06407001c809b73a778a69

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
    tx-pull.sh \
    tx-push.sh \
    features/openhab-addons/src/main/feature \
    addons/pom.xml \
    addons/binding/org.openhab.binding.withings \
    addons/binding/org.openhab.binding.withings/ESH-INF/i18n/withings*.properties \
    addons/binding/org.openhab.binding.withings.test \
    addons/binding/org.openhab.binding.withings-old \

git reset HEAD addons/binding/org.openhab.binding.withings/.build.*
git reset HEAD addons/binding/org.openhab.binding.withings/.idea

git reset HEAD addons/binding/org.openhab.binding.withings.test/.build.*
git reset HEAD addons/binding/org.openhab.binding.withings.test/.idea

git reset HEAD addons/binding/org.openhab.binding.withings-old/.build.*
git reset HEAD addons/binding/org.openhab.binding.withings-old/.idea

git commit \
    -s -m "[withings] reimplementation for openHAB2" \
    features/openhab-addons/src/main/feature \
    addons/binding/pom.xml \
    addons/binding/org.openhab.binding.withings \
    # addons/binding/org.openhab.binding.withings/README.md \
    # addons/binding/org.openhab.binding.withings/ESH-INF/thing \
    # addons/binding/org.openhab.binding.withings/META-INF \
    # addons/binding/org.openhab.binding.withings/src \

git commit \
    -s -m "[withings] tests for reimplementation for openHAB2" \
    addons/binding/org.openhab.binding.withings.test \

git commit \
    -s -m "[withings] old attempt to keep safe" \
    addons/binding/org.openhab.binding.withings-old \

# git commit \
#     -s -m "[withings] [i18n] Make the withings binding translateable" \
#     addons/binding/org.openhab.binding.withings/ESH-INF/i18n/withings.properties \

# git commit \
#     -s -m "[withings] [i18n] Translate withings binding to german" \
#     addons/binding/org.openhab.binding.withings/ESH-INF/i18n/withings_de.properties \

# git commit \
#     -s -m "[withings] [i18n] Translate withings binding to turkish" \
#     addons/binding/org.openhab.binding.withings/ESH-INF/i18n/withings_tr.properties \

# git commit \
#     -s -m "[withings] [WIP] Tools to support withings UOM / translation" \
#     .gitignore \
#     .tx/config \
#     build-vm.sh \
#     build-284.sh \
#     commit.sh \
#     data.sh \
#     fetch.sh \

git commit \
    -s -m "[withings] [WIP] Tools to support withings reimplementation" \
    .gitignore \
    .tx/config \
    build.sh \
    commit.sh \
    tx-pull.sh \
    tx-push.sh \

git push \
    --force \
    --set-upstream origin withings-binding

