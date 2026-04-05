package userinterfaces.saucedemo;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class InterfacesUI extends PageObject {

    //public static final Target CATEGORIAS = Target.the("categorías disponibles").locatedBy("//div[@class='list-group']/a[@class='list-group-item' and @id='itemc']");


    public static final Target BTN_LOGIN = Target.the("Btn de Login - {0}").locatedBy("//input[@id='login-button']").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target LOGIN_USUARIO = Target.the("Login - usuario - {0}").locatedBy("//input[@id='user-name']").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target LOGIN_PASSWORD = Target.the("Login - password - {0}").locatedBy("//input[@id='password']").waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target LISTA_PRODUCTOS = Target.the("Lista de productos del catalogo")
            .locatedBy("//div[@class='inventory_list']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target TITULO_CATALOGO = Target.the("Titulo del catalogo de productos")
            .locatedBy("//span[@class='title']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target BTN_MENU_DESPLEGABLE = Target.the("Boton del menu desplegable")
            .locatedBy("//button[@id='react-burger-menu-btn']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target BTN_ADD_TO_CART = Target.the("Boton Add to cart del producto {0}")
            .locatedBy("//div[@data-test='inventory-item-name' and normalize-space()='{0}']/ancestor::div[@data-test='inventory-item-description']//button[contains(@class,'btn_inventory')]")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target CONTADOR_CARRITO = Target.the("Contador del carrito")
            .locatedBy("//span[@data-test='shopping-cart-badge']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target NOMBRES_PRODUCTOS_CATALOGO = Target.the("Nombres de productos en catalogo")
            .locatedBy("//div[@data-test='inventory-item-name']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target ICONO_CARRITO = Target.the("Icono del carrito")
            .locatedBy("//a[@data-test='shopping-cart-link']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target LISTA_PRODUCTOS_CARRITO = Target.the("Productos en el carrito")
            .locatedBy("//div[@data-test='cart-list']//div[@data-test='inventory-item']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target BTN_REMOVE_CATALOGO = Target.the("Boton Remove del producto {0} en el catalogo")
            .locatedBy("//div[@data-test='inventory-item-name' and normalize-space()='{0}']/ancestor::div[@data-test='inventory-item-description']//button[text()='Remove']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target BTN_REMOVE_CARRITO = Target.the("Boton Remove del producto {0} en el carrito")
            .locatedBy("//div[@data-test='inventory-item' and .//div[@data-test='inventory-item-name' and normalize-space()='{0}']]//button[text()='Remove']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
}
