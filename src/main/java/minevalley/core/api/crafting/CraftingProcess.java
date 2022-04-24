package minevalley.core.api.crafting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.User;

@Getter
@RequiredArgsConstructor
public class CraftingProcess {
    final User user;
    final Recipe recipe;
}