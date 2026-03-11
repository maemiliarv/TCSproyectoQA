package poc.stepdefinitios;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.appium.BuscarVideo;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static userinterfaces.appium.HomePage.BOTON_BUSCAR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

//@ExtendWith(SerenityJUnit5Extension.class)
public class YoutubeAppStepDefinitions {

    /*
    @Test
    @DisplayName("Buscar un video de futbol en Youtubee")
    public void buscarVideoFutbolEnYoutube() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Juan").attemptsTo(
                WaitUntil.the(BOTON_BUSCAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BOTON_BUSCAR),
                BuscarVideo.enYoutube()
        );
    }



    @Test
    @DisplayName("Verificar la navegacion por las opciones de Menud e yOutube como Suscripciones y Principal")
    public void abrirOpcionesMenu() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Juan").attemptsTo(
                Abrir.laOpcion().suscripciones()
        );
        theActorInTheSpotlight().attemptsTo(
                Abrir.laOpcion().principal()
        );
    }


    @Test
    @DisplayName("Verificar que en Shorts la opcion COMPARTIR esta visible - Usando Question")
    public void verificarBotonCompartirEnShortsConQuestion() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Juan").attemptsTo(
                Abrir.laOpcion().shorts()
        );
        theActorInTheSpotlight().should(seeThat(
                BotonCompartir.esVisible()
        ).orComplainWith(BotonCompartirNoEsVisibleException.class, MENSAJE_BOTON_COMPARTIR_NO_VISIBLE)
        );
    }


    @Test
    @DisplayName("Verificar que en Shorts la opcion COMPARTIR esta visible - Usando Ensure")
    public void verificarBotonCompartirEnShortsConEnsure() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Juan").attemptsTo(
                Abrir.laOpcion().shorts()
        );
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(BOTON_COMPARTIR).isDisplayed()
        );
    }


     */


    @Given("que el usuario abre Youtube")
    public void abrirYoutube() {
        //System.out.printf("El entorno es = "+System.getenv().toString());
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Juan").attemptsTo(
                WaitUntil.the(BOTON_BUSCAR, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(BOTON_BUSCAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BOTON_BUSCAR),
                BuscarVideo.enYoutube()
        );
    }

    @When("busca un video de futbol")
    public void buscarVideoDeFutbol() {
        // Aquí implementas la acción de búsqueda
        System.out.println("Buscar video de futbol en Youtube");
    }

    @Then("debería ver resultados relacionados")
    public void validarResultados() {
        // Aquí validas que aparezcan resultados
        System.out.println("Validar que aparecen resultados de futbol");
    }
    //-----------------------------------------------------------------


}
