
public class Archer extends Character {
	public Archer() {
		super(6, 12, new Inventory(new Armor(0, "Basit giysi", 0), new Weapon(0, "Basit bıçak", 0)));
		System.out.println("Karakter Seçimi : Okçu { Hasar : 6 - Sağlık : 12 }");
	}
}
