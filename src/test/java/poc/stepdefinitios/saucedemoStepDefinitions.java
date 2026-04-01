package poc.stepdefinitios;

import io.cucumber.java.Before;
//import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.en.When; //agregado
import io.cucumber.java.es.Dado;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.saucedemo.AccederAlSistema;
import tasks.web.Eligiendo;
import tasks.web.NavigateTo;
import java.lang.String;

import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.actions.Enter; //agregado
import net.serenitybdd.screenplay.actions.Click; //agregado
import userinterfaces.saucedemo.InterfacesUI;

import tasks.saucedemo.VerificarCatalogo;
import tasks.saucedemo.VerificarTitulo;
import tasks.saucedemo.VerificarMenuDesplegable;
import tasks.saucedemo.VerificarUrl;

public class saucedemoStepDefinitions {


    @Given("que el {actor} navega hacia demoqa.com")
    public void accederADemoqa(Actor actor) {

        actor.wasAbleTo(
                NavigateTo.demoQAPage()
        );
    }

    @When("acceder al sistema")
    public void accederAlSistema() {
        theActorInTheSpotlight().attemptsTo(
                AccederAlSistema.Login()
        );
    }

    @Then("el catalogo de productos debe estar visible")
    public void verificarCatalogo() {
        theActorInTheSpotlight().attemptsTo(
                VerificarCatalogo.cargaCorrectamente()
        );
    }

    @Then("el titulo del catalogo existe")
    public void verificarTitulo() {
        theActorInTheSpotlight().attemptsTo(
                VerificarTitulo.delCatalogo()
        );
    }

    @Then("el boton del menu desplegable existe")
    public void verificarMenuDesplegable() {
        theActorInTheSpotlight().attemptsTo(
                VerificarMenuDesplegable.estaPresente()
        );
    }

    @Then("la url debe ser la del catalogo")
    public void verificarUrl() {
        theActorInTheSpotlight().attemptsTo(
                VerificarUrl.delCatalogo()
        );
    }

    /*
    @Y("visualiza el carrito de compras")
    public void visualizarCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(
                VerCarrito.deCompras()
        );
    }

    @Y("completa el formulario de compra con los datos del JSON y finaliza la compro")
    public void completarFormularioDeCompra() throws IOException, ParseException {
        JSONObject js = DatosParametrizados.leerJson();
        theActorInTheSpotlight().attemptsTo(
                CompletarPedido.conDatosCliente((String) js.get("nombre"),(String)js.get("pais") , (String)js.get("ciudad"), (String) js.get("tarjeta"), (String) js.get("mes"), (String) js.get("anio"))
        );
    }


    @Entonces("debe ver un mensaje de confirmacion con el ID de la orden y el monto total")
    public void deberiaVerUnMensajeConfirmacionConIdDeOrdenYMontoTotal() throws IOException, ParseException {
        JSONObject js = DatosParametrizados.leerJson();
        theActorInTheSpotlight().attemptsTo(
                FinalizarCompra.ahora((String) js.get("nombre"))
        );
    }

     */
}
