package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	@Override
    public void onFinish(ITestContext result) {

    }

    @Override
    public void onStart(ITestContext result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
    	//screenshot code
    	//respond if API is failed
    	System.out.println("Failed executing listener pass code");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	//respond if the API is success
    	System.out.println("I successfully executed listeners pass code");
    }
}
