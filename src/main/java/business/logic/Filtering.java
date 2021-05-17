package business.logic;

import business.objects.phone.Filter;
import driver.CustomDriver;
import po.pages.FilterPage;

public class Filtering {

    public static void filterPhones(Filter filter) {
        FilterPage filterPage = new FilterPage(CustomDriver.getWebDriverInstance()).open();
        filterPage.selectCost(filter.getCost());
        filterPage.selectBrand(filter.getBrand());
        filterPage.selectCapacity(filter.getCapacity());
    }
}
