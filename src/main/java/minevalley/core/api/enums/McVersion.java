package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum McVersion {
    V1_12(335),
    V1_14(477),
    V1_16(735),
    V1_18(757);

    /**
     * <b>Note:</b> The client's protocol version may differ from those specified here.
     * There are many sub-versions like 1.12.1 and 1.12.2. To get the currently used version,
     * check if the client's protocol number is between two of those specified here.
     * If the client is use a version lower than 1.12, it will not be able to join the server.
     */
    private final int protocolVersion;
}