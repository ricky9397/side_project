package bbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.BbsDao;

public class BbsDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BbsDao dao = BbsDao.getInstance();
		int bbsNum = Integer.parseInt(request.getParameter("bbsNum")); 
		dao.delete(bbsNum);
	}
}
