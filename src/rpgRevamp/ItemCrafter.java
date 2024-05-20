package rpgRevamp;
import javax.swing.JOptionPane;
import java.util.Random;

public class ItemCrafter {

	private static String playerName4;//This is player 1's name
	private static int player4Health = 8000;
	private static int player4Ki = 0;
	private static int player4Momentum = 0;
	private static int player4ChargeNumber = 0;
	private final int SKILLCOST = 50;
	private final String SKILL1 = "Craft";
	private final String SKILL2 = "Healing Elixir";
	private final int MAX_HEALTH = 8000;
	private static int attackUpDuration = 0;
	private static int defenseUpDuration = 0;
	private final int ATTACK_UP = 2;
	private final int DEFENSE_UP = 2;
	private static int hyperChargeDuration = 0;
	private static int staticMomentumDuration = 0;
	private static boolean defending = false;
	private int playerDamage;
	private final int PLAYERMINATTACK = 833;
	private Random rng = new Random();
	private final String MOMENTUM_SKILL = "Crafter's Intuition";
	private static int largeHealProgress = 0;
	private static int attackUpProgress = 0;
	private static int defenseUpProgress = 0;
	private static int hyperChargeProgress = 0;
	private static int staticMomentumProgress = 0;
	private Items craft = new Items();
	private int increasedProgress = 0;
	private final int DEFEND_REDUCTION = 2;
	private static boolean humanShieldTarget = false;
	private boolean ultimate = false;
	private final int MAX_CHARGE_NUMBER = 3;
	private static String ultimateTag = "";
	private static boolean craftersIntuition = false;
	private static int heldHealth = 0;
	private static int craftingProgress = 0;
	private static int revivalTimer = 30;
	
	/**
	 * This method sets player 4's name
	 * @param name This is the name set by the player
	 */
	public void setName4(String name) {
		playerName4 = name;
	}
	/**
	 * @return Player 4 name
	 */
	public String toString() {
		return playerName4;
	}
	
	/**
	 * @return player 4 health
	 */
	public int getPlayer4Health() {
		return player4Health;
	}

	/**
	 * @return player 4 ki
	 */
	public int getPlayer4Ki() {
		return player4Ki;
	}

	/**
	 * @return player 4 momentum
	 */
	public int getPlayer4Momentum() {
		return player4Momentum;
	}

	/**
	 * @return player 4 charge number
	 */
	public int getPlayer4ChargeNumber() {
		return player4ChargeNumber;
	}
	public String getSkill1() {
		return SKILL1;
	}
	public String getSkill2() {
		return SKILL2;
	}
	
	public void addKi(int addedKi) {
		if (player4Health <= 0)
		{
		}
		else if (hyperChargeDuration > 0)
		{
			player4Ki += addedKi / 5;
		}
		else
		{
			player4Ki += addedKi / 10;
		}
		if (player4Ki > 299)
		{
			player4ChargeNumber = 3;
			player4Ki = 0;
		}
		else if (player4Ki > 199)
		{
			if (player4ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player4Ki = 0;
			}
			else if (player4ChargeNumber == 2)
			{
				player4ChargeNumber++;
				player4Ki = 0;
			}
			else
			{
				player4ChargeNumber += 2;
				player4Ki -= 200;
			}
		}
		else if (player4Ki > 99)
		{
			if (player4ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player4Ki = 0;
			}
			else 
			{
				player4ChargeNumber++;
				player4Ki -= 100;
			}
		}
		if (player4ChargeNumber >= MAX_CHARGE_NUMBER)
		{
			player4Ki = 0;
		}
		Items.addPoints(addedKi);
	}
	
