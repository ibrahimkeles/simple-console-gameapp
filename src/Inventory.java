
public class Inventory {
	public Inventory(Armor armor, Weapon weapon) {
		this.armor = armor;
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	private Armor armor;
	private Weapon weapon;

}
