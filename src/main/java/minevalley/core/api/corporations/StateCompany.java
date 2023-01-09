package minevalley.core.api.corporations;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.corporations.business.Kapitalgesellschaft;

public interface StateCompany extends Kapitalgesellschaft {

    Sector getSector();

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    enum Sector {
        OFFICE("Behörde"),
        REAL_ESTATE("Immobilien"),
        ECONOMY("Wirtschaftsinstitut"),
        PUBLIC_INSTITUTION("Öffentliche Einrichtung");
        private final String clearName;
    }
}
