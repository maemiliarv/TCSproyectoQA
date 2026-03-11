package userinterfaces.web;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class HeaderUI extends PageObject {

    public static final Target LINK_HOME = Target.the("Enlace de 'Home' en Header").locatedBy("//a[contains(normalize-space(), 'Home')]").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target LINK_CART = Target.the("Enlace de 'Cart' en Header").locatedBy("//a[contains(normalize-space(), 'Cart')]").waitingForNoMoreThan(Duration.ofSeconds(10));


}