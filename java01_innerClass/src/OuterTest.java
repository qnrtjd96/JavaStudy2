

public class OuterTest {
	
	int num =1234;
	String name = "세종대왕";
	
	public OuterTest() {
			System.out.println("OuterTest() 생성자확인");
			
	}
	public void outerPrint() {
		System.out.println(num + " -> " + name);
		//외부클래스에서는 내부 클래스의 정보를 사용할수 없다.
		//객체로 만들면 사용이 가능하다.
		//System.out.println(no +" ===> "+ username);
		
		//내부클래스 객체 만들기 - 현재 클래스(외부클래스) 내에서 내부 클래스를 객체 생성가능하다.
		//메소드내의 내부클레스는 메소드 호출시 생성된다.
		InnerTest it = new InnerTest();
		it.innerPrint();
		
	}
	//내부 클래스(멤버)
	class InnerTest{
		int no = 6789;
		String username = "이순신";
		InnerTest(){
			System.out.println("InnerTest() 생성자 확인");
		}
		public void innerPrint() {
			System.out.println(no + " =======> " + username);
			//내부 클래스에서는 외부 클래스의 정보를 사용할 수 있다.
			System.out.println(num + "======> " + name);
		}
	}

	public static void main(String[] args) {
		OuterTest ot = new OuterTest();
		ot.outerPrint();
		
		//외부에서 내부클래스 객체를 생성하기 위해서는 외부 클래스 객체를 이용하여 내부 클래스 객체를 생성하여야한다.
		
		OuterTest ot2 = new OuterTest();
		OuterTest.InnerTest it = ot2.new InnerTest();
		it.innerPrint();
	}

}
