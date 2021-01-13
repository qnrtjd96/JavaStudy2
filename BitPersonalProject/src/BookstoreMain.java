import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import bookstore.BookstoreDataSet;
import bookstore.BookstoreVO;
import login.Login;
import member.MemberDataSet;
import member.MemberVO;

public class BookstoreMain {
	Scanner scan = new Scanner(System.in);
	
	public BookstoreMain() {
		
	}
	
	public void start() {
		//아이디와 비밀번호를 입력받아 로그인 구현하기
		Login.id = conInput("아이디");
		Login.pwd = conInput("비밀번호");
		String num = conInput("관리자면 1번 일반회원이면 2번을 입력하세요");
		
		if(Login.login() && num.equals("2")) { //일반
			MemberDataSet.setMemberList();
			BookstoreDataSet.setBookstoreList();
			do { 
				System.out.println("==================강산서점 회원프로그램입니다.=================");
				String menu = conInput("메뉴[1.책목록, 2.책사기, 3.책검색, 4.잔액충전하기, 5.로그아웃]");
				System.out.println("=========================================================");
				if(menu.equals("5")) {//로그아웃
					break;
				}else if(menu.equals("1")){//책전체목록
					bookstoreOutput();
				}else if(menu.equals("2")) {//책사기
					bookstoreBuy();
				}else if(menu.equals("3")) {//책검색
					bookstoreSearch();
				}else if(menu.equals("4")) {//잔액충전하기
					charging();
				}
			}while(true);
			
		}else if(Login.login() && num.equals("1")) { //관리자 
			BookstoreDataSet.setBookstoreList();
			MemberDataSet.setMemberList();
			do {
				System.out.println("================================강산서점 관리자프로그램입니다.===================================");
				String menu = conInput("메뉴[1.책보기, 2.책등록 , 3.책수정, 4.책삭제, 5.회원목록 6.회원등록 7.회원수정 8. 회원삭제 9.로그아웃]");
				System.out.println("=========================================================================================");
				if(menu.equals("9")) {//로그아웃
					break;
				}else if(menu.equals("1")){//책전체목록
					bookstoreOutput();
				}else if(menu.equals("2")) {//책등록
					bookstoreInsert();
				}else if(menu.equals("3")) {//책수정
					bookstoreEdit();
				}else if(menu.equals("4")) {//책삭제
					bookstoreDel();
				}else if(menu.equals("5")) {//회원목록
					memberOutput();
				}else if(menu.equals("6")) {//회원등록
					memberInsert();
				}else if(menu.equals("7")) {//회원수정
					memberEdit();
				}else if(menu.equals("8")) {//회원삭제
					memberDel();
				}
			}while(true);
			
		}else{ //로그인 실패시 
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	


//----------------------------------------------회원기능영역-----------------------------------------
	public void bookstoreBuy() { //책사기
		String memberName = conInput("회원이름");
		String bookstoreName = conInput("살 책이름");
		MemberVO vo = MemberDataSet.MemberList.get(memberName);
		BookstoreVO vo1 = BookstoreDataSet.BookstoreList.get(bookstoreName);
		String name = vo.getMemberName();
		int youcharge = vo.getCharge();
		int total = vo.getCharge()- vo1.getBooktotal();

		//System.out.println("total = "+ total);
		if(total < 0) {
			System.out.println("잔액이 부족합니다 충전후에 이용하세요.");
		}else if(total > 0){
			System.out.println("구매하신 회원님의 이름은 " + name + "이며 사기전 금액은 " + youcharge + " 였고, 사고난 후 금액은 " + total + "입니다.");
			vo.setCharge(total);
		}else {
			System.out.println("이름이나 책 이름이 잘못되었습니다.");
		}
	}
	
	private void bookstoreSearch() { //책검색
        String bookstoreName = conInput("찾고싶은 책 이름를 검색하세요");
		BookstoreVO vo = BookstoreDataSet.BookstoreList.get(bookstoreName);
        switch (bookstoreName) {
		case "코딩테스트다"   : System.out.println("확인 결과= "+vo.getBookstoreName()+"는 저희서점에 있습니다."); break;
		case "혼자하는 자바"  : System.out.println("확인 결과= "+vo.getBookstoreName()+"는 저희서점에 있습니다."); break;
		case "생활코딩 책"   : System.out.println("확인 결과= "+vo.getBookstoreName()+"는 저희서점에 있습니다.");  break;
		case "do it!자바!"  : System.out.println("확인 결과= "+vo.getBookstoreName()+"는 저희서점에 있습니다."); break;
		case "자바의정석기초" : System.out.println("확인 결과= "+vo.getBookstoreName()+"는 저희서점에 있습니다."); break;
		default : System.out.println("해당 이름의 책은 없습니다."); break;
        }	
	}
	private void charging() {  //잔액충전
		String memberName = conInput("충전할 회원이름");
		MemberVO vo = MemberDataSet.MemberList.get(memberName);  
		if(vo==null) {
			//System.out.println("vo.memberName에 뭐가담겨있니? = "+ vo.getMemberName());
			System.out.println("존재하지 않는 이름입니다.");
		}else {//해당 회원의 정보가 있을때
			int charge1 = vo.getCharge();
			System.out.println("현재 " + vo.getCharge() + "원 있습니다.");
			int charge2 = intInput("얼마를 충전하시겠습니까? ");
			vo.setCharge(charge1+charge2);
			System.out.println("충전된 현재 금액은 = " + vo.getCharge() + "원 입니다. ");
		}
	}

//----------------------------------관리자영역----------------------------------------------------------
//---------------------------------관리자 책 + 일반회원 책 출력만-----------------------------------------
	//책 전체목록 출력
	public void bookstoreOutput() {
		Set<String> keyList = BookstoreDataSet.BookstoreList.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			BookstoreVO vo = BookstoreDataSet.BookstoreList.get(ii.next());
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t\n", vo.getBookstoreNo(), vo.getBookstoreName(), vo.getBookstoreWriter(), vo.getBookstoreSell(), vo.getBookstorePublish(), vo.getStock());
		}
	}
	
	//책등록
	public void bookstoreInsert() {
		int bookstoreNo = Integer.parseInt(conInput("책번호"));
		String bookstoreName = conInput("책이름");
		String bookstoreWriter = conInput("책저자");
		String bookstoreSell = conInput("판매수");
		String bookstorePublish = conInput("출판사");
		int booktotal = intInput("책가격");
		int stock = intInput("재고량");
		
		BookstoreDataSet.BookstoreList.put(bookstoreName, new BookstoreVO(bookstoreNo, bookstoreName, bookstoreWriter, bookstoreSell, bookstorePublish, booktotal, stock));
	}
	
	//책 수정
	public void bookstoreEdit() {
		//책 명
		String bookstoreName = conInput("수정할 책이름");
		
		// 해당 책의 정보가 없을때
		BookstoreVO vo = BookstoreDataSet.BookstoreList.get(bookstoreName);
		if(vo==null) {
			System.out.println("존재하지 않는 책입니다.");
		}else {//해당 책의 정보가 있을때
			//책 이름, 저자, 판매수, 출판사
			String subMenu = conInput("수정할 필드 선택[1.책이름, 2.책저자, 3.판매수, 4.출판사]");
			if(subMenu.equals("1")) {
				String name = conInput("수정할 책이름");
				vo.setBookstoreName(name);
			}else if(subMenu.equals("2")) {
				String writer = conInput("수정할 책저자");
				vo.setBookstoreWriter(writer);
			}else if(subMenu.equals("3")) {
				String sell = conInput("수정할 판매수");
				vo.setBookstoreSell(sell);
			}else if(subMenu.equals("4")) {
				String publish = conInput("수정할 출판사");
				vo.setBookstorePublish(publish);
			}
		}
	}
	
	//책삭제
	public void bookstoreDel() {
		String bookstoreName = conInput("삭제할 책이름");
		BookstoreDataSet.BookstoreList.remove(bookstoreName);
	}
	
	//-------------------------------------책끝-------------------------------------------
	//---------------------------------관리자회원시작------------------------------------------
	//회원 전체목록 출력
	public void memberOutput() {
		Set<String> keyList = MemberDataSet.MemberList.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			MemberVO vo = MemberDataSet.MemberList.get(ii.next());
			System.out.printf("%d\t %s\t %s\t %s\t %s\t \n", vo.getMemberNo(), vo.getMemberName(), vo.getMemberPN(), vo.getMemberId(), vo.getCharge());
		}
	}
	// 등록
	public void memberInsert() {
		int no = Integer.parseInt(conInput("회원번호"));
		String name = conInput("회원이름");
		String writer = conInput("회원전화번호");
		String sell = conInput("회원아이디");
		int charge = 0;
		
		MemberDataSet.MemberList.put(name, new MemberVO(no, name, writer, sell, charge));
	}
		
