package minevalley.core.api.registrant.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.registrant.ProxyUser;
import minevalley.core.api.registrant.enums.Fraction;

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