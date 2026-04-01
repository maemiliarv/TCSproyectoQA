package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import userinterfaces.saucedemo.InterfacesUI;

public class VerificarCatalogo implements Task {

    public static VerificarCatalogo cargaCorrectamente() {
        return Tasks.instrumented(VerificarCatalogo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(InterfacesUI.LISTA_PRODUCTOS).isDisplayed()
        );
    }
}