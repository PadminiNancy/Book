package com.padmini.database;



import org.hibernate.*;

public class LoginDao {

	
	public Login addUser(Login user)
	{
		
		Session session =  SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addUser(session,user); 
        tx.commit();
        session.close();
        return user;
	}
	
	public void addUser(Session session,Login user)
	{
		Login l = new Login();
		l.setLastname(user.getLastname());
		l.setPassword(user.getPassword());
		session.save(l);
	}
}
