package testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import commonfunction.JibeLogin;

public class Purchase extends JibeLogin {
	public static WebDriver driver;
	
	public void purchaseMenu(WebDriver driver1) throws Exception
	{
		WebDriver driver=driver1;
		Actions action= new Actions(driver);
		
		Thread.sleep(1000);
		
		WebElement menu= driver.findElement(By.linkText("Purchase"));   //purchase
		action.moveToElement(menu).build().perform();
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Create New Reqsn")).click();    // Create new Reqsn
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		Select dropdown1= new Select(driver.findElement(By.name("ctl00$MainContent$DDLFleet")));      // Fleet
		dropdown1.selectByVisibleText("Fleet-A");   //Select Fleet-A
		Thread.sleep(1000);
		
		Select dropdown2= new Select(driver.findElement(By.name("ctl00$MainContent$DDLVessel")));    //vessel
		dropdown2.selectByVisibleText("IMARA");
		Thread.sleep(1000);
		
//		WebElement radiobtn=driver.findElement(By.id("ctl00_MainContent_optList_0"));     // Department Type
//		radiobtn.click();
		
		Select dropdown3= new Select(driver.findElement(By.name("ctl00$MainContent$cmbDept")));     // Department
		dropdown3.selectByVisibleText("Bond Stores");
		Thread.sleep(1000);
		
		Select dropdown4=new Select(driver.findElement(By.id("ctl00_MainContent_rgdCatalog")));     // Catalogue
		dropdown4.selectByVisibleText("BLACK HOLE");
		Thread.sleep(1000);
		
		Select dropdown5= new Select(driver.findElement(By.id("ctl00_MainContent_cmbdivReqPrio")));       // Urgency
		dropdown5.selectByVisibleText("Normal");
		Thread.sleep(1000);
		
		Select dropdown6= new Select(driver.findElement(By.id("ctl00_MainContent_ddlReqsnType")));         //Reqsn Type
		dropdown6.selectByVisibleText("Dry Dock");
		Thread.sleep(1000);
		
		
		Select dropdown7= new Select(driver.findElement(By.id("ctl00_MainContent_cmbRequisitionList")));    // Requisition
		dropdown7.selectByVisibleText("16/01/2017 / JIBEAdmin / Normal");
		Thread.sleep(1000);
		
		driver.findElement(By.id("ctl00_MainContent_btnViewRequisition")).click();       //View Requisition
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_rgdSubCatalog_ctl00__1']/td")).click();      // Sub Catalogue
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_btnAdd']")).click();       //Add Item
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
			
		WebElement partnumber= driver.findElement(By.id("ctl00_MainContent_txtPartnumber"));     // Part Number
		partnumber.clear();
		partnumber.sendKeys("1");
		
		WebElement item= driver.findElement(By.id("ctl00_MainContent_txtShortDescription"));       // Item
		item.clear();
		item.sendKeys("handle");
		
		WebElement longDesp= driver.findElement(By.id("ctl00_MainContent_txtLongDescription"));      // Long Description
		longDesp.clear();
		longDesp.sendKeys("needed");
		
		Select dropdown8= new Select(driver.findElement(By.id("ctl00_MainContent_cmbUnitnPackage")));      // Unit
		dropdown8.selectByVisibleText("BATCH");
		Thread.sleep(1000);
		
		driver.findElement(By.id("ctl00_MainContent_DivItembtnSave")).click();        // Save & Close
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		WebElement description= driver.findElement(By.id("ctl00_MainContent_txtSrchDesc"));      // Description
		description.clear();
		description.sendKeys("handle");
		
		driver.findElement(By.id("ctl00_MainContent_btnItemSearch")).click();          // Search button
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		WebElement ROB= driver.findElement(By.id("txtROB"));      // Enter ROB 
		ROB.clear();
		ROB.sendKeys("22");
		
		WebElement reqstQty= driver.findElement(By.id("txtROB"));        //Enter Reqst Quantity
		reqstQty.clear();
		reqstQty.sendKeys("44");
		
		WebElement comments= driver.findElement(By.id("ctl00_MainContent_rgdItems_ctl00_ctl04_txtgrdItemComments"));      // Write Comments
		comments.clear();
		comments.sendKeys("goodd");
		
		driver.findElement(By.id("ctl00_MainContent_btnPreview")).click();    //   Preview & Finalise
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		Select dropdown9= new Select(driver.findElement(By.id("ctl00_MainContent_DDLPort")));      // Delivery Port
		dropdown9.selectByVisibleText("AMOY");
		Thread.sleep(1000);
		
		WebElement deliverydate= driver.findElement(By.id("ctl00_MainContent_txtfrom"));         // Delivery Date
		deliverydate.clear();
		deliverydate.sendKeys("19");
		
		WebElement reasonreq= driver.findElement(By.id("ctl00_MainContent_txtReqComment"));       // Reason for request
		reasonreq.clear();
		reasonreq.sendKeys("to fix");
		
		
	
	
	}
		
		
	
	
//THIS IS FOR SCREEN SHOT WHEN TESTCASE IS FAILED---------------------------------------------------------
public String SShot(String actual1, String title1, WebDriver driver1) throws IOException {

String actual = actual1;
String title = title1;
WebDriver driver = driver1;

if (title.contentEquals(actual)) {
 System.out.println(title + " page is open.");
} else {

 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

 FileUtils.copyFile(scrFile, new File("C:\\Users\\jibe1"+ driver.getTitle().trim() + "_" + System.currentTimeMillis() + ".jpg"));


 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   

 driver.get(title); // if the page is not exceuted then it will
       // opne this url
}

return (null);
}
}
