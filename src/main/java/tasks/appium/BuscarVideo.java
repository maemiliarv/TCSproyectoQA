package tasks.appium;

import actions.appium.EscribirEnInputs;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterfaces.appium.HomePage.CAMPO_BUSCAR_VIDEOS;

public class BuscarVideo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CAMPO_BUSCAR_VIDEOS),
                EscribirEnInputs.elTexto("Gol de Roberto Carlos")
        );
    }

    public static Performable enYoutube(){
        return Tasks.instrumented(BuscarVideo.class);
    }
}
