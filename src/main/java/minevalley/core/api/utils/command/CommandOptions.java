package minevalley.core.api.utils.command;

import lombok.NonNull;
import minevalley.core.api.enums.FractionService;
import minevalley.core.api.enums.TeamRank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface CommandOptions {

    /**
     * This list is used to make all the strings usable command-variations. It should contain each alias and the original spelling of the command
     */
    @NonNull
    String[] commands();

    /**
     * <p>
     *     This string defines the correct syntax.
     * </p>
     * Begin with the mostly used alias of the command itself without "/"
     * Then add all possible arguments with "&lt; &gt;"
     * arguments that are not required are marked with "[&lt; &gt;]"
     * <br>
     * Different argument suggestions are separated by vertical bars (example: <i>see below</i>).
     * <br>
     * Literal argument suggestions are written in quotation marks (e. g. /restart &lt;seconds | 'now'&gt;)
     */
    @NonNull
    String syntax() default "<command>";

    /**
     * This message defined here will be sent, when the onCommand-method returns SUCCESS.
     * <br>
     * Don't use this method, if the player shouldn't get printed any message on success.
     */
    String successMessage() default "";

    /**
     * If this is true, the parameters player-rank, fractions and team-ranks are ignored. Every user is able to execute the command.
     * <p>
     * <b>Note: </b> This doesn't affect the requireSupportService()-parameter.
     */
    boolean ignoreRanks() default false;

    /**
     * Every player who is in service of one of the fractions listed here is able to execute this command
     * If everybody is allowed to use this command, add all existing values of this enum.
     * If nobody is allowed to use this command, return an empty list (or don't use this setting).
     */
    FractionService[] fractions() default {};

    /**
     * Every player who has one of the team-ranks listed here is able to execute this command
     * Note: The ranks are not staggered. The SERVER_LEAD does not have the authorization just because ADMINISTRATION has them
     * If nobody is allowed to use this command, return an empty list (or don't use this setting).
     */
    TeamRank[] teamRanks() default {};

    /**
     * If this is enabled, users aren't allowed to use this command, if they aren't in team service.
     * This is used for commands, that are only accessible for team members. Use this instead of adding every possible team rank into the teamRanks-option!
     */
    boolean requireTeamService() default false;

    /**
     * If this is enabled, users (in this case only team members) aren't allowed to use this command, if they aren't in support service.
     */
    boolean requireSupportService() default false;

    /**
     * If this is enabled, users that are allowed to use this command are also allowed to tab it.
     * Disable this if you want to make custom permission-checks beyond the command-options!
     */
    boolean allowTabbing() default true;

    /**
     * If abuseWarning() is true, the team will be notified if a player tries to execute this command without permission
     * The return of ABUSE_WARNING in the onCommand method is not related to this setting and can also be carried out if nothing (or false) is specified here
     */
    boolean abuseWarning() default false;

    /**
     * If a value is specified here, the user must execute the command with the specified number of arguments.
     * Otherwise, the command will not be invoked and the user will receive a syntax error.
     */
    int correctSyntaxLength() default -1;

    /**
     * If executableIfFrozen is true, this command can be executed even though the user is currently frozen by a team member.
     */
    boolean executableIfFrozen() default false;
}