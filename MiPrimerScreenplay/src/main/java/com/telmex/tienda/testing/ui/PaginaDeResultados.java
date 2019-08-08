package com.telmex.tienda.testing.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaDeResultados extends PageObject {
	
	private static final Target primerResultadoDeLaPagina =
			Target.the("Seleccion primer resultado").located(By
					.xpath("//a[contains(text(),'Lavadora automática con Tapa Cristal 16 kg Easy Bl')]"));
	
	public static Target getPrimerResultadoDeLaPagina() {
		return primerResultadoDeLaPagina;
	}
	
	private static final Target resultadNoEncontrado = 
			Target.the("articulo no encontrado").located(By
					.xpath("//span[@class='txt_precioficha']"));
	
	public static Target getResultadNoEncontrado() {
		return resultadNoEncontrado;
	}

}
