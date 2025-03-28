package minevalley.core.api.corporations.companies;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.corporations.RealEstateGroup;
import minevalley.core.api.regions.residences.ApartmentBlock;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Kapitalgesellschaft extends Group, RealEstateGroup {

    @Nonnull
    @Contract(pure = true)
    List<Shareholder> getShareholders();

    void distribution(@Nonnegative int distributionInCents) throws IllegalArgumentException;

    @Nonnull
    @Contract(pure = true)
    List<ApartmentBlock> getApartmentBlocks();

    interface Shareholder {

        @Nonnull
        @Contract(pure = true)
        Registrant getRegistrant();

        @Contract(pure = true)
        int getShareInPercent();

        void transfer(@Nonnull Registrant registrant, @Nonnegative int shareInPercent) throws IllegalArgumentException;
    }
}
