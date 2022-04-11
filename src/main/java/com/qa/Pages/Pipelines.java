package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseClass.PipeLines_BaseClass;

public class Pipelines extends PipeLines_BaseClass {

	String pipeLineName;

	@FindBy(linkText = "Demo 1-Trail")
	WebElement AppName;

	@FindBy(xpath = "//div[contains(text(),'Pipeline data')]")
	WebElement PipelineTable;

	@FindBy(xpath = "//div[@value=\"Test Data\"]")
	WebElement FirstRow;

	@FindBy(xpath = "//span[contains(text(),'Pipelines')]")
	WebElement PipelinesSearchPage;

	@FindBy(xpath = "//input[@label='Search']")
	WebElement Serachbox;

	@FindBy(xpath = "//div[@class='css-2mcx1n efcgjqz0']")
	WebElement firstrow;
	
	@FindBy(xpath = "//button[@role=\"switch\"]")
	WebElement Checkbox;

	public Pipelines() {
		PageFactory.initElements(driver, this);
		// String pipe = findpiplename();
		// TurnOnPipelines(pipe);
	}

//getter method 
	public String getPipeLineName() {
		return pipeLineName;
	}

	public void setPipelineName() {
		AppName.click();
		PipelineTable.click();
		pipeLineName = FirstRow.getText();
	}

	public void TurnOnPipelines(String Pipelinename) {
		PipelinesSearchPage.click();
		Serachbox.sendKeys(Pipelinename);
		wait123 = new WebDriverWait(driver, 30);
		wait123.until(ExpectedConditions.textToBePresentInElement(firstrow, Pipelinename));
		boolean flag = Checkbox.isSelected();
		System.out.println(flag);
		if (flag == true) {
			System.out.println("No action required , Pipeline is on");
		} else {
			driver.navigate().refresh();
			driver.findElement(By.xpath("//button[@role=\"switch\" and @class=\"css-1akupnl ec801352\"]")).click();
			System.out.println("Switch on the pipeline ");
		}
		System.out.println("Script Execeuted Successfully ");
		driver.navigate().refresh();
		//driver.quit();
	}
}
