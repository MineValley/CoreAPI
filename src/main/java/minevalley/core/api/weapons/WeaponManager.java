package minevalley.core.api.weapons;

import lombok.Setter;
import minevalley.core.api.Registrant;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public class WeaponManager {

    @Setter
    private static Manager manager;

    /**
     * Get all registered weapons.
     *
     * @return List of all registered weapons.
     */
    @Nonnull
    @Contract(pure = true)
    public static List<Weapon> getWeapons() {
        return manager.getWeapons();
    }

    /**
     * Get all registered weapons for a specific registrant.
     *
     * @param registrant The registrant to get weapons for.
     * @return List of registered weapons for the specified registrant.
     * @throws IllegalArgumentException If the registrant is null
     */
    @Nonnull
    @Contract(pure = true)
    public static List<Weapon> getWeapons(@Nonnull Registrant registrant) throws IllegalArgumentException {
        return manager.getWeapons(registrant);
    }

    public interface Manager {

        @Nonnull
        @Contract(pure = true)
        List<Weapon> getWeapons();

        @Nonnull
        @Contract(pure = true)
        List<Weapon> getWeapons(@Nonnull Registrant registrant) throws IllegalArgumentException;

    }
}
