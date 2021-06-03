package testt;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class eccomerce_tc_5 extends base123{


		public static void main(String[] args) throws MalformedURLException, InterruptedException {
			// TODO Auto-generated method stub
			AndroidDriver<AndroidElement> driver =capabilities();
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("hello");
			driver.hideKeyboard();
			driver.findElement(By.xpath("//android.widget.RadioButton[@text = 'Female']")).click();
			driver.findElement(By.id("android:id/text1")).click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		//   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));   
			driver.findElement(By.xpath("//*[@text= 'Argentina']")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			Thread.sleep(4000);
			int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
			double sum =0;
			for(int i=0;i<count;i++)
			{
				String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
				double amount = getAmount(amount1);
				sum = sum+amount;
			}
			System.out.println(sum+ "Sum of the products");
			String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
			total = total.substring(1);
			double totalvalue = Double.parseDouble(total);
			System.out.println(totalvalue+ "total of the products");
			Assert.assertEquals(sum, totalvalue);
	}
	
	public static double getAmount(String value)
	{
		value = value.substring(1);
		double amount3 = Double.parseDouble(value);
		return amount3;
	}

}
