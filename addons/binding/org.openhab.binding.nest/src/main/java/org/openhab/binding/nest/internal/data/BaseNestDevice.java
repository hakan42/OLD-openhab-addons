/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nest.internal.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Default properties shared across all Nest devices.
 *
 * @author David Bennett
 */
public class BaseNestDevice {
    @SerializedName("device_id")
    private String deviceId;
    @SerializedName("name")
    private String name;
    @SerializedName("name_long")
    private String nameLong;
    @SerializedName("last_connection")
    private Date lastConnection;
    @SerializedName("is_online")
    private boolean isOnline;
    @SerializedName("software_version")
    private String softwareVersion;
    @SerializedName("structure_id")
    private String structureId;
    @SerializedName("where_id")
    private String whereId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Date getLastConnection() {
        return lastConnection;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getNameLong() {
        return nameLong;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public String getStructureId() {
        return structureId;
    }

    public String getWhereId() {
        return whereId;
    }

}
