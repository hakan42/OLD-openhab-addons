/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nanoleaf.internal.discovery;

import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.openhab.binding.nanoleaf.internal.handler.NanoleafHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Set;

import static org.openhab.binding.nanoleaf.internal.NanoleafBindingConstants.THING_TYPE_CONTROLLER;

/**
 * The {@link NanoleafControllerDiscoveryService} class is used to discover ...
 *
 * @author Hakan Tandogan - Initial contribution
 */
public class NanoleafControllerDiscoveryService extends AbstractDiscoveryService {
        // implements DeviceStatusListener {

    private final Logger logger = LoggerFactory.getLogger(NanoleafControllerDiscoveryService.class);

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections.singleton(THING_TYPE_CONTROLLER);

    private NanoleafHandler nanoleafHandler;

    public NanoleafControllerDiscoveryService(NanoleafHandler nanoleafHandler) {
        super(SUPPORTED_THING_TYPES_UIDS, 10, true);
        this.nanoleafHandler = nanoleafHandler;
    }

    public void activate() {
        logger.info("activate() called");
        // nanoleafHandler.registerDeviceStatusListener(this);
    }

    @Override
    public void deactivate() {
        logger.info("deactivate() called");
        // nanoleafHandler.unregisterDeviceStatusListener(this);
    }

    @Override
    public Set<ThingTypeUID> getSupportedThingTypes() {
        return SUPPORTED_THING_TYPES_UIDS;
    }

//    @Override
//    public void onDeviceAdded(Bridge bridge, AbstractAudioDeviceConfig device) {
//        String uidName = device.getPaName();
//        logger.debug("device {} found", device);
//        ThingTypeUID thingType = null;
//        Map<String, Object> properties = new HashMap<>();
//        // All devices need this parameter
//        properties.put(PulseaudioBindingConstants.DEVICE_PARAMETER_NAME, uidName);
//        if (device instanceof Sink) {
//            if (((Sink) device).isCombinedSink()) {
//                thingType = PulseaudioBindingConstants.COMBINED_SINK_THING_TYPE;
//            } else {
//                thingType = PulseaudioBindingConstants.SINK_THING_TYPE;
//            }
//        } else if (device instanceof SinkInput) {
//            thingType = PulseaudioBindingConstants.SINK_INPUT_THING_TYPE;
//        } else if (device instanceof Source) {
//            thingType = PulseaudioBindingConstants.SOURCE_THING_TYPE;
//        } else if (device instanceof SourceOutput) {
//            thingType = PulseaudioBindingConstants.SOURCE_OUTPUT_THING_TYPE;
//        }
//
//        if (thingType != null) {
//            logger.trace("Adding new pulseaudio {} with name '{}' to smarthome inbox",
//                    device.getClass().getSimpleName(), uidName);
//            ThingUID thingUID = new ThingUID(thingType, bridge.getUID(), device.getUIDName());
//            DiscoveryResult discoveryResult = DiscoveryResultBuilder.create(thingUID).withProperties(properties)
//                    .withBridge(bridge.getUID()).withLabel(device.getUIDName()).build();
//            thingDiscovered(discoveryResult);
//        }
//    }

    @Override
    protected void startScan() {
        // this can be ignored here as we discover via the PulseaudioClient.update() mechanism
        logger.info("startScan() called");
    }

//    @Override
//    public void onDeviceStateChanged(ThingUID bridge, AbstractAudioDeviceConfig device) {
//        // this can be ignored here
//    }

//    @Override
//    public void onDeviceRemoved(NanoleafHandler bridge, AbstractAudioDeviceConfig device) {
//        // this can be ignored here
//    }
}
