package com.telmex.tienda.testing.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaDeInicioDeSesion extends PageObject {
	
	private static final Target textoLoginCompra =
			Target.the("Inicia sesión en Mi Telmex").located(By.xpath("//p[@class='titulo_form_ap']"));
	
	public static Target getTestoLoginCompra() {
		return textoLoginCompra;
	}
}
