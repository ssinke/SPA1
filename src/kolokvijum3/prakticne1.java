package kolokvijum3;

import org.svetovid.Svetovid;

public class prakticne1 {
	public static void prviZadatak(){
		Skup<String> s = new Skup<String>();
		String u = "a";
		do{
			u = Svetovid.in.readString("Unesite string:");
			if(!u.equals("."))
				s.ubaci(u);
		}while(!u.equals("."));
		
		System.out.println(s);
	}
	
	public static void drugiZadatak(){
		Skup<Integer> s = new Skup<Integer>();
		String imeF = "brojevi.txt";
		while(!Svetovid.in(imeF).isEmpty()){
			s.ubaci(Svetovid.in(imeF).readInt());
		}
		Svetovid.in("brojevi.txt").close();
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		
		drugiZadatak();
		
	}

}
