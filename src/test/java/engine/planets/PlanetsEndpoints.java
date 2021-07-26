package engine.planets;

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
public class PlanetsEndpoints {
    private final RequestSpecification request;

    //<editor-fold desc="Constructors">
    public PlanetsEndpoints(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }
    //</editor-fold>

    //<editor-fold desc="Public Methods">
    public IRestResponse<PlanetsExample> getPlanets() {
        Response response = request.get(Routes.planets());
        return new RestResponse<>(PlanetsExample.class, response);
    }

    public IRestResponse<Result> getPlanet(int planetNumber) {
        Response response = request.get(Routes.planet(planetNumber));
        return new RestResponse<>(Result.class, response);
    }
    //</editor-fold>
}
