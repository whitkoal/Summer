package org.summer.context.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.summer.context.ApplicationContext;
import org.summer.context.ApplicationEvent;
import org.summer.context.ApplicationListener;
import org.summer.context.ConfigurableApplicationContext;
import org.summer.context.event.ContextClosedEvent;
import org.summer.core.ResolvableType;
import org.summer.core.io.DefaultResourceLoader;
import org.summer.lang.Nullable;
import org.summer.util.Assert;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractApplicationContext extends DefaultResourceLoader
        implements ConfigurableApplicationContext {

    protected final Log logger = LogFactory.getLog(getClass());
    /**
     * 指示此上下文当前是否处于活动状态的标志。
     */
    private final AtomicBoolean active = new AtomicBoolean();

    /**
     * 指示此上下文是否已经关闭的标志。
     */
    private final AtomicBoolean closed = new AtomicBoolean();

    /**
     * 用于“refresh” 和 “destroy” 的同步监视器
     */
    private final Object startupShutdownMonitor = new Object();

    /** 在刷新之前注册了本地侦听器。 */
    @Nullable
    private Set<ApplicationListener<?>> earlyApplicationListeners;

    /** ApplicationEvents在多播机设置之前发布。 */
    @Nullable
    private Set<ApplicationEvent> earlyApplicationEvents;

    /**
     * JVM shutdown hook 的引用
     * 可以为空
     */
    @Nullable
    private Thread shutdownHook;

    @Override
    public void close() throws IOException {
        synchronized (this.startupShutdownMonitor) {
            doClose();
            // 如果我们注册了一个JVM shutdown hook， 我们现在不再需要它了
            // 我们已将显示的关闭了上下文
            if (this.shutdownHook != null) {
                try {
                    Runtime.getRuntime().removeShutdownHook(this.shutdownHook);
                } catch (IllegalStateException ex) {
                    // ignore - VM is already shutting down
                }
            }
        }

    }

    /**
     * 实际执行上下文关闭:发布一个ContextClosedEvent 并销毁该应用程序上下文的bean工厂中的单例bean。
     * 由close()和JVM关闭钩子(如果有的话)调用。
     */
    protected void doClose() {
        if (this.active.get() && this.closed.compareAndSet(false, true)) {
            if (logger.isDebugEnabled()) {
                logger.debug("Closing" + this);
            }

            try {
                // 发布关闭事件
                publishEvent(new ContextClosedEvent(this));
            } catch (Throwable ex){
                logger.warn("Exception thrown from ApplicationListener handling ContextClosedEvent", ex);
            }
        }
    }

    @Override
    public void publishEvent(Object event) {
        publishEvent(event, null);
    }

    public void publishEvent(Object event, @Nullable ResolvableType eventType) {
        Assert.notNull(event, "Event must not be null");

        // 将event装饰为ApplicationEvent
        ApplicationEvent applicationEvent;
        if (event instanceof ApplicationEvent) {
            applicationEvent = (ApplicationEvent) event;
        } else {

        }
    }

    //------------------------------------------------------------------
    // Implementation of Life
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}

