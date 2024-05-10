package rpgRevamp;
import javax.swing.JOptionPane;
import java.util.Random;

public class TankClass {

	private static String playerName2;//This is player 2's name
	private static int player2Health = 10000;
	private static int player2Ki = 0;
	private static int player2Momentum = 0;
	private static int player2ChargeNumber = 0;
	private final int SKILLCOST = 50;
	private final String SKILL1 = "Human Shield";
	private final String SKILL2 = "Genki Transfer";
	private final int MAX_HEALTH = 10000;
	private static int attackUpDuration = 0;
	private static int defenseUpDuration = 0;
	private final int ATTACK_UP = 2;
	private final int DEFENSE_UP = 2;
	private static int hyperChargeDuration = 0;
	private static int staticMomentumDuration = 0;
	private static boolean defending = false;
	private int playerDamage;
	private final int PLAYERMINATTACK = 625;
	private Random rng = new Random();
	private static boolean humanShieldSkill = false;
	private static int damageTaken = 0;
	private final String MOMENTUM_SKILL = "Genki Shield";
	private static boolean genkiShieldDuration = false;
	private final int GENKI_SHIELD_HEAL = 6000;
	private final int DEFEND_REDUCTION = 2;
	private boolean ultimate = false;
	private final int MAX_CHARGE_NUMBER = 3;
	private static String ultimateTag = "";
	private static int heldHealth = 0;
	
	/**
	 * This method sets player 2's name
	 * @param name This is the name set by the player
	 */
	public void setName2(String name) {
		playerName2 = name;
	}
	
	/**
	 * @return Player 2 name
	 */
	public String toString() {
		return playerName2;
	}
	/**
	 * @return player 2 health
	 */
	public int getPlayer2Health() {
		return player2Health;
	}

	/**
	 * @return player 2 ki
	 */
	public int getPlayer2Ki() {
		return player2Ki;
	}

	/**
	 * @return player 2 momentum
	 */
	public int getPlayer2Momentum() {
		return player2Momentum;
	}

	/**
	 * @return player 2 charge number
	 */
	public int getPlayer2ChargeNumber() {
		return player2ChargeNumber;
	}

	public String getSkill1() {
		return SKILL1;
	}

	public String getSkill2() {
		return SKILL2;
	}
	
	public void addKi(int addedKi) {
		if (player2Health <= 0)
		{
		}
		else if (hyperChargeDuration > 0)
		{
			player2Ki += addedKi;
		}
		else
		{
			player2Ki += addedKi / 10;
		}
		if (player2Ki > 299)
		{
			player2ChargeNumber = 3;
			player2Ki = 0;
		}
		else if (player2Ki > 199)
		{
			if (player2ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player2Ki = 0;
			}
			else if (player2ChargeNumber == 2)
			{
				player2ChargeNumber++;
				player2Ki = 100;
			}
			else
			{
				player2ChargeNumber += 2;
				player2Ki -= 200;
			}
		}
		else if (player2Ki > 99)
		{
			if (player2ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player2Ki = 0;
			}
			else 
			{
				player2ChargeNumber++;
				player2Ki -= 100;
			}
		}
		if (player2ChargeNumber >= MAX_CHARGE_NUMBER)
		{
			player2Ki = 0;
		}
		Items.addPoints(addedKi);
	}
	
