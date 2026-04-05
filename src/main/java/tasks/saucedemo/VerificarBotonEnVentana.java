package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import userinterfaces.saucedemo.InterfacesUI;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VerificarBotonEnVentana implements Task {

    public static VerificarBotonEnVentana enDistintosTabanos() {
        return Tasks.instrumented(VerificarBotonEnVentana.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        int configuracionesExitosas = 0;

        int[][] tamanios = {
                {1920, 1080},
                {768, 1024},
                {375, 667}
        };

        String[] nombres = {"pantalla completa", "tablet", "movil"};

        for (int i = 0; i < tamanios.length; i++) {
            try {
                driver.manage().window().setSize(new Dimension(tamanios[i][0], tamanios[i][1]));

                List<String> productos = InterfacesUI.NOMBRES_PRODUCTOS_CATALOGO
                        .resolveAllFor(actor)
                        .stream()
                        .map(e -> e.getText())
                        .collect(Collectors.toList());

                Collections.shuffle(productos);
                String productoElegido = productos.get(0);

                actor.attemptsTo(
                        Task.where("{0} verifica el boton Add to cart en " + nombres[i] + " (" + tamanios[i][0] + "x" + tamanios[i][1] + ")",
                                Ensure.that(InterfacesUI.BTN_ADD_TO_CART.of(productoElegido)).isDisplayed(),
                                Ensure.that(InterfacesUI.BTN_ADD_TO_CART.of(productoElegido)).isEnabled()
                        )
                );

                configuracionesExitosas++;

            } catch (Exception e) {
                System.out.println("Fallo en configuracion " + nombres[i] + ": " + e.getMessage());
            }
        }

        actor.remember("configuracionesExitosas", configuracionesExitosas);
    }
}