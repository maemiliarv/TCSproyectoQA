package utils.web;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ControlAlarmas {

    public static void aceptarAlerta() {
        /*
        WebDriver driver = Serenity.getDriver();
        Alert alerta = driver.switchTo().alert();
        alerta.accept(); // Hace clic en "Aceptar"
        driver.switchTo().activeElement(); // Vuelve al contexto principal

         */
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
            alerta.accept();
        } catch (TimeoutException e) {
            System.out.println("No apareció ninguna alerta en el tiempo esperado.");
        }
    }
}