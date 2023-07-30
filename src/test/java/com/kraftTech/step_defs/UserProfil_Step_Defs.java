package com.kraftTech.step_defs;

import com.kraftTech.pages.UserProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserProfil_Step_Defs {
    UserProfilePage userProfilePage = new UserProfilePage();
    @When("The user should be able to navigate User Profil Page Tabs with {string}")
    public void the_user_should_be_able_to_navigate_user_profil_page_tabs_with(String tabName) {
userProfilePage.navigateToOverViewMenu(tabName);

    }
    @Then("The user sholud be able to see last added record with {string}")
    public void the_user_sholud_be_able_to_see_last_added_record_with(String school) {
        String actualRecordName = userProfilePage.addedEducation(school);
        Assert.assertEquals(school,actualRecordName);

    }
    @Then("The user should be able to delete last added record with {string}")
    public void the_user_should_be_able_to_delete_last_added_record_with(String school) {
        userProfilePage.deleteEducationRecord(school);
    }


}
