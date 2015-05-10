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
		int uFajlu = 0;
		int citaj;
		while(!Svetovid.in(imeF).isEmpty()){
			citaj=Svetovid.in(imeF).readInt();
			if(uFajlu == 0)
				Svetovid.out("brojevi-bez-duplikata.txt").println(citaj);
			else{
				if(!s.pripada(citaj))
					Svetovid.append("brojevi-bez-duplikata.txt").println(citaj);
			}
			s.ubaci(citaj);
			uFajlu++;
		}
		Svetovid.in("brojevi.txt").close();
		Svetovid.out("brojevi-bez-duplikata.txt").close();
		System.out.println(s);
		System.out.println("U fajlu je bilo " + uFajlu + " brojeva, a u skupu " + s.velicina() + ".");
		System.out.println("Bilo je " + (uFajlu-s.velicina()) + " duplikata.");
	}
	
	public static void main(String[] args) {
		
		drugiZadatak();
		
	}

}
