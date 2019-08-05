package utilidadesOracle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpectedCondition {
	
	public static WebDriverWait explicitWait(WebDriver driver,String dato) {
		WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(dato)));
		return wait;	
	}
}
