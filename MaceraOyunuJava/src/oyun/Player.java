package oyun;

import java.util.Scanner;

public class Player {
	private int damage, healthy, money, rHealthy;
	private String name, cName;
	private Inventory inv;
	

	Scanner scan=new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inv=new Inventory();
		 
	}

	public void selectCha() {
		switch(chaMenu()) {
		case 1:
			initPlayer("Samuray", 5, 21, 15);
			break;
		case 2:
			initPlayer("Okcu", 7, 18, 20);
			break;
		case 3:
			initPlayer("Sovalye", 8, 24, 5);
			break;
		default:
			initPlayer("Samuray", 5, 21, 15);
			break;
		}
		System.out.println("Karakter: "+getcName()+"\t Hasar: "+getDamage()+"\t Saglik: "+getHealthy()+"\t Para: "+getMoney());
	}
	
	
	public int chaMenu() {
		System.out.println("Lutfen bir karakter seciniz.");
		System.out.println("1- Samuray --> \tHasar: 5 \tSaglik: 21 \tPara: 15");
		System.out.println("2- Okcu --> \tHasar: 7 \tSaglik: 18 \tPara: 20");
		System.out.println("3- Sovalye --> \tHasar: 8 \tSaglik: 24 \tPara: 5");
		System.out.print("Seciminiz: ");
		int chaId=scan.nextInt();
		
		while(chaId<1 || chaId>3) {
			System.out.print("Gecerli bir karakter seciniz: ");
			chaId=scan.nextInt();
		}
		
		return chaId;
	}
	
	public int getTotalDamage() {
		return this.getDamage()+this.getInv().getDamage();
	}
	
	public void initPlayer(String cname, int dmg, int hlthy, int mny) {
		setcName(cname);
		setDamage(dmg);
		setHealthy(hlthy);
		setMoney(mny);
		setrHealthy(hlthy);
		
	}
	
	public int getrHealthy() {
		return rHealthy;
	}

	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
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

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	
}
