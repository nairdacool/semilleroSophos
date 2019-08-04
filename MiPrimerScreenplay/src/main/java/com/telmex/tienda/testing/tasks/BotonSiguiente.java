package com.telmex.tienda.testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static com.telmex.tienda.testing.ui.PaginaDelCarrito.getBotonSiguienteCompra;

public class BotonSiguiente implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(getBotonSiguienteCompra()));
	}

	public static BotonSiguiente comprar() {
		return instrumented(BotonSiguiente.class);
	}

}