package minevalley.core.api.corporations.companies;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.corporations.RealEstateGroup;
import minevalley.core.api.regions.residences.ApartmentBlock;

import java.util.List;

public interface Kapitalgesellschaft extends Group, RealEstateGroup {

    List<Shareholder> getShareholders();

    void distribution(int distributionInCents);

    List<ApartmentBlock> getApartmentBlocks();

    interface Shareholder {

        Registrant getRegistrant();

        int getShareInPercent();

        void transfer(Registrant registrant, int shareInPercent);
    }
}
