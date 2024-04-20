package org.baseclass;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

	

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Baseclassmam  {

		public static WebDriver driver;
		public static Actions a;
		public static Robot r;

		public static void openChromeBrowser() {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		public static void openEdgeBrowser() {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		public static void closeCurrentTab() {

			driver.close();
		}

		public static void closeBrowser() {

			driver.quit();
		}

		public static String fetchTitle() {

			String titleName = driver.getTitle();
			return titleName;
		}

		public static String fetchUrl() {

			String url = driver.getCurrentUrl();
			return url;
		}
		
		public int add(int a , int b) {
			
			int c=a+b;
			return c;
		}

		public static void maxWindow() {

			driver.manage().window().maximize();
		}

//		public static void minWindow() {
//
//			driver.manage().window().minimize();
//		}

		public static void toReload() {

			driver.navigate().refresh();
		}

		public static void launchUrl(String url) {

			driver.get(url);
		}

		public static void holdExecution(int timeInMillisecond) throws InterruptedException {

			Thread.sleep(timeInMillisecond);
		}

		public static void fillTextBox(WebElement element, String input) {

			element.sendKeys(input);
		}

		public static void toClickButton(WebElement element) {

			element.click();
		}

		public static void moveCursor(WebElement targetElement) {

			a = new Actions(driver);
			a.moveToElement(targetElement).perform();
		}

		public static void dragDrop(WebElement source, WebElement target) {

			a = new Actions(driver);
			a.dragAndDrop(source, target).perform();
		}

		public static void handleSimpleAlert() {

			Alert ac = driver.switchTo().alert();
			ac.accept();
		}

		public static void cancelConfirmAlert() {

			driver.switchTo().alert().dismiss();
		}

		public static void copy() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);

		}

		public static void paste() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);

		}

		public static void takeSnap(String picName) throws IOException {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File("C:\\Users\\Amirtha\\eclipse-workspace\\CucumberNewProj\\Screenshots\\"+ picName+ ".png");
			FileUtils.copyFile(src, des);
		}
		
		public static void applyImplicitWait(int time) {
		
	//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		}
		
		public static void getDateAndTime() {
			Date d = new Date();
			System.out.println(d);
		}
		
		public static void fillTextBoxUsingJs(WebElement element , String input) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','"+input+"')", element);
		}
}
