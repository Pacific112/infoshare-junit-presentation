package pl.infoshare.junit5._4_advanced._3_nested;

public class Visitor {

    private final String name;
    private final IdType idType;
    private final boolean isFromEu;

    public Visitor(String name, IdType idType, boolean isFromEu) {
        this.name = name;
        this.idType = idType;
        this.isFromEu = isFromEu;
    }

    public boolean canEnter() {
        if (isFromEu) {
            return idType == IdType.PASSPORT || idType == IdType.ID;
        }

        return idType == IdType.PASSPORT;
    }
}
