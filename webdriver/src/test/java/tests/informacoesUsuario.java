package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;




public class informacoesUsuario {
	private WebDriver navegador;
	
	@Before
	public void setUp() {
		//Abrindo o navegador
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			
	    navegador = new FirefoxDriver();
	    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		navegador.get("http://www.juliodelima.com.br/taskit/"); 
		
		//clicar no link que possui o texto "Sing in"
		navegador.findElement(By.linkText("Sign in")).click();
		
		//Indetificando o formulario do login
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
		
		//Digitar no campo com nome "login" que esta dentro do formulario de id "signinbox" o texto "julio001"
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
		
		//Digitar no campo com nome "password" que esta dentro do formulario de id "signinbox" o texto "123456"
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		
		//clicar no link com o texto "SING IN"
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		//clicar em um link que possui a class "me"
		navegador.findElement(By.className("me")).click();
		
		//clicar em um link que possui o texto "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
	}
	
	 @Test
	 public void testAdicionarUmaInformacaoDoUsuario() {
		//Abrindo o navegador
		 
		//clicar no link que possui o texto "Sing in"
		//navegador.findElement(By.linkText("Sign in")).click();
		
		//Indetificando o formulario do login
		//WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
		
		//Digitar no campo com nome "login" que esta dentro do formulario de id "signinbox" o texto "julio001"
		//formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
		
		//Digitar no campo com nome "password" que esta dentro do formulario de id "signinbox" o texto "123456"
		//formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		
		//clicar no link com o texto "SING IN"
		//navegador.findElement(By.linkText("SIGN IN")).click();
		
		//clicar em um link que possui a class "me"
		//navegador.findElement(By.className("me")).click();
		
		//clicar em um link que possui o texto "MORE DATA ABOUT YOU"
		//navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
		//Clicar no botao atraves do seu xpath //button{@data-target="addmoredata"}
		navegador.findElement(By.xpath("//Button[@data-target=\"addmoredata\"]")).click();
		
		//Identificar o popup onde esta o formulario de id addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		
		//NO combo de name "type" escolhe a opcao "phone"
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
	    new Select(campoType).selectByVisibleText("Phone");
		
		//No combo de name  "contact" digitar "+5511999999999"
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511999999999");
		
		//Clicar no link do text "SAVE" que esta o popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		
		//Na mensagem de id "toast-container" validar qoe o texto é "Your contact has been added!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Your contact has been added!", mensagem);
		
		
		
		//Validar que dentro do elemento com class "me" esta o texto "Hi, Julio"
		WebElement me = navegador.findElement(By.className("me"));
		String textoNoElementoMe = me.getText();
		assertEquals("Hi, Julio", textoNoElementoMe);
		
		
		
      }
	
	@Test
	public void removerUmContatoDeUsuario() {
		//Clicar no elemento pelo seu xpath //span[text()="+551133334444"]/following-sibling::a
		navegador.findElement(By.xpath("//span[text()=\"+5511999999999\"]/following-sibling::a")).click();
		
		//Confirmar a janela javascript
		navegador.switchTo().alert().accept();
		
		//Validar que a mensagem apresentada foi Rest in peace,dear phone!
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);
		
		//String arquivo;
		Screenshot.tirar(navegador, "/Users/flavi/print01/foto/" + Generator.dataHoraParaArquivo() + " removerUmContatoDeUsuario.png");
		
		//Aguardar ate 10 segundos para que a janela desapareça
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		
		//Clicar no link com texto "logout"
		navegador.findElement(By.linkText("Logout")).click();
		
		

	}
	
	@After
	public void tearDown() {
		// fechar navegador
		navegador.close();

	}

}
