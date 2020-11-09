package org.summer.util;

import org.summer.lang.NonNull;

/**
 * 帮助验证参数。 有助于在运行时早期和清晰地识别程序员的错误。
 */
public abstract class Assert {
    public static void notNull(@NonNull Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
