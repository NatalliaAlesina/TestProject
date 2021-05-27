package business.logic.imp;

import business.logic.IFilterService;
import business.logic.base.BaseTestService;
import lombok.extern.slf4j.Slf4j;
import po.pages.GalleryPage;
import po.pages.HomePage;

@Slf4j
public class FilterService extends BaseTestService implements IFilterService {

    public void openGalleryPage() {
        log.info("Opening gallery page");
        initPage(HomePage.class).openMenu().openGalleryPage();
    }

    public void clickGoogleFilter() {
        log.info("Clicking 'Google' filter");
        initPage(GalleryPage.class).clickGoogleCheckBox();
    }

    public void clickAppleFilter() {
        log.info("Clicking 'Apple' filter");
        initPage(GalleryPage.class).clickAppleCheckBox();
    }

    public boolean isEePhoneDisplayed() {
        boolean isEePhoneDisplayed = initPage(GalleryPage.class).getEEPhone().isDisplayed();
        log.info("EE phone is displayed in gallery after filtering " + isEePhoneDisplayed);
        return isEePhoneDisplayed;
    }
}
