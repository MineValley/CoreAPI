package minevalley.core.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.TYPE)
public @interface Description {

    String name();

    String version();

    String[] authors();

    String[] dependencies() default "";

    int loadingPriority() default 0;
}
