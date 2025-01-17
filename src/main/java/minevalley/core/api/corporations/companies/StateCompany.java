package minevalley.core.api.corporations.companies;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("unused")
public interface StateCompany extends Kapitalgesellschaft {

    Sector getSector();

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    enum Sector {
        OFFICE(1, "Behörde"),
        REAL_ESTATE(2, "Immobilien"),
        ECONOMY(3, "Wirtschaftsinstitut"),
        PUBLIC_INSTITUTION(4, "Öffentliche Einrichtung");

        private final int id;
        private final String name;

        public static Sector getSector(int id) {
            assert id > 0;
            assert id < Sector.values().length;
            return Sector.values()[id - 1];
        }
    }
}
