package minevalley.core.api.users.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.users.User;
import minevalley.core.api.users.enums.FractionService;
import minevalley.core.api.users.events.UserEvent;

@Getter
public abstract class UserUpdateFractionServiceEvent extends UserEvent {

    private final FractionService fractionService;

    public UserUpdateFractionServiceEvent(User user, FractionService fractionService) {
        super(user);
        this.fractionService = fractionService;
    }
}