package minevalley.core.api.users.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.users.User;
import minevalley.core.api.users.enums.FractionService;

@Getter
public class UserEnterFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserEnterFractionServiceEvent(User user, FractionService fractionService) {
        super(user, fractionService);
    }
}