package com.alex.ponto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Marcacao {

	public static void main(String[] args) {
		
		try {
		final String usrRede = "re000000";
		final String senhaRede = "000000";
		
		final String usrPonto = "000000";
		final String senhaPonto = "000000";

    	//System.setProperty("webdriver.firefox.marionette","\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver","\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
        String baseUrl = "https://"+usrRede+":"+senhaRede+"@webponto.resource.com.br/";

        driver.get(baseUrl);
        
        driver.findElement(By.xpath("//*[@id=\"CodEmpresa\"]")).sendKeys("9");
        driver.findElement(By.xpath("//*[@id=\"requiredusuario\"]")).sendKeys(usrPonto);
        driver.findElement(By.xpath("//*[@id=\"requiredsenha\"]")).sendKeys(senhaPonto);
        driver.findElement(By.name("Submit")).click();
        
        driver.findElement(By.xpath("//*[@id=\"menu2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu2_Item2\"]/a")).click();
        
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        driver.findElement(By.name("Submit1")).click();
        //driver.findElement(By.name("Submit2")).click();
        
        //driver.switchTo().window(allWindows[0].toString());
        
        //driver.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
        
    }
	
}
