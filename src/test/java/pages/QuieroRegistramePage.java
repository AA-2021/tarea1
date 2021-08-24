package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class QuieroRegistramePage extends ClaseBase {

	public QuieroRegistramePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Lacator del formulario quiero registrarme
	By locatorNombre = By.xpath("//input[@id='customerFirstName']");
	By locatorApellido = By.cssSelector("#customerLastName");
	By locatorCelular = By.xpath("//input[@id='customerPhoneNumber']");
	By locatorRut = By.xpath("//input[@id='contactFormRut']");
	By locatorEmail = By.cssSelector("#registerCustomerEmail");
	By locatorPassword = By.cssSelector("#registerCustomerPassword");
	By locatorConfirmaPassword = By.cssSelector("#registerConfirmCustomerPassword");
	//locator boton del formulario quiero registrarme
	By locatorBtnRegistrarse = By.xpath("//body/div[@id='app']/div[4]/wlm[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/input[1]");
	
	//Mensajes de error
	By locatorErrormail = By.xpath("//li[contains(text(),'Email debe ser un email válido')]"); //05
	By locatorErrorConfirmaPass04 = By.xpath("//li[contains(text(),'Confirmación del Password no coincide')]");//04
	By locatorErrorNvaPassEnBlanco03 = By.xpath("//li[contains(text(),'Confirm Nueva contraseña no puede estar en blanco')]");//03
	By locatorErrorNombreBlanco02 = By.xpath("//li[contains(text(),'Nombre no puede estar en blanco')]");//02
	By locatorErrorNoIngresaDatos01 = By.xpath("//body/div[@id='app']/div[4]/wlm[1]/section[1]/div[1]/div[1]/div[1]/div[1]/h3[1]");//01
	By locatorErrorApellidoEnBlanco07 = By.xpath("//li[contains(text(),'Apellidos no puede estar en blanco')]");//07
	By locatorErrorNuevaContrasenna08 = By.xpath("//li[contains(text(),'Nueva contraseña no puede estar en blanco')]");
	
	public void completarFormulario 
		(String nombre, String apellido, String celular, String rut, String email, String pass, String confirmaPass) {

			agregarTexto(esperaExplicita(locatorNombre), nombre);
			agregarTexto(esperaExplicita(locatorApellido), apellido);
			agregarTexto(esperaExplicita(locatorCelular), celular);
			agregarTexto(esperaExplicita(locatorRut), rut);
			agregarTexto(esperaExplicita(locatorEmail), email);
			agregarTexto(esperaExplicita(locatorPassword), pass);
			agregarTexto(esperaExplicita(locatorConfirmaPassword), confirmaPass);
			//esperarXSegundos(3000);
			click(esperaExplicita(locatorBtnRegistrarse));
	}
		
		//metodo para obtener el mensaje de error esperado del formulario
		public String mensajeErrorEMail05() {//05
			esperarXSegundos(3000);
			return obtenerTexto(esperaExplicita(locatorErrormail));
		}
		
		public String mjeErrorConfirmaPass04() {//04
			esperarXSegundos(3000);
			return obtenerTexto(esperaExplicita(locatorErrorConfirmaPass04));
		}
		
		public String mjeErrorConfirmaNvaPass03() {//03
			esperarXSegundos(3000);
			return obtenerTexto(esperaExplicita(locatorErrorNvaPassEnBlanco03));
		}
		
		public String mjeErrorNombreBlanco02() {//02
			esperarXSegundos(3000);
			return obtenerTexto(esperaExplicita(locatorErrorNombreBlanco02));
		}
		
		public String mjeErrorErrorNoIngresaDatos01() {//01
			esperarXSegundos(3000);
			return obtenerTexto(esperaExplicita(locatorErrorNoIngresaDatos01));
		}

		public String mjeErrorApellidoEnBlanco07() {//07
			esperarXSegundos(3000);
			return obtenerTexto(esperaExplicita(locatorErrorApellidoEnBlanco07));
		}
		
		public String mjeErrorNuevaContrasenna08() {//08
			esperarXSegundos(3000);
			return obtenerTexto(esperaExplicita(locatorErrorNuevaContrasenna08));
		}

	}
	
	
	

