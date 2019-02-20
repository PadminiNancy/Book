package com.padmini.database;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

	public Student addUser(Student stud, int tid)
	{
		
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addStud(session,stud, tid); 
        tx.commit();
        session.close();
        return stud;
	}
	
	public void addStud(Session session,Student stud,int tid)
	{
		Login l = new Login();
		l.setTid(tid);
		Student s = new Student();
		s.setName(stud.getName());;
		s.setGrade(stud.getGrade());
		s.setLogin(l);
		session.save(s);
	}
	
}
