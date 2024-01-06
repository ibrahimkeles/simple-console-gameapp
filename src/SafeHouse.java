
public class SafeHouse implements ILocation {
	Player player;

	public SafeHouse(Player player) {
		this.player = player;

	}

	public void healPlayer() {
		Character chracter = this.player.getCharacter();
		chracter.setHealt(chracter.getHealt() + 2);
		System.out.println("Dinlenmek size iyi geldi. Canınız 2 derece iyileşti. Canınız : " + chracter.getHealt());
	}

	@Override
	public void getLocation() {
		System.out.println(
				"Güvenli eve hoş geldiniz. Sıcak bir ev ve huzurlu bir ortamdasınız şimdi güzelce iyileşin...");
		
	}
}
