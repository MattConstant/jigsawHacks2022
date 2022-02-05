package ca.sheridancollege.consmatt.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {

	private int id;
	private String name;
	private double score;
	
}
