package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class MiCuentaPage extends ClaseBase {

	public MiCuentaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//centralizar los localizadores
		By locatorQuieroRegistrame = By.xpath("//a[contains(text(),'Quiero registrarme')]");
		
		//login cliente 06
		By locatorLoginCliente = By.xpath("//input[@id='customerEmail']");
		By locatorBtnInicioSesion = By.xpath("/html[1]/body[1]/div[1]/div[4]/wlm[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]");
		By locatorMjeErrorCliente = By.xpath("//p[contains(text(),'Necesita registrarse para una nueva cuenta.')]");
	
		public void formulariologin(String mailLogin) {//06
			agregarTexto(esperaExplicita(locatorLoginCliente),mailLogin);
			esperarXSegundos(3000);
			click(locatorBtnInicioSesion);
			
		}
	
		public String mensajeErrorLogin06() {//06
			esperarXSegundos(3000);
			return obtenerTexto(locatorMjeErrorCliente);
		}
	
		public void irAQuieroRegistrame () {
			if (estaHabilitado(locatorQuieroRegistrame)) {
				click(locatorQuieroRegistrame);
			}
		}
	
		
		
}
