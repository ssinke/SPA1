package kolokvijum3;

public class ProbaSkupa {

	public static void main(String[] args) {
		Skup<Integer> in = new Skup<Integer>();
		for(int i=0; i<=5; i++){
			in.ubaci(i);
		}
		System.out.println(in);
	}

}
