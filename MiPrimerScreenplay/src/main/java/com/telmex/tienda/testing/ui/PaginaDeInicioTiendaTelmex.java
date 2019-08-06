package com.telmex.tienda.testing.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://tienda.telmex.com")
public class PaginaDeInicioTiendaTelmex extends PageObject {
	
	private static final Target campoDeBusqueda =
			Target.the("Campo de busqueda de Tienda Telmex").located(By.xpath("//input[@id='textInputSearch']"));
	
	public static Target getCampoDeBusqueda() {
		return campoDeBusqueda;
	}
	
}
