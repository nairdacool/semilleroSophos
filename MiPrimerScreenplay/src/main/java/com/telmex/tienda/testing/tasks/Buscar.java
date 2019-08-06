package com.telmex.tienda.testing.tasks;

import org.openqa.selenium.Keys;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static com.telmex.tienda.testing.ui.PaginaDeInicioTiendaTelmex.getCampoDeBusqueda;

public class Buscar implements Task {
	
	String palabra;
	
	public Buscar (String palabra) {
		this.palabra = palabra;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(palabra).into(getCampoDeBusqueda()).thenHit(Keys.ENTER));
	}

	public static Buscar laPalabra(String palabra) {
		return Tasks.instrumented(Buscar.class, palabra);
	}
	
}