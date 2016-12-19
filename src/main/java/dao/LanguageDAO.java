package dao;

import java.util.List;

import pojo.Language;
import util.JDBCTemplate;

public class LanguageDAO {
	public List<Language> getLanguages() throws Exception{
		String sql = "select * from language";
		return JDBCTemplate.queryData(sql, null, Language.class);
	}
}
