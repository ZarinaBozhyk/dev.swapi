package engine;

import dataProvider.ConfigFileReader;
import engine.people.PeopleEndpoints;
import engine.planets.PlanetsEndpoints;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 7/13/2021
 * #Comments:
 */
public class TestContext {
    private PlanetsEndpoints planetsEndpoints;
    private PeopleEndpoints peopleEndpoints;

    //<editor-fold desc="Constructors">
    public TestContext() {
        planetsEndpoints = new PlanetsEndpoints(ConfigFileReader.getInstance().getBaseUrl());
        peopleEndpoints = new PeopleEndpoints(ConfigFileReader.getInstance().getBaseUrl());
    }
    //</editor-fold>

    //<editor-fold desc="Public Methods">
    public PeopleEndpoints getPeopleEndpoints() {
        return peopleEndpoints;
    }

    public PlanetsEndpoints getPlanetsEndpoints() {
        return planetsEndpoints;
    }
    //</editor-fold>
}
