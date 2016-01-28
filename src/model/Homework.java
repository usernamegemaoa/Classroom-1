package model;
import java.sql.Date;

public class Homework {
	private String name;
	private Date endDate;
	private String info;
	private String subject;
	
	
	public Homework(String name, String subject, Date endDate, String info) {
		this.name = name;
		this.endDate = endDate;
		this.info = info;
		this.subject = subject;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
