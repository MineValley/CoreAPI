package minevalley.core.api.corporations.companies;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface StateCompany extends Kapitalgesellschaft {

    /**
     * Gets the sector of this state company.
     *
     * @return the sector
     */
    @Nonnull
    @Contract(pure = true)
    Sector getSector();

    /**
     * The sector of a state company.
     */
    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    enum Sector {
        OFFICE("Behörde"),
        REAL_ESTATE("Immobilien"),
        ECONOMY("Wirtschaftsinstitut"),
        PUBLIC_INSTITUTION("Öffentliche Einrichtung");

        private final String name;

        /**
         * Gets the ID of the sector.
         *
         * @return the ID
         */
        @Nonnegative
        @Contract(pure = true)
        public int id() {
            return ordinal();
        }

        /**
         * Gets the sector by its ID.
         *
         * @param id the ID
         * @return the sector
         * @throws IllegalArgumentException if the ID is invalid
         */
        @Nonnull
        @Contract(pure = true)
        public static Sector getSector(int id) throws IllegalArgumentException {
            if (id < 0) throw new IllegalArgumentException("ID must be greater than 0");
            if (id >= Sector.values().length) {
                throw new IllegalArgumentException("ID must be less than or equal to " + Sector.values().length);
            }
            return Sector.values()[id];
        }
    }
}
