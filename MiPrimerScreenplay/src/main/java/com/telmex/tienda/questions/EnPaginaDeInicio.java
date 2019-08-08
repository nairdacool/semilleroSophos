package com.telmex.tienda.questions;

import static com.telmex.tienda.testing.ui.PaginaDeResultados.getResultadNoEncontrado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class EnPaginaDeInicio implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(getResultadNoEncontrado()).viewedBy(actor).asString();
	}
	
	public static EnPaginaDeInicio elementoNoEncontrado() {
		return new EnPaginaDeInicio();
	}

}
