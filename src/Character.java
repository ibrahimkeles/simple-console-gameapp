
public class Character {

	public Character(int damage, int healty, Inventory inventory) {

		this.damage = damage;
		this.healt = healty;
		this.inventory = inventory;

	}

	public int getDamage() {

		return damage;
	}

	public void setDamage(int damage) {

		this.damage = damage;
	}

	public int getHealt() {
		return healt;
	}

	public void setHealt(int healt) {

		this.healt = healt;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	private int damage;
	private int healt;
	private Inventory inventory;
}
