package pl.flomee.styleconfigurator.domain.outfit.core.model.attributes;

public enum Sex {
    MALE,
    FEMALE,
    UNISEX;

    public String toPolish() {
        switch (this) {
            case MALE:
                return "MĘŻCZYZNA";
            case FEMALE:
                return "KOBIETA";
            case UNISEX:
                return "UNISEKS";
            default:
                return this.name();
        }
    }
}
