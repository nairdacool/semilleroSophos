package com.telmex.tienda.testing.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaDelCarrito extends PageObject {
	
	private static final Target botonSiguienteCompra =
			Target.the("boton siguiente para comprar").located(By.xpath("//input[@class='frm_boton_azul_tienda']"));
	
	public static Target getBotonSiguienteCompra() {
		return botonSiguienteCompra;
	}

}