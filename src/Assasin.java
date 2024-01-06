
public class Assasin extends Character {
	public Assasin() {
		super(5,15,new Inventory(new Armor(0,"Basit giysi",0),new Weapon(0,"Basit bıçak",0)));
		System.out.println("Karakter Seçimi : Suikastçi { Hasar : 5 - Sağlık : 15 }");	
	}
}
