package business.logic.base;

import business.logic.IFilterService;
import business.logic.IMenuService;
import business.logic.IPdpService;
import business.logic.imp.FilterService;
import business.logic.imp.MenuService;
import business.logic.imp.PdpService;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class BaseTestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IMenuService.class).to(MenuService.class).in(Scopes.SINGLETON);
        bind(IFilterService.class).to(FilterService.class).in(Scopes.SINGLETON);
        bind(IPdpService.class).to(PdpService.class).in(Scopes.SINGLETON);
    }
}
