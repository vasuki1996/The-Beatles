package com.beatles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class storeUsers {
    private StandardServiceRegistry ssr;
    private Metadata meta;
    private SessionFactory factory;
    private Session session;
    private Transaction t;

    public storeUsers(){
        ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        meta = new MetadataSources(ssr).getMetadataBuilder().build();

        factory = meta.getSessionFactoryBuilder().build();
        session = factory.openSession();
        t = session.beginTransaction();
    }

    public boolean login(String uname,String pass){
        boolean logStat=false;
        String losq="from users where username=:user and password=:pass";
        Query query=session.createQuery(losq);
        List l = query.list();
        Iterator i = l.iterator();
        if(i.hasNext()){
            logStat=true;
        }
        return logStat;
    }

    public String getUsername(){
        TUsers temp = new TUsers();
        String uname = temp.getUname();
        temp=null;
        return uname;
    }

    public String getEmailID() {
        TUsers temp = new TUsers();
        String em = temp.getEmail();
        temp=null;
        return em;
    }

    public ArrayList getUnameEmail() {
        TUsers temp = new TUsers();
        ArrayList l = new ArrayList();
        l.add(temp.getUname());
        l.add(temp.getEmail());
        temp=null;
        return l;
    }

    public void register(String uname,String pass,String emailid){
        TUsers temp = new TUsers();
        temp.setEmail(emailid);
        temp.setUname(uname);
        temp.setPassword(pass);
    }
}
