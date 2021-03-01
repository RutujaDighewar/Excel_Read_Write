package com.app.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.model.Student;

public class Impl {

	private static Connection con=null;
	private static String url="jdbc:mysql://localhost:3306/excel";
	private static String username="root";
	private static String password="root";
	private boolean flag=Boolean.FALSE;
	
	Scanner sc=new Scanner(System.in);
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertEmployee(List<Student> studentList) {
	try(PreparedStatement ps=con.prepareStatement("insert into student(name,address) values(?,?)");){
		for(Student stud : studentList) {
			ps.setString(1,stud.getName());
			ps.setString(2, stud.getAddress());
			ps.executeUpdate();
			flag=Boolean.TRUE;
		}
	}catch(Exception e) {
	e.printStackTrace();
	}
	if(flag==Boolean.TRUE) {
		System.out.println("Inserted successfully");
	}else {
		System.out.println("Failed");
	}
	
	}
}
