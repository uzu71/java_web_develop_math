package math;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutputServlet
 */
@WebServlet("/output-servlet")
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストスコープからデータ取得
		String howStr = (String) request.getAttribute("how");
		String number0Str = (String) request.getAttribute("number0");
		String number1Str = (String) request.getAttribute("number1");
		String number2Str = (String) request.getAttribute("number2");
		
		// レスポンスのコンテンツタイプおよびエンコーディング方式を指定
		response.setContentType("text/html; charset=UTF-8");

		// レスポンス書き出し用オブジェクトの取得
		PrintWriter out = response.getWriter();
		
		// ---数値保持変数---
		int number0Int = 0;
		int number1Int = 0;
		int number2Int = 0;
				
		// ---結果保持変数---
		int result = 0;
		double resultd = 0.0;
		
		// ---数値の検証と変換---
		if (number0Str != null && number0Str.matches("\\d+")) {
			number0Int = Integer.parseInt(number0Str);
		}
				
		if (number1Str != null && number1Str.matches("\\d+")) {
			number1Int = Integer.parseInt(number1Str);
		}
				
		if (number2Str != null && number2Str.matches("\\d+")) {
			number2Int = Integer.parseInt(number2Str);
		}
		
		// ---計算---
		// 階乗
		if ("階乗".equals(howStr)) {
			result = number0Int;
		    for (int i = 2; i < number0Int; i++) {
		    	result *= i;
		    }
		}
				
		// 等差数列
		if("等差数列".equals(howStr)) {
			result = number0Int + (number1Int * (number2Int - 1));
		}
						
		// 等比数列
		if("等比数列".equals(howStr)) {
			resultd = (double)number0Int * Math.pow(number1Int, (number2Int - 1));
			result = (int)resultd;
		}
				
		// 最小公倍数
		if("最小公倍数".equals(howStr)) {
			int a0 = number0Int;
			int b0 = number1Int;
			int a = a0;
			int b = b0;
			int c;
					 
			while((c = a % b) != 0){
				a = b;
				b = c;
			}
					 
			int g = b;
			result = (a0 / g) * (b0 / g) * g;
		}
				
		// 最大公約数
		if("最大公約数".equals(howStr)) {
			int a0 = number0Int;
			int b0 = number1Int;
			int a = a0;
			int b = b0;
			int c;
					 
			while((c = a % b) != 0){
				a = b;
				b = c;
			}
					 
			result = b;
		}
		
		// 計算結果をリクエストの属性に追加
		request.setAttribute("how", howStr);
		request.setAttribute("answer", result);
		
		// JSPへフォワード
		ServletContext ctx = getServletContext();
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/Print.jsp");
		dispatcher.forward(request, response);

	}

}
