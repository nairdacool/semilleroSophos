package com.telmex.tienda.testing.stepsdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
import org.openqa.selenium.WebDriver;
import com.telmex.tienda.testing.tasks.BotonSiguiente;
import com.telmex.tienda.testing.tasks.BuscarArticulos;
import com.telmex.tienda.testing.tasks.ClickEnBotonComprar;
import com.telmex.tienda.testing.tasks.EntrarATiendaTelmex;
import com.telmex.tienda.testing.ui.PaginaDeInicioTiendaTelmex;
import com.telmex.tienda.exeptions.ConexionNoDisponible;
import com.telmex.tienda.models.Articulos;
import com.telmex.tienda.questions.EnMiTelmex;
import com.telmex.tienda.questions.EnPaginaDeInicio;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class BuscarArticulosTiendaTelmexStepsDefinitions {
	
	Actor adrian = Actor.named("Adrian");
	PaginaDeInicioTiendaTelmex paginaDeInicio;

	@Managed(driver = "chrome")
	WebDriver suNavegador;
	

	@Given("^Adrian abrio el navegador web$")
	public void adrianAbrioElNavegadorWeb() throws Exception {
		adrian.can(BrowseTheWeb.with(suNavegador));
		suNavegador.manage().window().maximize();
	}

	@Given("^Adrian entro a la pagina de la Tienda Telmex$")
	public void adrianEntroALaPaginaDeLaTiendaTelmex() throws Exception {
		adrian.wasAbleTo(EntrarATiendaTelmex.En(paginaDeInicio));
	}

	@When("^el busca los siguientes articulos y agrega una al carrito de compras$")
	public void elBuscaLosSiguientesArticulosYAgregaUnaAlCarritoDeCompras(List<Articulos> articulo) throws Exception {
		try {
		adrian.attemptsTo(BuscarArticulos.buscar(articulo));
		adrian.attemptsTo(ClickEnBotonComprar.boton());
		adrian.attemptsTo(BotonSiguiente.comprar());
		}catch(Exception e) {
		adrian.attemptsTo(BuscarArticulos.buscar(articulo));
		}

	}

	@Then("^el valida que Tienda Telmex solicite iniciar sesion para comprar$")
	public void elValidaQueTiendaTelmexSoliciteIniciarSesionParaComprar() throws Exception {
		try {
		adrian.should(seeThat(EnMiTelmex.iniciarSesion(), equalTo("Inicia sesión en Mi Telmex"))
				.orComplainWith(ConexionNoDisponible.class, ConexionNoDisponible.getconexionNoDisponible()));
		}catch(Exception e) {
		adrian.should(seeThat(EnPaginaDeInicio.elementoNoEncontrado(), equalTo("Lo sentimos,")));
		}
			
		}
	
}
