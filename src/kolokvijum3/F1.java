package kolokvijum3;

import org.svetovid.Svetovid;

public class F1 {
	public static Skup<String> unosSampiona(String imeF){
		Skup<String> f1 = new Skup<String>();
		String ime,prezime;
		int godina;
		while(!Svetovid.in(imeF).isEmpty()){
			godina = Svetovid.in(imeF).readInt();
			ime = Svetovid.in(imeF).readString();
			prezime = Svetovid.in(imeF).readString();
			
			f1.ubaci(ime + " " + prezime);
		}
		Svetovid.in(imeF).close();
		return f1;
	}
	
	public static void ispisUFajl(String imeF , Skup<String> sampioni){
		if(imeF!=null && sampioni.velicina()>0){
			String[] nizSampiona = sampioni.napraviNiz();
			for(String u : nizSampiona){
				Svetovid.out(imeF).println(u);
			}
			Svetovid.out(imeF).close();
		}else{
			Svetovid.out(imeF).println();
			Svetovid.out(imeF).close();
		}
	}
	
	public static Skup<String> unosPobednika(String imeF){
		Skup<String> f1 = new Skup<String>();
		String ime,prezime;
		int pobeda;
		while(!Svetovid.in(imeF).isEmpty()){
			ime = Svetovid.in(imeF).readString();
			prezime = Svetovid.in(imeF).readString();
			pobeda = Svetovid.in(imeF).readInt();
			
			f1.ubaci(ime + " " + prezime);
		}
		Svetovid.in(imeF).close();
		return f1;
	}
	
	public static void main(String[] args) {
		Skup<String> sampioni = unosSampiona("sampioni-po-godinama.txt");
		System.out.println(sampioni);
		ispisUFajl("sampioni.txt" , sampioni);
		System.out.println();
		
		Skup<String> pobednici = unosPobednika("pobednici.txt");
		Skup<String> bezSampionata = pobednici.razlika(sampioni);
		System.out.println("Vozaci koji imaju bar jednu pobedu, a nikada nisu bili sampioni:");
		System.out.println(bezSampionata);
		ispisUFajl("pobednici-bez-sampionata.txt" , bezSampionata);
		
	}

}
