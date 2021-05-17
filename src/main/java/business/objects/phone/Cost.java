package business.objects.phone;

public enum Cost {

    COST1 ("£0-£49.99"),
    COST2 ("From £20 to £30"),
    COST3 ("150-199.99"),
    COST4 ("£50-£99.99");

    String costLinkText;

    Cost (String costLinkText) {
        this.costLinkText = costLinkText;
    }

    public String getCostLinkText() {
        return costLinkText;
    }

}
