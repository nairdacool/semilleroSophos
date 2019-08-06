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
	
	private static final Target botonComprar = 
			Target.the("click en el boton comprar").located(By.xpath("//form[@id='AddToCartForm1']//input[@id='button']"));
	
	public static final Target getBotonComprar() {
		return botonComprar;
	}

}
