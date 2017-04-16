package com.pack.locators;

import org.openqa.selenium.By;

public interface AcademicCalendar {
	
	public static By REHISTRAR				 = By.xpath("//a[@href='/registrar/index.aspx']");
	public static By ACADEMIC_CALENDER_NAV	 = By.xpath("//a[text()='Academic Calendar']");
	public static By ACADEMIC_SCHEDULING	 = By.xpath("//a[text()='Academic Scheduling']");
	public static By APP_FOR_DEGREE			 = By.xpath("//a[text()='Application for Degree']");
	public static By APPEAL_FORM			 = By.xpath("//a[text()='Appeal Form']");
	public static By COMMENCEMENT			 = By.xpath("//a[text()='Commencement']");
	public static By COURSE_BULLETIN		 = By.xpath("//a[text()='Course Bulletin']");
	public static By COURSE_DESCRIPTION		 = By.xpath("//a[text()='Course Description Archive']");
	public static By DEGREE_AUDIT			 = By.xpath("//a[text()='Degree Audit']");
	public static By ENROL_VERIFICATION		 = By.xpath("//a[text()='Enrollment Verification']");
	public static By FAM_EDU_RIGHTS			 = By.xpath("//a[text()='Family Educational Rights']");
	public static By FINAL_EXAM_SCHEDULE	 = By.xpath("//a[text()='Final Exam Schedule']");
	public static By FORMS					 = By.xpath("//a[text()='Forms']");
	public static By GRADE_CHANGE_FORM		 = By.xpath("//a[text()='Grade Change Form']");
	public static By ROOM_RESERVATION		 = By.xpath("//a[text()='Room Reservation']");
	public static By TRANSCRIPT_REQUEST		 = By.xpath("//a[text()='Transcript Request']");
	public static By TUTION_REFUND_POLICY	 = By.xpath("//a[text()='Tuition Refund policy']");
	public static By UNIVERSITY_CTALOG		 = By.xpath("//a[text()='University Catalog']");
	public static By VETERANS_AFFAIRS		 = By.xpath("//a[text()='Veterans Affairs']");
	public static By CONTACT_US				 = By.xpath("//a[text()='Contact Us']");
	
	public static By PDF_LINK				 = By.xpath("//a[text() = 'Download the Administrative Calendar 2017-2018 (pdf)']");
	

}
