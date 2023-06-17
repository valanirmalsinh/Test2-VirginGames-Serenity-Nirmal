package com.virgingames.cucumber.steps;

import com.virgingames.virgingamesinfo.VirgingamesSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.CoreMatchers.equalTo;

public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    VirgingamesSteps virgingamesSteps;

    @When("^I send a Get request$")
    public void iSendAGetRequest() {response = virgingamesSteps.getAllBingoInfo();}

    @Then("^I get valid  response code (\\d+)$")
    public void iGetValidResponseCode(int arg0) {
        response.statusCode(200);
    }

    @And("^I verify name is Enterprise in bingo data$")
    public void iVerifyNameIsEnterpriseInBingoData() {
        response.body("data.pots[2].name", equalTo("Enterprise"));
    }

    @And("^I verify currency GBP in bingo data$")
    public void iVerifyCurrencyGBPInBingoData() {
        response.body("data.pots[2].currency",equalTo("GBP"));
    }

    @Then("^I verify id (\\d+) is equal to 'CrystalMazeVirgin' in bingo data$")
    public void iVerifyIdIsEqualToCrystalMazeVirginInBingoData(int arg0) {
        response.extract().jsonPath().get("data.pots[4].id").equals("CrystalMazeVirgin");

    }
}

