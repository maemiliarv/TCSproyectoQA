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
}
