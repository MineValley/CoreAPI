package minevalley.core.api.banking;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("unused")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TransferResult {
    SUCCESS,
    NO_PERMISSION,
    NOT_ENOUGH_MONEY,
    MAX_PAYOUT_EXCEEDED;

    public boolean wasSuccessful() {
        return this == SUCCESS;
    }
}