package minevalley.core.api.corporations.business;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.regions.ApartmentBlock;

import java.util.List;

public interface Aktiengesellschaft extends Group {

    List<Stockholder> getStockholders();

    void distributeDividends(int dividendInCents);

    List<ApartmentBlock> getApartmentBlocks();

    interface Stockholder {

        Registrant getRegistrant();

        int getAmountOfStocks();

    }
}
