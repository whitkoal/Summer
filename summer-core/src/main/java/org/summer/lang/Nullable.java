package org.summer.lang;

import java.lang.annotation.*;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

/**
 * 一个常见的Spring注释，用于声明在某些情况下注释的元素可以为空。
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@NonNull
@TypeQualifierNickname
public @interface Nullable {
}
