package pl.flomee.styleconfigurator.domain.outfit.core.model.attributes;

public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    public String toPolish() {
        switch (this) {
            case WINTER:
                return "ZIMA";
            case SPRING:
                return "WIOSNA";
            case SUMMER:
                return "LATO";
            case AUTUMN:
                return "JESIEŃ";
            default:
                return this.name();
        }
    }
}
