package eu.minevalley.core.api.user.event.service.fraction;

import eu.minevalley.core.api.fraction.Fraction;
import eu.minevalley.core.api.user.ProxyUser;

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