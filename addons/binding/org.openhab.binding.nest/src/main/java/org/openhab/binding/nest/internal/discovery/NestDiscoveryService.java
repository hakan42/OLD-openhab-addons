/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nest.internal.discovery;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.config.discovery.DiscoveryResultBuilder;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.openhab.binding.nest.NestBindingConstants;
import org.openhab.binding.nest.handler.NestBridgeHandler;
import org.openhab.binding.nest.internal.NestDeviceDataListener;
import org.openhab.binding.nest.internal.data.BaseNestDevice;
import org.openhab.binding.nest.internal.data.Camera;
import org.openhab.binding.nest.internal.data.SmokeDetector;
import org.openhab.binding.nest.internal.data.Structure;
import org.openhab.binding.nest.internal.data.Thermostat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

import static org.openhab.binding.nest.NestBindingConstants.PROPERTY_FIRMWARE_VERSION;
import static org.openhab.binding.nest.NestBindingConstants.PROPERTY_ID;
import static org.openhab.binding.nest.NestBindingConstants.THING_TYPE_CAMERA;
import static org.openhab.binding.nest.NestBindingConstants.THING_TYPE_SMOKE_DETECTOR;
import static org.openhab.binding.nest.NestBindingConstants.THING_TYPE_STRUCTURE;

/**
 * This service connects to the nest bridge and creates the correct discovery results for nest devices
 * as they are found through the API.
 *
 * @author David Bennett - initial contribution
 */
public class NestDiscoveryService extends AbstractDiscoveryService implements NestDeviceDataListener {
    private final Logger logger = LoggerFactory.getLogger(NestDiscoveryService.class);

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES = Sets.newHashSet(
            NestBindingConstants.THING_TYPE_THERMOSTAT, NestBindingConstants.THING_TYPE_SMOKE_DETECTOR,
            THING_TYPE_STRUCTURE, NestBindingConstants.THING_TYPE_CAMERA);

    private final NestBridgeHandler bridge;

    public NestDiscoveryService(NestBridgeHandler bridge) {
        super(SUPPORTED_THING_TYPES, 60, true);
        this.bridge = bridge;
    }

    public void activate() {
        bridge.addDeviceDataListener(this);
    }

    @Override
    public void deactivate() {
        bridge.removeDeviceDataListener(this);
    }

    @Override
    protected void startScan() {
        this.bridge.startDiscoveryScan();
    }

    @Override
    public void onNewNestThermostatData(Thermostat thermostat) {
        onNestDeviceAdded(thermostat, NestBindingConstants.THING_TYPE_THERMOSTAT);
        logger.debug("thingDiscovered called for thermostat");
    }

    @Override
    public void onNewNestCameraData(Camera camera) {
        onNestDeviceAdded(camera, THING_TYPE_CAMERA);
        logger.debug("thingDiscovered called for camera");
    }

    @Override
    public void onNewNestSmokeDetectorData(SmokeDetector smoke) {
        onNestDeviceAdded(smoke, THING_TYPE_SMOKE_DETECTOR);
        logger.debug("thingDiscovered called for smoke detector");
    }

    private void onNestDeviceAdded(BaseNestDevice device, ThingTypeUID typeUID) {
        ThingUID bridgeUID = bridge.getThing().getUID();
        ThingUID deviceUID = new ThingUID(typeUID, bridgeUID, device.getDeviceId());
        Map<String, Object> properties = new HashMap<>();
        properties.put(PROPERTY_ID, device.getDeviceId());
        properties.put(PROPERTY_FIRMWARE_VERSION, device.getSoftwareVersion());
        thingDiscovered(DiscoveryResultBuilder.create(deviceUID)
                .withThingType(typeUID)
                .withLabel(device.getNameLong())
                .withBridge(bridgeUID)
                .withProperties(properties)
                .build());
    }

    @Override
    public void onNewNestStructureData(Structure struct) {
        ThingUID bridgeUID = bridge.getThing().getUID();
        ThingUID thingUID = new ThingUID(THING_TYPE_STRUCTURE, bridgeUID, struct.getStructureId());
        Map<String, Object> properties = new HashMap<>();
        properties.put(PROPERTY_ID, struct.getStructureId());
        thingDiscovered(DiscoveryResultBuilder.create(thingUID)
                .withThingType(THING_TYPE_STRUCTURE)
                .withLabel(struct.getName())
                .withBridge(bridgeUID)
                .withProperties(properties)
                .build());
        logger.debug("thingDiscovered called for structure");
    }
}
