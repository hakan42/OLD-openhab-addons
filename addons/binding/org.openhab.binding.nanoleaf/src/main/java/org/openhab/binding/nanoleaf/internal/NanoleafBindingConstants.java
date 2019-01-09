/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nanoleaf.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link NanoleafBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Hakan Tandogan - Initial contribution
 */
@NonNullByDefault
public class NanoleafBindingConstants {

    private static final String BINDING_ID = "nanoleaf";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_CONTROLLER = new ThingTypeUID(BINDING_ID, "controller");

    // List of all Channel ids
    public static final String CHANNEL_PANEL_1 = "panel_1";
    public static final String CHANNEL_PANEL_2 = "panel_2";
    public static final String CHANNEL_PANEL_3 = "panel_3";
    public static final String CHANNEL_PANEL_4 = "panel_4";
    public static final String CHANNEL_PANEL_5 = "panel_5";
    public static final String CHANNEL_PANEL_6 = "panel_6";
    public static final String CHANNEL_PANEL_7 = "panel_7";
    public static final String CHANNEL_PANEL_8 = "panel_8";
    public static final String CHANNEL_PANEL_9 = "panel_9";

    // List of all Property names
    public static final String PROPERTY_API_URL = "apiURL";
}
