package poc.stepdefinitios;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.RestAssured;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.web.Eligiendo;
import tasks.web.NavigateTo;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
public class PokemonApiStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario hace una consulta a la API de Pokemon para obtener el nombre de Pikachu")
    public void consultarPokemonPorNombre() {
        // Configuramos la base URI
        RestAssured.baseURI = "https://pokeapi.co/api/v2";
    }

    @Cuando("obtiene el resultado")
    public void obtieneElResultado() {
        // Realizamos la petición y validamos el status code
        given()
                .when()
                .get("/pokemon/pikachu")
                .then()
                .statusCode(200);
    }

    @Entonces("el nombre de Pokemon debe ser {string}")
    public void validarNombrePokemon(String nombreEsperado) {
        // Validamos el campo "name" en el JSON
        given()
                .when()
                .get("/pokemon/pikachu")
                .then()
                .body("name", equalTo(nombreEsperado));
    }
}
