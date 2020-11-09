package org.summer.context;

/**
 * 封装事件发布功能的接口。
 * 作为ApplicationContext的更高级接口。
 */
@FunctionalInterface
public interface ApplicationEventPublisher {

    default void publishEvent(ApplicationEvent event) {
        publishEvent((Object) event);
    }

    void publishEvent(Object event);
}
