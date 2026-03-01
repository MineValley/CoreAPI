package minevalley.core.api.user.event.services.fractions;

import lombok.Getter;
import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.enums.Fraction;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserLeaveFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserLeaveFractionServiceEvent(@Nonnull ProxyUser user, Fraction fractionService) {
        super(user, fractionService);
    }
}