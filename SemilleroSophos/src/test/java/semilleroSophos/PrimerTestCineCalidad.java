package semilleroSophos;

//Todas las importaciones de librerias
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.concurrent.TimeUnit;
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


public class PrimerTestCineCalidad {
		

	public static void main(String[] args) throws ATUTestRecorderException, IOException, InterruptedException {

		//Declaracion del Formato Fecha
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		
		//Declaracion Test Recorder, Ruta de guardado y firmato de nombre del test video
		ATUTestRecorder recorder = new ATUTestRecorder("C:\\Selenium\\ScriptVideos\\EvidenciaAutoamtionFirefox","TestVideo-"+dateFormat.format(date),false);
		
		// Metodo para inicar la grabacion
		recorder.start();
		
		//Declaracion WebDriver y ruta del controlador
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\BrowersDrivers\\geckodriver.exe");
		WebDriver Mozilla = new FirefoxDriver();
		
		//Acceso a la pagina de busqueda
        Mozilla.get("https://www.google.com");
        Mozilla.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        	//Toma primera imagen
        File scrFile1 = ((TakesScreenshot)Mozilla).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile1, new File("c:\\Selenium\\ScreenShots\\EvidenciaAutomationFireFox\\screenshot1 "+dateFormat.format(date)+".png"));
        
		//Escribe en la barra de busqueda el termino a buscar y clic en Buscar
        Mozilla.findElement(By.xpath("//input[@name='q']")).sendKeys("cine calidad");
        Mozilla.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click(); Thread.sleep(1000);
        Mozilla.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
           	//Toma Segunda imagen
        File scrFile2 = ((TakesScreenshot)Mozilla).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile2, new File("c:\\Selenium\\ScreenShots\\EvidenciaAutomationFireFox\\screenshot2 "+dateFormat.format(date)+".png"));
		
		//Ingresa a la primera pagina del resultado de busqueda, Escribe en el buscador de la pagina anterior y da Enter
        Mozilla.findElement(By.xpath("//h3[contains(text(),'Cinecalidad - Películas online y descarga gratis e')]")).click();
        Mozilla.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Mozilla.findElement(By.xpath("//input[@placeholder='Buscar...']")).sendKeys("Avengers"); Thread.sleep(1000);
        Mozilla.findElement(By.xpath("//input[@placeholder='Buscar...']")).sendKeys(Keys.ENTER); Thread.sleep(2000);
        Mozilla.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                
        	//Toma tercera imagen
        File scrFile3 = ((TakesScreenshot)Mozilla).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile3, new File("c:\\Selenium\\ScreenShots\\EvidenciaAutomationFireFox\\screenshot3 "+dateFormat.format(date)+".png")); Thread.sleep(2000);
				
		//Clic en el primer resultado de la busqueda, 
        Mozilla.findElement(By.xpath("//body/div[@id='main_container']/div[@id='content']/div[@id='content_inside']/div[1]/a[1]/div[1]")).click();
        
    	   //Toma Cuarta imagen
        File scrFile4 = ((TakesScreenshot)Mozilla).getScreenshotAs(OutputType.FILE); 
        FileUtils.copyFile(scrFile4, new File("c:\\Selenium\\ScreenShots\\EvidenciaAutomationFireFox\\screenshot4 "+dateFormat.format(date)+".png"));  Thread.sleep(2000);
               
        //Cierra el navegador y Detiene la grabacion
        Mozilla.quit();
        recorder.stop();

	}
}

