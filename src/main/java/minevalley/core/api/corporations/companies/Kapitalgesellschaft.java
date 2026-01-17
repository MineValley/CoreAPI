package minevalley.core.api.corporations.companies;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.RealEstateGroup;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Kapitalgesellschaft extends RealEstateGroup {

    /**
     * Gives a list of all shareholders of this Kapitalgesellschaft.
     *
     * @return a list of all shareholders
     */
    @Nonnull
    @Contract(pure = true)
    List<Shareholder> getShareholders();

    /**
     * Distributes a certain amount of money in cents to all shareholders of this Kapitalgesellschaft
     *
     * @param distributionInCents the amount of money in cents to be distributed
     * @throws IllegalArgumentException if the distribution is negative
     */
    void distribution(@Nonnegative int distributionInCents) throws IllegalArgumentException;

    interface Shareholder {

        /**
         * Gets the registrant who owns the shares.
         *
         * @return the shareholder
         */
        @Nonnull
        @Contract(pure = true)
        Registrant getRegistrant();

        /**
         * Gets the share of the shareholder in percent.
         *
         * @return the share in percent
         */
        @Contract(pure = true)
        int getShareInPercent();

        /**
         * Transfers a certain share in percent to another registrant.
         *
         * @param registrant     the new shareholder
         * @param shareInPercent the share in percent to be transferred
         * @throws IllegalArgumentException if the share is negative or greater than the current share of the shareholder
         */
        void transfer(@Nonnull Registrant registrant, @Nonnegative int shareInPercent) throws IllegalArgumentException;
    }
}
