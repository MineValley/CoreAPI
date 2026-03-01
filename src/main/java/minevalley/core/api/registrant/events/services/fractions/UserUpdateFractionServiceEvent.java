package minevalley.core.api.registrant.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.registrant.ProxyUser;
import minevalley.core.api.registrant.enums.Fraction;
import minevalley.core.api.registrant.events.ProxyUserEvent;

@Getter
public abstract class UserUpdateFractionServiceEvent extends ProxyUserEvent {

    private final Fraction fractionService;

    public UserUpdateFractionServiceEvent(ProxyUser user, Fraction fractionService) {
        super(user);
        this.fractionService = fractionService;
    }
}