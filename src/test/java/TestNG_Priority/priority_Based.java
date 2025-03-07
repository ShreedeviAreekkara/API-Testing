package TestNG_Priority;

import org.testng.annotations.Test;

public class priority_Based {

    @Test(priority = 0)
    public void testgeTToken(){
        System.out.println("Token was obtained");
    }
    @Test(priority = 1)
    public void testBookingId(){
        System.out.println("BookingId was obtained");
    }
    @Test(priority = 2)
    public void testAputRequest(){
        System.out.println("I will run after obtaining token and booking Id only");
    }
}
