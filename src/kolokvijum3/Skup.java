package kolokvijum3;

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
	
	public Skup(){
		zaglavlje = new Element();
		zaglavlje.veza = zaglavlje;
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
	
	public void stampajSve(){
		Element tekuci = zaglavlje.veza;
		while(tekuci!=zaglavlje){
			System.out.println(tekuci.info);
			tekuci=tekuci.veza;
		}
	}
}
