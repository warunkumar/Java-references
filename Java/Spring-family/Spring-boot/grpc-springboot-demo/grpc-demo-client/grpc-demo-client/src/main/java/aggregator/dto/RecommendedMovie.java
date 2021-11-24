package aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Warun
 * @createdOn 12-10-2021
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendedMovie {

    private String title;
    private int year;
    private double rating;

}
