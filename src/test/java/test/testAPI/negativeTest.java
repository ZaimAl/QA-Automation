package test.testAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import test.BaseTest;

public class negativeTest extends BaseTest {
    String one,two;
    @And("user give name as job {string}")
    public void userGiveNameAsJob(String nm) {
        one=nm;
    }

    @And("user give job as name {string}")
    public void userGiveJobAsName(String jb) {
        two=jb;
    }

    @When("user send a post respond")
    public void userSendAPostRespond() {
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("name", one);
        bodyObj.put("job",two);

        response=RestAssured.given()
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .body(bodyObj.toString())
                .when().post(apiServer)
                .then().log().body();

    }

    @And("respond should be name {string}")
    public void respondShouldBeName(String nm) {
        Assert.assertEquals(response.body("name", Matchers.equalTo(nm)),response);
    }

    @And("respond should be job {string}")
    public void respondShouldBeJob(String jb) {
        Assert.assertEquals(response.body("job", Matchers.equalTo(jb)),response);
    }

    @And("uset get the primary token {string}")
    public void usetGetThePrimaryToken(String token) {
        one=token;
    }

    @And("user give name as {string}")
    public void userGiveNameAs(String name) {
        two=name;
    }

    @When("user send post respond")
    public void userSendPostRespond() {
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("name", two);
        response=RestAssured.given().auth().oauth2(one)
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .body(bodyObj.toString())
                .when().post(apiServer)
                .then().log().all()
        ;
    }

}
