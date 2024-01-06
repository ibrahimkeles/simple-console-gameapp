
public class Player {
	private String name;
	private int money=20;
	private Character character;
	
	public Player(String name, Character character) {
		this.name = name;
		this.character=character;
		System.out.println("Hesabınız başarılı bir şekilde oluşturuldu.");
	}
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public Character getCharacter() {
		return character;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
