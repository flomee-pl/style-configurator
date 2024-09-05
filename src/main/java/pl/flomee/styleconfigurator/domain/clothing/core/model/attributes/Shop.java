package pl.flomee.styleconfigurator.domain.clothing.core.model.attributes;

public enum Shop {
    ANSWEAR;

    public String toPolish() {
        switch (this) {
            case ANSWEAR:
                return "ANSWEAR";
            default:
                return this.name();
        }
    }
}
