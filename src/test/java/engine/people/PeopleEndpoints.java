package engine.people;

import engine.IRestResponse;
import engine.RestResponse;
import engine.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 7/6/2021
 * #Comments:
 */
public class PeopleEndpoints {
    private final RequestSpecification request;

    //<editor-fold desc="Constructors">
    public PeopleEndpoints(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }
    //</editor-fold>

    //<editor-fold desc="Public Methods">
    public IRestResponse<PeopleExample> getAllPeople() {
        Response response = request.get(Routes.people());
        return new RestResponse(PeopleExample.class, response);
    }

    public IRestResponse<Result> getPerson(int personNumber) {
        Response response = request.get(Routes.person(personNumber));
        return new RestResponse(Result.class, response);
    }
    //</editor-fold>
}
