package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import po.pages.FilterPage;
import business.logic.Filtering;
import business.objects.phone.Brand;
import business.objects.phone.Capacity;
import business.objects.phone.Cost;
import business.objects.phone.Filter;
import business.objects.phone.FilterImpl;
import business.objects.phone.LogingFilter;

public class FilterTest extends BaseTest {

    @Test(groups = {"Full"}, description = "Check Filter Results")

    //test trigger
    //test trigger2

    public void checkFilterResults() {

        Filter filter = new LogingFilter (new FilterImpl());
        filter.setCost(Cost.COST2);
        filter.setBrand(Brand.HUAWEI);
        filter.setCapacity(Capacity.CAPACITY2);
        Filtering.filterPhones(filter);

        Assert.assertTrue(FilterPage.getHuaweiP30LiteGAN().isDisplayed(), "Filter results are invalid!");
    }

}
