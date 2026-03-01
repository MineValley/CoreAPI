package minevalley.core.api.user.event.services.fractions;

import lombok.Getter;
import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.enums.Fraction;

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