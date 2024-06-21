package amazon.TestComponents;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import amazon.resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
		ExtentReports extent = ExtentReporterNG.getReportObject();
		ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//Thread safe. 
		
		@Override		
	    public void onFinish(ITestContext context) {					
	        extent.flush();//flush de lam gi? 
	        	
	    }		

	    @Override		
	    public void onStart(ITestContext context) {					
	        // TODO Auto-generated method stub				
	    	
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub				
	    	//Screenshot
	    	//test.log(Status.FAIL, "Test Failed");
	    	extentTest.get().fail(result.getThrowable());//which thread ID is asking to get information. 
	    	
	    	try {
				driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e1) {
				//Field associates with class level, not method level. 
				// access to the class when the method is presented. 
				// TODO Auto-generated catch block
				e1.printStackTrace();
				//just need to focus on testcase creation
			}
	    	String filePath = null;
			try {
				filePath = getScreenshot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
	    	
	    	//screenshot , attach report
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestStart(ITestResult result) {					
	        // TODO Auto-generated method stub				
	    	test = extent.createTest(result.getMethod().getMethodName());// want the title of the method name, not class name. 
	    	extentTest.set(test);// unique Thread ID
	    	//Every Java class has its own unique ID (ErrorValidationTest) -> Test
	    
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult result) {					
	        // TODO Auto-generated method stub				
	    	extentTest.get().log(Status.PASS, "Test Passed");
	    }		
}
