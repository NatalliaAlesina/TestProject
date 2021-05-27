package business.logic.imp;

import business.logic.IPdpService;
import business.logic.base.BaseTestService;
import lombok.extern.slf4j.Slf4j;
import po.pages.HomePage;
import po.pages.PdpPage;

@Slf4j
public class PdpService extends BaseTestService implements IPdpService {

    @Override
    public void openPDPPage() {
        log.info("Opening PDP page");
        initPage(HomePage.class).openGalleryPage().openPDPPage();
    }

    @Override
    public void select256GbCapacity() {
        log.info("Selecting 256GB capacity");
        initPage(PdpPage.class).select256GbCapacity();
    }

    @Override
    public String getUpfrontCost() {
        String upfrontCost = initPage(PdpPage.class).getUpfrontCost().getText();
        log.info("Upfront cost for best selling plan is " + upfrontCost);
        return upfrontCost;
    }

}
