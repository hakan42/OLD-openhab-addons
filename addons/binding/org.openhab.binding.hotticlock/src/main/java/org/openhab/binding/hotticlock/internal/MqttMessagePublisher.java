/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.hotticlock.internal;

import org.openhab.io.transport.mqtt.MqttMessageProducer;
import org.openhab.io.transport.mqtt.MqttSenderChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link MqttMessagePublisher} is responsible items which send outbound MQTT messages.
 *
 * @author Hakan Tandogan - Initial contribution
 */
public class MqttMessagePublisher extends AbstractMqttMessagePubSub implements MqttMessageProducer {

    private Logger logger = LoggerFactory.getLogger(MqttMessagePublisher.class);

    private MqttSenderChannel senderChannel;

    // @Override
    public void setSenderChannel(MqttSenderChannel channel) {
        senderChannel = channel;
    }
}
