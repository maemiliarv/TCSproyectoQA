package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.saucedemo.InterfacesUI;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VerificarBotonesAddToCart implements Task {

    public static VerificarBotonesAddToCart enElCatalogo() {
        return Tasks.instrumented(VerificarBotonesAddToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> productos = InterfacesUI.NOMBRES_PRODUCTOS_CATALOGO
                .resolveAllFor(actor)
                .stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());

        for (String producto : productos) {
            actor.attemptsTo(
                    Task.where("{0} verifica que el boton Add to cart del producto '" + producto + "' es visible y esta habilitado",
                            Ensure.that(InterfacesUI.BTN_ADD_TO_CART.of(producto)).isDisplayed(),
                            Ensure.that(InterfacesUI.BTN_ADD_TO_CART.of(producto)).isEnabled()
                    )
            );
        }

        actor.remember("totalProductosVerificados", productos.size());
    }
}