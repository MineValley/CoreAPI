package minevalley.core.api.regions;

import lombok.NonNull;
import minevalley.core.api.Registrant;
import minevalley.core.api.economy.BankAccount;

public interface Plot extends Residence {

    int getHouseNumber();

    @Override
    default String getAddressShortcut() {
        return getStreet().getShortName() + getHouseNumber();
    }

    /**
     * The PlotMerge defines the way this plot is merged with other plots.
     *
     * @return this plots merge.
     */
    PlotMerge getPlotMerge();

    /**
     * Creates new PlotMerge with this plot and the given plot. This plot will be the main plot.
     * <br>
     * <b>Note:</b> If either this plot or the given plot is already in a PlotMerge, the other one is added to its existing PlotMerge.
     * If both already have a PlotMerge, the one given with the plot-parameter will be adapted to the PlotMerge given in this plot.
     *
     * @param plot plot to merge this plot with
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
     * @param registrant new owner
     * @param account    new owners bank account
     * @return true, if the buying-process was successful
     */
    boolean buy(@NonNull Registrant registrant, @NonNull BankAccount account);
}
