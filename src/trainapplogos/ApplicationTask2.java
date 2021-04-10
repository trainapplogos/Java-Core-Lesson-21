package trainapplogos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class ApplicationTask2 {
	public static void main(String[] args) {
//		System.out.println(ZoneId.systemDefault());
		
		System.out.println(ConvertFromDateToLocalDate());
		System.out.println(ConvertFromDateToLocalTime());
		System.out.println(ConvertFromDateToLocalDateTime()); 
	}
	
	public static LocalDate ConvertFromDateToLocalDate() {
		Date date = new Date();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalTime ConvertFromDateToLocalTime() {
		Date date = new Date();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}
	
	public static LocalDateTime ConvertFromDateToLocalDateTime() {
		Date date = new Date();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}

