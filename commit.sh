#!/bin/sh -ex

HASH=533e5f01be4d5395d9dc99b5e0fb3f22410c49f3

#
# commit our binding
#
# git checkout nanoleaf-binding

git reset ${HASH}

git add \
    .gitignore \
    .tx/config \
    build.sh \
    commit.sh \
    data*.sh \
    tx-pull.sh \
    tx-push.sh \
    features/openhab-addons/src/main/feature \
    addons/pom.xml \
    addons/binding/org.openhab.binding.nanoleaf \
    addons/binding/org.openhab.binding.nanoleaf/ESH-INF/i18n/nanoleaf*.properties \

git commit \
    -s -m "[nanoleaf] initial implementation" \
    features/openhab-addons/src/main/feature \
    addons/binding/pom.xml \
    addons/binding/org.openhab.binding.nanoleaf \
    # addons/binding/org.openhab.binding.nanoleaf/README.md \
    # addons/binding/org.openhab.binding.nanoleaf/ESH-INF/thing \
    # addons/binding/org.openhab.binding.nanoleaf/META-INF \
    # addons/binding/org.openhab.binding.nanoleaf/src \

# git commit \
#     -s -m "[nanoleaf] [i18n] Make the nanoleaf binding translateable" \
#     addons/binding/org.openhab.binding.nanoleaf/ESH-INF/i18n/nanoleaf.properties \

# git commit \
#     -s -m "[nanoleaf] [i18n] Translate nanoleaf binding to german" \
#     addons/binding/org.openhab.binding.nanoleaf/ESH-INF/i18n/nanoleaf_de.properties \

# git commit \
#     -s -m "[nanoleaf] [i18n] Translate nanoleaf binding to turkish" \
#     addons/binding/org.openhab.binding.nanoleaf/ESH-INF/i18n/nanoleaf_tr.properties \

# git commit \
#     -s -m "[nanoleaf] [WIP] Tools to support nanoleaf UOM / translation" \
#     .gitignore \
#     .tx/config \
#     build-vm.sh \
#     build-284.sh \
#     commit.sh \
#     data.sh \
#     fetch.sh \

git commit \
    -s -m "[nanoleaf] [WIP] Tools to support nanoleaf reimplementation" \
    .gitignore \
    .tx/config \
    build.sh \
    commit.sh \
    data*.sh \
    tx-pull.sh \
    tx-push.sh \

git push \
    --force \
    --set-upstream origin nanoleaf-binding
