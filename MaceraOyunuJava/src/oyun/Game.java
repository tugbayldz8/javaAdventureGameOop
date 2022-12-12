package oyun;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("***Macera Oyununa Hosgeldinizzz***");
		System.out.print("Oyuna Baslamadan Once Isminizi Giriniz:");
		// String playerName=scan.nextLine();
		player = new Player("a");
		player.selectCha();
		start();
	}

	public void start() {
		while (true) {
			System.out.println("\n===========================================================\n");
			System.out.println("Eylem gerceklestirmek icin bir yer seciniz:\n");
			System.out.println("1- Ev --> Size ait guvenli mekan, dusman yok!");
			System.out.println("2- Magara --> Karsiniza zombi cikabilir!");
			System.out.println("3- Orman --> Karsiniza vampir cikabilir!");
			System.out.println("4- Nehir --> Karsiniza ayi cikabilir!");
			System.out.println("5- Magaza --> Silah veya zirh alabilirsiniz!");
			System.out.print("Gitmek istediginiz yer: ");
			int selLoc = scan.nextInt();
			while (selLoc < 1 || selLoc > 5) {
				System.out.print("Gecerli bir yer seciniz: ");
				selLoc = scan.nextInt();
			}
			switch (selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}

			if (location.getName()=="Ev") {
				if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Tebrikler oyunu kazandiniz!!!");
					break;
				}
			}

			if (!location.getLocation()) {
				System.out.println("Oyun bitti");
				break;
			}
		}
	}

}
