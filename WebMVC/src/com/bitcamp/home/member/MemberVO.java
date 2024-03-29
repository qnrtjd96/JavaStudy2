package com.bitcamp.home.member;

public class MemberVO {
	private int no;
	private String userid;
	private String usepwd;
	private String username;
	
	private String tel;
	private String tel1;
	private String tel2;
	private String tel3;
	
	private String email;
	private String emailid;
	private String emaildomain;
	
	private String zipcode;
	private String addr;
	private String detailaddr;
	
	private String[] interest;
	private String InterestStr="";
	
	private String regdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsepwd() {
		return usepwd;
	}
	public void setUsepwd(String usepwd) {
		this.usepwd = usepwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		tel = tel1+ "-" + tel2 + "-" + "tel3";
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
		String[] t = tel.split("-");
		tel1 = t[0];
		tel2 = t[1];
		tel3 = t[2];
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getEmail() {
		email = emailid+"@"+ emaildomain;
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		
		String e[] = email.split("@");
		emailid = e[0];
		emaildomain = e[1];
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getEmaildomain() {
		return emaildomain;
	}
	public void setEmaildomain(String emaildomain) {
		this.emaildomain = emaildomain;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDetailaddr() {
		return detailaddr;
	}
	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String interest[]) {
		this.interest = interest;
		
		//배열의 값을 문자열로 for(String i: interest) { InterestStr += i+ "/"; }
		 
	}
	public String getInterestStr() {
		//배열의 값을 문자열로
		for(String i: interest) {
			InterestStr += i+ "/";
		}
		return InterestStr;
	}
	public void setInterestStr(String interestStr) {
		//문자열을 배열로
		this.InterestStr = interestStr;
		//관심분야 배열로 만들어 interest에 추가
		interest = interestStr.split("/");
		
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
