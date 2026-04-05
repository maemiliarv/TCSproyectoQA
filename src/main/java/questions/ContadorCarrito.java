package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterfaces.saucedemo.InterfacesUI;

public class ContadorCarrito implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        try {
            String texto = InterfacesUI.CONTADOR_CARRITO.resolveFor(actor).getText();
            return Integer.parseInt(texto);
        } catch (Exception e) {
            return 0;
        }
    }

    public static ContadorCarrito enElHeader() {
        return new ContadorCarrito();
    }
}
