package minevalley.core.api.user.event.services.fractions;

import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.enums.Fraction;

import javax.annotation.Nonnull;

/**
 * This event is called when a user is requested to enter a fraction service, before the action is processed.
 */
@SuppressWarnings("unused")
public class UserPreEnterFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserPreEnterFractionServiceEvent(@Nonnull ProxyUser user, @Nonnull Fraction fractionService) {
        super(user, fractionService);
    }
}