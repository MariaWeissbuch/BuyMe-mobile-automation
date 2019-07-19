import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen extends ScreenBase
{
    private static final String skipButtonElement = "il.co.mintapp.buyme:id/skipButton";

    public LoginScreen(AndroidDriver _driver, int timeoutInSeconds)
    {
        super(_driver, timeoutInSeconds);
    }

    public void ClickLoginButton()
    {
        //Log in screen 1
        MobileElement loginBtn = driver.findElement(By.id(skipButtonElement));
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
    }
}
