package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.Admin;
import com.techpalle.model.Student;

//below class is used to write JDBC code
public class StudentDao
{
	private static String classname="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/spring1";
	private static String user="root";
	private static String pw="admin";
	
	private static Connection con=null;
	private static Statement st=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private final static String insertStudent="insert into Student(name,email,password,mobile) values(?,?,?,?)";
	private static final String displayAllStudentsQry="select * from student";
	private final static String updateStudent="update student set name=?,email=?,password=?,mobile=? where sno=?";
	private final static String getOneStudent="select * from student where sno=?";
	private final static String deleteStudent="delete from student where sno=?";
	
	private final static String validateAdmin="select * from admin where name=? and email=? and pw=?";
	
	public static Connection basic()
	{
		try 
		{
			Class.forName(classname);
			con=DriverManager.getConnection(url, user, pw);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static boolean validateAdmin(Admin a)
	{
		boolean result=false;
		try 
		 {
		    con=basic();
			ps=con.prepareStatement(validateAdmin);
			ps.setString(1,a.getName());
			ps.setString(2, a.getEmail());
			ps.setString(3, a.getPw());
			rs=ps.executeQuery();
			result=rs.next();
		 } 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		 finally
		 {
				try 
				{
				  if(ps!=null)
					  ps.close();
				  if(con!=null)
					  con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		 }
		return result;
	}
	
	public static void deleteStudent(int sno)
	{
		 try 
		 {
		    con=basic();
			ps=con.prepareStatement(deleteStudent);
			ps.setInt(1,sno);
			ps.executeUpdate();
			
			
		 } 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		 finally
		 {
				try 
				{
				  if(ps!=null)
					  ps.close();
				  if(con!=null)
					  con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		 }
	}
	
	
	public static Student getOneStudent(int sno)
	{
		Student s=null;
		 try 
		 {
		    con=basic();
			ps=con.prepareStatement(getOneStudent);
			ps.setInt(1,sno);
			rs=ps.executeQuery();
			rs.next();
			int no=rs.getInt(1);
			String name=rs.getString(2);
			String email=rs.getString(3);
			String pw=rs.getString(4);
			long mob=rs.getLong(5);
		     s=new Student(no, name, email, pw, mob);
			
		 } 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		 finally
		 {
				try 
				{
				  if(ps!=null)
					  ps.close();
				  if(con!=null)
					  con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		 }
		return s;
	}
	
	public static void updateStudent(Student s)
	{
		 try 
		 {
			con=StudentDao.basic();
			ps=con.prepareStatement(updateStudent);
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3,s.getPassword());
			ps.setLong(4,s.getMobile());
			ps.setInt(5,s.getSno());
			ps.executeUpdate();
			
		 } 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		 finally
		 {
				try 
				{
				  if(ps!=null)
					  ps.close();
				  if(con!=null)
					  con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		 }
	}
	
	public static void insertStudent(Student s)
	{
		 try 
		 {
			con=StudentDao.basic();
			ps=con.prepareStatement(insertStudent);
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3,s.getPassword());
			ps.setLong(4,s.getMobile());
			ps.executeUpdate();
			
		 } 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		 finally
		 {
				try 
				{
				  if(ps!=null)
					  ps.close();
				  if(con!=null)
					  con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		 }
	}
	
	public static ArrayList<Student> getAllStudents()
	{
		con=basic();
		ArrayList<Student>al=new ArrayList<Student>();
		
		try 
		{
			st=con.createStatement();
		    rs=st.executeQuery(displayAllStudentsQry);
		    while(rs.next())
		    {
		    	int sno=rs.getInt(1);
		    	String name=rs.getString(2);
		    	String email=rs.getString(3);
		    	String pw=rs.getString(4);
		    	long mob=rs.getLong(5);
		    	
		    	Student s=new Student(sno, name, email, pw, mob);
		    	
		    	al.add(s);
		    }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		 finally
		 {
				try 
				{
				  if(rs!=null)
				     rs.close();
				  if(st!=null)
					 st.close();
				  if(con!=null)
					 con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		 }
		
		return al;
	}
}