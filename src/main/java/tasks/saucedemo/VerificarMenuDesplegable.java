package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import userinterfaces.saucedemo.InterfacesUI;

public class VerificarMenuDesplegable implements Task {

    public static VerificarMenuDesplegable estaPresente() {
        return Tasks.instrumented(VerificarMenuDesplegable.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(InterfacesUI.BTN_MENU_DESPLEGABLE).isDisplayed(),
                Click.on(InterfacesUI.BTN_MENU_DESPLEGABLE));
    }
}