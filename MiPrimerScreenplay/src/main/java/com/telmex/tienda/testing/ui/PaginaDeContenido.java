package com.telmex.tienda.testing.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaDeContenido extends PageObject {
	
	private static final Target agregarAlCarritoDeCompra =
			Target.the("Agregar al carrito de compras").located(By.xpath("//input[@class='frm_bot_azoscuro']"));
	
	public static Target getAgregarAlCarritoDeCompra() {
		return agregarAlCarritoDeCompra;
	}

}
