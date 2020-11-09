package org.summer.context.event;

import org.summer.context.ApplicationContext;
import org.summer.context.ApplicationEvent;

public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * 创建一个新的ApplicationEvent。
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 获取引发事件的ApplicationContext
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
