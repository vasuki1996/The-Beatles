package com.beatles;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name= "beatles")

public class TBeatles {
    private String albumName;
    private int relYear,ep,lp,sp;
    private java.sql.Date relDate;

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name="albumName")
    public String getAlbum(){
        return albumName;
    }

    public void setAlbumName(String albumName){
        this.albumName=albumName;
    }

    @Column(name="relYear")
    public int getRelYear() {
        return relYear;
    }

    public void setRelYear(int relYear){
        this.relYear=relYear;
    }

    @Column(name="ep")
    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep=ep;
    }

    @Column(name = "lp")
    public int getLp(){
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    @Column(name = "sp")
    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp=sp;
    }

    @Column(name = "relDate")
    public java.sql.Date getRelDate() {
        return relDate;
    }

    public void setRelDate(java.sql.Date relDate) {
        this.relDate = relDate;
    }
}
