package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.ContadorCarrito;
import userinterfaces.saucedemo.InterfacesUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AgregarProductosAlCarrito implements Task {

    private int cantidad;

    public AgregarProductosAlCarrito(int cantidad) {
        this.cantidad = cantidad;
    }

    public static AgregarProductosAlCarrito enCantidad(int cantidad) {
        return new AgregarProductosAlCarrito(cantidad);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> productos = InterfacesUI.NOMBRES_PRODUCTOS_CATALOGO
                .resolveAllFor(actor)
                .stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());

        Collections.shuffle(productos);
        List<String> productosElegidos = new ArrayList<>(productos.subList(0, cantidad));

        actor.remember("productosAgregados", productosElegidos);

        int contadorEsperado = 0;
        for (String producto : productosElegidos) {
            contadorEsperado++;
            final int valorEsperado = contadorEsperado;
            actor.attemptsTo(
                    Task.where("{0} agrega el producto '" + producto + "' al carrito",
                            Click.on(InterfacesUI.BTN_ADD_TO_CART.of(producto)),
                            WaitUntil.the(InterfacesUI.BTN_REMOVE_CATALOGO.of(producto),
                                            WebElementStateMatchers.isVisible())
                                    .forNoMoreThan(5).seconds(),
                            Scroll.to(InterfacesUI.CONTADOR_CARRITO),
                            Ensure.that(ContadorCarrito.enElHeader()).isEqualTo(valorEsperado)
                    )
            );

        }
    }
}
