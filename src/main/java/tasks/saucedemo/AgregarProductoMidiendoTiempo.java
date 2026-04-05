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

public class AgregarProductoMidiendoTiempo implements Task {

    public static AgregarProductoMidiendoTiempo alCarrito() {
        return Tasks.instrumented(AgregarProductoMidiendoTiempo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> productos = InterfacesUI.NOMBRES_PRODUCTOS_CATALOGO
                .resolveAllFor(actor)
                .stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());

        Collections.shuffle(productos);
        String productoElegido = productos.get(0);

        actor.attemptsTo(
                Task.where("{0} agrega el producto '" + productoElegido + "' midiendo el tiempo de respuesta",
                        Click.on(InterfacesUI.BTN_ADD_TO_CART.of(productoElegido))
                )
        );

        long tiempoInicio = System.currentTimeMillis();

        actor.attemptsTo(
                WaitUntil.the(InterfacesUI.CONTADOR_CARRITO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds()
        );

        long tiempoFin = System.currentTimeMillis();
        actor.remember("tiempoRespuesta", tiempoFin - tiempoInicio);
    }
}