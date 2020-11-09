package org.summer.core.io.support;

import org.summer.core.io.ResourceLoader;

public interface ResourcePatternResolver extends ResourceLoader {
    String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
}
