package com.qa.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PipeLines_BaseClass {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static WebDriverWait wait123;

	public static void intialization() throws IOException {

		FileInputStream readConfig = new FileInputStream(
				"\\Users\\a.b.ayesha\\eclipse-workspace\\ResolvePiplineError\\src\\main\\java\\com\\qa\\config\\config.properties"
						+ "");
		prop.load(readConfig);
		String BrowserName = prop.getProperty("Browser");
		System.out.println(BrowserName);

		switch (BrowserName) {

		case "Chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\a.b.ayesha\\Automation Code\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case ("IE"):

			System.setProperty("webdriver.Ie.driver",
					"C:\\Users\\a.b.ayesha\\Automation Code\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new InternetExplorerDriver();

			// initialize new WebDriver session
			break;
		case ("firefox"):
			// GeckoDriver
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\a.b.ayesha\\Automation Code\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();

			break;
		default:
			System.out.println("defalut");
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		driver.findElement(By.name("loginid")).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.id("signin")).click();
	}

}
