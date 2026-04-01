package tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.saucedemo.InterfacesUI;

public class AccederAlSistema implements Task {

    public static AccederAlSistema Login(){
        return Tasks.instrumented(AccederAlSistema.class);
    }

    @Override
    public <T extends Actor> void performAs(T Actor){
                Actor.attemptsTo(Enter.theValue("standard_user").into(InterfacesUI.LOGIN_USUARIO),
                        Enter.theValue("secret_sauce").into(InterfacesUI.LOGIN_PASSWORD),
                        Click.on(InterfacesUI.BTN_LOGIN));

    }
}
