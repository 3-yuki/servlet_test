package sonota;

public class sell_my_soul {

	public static void main(String[] args) {

		int a = 135;

		try{
			int n = a % 10;

			if(n == 0){
				System.out.println(n);
			}else{
				Exception e = new Exception("例外");
				throw e;

			}

		}catch(NullPointerException e){

			System.out.println("ぬるぽ");

		}catch(ArithmeticException e){

			System.out.println("ありす");

		}catch(RuntimeException e){

			System.out.println("例外発生！");

		}
		System.out.println("end");

	}
}