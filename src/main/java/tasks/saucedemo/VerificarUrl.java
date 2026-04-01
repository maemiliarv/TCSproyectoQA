package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import questions.UrlActual;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class VerificarUrl implements Task {

    public static VerificarUrl delCatalogo() {
        return Tasks.instrumented(VerificarUrl.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThat(UrlActual.delNavegador(), equalTo("https://www.saucedemo.com/inventory.html"))
        );
    }
}
