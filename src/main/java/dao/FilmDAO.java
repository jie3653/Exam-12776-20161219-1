package dao;

import java.util.List;

import pojo.Film;
import util.JDBCTemplate;

public class FilmDAO {
	public List<Film> getAllFilm() throws Exception{
		String sql = "select * from film";
		List<Film> films = JDBCTemplate.queryData(sql, null, Film.class);
		return films;
		
	}
}
