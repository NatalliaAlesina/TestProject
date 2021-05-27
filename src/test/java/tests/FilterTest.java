package tests;

import base.BaseTest;
import business.logic.imp.Filtering;
import business.objects.phone.Brand;
import business.objects.phone.Capacity;
import business.objects.phone.Cost;
import business.objects.phone.Filter;
import business.objects.phone.FilterImpl;
import business.objects.phone.LogingFilter;
import po.pages.FilterPage;

import com.google.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTest extends BaseTest {

    @Inject
    Filtering filtering;

    @Test(groups = { "Full" }, description = "Check Filter Results")

    public void checkFilterResults() {

        Filter filter = new LogingFilter(new FilterImpl());
        filter.setCost(Cost.COST2);
        filter.setBrand(Brand.HUAWEI);
        filter.setCapacity(Capacity.CAPACITY2);
        filtering.filterPhones(filter);

        Assert.assertTrue(FilterPage.getHuaweiP30LiteGAN().isDisplayed(), "Filter results are invalid!");
    }

}
