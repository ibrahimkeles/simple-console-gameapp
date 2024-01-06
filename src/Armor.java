
public class Armor {
	int defence;
	String name ;
int money;
	
	public Armor(int defence, String name, int money) {
	this.defence = defence;
	this.name = name;
	this.money = money;
}

	public int getMoney() {
	return money;
}

public void setMoney(int money) {
	this.money = money;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	


	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	
}
