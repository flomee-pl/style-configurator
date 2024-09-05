package pl.flomee.styleconfigurator.domain.outfit.core.model.attributes;

public enum Style {
    CASUAL,
    SPORT,
    ELEGANT,
    STREETWEAR,
    SMART,
    FORMAL;

    public String toPolish() {
        switch (this) {
            case CASUAL:
                return "CODZIENNY";
            case SPORT:
                return "SPORTOWY";
            case ELEGANT:
                return "ELEGANCKI";
            case STREETWEAR:
                return "ULICZNY";
            case SMART:
                return "SCHLUDNY";
            case FORMAL:
                return "FORMALNY";
            default:
                return this.name();
        }
    }
}
