package minevalley.core.api;

import minevalley.core.api.enums.Server;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Module {

    String name();

    String version();

    String[] authors();

    Server[] servers() default {};
}
