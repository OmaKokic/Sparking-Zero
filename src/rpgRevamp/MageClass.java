package rpgRevamp;
import javax.swing.JOptionPane;
import java.util.Random;

public class MageClass {

	private static String playerName3;//This is player 3's name
	private static int player3Health = 6000;
	private static int player3Ki = 0;
	private static int player3Momentum = 0;
	private static int player3ChargeNumber = 0;
	private final int SKILL1COST = 50;
	private final int SKILL2COST = 100;
	private final String SKILL1 = "Rapid Growth";
	private final String SKILL2 = "Helping Hand";
	private final int MAX_HEALTH = 6000;
	private static int attackUpDuration = 0;
	private static int defenseUpDuration = 0;
	private final int ATTACK_UP = 2;
	private final int DEFENSE_UP = 2;
	private static int hyperChargeDuration = 0;
	private static int staticMomentumDuration = 0;
	private static boolean defending = false;
	private int playerDamage;
	private final int PLAYERMINATTACK = 1250;
	private Random rng = new Random();
	private final String MOMENTUM_SKILL = "Shared Growth";
	private static int kiGained = 0;
	private final int DEFEND_REDUCTION = 2;
	private static boolean humanShieldTarget = false;
	private boolean ultimate = false;
	private final int MAX_CHARGE_NUMBER = 3;
	private static String ultimateTag = "";
	private static int heldHealth = 0;
	
	/**
	 * This method sets player 3's name
	 * @param name This is the name set by the player
	 */
	public void setName3(String name) {
		playerName3 = name;
	}
	
	/**
	 * @return Player 3 name
	 */
	public String toString() {
		return playerName3;
	}
	/**
	 * @return player 3 health
	 */
	public int getPlayer3Health() {
		return player3Health;
	}

	/**
	 * @return player 3 ki
	 */
	public int getPlayer3Ki() {
		return player3Ki;
	}

	/**
	 * @return player 3 momentum
	 */
	public int getPlayer3Momentum() {
		return player3Momentum;
	}

	/**
	 * @return player 3 charge number
	 */
	public int getPlayer3ChargeNumber() {
		return player3ChargeNumber;
	}

	public String getSkill1() {
		return SKILL1;
	}

	public String getSkill2() {
		return SKILL2;
	}
	
	public void addKi(int addedKi) {
		if (player3Health <= 0)
		{
		}
		else if (hyperChargeDuration > 0)
		{
			player3Ki += addedKi / 10;
			kiGained += addedKi / 10;
		}
		else
		{
			player3Ki += addedKi / 20;
			kiGained += addedKi / 20;
		}
		if (player3Ki > 299)
		{
			player3ChargeNumber = 3;
			player3Ki = 0;
		}
		else if (player3Ki > 199)
		{
			if (player3ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player3Ki = 0;
			}
			else if (player3ChargeNumber == 2)
			{
				player3ChargeNumber++;
				player3Ki = 0;
			}
			else
			{
				player3ChargeNumber += 2;
				player3Ki -= 200;
			}
		}
		else if (player3Ki > 99)
		{
			if (player3ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player3Ki = 0;
			}
			else 
			{
				player3ChargeNumber++;
				player3Ki -= 100;
			}
		}
		if (player3ChargeNumber >= MAX_CHARGE_NUMBER)
		{
			player3Ki = 0;
		}
		Items.addPoints(addedKi);
	}
	
