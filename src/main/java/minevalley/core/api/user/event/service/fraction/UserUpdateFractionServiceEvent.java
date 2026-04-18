package minevalley.core.api.user.event.service.fraction;

import lombok.Getter;
import minevalley.core.api.fraction.Fraction;
import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.event.ProxyUserEvent;

@Getter
public abstract class UserUpdateFractionServiceEvent extends ProxyUserEvent {

    private final Fraction fractionService;

    public UserUpdateFractionServiceEvent(ProxyUser user, Fraction fractionService) {
        super(user);
        this.fractionService = fractionService;
    }
}