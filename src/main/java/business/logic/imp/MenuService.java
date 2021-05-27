package business.logic.imp;

import business.logic.IMenuService;
import business.logic.base.BaseTestService;
import lombok.extern.slf4j.Slf4j;
import po.pages.HomePage;

@Slf4j
public class MenuService extends BaseTestService implements IMenuService {

    @Override
    public void openMenu() {
        log.info("Opening Home page");
        initPage(HomePage.class).openMenu();
    }

    @Override
    public boolean isShopButtonDisplayed() {
        boolean isShopButtonDisplayed = initPage(HomePage.class).getShopButton().isDisplayed();
        log.info("Shop button is displayed in the menu: " + isShopButtonDisplayed);
        return initPage(HomePage.class).getShopButton().isDisplayed();
    }

    @Override
    public boolean isPhoneMenuItemDisplayed() {
        boolean isPhoneMenuItemDisplayed = initPage(HomePage.class).getShopButton().isDisplayed();
        log.info("Phone menu item is displayed in the menu: " + isPhoneMenuItemDisplayed);
        return initPage(HomePage.class).getPhonesButton().isDisplayed();
    }
}
