package kolokvijum3;

import org.svetovid.Svetovid;

public class prakticne1brojevi {
	
	public static void drugiZadatak(){  //moj nacin u 1 metodi, mnogo efikasniji algoritam
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
	
	public static Skup<Integer> ucitajBrojeve(String imeF){
		Skup<Integer> s = new Skup<Integer>();
		int uFajlu = 0;
		while(!Svetovid.in(imeF).isEmpty()){
			s.ubaci(Svetovid.in(imeF).readInt());
			uFajlu++;
		}
		Svetovid.in(imeF).close();
		System.out.println(s);
		System.out.println("U fajlu je bilo " + uFajlu + " brojeva, a u skupu " + s.velicina() + ".");
		System.out.println("Bilo je " + (uFajlu-s.velicina()) + " duplikata.");
		
		return s;
	}
	
	public static void ispisUFajl(Skup<Integer> s , String imeF){
		if(s.velicina()>0){
			Integer n[] = s.napraviNiz();
			for(Integer r : n){
				Svetovid.out(imeF).println(r);
			}
			Svetovid.out(imeF).close();
		}else{
			Svetovid.out(imeF).println();
			Svetovid.out(imeF).close();
		}
	}
	
	public static void main(String[] args) {
		Skup<Integer> s = ucitajBrojeve("brojevi.txt");
		ispisUFajl(s , "brojevi-bez-duplikata.txt");
	}

}
