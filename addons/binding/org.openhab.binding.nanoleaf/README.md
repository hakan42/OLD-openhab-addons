# Nanoleaf Binding

_Give some details about what this binding is meant for - a protocol, system, specific device._

_If possible, provide some resources like pictures, a YouTube video, etc. to give an impression of what can be done with this binding. You can place such resources into a `doc` folder next to this README.md._

## Supported Things

_Please describe the different supported things / devices within this section._
_Which different types are supported, which models were tested etc.?_
_Note that it is planned to generate some part of this based on the XML files within ```ESH-INF/thing``` of your binding._

## Discovery

The Pulseaudio bridge is discovered through mDNS in the local network.

_Describe the available auto-discovery features here. Mention for what it works and what needs to be kept in mind when using it._

TODO remove this and provide a proper example.
TODO make mdns work...


```
hakan@wallaby:~/src/openhab/openhab-conf-pitaya-ng-mqtt$ avahi-browse --all | grep -i nano
+    em1 IPv6 Nanoleaf Light Panels 53:bc:ae                _nanoleafapi._tcp    local
+    em1 IPv4 Nanoleaf Light Panels 53:bc:ae                _nanoleafapi._tcp    local
+    em1 IPv6 Nanoleaf Light Panels 53:bc:ae                _nanoleafms._tcp     local
+    em1 IPv4 Nanoleaf Light Panels 53:bc:ae                _nanoleafms._tcp     local
+    em1 IPv6 Nanoleaf Light Panels 53:bc:ae                _hap._tcp            local
+    em1 IPv4 Nanoleaf Light Panels 53:bc:ae                _hap._tcp            local
```


Other binding doing mdns discovery, obtain ideas from them:

https://www.openhab.org/addons/bindings/miio/#discovery

https://www.openhab.org/addons/bindings/neeo/#discover

https://www.openhab.org/addons/bindings/ipp/#discovery

https://www.openhab.org/addons/bindings/bosesoundtouch/#discovery

https://www.openhab.org/addons/bindings/pulseaudio/#discovery


### How to obtain API key - if auto-discovery is not available

Determine IP address of the nanoleaf controller

Press button on controller

then, in 30 seconds, run the following curl statement, with the IP address of your nanoleaf

```
curl -X POST http://192.168.xx.yy:16021/api/v1/new
```

response will be json like

```
{"auth_token":"yaddayaddayadda"}
```

_#_#_ Binding Configuration - not necessary


## Thing Configuration

_Describe what is needed to manually configure a thing, either through the (Paper) UI or via a thing-file. This should be mainly about its mandatory and optional configuration parameters. A short example entry for a thing file can help!_

_Note that it is planned to generate some part of this based on the XML files within ```ESH-INF/thing``` of your binding._

The Nanoleaf controller requires address (or a hostname) and a port (default: 4712) as a configuration value in order for the binding to know where to access it.

TODO describe auth key here...

## Channels

_Here you should provide information about available channel types, what their meaning is and how they can be used._

_Note that it is planned to generate some part of this based on the XML files within ```ESH-INF/thing``` of your binding._

## Full Example

_Provide a full usage example based on textual configuration files (*.things, *.items, *.sitemap)._

## Any custom content here!

_Feel free to add additional sections for whatever you think should also be mentioned about your binding!_
