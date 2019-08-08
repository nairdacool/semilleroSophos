package com.telmex.tienda.questions;

import static com.telmex.tienda.testing.ui.PaginaDeInicioDeSesion.getTestoLoginCompra;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class EnMiTelmex implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(getTestoLoginCompra()).viewedBy(actor).asString();
	}

	public static EnMiTelmex iniciarSesion() {
		return new EnMiTelmex();
	}

}