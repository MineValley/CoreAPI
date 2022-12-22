package minevalley.core.api.regions;

import org.bukkit.Location;
import org.bukkit.block.Block;

public interface PlotMerge {

    /**
     * Only the main plot does have a plot sign.
     */
    Plot getMainPlot();

    /**
     * All plots that are merged in this PlotMerge including the main plot
     */
    Plot[] getPlots();

    /**
     * When plots are merged, there are tiny subregions between both plots that also need be added to the plotmerge.
     */
    Region[] getMergeRegions();

    /**
     * Merges this plot with this PlotMerge.
     * <br>
     * If the other plot isn't mergable with this PlotMerge,
     * or if the other plot doesn't have the same owner as this PlotMerges main plot, the merge won't be executed.
     * Add checks before calling this method to give the correct user feedback when needed!
     * <br>
     * <b>Ruling:</b> If neither this nor the plot to merge with is already merged to any other plot,
     * this plot will remain as the <i>main</i> plot (read below). If this plot is already merged with another plot,
     * the plot to merge with will be added to the plot, that is known as the main plot in the merge of this plot.
     * If the plot to merge with is also merged with/to other plots, all plots that were merged to the plot to merge with
     * will be added to the new main plot. Solely if the plot to merge with is already merged and this one is not, the other plots main plot is used.
     * <p>
     * This results in a behaviour of this method,
     * in which its insignificant from which of both plots this method is called,
     * as long as only one of both plots has already been merged.
     * </p>
     *
     * @param plot Plot to merge with
     */
    void merge(Plot plot);

    /**
     * Unmerges a merged plot.
     * <br>
     * If the other plot was never merged in this PlotMerge, nothing happens.
     * <br>
     * <b>Ruling:</b> In many cases (e. g. in plot-chains), unmerging one plot results in disconnecting
     * some plots from the main plot of this PlotMerge.
     * In this case, the other plots (including the one that was explicitly unmerged here)
     * will be added to a new PlotMerge with the unmerged plot as main plot.
     */
    void unmerge(Plot plot);

    /**
     * Checks whether the given block is part of this plotmerge region.
     */
    boolean contains(Block block);

    /**
     * Checks whether the given location is part of this plotmerge region.
     */
    boolean contains(Location location);

    // setup-method
    void addPlot(Region mergeRegion, Plot... plots);

    // setup-method
    void removePlot(Plot plot);
}
