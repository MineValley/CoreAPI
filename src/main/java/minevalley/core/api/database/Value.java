package minevalley.core.api.database;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class Value {

    private final String column;

    private final Object value;
}