package com.kraftTech.step_defs;

import com.kraftTech.pages.DashboardPage;
import com.kraftTech.pages.LoginPage;
import com.kraftTech.utilities.ConfigurationReader;
import com.kraftTech.utilities.Driver;
import com.kraftTech.utilities.ExcelUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Login_StepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));


    }

    @When("The user logs in with Melih's credentials")
    public void the_user_logs_in_with_melih_s_credentials() {
        loginPage.login();

    }

    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {
        String currentUrl = Driver.get().getCurrentUrl();
        String expectedUrl = "https://www.krafttechexlab.com/index";
        Assert.assertEquals(expectedUrl, currentUrl);

    }

    @When("The user logs in with Semih's credentials")
    public void theUserLogsInWithSemihSCredentials() {
        System.out.println("Semih");

    }

    @When("The user logs in with Mehmet's credentials")
    public void theUserLogsInWithMehmetSCredentials() {
        System.out.println("mehmet");
    }

    @When("The user logs in with Rosa's credentials")
    public void theUserLogsInWithRosaSCredentials() {
        loginPage.login("rosa@test.com", "Test123456");
    }

    @When("The user logs in with valid credentials {string} and {string}")
    public void the_user_logs_in_with_valid_credentials_and(String userEmail, String password) {
        loginPage.login(userEmail, password);

    }

    @When("The user logins with following list")
    public void the_user_logins_with_following_list(List<String> userInfo) {
        loginPage.login(userInfo.get(0), userInfo.get(1));
        String actualUserName = dashboardPage.getUserAccountName();
        String expectedUserName = userInfo.get(2);
        Assert.assertEquals(expectedUserName, actualUserName);

    }

    @When("The user logins with following map")
    public void the_user_logins_with_following_map(Map<String, String> userInfo) {
        loginPage.login(userInfo.get("userEmail"), userInfo.get("password"));
        String actualUserName = dashboardPage.getUserAccountName();
        Assert.assertEquals(userInfo.get("name"), actualUserName);

    }
    @When("The user logins with valid credentials {string} and {string} from Excel file {string},{string},{int}")
    public void the_user_logins_with_valid_credentials_and_from_excel_file(String yourEmail, String password, String path, String sheetName, Integer row) {
        ExcelUtil excelUtil = new ExcelUtil(path, sheetName);
        List<Map<String, String>> dataList = excelUtil.getDataList();
        String email = dataList.get(row).get(yourEmail);
        String pass = dataList.get(row).get(password);

        loginPage.login(email,pass);
    }
}

