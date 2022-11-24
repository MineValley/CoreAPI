package minevalley.core.api.regions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import minevalley.core.api.User;

@Getter
@AllArgsConstructor
public class Warning {

    private final long date, expiration;
    private final String text;
    private final User teamler;
}