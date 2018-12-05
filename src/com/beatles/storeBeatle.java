package com.beatles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Iterator;

public class storeBeatle {
    private StandardServiceRegistry ssr;
    private Metadata meta;
    private SessionFactory factory;
    private Session session;
    private Transaction t;

    public storeBeatle(){
        ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        meta = new MetadataSources(ssr).getMetadataBuilder().build();

        factory = meta.getSessionFactoryBuilder().build();
        session = factory.openSession();
        t = session.beginTransaction();
    }
    public void set(int relYear,String albumName,int ep,int lp,int sp,java.sql.Date relDate){
        TBeatles temp = new TBeatles();
        temp.setAlbumName(albumName);
        temp.setRelDate(relDate);
        temp.setRelYear(relYear);
        temp.setEp(ep);
        temp.setLp(lp);
        temp.setSp(sp);
        session.save(temp);
        t.commit();
        System.out.println("successfully saved");
        t =null;
    }

    public ArrayList getAll(){
        TBeatles gTemp = new TBeatles();
        ArrayList details = new ArrayList();
        details.add(gTemp.getRelDate());
        details.add(gTemp.getAlbum());
        details.add(gTemp.getRelYear());
        details.add(gTemp.getEp());
        details.add(gTemp.getLp());
        details.add(gTemp.getSp());
        return details;
    }

    public ArrayList getAsId(ArrayList ids){
        TBeatles giTemp = new TBeatles();
        ArrayList list = new ArrayList();
        Iterator i = ids.iterator();
        while(i.hasNext()){
            char a = i.next().toString().charAt(0);
            switch (a){
                case 'a' : list.add(giTemp.getAlbum()); break;
                case 's' : list.add(giTemp.getSp()); break;
                case 'e' : list.add(giTemp.getEp()); break;
                case 'l' : list.add(giTemp.getLp()); break;
                case 'y' : list.add(giTemp.getRelYear()); break;
                case 'd' : list.add(giTemp.getRelDate()); break;
                default : System.out.println("Error");
            }
        }
        return list;
    }
    
     public List hqlSelect(String hql) {
        Query query=session.createQuery(hql);
        query.setFirstResult(5);
        query.setMaxResults(20);
        return query.list();
    }

    public int hqlInsert(String hql) {
        Query q=session.createQuery(hql);
        int status=q.executeUpdate();
        System.out.println(status);
        t.commit();
        return status;
    }

    public void update(Map m){
        TBeatles temp = new TBeatles();
        Set set = m.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry entry=(Map.Entry)i.next();
            char a = entry.getKey().toString().charAt(0);
            switch(a){
                case 'a' : temp.setAlbumName(entry.getValue().toString()); break;
                case 's' : temp.setSp(Integer.parseInt(entry.getValue().toString())); break;
                case 'e' : temp.setEp(Integer.parseInt(entry.getValue().toString())); break;
                case 'l' : temp.setLp(Integer.parseInt(entry.getValue().toString())); break;
                case 'y' : temp.setRelYear(Integer.parseInt(entry.getValue().toString())); break;
                case 'd' : temp.setRelDate((java.sql.Date)entry.getValue()); break;
                default : System.out.println("Error");
            }
        }
        session.update(temp);
        t.commit();
        t=null;
    }


    public void connClose(){
        factory.close();
        session.close();
    }
}
