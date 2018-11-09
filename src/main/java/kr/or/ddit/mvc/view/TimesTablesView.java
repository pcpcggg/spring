package kr.or.ddit.mvc.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

//9*9단 출력 custom view
//spring customview를 만들기 위해서는 view interface를 구현할 필요가 있음
public class TimesTablesView implements View {

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw =  response.getWriter();
		
		int guguNum = 0 ;
		
		if(request.getParameter("tables") == null ) {
			guguNum = 9;
		}else {
			guguNum = Integer.parseInt(request.getParameter("tables"));
		}
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("<style>");
		pw.println(" td { border :1px solid #ddd; padding:10px;}");
		pw.println("</style>");
		pw.println("		</head>");
		pw.println("		<body>");
		for(int z = 1; z <= guguNum; z++){
			if( z%2 == 0){
				pw.println(z);
				pw.println("			<table>");
				for(int j = 1; j<= guguNum; j++){
					pw.println("				<tr>");
					for(int i = 2; i <= guguNum; i++ ){
						pw.println("					<td>");
						pw.println(						i + " * " + j + " = " + i*j);
						pw.println("					</td>");
					}
					pw.println("				</tr>");
				}
				pw.println("			</table>");
				pw.println("<br>");
			}
		}
		pw.println("		</body>");
		pw.println("	</html>");
		
	}
	
}
