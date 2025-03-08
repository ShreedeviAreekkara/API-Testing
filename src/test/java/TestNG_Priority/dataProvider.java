package TestNG_Priority;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

    @Test(dataProvider = "getData")
    public void loginToGmail(String name, String pass){
        String userName = name;
        String Password = pass;
        System.out.println("login successful with user : "+ userName+ " , password : "+Password);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                new Object[]{"Shreedevi", "apple@123"},
                new Object[]{"Kiran", "pineApple@123"},
                new Object[]{"Sooraj", "orange@123"}
        };
    }




}
