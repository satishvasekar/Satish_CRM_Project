package com.crm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.NoSuchElementException;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestNGMethod;

import com.crm.base.TestBase;

public class TestUtility extends TestBase {

	public void SwicthTo() {
		driver.switchTo().frame("mainpanel");
	}

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	static String TESTDATA_SHEET_PATH = "C:\\Users\\Satish\\Desktop\\CRMPRO(POM).xlsx";

	// Fecthing data from the Excel Sheet
	public static Object[][] getTestData(String sheetname) throws InvalidFormatException {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (IllegalFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(1).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	// Selecting the Contact From the Contacts page Dynamic Table
	public void SelectContact1(String contactName) {
		// *[@id="vContactsForm"]/table/tbody/tr[8]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[4]/td[2]

		String beforeXpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		String afterXpath = "]/td[2]/a";

		for (int i = 4; i <= 9; i++) {
			String str = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			System.out.println(str);
			if (str.equalsIgnoreCase(contactName)) {
				// *[@id="vContactsForm"]/table/tbody/tr[9]/td[1]/input
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[" + i + "]/td[1]/input")).click();

			}

		}
	}
	
	
	// Selecting the Date From the Calender 
	public void SelectDate(String date1){
		String date2 = date1;
		String arr[] = date2.split("-");
		String day = arr[0];
		String month = arr[1];
		//String year = arr[2];
		
		WebElement w1 = driver.findElement(By.xpath("//select[@name='slctMonth']"));
		WebElement w2 = driver.findElement(By.xpath("//select[@name='slctYear']"));
		
		Select s1 = new Select(w1);
		s1.selectByVisibleText(month);
		
		
		/*driver.navigate().refresh();
		Select s2 = new Select(w2);
		s2.selectByVisibleText(year);

		*/
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]
		
		String beforepath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterpath = "]/td[";
		
		 final int weakDays = 7;
		 
		 boolean flag = false;
		 String dayValue = null;
		 for(int rowNum=2;rowNum<=7;rowNum++){
			 for(int collNum=1;collNum<=weakDays;collNum++){
				try{ 
			    dayValue = driver.findElement(By.xpath(beforepath+rowNum+afterpath+collNum+"]")).getText();
				}catch(Exception e){
					System.out.println("Please enter correct date");
					flag =false;
					break;
				}
				System.out.println(dayValue);
				if(dayValue.equals(day)){
					driver.findElement(By.xpath(beforepath+rowNum+afterpath+collNum+"]")).click();
					flag = true;
					break;
				}
				
			 }
			 if(flag){
				 break;
			 }
		 }				 		
	}
	
	// Taking the screeenShots of the failed test cases 
	public static void ScreenShot(ITestNGMethod iTestNGMethod) throws IOException{
		//take screenShot 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Store the screenShot 
		FileUtils.copyFile(src, new File("D:\\Satish Softaware Backup\\Eclipse Worspace\\Satish_FreeCRM_Project_POM\\ScreenShots\\"+iTestNGMethod+".jpg"));
	}

}
