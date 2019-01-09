#!/bin/sh -x

TOKEN=$(grep token ${HOME}/.transifexrc | sed -e 's|token\s=\s||')

HERE=$(realpath $(dirname $0))

LANGUAGES=
LANGUAGES=--all
# LANGUAGES=--language=tr

docker run \
       --rm \
       --name ci-transifex \
       -e TX_TOKEN=${TOKEN} \
       -v ${HERE}:/project \
       ci-transifex \
       tx -d pull ${LANGUAGES} --force --minimum-perc=0 --root /project

git diff
