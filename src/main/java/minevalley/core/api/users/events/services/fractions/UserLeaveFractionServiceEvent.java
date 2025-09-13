package minevalley.core.api.users.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.enums.Fraction;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserLeaveFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserLeaveFractionServiceEvent(@Nonnull ProxyUser user, Fraction fractionService) {
        super(user, fractionService);
    }
}