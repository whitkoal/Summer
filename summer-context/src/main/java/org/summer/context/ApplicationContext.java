package org.summer.context;

import org.summer.beans.factory.HierarchicalBeanFactory;
import org.summer.beans.factory.ListableBeanFactory;
import org.summer.core.env.EnvironmentCapable;
import org.summer.core.io.support.ResourcePatternResolver;

public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
        MessageSource, ApplicationEventPublisher, ResourcePatternResolver {
}
