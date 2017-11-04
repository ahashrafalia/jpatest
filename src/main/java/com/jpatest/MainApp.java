package com.jpatest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.jpatest.model.Courses;
import com.jpatest.model.MyUser;
import com.jpatest.model.Students;
import com.jpatest.model.Univ;
import com.jpatest.model.UnivAddress;

public class MainApp {
	  public static void main(String[] args) {
	    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	    entityManager.getTransaction().begin();

	    // Check database version
	    /*String sql = "select version()";

	    String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
	    System.out.println(result);*/
	    
	   /* MyUser myus=new MyUser();
	    myus.setUsername("username");
	    myus.setPassword("ii$SD");
	    entityManager.persist(myus);*/
	    
	  /*  UnivAddress uadd=new UnivAddress();
	    uadd.setStreet("Noth Street");
	    uadd.setCity("Tirunelveli");
	   
	    Univ univ=new Univ();
	    univ.setUnivName("MS Univ");
	    univ.setUnivAddress(uadd);
	    uadd.setUniv(univ);
	    
	    Students s1=new Students();
	    s1.setStudentName("Ashraf");
	    
	    Students s2=new Students();
	    s2.setStudentName("Ershath");
	    
	    
	    Students s3=new Students();
	    s3.setStudentName("Peer");
	    
	    Students s4=new Students();
	    s4.setStudentName("Riz");
	    
	    List<Students> stuList1=new ArrayList<>();
	    stuList1.add(s1);
	    stuList1.add(s2);
	    
	    List<Students> stuList2=new ArrayList<>();
	    stuList2.add(s3);
	    
	    List<Students> stuList3=new ArrayList<>();
	    stuList3.add(s4);
	    
	    
	    Courses c1=new Courses();
	    c1.setCourseName("CSE");
	    c1.setStudents(stuList1);
	    c1.setUniv(univ);
	    s1.setCourses(c1);
	    s2.setCourses(c1);
	    
	    Courses c2=new Courses();
	    c2.setCourseName("EEE");
	    c2.setStudents(stuList2);
	    c2.setUniv(univ);
	    s3.setCourses(c2);
	    
	    Courses c3=new Courses();
	    c3.setCourseName("MECH");
	    c3.setStudents(stuList3);
	    c3.setUniv(univ);
	    s4.setCourses(c3);
	    
	    List<Courses> listcourses=new ArrayList<Courses>();
	    listcourses.add(c1);
	    listcourses.add(c2);
	    listcourses.add(c3);
	    univ.setCourses(listcourses);
	    
	    entityManager.persist(univ);
	    
	    
	    entityManager.getTransaction().commit();
	    */
	    
	    System.out.println("For Retriving-----------------");
	    
	    Univ univer=entityManager.find(Univ.class, 87l);
	    List<Courses> listcour=(List<Courses>) univer.getCourses();
	    
	    for(Courses cour:listcour){
	    	 List<Students> liststud=(List<Students>)cour.getStudents();
	    	 for(Students stu:liststud){
	    		 System.out.println("Student name="+stu.getStudentName()+", CourseName="+cour.getCourseName()+",univName="+univer.getUnivName());
	    	 }
	    	System.out.println();
	    }
	    System.out.println("University="+univer);
	    
	    entityManager.close();

	    JPAUtil.shutdown();
	  }
	}
