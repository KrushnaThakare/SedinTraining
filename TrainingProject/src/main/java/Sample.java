import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krushna Pralhad\\git\\repository\\TrainingProject\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D60612964962%26hvpone%3D%26hvptwo%3D%26hvadid%3D486380734074%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D16506050426990461876%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9299716%26hvtargid%3Dkwd-296458777401%26hydadcr%3D14454_2154375%26gclid%3DCj0KCQjw48OaBhDWARIsAMd966DLG2TNHgxUfZIyQYXM1rsdvhtpiHIvYOQbnBEcy_0ZHdjPVEVMNZkaAqx9EALw_wcB&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.findElement(By.id("ap_email")).sendKeys("krushna.gopal96@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("gopal1996");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 13");

		
	}
}
