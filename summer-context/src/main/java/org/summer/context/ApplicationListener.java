package org.summer.context;

import java.util.EventListener;
import java.util.function.Consumer;

@FunctionalInterface
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * 处理应用程序事件
     * @param event-要响应的事件
     */
    void onApplicationEvent(E event);

    static <T> ApplicationListener<PayloadApplicationEvent<T>> forPayload(Consumer<T> consumer) {
        return event -> consumer.accept(event.getPayload());
    }
}
