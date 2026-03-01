package minevalley.core.api.user.events.services.fractions;

import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.enums.Fraction;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user enters a fraction service.
 */
@SuppressWarnings("unused")
public class UserEnterFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserEnterFractionServiceEvent(@Nonnull ProxyUser user, @Nonnull Fraction fractionService) {
        super(user, fractionService);
    }
}