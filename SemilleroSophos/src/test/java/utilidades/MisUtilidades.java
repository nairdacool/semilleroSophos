package utilidades;

import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class MisUtilidades {
	
	static ATUTestRecorder video;
	static WebDriver Mozilla;
	static Date fecha;
	static DateFormat formatoFecha;
	
	final static String rutaControlador = "C:\\Selenium\\BrowersDrivers\\geckodriver.exe";
	final static String rutaPantallazo = "C:\\Selenium\\ScreenShots\\EvidenciaAutomationFireFox\\";
	final static String rutaVideo = "C:\\Selenium\\ScriptVideos\\EvidenciaVideoMetodos\\";
	final static int tiempo = 15;
	final static String url = "https://www.google.com";
	final static String variableEntorno = "webdriver.gecko.driver";
	final static By campoDeBusqueda = By.xpath("//input[@title='Buscar']");
	final static By botonDeBusqueda = By.xpath("(//input[@value='Buscar con Google'])[2]");
	final static By entrarAlResultado = By.xpath("//h3[contains(text(),'Cinecalidad - Películas')]");
	final static By campoBusquedaDeLaPagina = By.xpath("//input[contains(@placeholder,'Buscar')]");
	final static By seleccionPrimerResultado = By.xpath("//img[@title='Avengers: Infinity War (2018)']/parent::*");
	
	/**
	 * Metodo para crear el controlador y abrir el navegador.
	 */
	public static void abrirNavegador() {
		System.setProperty(variableEntorno, rutaControlador);
		Mozilla = new FirefoxDriver();
		//assertNotNull("La instanciación del controlador no puede ser nula", Mozilla);
		Mozilla.get(url);
		Mozilla.manage().window().maximize();
		esperar(tiempo);
	}
	
	/**
	 * Metodo para escribir en la barra de busqueda.
	 * 
	 * @param textoParaBuscar
	 */
	public static void escribirEnElCampoDeBusqueda(String textoParaBuscar) {
		 Mozilla.findElement(campoDeBusqueda).sendKeys(textoParaBuscar);
		 Mozilla.findElement(botonDeBusqueda).click();
		 esperar(tiempo);
	}
	
	/**
	 * Metodo para ingresar al primer resultado.
	 */
	public static void ingresarAlPrimerResultado() {
		Mozilla.findElement(entrarAlResultado).click();
		esperar(tiempo);
	}
	
	/**
	 * Metodo para buscar una pelicula.
	 * 
	 * @param peliculaParaBuscar
	 * @throws InterruptedException
	 */
	public static void buscarPelicula(String peliculaParaBuscar) throws InterruptedException {
		Mozilla.findElement(campoBusquedaDeLaPagina).sendKeys(peliculaParaBuscar);
        Mozilla.findElement(campoBusquedaDeLaPagina).sendKeys(Keys.ENTER);
        esperar(tiempo);Thread.sleep(1);
        Mozilla.findElement(seleccionPrimerResultado).click();
	}
	
	/**
	 * Metodo para tomar pantallazo.
	 * 
	 * @throws IOException
	 */
	public static void tomarPantallazo() throws IOException {
		formatoFecha = formatoFecha();
		fecha = tomarFecha();
		assertNotNull("La variable 'date', no puede ser nula", fecha);
		File scrFile4 = ((TakesScreenshot)Mozilla).getScreenshotAs(OutputType.FILE); 
        FileUtils.copyFile(scrFile4, new File(rutaPantallazo + "screenshot " + formatoFecha.format(fecha) + ".png"));
	}
	
	/**
	 * Metodo para iniciar la grabacion del test.
	 * 	
	 * @return video
	 * @throws ATUTestRecorderException
	 */
	public static void iniciarGrabacion() throws ATUTestRecorderException {
		formatoFecha = formatoFecha();
	    fecha = tomarFecha();
	    video = new ATUTestRecorder(rutaVideo,"TestVideo-" + formatoFecha.format(fecha),false);
	    video.start();	
	}
	
	/**	
	 * Metodo para detener la grabacion del test.
	 * 
	 * @param recorder
	 * @throws ATUTestRecorderException
	 */
	public static void detenerGrabacion() throws ATUTestRecorderException {
		video.stop();
	}

	/**
	 * Metodo para cerrar el controlador navegador.
	 */
	public static void cerrarNavegador() {
		Mozilla.quit();
	}
	
	/**
	 * Assert para verificar que el controlador no sea nulo
	 */
	public static void verificarNoNullControlador() {
		assertNotNull("La instanciación no puede ser nula", Mozilla);
	}
	/**
	 * Assert para verificar que el la fecha no sea nula
	 */
	public static void verificarNotNullFecha() {
	    assertNotNull("La variable 'date', no puede ser nula", fecha);
	}
	/**
	 * Metodo para las esperas implicitas (implicitlyWait)
	 * @param segundos
	 */
	private static void esperar(int segundos) {
		Mozilla.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
	}
	
	private static Date tomarFecha() {
		Date date = new Date();
		return date;
	}
	
	private static DateFormat formatoFecha() {
		DateFormat formato = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		return formato;
	}
	
}
