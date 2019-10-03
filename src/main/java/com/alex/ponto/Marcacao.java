package com.alex.ponto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Marcacao {

	public static void main(String[] args) {

		try {

			String usrRede = args[0];
			String senhaRede = args[1];

			String usrPonto = args[2];
			String senhaPonto = args[3];

			// System.setProperty("webdriver.firefox.marionette","\\geckodriver.exe");
			// WebDriver driver = new FirefoxDriver();

			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			String baseUrl = "https://" + usrRede + ":" + senhaRede + "@webponto.resource.com.br/";

			driver.get(baseUrl);

			driver.findElement(By.xpath("//*[@id=\"CodEmpresa\"]")).sendKeys("9");
			driver.findElement(By.xpath("//*[@id=\"requiredusuario\"]")).sendKeys(usrPonto);
			driver.findElement(By.xpath("//*[@id=\"requiredsenha\"]")).sendKeys(senhaPonto);
			driver.findElement(By.name("Submit")).click();

			driver.findElement(By.xpath("//*[@id=\"menu2\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"menu2_Item2\"]/a")).click();

			Object[] allWindows = driver.getWindowHandles().toArray();

			driver.switchTo().window(allWindows[1].toString());

			driver.findElement(By.xpath("//*[@id=\"Button1\"]")).click();
			driver.findElement(By.name("Submit22")).click();

			driver.switchTo().window(allWindows[0].toString());

			driver.close();

			BufferedWriter writer = new BufferedWriter(new FileWriter("./log-marcacao-ponto.txt", true));
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			writer.append(dt.format(new Date()) + " - Ponto Marcado");
			writer.newLine();

			writer.close();
		} catch (Exception e) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("./log-marcacao-ponto.txt", true));
				SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				writer.append(dt.format(new Date()));
				writer.append(" - " + e.getMessage());
				writer.newLine();

				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
