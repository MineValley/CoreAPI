package minevalley.core.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.inventory.ItemStack;

@Getter
public class Property {

    private final String code, name;
    private final ItemStack propertyIcon;
    private final Type type;

    public Property(int id, String name, Type type, ItemStack propertyIcon) {
        this.code = type.getKey() + ":" + id;
        this.name = name;
        this.propertyIcon = propertyIcon;
        this.type = type;
    }

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Type {
        VEHICLE("V"),
        WEAPON("W"),
        SPECIAL_ITEM("S");

        private final String key;
    }
}