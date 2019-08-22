package project;

import java.sql.Date;

public class MyDietDTO {
	int mydid;
	String id;
	Date date;
	int amount;
	int did;
	int time;
	public int getMydid() {
		return mydid;
	}
	public void setMydid(int mydid) {
		this.mydid = mydid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}
