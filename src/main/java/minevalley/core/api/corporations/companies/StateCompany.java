package minevalley.core.api.corporations.companies;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface StateCompany extends Kapitalgesellschaft {

    @Nonnull
    @Contract(pure = true)
    Sector getSector();

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    enum Sector {
        OFFICE("Behörde"),
        REAL_ESTATE("Immobilien"),
        ECONOMY("Wirtschaftsinstitut"),
        PUBLIC_INSTITUTION("Öffentliche Einrichtung");

        private final String name;

        public int getId() {
            return ordinal();
        }

        public static Sector getSector(int id) throws IllegalArgumentException {
            if (id < 0) throw new IllegalArgumentException("ID must be greater than 0");
            if (id >= Sector.values().length) {
                throw new IllegalArgumentException("ID must be less than or equal to " + Sector.values().length);
            }
            return Sector.values()[id];
        }
    }
}
