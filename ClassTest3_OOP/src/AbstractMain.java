
public class AbstractMain extends AbstractTesst{
	
	
	public AbstractMain() {
		
	}
	
	//추상메소드 오버라이딩
	public void output() {
		System.out.println("num --> " + num);
		System.out.println("num --> " + name);
	}

	public void sum(int max) {
		int total = 0;
		for (int i = 1; i <= max; i++) {
			total += i;
		}
		System.out.println("1~" + max + "까지의 합은 " + total);
	}
	
	public void start() {
		
	}
	
	public static void main(String[] args) {
		AbstractMain am = new AbstractMain();
		am.sum(100);
		//추상클래스는 객체를 생성할 수 없다.
		//AbstractTest at = new AbstractTest
	}

}
