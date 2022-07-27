package co.dev.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청정보 유틸정보 포워딩 정보 구현
public class Utils {
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) {
		RequestDispatcher rd = req.getRequestDispatcher(path);
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}
}
