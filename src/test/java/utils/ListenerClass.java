package utils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Base.ProjectSpecificationMethods;

public class ListenerClass extends ProjectSpecificationMethods implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "TestCase Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	test.fail(result.getThrowable());
	String screenShot = "";
	try {
		screenShot = screenShot(result.getMethod().getMethodName());
	} catch (IOException e) {e.printStackTrace();}
	test.addScreenCaptureFromPath(screenShot,"Faliure ScreenShot");
	}

}
