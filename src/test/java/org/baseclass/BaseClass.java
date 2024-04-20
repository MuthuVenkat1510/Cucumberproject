package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert alt;
	public static JavascriptExecutor js;
	public static TakesScreenshot tk;
	public static Select s;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void toMaximize() {
		driver.manage().window().maximize();


	}

	public static void toTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static String toCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;
	}

	public static void fillText(WebElement element, String userText) {
		element.sendKeys(userText);
	}

	public static void toClick(WebElement element) {
		element.click();
	}

	public static void toQuit() {
		driver.quit();
	}

	public static void tonavgiateforward() {
		driver.navigate().forward();
	}

	public static void tonavigatebackward() {
		driver.navigate().back();

	}

	public static void torefresh() {
		driver.navigate().refresh();
	}

	public static void togettxt(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}

	public static String togetattributevalue(WebElement element) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	public static void toPerformMoveToElement(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public static void toPerormDragAndDrop(WebElement source, WebElement target) {
		a.dragAndDrop(source, target).perform();

	}

	public static void toPerformDoubleClick(WebElement element) {
		a.doubleClick(element).perform();
	}

	public static void toPerormContextClick(WebElement element) {
		a.contextClick(element).perform();
	}

	public static void toPerformEnter() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void toPerformTab() {
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	public static void toSleep(long sec) throws InterruptedException {
		Thread.sleep(sec);

	}

	public static void toAcceptAlert() {
		alt = driver.switchTo().alert();
		alt.accept();
	}

	public static void toDismissAlert() {
		alt.dismiss();
	}

	public static void toSendKeysAlert(String value) {
		alt.sendKeys(value);
	}

	public static void toGetText() {
		alt.getText();
	}

	public static void toFillByJavaScriptExc(WebElement element, String txt) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arugments[0].Setattribute('vaue','txt')", element);

	}

	public static void toClickByJavaSCript(WebElement element) {
		js.executeScript("arguments[0].click()", element);

	}

	public static void toScrollDown(WebElement element) {
		js.executeScript("arguments[0].scrollIntoview(true)", element);
	}

	public static void toScrollUp(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(flase)", element);

	}

	public static void toTakeScreenShot(String filepath) throws IOException {
		tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File de = new File("filepath");
		FileUtils.copyFile(src, de);
	}

	public static void toSelectByIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}

	public static String excelRead(int rowNo, int cellNo) throws IOException {
		File f = new File("DataExcel\\LoginCredential.xlsx");
		FileInputStream data = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(data);
		Sheet sh = book.getSheet("sheet1");

		Row row = sh.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		String value = "";
		if (cellType == 1) {
			value = cell.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-mmm-yyyy");
			value = sim.format(dateCellValue);

		} else {
			double dd = cell.getNumericCellValue();
			long l = (long) dd;
			value = String.valueOf(l);

		}
		return value;
	}

	public static void writeexcel(String filepath, String sheetname, int row, int cell, String value)
			throws IOException {
		File f = new File(filepath);
		FileInputStream file = new FileInputStream(f);

		Workbook book = new XSSFWorkbook(file);
		Sheet sh = book.getSheet(sheetname);
		Row r = sh.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		FileOutputStream files = new FileOutputStream(f);
		book.write(files);
		System.out.println("done");
	}

}
