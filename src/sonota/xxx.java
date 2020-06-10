package sonota;

public class xxx {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int a = 10;
		int b = 0;
		int result = 5;
		
		try{
			result = a / b;
			System.out.println(result);
			
		}catch(ArithmeticException e){
			
			System.out.println("0除算発生");
		
		}
		System.out.println("end");
	}

}
