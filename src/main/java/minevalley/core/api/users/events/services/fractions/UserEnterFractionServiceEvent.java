package minevalley.core.api.users.events.services.fractions;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.enums.Fraction;

@Getter
public class UserEnterFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserEnterFractionServiceEvent(OnlineUser user, Fraction fractionService) {
        super(user, fractionService);
    }
}