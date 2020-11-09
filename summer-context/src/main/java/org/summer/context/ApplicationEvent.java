package org.summer.context;

import java.util.EventObject;

public abstract class ApplicationEvent extends EventObject {
    /**
     * 创建一个新的ApplicationEvent。
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
