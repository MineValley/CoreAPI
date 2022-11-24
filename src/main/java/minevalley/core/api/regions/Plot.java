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

    /**
     * The sale defines the price this plot is sold for.
     * <br>
     * The sale price is set to -1 if the plot isn't for sale.
     */
    int getSale();

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

    boolean payElectricityCosts(BankAccount account);

    BankAccount getOwnersBankAccount();

    void changeOwnersBankAccount(@NonNull BankAccount account);

    void openForSale(int price);

    boolean buy(@NonNull Registered registered, @NonNull BankAccount account);

    /**
     * Transmits this plot to another owner. This method should never be called to sell the plot.
     * It only changes the given parameters. No money is transferred. This plots worth remains unchanged.
     */
    void transmit(@NonNull Registered registered, @NonNull BankAccount account);
}