	public void increaseHealth(int heal) {
		player3Health += heal;
		Items.addPoints(heal);
		if (player3Health > MAX_HEALTH)
		{
			player3Health = MAX_HEALTH;
		}
		JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " healed " + heal + " health");
		System.out.println(ultimateTag + playerName3 + " healed " + heal + " health");
	}
	public void revive() {
		player3Health = MAX_HEALTH;
		Items.addPoints(10000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " was revived");
		System.out.println(ultimateTag + playerName3 + " was revived");
	}
	
	public void setAttackUpDuration() {
		attackUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " powered up");
		System.out.println(ultimateTag + playerName3 + " powered up");
	}
	
	public void reduceAttackUpDuration() {
		if (attackUpDuration > 2)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s attack up will last for " 
					+ attackUpDuration + " more turns");
			System.out.println(ultimateTag + playerName3 + "'s attack up will last for " 
					+ attackUpDuration + " more turns");
		}
		else if (attackUpDuration == 2)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
			System.out.println(ultimateTag + playerName3 + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
		}
		else
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s attack up has ended");
			System.out.println(ultimateTag + playerName3 + "'s attack up has ended");
		}
	}
	
	public void setDefenseUpDuration() {
		defenseUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s body got tougher");
		System.out.println(ultimateTag + playerName3 + "'s body got tougher");
	}
	
	public void reduceDefenseUpDuration() {
		if (defenseUpDuration > 2)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
			System.out.println(ultimateTag + playerName3 + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
		}
		else if (defenseUpDuration == 2)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
			System.out.println(ultimateTag + playerName3 + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
		}
		else
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s defense up has ended");
			System.out.println(ultimateTag + playerName3 + "'s defense up has ended");
		}
	}

	public int getSKILL1COST() {
		return SKILL1COST;
	}

	public int getSKILL2COST() {
		return SKILL2COST;
	}
	
	public void setHyperChargeDuration() {
		hyperChargeDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " is overflowing with ki");
		System.out.println(ultimateTag + playerName3 + " is overflowing with ki");
	}
	
	public void reduceHyperChargeDuration() {
		if (hyperChargeDuration > 2)
		{
			player3Ki += 15;
			if (player3Ki > 99)
			{
				if (player3ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player3Ki = 0;
				}
				else 
				{
					player3ChargeNumber++;
					player3Ki -= 100;
				}
			}
			if (player3ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player3Ki = 0;
			}
				hyperChargeDuration--;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
				System.out.println(ultimateTag + playerName3 + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
		}
		else if (hyperChargeDuration == 2)
		{
			player3Ki += 15;
			if (player3Ki > 100)
			{
				if (player3ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player3Ki = 0;
				}
				else 
				{
					player3ChargeNumber++;
					player3Ki -= 100;
				}
			}
			if (player3ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player3Ki = 0;
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
			System.out.println(ultimateTag + playerName3 + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
		}
		else
		{
			player3Ki += 15;
			if (player3Ki > 99)
			{
				if (player3ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player3Ki = 0;
				}
				else 
				{
					player3ChargeNumber++;
					player3Ki -= 100;
				}
			}
			if (player3ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player3Ki = 0;
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s hyper charge has ended");
			System.out.println(ultimateTag + playerName3 + "'s hyper charge has ended");
		}
	}
	public void setStaticMomentumDuration() {
		staticMomentumDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " is now focused");
		System.out.println(ultimateTag + playerName3 + " is now focused");
	}
	
	public void reduceStaticMomentumDuration() {
		if (staticMomentumDuration > 2)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
			System.out.println(ultimateTag + playerName3 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
		}
		else if (staticMomentumDuration == 2)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
			System.out.println(ultimateTag + playerName3 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
		}
		else 
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + "'s static momentum has ended");
			System.out.println(ultimateTag + playerName3 + "'s static momentum has ended");
		}
	}
	public void startDefending() {
		defending = true;
	}
	
	public void endDefending() {
		defending = false;
	}
	
	public void addMomentum(int addedMomentum) {
		player3Momentum += addedMomentum / 100;
		if (player3Momentum > 100)
		{
			player3Momentum = 100;
		}
		Items.addPoints(addedMomentum);
	}
	
	public void addKiFromHighSpirit(int addedKi) {
		player3Ki += addedKi;
		if (player3Ki > 299)
		{
			player3ChargeNumber = 3;
			player3Ki = 0;
		}
		else if (player3Ki > 199)
		{
			if (player3ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player3Ki = 0;
			}
			else if (player3ChargeNumber == 2)
			{
				player3ChargeNumber++;
				player3Ki = 0;
			}
			else
			{
				player3ChargeNumber += 2;
				player3Ki -= 200;
			}
		}
		else if (player3Ki > 99)
		{
			if (player3ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player3Ki = 0;
			}
			else 
			{
				player3ChargeNumber++;
				player3Ki -= 100;
			}
		}
		if (player3ChargeNumber >= MAX_CHARGE_NUMBER)
		{
			player3Ki = 0;
		}
	}
	
	public int getPlayerAttack() {
		if (attackUpDuration > 0)
		{
			playerDamage = rng.nextInt(1250) + PLAYERMINATTACK;
			playerDamage *= ATTACK_UP;
		}
		else
		{
			playerDamage = rng.nextInt(1250) + PLAYERMINATTACK;
		}
		return playerDamage;
	}

	public String getMOMENTUM_SKILL() {
		return MOMENTUM_SKILL;
	}

	public int getKiGained() {
		return kiGained;
	}
	
	public void resetKiGained() {
		player3ChargeNumber -= 3;
		kiGained = 0;
	}
	
	public void useSharedGrowth() {
		player3Ki = 0;
		player3ChargeNumber = 3;
		player3Momentum = 0;
		kiGained += 300;
		JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " used " + MOMENTUM_SKILL);
		System.out.println(ultimateTag + playerName3 + " used " + MOMENTUM_SKILL);
	}
	
	public void useRapidGrowth() {
		player3Ki -= SKILL1COST;
		if (player3Ki < 0)
		{
			if (player3ChargeNumber == 0)
			{
				player3Ki = 0;
			}
			else
			{
				player3ChargeNumber--;
				player3Ki += 100;
			}
		}
		player3Momentum += 10;
		if (player3Momentum > 100)
		{
			player3Momentum = 100;
		}
	}
	
	public int takeDamage(int damageTaken) {
		Broly dodgeCost = new Broly();
		String dodge = "no";
		boolean validAnswer = false;
		boolean canDodge = false;
		FusedPlayer fusion = new FusedPlayer();
		UltimateTankClass player2 = new UltimateTankClass();
		if (humanShieldTarget)
		{
			if (FusedPlayer.getSkill1() == FusedPlayer.getAttackTankSkill1())
			{
				JOptionPane.showMessageDialog(null, fusion + " protected " + playerName3);
				System.out.println(fusion + " protected " + playerName3);
				fusion.addMomentum(damageTaken);
				damageTaken = fusion.takeDamage(damageTaken);
				dodgeCost.addKi(damageTaken);
				if (!Broly.isBrolyFullPowerUltimate())
						{
							dodgeCost.addMomentum(damageTaken);
						}
				damageTaken = dodgeCost.reduceBrolyHealth(damageTaken);
				dodgeCost.addKi(damageTaken);
				FusedPlayer.addDamageDealt(damageTaken);
				damageTaken = 0;
			}
			else if (player2.getPlayer2Health() <= 0)
			{
				humanShieldTarget = false;
			}
			
			else if (player2.isUltimate())
			{
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName3);
				System.out.println(TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName3);
				player2.addMomentum(damageTaken);
				damageTaken = player2.takeDamageHumanTanking(damageTaken);
				dodgeCost.addKi(damageTaken);
				if (!Broly.isBrolyFullPowerUltimate())
						{
							dodgeCost.addMomentum(damageTaken);
						}
				damageTaken = 0;
			}
			else
			{
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName3);
				System.out.println(TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName3);
				player2.addMomentum(damageTaken);
				damageTaken = player2.takeDamage(damageTaken);
				dodgeCost.addKi(damageTaken);
				if (!Broly.isBrolyFullPowerUltimate())
						{
							dodgeCost.addMomentum(damageTaken);
						}
				damageTaken = 0;
			}
		}
		else if (player2.isGenkiShieldDuration())
		{
			JOptionPane.showMessageDialog(null, "Genki Shield blocked the attack");
			System.out.println("Genki Shield blocked the attack");
			damageTaken = 0;
		}
		else if (player2.getUltimateGenkiShieldDuration() > 0)
		{
			JOptionPane.showMessageDialog(null, "Ultimate Genki Shield blocked the attack");
			System.out.println("Ultimate Genki Shield blocked the attack");
			damageTaken = 0;
		}
		else if (Broly.isBrolyFullPowerUltimate())
		{
			if (player3ChargeNumber < 5)
			{
				canDodge = false;
				dodge = "no";
			}
			else
			{
				canDodge = true;
			}
		}
		else if (Broly.isBrolySuperUltimate())
		{
			if (player3ChargeNumber < 4)
			{
				canDodge = false;
				dodge = "no";
			}
			else
			{
				canDodge = true;
			}
		}
		else if (dodgeCost.isBrolyUltimate())
		{
			if (player3ChargeNumber < 3)
			{
				canDodge = false;
				dodge = "no";
			}
			else
			{
				canDodge = true;
			}
		}	
		else if (dodgeCost.isBrolySuper())
		{
			if (player3ChargeNumber < 2)
			{
				canDodge = false;
				dodge = "no";
			}
			else
			{
				canDodge = true;
			}
		}
		else
		{
			if (player3ChargeNumber < 1)
			{
				canDodge = false;
				dodge = "no";
			}
			else
			{
				canDodge = true;
			}
		}
		if (humanShieldTarget)
		{
		}
		else if (player2.isGenkiShieldDuration())
		{
		}
		else if (player2.getUltimateGenkiShieldDuration() > 0)
		{
		}
		else if (canDodge && Broly.isBrolyFullPowerUltimate())
		{
			do
				{
					dodge = JOptionPane.showInputDialog("Do you want to dodge\n" + 
							ultimateTag + playerName3 + " Ki: " + player3ChargeNumber + " (" + 
							player3Ki + ")\nCost"
						+ " 500 ki\n\nYes  No");
					if (dodge == null)
					{
						dodge = "null";
					}
					if (dodge.equalsIgnoreCase("yes") || dodge.equalsIgnoreCase("y"))
					{
						validAnswer = true;
					}
					else if (dodge.equalsIgnoreCase("no") || dodge.equalsIgnoreCase("n"))
					{
						validAnswer = true;
					}
					else
					{
						validAnswer = false;
						JOptionPane.showMessageDialog(null, "Error");		
					}
				} while (!((validAnswer)));
		}
		else if (canDodge && Broly.isBrolySuperUltimate())
		{
			do
				{
					dodge = JOptionPane.showInputDialog("Do you want to dodge\n" + 
							ultimateTag + playerName3 + " Ki: " + player3ChargeNumber + " (" + 
							player3Ki + ")\nCost"
						+ " 400 ki\n\nYes  No");
					if (dodge == null)
					{
						dodge = "null";
					}
					if (dodge.equalsIgnoreCase("yes") || dodge.equalsIgnoreCase("y"))
					{
						validAnswer = true;
					}
					else if (dodge.equalsIgnoreCase("no") || dodge.equalsIgnoreCase("n"))
					{
						validAnswer = true;
					}
					else
					{
						validAnswer = false;
						JOptionPane.showMessageDialog(null, "Error");		
					}
				} while (!((validAnswer)));
		}
		else if (canDodge && dodgeCost.isBrolyUltimate())
		{
			do
				{
					dodge = JOptionPane.showInputDialog("Do you want to dodge\n" + 
							ultimateTag + playerName3 + " Ki: " + player3ChargeNumber + " (" + 
							player3Ki + ")\nCost"
						+ " 300 ki\n\nYes  No");
					if (dodge == null)
					{
						dodge = "null";
					}
					if (dodge.equalsIgnoreCase("yes") || dodge.equalsIgnoreCase("y"))
					{
						validAnswer = true;
					}
					else if (dodge.equalsIgnoreCase("no") || dodge.equalsIgnoreCase("n"))
					{
						validAnswer = true;
					}
					else
					{
						validAnswer = false;
						JOptionPane.showMessageDialog(null, "Error");		
					}
				} while (!((validAnswer)));
		}
		else if (canDodge && dodgeCost.isBrolySuper())
		{
			do
			{
				dodge = JOptionPane.showInputDialog("Do you want to dodge\n" + 
						ultimateTag + playerName3 + " Ki: " + player3ChargeNumber + " (" + 
						player3Ki + ")\nCost"
					+ " 200 ki\n\nYes  No");
				if (dodge == null)
				{
					dodge = "null";
				}
				if (dodge.equalsIgnoreCase("yes") || dodge.equalsIgnoreCase("y"))
				{
					validAnswer = true;
				}
				else if (dodge.equalsIgnoreCase("no") || dodge.equalsIgnoreCase("n"))
				{
					validAnswer = true;
				}
				else
				{
					validAnswer = false;
					JOptionPane.showMessageDialog(null, "Error");		
				}
			} while (!((validAnswer)));
		}
		else if (canDodge)
		{
			do
			{
				dodge = JOptionPane.showInputDialog("Do you want to dodge\n" + 
						ultimateTag + playerName3 + " Ki: " + player3ChargeNumber + " (" + 
						player3Ki + ")\nCost"
					+ " 100 ki\n\nYes  No");
				if (dodge == null)
				{
					dodge = "null";
				}
				if (dodge.equalsIgnoreCase("yes") || dodge.equalsIgnoreCase("y"))
				{
					validAnswer = true;
				}
				else if (dodge.equalsIgnoreCase("no") || dodge.equalsIgnoreCase("n"))
				{
					validAnswer = true;
				}
				else
				{
					validAnswer = false;
					JOptionPane.showMessageDialog(null, "Error");		
				}
			} while (!((validAnswer)));
		}
		if (humanShieldTarget)
		{
		}
		else if (player2.isGenkiShieldDuration())
		{
		}
		else if (player2.getUltimateGenkiShieldDuration() > 0)
		{
		}
		else if (dodge.equalsIgnoreCase("yes") || dodge.equalsIgnoreCase("y"))
		{
			if (Broly.isBrolyFullPowerUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " dodged"); 
				System.out.println(ultimateTag + playerName3 + " dodged");
				player3ChargeNumber -= 5;
				if (player3ChargeNumber < 0)
				{
					player3ChargeNumber = 0;
				}
			}
			else if (Broly.isBrolySuperUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " dodged"); 
				System.out.println(ultimateTag + playerName3 + " dodged");
				player3ChargeNumber -= 4;
				if (player3ChargeNumber < 0)
				{
					player3ChargeNumber = 0;
				}
			}
			else if (dodgeCost.isBrolyUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " dodged"); 
				System.out.println(ultimateTag + playerName3 + " dodged");
				player3ChargeNumber -= 3;
				if (player3ChargeNumber < 0)
				{
					player3ChargeNumber = 0;
				}
			}
			else if (dodgeCost.isBrolySuper())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " dodged"); 
				System.out.println(ultimateTag + playerName3 + " dodged");
				player3ChargeNumber -= 2;
				if (player3ChargeNumber < 0)
				{
					player3ChargeNumber = 0;
				}
			}
			else
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " dodged"); 
				System.out.println(ultimateTag + playerName3 + " dodged");
				player3ChargeNumber -= 1;
				if (player3ChargeNumber < 0)
				{
					player3ChargeNumber = 0;
				}
			}
		}
		else if(defenseUpDuration > 0)
		{
			if (defending)
			{
				damageTaken /= DEFENSE_UP;
				damageTaken /= DEFEND_REDUCTION;
			}
			else
			{
				damageTaken /= DEFENSE_UP;
			}
		}
		else if (defending)
		{
			damageTaken /= DEFEND_REDUCTION;
		}
		if (damageTaken < 0)
		{
			damageTaken = 0;
		}
		if (humanShieldTarget)
		{
		}
		else if (player2.isGenkiShieldDuration())
		{
		}
		else if (player2.getUltimateGenkiShieldDuration() > 0)
		{
		}
		else if (!((dodge.equalsIgnoreCase("yes"))))
		{
			player3Health -= damageTaken;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " took " + 
			damageTaken + " damage");
			System.out.println(ultimateTag + playerName3 + " took " + 
			damageTaken + " damage");
		}
		if (player3Health <= 0)
		{
			JOptionPane.showMessageDialog(null, ultimateTag + playerName3 + " died");
			System.out.println(ultimateTag + playerName3 + " died");
			ultimate = false;
			ultimateTag = "";
			player3Ki = 0;
			player3ChargeNumber = 0;
			player3Momentum = 0;
			attackUpDuration = 0;
			defenseUpDuration = 0;
			hyperChargeDuration = 0;
			staticMomentumDuration = 0;
			player3Health = 0;
			kiGained = 0;
		}
		return damageTaken;
	}
	
	public void reduceMomentum(int reducedMomentum) {
		if (staticMomentumDuration < 1)
		{
			player3Momentum -= reducedMomentum / 200;
		}
		if (player3Momentum < 0)
		{
			player3Momentum = 0;
		}
	}
	
	public int getAttackUpDuration() {
		return attackUpDuration;
	}
	
	public int getDefenseUpDuration() {
		return defenseUpDuration;
	}

	public int getHyperChargeDuration() {
		return hyperChargeDuration;
	}

	public int getStaticMomentumDuration() {
		return staticMomentumDuration;
	}
	
	public boolean isHumanShieldTarget() {
		return humanShieldTarget;
	}

	public void setHumanShieldTarget() {
		humanShieldTarget = true;
	}

	public void removeHumanShieldTarget() {
		humanShieldTarget = false;
	}

	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}
	
	public void becomeUltimate() {
		UltimateMageClass newHealth = new UltimateMageClass();
		player3Health = newHealth.getMAX_HEALTH();
		ultimate = true;
		ultimateTag = "Ultimate ";
		JOptionPane.showMessageDialog(null, playerName3 + " has awakened their potential");
		System.out.println(playerName3 + " has awakened their potential");
	}

	public boolean isUltimate() {
		return ultimate;
	}
	
	public static boolean isDefending() {
		return defending;
	}
	
	public void reducePlayerKi(int kiReduction) {
		player3Ki -= kiReduction;
		if (player3Ki < 0)
		{
			if (player3ChargeNumber == 0)
			{
				player3Ki = 0;
			}
			else
			{
				player3ChargeNumber--;
				player3Ki += 100;
			}
		}
	}

	public static void setPlayer3Ki(int player3Ki) {
		MageClass.player3Ki = player3Ki;
	}
	
	public void reducePlayerChargeNumber() {
		player3ChargeNumber--;
	}
	
	public void addKiUltimate(int addedKi) {
		player3Ki += addedKi;
	}
	
	public void reduceKiUltimate(int reducedKi) {
		player3Ki -= reducedKi;
	}
	
	public void addPlayerChargeNumberUltimate() {
		player3ChargeNumber++;
	}

	public static void setPlayer3ChargeNumber(int player3ChargeNumber) {
		MageClass.player3ChargeNumber = player3ChargeNumber;
	}

	/**
	 * @return the aTTACK_UP
	 */
	public int getATTACK_UP() {
		return ATTACK_UP;
	}

	/**
	 * @param player3Health the player3Health to set
	 */
	public static void setPlayer3Health(int player3Health) {
		MageClass.player3Health = player3Health;
	}
	
	public void reduceHyperChargeDurationUltimate() {
		hyperChargeDuration--;
	}
	
	public void addToKiGained(int gainedKi) {
		MageClass.kiGained += gainedKi;
	}

	/**
	 * @param player3Momentum the player3Momentum to set
	 */
	public static void setPlayer3Momentum(int player3Momentum) {
		MageClass.player3Momentum = player3Momentum;
	}

	/**
	 * @return the ultimateTag
	 */
	public static String getUltimateTag() {
		return ultimateTag;
	}
	
	public void addPlayerChargeNumber(int chargeNumberIncrease) {
		int currentKi = player3ChargeNumber;
		player3ChargeNumber += chargeNumberIncrease;
		if (player3ChargeNumber > MAX_CHARGE_NUMBER)
		{
			player3ChargeNumber = MAX_CHARGE_NUMBER;
			chargeNumberIncrease = MAX_CHARGE_NUMBER - currentKi;
			kiGained += chargeNumberIncrease * 100;
		}
		else
		{
			chargeNumberIncrease -= currentKi;
			kiGained += chargeNumberIncrease * 100;
		}
	}
	
	public void addPlayerChargeNumberUltimate(int chargeNumberIncrease) {
		player3ChargeNumber += chargeNumberIncrease;
	}

	/**
	 * @param kiGained the kiGained to set
	 */
	public static void setKiGained(int kiGained) {
		MageClass.kiGained = kiGained;
	}

	public static void die() {
		player3Health = 0;
		JOptionPane.showMessageDialog(null, playerName3 + " died");
		System.out.println(playerName3 + " died");
	}
	
	public static void removeUltimateTag() {
		ultimateTag = "";
	}

	/**
	 * @return the pLAYERMINATTACK
	 */
	public int getPLAYERMINATTACK() {
		return PLAYERMINATTACK;
	}
	
	public void fuse() {
		heldHealth = player3Health;
		player3Health = 0;
	}
	
	public void endFusion() {
		player3Health = heldHealth;
	}
	
	public void resetKiGainedUltimate() {
		player3ChargeNumber -= 5;
		kiGained = 0;
	}
	
	public void addKiUltimateHighSpirit(int addedKi) {
		player3Ki += addedKi / 100;
	}
	
	public void addKiDragonBalls() {
		player3Ki += 50;
		if (player3Ki > 299)
		{
			player3ChargeNumber = 3;
			player3Ki = 0;
		}
		else if (player3Ki > 199)
		{
			if (player3ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player3Ki = 0;
			}
			else if (player3ChargeNumber == 2)
			{
				player3ChargeNumber++;
				player3Ki = 100;
			}
			else
			{
				player3ChargeNumber += 2;
				player3Ki -= 200;
			}
		}
		else if (player3Ki > 99)
		{
			if (player3ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player3Ki = 0;
			}
			else 
			{
				player3ChargeNumber++;
				player3Ki -= 100;
			}
		}
		if (player3ChargeNumber == MAX_CHARGE_NUMBER)
		{
			player3Ki = 0;
		}
		player3Health += 500;
		if (player3Health > MAX_HEALTH)
		{
			player3Health = MAX_HEALTH;
		}
		Items.addPoints(50);
	}
	
	public static void addMomentumUltimate(int addedMomentum) {
		player3Momentum += addedMomentum;
	}
	
	public void addPlayerChargeNumber() {
		player3ChargeNumber++;
	}
}