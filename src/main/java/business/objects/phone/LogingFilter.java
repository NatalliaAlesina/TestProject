package business.objects.phone;

public class LogingFilter implements Filter {

    public LogingFilter(FilterImpl filter) {
    }

    private Cost cost;
    private Brand brand;
    private Capacity capacity;

    public Cost getCost() {
        System.out.println("Getting cost");
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Brand getBrand() {
        System.out.println("Geting brand");
        return brand;
    }

    public void setBrand(Brand name) {
        this.brand = name;
    }

    public Capacity getCapacity() {
        System.out.println("Geting capacity");
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

}
