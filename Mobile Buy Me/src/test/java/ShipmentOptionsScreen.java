import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShipmentOptionsScreen extends ScreenBase
{
    private static final String nowRadioButtonId = "il.co.mintapp.buyme:id/nowRadioButton";
    private static final String mailButtonId = "il.co.mintapp.buyme:id/optionCheckBox";
    private static final int mailIndex = 2;
    private static final String mailEditClass = "android.widget.EditText";
    private static final String proceedButtonId = "il.co.mintapp.buyme:id/goNextButton";

    public ShipmentOptionsScreen(AndroidDriver _driver, int timeoutInSeconds)
    {
        super(_driver, timeoutInSeconds);
    }

    public void SelectShipmentTime()
    {
        MobileElement radioBtn =driver.findElementById(nowRadioButtonId);
        wait.until(ExpectedConditions.visibilityOf(radioBtn));
        radioBtn.click();
    }

    public void SelectMailCheckbox()
    {
        List<MobileElement> mailBtn = driver.findElementsById(mailButtonId);
        mailBtn.get(mailIndex).click();
    }

    public void EnterEmail(String mail)
    {
        MobileElement mailField =driver.findElementByClassName(mailEditClass);
        wait.until(ExpectedConditions.visibilityOf(mailField));
        mailField.click();
        mailField.sendKeys(mail);
        driver.hideKeyboard();
    }

    public void Proceed()
    {
        MobileElement continueButton = driver.findElement(By.id(proceedButtonId));
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }

}
