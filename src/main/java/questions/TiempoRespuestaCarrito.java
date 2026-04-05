package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TiempoRespuestaCarrito implements Question<Long> {

    @Override
    public Long answeredBy(Actor actor) {
        return actor.recall("tiempoRespuesta");
    }

    public static TiempoRespuestaCarrito enMillisegundos() {
        return new TiempoRespuestaCarrito();
    }
}