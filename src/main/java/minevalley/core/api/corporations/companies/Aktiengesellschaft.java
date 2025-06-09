package minevalley.core.api.corporations.companies;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.corporations.RealEstateGroup;

import java.util.List;

@SuppressWarnings("unused")
public interface Aktiengesellschaft extends Group, RealEstateGroup {

    List<Stockholder> getStockholders();

    void distributeDividends(int dividendInCents);

    interface Stockholder {

        Registrant getRegistrant();

        int getAmountOfStocks();

    }
}
