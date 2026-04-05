package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import userinterfaces.saucedemo.InterfacesUI;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.time.Duration;

public class EliminarProductosDelCatalogo implements Task {

    private int cantidad;

    public EliminarProductosDelCatalogo(int cantidad) {
        this.cantidad = cantidad;
    }

    public static EliminarProductosDelCatalogo enCantidad(int cantidad) {
        return new EliminarProductosDelCatalogo(cantidad);
    }

    public static EliminarProductosDelCatalogo todosLosAgregados() {
        return new EliminarProductosDelCatalogo(-1);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> todosLosProductos = new ArrayList<>((List<String>) actor.recall("productosAgregados"));

        List<String> productosAEliminar = cantidad == -1
                ? todosLosProductos
                : new ArrayList<>(todosLosProductos.subList(0, cantidad));

        for (int i = 0; i < productosAEliminar.size(); i++) {
            String producto = productosAEliminar.get(i);
            boolean esElUltimo = i == productosAEliminar.size() - 1;

            if (esElUltimo) {
                actor.attemptsTo(
                        Task.where("{0} elimina el ultimo producto '" + producto + "' desde el catalogo",
                                Click.on(InterfacesUI.BTN_REMOVE_CATALOGO.of(producto)),
                                WaitUntil.the(InterfacesUI.BTN_ADD_TO_CART.of(producto),
                                                WebElementStateMatchers.isVisible())
                                        .forNoMoreThan(5).seconds(),
                                Scroll.to(InterfacesUI.ICONO_CARRITO)
                        )
                );
            } else {
                actor.attemptsTo(
                        Task.where("{0} elimina el producto '" + producto + "' desde el catalogo",
                                Click.on(InterfacesUI.BTN_REMOVE_CATALOGO.of(producto)),
                                WaitUntil.the(InterfacesUI.CONTADOR_CARRITO,
                                                WebElementStateMatchers.isVisible())
                                        .forNoMoreThan(5).seconds()
                        )
                );
            }
        }
    }


}