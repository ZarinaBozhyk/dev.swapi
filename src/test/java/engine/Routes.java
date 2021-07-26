package engine;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 7/7/2021
 * #Comments:
 */
public class Routes {
    private static final String PLANETS = "/planets";
    private static final String PEOPLE = "/people";


    //<editor-fold desc="Public Methods">
    public static String planets() {
        return PLANETS;
    }

    public static String planet(int number) {
        return PLANETS + "/" + number;
    }

    public static String people() {
        return PEOPLE;
    }

    public static String person(int number) {
        return PEOPLE + "/" + number;
    }
    //</editor-fold>
}
