package pl.pjwtk.domkru;

import org.springframework.context.ApplicationContext;

public class ComponentContext {
    private ApplicationContext applicationContext;

    public ComponentContext(ApplicationContext applicationContext) {
        Component01 component01 = applicationContext.getBean(Component01.class);
        Component02 component02 = applicationContext.getBean(Component02.class);
        component01.printInfo();
        component02.printInfo();
    }

}
