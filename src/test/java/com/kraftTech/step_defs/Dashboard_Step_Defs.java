package com.kraftTech.step_defs;

import com.kraftTech.pages.DashboardPage;
import com.kraftTech.utilities.BrowserUtils;
import com.kraftTech.utilities.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Dashboard_Step_Defs {
    DashboardPage dashboardPage = new DashboardPage();


    @Then("Verify that the username on the dashboard page is {string}")
    public void verify_that_the_username_on_the_dashboard_page_is(String username) {
        String actualUserName = dashboardPage.getUserAccountName();
        String expectedUserName = username;
        Assert.assertEquals(expectedUserName, actualUserName);

    }

    @Then("The user should be able to see all following tabs that shown on the page")
    public void the_user_should_be_able_to_see_all_following_tabs_that_shown_on_the_page(List<String>expectedtabMenuNames) {
        List<String> actualTabNames = BrowserUtils.getElementsText(dashboardPage.basePageTabs);
        Assert.assertEquals(expectedtabMenuNames,actualTabNames);


    }
    @When("The user should be able to navigate tabs and Modules with {string} and {string}")
    public void the_user_should_be_able_to_navigate_tabs_and_modules_with_and(String tabName, String moduleName) {
        dashboardPage.navigateToModule(tabName,moduleName);
    }

    @Then("Verify that {string} is visible on dashboard page with excel file {string}, {string},{int}")
    public void verify_that_is_visible_on_dashboard_page_with_excel_file(String yourName, String path, String sheetName, Integer row) {
        ExcelUtil excelUtil = new ExcelUtil(path, sheetName);
        List<Map<String, String>> dataList = excelUtil.getDataList();
        String expectedUsername = dataList.get(row).get(yourName);
        String actualUserName = dashboardPage.getUserAccountName();
        Assert.assertEquals(expectedUsername,actualUserName);
    }


}
