package oyun;

public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "Magaza");
	}

	public boolean getLocation() {
		System.out.println("Para Miktariniz: " + player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zirhlar");
		System.out.println("3. Cikis");
		System.out.print("Seciminiz: ");
		int selTool = scan.nextInt();
		int selItemId;

		switch (selTool) {
		case 1:
			selItemId = weaponMenu();
			buyWeapon(selItemId);
			break;
		case 2:
			selItemId = armorMenu();
			buyArmor(selItemId);
			break;
		}
		return true;
	}

	public int weaponMenu() {
		System.out.println("1. Tabanca\t <Para : 25 - Hasar: 2>");
		System.out.println("2. Kilic\t <Para : 35 - Hasar: 3>");
		System.out.println("3. Tufek\t <Para : 45 - Hasar: 7>");
		System.out.println("4. Iptal");
		System.out.print("Silah Seciniz: ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}

	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch (itemID) {
		case 1:
			damage = 2;
			wName = "Tabanca";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "Kilic";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Tufek";
			price = 45;
			break;
		case 4:
			System.out.println("Cikis Yapiliyor");
			break;
		default:
			System.out.println("Gecersiz Islem");
			break;
		}
		if (price > 0) {
			if (player.getMoney() > price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + " satin aldiniz. Onceki Hasar: " + player.getDamage() + " Yeni Hasar: "
						+ player.getTotalDamage());
				System.out.println("Kalan Para: "+player.getMoney());
			} else {
				System.out.println("Bakiye yetersiz, fakir...");
			}
		}
	}

	public int armorMenu() {
		System.out.println("1. Hafif \t <Hasar: 1 - Para: 15>");
		System.out.println("2. Orta \t <Hasar: 3 - Para: 25>");
		System.out.println("3. Agir \t <Hasar: 5 - Para: 40>");
		System.out.println("4. Iptal");
		System.out.print("Zirh Seciniz: ");
		int selArmorID = scan.nextInt();
		return selArmorID;

	}

	public void buyArmor(int itemID) {
		int avoid = 0, price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			avoid = 1;
			price = 15;
			aName = "Hafif Zirh";
			break;
		case 2:
			avoid = 3;
			price = 15;
			aName = "Orta Zirh";
			break;
		case 3:
			avoid = 5;
			price = 40;
			aName = "Agir Zirh";
			break;
		case 4:
			System.out.println("Cikis Yapiliyor");
			break;
		default:
			System.out.println("Gecersiz Islem");
			break;
		}
		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " satin aldiniz. Engellenen Hasar: " + player.getInv().getArmor()
						+ " Kalan Para: " + player.getMoney());
			} else {
				System.out.println("Bakiye yetersiz, fakir...");
			}
		}

	}

}
