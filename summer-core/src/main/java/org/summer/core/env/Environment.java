package org.summer.core.env;

/**
 * 表示当前应用程序在其中运行的环境的接口。
 * 对应用程序环境的两个关键方面进行建模: 概要文件(profiles)和属性(properties)。
 * 与属性访问相关的方法通过PropertyResolver超接口公开。
 * 概要文件是一个命名的bean定义逻辑组，只有在给定的概要文件处于活动状态时才向容器注册。
 */
public interface Environment extends PropertyResolver{

    String[] getActiveProfiles();

    String[] getDefaultProfiles();

    boolean acceptsProfiles(Profiles profiles);
}
