package minevalley.core.api.regions;

import lombok.NonNull;
import minevalley.core.api.Registered;
import minevalley.core.api.economy.BankAccount;

public interface Plot extends Residence {

    /**
     * The worth of a plot is calculated automatically by its latest selling price.
     * <br>
     * It's used to calculate the upcoming taxes.
     */
    int getWorth();

    void setWorth();

    /**
     * The sale defines the price this plot is sold for.
     * <br>
     * The sale price is set to -1 if the plot isn't for sale.
     */
    int getSale();

    int getTaxes();

    /**
     * The PlotMerge defines the way this plot is merged with other plots.
     */
    PlotMerge getPlotMerge();

    /**
     * Creates new PlotMerge with this plot and the given plot. This plot will be the main plot.
     * <br>
     * <b>Note:</b> If either this plot or the given plot is already in a PlotMerge, the other one is added to its existing PlotMerge.
     * If both already have a PlotMerge, the one given with the plot-parameter will be adapted to the PlotMerge given in this plot.
     */
    void merge(Plot plot);

    /**
     * Sets this plot open for sale.
     *
     * @param price the price has to be a positive integer
     */
    void openForSale(int price);

    void changeBankAccount(BankAccount bankAccount);

    /**
     * Transfers this plot to the new owner and transfers the given price to the then owners bank account.
     * <br>
     * If the plot wasn't for sale or is locked, this method does nothing!
     *
     * @param registered new owner
     * @param account    new owners bank account
     * @return true, if the buying-process was successful
     */
    boolean buy(@NonNull Registered registered, @NonNull BankAccount account);

    boolean isLocked();
}
