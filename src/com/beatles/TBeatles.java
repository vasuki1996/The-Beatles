package com.beatles;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name= "beatles")

public class TBeatles {
    @Id
    private String albumName;
    private int relYear,ep,lp,sp;
    private java.sql.Date relDate;

    public String getAlbum(){
        return albumName;
    }

    public int getRelYear() {
        return relYear;
    }

    public int getEp() {
        return ep;
    }

    public int getLp(){
        return lp;
    }

    public int getSp() {
        return sp;
    }

    public java.sql.Date getRelDate() {
        return relDate;
    }

    public void setAlbumName(String albumName){
        this.albumName=albumName;
    }

    public void setRelYear(int relYear){
        this.relYear=relYear;
    }

    public void setEp(int ep) {
        this.ep=ep;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public void setSp(int sp) {
        this.sp=sp;
    }

    public void setRelDate(java.sql.Date relDate) {
        this.relDate = relDate;
    }
}
