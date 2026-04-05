package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.saucedemo.InterfacesUI;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AgregarProductoRepetidamente implements Task {

    public static AgregarProductoRepetidamente tresveces() {
        return Tasks.instrumented(AgregarProductoRepetidamente.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int ejecucionesExitosas = 0;

        for (int i = 0; i < 3; i++) {
            try {
                List<String> productos = InterfacesUI.NOMBRES_PRODUCTOS_CATALOGO
                        .resolveAllFor(actor)
                        .stream()
                        .map(e -> e.getText())
                        .collect(Collectors.toList());

                Collections.shuffle(productos);
                String productoElegido = productos.get(0);

                actor.attemptsTo(
                        Task.where("{0} agrega el producto '" + productoElegido + "' al carrito en el intento " + (i + 1),
                                Click.on(InterfacesUI.BTN_ADD_TO_CART.of(productoElegido)),
                                WaitUntil.the(InterfacesUI.CONTADOR_CARRITO, WebElementStateMatchers.isVisible())
                                        .forNoMoreThan(5).seconds(),
                                Click.on(InterfacesUI.BTN_REMOVE_CATALOGO.of(productoElegido))
                        )
                );

                ejecucionesExitosas++;

            } catch (Exception e) {
                System.out.println("Fallo en el intento " + (i + 1) + ": " + e.getMessage());
            }
        }

        actor.remember("ejecucionesExitosas", ejecucionesExitosas);
    }
}