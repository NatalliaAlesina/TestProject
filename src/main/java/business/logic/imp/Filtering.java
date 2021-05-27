package business.logic.imp;

import business.logic.base.BaseTestService;
import business.objects.phone.Filter;
import po.pages.FilterPage;

public class Filtering extends BaseTestService {

    public void filterPhones(Filter filter) {
        FilterPage filterPage = initPage(FilterPage.class);
        filterPage.open();
        filterPage.selectCost(filter.getCost());
        filterPage.selectBrand(filter.getBrand());
        filterPage.selectCapacity(filter.getCapacity());
    }
}
