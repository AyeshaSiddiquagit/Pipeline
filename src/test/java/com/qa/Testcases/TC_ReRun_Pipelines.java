package com.qa.Testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.BaseClass.PipeLines_BaseClass;
import com.qa.Pages.Pipelines;

public class TC_ReRun_Pipelines extends PipeLines_BaseClass {

	// private static final String Pipelinename = null;
	
@BeforeTest 
public void setup() throws IOException {
	
		intialization();
		System.out.println("Able to login to the Application Successfully");
}
@Test 
public void Verify()
{
		Pipelines obj = new Pipelines();
		obj.setPipelineName();
		obj.TurnOnPipelines (obj.getPipeLineName());
		System.out.println("Test exceuted successfully");
		
}

@AfterTest
	public  void teardown()
	{
	driver.quit();
	}

}
