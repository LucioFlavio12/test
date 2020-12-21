package suporte;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Web {
	  public static final String AUTOMATE_USERNAME = "lucioflvio1";
	  public static final String AUTOMATE_ACCESS_KEY = "";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static WebDriver createGecko() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		
	    WebDriver navegador = new FirefoxDriver();
	    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		navegador.get("http://www.juliodelima.com.br/taskit/");
		return navegador; 
	}
	public static WebDriver createBrowserStack() {
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1920x1080");
	    caps.setCapability("browser", "Firefox");
	    caps.setCapability("browser_version", "latest-beta");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
	    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
	    
	    WebDriver navegador = null;
	    
	    try {
			 navegador = new RemoteWebDriver(new java.net.URL(URL), caps);
			navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			navegador.get("http://www.juliodelima.com.br/taskit/");
		} catch (MalformedURLException e) {
	       System.out.println("Houveram problemas com URL:" + e.getMessage());
			
		}
	    
	    
	   
	    return navegador ;
		
	}

}
