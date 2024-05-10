package rpgRevamp;
import java.util.Random;
import javax.swing.JOptionPane;
public class Items {
	
	private final String ITEM1 = "Small Heal";
	private final String ITEM2 = "Large Heal";
	private final String ITEM3 = "Senzu";
	private final String ITEM4 = "Attack Up";
	private final String ITEM5 = "Defense Up";
	private final String ITEM6 = "Hyper Charge";
	private final String ITEM7 = "Static Momentum";
	private final String ITEM8 = "Dragon Balls";
	private static int smallHealItemAmount = 1;
	private static int largeHealItemAmount = 1;
	private static int senzuAmount = 1;
	private static int attackUpAmount = 1;
	private static int defenseUpAmount = 1;
	private static int hyperChargeAmount = 1;
	private static int staticMomentumAmount = 1;
	private final int SMALL_HEAL_AMOUNT = 1000;
	private final int LARGE_HEAL_AMOUNT = 5000;
	private static int dragonBallAmount = 0;
	private final int TOTAL_DRAGON_BALLS = 7;
	Random findDragonBall = new Random();
	private int foundDragonBall = 0;
	private String chosenPlayer = "null";
	private static boolean potaras = false;
	private static int points;
	private final String ITEM9 = "Potara Earrings";
	
	public int getSmallHealItemAmount() {
		return smallHealItemAmount;
	}
	public int getSmallHealAmount() {
		return SMALL_HEAL_AMOUNT;
	}
	public int getLargeHealItemAmount() {
		return largeHealItemAmount;
	}
	public int getLargeHealAmount() {
		return LARGE_HEAL_AMOUNT;
	}
	public int getSenzuAmount() {
		return senzuAmount;
	}
	public int getAttackUpAmount() {
		return attackUpAmount;
	}
	public int getDefenseUpAmount() {
		return defenseUpAmount;
	}
	public int getHyperChargeAmount() {
		return hyperChargeAmount;
	}
	public int getStaticMomentumAmount() {
		return staticMomentumAmount;
	}
	public String getITEM1() {
		return ITEM1;
	}
	public String getITEM2() {
		return ITEM2;
	}
	public String getITEM3() {
		return ITEM3;
	}
	public String getITEM4() {
		return ITEM4;
	}
	public String getITEM5() {
		return ITEM5;
	}
	public String getITEM6() {
		return ITEM6;
	}
	public String getITEM7() {
		return ITEM7;
	}
	public void increaseSmallHealItemAmount() {
		smallHealItemAmount++;
	}
	
	public void decreaseSmallHealItemAmount() {
		smallHealItemAmount--;
	}
	
	public void increaseLargeHealItemAmount() {
		largeHealItemAmount++;
	}
	
	public void decreaseLargeHealItemAmount() {
		largeHealItemAmount--;
	}
	
	public void increaseSenzuHealItemAmount() {
		senzuAmount++;
	}
	
	public void decreaseSenzuHealItemAmount() {
		senzuAmount--;
	}
	
	public void increaseAttackUpAmount() {
		attackUpAmount++;
	}
	
	public void decreaseAttackUpAmount() {
		attackUpAmount--;
	}
	
	public void increaseDefenseUpAmount() {
		defenseUpAmount++;
	}
	
	public void decreaseDefenseUpAmount() {
		defenseUpAmount--;
	}
	
	public void increaseHyperChargeAmount() {
		hyperChargeAmount++;
	}
	
	public void decreaseHyperChargeAmount() {
		hyperChargeAmount--;
	}
	
	public void increaseStaticMomentumAmount() {
		staticMomentumAmount++;
	}
	
	public void decreaseStaticMomentumAmount() {
		staticMomentumAmount--;
	}
	public int getDragonBallAmount() {
		return dragonBallAmount;
	}
	
