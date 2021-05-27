package business.objects.phone;

public class FilterImpl implements Filter {

    private Cost cost;
    private Brand brand;
    private Capacity capacity;

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand name) {
        this.brand = name;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

}
