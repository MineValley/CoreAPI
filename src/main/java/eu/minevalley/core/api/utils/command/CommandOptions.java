package eu.minevalley.core.api.utils.command;

import eu.minevalley.core.api.enums.Fraction;
import eu.minevalley.core.api.enums.PlayerRank;
import eu.minevalley.core.api.enums.TeamRank;
import lombok.NonNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface CommandOptions {

    @NonNull
    String[] commands();

    String syntax();

    String successMessage() default "";

    Fraction[] fractions() default {};

    PlayerRank[] playerRank() default {};

    TeamRank[] teamRanks() default {};

    boolean abuseWarning() default false;
}