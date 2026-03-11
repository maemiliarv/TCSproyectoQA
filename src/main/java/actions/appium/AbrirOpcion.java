package actions.appium;

import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import utils.appium.MenuEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.appium.HomePage;
import utils.appium.MobileHelper;

public class AbrirOpcion implements Interaction {

    private MenuEnum opcionMenu;

    public AbrirOpcion(MenuEnum opcionMenu){
        this.opcionMenu = opcionMenu;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String platform = MobileHelper.getPlatformName();
        String valorPlataforma = opcionMenu.getValorSegunPlataforma(platform);
        if("Android".equals(platform)){
            actor.attemptsTo(
                    WaitUntil.the(HomePage.MENU_ANDROID.of(valorPlataforma), WebElementStateMatchers.isClickable())
                            .forNoMoreThan(10).seconds(),
                    Click.on(HomePage.MENU_ANDROID.of(valorPlataforma))
            );
        }else {
            actor.attemptsTo(
                    WaitUntil.the(HomePage.MENU_IOS.of(valorPlataforma), WebElementStateMatchers.isClickable())
                            .forNoMoreThan(10).seconds(),
                    Click.on(HomePage.MENU_IOS.of(valorPlataforma))
            );
        }
    }
}
