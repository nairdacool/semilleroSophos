package com.telmex.tienda.testing.tasks;

import java.util.List;

import org.openqa.selenium.Keys;

import com.telmex.tienda.models.Articulos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import static com.telmex.tienda.testing.ui.PaginaDeInicioTiendaTelmex.getCampoDeBusqueda;

public class BuscarArticulos implements Task {
	
	private List<Articulos> articulos;
	
	public BuscarArticulos(List<Articulos> articulos) {
		this.articulos = articulos;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(articulos.get(0).getArticulo()).into(getCampoDeBusqueda()).thenHit(Keys.ENTER));
		
	}
	
	public static  BuscarArticulos buscar (List<Articulos> articulos) {
		return Tasks.instrumented(BuscarArticulos.class, articulos);
		
	}

}
