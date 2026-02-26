package minevalley.core.api.users;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public record Education(@Nonnull Education.Subject subject, long graduationDate) {

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Subject {

        // Medicine
        MEDICINE("Medizin", "Mediziner", true),
        PARAMEDIC_2("Ausbildung zum Notfallsanitäter", "Notfallsanitäter", false),
        PARAMEDIC_1("Ausbildung zum Rettungssanitäter", "Rettungssanitäter", false),

        // Law and Order
        CRIMINOLOGY("Kriminologie", "Kriminologe", true),
        POLICE_2("Polizeiausbildung im gehobenen Dienst", "Polizeibeamter im gehobenen Dienst", true),
        POLICE_1("Polizeiausbildung im mittleren Dienst", "Polizeibeamter im mittleren Dienst", false),

        // Engineering
        AEROSPACE_ENGINEERING("Luft- und Raumfahrttechnik", "Luft- und Raumfahrttechniker", true),
        AUTOMOTIVE_ENGINEERING("Fahrzeugtechnik", "Fahrzeugtechniker", true),
        CIVIL_ENGINEERING("Bauingenieurwesen", "Bauingenieur", true),
        WEAPON_TECHNOLOGY("Waffentechnik", "Waffentechniker", true),
        MECHATRONICS_AUTOMOTIVE("KFZ-Mechatronik", "KFZ-Mechatroniker", false),
        MECHATRONICS("Mechatronik", "Mechatroniker", false),

        // Sales
        PUBLIC_ADMINISTRATION("Verwaltungswissenschaften", "Verwaltungswissenschaftler", true),
        ECONOMICS("Wirtschaftswissenschaft", "Wirtschaftswissenschaftler", true),
        RETAIL("Ausbildung zum Einzelhandelskaufmann", "Einzelhandelskaufmann", false),

        // Gastronomy
        GASTRONOMY("Ausbildung in der Gastronomie", "Fachkraft für Gastronomie", false),
        BAKER("Ausbildung zum Bäcker", "Bäcker", false),

        // Agriculture
        AGRICULTURE_SCIENCE("Agrarwissenschaften", "Agrarwissenschaftler", true),
        AGRICULTURE("Ausbildung zum Landwirt", "Landwirt", false),

        // Environment and Logistics
        WASTE_MANAGEMENT("Ausbildung zum Umwelttechnologen", "Umwelttechnologe", false),
        LOGISTICS("Logistikausbildung", "Logistiker", false),

        // Licenses - Vehicles
        HELICOPTER_LICENSE("Helikopter-Flugschein", "Pilot", false),
        DRIVERS_LICENSE("Führerschein", "Besitzer eines Führerscheins", false),
        MOTORCYCLE_LICENSE("Motorradführerschein", "Besitzer eines Motorradführerscheins", false),

        // Licenses - Firearms
        BIG_FIREARM_LICENSE("Waffenschein", "Besitzer eines großen Waffenscheins", false),
        SMALL_FIREARM_LICENSE("Kleiner Waffenschein", "Besitzer eines kleinen Waffenscheins", false),

        // Extracurricular
        HACKING("Hacking", "Hacker", false);

        private final String subjectName;
        private final String jobName;
        private final boolean isAcademic;
    }
}