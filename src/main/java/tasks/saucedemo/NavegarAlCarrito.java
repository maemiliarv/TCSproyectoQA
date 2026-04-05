package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.saucedemo.InterfacesUI;

public class NavegarAlCarrito implements Task {

    public static NavegarAlCarrito deCompras() {
        return Tasks.instrumented(NavegarAlCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Task.where("{0} navega al carrito de compras",
                        Click.on(InterfacesUI.ICONO_CARRITO)
                )
        );
    }
}