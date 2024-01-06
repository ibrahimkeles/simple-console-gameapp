import java.util.concurrent.ThreadLocalRandom;

public class BossPlace implements ILocation{

	@Override
	public void getLocation() {
		System.out.println("Özel bölgeye geldiniz. Burada bir çok boos bulunmakta hemen buradan kaçın...");
		
	}
	public Battle createBattle() {
		int randomDamage = ThreadLocalRandom.current().nextInt(7, 15+ 1);
		int randomHealt = ThreadLocalRandom.current().nextInt(30, 45+ 1);
		int randomMoney = ThreadLocalRandom.current().nextInt(10, 25+ 1);
	
		System.out.println("Savaş başladı! Karşınızda bir bos bulunuyor! Lütfen dikkatli olun ölebilirsiniz...");
		return  new Battle(new Monster(randomDamage,randomHealt,randomMoney));
	}

}
