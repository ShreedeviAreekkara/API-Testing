package TestNG_Priority;

import org.testng.annotations.Test;

public class groups {
    //priority based ones are not used much instead groups are used widely
    @Test(groups={"Sanity"})
    public void testSanity() {
        System.out.println("This is a sanity test case");
    }
    @Test(groups={"Smoke"})
    public void testSmoke() {
        System.out.println("This is a smoke test case");
    }

    @Test(groups={"Reg"})
    public void testRegression() {
        System.out.println("This is a regression test case");
    }

    @Test(groups={"QA"})
    public void testgeTToken(){
        System.out.println("Token was obtained for QA  env");
    }
    @Test(groups={"Prod","UAT"})
    public void testBookingId(){
        System.out.println("Booking id will be obtained for both prod and UAT env");
    }
    @Test(groups={"UAT"})
    public void testAputRequest(){
        System.out.println("I will run after obtaining token and booking Id only in UAT env");
    }
}
