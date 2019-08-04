package com.telmex.tienda.testing.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EntrarATiendaTelmex implements Task {
	
	PageObject pagina;
	
	public EntrarATiendaTelmex(PageObject pagina) {
		this.pagina = pagina;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn(pagina));
	}

	public static EntrarATiendaTelmex En(PageObject paginadeinicio) {
		return instrumented(EntrarATiendaTelmex.class, paginadeinicio);
	}

}