package org.summer.context;

import org.summer.util.Assert;

public class PayloadApplicationEvent<T> extends ApplicationEvent {

    private final T payload;

    /**
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public PayloadApplicationEvent(Object source, T payload) {
        super(source);
        Assert.notNull(payload, "Payload must not be null");
        this.payload = payload;
    }

    /**
     * Return the payload of the event.
     */
    public T getPayload() {
        return this.payload;
    }
}
