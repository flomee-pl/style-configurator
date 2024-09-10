package pl.flomee.styleconfigurator.domain.clothing.core.model.attributes;

public enum ClothingPart {
    SHIRT,
    PANTS,
    SHOES,
    JACKET,
    DRESS,
    HAT,
    BRACELET,
    NECKLACE,
    RING;
    public String toPolish() {
        switch (this) {
            case SHIRT:
                return "Koszula";
            case PANTS:
                return "Spodnie";
            case SHOES:
                return "Buty";
            case JACKET:
                return "Kurtka";
            case DRESS:
                return "Sukienka";
            case HAT:
                return "Czapka";
            case BRACELET:
                return "Bransoletka";
            case NECKLACE:
                return "Naszyjnik";
            case RING:
                return "Pierścionek";
            default:
                return this.name();
        }
    }
}
