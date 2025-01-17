package minevalley.core.api.corporations.companies;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.corporations.RealEstateGroup;
import minevalley.core.api.regions.residences.ApartmentBlock;

import java.util.List;

@SuppressWarnings("unused")
public interface Aktiengesellschaft extends Group, RealEstateGroup {

    List<Stockholder> getStockholders();

    void distributeDividends(int dividendInCents);

    List<ApartmentBlock> getApartmentBlocks();

    interface Stockholder {

        Registrant getRegistrant();

        int getAmountOfStocks();

    }
}
