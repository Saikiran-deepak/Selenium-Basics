package CheckBox;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.Base;

public class CheckBoxTest extends Base {

	static Base b;

	@Test
	public void test1() throws InterruptedException {
		b = new Base();
		driver = b.Login2();
		//driver = new ChromeDriver();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();
		// Click on the checkbox
		driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
		driver.findElement(By.xpath("//button[@class=\"rct-collapse rct-collapse-btn\"]")).click();

		driver.findElement(By.xpath("(//button[@class=\"rct-collapse rct-collapse-btn\"])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Notes')]")).click();
		driver.findElement(By.xpath("(//button[@class=\"rct-collapse rct-collapse-btn\"])[3]")).click();
		driver.findElement(By.xpath("(//button[@class=\"rct-collapse rct-collapse-btn\"])[5]")).click();
		List<WebElement> elements = driver.findElements(By.xpath(
				"(//li[@class=\"rct-node rct-node-parent rct-node-expanded\"])[3]//li[@class=\"rct-node rct-node-parent rct-node-expanded\"]//li"));

//		for (int i = 0; i < elements.size(); i++) {
//			if (!elements.get(i).isSelected()) {
//				Thread.sleep(3000);
//				WebElement officeElement = elements.get(i);
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", officeElement);
//				officeElement.click();
//			}
//		}

		for (WebElement element : elements) {
			if (!element.isSelected()) {
				Thread.sleep(3000);
				//WebElement officeElement = element;
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();
			}
		}

		Thread.sleep(5000);
		driver.close();
	}

	//@Test
	public void checkBoxTest2() {
		b = new Base();
		driver = b.Login2();
		//driver = new ChromeDriver();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();
		// Click on the checkbox
		driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
		driver.findElement(By.xpath("//button[@class=\"rct-collapse rct-collapse-btn\"]")).click();

		driver.findElement(By.xpath("(//button[@class=\"rct-collapse rct-collapse-btn\"])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Notes')]")).click();
		driver.findElement(By.xpath("(//button[@class=\"rct-collapse rct-collapse-btn\"])[3]")).click();
		driver.findElement(
				By.xpath("//span[text()='WorkSpace']/ancestor::label/preceding-sibling::button[@type='button']"))
				.click();

		List<WebElement> elements = driver.findElements(By.xpath(
				"//span[contains(text(),'WorkSpace')]/ancestor::li[@class='rct-node rct-node-parent rct-node-expanded'][1]//li[@class=\"rct-node rct-node-leaf\"]"));

		// Step 1: Get the parent li element for "WorkSpace"
		WebElement workspaceNode = driver.findElement(By
				.xpath("//span[text()='WorkSpace']/ancestor::li[@class='rct-node rct-node-parent rct-node-expanded']"));

		// Step 2: Get all child node titles under "WorkSpace"
		List<WebElement> childNodes = workspaceNode.findElements(By.xpath(".//span[@class='rct-title']"));

		// Step 3: Loop through and click the checkbox for each desired node
		for (WebElement node : childNodes) {
			String text = node.getText();

			if (text.equals("React") || text.equals("Angular") || text.equals("Vue")) {
				WebElement checkbox = node.findElement(By.xpath("./ancestor::label/input[@type='checkbox']"));
				if (!checkbox.isSelected()) {
					checkbox.click();
				}
			}
		}

	}

	//@Test
	public void checkBoxTest3() {
		b = new Base();
		driver = b.Login2(); // Assuming Login2 returns WebDriver

		driver.get("https://demoqa.com");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement ele = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Elements')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Check Box')]"))).click();

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")))
				.click(); // Expand "Home"
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[2]"))).click(); // Expand
																													// "Desktop"
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[3]"))).click(); // Expand
																													// "Documents"

		// Expand "WorkSpace"
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[text()='WorkSpace']/ancestor::label/preceding-sibling::button")))
				.click();

		// Get the parent "WorkSpace" node
		WebElement workspaceNode = driver.findElement(
				By.xpath("//span[text()='WorkSpace']/ancestor::li[contains(@class, 'rct-node-expanded')]"));

		List<WebElement> childTitles = workspaceNode.findElements(By.xpath(".//span[@class='rct-title']"));
		Set<String> targets = new HashSet<>(Arrays.asList("React", "Angular", "Vue"));

		for (WebElement title : childTitles) {
			String text = title.getText();
			if (targets.contains(text)) {
				try {
					// Click on parent label instead of checkbox input (handles hidden inputs)
					WebElement label = title.findElement(By.xpath("./ancestor::label"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", label);
					label.click();
					System.out.println("Clicked on label for: " + text);
				} catch (ElementNotInteractableException e) {
					System.out.println("Could not click checkbox for: " + text + " - " + e.getMessage());
				}
			}
		}

		System.out.println("Done selecting React, Angular, and Vue.");
	}
}
