package minevalley.core.api.users.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.enums.FractionService;
import minevalley.core.api.users.events.OnlineUserEvent;

@Getter
public abstract class UserUpdateFractionServiceEvent extends OnlineUserEvent {

    private final FractionService fractionService;

    public UserUpdateFractionServiceEvent(OnlineUser user, FractionService fractionService) {
        super(user);
        this.fractionService = fractionService;
    }
}