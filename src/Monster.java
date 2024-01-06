
public class Monster  {
	private int damage;
	private int healt;
	private int money;
	
	public Monster(int damage,int healt,int money) {
		this.damage=damage;
		this.healt=healt;
		this.money=money;
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
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
