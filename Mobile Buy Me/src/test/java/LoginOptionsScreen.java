import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOptionsScreen extends ScreenBase
{
    private static final String googleButtonId = "il.co.mintapp.buyme:id/googleButton";
    private static final String userClassName = "android.widget.LinearLayout";

    public LoginOptionsScreen(AndroidDriver _driver, int timeoutInSeconds)
    {
        super(_driver, timeoutInSeconds);
    }

    public void SelectGoogleAccountLogin()
    {
        MobileElement googleLogIn = driver.findElement(By.id(googleButtonId));
        wait.until(ExpectedConditions.visibilityOf(googleLogIn));
        googleLogIn.click();

        MobileElement user = driver.findElement(By.className(userClassName));
        wait.until(ExpectedConditions.visibilityOf(user));
        user.click();
    }
}
