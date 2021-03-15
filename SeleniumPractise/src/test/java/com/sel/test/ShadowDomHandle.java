package com.sel.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomHandle {

	@Test
	public void shadowTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http://sandbox-sponsors.pointsville.com/");
		Thread.sleep(3000);
	
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
		WebElement usernameTxtBx = (WebElement)jse.executeScript("return document.querySelector(\"amplify-authenticator > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\").shadowRoot.querySelector(\"div > amplify-username-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#username\")");
		WebElement passwordTxtBx = (WebElement)jse.executeScript("return document.querySelector(\"amplify-authenticator > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\").shadowRoot.querySelector(\"div > amplify-password-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#password\")");
		
		String js="arguments[0].setAttribute('value','admin')";
		String js2="arguments[0].setAttribute('value','manager')";
		
		jse.executeScript(js, usernameTxtBx);
		jse.executeScript(js2, passwordTxtBx);
		
		
	}
}
