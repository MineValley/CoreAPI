package minevalley.core.api.users.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.enums.Fraction;
import minevalley.core.api.users.events.ProxyUserEvent;

@Getter
public abstract class UserUpdateFractionServiceEvent extends ProxyUserEvent {

    private final Fraction fractionService;

    public UserUpdateFractionServiceEvent(ProxyUser user, Fraction fractionService) {
        super(user);
        this.fractionService = fractionService;
    }
}