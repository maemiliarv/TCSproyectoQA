package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import userinterfaces.saucedemo.InterfacesUI;

public class VerificarTitulo implements Task {

    public static VerificarTitulo delCatalogo() {
        return Tasks.instrumented(VerificarTitulo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(InterfacesUI.TITULO_CATALOGO).isDisplayed()
        );
    }
}