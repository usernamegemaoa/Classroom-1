package model;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class HomeworkDescriptor {
	List<Homework> homeworks;

	public HomeworkDescriptor() {
		homeworks= new ArrayList<Homework>();
	}
	
	
	public void generateData(ResultSet rs) throws SQLException{
		
		while (rs.next()) {
			String name = rs.getString("name");
			String subject = rs.getString("subject");
			Date date = rs.getDate("end_date");
			String info = rs.getString("info");
			Homework hw = new Homework(name, subject, date, info);
			homeworks.add(hw);		
			
		}
	}


	public List<Homework> getHomeworks() {
		return homeworks;
	}


	public void setHomeworks(ArrayList<Homework> homeworks) {
		this.homeworks = homeworks;
	}
	
}
