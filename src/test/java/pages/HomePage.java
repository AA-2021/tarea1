package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class HomePage extends ClaseBase {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//centralizar los localizadores
	By locatorMICuenta = By.xpath("//span[contains(text(),'mi cuenta')]");
	
	public void irAMiCuenta () {
		if (estaHabilitado(locatorMICuenta)) {
			esperarXSegundos(2000);
			click(locatorMICuenta);
		}
	}
	
	
}
