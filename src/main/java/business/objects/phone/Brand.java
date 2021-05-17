package business.objects.phone;

public enum Brand {

    ALCATEL ("Alcatel"),
    DORO ("Doro"),
    EE ("EE"),
    HUAWEI ("HUAWEI"),
    LG ("LG"),
    MOBIWIRE ("MobiWire"),
    MOTOROLA ("Motorola"),
    NOKIA ("Nokia"),
    SAMSUNG ("Sumsung"),
    SONY ("Sony");

    String brandLinkText;

    Brand (String brandLinkText) {
        this.brandLinkText = brandLinkText;
    }

    public String getBrandLinkText() {
        return brandLinkText;
    }

}
