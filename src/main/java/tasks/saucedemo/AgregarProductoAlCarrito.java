package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.saucedemo.InterfacesUI;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AgregarProductoAlCarrito implements Task {

    public static AgregarProductoAlCarrito aleatorio() {
        return Tasks.instrumented(AgregarProductoAlCarrito.class);
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

        actor.remember("productosAgregados", productoElegido);

        actor.attemptsTo(
                Task.where("{0} agrega el producto '" + productoElegido + "' al carrito",
                        Click.on(InterfacesUI.BTN_ADD_TO_CART.of(productoElegido))
                )
        );
    }
}