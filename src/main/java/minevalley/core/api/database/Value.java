package minevalley.core.api.database;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class Value {

    private final String column;
    private final Object value;
}