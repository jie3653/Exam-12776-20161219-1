package service;

import java.util.List;

import dao.FilmDAO;
import pojo.Film;

public class FilmService {
	FilmDAO fd = new FilmDAO();

	public List<Film> getAllFilm() {
		// TODO Auto-generated method stub
		try {
			return fd.getAllFilm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
