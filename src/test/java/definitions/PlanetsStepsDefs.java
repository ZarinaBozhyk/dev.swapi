package definitions;

import engine.IRestResponse;
import engine.TestContext;
import engine.planets.PlanetsEndpoints;
import engine.planets.PlanetsExample;
import engine.planets.Result;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 7/13/2021
 * #Comments:
 */
public class PlanetsStepsDefs extends BaseSteps {
    private final String BaseUrl = "https://swapi.dev/api";
    private PlanetsEndpoints planetsEndpoints = new PlanetsEndpoints(BaseUrl);

    //<editor-fold desc="Constructors">
    public PlanetsStepsDefs(TestContext testContext) {
        super(testContext);
    }
    //</editor-fold>

    //<editor-fold desc="When">
    @When("I send request to get information about the {int} planet")
    public void iSendRequestToGetInformationAboutTheFirstPlanet(int number) {
        planetsEndpoints.getPlanet(number);
    }

    @When("I get planets information")
    public void iGetPlanetsInformation() {
        planetsEndpoints.getPlanets();
    }
    //</editor-fold>

    //<editor-fold desc="Then">
    @Then("I check name of {int} planet equals to {string}")
    public void iCheckNameOfFirstPlanetEqualsTo(int number, String name) {
        engine.planets.Result body = planetsEndpoints.getPlanet(number).getBody();
        Assert.assertEquals(body.getName(), name);
    }

    @Then("I check at list one of them has diameter more than {int} kilometers")
    public void iCheckAtListOneOfThemHasDiameterMoreThanKilometers(long km) {
        IRestResponse<PlanetsExample> planetsExampleIRestResponse = planetsEndpoints.getPlanets();
        List<Result> results = planetsExampleIRestResponse.getBody().getResults();
        results.stream()
                .filter(planet -> Integer.parseInt(planet.getDiameter()) > km)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("There is no planet with diameter more than '%d'", km)));
    }
    //</editor-fold>
}
