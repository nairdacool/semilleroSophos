package com.telmex.tienda.testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static com.telmex.tienda.testing.ui.PaginaDeContenido.getBotonComprar;

public class ClickEnBotonComprar implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(getBotonComprar()));
		
	}

	public static Performable boton() {
		return Tasks.instrumented(ClickEnBotonComprar.class);
	}

}
