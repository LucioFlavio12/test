package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import suporte.Web;



public class informacoesUsuarioPageObjectsTests {
	 private WebDriver navegador;
	private String textoToast;

	@Before
	public void setUp () {
		navegador = Web.createGecko();

	}
		
	@Test
	 public void testAdicionarUmaInformacaoDoUsuario() {
		textoToast = new LoginPage(navegador)
		        .clickSignin()
		        .fazerLogin( "julio0001", "123456")
		        .clicarMe()
		        .clicarAbaMoreDataAboutYou()
		        .clicarBotaoAddMoreDataAboutYou()
		        .adicionarContato("Phone", "+551199998888")
		        .capturarTextoToast();
		
		assertEquals("Your contact has been added!", textoToast );
		        
		
	}

	@After
	public void tearDown() {
		// fechar navegador
	    navegador.close();
	}


}
  