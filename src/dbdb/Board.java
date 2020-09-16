package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Board implements Serializable {
    private String name;
    private String mail;
    private String comment;
    private Timestamp time;


    public Board(String key) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Timestamp getTime() {
        return time;
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

}

