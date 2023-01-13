package minevalley.core.api.corporations;

public enum MemberPermission {

    MANAGE_DEPARTMENT_BELL, // Klingeln erstellen und bearbeiten
    MANAGE_GROUP_BELL,

    MANAGE_DEPARTMENT_CARS, // Autos umlackieren, Schloss tauschen, etc.
    MANAGE_GROUP_CARS,

    MANAGE_DEPARTMENT_RESIDENCES, // Residenzen bearbeiten (Baurechte verteilen und Wohnungen erstellen/löschen/bearbeiten)
    MANAGE_GROUP_RESIDENCES,

    MANAGE_DEPARTMENT_BILLS, // Rechnungen begleichen (Stromkosten; Mit Firmenkonto)
    MANAGE_GROUP_BILLS,

    MANAGE_DEPARTMENT_PROPERTY, // Besitzgüter verwalten (kaufen, verkaufen)
    MANAGE_GROUP_PROPERTY,

    OPERATE_APARTMENT_BLOCKS, // Wohnblocks betreiben (Reparaturen, Stromrechnungen)

    MANAGE_APARTMENT_BLOCKS, // Wohnblocks verwalten (Stockwerke, Kündigungen)
}