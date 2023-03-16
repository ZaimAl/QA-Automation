package test.testAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Assert;
import test.BaseTest;

public class boundaryTest extends BaseTest {
    private int pokedexGen[];
    int page,per_page;

    @Given("user have an API to access all pokedex {string}")
    public void userHaveAnAPIToAccessAllPokedex(String api) {
        apiServer=api;
    }

    @And("user know the number of pokedex gen one \\({int}), gen two \\({int}), and gen third \\({int})")
    public void userKnowTheNumberOfPokedexGenOneGenTwoAndGenThird(int gen1, int gen2, int gen3) {
        pokedexGen= new int[]{0, gen1, gen2, gen3};
    }

     @When("user send a GET respond")
    public void userSendAGETRespond() {
        for (int a = 1; a < pokedexGen.length; a++) {
            int limit = pokedexGen[a] - pokedexGen[a - 1];
            int start = pokedexGen[a - 1];
            response=RestAssured
                    .given().when()
                    .get(apiServer+"?limit=" + limit + "&offset=" + start)
                    .then().log().all()
            ;
    }}
    @Then("respond code should be \\({int})")
    public void respondCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.statusCode(statusCode), response);
    }

    @And("user GET API respond for each pokedex")
    public void userGETAPIRespondForEachPokedex() {
        Assert.assertEquals(response.body("count", Matchers.equalTo(1281)),response);
    }

    @Given("user have an API to access {string}")
    public void userHaveAnAPIToAccess(String api) {
        apiServer=api;
    }

    @And("user choose page \\({int}) and per_page \\({int})")
    public void userChoosePageAndPer_page(int pg, int perpage) {
        page=pg;
        per_page=perpage;
    }

    @When("user send GET API respond")
    public void userSendGETAPIRespond() {
        response= RestAssured
                .given().when()
                .get(apiServer+"?page="+page+"&per_page="+per_page)
                .then().log().body();
    }

    @And("respond should be page \\({int}) and per_page \\({int})")
    public void respondShouldBePageAndPer_page(int pg, int perpage) {
        Assert.assertEquals(response.body("page", Matchers.equalTo(pg)),response);
        Assert.assertEquals(response.body("per_page", Matchers.equalTo(perpage)),response);
    }
}
