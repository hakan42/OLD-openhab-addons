#!/bin/sh -x

TOKEN=$(grep token ${HOME}/.transifexrc | sed -e 's|token\s=\s||')

HERE=$(realpath $(dirname $0))

docker run \
       --rm \
       --name ci-transifex \
       -e TX_TOKEN=${TOKEN} \
       -v ${HERE}:/project \
       ci-transifex \
       tx -d push --source --root /project
