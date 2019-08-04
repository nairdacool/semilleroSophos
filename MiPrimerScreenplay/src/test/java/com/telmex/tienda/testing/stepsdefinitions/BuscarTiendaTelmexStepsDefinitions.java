package com.telmex.tienda.testing.stepsdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import org.openqa.selenium.WebDriver;
import com.telmex.tienda.questions.EnMiTelmex;
import com.telmex.tienda.testing.tasks.BotonSiguiente;
import com.telmex.tienda.testing.tasks.Buscar;
import com.telmex.tienda.testing.tasks.CarritoDeCompra;
import com.telmex.tienda.testing.tasks.EntrarATiendaTelmex;
import com.telmex.tienda.testing.tasks.SeleccionarResultado;
import com.telmex.tienda.testing.ui.PaginaDeInicio;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed; 

public class BuscarTiendaTelmexStepsDefinitions {
	Actor adrian = Actor.named("Adrian");
	PaginaDeInicio paginaDeInicio;

	@Managed(driver = "chrome")
	WebDriver suNavegador;
	
	@Before
	public void setUp() {
		adrian.can(BrowseTheWeb.with(suNavegador));
		suNavegador.manage().window().maximize();
	}
	
	@Given("Adrian entro a Tienda Telmex")
	public void adrianEntroATiendaTelmex() {
		adrian.attemptsTo(EntrarATiendaTelmex.En(paginaDeInicio));
	}

	@When("^Adrian busca \"([^\"]*)\" y agrega una al carrito de compras$")
	public void adrianBuscaYAgregaUnaAlCarritoDeCompras(String palabra) {
		adrian.attemptsTo(Buscar.laPalabra(palabra));
		adrian.attemptsTo(SeleccionarResultado.primero());
		adrian.attemptsTo(CarritoDeCompra.agregar());
		adrian.attemptsTo(BotonSiguiente.comprar());
	}

	@Then("Adrian valida que el titulo de la ventana contenga la palabra (.*)")
	public void adrianValidaQueElTituloDeLaVentanaContengaLaPalabra(String palabra) {
		adrian.should(seeThat(EnMiTelmex.iniciarSesion(), equalTo("Inicia sesión en Mi Telmex")));
	}

}