	public void increaseHealth(int heal) {
		player4Health += heal;
		Items.addPoints(heal);
		if (player4Health > MAX_HEALTH)
		{
			player4Health = MAX_HEALTH;
		}
		JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " healed " + heal + " health");
		System.out.println(ultimateTag + playerName4 + " healed " + heal + " health");
	}
	public void revive() {
		player4Health = MAX_HEALTH;
		Items.addPoints(10000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " was revived");
		System.out.println(ultimateTag + playerName4 + " was revived");
	}
	
	public void setAttackUpDuration() {
		attackUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " powered up");
		System.out.println(ultimateTag + playerName4 + " powered up");
	}
	
	public void reduceAttackUpDuration() {
		if (attackUpDuration > 2)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s attack up will last for " 
					+ attackUpDuration + " more turns");
			System.out.println(ultimateTag + playerName4 + "'s attack up will last for " 
					+ attackUpDuration + " more turns");
		}
		else if (attackUpDuration == 2)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
			System.out.println(ultimateTag + playerName4 + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
		}
		else
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s attack up has ended");
			System.out.println(ultimateTag + playerName4 + "'s attack up has ended");
		}
	}
	public void setDefenseUpDuration() {
		defenseUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s body got tougher");
		System.out.println(ultimateTag + playerName4 + "'s body got tougher");
	}
	
	public void reduceDefenseUpDuration() {
		if (defenseUpDuration > 2)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
			System.out.println(ultimateTag + playerName4 + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
		}
		else if (defenseUpDuration == 2)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
			System.out.println(ultimateTag + playerName4 + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
		}
		else
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s defense up has ended");
			System.out.println(ultimateTag + playerName4 + "'s defense up has ended");
		}
	}
	public int getSKILLCOST() {
		return SKILLCOST;
	}
	
	public void setHyperChargeDuration() {
		hyperChargeDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " is overflowing with ki");
		System.out.println(ultimateTag + playerName4 + " is overflowing with ki");
	}
	
	public void reduceHyperChargeDuration() {
		if (hyperChargeDuration > 2)
		{
			player4Ki += 15;
			if (player4Ki > 99)
			{
				if (player4ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player4Ki = 0;
				}
				else 
				{
					player4ChargeNumber++;
					player4Ki -= 100;
				}
			}
			if (player4ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player4Ki = 0;
			}
				hyperChargeDuration--;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
				System.out.println(ultimateTag + playerName4 + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
		}
		else if (hyperChargeDuration == 2)
		{
			player4Ki += 15;
			if (player4Ki > 100)
			{
				if (player4ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player4Ki = 0;
				}
				else 
				{
					player4ChargeNumber++;
					player4Ki -= 100;
				}
			}
			if (player4ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player4Ki = 0;
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
			System.out.println(ultimateTag + playerName4 + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
		}
		else
		{
			player4Ki += 15;
			if (player4Ki > 99)
			{
				if (player4ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player4Ki = 0;
				}
				else 
				{
					player4ChargeNumber++;
					player4Ki -= 100;
				}
			}
			if (player4ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player4Ki = 0;
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s hyper charge has ended");
			System.out.println(ultimateTag + playerName4 + "'s hyper charge has ended");
		}
	}
	
	public void setStaticMomentumDuration() {
		staticMomentumDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " is now focused");
		System.out.println(ultimateTag + playerName4 + " is now focused");
	}
	
	public void reduceStaticMomentumDuration() {
		if (staticMomentumDuration > 2)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
			System.out.println(ultimateTag + playerName4 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
		}
		else if (staticMomentumDuration == 2)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
			System.out.println(ultimateTag + playerName4 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
		}
		else 
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + "'s static momentum has ended");
			System.out.println(ultimateTag + playerName4 + "'s static momentum has ended");
		}
	}
	
	public void startDefending() {
		defending = true;
	}
	
	public void endDefending() {
		defending = false;
	}
	
	public void addMomentum(int addedMomentum) {
		player4Momentum += addedMomentum / 5;
		if (player4Momentum > 100)
		{
			player4Momentum = 100;
		}
		Items.addPoints(addedMomentum);
	}
	
	public void addKiFromHighSpirit(int addedKi) {
		player4Ki += addedKi;
		if (player4Ki > 299)
		{
			player4ChargeNumber = 3;
			player4Ki = 0;
		}
		else if (player4Ki > 199)
		{
			if (player4ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player4Ki = 0;
			}
			else if (player4ChargeNumber == 2)
			{
				player4ChargeNumber++;
				player4Ki = 100;
			}
			else
			{
				player4ChargeNumber += 2;
				player4Ki -= 200;
			}
		}
		else if (player4Ki > 99)
		{
			if (player4ChargeNumber >= MAX_CHARGE_NUMBER)
			{
				player4Ki = 0;
			}
			else 
			{
				player4ChargeNumber++;
				player4Ki -= 100;
			}
		}
		if (player4ChargeNumber >= MAX_CHARGE_NUMBER)
		{
			player4Ki = 0;
		}
	}
	
	public int getPlayerAttack() {
		if (attackUpDuration > 0)
		{
			playerDamage = rng.nextInt(833) + PLAYERMINATTACK;
			playerDamage *= ATTACK_UP;
		}
		else
		{
			playerDamage = rng.nextInt(833) + PLAYERMINATTACK;
		}
		return playerDamage;
	}
	public String getMOMENTUM_SKILL() {
		return MOMENTUM_SKILL;
	}
	
	public void sharedGrowthHyperChargeDuration() {
		hyperChargeDuration = 2;
		JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " powered up");
		System.out.println(ultimateTag + playerName4 + " powered up");
	}
	
	public int craftLargeHeal() {
		if (!craftersIntuition)
		{
			player4Ki -= SKILLCOST;
			if (player4Ki < 0)
			{
				if (player4ChargeNumber == 0)
				{
					player4Ki = 0;
				}
				else
				{
					player4ChargeNumber--;
					player4Ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100) + 1;
		largeHealProgress += increasedProgress;
		craftingProgress += increasedProgress * 10;
		if (largeHealProgress >= 100)
		{
			craft.increaseLargeHealItemAmount();
			largeHealProgress = 0;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " crafted a " + craft.getITEM2());
			System.out.println(ultimateTag + playerName4 + " crafted a " + craft.getITEM2());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM2() + 
					" is now at " + largeHealProgress + "% completion");
			System.out.println(craft.getITEM2() + 
					" is now at " + largeHealProgress + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftAttackUp() {
		if (!craftersIntuition)
		{
			player4Ki -= SKILLCOST;
			if (player4Ki < 0)
			{
				if (player4ChargeNumber == 0)
				{
					player4Ki = 0;
				}
				else
				{
					player4ChargeNumber--;
					player4Ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100) + 50;
		attackUpProgress += increasedProgress;
		craftingProgress += increasedProgress * 10;
		if (attackUpProgress >= 100)
		{
			craft.increaseAttackUpAmount();
			attackUpProgress = 0;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " crafted a " + craft.getITEM4());
			System.out.println(ultimateTag + playerName4 + " crafted a " + craft.getITEM4());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM4() + 
					" is now at " + attackUpProgress + "% completion");
			System.out.println(craft.getITEM4() + 
					" is now at " + attackUpProgress + "% completion");
		}
		return increasedProgress - 50;
	}
	
	public int craftDefenseUp() {
		if (!craftersIntuition)
		{
			player4Ki -= SKILLCOST;
			if (player4Ki < 0)
			{
				if (player4ChargeNumber == 0)
				{
					player4Ki = 0;
				}
				else
				{
					player4ChargeNumber--;
					player4Ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100) + 1;
		defenseUpProgress += increasedProgress;
		craftingProgress += increasedProgress * 10;
		if (defenseUpProgress >= 100)
		{
			craft.increaseDefenseUpAmount();
			defenseUpProgress = 0;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " crafted a " + craft.getITEM5());
			System.out.println(ultimateTag + playerName4 + " crafted a " + craft.getITEM5());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM5() + 
					" is now at " + defenseUpProgress + "% completion");
			System.out.println(craft.getITEM5() + 
					" is now at " + defenseUpProgress + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftHyperCharge() {
		if (!craftersIntuition)
		{
			player4Ki -= SKILLCOST;
			if (player4Ki < 0)
			{
				if (player4ChargeNumber == 0)
				{
					player4Ki = 0;
				}
				else
				{
					player4ChargeNumber--;
					player4Ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100) + 50;
		hyperChargeProgress += increasedProgress;
		craftingProgress += increasedProgress * 10;
		if (hyperChargeProgress >= 100)
		{
			craft.increaseHyperChargeAmount();
			hyperChargeProgress = 0;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " crafted a " + craft.getITEM6());
			System.out.println(ultimateTag + playerName4 + " crafted a " + craft.getITEM6());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM6() + 
					" is now at " + hyperChargeProgress + "% completion");
			System.out.println(craft.getITEM6() + 
					" is now at " + hyperChargeProgress + "% completion");
		}
		return increasedProgress - 50;
	}
	
	public int craftStaticMomentum() {
		if (!craftersIntuition)
		{
			player4Ki -= SKILLCOST;
			if (player4Ki < 0)
			{
				if (player4ChargeNumber == 0)
				{
					player4Ki = 0;
				}
				else
				{
					player4ChargeNumber--;
					player4Ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100);
		staticMomentumProgress += increasedProgress;
		craftingProgress += increasedProgress * 10;
		if (staticMomentumProgress >= 100)
		{
			craft.increaseStaticMomentumAmount();
			staticMomentumProgress = 0;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " crafted a " + craft.getITEM7());
			System.out.println(ultimateTag + playerName4 + " crafted a " + craft.getITEM7());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM7() + 
					" is now at " + staticMomentumProgress + "% completion");
			System.out.println(craft.getITEM7() + 
					" is now at " + staticMomentumProgress + "% completion");
		}
		return increasedProgress;
	}
	public int getLargeHealProgress() {
		return largeHealProgress;
	}
	public int getAttackUpProgress() {
		return attackUpProgress;
	}
	public int getDefenseUpProgress() {
		return defenseUpProgress;
	}
	public int getHyperChargeProgress() {
		return hyperChargeProgress;
	}
	public int getStaticMomentumProgress() {
		return staticMomentumProgress;
	}
	
	public void useCrafterIntuition() {
		JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " used " + MOMENTUM_SKILL); 
		System.out.println(ultimateTag + playerName4 + " used " + MOMENTUM_SKILL);
		player4Momentum = 0;
	}
	
	public int takeDamage(int damageTaken) {
		Broly dodgeCost = new Broly();
		String dodge = "no";
		boolean validAnswer = false;
		boolean canDodge = false;
		TankClass player2 = new TankClass();
		FusedPlayer fusion = new FusedPlayer();
		AttackerClass player1 = new AttackerClass();
		UltimateTankClass ultimatePlayer2 = new UltimateTankClass();
		if (humanShieldTarget)
		{
			if (FusedPlayer.getFusionType() == fusion.getTankMage())
			{
				String fusionTurn, 
					playerConfirmation;
				fusion.addMomentum(damageTaken);
				if (FusedPlayer.getKi() > dodgeCost.getBrolyKi())
				{
					if (FusedPlayer.getChargeNumber() < dodgeCost.getBrolyChargeNumber())
					{
						fusion.startDefending();
						fusion.takeDamage(damageTaken);
						dodgeCost.addKi(damageTaken);
						if (!Broly.isBrolyFullPowerUltimate())
						{
							dodgeCost.addMomentum(damageTaken);
						}
						fusion.endDefending();
					}
					else
					{
						do 
						{
							fusionTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" +
									ultimateTag + playerName4);
							if (fusionTurn == null)
							{
								fusionTurn = "null";
							}
							if (fusionTurn.equalsIgnoreCase(player1.toString()))
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
							else if (fusionTurn.equalsIgnoreCase(playerName4))
							{
									playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
									if (playerConfirmation == null)
									{
										playerConfirmation = "null";
									}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Error");
								playerConfirmation = "no";
							}
						} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
						if (fusionTurn.equalsIgnoreCase(player1.toString()))
						{
							player1.setDefenseUpDuration();
							fusion.addMomentum(10000);
						}
						else if (fusionTurn.equalsIgnoreCase(playerName4))
						{
							setDefenseUpDuration();
							fusion.addMomentum(10000);
						}
					}
				}
				else
				{
					do 
					{
						fusionTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" +
								ultimateTag + playerName4);
						if (fusionTurn == null)
						{
							fusionTurn = "null";
						}
						if (fusionTurn.equalsIgnoreCase(player1.toString()))
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
						else if (fusionTurn.equalsIgnoreCase(playerName4))
						{
								playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
								if (playerConfirmation == null)
								{
									playerConfirmation = "null";
								}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Error");
							playerConfirmation = "no";
						}
					} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
					if (fusionTurn.equalsIgnoreCase(player1.toString()))
					{
						player1.setDefenseUpDuration();
						fusion.addMomentum(10000);
					}
					else if (fusionTurn.equalsIgnoreCase(playerName4))
					{
						setDefenseUpDuration();
						fusion.addMomentum(10000);
					}
				}
				damageTaken = 0;
			}
			else if (FusedPlayer.getSkill1() == FusedPlayer.getAttackTankSkill1())
			{
				JOptionPane.showMessageDialog(null, fusion + " protected " + playerName4);
				System.out.println(fusion + " protected " + playerName4);
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
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName4);
				System.out.println(TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName4);
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
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName4);
				System.out.println(TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName4);
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
		else if (ultimatePlayer2.getUltimateGenkiShieldDuration() > 0)
		{
			JOptionPane.showMessageDialog(null, "Ultimate Genki Shield blocked the attack");
			System.out.println("Ultimate Genki Shield blocked the attack");
			damageTaken = 0;
		}
		else if (Broly.isBrolyFullPowerUltimate())
		{
			if (player4ChargeNumber < 5)
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
			if (player4ChargeNumber < 4)
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
			if (player4ChargeNumber < 3)
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
			if (player4ChargeNumber < 2)
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
			if (player4ChargeNumber < 1)
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
		else if (ultimatePlayer2.getUltimateGenkiShieldDuration() > 0)
		{
		}
		else if (canDodge && Broly.isBrolyFullPowerUltimate())
		{
			do
				{
					dodge = JOptionPane.showInputDialog("Do you want to dodge\n" + 
							ultimateTag + playerName4 + " Ki: " + player4ChargeNumber + " (" + 
							playerName4 + ")\nCost"
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
							ultimateTag + playerName4 + " Ki: " + player4ChargeNumber + " (" + 
							player4Ki + ")\nCost"
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
							ultimateTag + playerName4 + " Ki: " + player4ChargeNumber + " (" + 
							player4Ki + ")\nCost"
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
						ultimateTag + playerName4 + " Ki: " + player4ChargeNumber + " (" + 
						player4Ki + ")\nCost"
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
						ultimateTag + playerName4 + " Ki: " + player4ChargeNumber + " (" + 
						player4Ki + ")\nCost"
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
		else if (ultimatePlayer2.getUltimateGenkiShieldDuration() > 0)
		{
		}
		else if (dodge.equalsIgnoreCase("yes") || dodge.equalsIgnoreCase("y"))
		{
			if (Broly.isBrolyFullPowerUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " dodged"); 
				System.out.println(ultimateTag + playerName4 + " dodged");
				player4ChargeNumber -= 5;
				if (player4ChargeNumber < 0)
				{
					player4ChargeNumber = 0;
				}
			}
			else if (Broly.isBrolySuperUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " dodged"); 
				System.out.println(ultimateTag + playerName4 + " dodged");
				player4ChargeNumber -= 4;
				if (player4ChargeNumber < 0)
				{
					player4ChargeNumber = 0;
				}
			}
			else if (dodgeCost.isBrolyUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " dodged"); 
				System.out.println(ultimateTag + playerName4 + " dodged");
				player4ChargeNumber -= 3;
				if (player4ChargeNumber < 0)
				{
					player4ChargeNumber = 0;
				}
			}
			else if (dodgeCost.isBrolySuper())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " dodged"); 
				System.out.println(ultimateTag + playerName4 + " dodged");
				player4ChargeNumber -= 2;
				if (player4ChargeNumber < 0)
				{
					player4ChargeNumber = 0;
				}
			}
			else
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " dodged"); 
				System.out.println(ultimateTag + playerName4 + " dodged");
				player4ChargeNumber --;
				if (player4ChargeNumber < 0)
				{
					player4ChargeNumber = 0;
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
		else if (ultimatePlayer2.getUltimateGenkiShieldDuration() > 0)
		{
		}
		else if (!((dodge.equalsIgnoreCase("yes"))))
		{
			player4Health -= damageTaken;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " took " + 
			damageTaken + " damage");
			System.out.println(ultimateTag + playerName4 + " took " + 
			damageTaken + " damage");
		}
		if (player4Health <= 0)
		{
			JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " died");
			System.out.println(ultimateTag + playerName4 + " died");
			ultimate = false;
			ultimateTag = "";
			player4Ki = 0;
			player4ChargeNumber = 0;
			player4Momentum = 0;
			attackUpDuration = 0;
			defenseUpDuration = 0;
			hyperChargeDuration = 0;
			staticMomentumDuration = 0;
			player4Health = 0;
			craftingProgress = 0;
		}
		return damageTaken;
	}
	
	public void reduceMomentum(int reducedMomentum) {
		if (staticMomentumDuration < 1)
		{
			player4Momentum -= reducedMomentum / 200;
		}
		if (player4Momentum < 0)
		{
			player4Momentum = 0;
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
		UltimateItemCrafter newHealth = new UltimateItemCrafter();
		player4Health = newHealth.getMAX_HEALTH();
		ultimate = true;
		ultimateTag = "Ultimate ";
		JOptionPane.showMessageDialog(null, playerName4 + " has awakened their potential");
		System.out.println(playerName4 + " has awakened their potential");
	}

	public boolean isUltimate() {
		return ultimate;
	}
	
	public static boolean isDefending() {
		return defending;
	}
	
	public void reducePlayerKi(int kiReduction) {
		player4Ki -= kiReduction;
		if (player4Ki < 0)
		{
			if (player4ChargeNumber == 0)
			{
				player4Ki = 0;
			}
			else
			{
				player4ChargeNumber--;
				player4Ki += 100;
			}
		}
	}
	public static void setPlayer4Ki(int player4Ki) {
		ItemCrafter.player4Ki = player4Ki;
	}
	
	public void reducePlayerChargeNumber() {
		player4ChargeNumber--;
	}
	
	public void addKiUltimate(int addedKi) {
		player4Ki += addedKi;
	}
	
	public void reduceKiUltimate(int reducedKi) {
		player4Ki -= reducedKi;
	}
	
	public void addPlayerChargeNumber() {
		player4ChargeNumber++;
	}
	public static void setPlayer4ChargeNumber(int player4ChargeNumber) {
		ItemCrafter.player4ChargeNumber = player4ChargeNumber;
	}
	/**
	 * @return the aTTACK_UP
	 */
	public int getATTACK_UP() {
		return ATTACK_UP;
	}
	/**
	 * @param player4Health the player4Health to set
	 */
	public static void setPlayer4Health(int player4Health) {
		ItemCrafter.player4Health = player4Health;
	}
	
	public void addLargeHealProgress(int addedProgress) {
		largeHealProgress += addedProgress;
	}
	public static void setLargeHealProgress(int largeHealProgress) {
		ItemCrafter.largeHealProgress = largeHealProgress;
	}
	public static String getUltimateTag() {
		return ultimateTag;
	}
	
	public void addAttackUpProgress(int addedProgress) {
		attackUpProgress += addedProgress;
	}
	
	public void addDefenseUpProgress(int addedProgress) {
		defenseUpProgress += addedProgress;
	}
	
	public void addHyperChargeProgress(int addedProgress) {
		hyperChargeProgress += addedProgress;
	}
	
	public void addStaticMomentumProgress(int addedProgress) {
		staticMomentumProgress += addedProgress;
	}
	public static void setAttackUpProgress(int attackUpProgress) {
		ItemCrafter.attackUpProgress = attackUpProgress;
	}
	public static void setDefenseUpProgress(int defenseUpProgress) {
		ItemCrafter.defenseUpProgress = defenseUpProgress;
	}
	public static void setHyperChargeProgress(int hyperChargeProgress) {
		ItemCrafter.hyperChargeProgress = hyperChargeProgress;
	}
	public static void setStaticMomentumProgress(int staticMomentumProgress) {
		ItemCrafter.staticMomentumProgress = staticMomentumProgress;
	}
	/**
	 * @param player4Momentum the player4Momentum to set
	 */
	public static void setPlayer4Momentum(int player4Momentum) {
		ItemCrafter.player4Momentum = player4Momentum;
	}
	
	public void reduceHyperChargeDurationUltimate() {
		hyperChargeDuration--;
	}
	
	public void contagiousGrowthHyperChargeDuration() {
		hyperChargeDuration = 4;
		JOptionPane.showMessageDialog(null, ultimateTag + playerName4 + " powered up");
		System.out.println(ultimateTag + playerName4 + " powered up");
	}
	
	public void setCraftersIntuition() {
		craftersIntuition = true;
	}
	
	public void endCraftersIntuition() {
		craftersIntuition = false;
	}
	/**
	 * @return the craftersIntuition
	 */
	public static boolean isCraftersIntuition() {
		return craftersIntuition;
	}
	
	public static void die() {
		player4Health = 0;
		JOptionPane.showMessageDialog(null, playerName4 + " died");
		System.out.println(playerName4 + " died");
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
		heldHealth = player4Health;
		player4Health = 0;
	}
	
	public void endFusion() {
		player4Health = heldHealth;
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
		player4Momentum += addedMomentum / 20;
		if (player4Momentum > 100)
		{
			player4Momentum = 100;
		}
		JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " gave " 
				+ ultimateTag + playerName4 + " " + addedMomentum / 20 + " momentum");
		System.out.println(MageClass.getUltimateTag() + player3 + " gave " 
				+ ultimateTag + playerName4 + " " + addedMomentum / 20 + " momentum");
	}
	
	public void addKiUltimateHighSpirit(int addedKi) {
		player4Ki += addedKi / 100;
	}
	
	public static void reduceLargeHealProgress(int decreasedProgress) {
		largeHealProgress -= decreasedProgress;
	}
	
	public static void reduceAttackUpProgress(int decreasedProgress) {
		attackUpProgress -= decreasedProgress;
	}
	
	public static void reduceDefenseUpProgress(int decreasedProgress) {
		defenseUpProgress -= decreasedProgress;
	}
	
	public static void reduceHyperChargeProgress(int decreasedProgress) {
		hyperChargeProgress -= decreasedProgress;
	}
	
	public static void reduceStaticMomentumProgress(int decreasedProgress) {
		staticMomentumProgress -= decreasedProgress;
	}
	
	public void addKiDragonBalls() {
		player4Ki += 50;
		if (player4Ki > 299)
		{
			player4ChargeNumber = 3;
			player4Ki = 0;
		}
		else if (player4Ki > 199)
		{
			if (player4ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player4Ki = 0;
			}
			else if (player4ChargeNumber == 2)
			{
				player4ChargeNumber++;
				player4Ki = 100;
			}
			else
			{
				player4ChargeNumber += 2;
				player4Ki -= 200;
			}
		}
		else if (player4Ki > 99)
		{
			if (player4ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player4Ki = 0;
			}
			else 
			{
				player4ChargeNumber++;
				player4Ki -= 100;
			}
		}
		if (player4ChargeNumber == MAX_CHARGE_NUMBER)
		{
			player4Ki = 0;
		}
		player4Health += 500;
		if (player4Health > MAX_HEALTH)
		{
			player4Health = MAX_HEALTH;
		}
		Items.addPoints(50);
	}
	
	public static int getCraftingProgress() {
		return craftingProgress;
	}
	
	public static void resetCraftingProgress() {
		craftingProgress = 0;
	}
	
	public static void addCraftingProgress(int addedProgress) {
		craftingProgress += addedProgress;
	}
	
	public static int getCraftingProgressUltimate() {
		return craftingProgress * 2;
	}
	
	public void reviveItemCrafter() {
		revivalTimer--;
		if (revivalTimer == 0)
		{
			revive();
			revivalTimer = 10;
		}
	}
	
	public static void resetRevivalTimer() {
		revivalTimer = 10;
	}
	
	public static int getRevivalTimer() {
		return revivalTimer;
	}
	
	
}