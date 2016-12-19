package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Film;
import pojo.Language;
import service.FilmService;
import service.LanguageService;

public class FilmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @author �ܽ�
	 * service
	 * �����̨����Ա���й�����
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ú�̨����������
		String command = request.getParameter("command");
		if("getAllFilm".equals(command)){	
			getAllFilm(request,response);
		}
	}

	private void getAllFilm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		FilmService fs = new FilmService();
		LanguageService ls = new LanguageService();
		List<Film> films = fs.getAllFilm();
		List<Language> languages = ls.getLanguages();
		//����
		request.setAttribute("films",films);
		request.setAttribute("languages",languages);
		System.out.println(films.size());
		System.out.println(languages.size());
		try {
			request.getRequestDispatcher("film.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
