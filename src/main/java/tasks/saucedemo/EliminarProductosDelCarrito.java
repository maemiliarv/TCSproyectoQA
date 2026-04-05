package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import userinterfaces.saucedemo.InterfacesUI;

import java.util.List;

public class EliminarProductosDelCarrito implements Task {

    public static EliminarProductosDelCarrito todosLosAgregados() {
        return Tasks.instrumented(EliminarProductosDelCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> productos = (List<String>) actor.recall("productosAgregados");

        for (String producto : productos) {
            Click.on(InterfacesUI.BTN_REMOVE_CARRITO.of(producto)).performAs(actor);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

