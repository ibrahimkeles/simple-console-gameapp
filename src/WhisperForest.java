
public class WhisperForest implements ILocation {
	
	@Override
	public void getLocation() {
		System.out.println("Fısıltı ormanına geldiniz. Kulakları tırmalayan bir fısıltı var Grantlar her yerde yerde yerde ölüler var.");
	}
	public Battle createBattle() {
		System.out.println("Savaş başladı! Karşınızda bir grant var onu yenerek fısıltı ormanı bu canavarlardan temizleyin!");
		return  new Battle(new Grant());
	}
	
}
