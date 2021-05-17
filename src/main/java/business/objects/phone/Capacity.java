package business.objects.phone;

public enum Capacity {

    CAPACITY1 ("4GB"),
    CAPACITY2 ("256GB"),
    CAPACITY3 ("8GB"),
    CAPACITY4 ("8MB"),
    CAPACITY5 ("16GB"),
    CAPACITY6 ("16MB"),
    CAPACITY7 ("32GB"),
    CAPACITY8 ("512MB");

    String capacityLinkText;

    Capacity (String capacityLinkText) {
        this.capacityLinkText = capacityLinkText;
    }

    public String getCapacityLinkText() {
        return capacityLinkText;
    }

}
