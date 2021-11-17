package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    private boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void click(By lockator) {
        wd.findElement(lockator).click();
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
}