package com.mfrp.javaclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetDetails {

	String username="";
	String password="";
	String details="";
	String query ="";
	
	public HttpServletResponse getData(HttpServletRequest request, HttpServletResponse response, Connection con) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		username = request.getParameter("username");
		password = request.getParameter("password");
		query ="select details from Details where username='"+username+"' and '"+password+"'=(select password from Details where username='"+username+"')";
		
		try {
			System.out.println(username);
			System.out.println(password);
			
			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery(query);
			while(res.next()){
				details += res.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(details.length()>0){
			out.println("<h3>Here the Details</h3>");
			out.println("<p>"+details+"</p>");
		}else{
			out.println("<h3>Oops ! Invalid Entry !</h3>");
		}
		return response;
	}

}
