package kolokvijum3;

class Cuvar<T> {
	T info;
	
	public String toString(){
		return "Cuvam:" + info;
	}
	
	public Cuvar(){
		info = null;
	}
	
	public Cuvar(T podatak){
		this.info = podatak;
	}
}

public class OpstiTipovi{

	public static void main(String[] args) {
		Cuvar<String> st = new Cuvar<String>();
		st.info = "Proba za String";
		System.out.println(st);
		
		Cuvar<Integer> broj = new Cuvar<Integer>();
		broj.info = 5;
		System.out.println(broj);
		
		Cuvar<Character> karakter = new Cuvar<Character>('s');
		System.out.println(karakter);
	}

}
