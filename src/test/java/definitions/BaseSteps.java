package definitions;

import engine.TestContext;
import engine.people.PeopleEndpoints;
import engine.planets.PlanetsEndpoints;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 7/13/2021
 * #Comments:
 */
public class BaseSteps {
    private PlanetsEndpoints planetsEndpoints;
    private PeopleEndpoints peopleEndpoints;

    //<editor-fold desc="Constructors">
    public BaseSteps(TestContext testContext) {
        planetsEndpoints = testContext.getPlanetsEndpoints();
        peopleEndpoints = testContext.getPeopleEndpoints();
    }
    //</editor-fold>
}
