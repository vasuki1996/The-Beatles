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



    public void connClose(){
        factory.close();
        session.close();
    }
}
