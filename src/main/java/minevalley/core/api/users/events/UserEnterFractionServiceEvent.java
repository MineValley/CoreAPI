package minevalley.core.api.users.events;

import lombok.Getter;
import minevalley.core.api.users.User;
import minevalley.core.api.users.enums.FractionService;

@Getter
public class UserEnterFractionServiceEvent extends UserEvent {

    private final FractionService fractionService;

    public UserEnterFractionServiceEvent(User user, FractionService fractionService) {
        super(user);
        this.fractionService = fractionService;
    }
}