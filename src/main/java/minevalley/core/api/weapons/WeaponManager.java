package minevalley.core.api.weapons;

import lombok.Setter;
import minevalley.core.api.Registrant;

import java.util.List;

@SuppressWarnings("unused")
public class WeaponManager {

    @Setter
    private static Manager manager;

    public static List<Weapon> getWeapons() {
        return manager.getWeapons();
    }

    public static List<Weapon> getWeapons(Registrant registrant) {
        return manager.getWeapons(registrant);
    }

    public interface Manager {

        List<Weapon> getWeapons();

        List<Weapon> getWeapons(Registrant registrant);

    }
}
