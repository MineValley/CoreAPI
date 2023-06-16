package minevalley.core.api.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public final class Value {

    private final String column;
    private final Object value;
}