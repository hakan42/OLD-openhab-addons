/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.hotticlock.internal;

import static org.openhab.binding.hotticlock.HottiClockBindingConstants.*;

import java.util.Collections;
import java.util.Set;

import org.openhab.binding.hotticlock.handler.HottiClockHandler;
import org.openhab.io.transport.mqtt.MqttService;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link HottiClockHandlerFactory} is responsible for creating things and thing 
 * handlers.
 * 
 * @author Hakan Tandogan - Initial contribution
 */
public class HottiClockHandlerFactory extends BaseThingHandlerFactory {
    
    private Logger logger = LoggerFactory.getLogger(HottiClockHandlerFactory.class);

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections.singleton(THING_TYPE_SAMPLE);
    
    private MqttService mqttService;

    private String brokerName;

    // @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {

        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(THING_TYPE_SAMPLE)) {
            return new HottiClockHandler(thing);
        }

        return null;
    }

    /**
     * Set MQTT Service from DS.
     * 
     * @param mqttService
     *            to set.
     */
    public void setMqttService(MqttService mqttService) {
        logger.info("Setting mqttService to {}", mqttService);
        this.mqttService = mqttService;
    }

    /**
     * Unset MQTT Service from DS.
     * 
     * @param mqttService
     *            to remove.
     */
    public void unsetMqttService(MqttService mqttService) {
        logger.info("Unsetting mqttService, was {}", mqttService);
        this.mqttService = null;
    }
}

