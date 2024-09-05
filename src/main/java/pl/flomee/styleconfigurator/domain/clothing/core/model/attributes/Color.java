package pl.flomee.styleconfigurator.domain.clothing.core.model.attributes;

public enum Color {
    BLACK,
    WHITE,
    GREY,
    BLUE,
    RED,
    GREEN;

    public String toPolish() {
        switch (this) {
            case BLACK:
                return "CZARNY";
            case WHITE:
                return "BIAŁY";
            case GREY:
                return "SZARY";
            case BLUE:
                return "NIEBIESKI";
            case RED:
                return "CZERWONY";
            case GREEN:
                return "ZIELONY";
            default:
                return this.name();
        }
    }
}
