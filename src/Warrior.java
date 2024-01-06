
public class Warrior extends Character {
	public Warrior() {
		super(4, 17, new Inventory(new Armor(0, "Basit giysi", 0), new Weapon(0, "Basit bıçak", 0)));
		System.out.println("Karakter Seçimi : Savaşçı { Hasar : 4 - Sağlık : 17 }");

	}
}
