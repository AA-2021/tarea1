 package utilidades;

//La clase Base define las funciones que se realizarán en las paginas.
//Las Paginas heredaran todos los metodos definos en la la clase base.
 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClaseBase {
	//atributos
	protected WebDriver driver;
	protected WebDriverWait espera;
	
	//Métodos
	public ClaseBase(WebDriver driver) {
		this.driver = driver;
	}
	

	//getters and setters
	public WebDriverWait getEspera() {
		return espera;
	}
	public void setEspera(WebDriverWait espera) {
		this.espera = espera;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;

	}

	//encapsular los elementos
	//buscar un elemento 
	public WebElement buscarElementoWeb(By localizador) {
		return this.driver.findElement(localizador);
	}
	
	public List<WebElement> buscarElementosWeb(By localizador){
		return this.driver.findElements(localizador);
	}
	
	
	//Obteber texto de una pagina NOTA: (ambos metodos hacen lo mismo pero utilizan parametros ditintos)
	public String obtenerTexto(By localizador) {
		return this.driver.findElement(localizador).getText();
	}
	
	public String obtenerTexto(WebElement elemento) {
		return elemento.getText();
	}
	
	
	//Agregar texto a la pagina 
	public void agregarTexto(By localizador, String mensaje) {
		this.driver.findElement(localizador).sendKeys(mensaje);
	}
	
	public void agregarTexto(WebElement elemento,String mensaje) {
		elemento.sendKeys(mensaje);
	}
	
	
	//presionar botón en la pagina
	public void click(By localizador) {
		this.driver.findElement(localizador).click();
	}
	

	public void click(WebElement elemento) {
		elemento.click();
	}
	
	
	public void cargarSitio(String url) {
		this.driver.get(url);
	}
	
	public void maximizarBrowser() {
		this.driver.manage().window().maximize();
	}
	
	public void cerrarBrowser() {
		this.driver.close();
	}
	
	public WebDriver conexionDriver(String browser, String ruta, String propertyDriver) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty(propertyDriver,ruta);	
			this.driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(propertyDriver,ruta);	
			this.driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty(propertyDriver,ruta);	
			this.driver = new InternetExplorerDriver();
		}
		return driver;
				
	}
	
	
	public boolean estaDesplegado(By localizador) {
		try { //try catch captura el error evitando que recaiga y retornando false 
			return this.driver.findElement(localizador).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean estaSeleccionado(By localizador) {
		try {
			return this.driver.findElement(localizador).isSelected();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean estaHabilitado(By localizador) {
		try {
			return this.driver.findElement(localizador).isEnabled();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	//espera fija implica esperar el tiempo definido en el parametro de entrada
	public void esperarXSegundos(int milisegundos) {
		
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//espera explicita implica que espera hasta 30 seg que se active el elemento web o antes si se localiza. 
	public WebElement esperaExplicita(By localizador) {
		espera = new WebDriverWait(this.driver,30);
		
		return espera.until(ExpectedConditions.
				presenceOfElementLocated(localizador));
	}
	
	
}
