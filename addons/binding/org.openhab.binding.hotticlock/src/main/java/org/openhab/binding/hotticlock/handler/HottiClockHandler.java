/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.hotticlock.handler;

import static org.openhab.binding.hotticlock.HottiClockBindingConstants.*;

import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.hotticlock.internal.HottiClockConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link HottiClockHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 * 
 * @author Hakan Tandogan - Initial contribution
 */
public class HottiClockHandler extends BaseThingHandler {

    private Logger logger = LoggerFactory.getLogger(HottiClockHandler.class);

    public HottiClockHandler(Thing thing) {
        super(thing);
    }

    // @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        // if (command instanceof RefreshType) {
        //     updateChannel(channelUID.getId(), aqiResponse);
        // } else {
        // }

        // Send a "V" message to determine whether we might go online. The response will determine stuff

        logger.debug("Asked to handle '{}' on '{}'", command, channelUID);
        logger.debug("  thing is '{}' - '{}'", getThing(), getThing().getStatusInfo());

        if (channelUID.getId().equals(CHANNEL_RAW_IN)) {
            // Note: if communication with thing fails for some reason,
            // indicate that by setting the status with detail information
            // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
            // "Could not control device at IP address x.x.x.x");
        }

        if (channelUID.getId().equals(CHANNEL_RAW_OUT)) {
            // Note: if communication with thing fails for some reason,
            // indicate that by setting the status with detail information
            // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
            // "Could not control device at IP address x.x.x.x");
        }

        if (channelUID.getId().equals(CHANNEL_VERSION)) {
            // Note: if communication with thing fails for some reason,
            // indicate that by setting the status with detail information
            // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
            // "Could not control device at IP address x.x.x.x");
        }
    }

    @Override
    public void initialize() {
        logger.debug("Initializing HottiClock handler.");
        super.initialize();

        HottiClockConfiguration config = getConfigAs(HottiClockConfiguration.class);

        // logger.debug("config apikey = (omitted from logging)");
        // logger.debug("config location = {}", config.location);
        // logger.debug("config stationId = {}", config.stationId);
        // logger.debug("config refresh = {}", config.refresh);

        // boolean validConfig = true;
        // String errorMsg = null;

        // if (StringUtils.trimToNull(config.apikey) == null) {
        // errorMsg = "Parameter 'apikey' is mandatory and must be configured";
        // validConfig = false;
        // }
        // if (StringUtils.trimToNull(config.location) == null && config.stationId == null) {
        // errorMsg = "Parameter 'location' or 'stationId' is mandatory and must be configured";
        // validConfig = false;
        // }
        // if (config.refresh != null && config.refresh < 5) {
        // errorMsg = "Parameter 'refresh' must be at least 5 minutes";
        // validConfig = false;
        // }

        // if (validConfig) {
        // startAutomaticRefresh();
        // } else {
        // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR, errorMsg);
        // }

        // Long running initialization should be done asynchronously in background.
        updateStatus(ThingStatus.ONLINE);

        // Note: When initialization can NOT be done set the status with more details for further
        // analysis. See also class ThingStatusDetail for all available status details.
        // Add a description to give user information to understand why thing does not work
        // as expected. E.g.
        // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
        // "Can not access device as username and/or password are invalid");
    }
}
