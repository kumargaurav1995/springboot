package com.springboot.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.*;
import org.springframework.*;

@Controller  


public class ShowController {
	@RequestMapping("show")
public ModelAndView show(@RequestParam("city")String city) throws SQLException, ClassNotFoundException{
	ModelAndView mv=new ModelAndView();
	//processing
	
	String url="jdbc:mysql://localhost:3306/student1?autoReconnect=true&useSSL=false";
	String user="root";
	String pass="kskg1009@";
	String query="select name from studentinfo1 where city=?";
	
	
		Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection(url, user, pass);
	PreparedStatement st1=con.prepareStatement(query);
	
	ResultSet rs=st1.executeQuery();
	
	while(rs.next()){
		rs.getString("name");
	}
	
	st1.close();
	con.close();
	mv.addObject("name",rs);
	mv.setViewName("result.jsp");

	
	return mv;
	
}
}
