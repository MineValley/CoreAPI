package minevalley.core.api.regions;

import lombok.Setter;
import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.RealEstateGroup;

import java.util.List;

@SuppressWarnings("unused")
public class ResidenceManager {

    @Setter
    private static Manager manager;

    public static Residence getResidence(int id) {
        return manager.getResidence(id);
    }

    public static List<Residence> getResidences() {
        return manager.getResidences();
    }

    public static List<Residence> getResidences(Registrant registrant) {
        return manager.getResidences(registrant);
    }

    public static ApartmentBlock getApartmentBlock(int id) {
        return manager.getApartmentBlock(id);
    }

    public static List<ApartmentBlock> getApartmentBlocks() {
        return manager.getApartmentBlocks();
    }

    public static List<ApartmentBlock> getApartmentBlocks(RealEstateGroup realEstateGroup) {
        return manager.getApartmentBlocks(realEstateGroup);
    }

    public interface Manager {

        Residence getResidence(int id);

        List<Residence> getResidences();

        List<Residence> getResidences(Registrant registrant);

        ApartmentBlock getApartmentBlock(int id);

        List<ApartmentBlock> getApartmentBlocks();

        List<ApartmentBlock> getApartmentBlocks(RealEstateGroup realEstateGroup);
    }
}