	//회원 수정
	public void memberEdit() {
		//회원명
		String memberName = conInput("수정할 회원명");
		MemberVO vo = MemberDataSet.MemberList.get(memberName);
		if(vo==null) {// 해당 회원의 정보가 없을때
			System.out.println("존재하지않는 회원입니다.");
		}else {//해당 회원의 정보가 있을때
			//회원 번호, 이름, 전화번호, 아이디
			String subMenu = conInput("수정할 필드 선택[1.회원이름, 2.회원전화번호, 3.회원아이디]");
			if(subMenu.equals("1")) {
				String name = conInput("수정할 회원이름");
				vo.setMemberName(name);
			}else if(subMenu.equals("2")) {
				String Pn = conInput("수정할 회원전화번호");
				vo.setMemberPN(Pn);
			}else if(subMenu.equals("3")) {
				String Id = conInput("수정할 회원아이디");
				vo.setMemberId(Id);
			}else if(subMenu.equals("4")) {
				int charge = intInput("수정할 충전금액");
				vo.setCharge(charge);
			}
		}
	}
	
	//회원삭제
	public void memberDel() {
		String memberNameName = conInput("삭제할 회원이름");
		MemberDataSet.MemberList.remove(memberNameName);
	}
	//----------------------------회원끝--------------------------------------
	
	//콘솔에서 문자입력받아 리턴하는 메소드
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return scan.next();
	}
	
	//콘솔에서 인트형 입력받아 리턴하는 메소드
	public int intInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextInt();
	}
	
	//시작하는메소드
	public static void main(String[] args) {
		new BookstoreMain().start();
		System.out.println("시스템이 종료되었습니다.");
	}

}
