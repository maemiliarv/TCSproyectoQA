package actions.appium;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.appium.HomePage;

public class EscribirEnInputs implements Interaction {

    private String nombreVideo;

    public EscribirEnInputs(String nombreVideo){
        this.nombreVideo = nombreVideo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombreVideo).into(HomePage.CAMPO_BUSCAR_VIDEOS)
        );
    }

    public static EscribirEnInputs elTexto(String nombreVideo){
        return Tasks.instrumented(EscribirEnInputs.class, nombreVideo);
    }
}
