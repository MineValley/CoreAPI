package minevalley.core.api.regions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import minevalley.core.api.User;

@Getter
@AllArgsConstructor
public class Termination {
    private final long date;
    private final Type type;
    private final String reason;
    private final User user;

    enum Type {
        LANDLORD,
        STATE
    }
}