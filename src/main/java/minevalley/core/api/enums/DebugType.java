package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum DebugType {
    SYSTEM("System"),
    DATABASE("Datenbank"),
    DATABASE_ALL("Datenbank (erweitert)"),
    SETTINGS("Spielereinstellungen"),
    STATISTICS("Statistik"),
    POLICE("Polizei"),
    MEDIC("Rettungsdienst"),
    USER_ACTION("Spieleraktionen"),
    FINANCE("Finanzen"),
    ERRORS("Errors");

    private final String name;
}
