package project;

import java.sql.Date;

public class MyExerDTO {
	int myeid;
	String id;
	Date date;
	int amount;
	int eid;
	boolean result;
	
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public int getMyeid() {
		return myeid;
	}
	public void setMyeid(int myeid) {
		this.myeid = myeid;
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
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	@Override
	public String toString() {
		return "MyExerDTO [myeid=" + myeid + ", id=" + id + ", date=" + date + ", amount=" + amount + ", eid=" + eid
				+ ", result=" + result + "]";
	}
	
}
