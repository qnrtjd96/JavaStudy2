package login;

public class Login {
	
	public static String num;
	public static String id;
	public static String pwd;
	
	//관리자, 일반회원 두개로 구분할것
	public static String login(String num) {
		//System.out.println("들어갔니?  : login3===== " + Login.id + "  password3===== " + Login.pwd +"  num3======= " + Login.num);
		if (id == "" || pwd == "") {
			System.out.println("아이디와 비밀번호를 입력후 로그인하세요.");
			return num = "0";
		} else {
			if(id.equals("master") && pwd.equals("1234")) {
				//System.out.println("login4===== " + Login.id + "  password4===== " + Login.pwd +"  num4======= " + Login.num);
				return num = "1";
			}else if(id.equals("123") && pwd.equals("123")){
				//System.out.println("login5===== " + Login.id + "  password5===== " + Login.pwd +"  num5======= " + Login.num);
				return num = "2";
			}else {
				//System.out.println("login6===== " + Login.id + "  password6===== " + Login.pwd +"  num6======= " + Login.num);
				return num = "0";
			}
		}
	}
}
