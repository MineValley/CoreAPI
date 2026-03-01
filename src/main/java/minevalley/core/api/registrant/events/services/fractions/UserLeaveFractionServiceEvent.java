package minevalley.core.api.registrant.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.registrant.ProxyUser;
import minevalley.core.api.registrant.enums.Fraction;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserLeaveFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserLeaveFractionServiceEvent(@Nonnull ProxyUser user, Fraction fractionService) {
        super(user, fractionService);
    }
}