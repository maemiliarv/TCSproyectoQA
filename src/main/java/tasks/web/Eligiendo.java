package tasks.web;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import userinterfaces.web.CategoriasUI;
import userinterfaces.web.HeaderUI;
import userinterfaces.web.ProductosUI;
import utils.web.ControlAlarmas;
import utils.web.GeneradorAleatorio;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Eligiendo implements Task {

    private String eligiendo;

    @Steps
    static CategoriasUI categoriasUI;
    @Steps
    static ProductosUI productosUI;

    public Eligiendo(String eligiendo){
        this.eligiendo = eligiendo;
    }

    public static Eligiendo unaCategoriaAleatoria(){
        return Tasks.instrumented(Eligiendo.class, "categoria");
    }

    public static Eligiendo unProductoAleatorios(){
        return Tasks.instrumented(Eligiendo.class, "productos");
    }

    public static Eligiendo productosDeCualquierCategoria(){
        return Tasks.instrumented(Eligiendo.class, "2productos");
    }

    @Override
    public <T extends Actor> void performAs(T Actor){
        if(eligiendo.equals("categoria")){
            //Elije el nombre de una categoria aleatoriamente
            List<String> listaCategorias = categoriasUI.obtenerCategorias();
            String nombreCategoria = listaCategorias.get(GeneradorAleatorio.numeroEntre(0,2));
            //Selecciona una categoria
            theActorInTheSpotlight().attemptsTo(Task.where("Selecciona la categoria: {0}",
                    Scroll.to(CategoriasUI.BTN_CATEGORIA.of(nombreCategoria)).andAlignToBottom(),
                    Click.on(CategoriasUI.BTN_CATEGORIA.of(nombreCategoria)).afterWaitingUntilEnabled()
            ));
        }else if(eligiendo.equals("productos")){
            //Elije el nombre de un producto aleatorio
            List<String> listaProductos = productosUI.obtenerProductos();
            String nombreProducto = listaProductos.get(GeneradorAleatorio.numeroEntre(0,listaProductos.size()-1));
            theActorInTheSpotlight().attemptsTo(Scroll.to(ProductosUI.BTN_PRODUCTO_SELECCIONADO.of(nombreProducto)).andAlignToBottom());
            //Recuerda el nombre y precio del producto seleccionado
            theActorInTheSpotlight().remember("producto"+nombreProducto, nombreProducto);
            theActorInTheSpotlight().remember("precio"+nombreProducto, ProductosUI.LBL_PRECIO_PRODUCTO_SELECCIONADO.of(nombreProducto).resolveFor(Actor).getText());
            //Selecciona un producto
            theActorInTheSpotlight().attemptsTo(
                    Task.where("Selecciona el producto: {0}",
                    Click.on(ProductosUI.BTN_PRODUCTO_SELECCIONADO.of(nombreProducto)).afterWaitingUntilEnabled(),
                    Click.on(ProductosUI.BTN_ADD_CART).afterWaitingUntilEnabled()
            ));
            theActorInTheSpotlight().attemptsTo(
                    Task.where("acepta la alerta",
                            a -> ControlAlarmas.aceptarAlerta()
                    )
            );
            theActorInTheSpotlight().attemptsTo(
                    Click.on(HeaderUI.LINK_HOME).afterWaitingUntilEnabled()
            );
        }else if(eligiendo.equals("2productos")){
            for (int i = 1; i < 3; i++) {
                theActorInTheSpotlight().attemptsTo(
                        Task.where("Eligiendo Categorias y productos aleatorios",
                                unaCategoriaAleatoria(),
                                unProductoAleatorios()
                        )
                );
            }
        }
    }
}
