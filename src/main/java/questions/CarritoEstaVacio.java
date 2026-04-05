package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterfaces.saucedemo.InterfacesUI;

public class CarritoEstaVacio implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return InterfacesUI.LISTA_PRODUCTOS_CARRITO.resolveAllFor(actor).isEmpty();
        } catch (Exception e) {
            return true;
        }
    }

    public static CarritoEstaVacio enLaPagina() {
        return new CarritoEstaVacio();
    }
}