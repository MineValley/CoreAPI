package minevalley.core.api.users.events.services.fractions;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.enums.Fraction;

@SuppressWarnings("unused")
public class UserEnterFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserEnterFractionServiceEvent(OnlineUser user, Fraction fractionService) {
        super(user, fractionService);
    }
}