	public void increaseHealth(int heal) {
		player2Health += heal;
		Items.addPoints(heal);
		if (player2Health > MAX_HEALTH)
		{
			player2Health = MAX_HEALTH;
		}
		JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " healed " + heal + " health");
		System.out.println(ultimateTag + playerName2 + " healed " + heal + " health");
	}
	public void revive() {
		player2Health = MAX_HEALTH;
		Items.addPoints(10000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " was revived");
		System.out.println(ultimateTag + playerName2 + " was revived");
	}
	
	public void setAttackUpDuration() {
		attackUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " powered up");
		System.out.println(ultimateTag + playerName2 + " powered up");
	}
	
	public void reduceAttackUpDuration() {
		if (attackUpDuration > 2)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s attack up will last for " 
					+ attackUpDuration + " more turns");
			System.out.println(ultimateTag + playerName2 + "'s attack up will last for " 
					+ attackUpDuration + " more turns");
		}
		else if (attackUpDuration == 2)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
			System.out.println(ultimateTag + playerName2 + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
		}
		else
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s attack up has ended");
			System.out.println(ultimateTag + playerName2 + "'s attack up has ended");
		}
	}
	
	public void setDefenseUpDuration() {
		defenseUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s body got tougher");
		System.out.println(ultimateTag + playerName2 + "'s body got tougher");
	}
	
	public void reduceDefenseUpDuration() {
		if (defenseUpDuration > 2)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
			System.out.println(ultimateTag + playerName2 + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
		}
		else if (defenseUpDuration == 2)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
			System.out.println(ultimateTag + playerName2 + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
		}
		else
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s defense up has ended");
			System.out.println(ultimateTag + playerName2 + "'s defense up has ended");
		}
	}

	public int getSKILLCOST() {
		return SKILLCOST;
	}
	
	public void setHyperChargeDuration() {
		hyperChargeDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " is overflowing with ki");
		System.out.println(ultimateTag + playerName2 + " is overflowing with ki");
	}
	
	public void reduceHyperChargeDuration() {
		if (hyperChargeDuration > 2)
		{
			player2Ki += 15;
			if (player2Ki > 99)
			{
				if (player2ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player2Ki = 0;
				}
				else 
				{
					player2ChargeNumber++;
					player2Ki -= 100;
				}
			}
			if (player2ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player2Ki = 0;
			}
				hyperChargeDuration--;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
				System.out.println(ultimateTag + playerName2 + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
		}
		else if (hyperChargeDuration == 2)
		{
			player2Ki += 15;
			if (player2Ki > 100)
			{
				if (player2ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player2Ki = 0;
				}
				else 
				{
					player2ChargeNumber++;
					player2Ki -= 100;
				}
			}
			if (player2ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player2Ki = 0;
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
			System.out.println(ultimateTag + playerName2 + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
		}
		else
		{
			player2Ki += 15;
			if (player2Ki > 99)
			{
				if (player2ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player2Ki = 0;
				}
				else 
				{
					player2ChargeNumber++;
					player2Ki -= 100;
				}
			}
			if (player2ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player2Ki = 0;
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s hyper charge has ended");
			System.out.println(ultimateTag + playerName2 + "'s hyper charge has ended");
		}
	}
	
	public void setStaticMomentumDuration() {
		staticMomentumDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " is now focused");
		System.out.println(ultimateTag + playerName2 + " is now focused");
	}
	
	public void reduceStaticMomentumDuration() {
		if (staticMomentumDuration > 2)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
			System.out.println(ultimateTag + playerName2 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
			player2Momentum += 10;
			if (player2Momentum > 100)
			{
				player2Momentum = 100;
			}
		}
		else if (staticMomentumDuration == 2)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
			System.out.println(ultimateTag + playerName2 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
			player2Momentum += 10;
			if (player2Momentum > 100)
			{
				player2Momentum = 100;
			}
		}
		else 
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + "'s static momentum has ended");
			System.out.println(ultimateTag + playerName2 + "'s static momentum has ended");
		}
	}
	
	public void startDefending() {
		defending = true;
	}
	
	public void endDefending() {
		defending = false;
	}
	
	public void addMomentum(int addedMomentum) {
		player2Momentum += addedMomentum / 100;
		if (player2Momentum > 100)
		{
			player2Momentum = 100;
		}
		Items.addPoints(addedMomentum);
	}
	
	public void addKiFromHighSpirit(int addedKi) {
		player2Ki += addedKi / 100;
		if (player2Ki > 299)
		{
			player2ChargeNumber = 3;
			player2Ki = 0;
		}
		else if (player2Ki > 199)
		{
			if (player2ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player2Ki = 0;
			}
			else if (player2ChargeNumber == 2)
			{
				player2ChargeNumber++;
				player2Ki = 100;
			}
			else
			{
				player2ChargeNumber += 2;
				player2Ki -= 200;
			}
		}
		else if (player2Ki > 99)
		{
			if (player2ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player2Ki = 0;
			}
			else 
			{
				player2ChargeNumber++;
				player2Ki -= 100;
			}
		}
		if (player2ChargeNumber >= MAX_CHARGE_NUMBER)
		{
			player2Ki = 0;
		}
	}
	
	public int getPlayerAttack() {
		if (attackUpDuration > 0)
		{
			playerDamage = rng.nextInt(625) + PLAYERMINATTACK;
			playerDamage *= ATTACK_UP;
		}
		else
		{
			playerDamage = rng.nextInt(625) + PLAYERMINATTACK;
		}
		return playerDamage;
	}
	
	public void activateHumanShieldSkill() {
		player2ChargeNumber--;
		Items.addPoints(2000);
		humanShieldSkill = true;
	}
	
	public void deactivateHumanShieldSkill() {
		humanShieldSkill = false;
	}

	public int getDamageTaken() {
		return damageTaken;
	}
	
	public void useGenkiTransfer() {
		player2Ki -= SKILLCOST;
		if (player2Ki < 0)
		{
			if (player2ChargeNumber == 0)
			{
				player2Ki = 0;
			}
			else
			{
				player2ChargeNumber--;
				player2Ki += 100;
			}
		}
	}
	
	public void resetDamageTaken() {
		damageTaken = 0;
	}

	public String getMOMENTUM_SKILL() {
		return MOMENTUM_SKILL;
	}
	
	public void activateGenkiShield() {
		genkiShieldDuration = true;
		FusedPlayer fusion = new FusedPlayer();
		if ((!(FusedPlayer.getFusionType() == fusion.getAttackTank())) || (!(FusedPlayer.getFusionType() == fusion.getTankMage())) || (!(FusedPlayer.getFusionType() == fusion.getTankCrafter())))
		{
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " used " + MOMENTUM_SKILL);
			System.out.println(ultimateTag + playerName2 + " used " + MOMENTUM_SKILL);
			player2Momentum = 0;
		}
	}
	
	public void reduceGenkiShieldDuration() {
		genkiShieldDuration = false;
		JOptionPane.showMessageDialog(null, MOMENTUM_SKILL + " has ended");
		System.out.println(MOMENTUM_SKILL + " has ended");
	}

	public int getGENKI_SHIELD_HEAL() {
		return GENKI_SHIELD_HEAL;
	}
	
	public void sharedGrowthHyperChargeDuration() {
		hyperChargeDuration = 2;
		JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " powered up");
		System.out.println(ultimateTag + playerName2 + " powered up");
	}
	
	public int takeDamage(int damageTaken) {
		Broly deflectCost = new Broly();
		String deflect = "no";
		boolean validAnswer = false;
		boolean canDeflect = false;
		if (Broly.isBrolyFullPowerUltimate())
		{
			if (player2ChargeNumber < 5)
			{
				canDeflect = false;
				deflect = "no";
			}
			else
			{
				canDeflect = true;
			}
		}
		else if (Broly.isBrolySuperUltimate())
		{
			if (player2ChargeNumber < 4)
			{
				canDeflect = false;
				deflect = "no";
			}
			else
			{
				canDeflect = true;
			}
		}
		else if (deflectCost.isBrolyUltimate())
		{
			if (player2ChargeNumber < 3)
			{
				canDeflect = false;
				deflect = "no";
			}
			else
			{
				canDeflect = true;
			}
		}	
		else if (deflectCost.isBrolySuper())
		{
			if (player2ChargeNumber < 2)
			{
				canDeflect = false;
				deflect = "no";
			}
			else
			{
				canDeflect = true;
			}
		}
		else
		{
			if (player2ChargeNumber < 1)
			{
				canDeflect = false;
				deflect = "no";
			}
			else
			{
				canDeflect = true;
			}
		}
		if (canDeflect && Broly.isBrolyFullPowerUltimate())
		{
			do
				{
					deflect = JOptionPane.showInputDialog("Do you want to deflect\n" + 
							ultimateTag + playerName2 + " Ki: " + player2ChargeNumber + " (" + 
							player2Ki + ")\nCost"
						+ " 500 ki\n\nYes  No");
					if (deflect == null)
					{
						deflect = "null";
					}
					if (deflect.equalsIgnoreCase("yes") || deflect.equalsIgnoreCase("y"))
					{
						validAnswer = true;
					}
					else if (deflect.equalsIgnoreCase("no") || deflect.equalsIgnoreCase("n"))
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
		else if (canDeflect && Broly.isBrolySuperUltimate())
		{
			do
				{
					deflect = JOptionPane.showInputDialog("Do you want to deflect\n" + 
							ultimateTag + playerName2 + " Ki: " + player2ChargeNumber + " (" + 
							player2Ki + ")\nCost"
						+ " 400 ki\n\nYes  No");
					if (deflect == null)
					{
						deflect = "null";
					}
					if (deflect.equalsIgnoreCase("yes") || deflect.equalsIgnoreCase("y"))
					{
						validAnswer = true;
					}
					else if (deflect.equalsIgnoreCase("no") || deflect.equalsIgnoreCase("n"))
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
		else if (canDeflect && deflectCost.isBrolyUltimate())
		{
			do
				{
					deflect = JOptionPane.showInputDialog("Do you want to deflect\n" + 
							ultimateTag + playerName2 + " Ki: " + player2ChargeNumber + " (" + 
							player2Ki + ")\nCost"
						+ " 300 ki\n\nYes  No");
					if (deflect == null)
					{
						deflect = "null";
					}
					if (deflect.equalsIgnoreCase("yes") || deflect.equalsIgnoreCase("y"))
					{
						validAnswer = true;
					}
					else if (deflect.equalsIgnoreCase("no") || deflect.equalsIgnoreCase("n"))
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
		else if (canDeflect && deflectCost.isBrolySuper())
		{
			do
			{
				deflect = JOptionPane.showInputDialog("Do you want to deflect\n" + 
						ultimateTag + playerName2 + " Ki: " + player2ChargeNumber + " (" + 
						player2Ki + ")\nCost"
					+ " 200 ki\n\nYes  No");
				if (deflect == null)
				{
					deflect = "null";
				}
				if (deflect.equalsIgnoreCase("yes") || deflect.equalsIgnoreCase("y"))
				{
					validAnswer = true;
				}
				else if (deflect.equalsIgnoreCase("no") || deflect.equalsIgnoreCase("n"))
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
		else if (canDeflect)
		{
			do
			{
				deflect = JOptionPane.showInputDialog("Do you want to deflect\n" + 
						ultimateTag + playerName2 + " Ki: " + player2ChargeNumber + " (" + 
						player2Ki + ")\nCost"
					+ " 100 ki\n\nYes  No");
				if (deflect == null)
				{
					deflect = "null";
				}
				if (deflect.equalsIgnoreCase("yes") || deflect.equalsIgnoreCase("y"))
				{
					validAnswer = true;
				}
				else if (deflect.equalsIgnoreCase("no") || deflect.equalsIgnoreCase("n"))
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
		if (deflect.equalsIgnoreCase("yes") || deflect.equalsIgnoreCase("y"))
		{
			if (Broly.isBrolyFullPowerUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " deflected"); 
				System.out.println(ultimateTag + playerName2 + " deflected");
				player2ChargeNumber -= 5;
				if (player2ChargeNumber < 0)
				{
					player2ChargeNumber = 0;
				}
			}
			else if (Broly.isBrolySuperUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " deflected"); 
				System.out.println(ultimateTag + playerName2 + " deflected");
				player2ChargeNumber -= 4;
				if (player2ChargeNumber < 0)
				{
					player2ChargeNumber = 0;
				}
			}
			else if (deflectCost.isBrolyUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " deflected"); 
				System.out.println(ultimateTag + playerName2 + " deflected");
				player2ChargeNumber -= 3;
				if (player2ChargeNumber < 0)
				{
					player2ChargeNumber = 0;
				}
			}
			else if (deflectCost.isBrolySuper())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " deflected"); 
				System.out.println(ultimateTag + playerName2 + " deflected");
				player2ChargeNumber -= 2;
				if (player2ChargeNumber < 0)
				{
					player2ChargeNumber = 0;
				}
			}
			else
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " deflected"); 
				System.out.println(ultimateTag + playerName2 + " deflected");
				player2ChargeNumber -= 1;
				if (player2ChargeNumber < 0)
				{
					player2ChargeNumber = 0;
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
		if (!((deflect.equalsIgnoreCase("yes"))))
		{
			player2Health -= damageTaken;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " took " + 
			damageTaken + " damage");
			System.out.println(ultimateTag + playerName2 + " took " + 
			damageTaken + " damage");
		}
		if (player2Health <= 0)
		{
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " died");
			System.out.println(ultimateTag + playerName2 + " died");
			ultimate = false;
			ultimateTag = "";
			player2Ki = 0;
			player2ChargeNumber = 0;
			player2Momentum = 0;
			attackUpDuration = 0;
			defenseUpDuration = 0;
			hyperChargeDuration = 0;
			staticMomentumDuration = 0;
			player2Health = 0;
		}
		TankClass.damageTaken += damageTaken;
		return damageTaken;
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

	public boolean isHumanShieldSkill() {
		return humanShieldSkill;
	}

	public boolean isGenkiShieldDuration() {
		return genkiShieldDuration;
	}

	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}
	
	public void becomeUltimate() {
		UltimateTankClass newHealth = new UltimateTankClass();
		player2Health = newHealth.getMAX_HEALTH();
		ultimate = true;
		ultimateTag = "Ultimate ";
		JOptionPane.showMessageDialog(null, playerName2 + " has awakened their potential");
		System.out.println(playerName2 + " has awakened their potential");
	}

	public boolean isUltimate() {
		return ultimate;
	}
	
	public static boolean isDefending() {
		return defending;
	}
	
	public void reducePlayerKi(int kiReduction) {
		player2Ki -= kiReduction;
		if (player2Ki < 0)
		{
			if (player2ChargeNumber == 0)
			{
				player2Ki = 0;
			}
			else
			{
				player2ChargeNumber--;
				player2Ki += 100;
			}
		}
	}

	public static void setPlayer2Ki(int player2Ki) {
		TankClass.player2Ki = player2Ki;
	}
	
	public void reducePlayerChargeNumber() {
		player2ChargeNumber--;
	}
	
	public void addKiUltimate(int addedKi) {
		player2Ki += addedKi;
	}
	
	public void reduceKiUltimate(int reducedKi) {
		player2Ki -= reducedKi;
	}
	
	public void addPlayerChargeNumber() {
		player2ChargeNumber++;
	}

	public static void setPlayer2ChargeNumber(int player2ChargeNumber) {
		TankClass.player2ChargeNumber = player2ChargeNumber;
	}

	public int getATTACK_UP() {
		return ATTACK_UP;
	}

	public static void setPlayer2Health(int player2Health) {
		TankClass.player2Health = player2Health;
	}
	
	public void reduceHyperChargeDurationUltimate() {
		hyperChargeDuration--;
	}
	
	public static void setPlayer2Momentum(int player2Momentum) {
		TankClass.player2Momentum = player2Momentum;
	}
	
	public int takeDamageHumanTanking(int damageTaken) {
		if(defenseUpDuration > 0)
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
			player2Health -= damageTaken;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " took " + 
			damageTaken + " damage");
			System.out.println(ultimateTag + playerName2 + " took " + 
			damageTaken + " damage");
		if (player2Health <= 0)
		{
			JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " died");
			System.out.println(ultimateTag + playerName2 + " died");
			ultimate = false;
		}
		TankClass.damageTaken += damageTaken;
		return damageTaken;
	}

	/**
	 * @return the ultimateTag
	 */
	public static String getUltimateTag() {
		return ultimateTag;
	}
	
	public void contagiousGrowthHyperChargeDuration() {
		hyperChargeDuration = 4;
		JOptionPane.showMessageDialog(null, ultimateTag + playerName2 + " powered up");
		System.out.println(ultimateTag + playerName2 + " powered up");
	}
	
	public static void die() {
		player2Health = 0;
		JOptionPane.showMessageDialog(null, playerName2 + " died");
		System.out.println(playerName2 + " died");
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
		heldHealth = player2Health;
		player2Health = 0;
	}
	
	public void endFusion() {
		player2Health = heldHealth;
	}
	
	public void gainRandomBuff() {
		int randomBuff = rng.nextInt(4) + 1;
		switch (randomBuff)
		{
		case 1:
		{
			setAttackUpDuration();
		}
		case 2:
		{
			setDefenseUpDuration();
		}
		case 3:
		{
			setHyperChargeDuration();
		}
		case 4:
			setStaticMomentumDuration();
		}
	}
	
	public void addMomentumFromMage(int addedMomentum) {
		MageClass player3 = new MageClass();
		player2Momentum += addedMomentum / 20;
		if (player2Momentum > 100)
		{
			player2Momentum = 100;
		}
		JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " gave " 
				+ ultimateTag + playerName2 + " " + addedMomentum / 20 + " momentum");
		System.out.println(MageClass.getUltimateTag() + player3 + " gave " 
				+ ultimateTag + playerName2 + " " + addedMomentum / 20 + " momentum");
	}
	
	public void activateHumanShieldSkillUltimate() {
		player2ChargeNumber -= 2;
		humanShieldSkill = true;
	}
	
	public void addKiUltimateHighSpirit(int addedKi) {
		player2Ki += addedKi / 100;
	}
	
	public void addKiDragonBalls() {
		player2Ki += 50;
		if (player2Ki > 299)
		{
			player2ChargeNumber = 3;
			player2Ki = 0;
		}
		else if (player2Ki > 199)
		{
			if (player2ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player2Ki = 0;
			}
			else if (player2ChargeNumber == 2)
			{
				player2ChargeNumber++;
				player2Ki = 100;
			}
			else
			{
				player2ChargeNumber += 2;
				player2Ki -= 200;
			}
		}
		else if (player2Ki > 99)
		{
			if (player2ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player2Ki = 0;
			}
			else 
			{
				player2ChargeNumber++;
				player2Ki -= 100;
			}
		}
		if (player2ChargeNumber == MAX_CHARGE_NUMBER)
		{
			player2Ki = 0;
		}
		player2Health += 500;
		if (player2Health > MAX_HEALTH)
		{
			player2Health = MAX_HEALTH;
		}
		Items.addPoints(50);
	}
}