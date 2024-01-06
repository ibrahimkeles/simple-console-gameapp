import java.util.Scanner;

public class Store implements ILocation {

	@Override
	public void getLocation() {
		System.out.println(
				"Mağazaya hoş geldiniz. Burada silah veya zırh satın alıp karakterinizi güçlendirebilirsiniz.");
	}

	Armor[] armors = { new Armor(2, "Çelik zırh", 15), new Armor(4, "Platin Zırh", 30), new Armor(6, "Elmas Zırh", 50),
			new Armor(8, "Nadir Zırh", 100) };

	Weapon[] weapons = { new Weapon(2, "Çelik bıçak", 15), new Weapon(4, "Platin bıçak", 30),
			new Weapon(6, "Elmas bıçak", 50), new Weapon(8, "Nadir bıçak", 100) };

	public Armor showArmors(Scanner scanner) {
		while (true) {
			for (int i = 0; i < armors.length; i++) {
				System.out.println(i + 1 + " - " + armors[i].getName() + " Para : " + armors[i].getMoney());
			}
			try {
				int selectedArmor = scanner.nextInt();
				return armors[selectedArmor - 1];
			} catch (Exception e) {
				System.out.println("Yanlış bir karakter girdiniz! Yalnızca numeric değer geçerlidir.");
			}
		}

	}

	public Weapon showWeapons(Scanner scanner) {
		while (true) {
			for (int i = 0; i < weapons.length; i++) {
				System.out.println(i + 1 + " - " + weapons[i].getName() + " Para : " + weapons[i].getMoney());
			}
			try {
				int selectedArmor = scanner.nextInt();
				return weapons[selectedArmor - 1];
			} catch (Exception e) {
				System.out.println("Yanlış bir karakter girdiniz! Yalnızca numeric değer geçerlidir.");
			}
		}
	}

	public boolean buyWeapon(Player player, Weapon weapon, Scanner scanner) {
		Inventory inventory = player.getCharacter().getInventory();
		if (player.getMoney() >= weapon.getMoney()) {
			System.out.println("Seçilen Silah : " + weapon.getName() + " Saldırı Değeri : " + weapon.getAttack()
					+ " Para : " + weapon.getMoney());
			System.out.println("");

			while (true) {
				try {
					System.out.println("Satın Al: 1 \t Vazgeç : 2");
					int choice = scanner.nextInt();
					if (choice == 1) {
						System.out.println("Satın Alım başarılı artık daha güçlüsünüz...");
						inventory.setWeapon(weapon);
						player.setMoney(player.getMoney()-weapon.getMoney());
					return true;
						
					} else if (choice == 2) {
						break;
					} else {
						System.out.println("1 veya 2 seçebilirsiniz. Yanlış bir karakter girişi yaptınız!");
					}
				} catch (Exception e) {
					System.out.println("Yalnızca numeric değer girebilirsiniz.");
				}
			}

			return true;
		} else {
			System.out.println("Yeterli paranız bulunmamaktadır.");
			return false;
		}

	}

	public boolean buyArmor(Player player, Armor armor, Scanner scanner) {
		Inventory inventory = player.getCharacter().getInventory();
		if (player.getMoney() >= armor.getMoney()) {
			System.out.println("Seçilen Silah : " + armor.getName() + " Savunma Değeri : " + armor.getDefence()
					+ " Para : " + armor.getMoney());
			System.out.println("");

			while (true) {
				try {
					System.out.println("Satın Al: 1 \t Vazgeç : 2");
					int choice = scanner.nextInt();
					if (choice == 1) {
						System.out.println("Satın Alım başarılı artık daha güçlüsünüz...");
						inventory.setArmor(armor);
						player.setMoney(player.getMoney()-armor.getMoney());
						return true;
						
					} else if (choice == 2) {
						break;
					} else {
						System.out.println("1 veya 2 seçebilirsiniz. Yanlış bir karakter girişi yaptınız!");
					}
				} catch (Exception e) {
					System.out.println("Yalnızca numeric değer girebilirsiniz.");
				}
			}

		
		} else {
			System.out.println("Yeterli paranız bulunmamaktadır.");

		}
		return false;
	}
}
