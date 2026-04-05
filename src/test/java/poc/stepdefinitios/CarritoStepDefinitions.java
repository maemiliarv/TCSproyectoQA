package poc.stepdefinitios;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.ContadorCarrito;
import tasks.saucedemo.AgregarProductoAlCarrito;
import tasks.saucedemo.AgregarProductosAlCarrito;
import questions.ProductoEnCarrito;
import tasks.saucedemo.NavegarAlCarrito;
import tasks.saucedemo.EliminarProductosDelCatalogo;
import questions.CarritoEstaVacio;
import tasks.saucedemo.EliminarProductosDelCarrito;


import questions.TiempoRespuestaCarrito;
import tasks.saucedemo.AgregarProductoMidiendoTiempo;
import static org.hamcrest.Matchers.lessThan;
import tasks.saucedemo.VerificarBotonesAddToCart;
import static org.hamcrest.Matchers.greaterThan;
import questions.ResultadoEjecucionesRepetidas;
import tasks.saucedemo.AgregarProductoRepetidamente;
import static org.hamcrest.Matchers.equalTo;
import tasks.saucedemo.VerificarBotonEnVentana;
import questions.TiempoCargaCarrito;
import tasks.saucedemo.AgregarTodosLosProductos;
import tasks.saucedemo.NavegarAlCarritoMidiendoTiempo;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CarritoStepDefinitions {

    @Before("@carrito")
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("agrega un producto aleatorio al carrito")
    public void agregarProducto() {
        theActorInTheSpotlight().attemptsTo(
                AgregarProductoAlCarrito.aleatorio()
        );
    }

    @When("agrega {int} productos aleatorios al carrito")
    public void agregarVariosProductos(int cantidad) {
        theActorInTheSpotlight().attemptsTo(
                AgregarProductosAlCarrito.enCantidad(cantidad)
        );
    }

    @Then("el contador del carrito debe ser {int}")
    public void verificarContador(int cantidad) {
        theActorInTheSpotlight().should(
                seeThat(ContadorCarrito.enElHeader(), equalTo(cantidad))
        );
    }

    @When("navega al carrito de compras")
    public void navegarAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                NavegarAlCarrito.deCompras()
        );
    }

    @Then("el producto agregado debe aparecer en el carrito")
    public void verificarProductoEnCarrito() {
        String productoAgregado = (String) theActorInTheSpotlight().recall("productosAgregados");
        theActorInTheSpotlight().should(
                seeThat(ProductoEnCarrito.conNombre(productoAgregado), is(true))
        );
    }

    @When("elimina {int} productos aleatorios desde el catalogo")
    public void eliminarProductosDelCatalogo(int cantidad) {
        theActorInTheSpotlight().attemptsTo(
                EliminarProductosDelCatalogo.enCantidad(cantidad)
        );
    }

    @When("elimina los productos desde el carrito")
    public void eliminarProductosDelCarrito() {
        theActorInTheSpotlight().attemptsTo(
                EliminarProductosDelCarrito.todosLosAgregados()
        );
    }

    @Then("el carrito debe estar vacio")
    public void verificarCarritoVacio() {
        theActorInTheSpotlight().should(
                seeThat(CarritoEstaVacio.enLaPagina(), is(true))
        );
    }

    @When("agrega un producto midiendo el tiempo de respuesta")
    public void agregarProductoMidiendoTiempo() {
        theActorInTheSpotlight().attemptsTo(
                AgregarProductoMidiendoTiempo.alCarrito()
        );
    }

    @Then("el tiempo de respuesta del carrito debe ser menor a {int} milisegundos")
    public void verificarTiempoRespuesta(Integer tiempoMaximo) {
        theActorInTheSpotlight().should(
                seeThat(TiempoRespuestaCarrito.enMillisegundos(), lessThan((long) tiempoMaximo))
        );
    }

    @When("verifica que los botones Add to cart son visibles y estan habilitados")
    public void verificarBotonesAddToCart() {
        theActorInTheSpotlight().attemptsTo(
                VerificarBotonesAddToCart.enElCatalogo()
        );
    }

    @Then("todos los botones Add to cart deben estar disponibles")
    public void verificarTodosLosBotones() {
        int totalProductos = theActorInTheSpotlight().recall("totalProductosVerificados");
        theActorInTheSpotlight().should(
                seeThat("el total de productos verificados", actor -> totalProductos, greaterThan(0))
        );
    }

    @When("ejecuta el flujo de agregar producto al carrito 3 veces consecutivas")
    public void ejecutarFlujoTresVeces() {
        theActorInTheSpotlight().attemptsTo(
                AgregarProductoRepetidamente.tresveces()
        );
    }

    @Then("todas las ejecuciones deben haber sido exitosas")
    public void verificarEjecucionesExitosas() {
        theActorInTheSpotlight().should(
                seeThat(ResultadoEjecucionesRepetidas.deLastresejecuciones(), equalTo(3))
        );
    }

    @When("verifica el boton Add to cart en distintos tamaños de ventana")
    public void verificarBotonEnDistintosTamanios() {
        theActorInTheSpotlight().attemptsTo(
                VerificarBotonEnVentana.enDistintosTabanos()
        );
    }

    @Then("el boton debe funcionar correctamente en todas las configuraciones")
    public void verificarTodasLasConfiguraciones() {
        int configuracionesExitosas = theActorInTheSpotlight().recall("configuracionesExitosas");
        theActorInTheSpotlight().should(
                seeThat("las configuraciones de ventana exitosas", actor -> configuracionesExitosas, equalTo(3))
        );
    }

    @When("agrega todos los productos disponibles al carrito")
    public void agregarTodosLosProductos() {
        theActorInTheSpotlight().attemptsTo(
                AgregarTodosLosProductos.alCarrito()
        );
    }

    @When("navega al carrito midiendo el tiempo de carga")
    public void navegarAlCarritoMidiendoTiempo() {
        theActorInTheSpotlight().attemptsTo(
                NavegarAlCarritoMidiendoTiempo.desdeElHeader()
        );
    }

    @Then("el tiempo de carga del carrito debe ser menor a {int} milisegundos")
    public void verificarTiempoCargaCarrito(Integer tiempoMaximo) {
        theActorInTheSpotlight().should(
                seeThat(TiempoCargaCarrito.enMillisegundos(), lessThan((long) tiempoMaximo))
        );
    }
}
