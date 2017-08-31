package testngcase;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import testcase.EngineLogBook;

public class EngineLogBookTest extends DriverPass {
	
	ExtentReports report;
	ExtentTest test;
	
	EngineLogBook E=new EngineLogBook();
	
	
  @Test(priority=0)
  public void EngineLogBook() throws Exception {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);

		test = report.startTest("Engine Log Book");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");

		E.EngineLogBook(driver);

  }
  
  @Test(priority=1)
  public void FleetOffice_Vessel1() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("FleetOffice_Vessel1");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.FleetOffice_Vessel1(driver);
}

  
  @Test(priority=2)
  public void FleetOffice_Vessel2() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("FleetOffice_Vessel2");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.FleetOffice_Vessel2(driver);
}
  
  @Test(priority=3)
  public void FleetOffice_Vessel3() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("FleetOffice_Vessel3");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		
		E.FleetOffice_Vessel3(driver);
  
}
  @Test(priority=4)
  public void Fleet_A_Vessel1() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel1");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		
		E.Fleet_A_Vessel1(driver);
  
  
  
}
  
  @Test(priority=5)
  public void Fleet_A_Vessel2() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel2");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		
		E.Fleet_A_Vessel2(driver);
  
  
  
}
  
  @Test(priority=6)
  public void Fleet_A_Vessel3() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel3");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_A_Vessel3(driver);
  
  
  
}
  
  @Test(priority=7)
  public void Fleet_A_Vessel4() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel4");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_A_Vessel4(driver);
  
  
  
}
  
  @Test(priority=8)
  public void Fleet_A_Vessel5() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel5");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_A_Vessel5(driver);

}
  


  @Test(priority=9)
  public void Fleet_A_Vessel6() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel6");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_A_Vessel6(driver);

}

  @Test(priority=10)
  public void Fleet_A_Vessel7() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel7");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_A_Vessel7(driver);

}

  
  @Test(priority=11)
  public void Fleet_A_Vessel8() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel8");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_A_Vessel8(driver);

}

  @Test(priority=12)
  public void Fleet_A_Vessel9() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel9");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_A_Vessel9(driver);

}

  @Test(priority=13)
  public void Fleet_A_Vessel10() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_A_Vessel10");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_A_Vessel10(driver);

}
  
  @Test(priority=14)
  public void Fleet_B_Vessel1() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_B_Vessel1");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_B_Vessel1(driver);

}
  
  
  @Test(priority=15)
  public void Fleet_B_Vessel2() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		test = report.startTest("Fleet_B_Vessel2");

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as condtion is true");
		
		E.Fleet_B_Vessel2(driver);

}
  
  @AfterMethod
	public void afterMethod(ITestResult result) {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        test.log(LogStatus.FAIL, "Test failed " + result.getThrowable());
	    } else if (result.getStatus() == ITestResult.SKIP) {
	        test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	    } else {
	        test.log(LogStatus.PASS, "Test passed");
	    }

	    report.endTest(test);
	    report.flush();
}

@BeforeSuite
public void worklst() {
    report = EngineLogBook.getReporter("C:\\Users\\Arati\\workspace\\EngineLogBook\\Engine.html");
}
  
}