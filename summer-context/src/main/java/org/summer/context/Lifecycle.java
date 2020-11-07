package org.summer.context;

/**
 * 定义启动/停止生命周期控制方法的公共接口。
 */
public interface Lifecycle {
    void start();
    void stop();
    boolean isRunning();
}
