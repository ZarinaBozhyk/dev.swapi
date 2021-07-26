package definitions;

import engine.IRestResponse;
import engine.TestContext;
import engine.people.PeopleEndpoints;
import engine.people.PeopleExample;
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
public class PeopleStepsDefs extends BaseSteps {
    private final String BaseUrl = "https://swapi.dev/api";
    private PeopleEndpoints peopleEndpoints = new PeopleEndpoints(BaseUrl);

    //<editor-fold desc="Constructors">
    public PeopleStepsDefs(TestContext testContext) {
        super(testContext);
    }
    //</editor-fold>

    //<editor-fold desc="When">
    @When("I get people information")
    public void iGetPeopleInformation() {
        peopleEndpoints.getAllPeople();
    }
    //</editor-fold>

    //<editor-fold desc="Then">
    @Then("I check at list one of them has name {string}")
    public void iCheckAtListOneOfThemHasName(String expectedName) {
        IRestResponse<PeopleExample> peopleExampleIRestResponse = peopleEndpoints.getAllPeople();
        List<engine.people.Result> results = peopleExampleIRestResponse.getBody().getResults();
        results.stream()
                .filter(person -> person.getName().equals(expectedName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("There is no person with expected name '%s'", expectedName)));
    }

    @Then("I check {int} person with name equals to {string} has {string} eyes")
    public void iCheckAWithNameEqualsToHasEyes(
            int personNumber,
            String expectedName,
            String expectedEyesColor) {
        engine.people.Result body = peopleEndpoints.getPerson(personNumber).getBody();
        Assert.assertTrue(body.getName().equals(expectedName) && body.getEyeColor().equals(expectedEyesColor));
    }
    //</editor-fold>
}
