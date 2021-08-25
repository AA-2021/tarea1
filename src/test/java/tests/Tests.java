package tests;

import static org.testng.Assert.assertEquals;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MiCuentaPage;
import pages.QuieroRegistramePage;
import utilidades.DataDriven;

public class Tests {
	//definir atributos
	private WebDriver driver;
	
	private HomePage homePage;
	private MiCuentaPage micuentaPage;
	private QuieroRegistramePage quieroregistrarmePage;
	private DataDriven data;
	private ArrayList<String> datosCP; 
	
	
	@BeforeMethod
	public void prepararSitio() {
	homePage.maximizarBrowser();
	homePage.cargarSitio("https://kitchencenter.cl/");
		
	}
	
	
	@BeforeTest //antes de ejecutar las pruebas se carga el driver
	public void before() {

		String navegador = "chrome";
		String rutaDriver = Paths.get(System.getProperty("user.dir"),"src\\test\\resources\\drivers\\chromedriver.exe").toString();
		String propertydriver = "webdriver.chrome.driver";
		
		homePage = new HomePage(driver);
		
		data = new DataDriven();
		
		homePage.conexionDriver(navegador, rutaDriver, propertydriver);
		
		micuentaPage = new MiCuentaPage(homePage.getDriver());
		
		quieroregistrarmePage = new QuieroRegistramePage(micuentaPage.getDriver());
			
		
	}
	
	
	@AfterTest
	public void after() {
	}
	


	@Test
	public void cp01() throws IOException {
		homePage.irAMiCuenta();
		micuentaPage.irAQuieroRegistrame();
		datosCP = data.getData("cp01");
		quieroregistrarmePage.completarFormulario
			(datosCP.get(1),datosCP.get(2),datosCP.get(3),datosCP.get(4),datosCP.get(5),datosCP.get(6),datosCP.get(7));
		
		assertEquals(quieroregistrarmePage.mjeErrorErrorNoIngresaDatos01(),datosCP.get(8));
	}

	
	@Test
	public void cp02() throws IOException {
		homePage.irAMiCuenta();
		micuentaPage.irAQuieroRegistrame();
		datosCP = data.getData("cp02");
		quieroregistrarmePage.completarFormulario
			(datosCP.get(1),datosCP.get(2),datosCP.get(3),datosCP.get(4),datosCP.get(5),datosCP.get(6),datosCP.get(7));
		
		assertEquals(quieroregistrarmePage.mjeErrorNombreBlanco02(), datosCP.get(8));
	}


	
	@Test
	public void cp03() throws IOException {
		homePage.irAMiCuenta();
		micuentaPage.irAQuieroRegistrame();
		datosCP = data.getData("cp03");
		quieroregistrarmePage.completarFormulario
			(datosCP.get(1),datosCP.get(2),datosCP.get(3),datosCP.get(4),datosCP.get(5),datosCP.get(6),datosCP.get(7));
		
		assertEquals(quieroregistrarmePage.mjeErrorConfirmaNvaPass03(), datosCP.get(8));
	}

	
	
	@Test


	public void cp04() throws IOException {
		homePage.irAMiCuenta();
		micuentaPage.irAQuieroRegistrame();
		datosCP = data.getData("cp04");
		quieroregistrarmePage.completarFormulario
			(datosCP.get(1), datosCP.get(2), datosCP.get(3), datosCP.get(4), datosCP.get(5), datosCP.get(6), datosCP.get(7));
		
		assertEquals(quieroregistrarmePage.mjeErrorConfirmaPass04(), datosCP.get(8));
	}

	
	@Test
	public void cp05() throws IOException {
		homePage.irAMiCuenta();
		micuentaPage.irAQuieroRegistrame();
		datosCP = data.getData("cp05");
		quieroregistrarmePage.completarFormulario
			(datosCP.get(1),datosCP.get(2),datosCP.get(3),datosCP.get(4),datosCP.get(5),datosCP.get(6),datosCP.get(7));
		
		assertEquals(quieroregistrarmePage.mensajeErrorEMail05(), datosCP.get(8));
	}

	
	@Test
	public void cp06() throws IOException {
		homePage.irAMiCuenta();
		datosCP = data.getData("cp06");
		micuentaPage.formulariologin(datosCP.get(1));

		assertEquals(micuentaPage.mensajeErrorLogin06(), datosCP.get(2));
	}


	@Test
	public void cp07() throws IOException {
		homePage.irAMiCuenta();
		micuentaPage.irAQuieroRegistrame();
		datosCP = data.getData("cp07");
		quieroregistrarmePage.completarFormulario
			(datosCP.get(1),datosCP.get(2),datosCP.get(3),datosCP.get(4),datosCP.get(5),datosCP.get(6),datosCP.get(7));
		
		assertEquals(quieroregistrarmePage.mjeErrorApellidoEnBlanco07(), datosCP.get(8));
	}
	
	@Test


	public void cp08() throws IOException {
		homePage.irAMiCuenta();
		micuentaPage.irAQuieroRegistrame();
		datosCP = data.getData("cp08");
		quieroregistrarmePage.completarFormulario
			(datosCP.get(1),datosCP.get(2),datosCP.get(3),datosCP.get(4),datosCP.get(5),datosCP.get(6),datosCP.get(7));
		
		assertEquals(quieroregistrarmePage.mjeErrorNuevaContrasenna08(), datosCP.get(8));
	}	
	
}
 