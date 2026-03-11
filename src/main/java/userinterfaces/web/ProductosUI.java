package userinterfaces.web;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductosUI extends PageObject {


    @FindBy(xpath = "//div[@id='tbodyid']//h4[@class='card-title']/a[@class='hrefch']")
    public List<WebElement> productosVisibles;

    public List<String> obtenerProductos(){
        return productosVisibles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public static final Target BTN_PRODUCTO_SELECCIONADO = Target.the("Enlace hacia el producto: {0}").locatedBy("//div[@id='tbodyid']//h4[@class='card-title']/a[contains(normalize-space(), '{0}')]").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target LBL_PRECIO_PRODUCTO_SELECCIONADO = Target.the("Label del precio del producto: {0}").locatedBy("//a[contains(normalize-space(), '{0}')]/ancestor::div[@class='card-block']/h5").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target BTN_ADD_CART = Target.the("Boton para agregar al carrito").locatedBy("//a[contains(normalize-space(), 'Add to cart')]").waitingForNoMoreThan(Duration.ofSeconds(15));


}