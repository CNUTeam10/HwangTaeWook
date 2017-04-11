package univ.lecture.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by taewook on 2017. 4. 11..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int teamId;
    private long now;
    private double result;
}