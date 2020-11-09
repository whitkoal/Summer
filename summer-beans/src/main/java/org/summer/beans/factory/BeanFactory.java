package org.summer.beans.factory;

import org.summer.core.ResolvableType;
import org.summer.exception.BeansException;
import org.summer.exception.NoSuchBeanDefinitionException;

/**
 * 所有 bean容器的根接口
 */
public interface BeanFactory {

    /**
     * 用于指示getting方法返回工厂
     */
    String FACTORY_BEAN_PREFIX = "&";

    /**
     * 返回指定bean的实例，该实例可以是共享的，也可以是独立的。
     *
     * @param name bean的名字
     * @return 一个bean实例
     * @throws BeansException 如果没找到指定的bean就会抛出异常
     */
    Object getBean(String name) throws BeansException;

    boolean containsBean(String name);

    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

    boolean isPrototype(String name) throws NoSuchBeanDefinitionException;

    boolean isTypeMatch(String name, ResolvableType resolvableType) throws NoSuchBeanDefinitionException;

    Class<?> getType(String name) throws NoSuchBeanDefinitionException;

    String[] getAliases(String name);

}
