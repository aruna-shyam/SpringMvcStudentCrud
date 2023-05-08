package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.StudentDao;
import com.techpalle.model.Admin;
import com.techpalle.model.Student;

@Controller
public class StudentController 
{
	@RequestMapping(value="validate")
	public ModelAndView validateAdmin(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv=new ModelAndView();
	
		String name=req.getParameter("tbname");
		String email=req.getParameter("tbemail");
		String pw=req.getParameter("tbpw");
		
		Admin a=new Admin(name,email,pw);
		
		boolean b=StudentDao.validateAdmin(a);
		
		if(b==true)
			mv.setViewName("adminPage.jsp");
		else
			mv.setViewName("index.jsp");
		return mv;
	}
		
	@RequestMapping(value="student",params="showAll")
	public ModelAndView dispalyAllStudents()
	{
		ModelAndView mv=new ModelAndView();
		
		//call the dao method
		ArrayList<Student> alstud=StudentDao.getAllStudents();
		
		//we need to redirect the user to display.jsp with ArrayList data
		mv.addObject("student",alstud);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping(value="student",params="showReg")
	public ModelAndView getRegistrationPage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("registration.jsp");
		return mv;
	}
	
	@RequestMapping(value="insert")
	public ModelAndView insertStudent(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv=new ModelAndView();
		
		String name=req.getParameter("tbname");
		String email=req.getParameter("tbemail");
		String pw=req.getParameter("tbpw");
		long mob=Long.parseLong(req.getParameter("tbmob"));
		
		Student s=new Student(name,email,pw,mob);
		
		StudentDao.insertStudent(s);
		
		mv=dispalyAllStudents();
		
		return mv;
	}
	
	@RequestMapping(value="editForm")
	public ModelAndView getEditPage(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv=new ModelAndView();
		
		int no=Integer.parseInt(req.getParameter("sno"));
		Student s=StudentDao.getOneStudent(no);
		mv.addObject("student", s);
		mv.setViewName("updatePage.jsp");

		return mv;
	}
	
	@RequestMapping(value="update")
	public ModelAndView editStudent(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv=new ModelAndView();
		
		int no=Integer.parseInt(req.getParameter("sno"));
		String name=req.getParameter("tbname");
		String email=req.getParameter("tbemail");
		String pw=req.getParameter("tbpw");
		long mob=Long.parseLong(req.getParameter("tbmob"));
		
		Student s=new Student(no,name,email,pw,mob);
		
		StudentDao.updateStudent(s);
		
		mv=dispalyAllStudents();
		
		return mv;
	}
	
	@RequestMapping(value="deleteForm")
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv=new ModelAndView();
		
		int no=Integer.parseInt(req.getParameter("sno"));
		StudentDao.deleteStudent(no);
		
		mv=dispalyAllStudents();

		return mv;
	}

}