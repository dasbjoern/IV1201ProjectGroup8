package com.projectgroup8.iv1201.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RecruitmentController {

	// @Autowired
	// private DataSource dataSource;


//example code.
@GetMapping("/")
	public String hello(Model model) {

		//TEMP TEST CODE from prev course. Björn

		// Connection connectDB = null;
		// String oneResult = "";

		// try{
		//  connectDB = dataSource.getConnection();
        //     //start new query

           
        //     Statement derbyQuery = connectDB.createStatement(); 
        //     ResultSet queryResults = derbyQuery.executeQuery("select name from person");
		// 	connectDB.close();
		// 	oneResult = (String)queryResults.getString("table"); //first name
		// 	model.addAttribute("name", oneResult);


		// }catch(SQLException  e){
				//system.out.println(e.getMessage());
			//    }
		return "hello";
	}


}
