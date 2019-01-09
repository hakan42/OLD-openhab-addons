#!/bin/sh -x

rm -f davos-*.json

curl -v \
     -o davos-boxes-one-line.json \
     https://api.opensensemap.org/boxes/5b94a2c97c51910019097f14

jq "." < davos-boxes-one-line.json > davos-boxes-formatted.json
     
curl -v \
     -o davos-sensors-one-line.json \
     https://api.opensensemap.org/boxes/5b94a2c97c51910019097f14/sensors

jq "." < davos-sensors-one-line.json > davos-sensors-formatted.json
     
cp *.json addons/binding/org.openhab.binding.sensebox
