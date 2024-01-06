import java.util.Scanner;

public class Game {
	Scanner scanner = new Scanner(System.in);

	public void start() {
		System.out.println("Macera oyununa hoş geldiniz.");
		Player player = createPlayer();
		System.out.println("Artık maceraya hazırsınız. Haydi hemen başlayalım! ");
		selectLocation(player);
	}

	public Player createPlayer() {
		System.out.println("Lütfen kullanıcı adınızı giriniz");
		String name = scanner.nextLine();
		Character character = selectCharacter();
		return new Player(name, character);
	}

	public Character selectCharacter() {
		while (true) {
			try {
				System.out.println("Lütfen karakterinizi seçiniz");
				System.out.println("1 - Suikastçi");
				System.out.println("2 - Okçu");
				System.out.println("3 - Savaşçı");

				int characterId = scanner.nextInt();

				switch (characterId) {
				case 1:
					return new Assasin();
				case 2:
					return new Archer();
				case 3:
					return new Warrior();
				default:
					System.out.println(
							"Yanlış bir seçim yaptınız. Lütfen (1,2,3) değerlerinden birini seçerek tekrar deneyiniz.");
				}
			} catch (Exception e) {
				System.out.println("Yanlış karakter girdiniz. Yalnızca numara girişi yapabilirsiniz. (1,2,3)");
				scanner.nextLine();
			}
		}
	}

	public ILocation selectLocation(Player player) {

		while (true) {
			try {
				System.out.println("-- Gitmek istediğiniz yeri seçiniz. -- ");
				System.out.println("1- Güvenli Ev ( Burada canınız +2 değerinde artar. )");
				System.out
						.println("2- Fısıltı Ormanı ( Burada tehlikeli Taş Kayalar bulunur hasar gücü 3, sağlık 14 )");
				System.out.println("3- Issız Park ( Burada tehlikeli zombiler bulunur hasar gücü 4, sağlık 10 )");
				System.out.println(
						"4- Gizli bir canavar ( Burada tehlikeli bir canavar bulunur. Hasar gücü 7 ile 15 sağlık 30 ile 45 aralığında canavar karşınıza çıkar)");
				System.out.println("5- Mağaza ( Karakterinizi güçlendirmek için bir şeyler satın alın...)");
				int locationId = scanner.nextInt();

				switch (locationId) {
				case 1:
					SafeHouse safeHouse = new SafeHouse(player);
					safeHouse.getLocation();
					safeHouse.healPlayer();
					break;
				case 2:
					WhisperForest whisperForest = new WhisperForest();
					whisperForest.getLocation();
					fight(whisperForest.createBattle(), player);
					break;
				case 3:
					DesertedPark desertedPark = new DesertedPark();
					desertedPark.getLocation();
					fight(desertedPark.createBattle(), player);
					break;
				case 4:
					BossPlace bossPlace = new BossPlace();
					bossPlace.getLocation();
					fight(bossPlace.createBattle(), player);
					break;
				case 5:
					Store store = new Store();
					store.getLocation();
					showStore(store, player);
					break;
				default:
					System.out.println(
							"Yanlış bir seçim yaptınız. Lütfen (1,2,3,4) değerlerinden birini seçerek tekrar deneyiniz.");
					break;
				}

			} catch (Exception ex) {
				System.out.println("Yanlış karakter girdiniz. Yalnızca numara girişi yapabilirsiniz. (1,2,3,4)");
				scanner.nextLine();
			}
		}
	}

	public void end() {
		
		System.exit(0);
	}

	public void fight(Battle battle, Player player) {

		Character chracter = player.getCharacter();

		Inventory inventory = chracter.getInventory();
		Armor armor = inventory.getArmor();
		Weapon weapon = inventory.getWeapon();

		int chracterDamage = chracter.getDamage() + weapon.attack;

		Monster monster = battle.getMonster();
		int monsterDamage = monster.getDamage() - armor.defence;

		System.out.println("Hasarınız " + chracterDamage + " Canınız : " + chracter.getHealt());
		System.out.println("Canavarın Hasarı :  " + monsterDamage + " Canavarın Canı  : " + monster.getHealt());
		while (true) {

			System.out.println("Saldır : 1 \t Geri Çekil: 2 ");
			try {

				int choice = scanner.nextInt();
				if (choice == 2) {
					break;
				} else if (choice == 1) {

					System.out.println("Saldırı başlatılıdı. ");
					System.out.println("");
					monster.setHealt(monster.getHealt() - chracterDamage);

					System.out.println("Canavara " + chracterDamage + " hasar verdiniz!" + " Canavarın canı : "
							+ monster.getHealt());
					chracter.setHealt(chracter.getHealt() - monsterDamage);

					System.out.println("");
					System.out.println("Canavar size " + monsterDamage + " hasar verdi!" + " Sizin canınız : "
							+ chracter.getHealt());
					if (monster.getHealt() <= 0) {
						System.out.println("Canavarını yendiniz! ");
						System.out.println("Kazanılan Para : " + monster.getMoney());
						player.setMoney(player.getMoney() + monster.getMoney());
						System.out.println("Toplam paranız :  : " + player.getMoney());
						break;
					}
					if (chracter.getHealt() <= 0) {
						System.out.println("Canavar sizi yendi! Oyun bitti... ");
						end();
						break;
					}

				} else {
					System.out.println(
							"Yanlış bir seçim yaptınız. Lütfen (1,2) değerlerinden birini seçerek tekrar deneyiniz.");

				}

			} catch (Exception e) {
				System.out.println("Yanlış karakter girdiniz. Yalnızca numara girişi yapabilirsiniz. (1,2)");
				scanner.nextLine();
			}
		}

	}

	public void showStore(Store store, Player player) {
		

		while (true) {
			try {

				System.out.println("1- Zırhlar");
				System.out.println("2- Silahlar");
				System.out.println("3- Geri dön");

				int storeId = scanner.nextInt();
				if (storeId == 1) {
					Armor armor = store.showArmors(scanner);
					if(!store.buyArmor(player,armor,scanner)) {
						continue;
					}
					break;
				} 
				else if (storeId == 2) {
					Weapon weapon = store.showWeapons(scanner);
					if(!store.buyWeapon(player,weapon,scanner)) {
						continue;
					}
					break;
				} 
				else if(storeId==3) {
					break;
				}
				else {
					System.out.println(
							"Yanlış bir seçim yaptınız. Lütfen (1,2,3) değerlerinden birini seçerek tekrar deneyiniz.");
				
				}

			} catch (Exception ex) {
				System.out.println("Yanlış karakter girdiniz. Yalnızca numara girişi yapabilirsiniz. (1,2,3,4)");
				scanner.nextLine();
			}
		}
	}
	
}
