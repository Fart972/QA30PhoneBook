import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver wd;
    @BeforeSuite
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
public void pause(int millis){
   try {
       Thread.sleep(millis);
   } catch (InterruptedException e){
       e.printStackTrace();
   }


}

    @AfterSuite
    public void tearDown(){
        wd.quit();
    }
}
