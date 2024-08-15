package minevalley.core.api.users.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.enums.FractionService;

@Getter
public class UserLeaveFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserLeaveFractionServiceEvent(OnlineUser user, FractionService fractionService) {
        super(user, fractionService);
    }
}