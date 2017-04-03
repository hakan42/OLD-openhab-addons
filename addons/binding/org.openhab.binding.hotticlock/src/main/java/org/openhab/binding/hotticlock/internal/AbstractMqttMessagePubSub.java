/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.hotticlock.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link AbstractMqttMessagePubSub} is he base class for in and outbound MQTT message configurations on an openHAB
 * item.
 *
 * @author Hakan Tandogan - Initial contribution
 */
public abstract class AbstractMqttMessagePubSub {
        // implements BindingConfig {

    private Logger logger = LoggerFactory.getLogger(AbstractMqttMessagePubSub.class);

    private String broker;

    private String topic;


    /**
     * Get the name of broker to use for sending/receiving MQTT messages.
     * 
     * @return name as defined in configuration file.
     */
    public String getBroker() {
        return broker;
    }

    /**
     * Set the name of broker to use for sending/receiving MQTT messages.
     * 
     * @param broker
     *            name as defined in configuration file.
     */
    public void setBroker(String broker) {
        this.broker = broker;
    }

    /**
     * Get the MQTT topic to which to publish/subscribe to.
     * 
     * @return MQTT Topic string
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Set the MQTT topic to which to publish/subscribe to. Subscription topics
     * may contain wild cards.
     * 
     * @param topic
     *            MQTT topic string.
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

}
