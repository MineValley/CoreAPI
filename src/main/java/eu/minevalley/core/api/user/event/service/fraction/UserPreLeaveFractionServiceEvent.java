package eu.minevalley.core.api.user.event.service.fraction;

import eu.minevalley.core.api.fraction.Fraction;
import eu.minevalley.core.api.user.ProxyUser;
import lombok.Getter;

import javax.annotation.Nonnull;

/**
 * This event is called when a user is requested to leave a fraction service, before the action is processed.
 */
@Getter
@SuppressWarnings("unused")
public class UserPreLeaveFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserPreLeaveFractionServiceEvent(@Nonnull ProxyUser user, Fraction fractionService) {
        super(user, fractionService);
    }
}