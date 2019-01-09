/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nanoleaf.internal.handler;

import static org.openhab.binding.nanoleaf.internal.NanoleafBindingConstants.*;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.openhab.binding.nanoleaf.internal.NanoleafConfiguration;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.RefreshType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link NanoleafHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Hakan Tandogan - Initial contribution
 */
@NonNullByDefault
public class NanoleafHandler extends BaseThingHandler {

    private final Logger logger = LoggerFactory.getLogger(NanoleafHandler.class);

    @Nullable
    private NanoleafConfiguration config;

    public NanoleafHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (CHANNEL_PANEL_1.equals(channelUID.getId())) {
            if (command instanceof RefreshType) {
                // TODO: handle data refresh
            }
            
            // TODO: handle command

            // Note: if communication with thing fails for some reason,
            // indicate that by setting the status with detail information:
            // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
            // "Could not control device at IP address x.x.x.x");
        }
    }

    @Override
    public void initialize() {
        // logger.debug("Start initializing!");
        config = getConfigAs(NanoleafConfiguration.class);

        // TODO: Initialize the handler.
        // The framework requires you to return from this method quickly. Also, before leaving this method a thing 
        // status from one of ONLINE, OFFLINE or UNKNOWN must be set. This might already be the real thing status in 
        // case you can decide it directly.
        // In case you can not decide the thing status directly (e.g. for long running connection handshake using WAN
        // access or similar) you should set status UNKNOWN here and then decide the real status asynchronously in the
        // background.

        // set the thing status to UNKNOWN temporarily and let the background task decide for the real status.
        // the framework is then able to reuse the resources from the thing handler initialization.
        // we set this upfront to reliably check status updates in unit tests.
        updateStatus(ThingStatus.UNKNOWN);

        publishProperties(config);

        // Example for background initialization:
        scheduler.execute(() -> {
            boolean thingReachable = true; // <background task with long running initialization here>
            // when done do:
            if (thingReachable) {
                updateStatus(ThingStatus.ONLINE);
            } else {
                updateStatus(ThingStatus.OFFLINE);
            }
        });

        // logger.debug("Finished initializing!");

        // Note: When initialization can NOT be done set the status with more details for further
        // analysis. See also class ThingStatusDetail for all available status details.
        // Add a description to give user information to understand why thing does not work as expected. E.g.
        // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
        // "Can not access device as username and/or password are invalid");

//        String senseBoxId = thingConfiguration.getSenseBoxId();
//        logger.debug("Thing Configuration {} initialized {}", getThing().getUID().toString(), senseBoxId);
//
//        String offlineReason = "";
//        boolean validConfig = true;
//
//        if (StringUtils.trimToNull(senseBoxId) == null) {
//            offlineReason = "senseBox ID is mandatory and must be configured";
//            validConfig = false;
//        }
//
//        if (thingConfiguration.getRefreshInterval() < MINIMUM_UPDATE_INTERVAL) {
//            logger.info("Refresh interval is much too small, setting to default of {} seconds",
//                    MINIMUM_UPDATE_INTERVAL);
//            thingConfiguration.setRefreshInterval(MINIMUM_UPDATE_INTERVAL);
//        }
//
//        if (validConfig) {
//            updateStatus(ThingStatus.UNKNOWN);
//            startAutomaticRefresh();
//        } else {
//            updateStatus(ThingStatus.UNKNOWN, ThingStatusDetail.CONFIGURATION_ERROR, offlineReason);
//        }
//
//        cache.put(CACHE_KEY_DATA, () -> {
//            return connection.reallyFetchDataFromServer(senseBoxId);
//        });
//
        logger.debug("Thing {} initialized {}", getThing().getUID(), getThing().getStatus());
    }

//    // @Override
//    public void handleCommand(ChannelUID channelUID, Command command) {
//        // if (command instanceof RefreshType) {
//        //     updateChannel(channelUID.getId(), aqiResponse);
//        // } else {
//        // }
//
//        if (channelUID.getId().equals(CHANNEL_RAW_INPUT_FOR_IFTTT)) {
//            if (command instanceof StringType) {
//
//                // Asked to handle 'Weight: 259.67 lb / 117.78 kg | Lean mass: 156.65 lb / 71.06 kg | Fat mass: 103.02 lb / 46.73 kg | Body fat: 39.67 % | April 25, 2017 at 08:42AM' on 'nanoleaf:scale:mine:raw-input-for-ifttt'
//                // thing is 'org.eclipse.smarthome.core.thing.internal.ThingImpl@7142b1bd' - 'ONLINE'
//                logger.debug("Asked to handle '{}' on '{}'", command, channelUID);
//                logger.debug("  thing is '{}' - '{}'", getThing(), getThing().getStatusInfo());
//
//                logger.debug("Raw Data");
//                logger.debug("{}", command.getClass());
//                logger.debug("{}", command);
//                logger.debug("===============================================================");
//
//                String[] data = command.toString().split("\\|");
//                if (data != null) {
//                    for (int i = 0; i < data.length; i++) {
//                        String s = data[i].trim();
//                        logger.debug("Split data # {}: '{}'", i, s);
//
//                        if (s.startsWith("Weight:")) {
//                            String[] s1 = s.split(":");
//                            logger.debug("Found '{}' : '{}'", s1[0], s1[1].trim());
//                            updateState(CHANNEL_WEIGHT, decimalFromString(s1[1].replace("kg", "").trim()));
//                        } else if (s.startsWith("Lean mass:")) {
//                            String[] s1 = s.split(":");
//                            logger.debug("Found '{}' : '{}'", s1[0], s1[1].trim());
//                            updateState(CHANNEL_LEAN_MASS, decimalFromString(s1[1].replace("kg", "").trim()));
//                        } else if (s.startsWith("Fat mass:")) {
//                            String[] s1 = s.split(":");
//                            logger.debug("Found '{}' : '{}'", s1[0], s1[1].trim());
//                            updateState(CHANNEL_FAT_MASS, decimalFromString(s1[1].replace("kg", "").trim()));
//                        } else if (s.startsWith("Body fat:")) {
//                            String[] s1 = s.split(":");
//                            logger.debug("Found '{}' : '{}'", s1[0], s1[1].trim());
//                            updateState(CHANNEL_BODY_FAT, decimalFromString(s1[1].replace("%", "").trim()));
//                        } else {
//                            // Timestamp???
//                            logger.debug("Found possible Timestamp '{}'", s);
//                            try {
//                                SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMM yyyy 'at' HH:mma");
//                                Date date = sdf.parse(s);
//                                logger.debug("Parsed date: {}", date);
//                            } catch (ParseException pe) {
//                                logger.error("While parsing date", pe);
//                            }
//                        }
//                    }
//                }
//            } else {
//                logger.debug("{}", command.getClass());
//                logger.debug("{}", command);
//            }
//        }
//        else {
//            logger.debug("Asked to handle '{}' on '{}'", command, channelUID);
//            logger.debug("  thing is '{}' - '{}'", getThing(), getThing().getStatusInfo());
//        }
//    }

    private void publishProperties(NanoleafConfiguration config) {
        // TODO maybe overkill, but we could maybe use an URIBuilder here...
        String apiURL = "http://" + config.host + ":" + config.port + "/api/v1";
        thing.setProperty(PROPERTY_API_URL, apiURL);
    }


}
