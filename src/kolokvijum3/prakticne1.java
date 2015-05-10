package kolokvijum3;

import org.svetovid.Svetovid;

public class prakticne1 {
	
	public static void main(String[] args) {
		
		Skup<String> s = new Skup<String>();
		String u = "a";
		do{
			u = Svetovid.in.readString("Unesite string:");
			if(!u.equals("."))
				s.ubaci(u);
		}while(!u.equals("."));
		
		System.out.println(s);
		
	}

}
