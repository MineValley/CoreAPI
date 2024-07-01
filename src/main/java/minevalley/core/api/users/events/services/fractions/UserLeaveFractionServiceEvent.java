package minevalley.core.api.users.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.users.User;
import minevalley.core.api.users.enums.FractionService;

@Getter
public class UserLeaveFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserLeaveFractionServiceEvent(User user, FractionService fractionService) {
        super(user, fractionService);
    }
}