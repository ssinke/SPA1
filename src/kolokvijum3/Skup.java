package kolokvijum3;
import java.lang.reflect.Array;
public class Skup<T> {
	class Element{
		T info;
		Element veza;
		
		public Element(){
			this.info=null;
			this.veza=null;
		}
		
		public Element(T info){
			this.info=info;
			this.veza=null;
		}
	}
	
	Element zaglavlje;
	int brojac;
	
	public Skup(){
		zaglavlje = new Element();
		zaglavlje.veza = zaglavlje;
		brojac=0;
	}
	
	public boolean pripada(T clan){
		zaglavlje.info=clan;
		Element tekuci = zaglavlje.veza;
		while(!tekuci.info.equals(clan)){
			tekuci=tekuci.veza;
		}
		return tekuci!=zaglavlje;
	}
	
	public boolean ubaci(T clan){
		if(!pripada(clan)){
			Element novi = new Element(clan);
			novi.veza=zaglavlje.veza;
			zaglavlje.veza=novi;
			brojac++;
			return true;
		}else{
			return false;
		}
	}
	
	public String toString() {
	      String rezultat = "Skup {";
	      Element tekuci = zaglavlje.veza;
	      if (tekuci != zaglavlje) {
	         rezultat += " " + tekuci.info;
	         tekuci = tekuci.veza;
	      }
	      while (tekuci != zaglavlje) {
	         rezultat += ", " + tekuci.info;
	         tekuci = tekuci.veza;
	      }
	      return rezultat + " }";
	}
	
	public int velicina() {
		return brojac;
	}
	
	public boolean jePrazan() {
		return brojac == 0;
	}
	
	public boolean izbaci(T clan) {
		if (clan == null)
			return false;
		zaglavlje.info = clan;
		Element prethodni = zaglavlje;
		while (!prethodni.veza.info.equals(clan)) {
			prethodni = prethodni.veza;
		}
		if (prethodni.veza != zaglavlje) {
			prethodni.veza = prethodni.veza.veza;
			brojac--;
			return true;
		} else {
			return false;
		}
	}
	
	public void ubaciSve(Skup<T> skup) {
		if (skup == null)
			return;

		Element tekuci = skup.zaglavlje.veza;
		while (tekuci != skup.zaglavlje) {
			ubaci(tekuci.info);
			tekuci = tekuci.veza;
		}
	}
	
	public Skup<T> unija(Skup<T> drugi) {
		Skup<T> rezultat = new Skup<T>();
		rezultat.ubaciSve(this);
		rezultat.ubaciSve(drugi);
		return rezultat;
	}
	
	public Skup<T> presek(Skup<T> drugi) {
		Skup<T> rezultat = new Skup<T>();
		if (drugi != null) {
			Element tekuci = zaglavlje.veza;
			while (tekuci != zaglavlje) {
				if (drugi.pripada(tekuci.info)) {
					rezultat.ubaci(tekuci.info);
				}
				tekuci = tekuci.veza;
			}
		}
		return rezultat;
	}
	
	public Skup<T> razlika(Skup<T> drugi) {
		Skup<T> rezultat = new Skup<T>();
		if (drugi != null) {
			Element tekuci = zaglavlje.veza;

			while (tekuci != zaglavlje) {
				if (!drugi.pripada(tekuci.info)) {
					rezultat.ubaci(tekuci.info);
				}
				tekuci = tekuci.veza;
			}
		} else
			rezultat.ubaciSve(this);
		return rezultat;
	}
	
	public boolean podskupOd(Skup<T> drugi) {
		if (drugi == null)
			return brojac == 0;
		Element tekuci = zaglavlje.veza;
		while (tekuci != zaglavlje) {
			if (!drugi.pripada(tekuci.info)) {
				return false;
			}
			tekuci = tekuci.veza;
		}
		return true;
	}
	
	public T[] napraviNiz() {
		if (brojac > 0) {
			@SuppressWarnings("unchecked")
			T[] rez = (T[]) Array
					.newInstance(zaglavlje.info.getClass(), brojac);

			int i = 0;
			Element tekuci = zaglavlje.veza;
			while (tekuci != zaglavlje) {
				rez[i++] = tekuci.info;
				tekuci = tekuci.veza;
			}
			return rez;
		} else {
			return null;
		}
	}
}
