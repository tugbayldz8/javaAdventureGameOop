package oyun;

public class SafeHouse extends NormalLoc {

   SafeHouse(Player player) {
		super(player,"Ev");
		
	}
   public boolean getLocation() {
	player.setHealthy(player.getrHealthy());
	System.out.println("Caniniz fullendi\nSuan guvenli evdesiniz...");
	return true;
}
   

}
