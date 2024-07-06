package minevalley.core.api.trashcans.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TrashCanInteraction {

    ADD_ITEM,
    CLEAR,
    CLICK,
    REMOVE_ITEM,

}
