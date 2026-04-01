package tasks.web;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable demoQAPage() {
        return Task.where("{0} navega hacia la pagina principal de DemoQA",
                Open.browserOn().the(GoHomePage.class));
    }
}
