package userinterfaces.web;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriasUI extends PageObject {

    //public static final Target CATEGORIAS = Target.the("categorías disponibles").locatedBy("//div[@class='list-group']/a[@class='list-group-item' and @id='itemc']");

    @FindBy(xpath = "//div[@class='list-group']/a[@class='list-group-item' and @id='itemc']")
    public List<WebElement> categoriasVisibles;

    public List<String> obtenerCategorias(){
        return categoriasVisibles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public static final Target BTN_CATEGORIA = Target.the("Btn de Categoria - {0}").locatedBy("//div[@class='list-group']/a[@class='list-group-item' and @id='itemc' and contains(normalize-space(), '{0}')]").waitingForNoMoreThan(Duration.ofSeconds(10));

}