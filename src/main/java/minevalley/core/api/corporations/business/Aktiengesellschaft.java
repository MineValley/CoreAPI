package minevalley.core.api.corporations.business;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.Group;

import java.util.List;

public interface Aktiengesellschaft extends Group {

    List<Stockholder> getStockholders();

    void distributeDividends(int dividendInCents);

    interface Stockholder {

        Registrant getRegistrant();

        int getAmountOfStocks();

    }
}
