package utilidadesExcel;

import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import tiendaTelmexExcelTest.Excel;
import tiendaTelmexExcelTest.ExpectedCondition;

public class UtilidadesExcel {
	
	final static String rutaControlador = "C:\\Selenium\\BrowersDrivers\\chromedriver.exe";
	final static String rutaPantallazo = "C:\\Selenium\\ScreenShots\\EvidenciasTiendaTelmexExcel\\";
	final static String rutaVideo = "C:\\Selenium\\ScriptVideos\\EvidenciasTiendaTelmexExcel\\";
	final static String rutaArchivo = "C:\\Selenium\\archivo\\ArticulosDeBusqueda.xls";
	final static int tiempo = 15;
	final static String url = "https://tienda.telmex.com/";
	final static String variableEntorno = "webdriver.chrome.driver";
	final static By campoDeBusqueda = By.name("query");
	final static By botonDeBusqueda = By.xpath("//input[@id='botonbuscar1']");
		
	public static WebDriver adrian;
	public static FileInputStream inputStream;
	public static Workbook workbook;
	public static FileOutputStream outputStream;
	public static File archivoExcel;
	public static Excel operaciones;
	public static ArrayList<String> datos;
	static ATUTestRecorder video;
	static Date fecha;
	static DateFormat formatoFecha;
	
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
	 * Metodo para leer y extraer los datos del arichivo Excel
	 * 
	 * @throws IOException
	 */
	public static void leerDatosTablaExcel() throws IOException {
		archivoExcel = new File(rutaArchivo);
		inputStream = new FileInputStream(archivoExcel);
		POIFSFileSystem FileSystem = new POIFSFileSystem(inputStream);
		workbook = new HSSFWorkbook(FileSystem);
		operaciones = new Excel(workbook.getSheetAt(0));
		datos = (ArrayList<String>) operaciones.listExcelData();
	}
	
	/**
	 * Metodo para recorrer y buscar los elementos descritos en el archivo Excel
	 * 
	 * @throws IOException 
	 */
	public static void realizarBusquedaDeArticulos() throws IOException {
		for (int i = 1; i < operaciones.getRows() + 1; i++) {
			String dato = datos.get(i);
			escribirEnElCampoDeBusqueda(dato);
			try {
				tomarPantallazo();
				ExpectedCondition.explicitWait(adrian, dato);
				operaciones.writeExcel(operaciones.getSheet().getRow(i), "Encontrado");		
			} catch (RuntimeException e) {
				tomarPantallazo();
				operaciones.writeExcel(operaciones.getSheet().getRow(i), "No Encontrado");
			}
		}
	}
	
	/**
	 * Metodo para cerrar reporte de resultados obtenidos de la busqueda de los elementos en el archivo Excel
	 * 
	 * @throws IOException
	 */
	public static void generarReporteEnArchivoDeBusquedaExcel() throws IOException {
		inputStream.close();
		outputStream = new FileOutputStream(archivoExcel);
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
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
	
}