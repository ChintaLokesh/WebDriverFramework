package com.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class Listener implements ITestListener {
	
	ExtentReports extent;
	
	
	
	  public void onTestStart(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a test succeeds.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS
		   */
		  public void onTestSuccess(ITestResult result) {
		    // not implemented
			  
			  if(result.getStatus()== ITestResult.SUCCESS)
			  {
				  String name=System.getProperty("user.dir")+"\\Screenshots\\FourthPage.jpg";
				  try {
					 
					ReUsableMethods.logger.addScreenCaptureFromPath(name, "Test is passed Successfully");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			  
			  
		  }

		  /**
		   * Invoked each time a test fails.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#FAILURE
		   */
		  public void onTestFailure(ITestResult result) {
		    // not implemented
			  
			  
			  
		  }

		  /**
		   * Invoked each time a test is skipped.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SKIP
		   */
		  public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a method fails but has been annotated with successPercentage and this failure
		   * still keeps it within the success percentage requested.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
		   */
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a test fails due to a timeout.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   */
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		  /**
		   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
		   * and calling all their Configuration methods.
		   */
		  public void onStart(ITestContext context) {
		    // not implemented
			  
			  extent=ReUsableMethods.initializeReports(context.getName());
				ReUsableMethods.logger=extent.createTest(context.getName());  
			  
		  }

		  /**
		   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
		   * and all their Configuration methods have been called.
		   */
		  public void onFinish(ITestContext context) {
		    // not implemented
			  
			  extent.flush();
		  }
	

}
