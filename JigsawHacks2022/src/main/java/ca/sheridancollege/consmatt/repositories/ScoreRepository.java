package ca.sheridancollege.consmatt.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.consmatt.beans.Score;

@Repository
public class ScoreRepository {

@Autowired
private NamedParameterJdbcTemplate jdbc;

public void addScore(Score score) {
	MapSqlParameterSource parameters = new MapSqlParameterSource();
	String query = "INSERT INTO scores (name, score) VALUES (:name, :score )";
	parameters.addValue("name", score.getName());
	parameters.addValue("score", score.getScore());
	jdbc.update(query, parameters);
}

public ArrayList<Score> getScores() {
	ArrayList<Score> scores = new ArrayList<Score>();
	MapSqlParameterSource parameters = new MapSqlParameterSource();
	String query = "SELECT * FROM scores";
	List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
	
	for (Map<String, Object> row: rows) {
		Score d = new Score();
		d.setId((Integer)row.get("id"));
		d.setScore((Double)row.get("score"));
		d.setName((String)row.get("name"));
		scores.add(d);	
	}
	return scores;
}

	
}
