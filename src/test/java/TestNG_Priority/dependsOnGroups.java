package TestNG_Priority;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class dependsOnGroups {

    @Issue("BUGZ-123")//this can be a jira
    @AllureId("#TC1")//this can be the tc number in excel sheet
    @Severity(SeverityLevel.NORMAL)
    @Test(groups={"Sanity"})
    public void testSanity() {
        System.out.println("This is a sanity test case");
    }

    @AllureId("#TC2")
    @Severity(SeverityLevel.NORMAL)
    @Description("This is smoke case")
    @Test(groups={"Smoke"})
    public void testSmoke() {
        System.out.println("This is a smoke test case");
    }

    @AllureId("#TC3")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups={"Reg"},dependsOnGroups={"Sanity"})
    public void testRegression() {
        System.out.println("This is a regression test case and I will run only after Sanity cases run");
    }

    @AllureId("#TC4")//this can be the tc number in excel sheet
    @Severity(SeverityLevel.NORMAL)
    @Test(groups={"Sanity"})
    public void testRunForFun() {
        System.out.println("This is a sanity test case 2");
    }


}
