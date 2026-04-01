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

}