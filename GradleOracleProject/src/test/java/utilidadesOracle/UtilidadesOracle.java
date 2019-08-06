package utilidadesOracle;

import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class UtilidadesOracle {
	
	final static String rutaControlador = "C:\\Selenium\\BrowersDrivers\\chromedriver.exe";
	final static String rutaPantallazo = "C:\\Selenium\\ScreenShots\\EvidenciasTiendaTelmexExcel\\";
	final static String rutaVideo = "C:\\Selenium\\ScriptVideos\\EvidenciasTiendaTelmexExcel\\";
	final static String rutaArchivo = "C:\\Selenium\\archivo\\ArticulosDeBusqueda.xls";
	final static String urlDatabase = "jdbc:oracle:thin:@localhost:1521:orcl";
	final static String userDatabase = "SYSTEM";
	final static String passwordDatabase = "2568854Cool";
	final static String url = "https://tienda.telmex.com/";
	final static String variableEntorno = "webdriver.chrome.driver";
	final static int tiempo = 15;
	final static By campoDeBusqueda = By.name("query");
	final static By botonDeBusqueda = By.xpath("//input[@id='botonbuscar1']");
	
	public static WebDriver adrian;
	
	static ATUTestRecorder video;
	static Date fecha;
	static DateFormat formatoFecha;
	static Connection conexion;
	
	private final static String SELECT_CANTIDAD_DE_REGISTROS = "SELECT COUNT(*) FROM datos_tienda_telmex";
	private final static String SELECT_DATOS_A_BUSCAR =
			"SELECT articulo FROM datos_tienda_telmex WHERE id_articulo = %d";
	private final static String UPDATE_RESULTADO_OBTENIDO =
			"UPDATE datos_tienda_telmex SET resultado_obtenido = '%s' WHERE id_articulo = %d";
	
	static Query query;
	static Sql2o sql2o;
	
	/**
	 * Metodo para crear el controlador y abrir el navegador.
	 * 
	 * @throws IOException 
	 */
	public static void abrirNavegador() {
		System.setProperty(variableEntorno, rutaControlador);
		adrian = new ChromeDriver();
		adrian.manage().window().maximize();
		adrian.get(url);
		esperar(tiempo);
	}
	
	/**
	 * Metodo para crear la conexion con la base de datos
	 * 
	 * @throws IOException
	 */
	public static void crearConexionConLaBD() throws IOException {
		sql2o = new Sql2o(urlDatabase, userDatabase, passwordDatabase);
	}
	
	/**
	 * Metodo para ejecutar las acciones y actualizar la base de datos
	 * 
	 * @throws IOException 
	 */
	public static void realizarBusquedaDeArticulos() throws IOException {
		conexion = sql2o.open();
		int cantidadDeRegistros = getItemsCount();
		for (int i = 1; i <= cantidadDeRegistros; i++) {
			query = conexion.createQuery(formatString(SELECT_DATOS_A_BUSCAR, i));
			String articulo = query.executeAndFetchFirst(String.class);
			escribirEnElCampoDeBusqueda(articulo);
			try {
				tomarPantallazo();
				ExpectedCondition.explicitWait(adrian, articulo);
				conexion.createQuery(formatString(UPDATE_RESULTADO_OBTENIDO, "Encontrado", i)).executeUpdate();
			} catch (RuntimeException e) {
				tomarPantallazo();
				conexion.createQuery(formatString(UPDATE_RESULTADO_OBTENIDO, "No Encontrado", i)).executeUpdate();
			}
		}
	}
	
	/**
	 * Metodo para cerrar la conexion con la base de datos
	 * 
	 * @throws IOException
	 */
	public static void cerrarConexionConLaBD() throws IOException {
		if (conexion != null) {
			conexion.close();
			conexion = null;
		}
	}

	/**
	 * Metodo para escribir en la barra de busqueda.
	 * 
	 * @param textoParaBuscar
	 */
	public static void escribirEnElCampoDeBusqueda(String dato) {
		 adrian.findElement(campoDeBusqueda).sendKeys(dato);
		 adrian.findElement(botonDeBusqueda).submit();
		 esperar(tiempo);
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
		File scrFile4 = ((TakesScreenshot)adrian).getScreenshotAs(OutputType.FILE); 
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
		adrian.quit();
	}
	
	/**
	 * Assert para verificar que el controlador no sea nulo
	 */
	public static void verificarControladorNoSeaNulo() {
		assertNotNull("La instanciación no puede ser nula", adrian);
	}
	
	/**
	 * Assert para verificar que el la fecha no sea nula
	 */
	public static void verificarNotNullFecha() {
	    assertNotNull("La variable 'date', no puede ser nula", fecha);
	}

	/**
	 * Metodo para las esperas implicitas (implicitlyWait)
	 * 
	 * @param segundos
	 */
	private static void esperar(int segundos) {
		adrian.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
	}
	
	private static Date tomarFecha() {
		Date date = new Date();
		return date;
	}
	
	private static DateFormat formatoFecha() {
		DateFormat formato = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		return formato;
	}
	
	private static String formatString(String text, Object... variables) {
		return String.format(text, variables);
	}
	/**
	 * Metodo para 
	 * @return
	 */
	private static Integer getItemsCount(){
	    try (Connection con = sql2o.open()) {
	    	int cantidad = con.createQuery(SELECT_CANTIDAD_DE_REGISTROS).executeScalar(Integer.class);
	    	con.close();
	        return cantidad;
	    }
	}
	
}
