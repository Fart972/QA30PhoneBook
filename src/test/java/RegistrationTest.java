import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends BaseTest{

    @BeforeMethod
    public void preCondition(){
        if (app.getUser().isLogged()){
            app.getUser().logout();

        }
    }


    @Test
    public void  registrationTestPositive(){
        int i=(int) (System.currentTimeMillis()/1000)%3600;
        String email = "nikk"+i+"gmail.com";
        String password = "Nikk1234$";
        System.out.println("Email:  "+email);



        app.getUser().openLoginRegistrationForm();
        app.getUser(). fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();
        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertFalse(app.getUser().isLogged());
    }

    private boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }

    private void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }
public void type(By locator, String text){
        if (text !=null){
            WebElement emailInput= wd.findElement(locator);
            emailInput.click();
            emailInput.clear();
            emailInput.sendKeys(text);
        }
}
    public void openLoginRegistrationForm() {
        click(By.xpath("//*[text()='LOGIN']"));
    }

public void click(By lockator){
        wd.findElement(lockator).click();
}



}
