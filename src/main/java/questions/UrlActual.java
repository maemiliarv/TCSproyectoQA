package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.core.Serenity;

public class UrlActual implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Serenity.getDriver().getCurrentUrl();
    }

    public static UrlActual delNavegador() {
        return new UrlActual();
    }
}