package TestNG_Priority;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterisation {
    @Parameters("browser")
    @Test
    public void testbrowserInitialisation(String browserName){
        System.out.println(browserName);
        switch (browserName){
            case "firefox":
                System.out.println("Run on firefox browser");
                break;
            case "chrome":
                System.out.println("Run on chrome browser");
                break;
            case "edge":
                System.out.println("Run on edge browser");
                break;
            default:
                System.out.println("donot know which one to run on");

        }

    }

}

