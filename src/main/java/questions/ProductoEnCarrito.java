package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterfaces.saucedemo.InterfacesUI;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoEnCarrito implements Question<Boolean> {

    private String nombreProducto;

    public ProductoEnCarrito(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> productosEnCarrito = InterfacesUI.LISTA_PRODUCTOS_CARRITO
                .resolveAllFor(actor)
                .stream()
                .map(e -> e.findBy(".//div[@data-test='inventory-item-name']").getText())
                .collect(Collectors.toList());
        return productosEnCarrito.contains(nombreProducto);
    }

    public static ProductoEnCarrito conNombre(String nombreProducto) {
        return new ProductoEnCarrito(nombreProducto);
    }
}