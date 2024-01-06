
public class DesertedPark implements ILocation{
	@Override
	public void getLocation() {
		System.out.println("Issız bir parktasınız. Ölüler burada canlanıyor... Her yerde ölüler var ... Buradan uzaklaşın....");
	}
	public Battle createBattle() {
		System.out.println("Savaş başladı! Karşınızda bir zombi var onu yenerek ıssız parkı bu canavarlardan temizleyin!");
		return  new Battle(new Zombi());
	}
}
