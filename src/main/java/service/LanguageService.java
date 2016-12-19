package service;

import java.util.List;

import dao.LanguageDAO;
import pojo.Language;

public class LanguageService {
	LanguageDAO ld = new LanguageDAO(); 
	public List<Language> getLanguages() {
		// TODO Auto-generated method stub
		try {
			return ld.getLanguages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
