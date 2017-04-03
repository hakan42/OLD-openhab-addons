/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.hotticlock.internal;

import org.openhab.core.events.EventPublisher;
import org.openhab.io.transport.mqtt.MqttMessageConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The {@link MqttMessagePublisher} is responsible items which receive inbound MQTT messages.
 *
 * @author Hakan Tandogan - Initial contribution
 */
public class MqttMessageSubscriber extends AbstractMqttMessagePubSub implements MqttMessageConsumer {

    private Logger logger = LoggerFactory.getLogger(MqttMessageSubscriber.class);

    private EventPublisher eventPublisher;

    // @Override
    public void processMessage(String topic, byte[] message) {
        logger.debug("Received message '{}'", message);
    }

    // @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
}
