package minevalley.core.api.users.events.services.fractions;

import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.enums.Fraction;

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