package test.testAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import test.BaseTest;

import java.util.HashMap;

public class positifTest extends BaseTest {
    String name,fname;
    private int one,two;
    @And("user input to get page one \\({int}) and page two \\({int})")
    public void userInputToGetPageOneAndPageTwo(int first, int second) {
        one=first;
        two=second;
    }

    @When("user send a GET respond per page")
    public void userSendAGETRespondPerPage() {
        for (int a=one;a<=two;a++){
           response= RestAssured.given().when()
                    .get(apiServer + a)
                    .then().log().all()
                    .assertThat().statusCode(200);

        }
    }

    @And("user GET API respond for each page")
    public void userGETAPIRespondForEachPage() {
        Assert.assertEquals(response.body("per_page", Matchers.equalTo(6)),response);

    }

    @And("user print name id before change")
    public void userPrintNameIdBeforeChange() {
      fname = RestAssured.given().when().get(apiServer+2).getBody().jsonPath().get("data.first_name");
        System.out.printf(fname);
    }

    @And("user change name as {string}")
    public void userChangeNameAs(String newName) {
        name=newName;
    }

    @When("user send POST respond to change name")
    public void userSendPOSTRespondToChangeName() {
        String lName = RestAssured.given().when().get(apiServer+2).getBody().jsonPath().get("data.last_name");
        String email = RestAssured.given().when().get(apiServer+2).getBody().jsonPath().get("data.email");
        String avatar = RestAssured.given().when().get(apiServer+2).getBody().jsonPath().get("data.avatar");

        HashMap<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("id",2);
        bodyMap.put("email",email);
        bodyMap.put("first_name",name);
        bodyMap.put("last_name",lName);
        bodyMap.put("avatar",avatar);
        JSONObject jsonObject=new JSONObject(bodyMap);

        response=RestAssured.given().log().all()
                .header("Content-type","application/json")
                .header("Accept","application/json")
                .body(jsonObject.toString())
                .put(apiServer+2)
                .then().log().all();
    }
}