	public void findDragonBall() {
		foundDragonBall = findDragonBall.nextInt(2);
		if (dragonBallAmount == TOTAL_DRAGON_BALLS)
		{
		}
		else if (foundDragonBall == 0)
		{
			JOptionPane.showMessageDialog(null, "You found a Dragon Ball!");
			System.out.println("You found a draon ball!");
			dragonBallAmount++;
			Items.addPoints(500000);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You didn't find a Dragon Ball");
			System.out.println("You didn't find a Dragon Ball");
		}
	}
	/**
	 * @return the tOTAL_DRAGON_BALLS
	 */
	public int getTOTAL_DRAGON_BALLS() {
		return TOTAL_DRAGON_BALLS;
	}
	/**
	 * @return the foundDragonBall
	 */
	/**
	 * @return the iTEM8
	 */
	public String getITEM8() {
		return ITEM8;
	}
	
	public void useDragonBalls(AttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4) {
		String playerConfirmation = "no";
		do
		{
			JOptionPane.showMessageDialog(null, "Shenron: State your wish.");
			chosenPlayer = JOptionPane.showInputDialog("Who do you want to power up?\n" + player1 + "\n" + player2 + "\n"
					+ player3 + "\n" + player4);
			if (chosenPlayer == null)
			{
				chosenPlayer = "null";
			}
			if (chosenPlayer.equalsIgnoreCase(player1.toString()))
			{
				if (player1.getPlayer1Health() <= 0)
				{
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "This player is dead");
				}
				else
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
			}
			else if (chosenPlayer.equalsIgnoreCase(player2.toString()))
			{
				if (player2.getPlayer2Health() <= 0)
				{
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "This player is dead");
				}
				else 
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
			}
			else if (chosenPlayer.equalsIgnoreCase(player3.toString()))
			{
				if (player3.getPlayer3Health() <= 0)
				{
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "This player is dead");
				}
				else
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
			}
			else if (chosenPlayer.equalsIgnoreCase(player4.toString()))
			{
				if (player4.getPlayer4Health() <= 0)
				{
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "This player is dead");
				}
				else
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error");
				playerConfirmation = "no";
			}
		} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
		if (chosenPlayer.equalsIgnoreCase(player1.toString()))
		{
			player1.becomeUltimate();
			dragonBallAmount = 8;
		}
		else if (chosenPlayer.equalsIgnoreCase(player2.toString()))
		{
			player2.becomeUltimate();
			dragonBallAmount = 8;
		}
		else if (chosenPlayer.equalsIgnoreCase(player3.toString()))
		{
			player3.becomeUltimate();
			dragonBallAmount = 8;
		}
		else if (chosenPlayer.equalsIgnoreCase(player4.toString()))
		{
			player4.becomeUltimate();
			dragonBallAmount = 8;
		}
		Items.addPoints(1000000);
	}
	
	public static void itemAmountSelect(int smallHealAmount, int largeHealAmount, int senzuAmount, int attackUpAmount, int defenseUpAmount, int hyperChargeAmount, int staticMomentumAmount, int dragonBallsAmount, String potaras) {
		smallHealItemAmount = smallHealAmount;
		largeHealItemAmount = largeHealAmount;
		Items.senzuAmount = senzuAmount;
		Items.attackUpAmount = attackUpAmount;
		Items.defenseUpAmount = defenseUpAmount;
		Items.hyperChargeAmount = hyperChargeAmount;
		Items.staticMomentumAmount = staticMomentumAmount;
		Items.dragonBallAmount = dragonBallsAmount;
		if (potaras.equalsIgnoreCase("yes"))
		{
			Items.potaras = true;
		}
	}
	
	public static boolean isPotaras() {
		return potaras;
	}
	public static int getPoints() {
		return points;
	}
	
	public static void addPoints(int addedPoints) {
		points += addedPoints;
	}
	
	public static void reducePoints(int reducedPoints) {
		points -= reducedPoints;
	}
	public String getITEM9() {
		return ITEM9;
	}
	
	
}