package math;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MathServlet
 */
@WebServlet("/input-servlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String howStr = request.getParameter("how");
		String number0Str = request.getParameter("number0");
		String number1Str = request.getParameter("number1");
		String number2Str = request.getParameter("number2");
		
		// リクエストスコープへのデータ格納
		request.setAttribute("how", howStr);
		request.setAttribute("number0", number0Str);
		request.setAttribute("number1", number1Str);
		request.setAttribute("number2", number2Str);
				
		// 転送オブジェクトを取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("output-servlet");

		// 転送
		dispatcher.forward(request, response);
	}

}
