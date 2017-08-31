package testcase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import com.relevantcodes.extentreports.ExtentReports;

import commonfunction.RW;

public class EngineLogBook extends RW {
	
private static ExtentReports report;
    
    public synchronized static ExtentReports getReporter(String filePath) { //allow only one thread to access the shared resource,To prevent thread interference.
        if (report == null) {
            report = new ExtentReports("C:\\Users\\Arati\\workspace\\EngineLogBook\\Engine.html", false); //Path of generating report
            
            report
                .addSystemInfo("Host Name", "AratiD") //Environment Setup
                .addSystemInfo("Environment", "QA");
        }
        
        return report;
    }
	
	public static WebDriver driver;
	
	public void EngineLogBook(WebDriver driver1) throws Exception 
	
	{
		WebDriver driver= driver1;
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		
		WebElement TechnicalMenu= driver.findElement(By.linkText("Technical"));   //TechnicalMenu
		
        action.moveToElement(TechnicalMenu).build().perform();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Engine Log Book")).click();    // Engine Log Book
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		
	}
	
	public void FleetOffice_Vessel1(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-Office");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","Demo Vessel -6");
		
		Thread.sleep(1000);
		
		String FV1 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for Demo Vessel -6  " + FV1);
		
		
	}
	
	public void FleetOffice_Vessel2(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-Office");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","Demo Vessel -7");
		
		Thread.sleep(1000);
		
		String FV2 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for Demo Vessel -7 " + FV2);
		
		
	}
	
	public void FleetOffice_Vessel3(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-Office");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","OFFICE");
		
		Thread.sleep(1000);
		
		String FV3 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for OFFICE  " + FV3);
		
		
	}
	
	
	public void Fleet_A_Vessel1(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","AGNI");
		
		Thread.sleep(1000);
		
		String FV4 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for AGNI  " + FV4);
	
}
	
	
	public void Fleet_A_Vessel2(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","IMARA");
		
		Thread.sleep(1000);
		
		String FV5 = driver.findElement(By.id("ctl00_MainContent_ucCustomPagerItems_lblTotalPages")).getText();      // Get total Record count
		System.out.println("total record for IMARA  " + FV5);
	
}
	
	
	public void Fleet_A_Vessel3(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","MOON STAR");
	
		Thread.sleep(1000);
		
		String FV6 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for MOON STAR  " + FV6);
	
}
	
	public void Fleet_A_Vessel4(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","SANTA MONICA");
		
		Thread.sleep(1000);
		
		String FV6 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for SANTA MONICA  " + FV6);
	
}
	
	public void Fleet_A_Vessel5(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","TAPTI");
		
		Thread.sleep(1000);
		
		String FV7 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for TAPTI " + FV7);
		
		Thread.sleep(1000);
	
}
	

	public void Fleet_A_Vessel6(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","test1");
		
		Thread.sleep(1000);
		
		String FV8 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for test1  " + FV8);
	
		Thread.sleep(1000);
	
	
	}
	
	
	

	public void Fleet_A_Vessel7(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","test2");
	
		Thread.sleep(1000);
		
		String FV9 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for test2 " + FV9);
	
		Thread.sleep(1000);
	
	
	}
	
	
	public void Fleet_A_Vessel8(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","test3");
		
		Thread.sleep(1000);
		
		String FV10 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for test3 " + FV10);
	
		Thread.sleep(1000);
	
	
	}
	
	public void Fleet_A_Vessel9(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
	
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","TestA");
		
		Thread.sleep(1000);
		
		String FV11 = driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_gvERLogIndex']/tbody/tr/td")).getText();      // Get total Record count
		System.out.println("total record for TestA " + FV11);
	
		Thread.sleep(1000);
	
	
	}
	
	public void Fleet_A_Vessel10(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-A");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","YELLOW MOON");
		
		Thread.sleep(1000);
		
		String FV12 = driver.findElement(By.id("ctl00_MainContent_ucCustomPagerItems_lblTotalPages")).getText();      // Get total Record count
		System.out.println("total record for YELLOW MOON " + FV12);
	
		Thread.sleep(1000);
	
	
	}
	
	public void Fleet_B_Vessel1(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-B");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","BALEEN");
		
		Thread.sleep(1000);
		
		String FV13 = driver.findElement(By.id("ctl00_MainContent_ucCustomPagerItems_lblTotalPages")).getText();      // Get total Record count
		System.out.println("total record for BALEEN " + FV13);
	
		Thread.sleep(1000);
	
	
	}
	
	public void Fleet_B_Vessel2(WebDriver driver1) throws Exception 
	{
		WebDriver driver = driver1;
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLFleet","Fleet-B");
		
		Thread.sleep(1000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","HARUKA");
		
		Thread.sleep(1000);
		
		String FV14 = driver.findElement(By.id("ctl00_MainContent_ucCustomPagerItems_lblTotalPages")).getText();      // Get total Record count
		System.out.println("total record for HARUKA " + FV14);
	
		Thread.sleep(2000);
		
		click_element(driver,"id", "ctl00_MainContent_gvERLogIndex_ctl02_ImgBtn");   // + icon
		Thread.sleep(1000);
		
		click_element(driver,"id", "ctl00_MainContent_gvERLogIndex_ctl02_grdLHanomalies_ctl02_lblLogWatch");   // Log Watch
		Thread.sleep(1000);
		
		WindowSwitchto(driver);       // Switch Window
		
		dropdown(driver,"id", "ctl00_MainContent_ddlWatchHours","0800-1200");   // Watch From
		Thread.sleep(3000);
		
		dropdown(driver,"id", "ctl00_MainContent_ddlWatchHours","2000-2400");   // Watch From
		Thread.sleep(3000);
		
		dropdown(driver,"id", "ctl00_MainContent_DDLVessel","IMARA");   // Vessel
		Thread.sleep(3000);
		
		dropdown(driver,"id", "ctl00_MainContent_ddlWatchHours","0000-0400");   // Watch From
		Thread.sleep(3000);
		
		
		
		
	
	}
	
	
	
}