package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResultadoEjecucionesRepetidas implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return actor.recall("ejecucionesExitosas");
    }

    public static ResultadoEjecucionesRepetidas deLastresejecuciones() {
        return new ResultadoEjecucionesRepetidas();
    }
}