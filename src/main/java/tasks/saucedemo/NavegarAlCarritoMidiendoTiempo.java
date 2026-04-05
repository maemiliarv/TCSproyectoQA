package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.saucedemo.InterfacesUI;

public class NavegarAlCarritoMidiendoTiempo implements Task {

    public static NavegarAlCarritoMidiendoTiempo desdeElHeader() {
        return Tasks.instrumented(NavegarAlCarritoMidiendoTiempo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Task.where("{0} navega al carrito midiendo el tiempo de carga",
                        Click.on(InterfacesUI.ICONO_CARRITO)
                )
        );

        long tiempoInicio = System.currentTimeMillis();

        actor.attemptsTo(
                WaitUntil.the(InterfacesUI.LISTA_PRODUCTOS_CARRITO,
                                WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds()
        );

        long tiempoFin = System.currentTimeMillis();
        actor.remember("tiempoCargaCarrito", tiempoFin - tiempoInicio);
    }
}