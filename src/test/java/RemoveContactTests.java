package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void precondition () {
        if (!app.getUser().isLogged()){
            app.getUser().login(new User()
                    .withEmail("noa@gmail.com")
                    .withPassword("Nnoa12345$"));
        }


        app.contact().providerOfContacts();

    }

    @Test
    public void test(){

    }

    @Test
    public void removeOneContact(){

       int result =  app.contact().removeOneContact();
        Assert.assertEquals(result,-1);

    }

    @Test
    public  void removeAllContact(){
        app.contact().removeAllContacts();
        Assert.assertTrue(app.contact().isContactNotHere());
    }
}
