package engine.planets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 7/6/2021
 * #Comments:
 */
@Data
@JsonIgnoreProperties
public class PlanetsExample {
    private Integer count;
    private String next;
    private Object previous;
    private List<Result> results;
}
