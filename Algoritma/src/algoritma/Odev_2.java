package Algoritma;


class Okul{
	private String okul_ismi;
	int fakulte_sayisi;
	int taban_puni;
	
	public Okul (int sayi, int puan) {
		fakulte_sayisi = sayi;
		taban_puni = puan;
	}
	public String getName() {
	    return okul_ismi;
	  }
	public void setName(String newName) {
	    this.okul_ismi = newName;
	  }
	public void akivite() {
		System.out.println("ben akivite yapiyorum");
	}
	private void yarisma() {
		System.out.println("yarismaya katiliyorum");
	}
	
}

class Muhendislik extends Okul {
	public Muhendislik(int sayi, int puan) {
		super(sayi, puan);
		}
	public void akivite() {
		System.out.println("ben spor yapiyoum");
	}
	
	
}

public class Odev_2 {
	public static void main (String [] args) {
		Okul yine_ogrenci = new Okul(55,200);
		Muhendislik yine_ogrenci_2 = new Muhendislik(15,480);
		yine_ogrenci.setName("yine ogenci");
		System.out.println(yine_ogrenci.getName()+" "+yine_ogrenci.fakulte_sayisi +" "+ yine_ogrenci.taban_puni );
		System.out.println(yine_ogrenci_2.fakulte_sayisi +" "+ yine_ogrenci_2.taban_puni);
		yine_ogrenci.akivite();
		yine_ogrenci_2.akivite();
		
	}

}