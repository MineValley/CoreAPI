package minevalley.core.api.users.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.enums.Fraction;
import minevalley.core.api.users.events.OnlineUserEvent;

@Getter
public abstract class UserUpdateFractionServiceEvent extends OnlineUserEvent {

    private final Fraction fractionService;

    public UserUpdateFractionServiceEvent(OnlineUser user, Fraction fractionService) {
        super(user);
        this.fractionService = fractionService;
    }
}