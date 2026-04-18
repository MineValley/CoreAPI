package minevalley.core.api.user.event.service.fraction;

import lombok.Getter;
import minevalley.core.api.fraction.Fraction;
import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserLeaveFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserLeaveFractionServiceEvent(@Nonnull ProxyUser user, Fraction fractionService) {
        super(user, fractionService);
    }
}