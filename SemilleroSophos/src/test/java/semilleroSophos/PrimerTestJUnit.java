package semilleroSophos;

//Todas las importaciones de librerias
import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class PrimerTestJUnit {
	
	//Declaración del WebDriver
	private WebDriver Mozilla;

	@Before
	public void setUp() throws Exception {
		
		//Crea el comando que controla el navegador **Cambia de acuerdo al navegador que se controle
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\BrowersDrivers\\geckodriver.exe");
		Mozilla = new FirefoxDriver();
		assertNotNull(" La instanciación del controlador no puede ser null", Mozilla);
		
	}
	@Test
	public void test() throws InterruptedException, ATUTestRecorderException, IOException {
		//fail("Not yet implemented");
				
		//Declaracion del Formato Fecha
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		assertNotNull(" La variable 'date', no puede ser nula", date);
		
		//Declaracion Test Recorder, Ruta de guardado y firmato de nombre del test video
		ATUTestRecorder recorder = new ATUTestRecorder("C:\\Selenium\\ScriptVideos\\EvidenciaAutoamtionFirefox","TestVideo-"+dateFormat.format(date),false);
		assertNotNull(" La variable 'recorder', no puede ser nula", recorder);
		recorder.start();	
		
		//Acceso a la pagina de busqueda
        Mozilla.get("https://www.google.com");
        Mozilla.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
           	//Toma primera imagen
        File scrFile1 = ((TakesScreenshot)Mozilla).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile1, new File("c:\\Selenium\\ScreenShots\\EvidenciaAutomationFireFox\\screenshot1 "+dateFormat.format(date)+".png"));
        
		//Escribe en la barra de busqueda el termino a buscar y clic en el boton de busqueda
        Mozilla.findElement(By.xpath("//input[@name='q']")).sendKeys("cine calidad");
        Mozilla.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click(); Thread.sleep(1000);
        Mozilla.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
           	//Toma Segunda imagen
        File scrFile2 = ((TakesScreenshot)Mozilla).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile2, new File("c:\\Selenium\\ScreenShots\\EvidenciaAutomationFireFox\\screenshot2 "+dateFormat.format(date)+".png"));
		
		//Ingresa a la primera pagina del resultado, Escribe en el buscador de la pagina encontrada y da Enter
        Mozilla.findElement(By.xpath("//h3[contains(text(),'Cinecalidad - Películas online y descarga gratis e')]")).click();
        Mozilla.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Mozilla.findElement(By.xpath("//input[@placeholder='Buscar...']")).sendKeys("Avengers"); Thread.sleep(1000);
        Mozilla.findElement(By.xpath("//input[@placeholder='Buscar...']")).sendKeys(Keys.ENTER); Thread.sleep(1000);
        Mozilla.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                
        	//Toma tercera imagen
        File scrFile3 = ((TakesScreenshot)Mozilla).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile3, new File("c:\\Selenium\\ScreenShots\\EvidenciaAutomationFireFox\\screenshot3 "+dateFormat.format(date)+".png")); Thread.sleep(1000);
				
		//Clic en el primer resultado de la busqueda, 
        Mozilla.findElement(By.xpath("//body/div[@id='main_container']/div[@id='content']/div[@id='content_inside']/div[1]/a[1]/div[1]")).click();
        
    	   //Toma Cuarta imagen
        File scrFile4 = ((TakesScreenshot)Mozilla).getScreenshotAs(OutputType.FILE); 
        FileUtils.copyFile(scrFile4, new File("c:\\Selenium\\ScreenShots\\EvidenciaAutomationFireFox\\screenshot4 "+dateFormat.format(date)+".png"));  Thread.sleep(1000);
               
        //Detiene la grabacion
		recorder.stop();
	}
	
	@After
	public void tearDown() throws Exception {
		
		//Cierra el navegador
		Mozilla.quit();

		
	}

}
