import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlessingScreen extends ScreenBase
{
    private static final String scrollArrowId = "il.co.mintapp.buyme:id/scrollArrows";
    private static final String receiverTextEditId = "il.co.mintapp.buyme:id/toEditText";
    private static final String receiverName = "Matan";
    private static final String blessingTextBoxId = "il.co.mintapp.buyme:id/blessEditText";
    private static final String blessingText = "Thank you";
    private static final String senderTextEditId = "il.co.mintapp.buyme:id/userFrom";
    private static final String senderName = "Maria Weissbuch";
    private static final String proceedButtonId = "il.co.mintapp.buyme:id/goNextButton";

    public BlessingScreen(AndroidDriver _driver, int timeoutInSeconds)
    {
        super(_driver, timeoutInSeconds);
    }

    public void ScrollDown()
    {
        MobileElement scrollBtn = driver.findElementById(scrollArrowId);
        wait.until(ExpectedConditions.visibilityOf(scrollBtn));
        scrollBtn.click();
    }

    public void EnterReceiverName()
    {
        MobileElement receiverEditField = driver.findElement(By.id(receiverTextEditId));
        wait.until(ExpectedConditions.visibilityOf(receiverEditField));
        receiverEditField.sendKeys(receiverName);
    }

    public void EnterBlessing()
    {
        driver.hideKeyboard();
        MobileElement blessing = driver.findElementById(blessingTextBoxId);
        wait.until(ExpectedConditions.visibilityOf(blessing));
        blessing.sendKeys(blessingText);
    }

    public void EnterSenderName()
    {
        driver.hideKeyboard();
        MobileElement senderNameField = driver.findElementById(senderTextEditId);
        wait.until(ExpectedConditions.visibilityOf(senderNameField));

        senderNameField.clear();
        senderNameField.sendKeys(senderName);
        driver.hideKeyboard();
    }

    public void Proceed()
    {
        MobileElement continueBtn = driver.findElement(By.id(proceedButtonId));
        wait.until(ExpectedConditions.visibilityOf(continueBtn));
        continueBtn.click();
    }
}
