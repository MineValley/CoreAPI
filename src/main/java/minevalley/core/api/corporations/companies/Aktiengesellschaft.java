package minevalley.core.api.corporations.companies;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.RealEstateGroup;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Aktiengesellschaft extends RealEstateGroup {

    /**
     * Gives a list of all stockholders of this AG.
     *
     * @return a list of all stockholders
     */
    @Nonnull
    @Contract(pure = true)
    List<Stockholder> getStockholders();

    /**
     * Distributes dividends to all stockholders of this AG.
     *
     * @param dividendInCents the amount of money in cents to be distributed per stock
     * @throws IllegalArgumentException if the dividend is negative
     */
    void distributeDividends(@Nonnegative int dividendInCents) throws IllegalArgumentException;

    interface Stockholder {

        /**
         * Gives the registrant who owns the stocks.
         *
         * @return the stockholder
         */
        @Nonnull
        @Contract(pure = true)
        Registrant getRegistrant();

        /**
         * Gives the amount of stocks owned by the stockholder.
         *
         * @return the amount of stocks
         */
        @Nonnegative
        @Contract(pure = true)
        int getAmountOfStocks();

    }
}
