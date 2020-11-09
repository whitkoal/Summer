package org.summer.core.env;

import org.summer.lang.Nullable;

public interface PropertyResolver {
    boolean containsProperty(String key);

    @Nullable
    String getProperty(String key);
}
