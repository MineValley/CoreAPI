package minevalley.core.api.users.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum McVersion {

    @Deprecated(forRemoval = true)
    V1_12(335),
    @Deprecated(forRemoval = true)
    V1_14(477),
    @Deprecated(forRemoval = true)
    V1_16(735),
    @Deprecated(forRemoval = true)
    V1_18(757),

    /**
     * 1.20.0 and 1.20.1 share the same protocol version and are therefore indistinguishable for the server.
     */
    V1_20_1(763),

    V1_20_2(764),

    /**
     * 1.20.3 and 1.20.4 share the same protocol version and are therefore indistinguishable for the server.
     */
    V1_20_4(765),

    V1_20_5(766);

    private final int protocolVersion;
}