package minevalley.core.api.corporations;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MemberPermission {

    MANAGE_DEPARTMENT_BELL("manage_department_bell"), // Klingeln erstellen und bearbeiten
    MANAGE_GROUP_BELL("manage_group_bell"),

    MANAGE_DEPARTMENT_CARS("manage_department_cars"), // Autos umlackieren, Schloss tauschen, etc.
    MANAGE_GROUP_CARS("manage_group_cars"),

    MANAGE_DEPARTMENT_RESIDENCES("manage_department_residences"), // Residenzen bearbeiten (Baurechte verteilen und Wohnungen erstellen/löschen/bearbeiten)
    MANAGE_GROUP_RESIDENCES("manage_group_residences"),

    MANAGE_DEPARTMENT_BILLS("manage_department_bills"), // Rechnungen begleichen (Stromkosten; Mit Firmenkonto)
    MANAGE_GROUP_BILLS("manage_group_bills"),

    MANAGE_DEPARTMENT_PROPERTY("manage_department_property"), // Besitzgüter verwalten (kaufen, verkaufen)
    MANAGE_GROUP_PROPERTY("manage_group_property"),

    OPERATE_APARTMENT_BLOCKS("operate_apartment_blocks"), // Wohnblocks betreiben (Reparaturen, Stromrechnungen)

    MANAGE_APARTMENT_BLOCKS("manage_apartment_blocks"); // Wohnblocks verwalten (Stockwerke, Kündigungen)

    private final String code;
}