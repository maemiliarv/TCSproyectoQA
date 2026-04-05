package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TiempoCargaCarrito implements Question<Long> {

    @Override
    public Long answeredBy(Actor actor) {
        return actor.recall("tiempoCargaCarrito");
    }

    public static TiempoCargaCarrito enMillisegundos() {
        return new TiempoCargaCarrito();
    }
}