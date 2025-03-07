package Shreedevi_Automation_Projects.testNG;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ra_01 {
    @Description("TC #1")
    @Test
    public void testing_testNG_API(){
        System.out.println("installations were successful");
    }
    @Description("TC #2")
    @Test
    public void first_tc(){
        System.out.println("TC");
    }
    @Description("TC #3")
    @Test
    public void Second_tc(){
        System.out.println("TC_2");
    }

}
