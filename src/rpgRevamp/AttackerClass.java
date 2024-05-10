package rpgRevamp;

import java.util.Random;
import javax.swing.JOptionPane;
public class AttackerClass {

	private static String playerName1;//This is player 1's name
	private static int player1Health = 5000;
	private static int player1Ki = 0;
	private static int player1Momentum = 0;
	private static int player1ChargeNumber = 0;
	private final String SKILL1 = "Full Power Strike";
	private final String SKILL2 = "High Spirit";
	private final int SKILLCOST = 50;
	private Random rng = new Random();
	private int playerDamage;
	private final int PLAYERMINATTACK = 2500;
	private final int FULL_POWER_STRIKE_MIN_DAMAGE = 5000;
	private static int damageDealt = 0;
	private Broly highSpiritKi = new Broly();
	ItemCrafter itemCrafterHighSpirit = new ItemCrafter();
	MageClass mageHighSpirit = new MageClass();
	TankClass tankHighSpirit = new TankClass();
	private final int MAX_HEALTH = 5000;
	private static int attackUpDuration = 0;
	private static int defenseUpDuration = 0;
	private final int ATTACK_UP = 2;
	private final int DEFENSE_UP = 2;
	private static int hyperChargeDuration = 0;
	private static int staticMomentumDuration = 0;
	private static boolean defending = false;
	private final String MOMENTUM_SKILL = "High Spirit Strike";
	private final int HIGH_SPIRIT_STRIKE_KI_GAIN = 100;
	private final int HIGH_SPIRIT_STRIKE_MIN_DAMAGE = 7500;
	private final int DEFEND_REDUCTION = 2;
	private boolean humanShieldTarget = false;
	private boolean ultimate = false;
	private final int MAX_CHARGE_NUMBER = 3;
	private static String ultimateTag = "";
	private static int heldHealth = 0;
	
	/**
	 * This method sets player 1's name
	 * @param name This is the name set by the player
	 */
	public void setName1(String name) {
		playerName1 = name;
	}
	
	/**
	 * @return Player 1 name
	 */
	public String toString() {
		return playerName1;
	}

	/**
	 * @return player 1 health
	 */
	public int getPlayer1Health() {
		return player1Health;
	}

	/**
	 * @return player 1 ki
	 */
	public int getPlayer1Ki() {
		return player1Ki;
	}

	/**
	 * @return player 1 momentum
	 */
	public int getPlayer1Momentum() {
		return player1Momentum;
	}

	/**
	 * @return player 1 charge number
	 */
	public int getPlayer1ChargeNumber() {
		return player1ChargeNumber;
	}

	/**
	 * @return skill 1 name
	 */
	public String getSkill1() {
		return SKILL1;
	}

	/**
	 * @return skill 2 name
	 */
	public String getSkill2() {
		return SKILL2;
	}

	/**
	 * @return skill cost
	 */
	public int getSkillCost() {
		return SKILLCOST;
	}

	public int getPlayerAttack() {
		if (attackUpDuration > 0)
		{
			playerDamage = rng.nextInt(2500) + PLAYERMINATTACK;
			playerDamage *= ATTACK_UP;
		}
		else
		{
			playerDamage = rng.nextInt(2500) + PLAYERMINATTACK;
		}
		return playerDamage;
	}
	
	public int getFullPowerStrike() {
		player1ChargeNumber--;
		if (attackUpDuration > 0)
		{
			playerDamage = rng.nextInt(2500) + FULL_POWER_STRIKE_MIN_DAMAGE;
			playerDamage *= ATTACK_UP;
		}
		else
		{
			playerDamage = rng.nextInt(2500) + FULL_POWER_STRIKE_MIN_DAMAGE;
		}
		return playerDamage;
	}
	
	public void useHighSpirit() {
		String playerConfirmation = "no";
		String playerSupported = "null";
		String playerOutsideOfFusion = "null";
		FusedPlayer fusion = new FusedPlayer();
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		if (FusedPlayer.isFused())
		{
			if (FusedPlayer.getFusionType() == fusion.getTankMage())
			{
				playerOutsideOfFusion = player4.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getTankCrafter())
			{
				playerOutsideOfFusion = player3.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getMageCrafter())
			{
				playerOutsideOfFusion = player2.toString();
			}
		}
		player1Ki -= SKILLCOST;
		if (player1Ki < 0)
		{
			if (player1ChargeNumber == 0)
			{
				player1Ki = 0;
			}
			else
			{
				player1ChargeNumber--;
				player1Ki += 100;
			}
		}
		do {
			if (FusedPlayer.isFused())
			{
				playerSupported = JOptionPane.showInputDialog("Who do you want to give Ki to?\n" + fusion + "\n" + playerOutsideOfFusion);
				if (playerSupported == null)
				{
					playerSupported = "null";
				}
						if (playerSupported.equalsIgnoreCase(fusion.toString()))
						{
							if (FusedPlayer.getHealth() <= 0)
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
						else if (playerSupported.equalsIgnoreCase(playerOutsideOfFusion))
						{
							if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
									playerSupported = player2.toString();
								}
							}
							else if (playerOutsideOfFusion.equalsIgnoreCase(player3.toString()))
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
									playerSupported = player3.toString();
								}
							}
							else if (playerOutsideOfFusion.equalsIgnoreCase(player4.toString()))
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
									playerSupported = player4.toString();
								}
							}
						else 
						{
							JOptionPane.showMessageDialog(null, "Error");
							playerConfirmation = "no";
						}
			}
			}
			else
			{
				playerSupported = JOptionPane.showInputDialog("Who do you want to give Ki to?\n" + TankClass.getUltimateTag() + tankHighSpirit + "\n" + 
				MageClass.getUltimateTag() + mageHighSpirit + "\n" +  ItemCrafter.getUltimateTag() + itemCrafterHighSpirit);
				if (playerSupported == null)
				{
					playerSupported = "null";
				}
				if (playerSupported.equalsIgnoreCase(tankHighSpirit.toString()))
				{
					if (tankHighSpirit.getPlayer2Health() <= 0)
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
				else if (playerSupported.equalsIgnoreCase(mageHighSpirit.toString()))
				{
					if (mageHighSpirit.getPlayer3Health() <= 0)
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
				else if (playerSupported.equalsIgnoreCase(itemCrafterHighSpirit.toString()))
				{
					if (itemCrafterHighSpirit.getPlayer4Health() <= 0) 
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
			}
		} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
		if (playerSupported.equalsIgnoreCase(tankHighSpirit.toString()))
		{
			tankHighSpirit.addKiFromHighSpirit(damageDealt);
			Items.addPoints(damageDealt);
		}
		else if (playerSupported.equalsIgnoreCase(mageHighSpirit.toString()))
		{
			mageHighSpirit.addKiFromHighSpirit(damageDealt);
			Items.addPoints(damageDealt);
		}
		else if (playerSupported.equalsIgnoreCase(itemCrafterHighSpirit.toString()))
		{
			itemCrafterHighSpirit.addKiFromHighSpirit(damageDealt);
			Items.addPoints(damageDealt);
		}
		else if (playerSupported.equalsIgnoreCase(fusion.toString()))
		{
			fusion.addKiSkill(damageDealt);
			Items.addPoints(damageDealt);
		}
		damageDealt = 0;
	}

	public void setDamageDealt() {
		damageDealt += highSpiritKi.getDamageTook();
	}
	
	public void increaseHealth(int heal) {
		player1Health += heal;
		Items.addPoints(heal);
		if (player1Health > MAX_HEALTH)
		{
			player1Health = MAX_HEALTH;
		}
		JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " healed " + heal + " health");
		System.out.println(ultimateTag + playerName1 + " healed " + heal + " health");
	}
	public void revive() {
		player1Health = MAX_HEALTH;
		Items.addPoints(10000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " was revived");
		System.out.println(ultimateTag + playerName1 + " was revived");
	}

	public void setAttackUpDuration() {
		attackUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " powered up");
		System.out.println(ultimateTag + playerName1 + " powered up");
	}
	
	public void reduceAttackUpDuration() {
		if (attackUpDuration > 2)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s attack up will last for " 
			+ attackUpDuration + " more turns");
			System.out.println(ultimateTag + playerName1 + "'s attack up will last for " 
			+ attackUpDuration + " more turns");
		}
		else if (attackUpDuration == 2)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
			System.out.println(ultimateTag + playerName1 + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
		}
		else
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s attack up has ended");
			System.out.println(ultimateTag + playerName1 + "'s attack up has ended");
		}
	}
	public void setDefenseUpDuration() {
		defenseUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s body got tougher");
		System.out.println(ultimateTag + playerName1 + "'s body got tougher");
	}
	
	public void reduceDefenseUpDuration() {
		if (defenseUpDuration > 2)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
			System.out.println(ultimateTag + playerName1 + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
		}
		else if (defenseUpDuration == 2)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
			System.out.println(ultimateTag + playerName1 + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
		}
		else
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s defense up has ended");
			System.out.println(ultimateTag + playerName1 + "'s defense up has ended");
		}
	}
	
	public void setHyperChargeDuration() {
		hyperChargeDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " is overflowing with ki");
		System.out.println(ultimateTag + playerName1 + " is overflowing with ki");
	}
	
	public void reduceHyperChargeDuration() {
		if (hyperChargeDuration > 2)
		{
			player1Ki += 15;
			if (player1Ki > 99)
			{
				if (player1ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player1Ki = 0;
				}
				else 
				{
					player1ChargeNumber++;
					player1Ki -= 100;
				}
			}
			if (player1ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player1Ki = 0;
			}
				hyperChargeDuration--;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
				System.out.println(ultimateTag + playerName1 + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
		}
		else if (hyperChargeDuration == 2)
		{
			player1Ki += 15;
			if (player1Ki > 100)
			{
				if (player1ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player1Ki = 0;
				}
				else 
				{
					player1ChargeNumber++;
					player1Ki -= 100;
				}
			}
			if (player1ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player1Ki = 0;
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
			System.out.println(ultimateTag + playerName1 + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
		}
		else
		{
			player1Ki += 15;
			if (player1Ki > 99)
			{
				if (player1ChargeNumber == MAX_CHARGE_NUMBER)
				{
					player1Ki = 0;
				}
				else 
				{
					player1ChargeNumber++;
					player1Ki -= 100;
				}
			}
			if (player1ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player1Ki = 0;
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s hyper charge has ended");
			System.out.println(ultimateTag + playerName1 + "'s hyper charge has ended");
		}
	}

	public int getSKILLCOST() {
		return SKILLCOST;
	}
	
	public void setStaticMomentumDuration() {
		staticMomentumDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " is now focused");
		System.out.println(ultimateTag + playerName1 + " is now focused");
	}
	
	public void reduceStaticMomentumDuration() {
		if (staticMomentumDuration > 2)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
			System.out.println(ultimateTag + playerName1 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
		}
		else if (staticMomentumDuration == 2)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
			System.out.println(ultimateTag + playerName1 + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
		}
		else 
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + "'s static momentum has ended");
			System.out.println(ultimateTag + playerName1 + "'s static momentum has ended");
		}
	}
	
	public void startDefending() {
		defending = true;
	}
	
	public void endDefending() {
		defending = false;
	}
	
	public void addKi(int addedKi) {
		if (player1Health <= 0)
		{
		}
		else if (hyperChargeDuration > 0)
		{
			player1Ki += addedKi / 50;
		}
		else
		{
			player1Ki += addedKi / 100;
		}
		if (player1Ki > 299)
		{
			player1ChargeNumber = 3;
			player1Ki = 0;
		}
		else if (player1Ki > 199)
		{
			if (player1ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player1Ki = 0;
			}
			else if (player1ChargeNumber == 2)
			{
				player1ChargeNumber++;
				player1Ki = 100;
			}
			else
			{
				player1ChargeNumber += 2;
				player1Ki -= 200;
			}
		}
		else if (player1Ki > 99)
		{
			if (player1ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player1Ki = 0;
			}
			else 
			{
				player1ChargeNumber++;
				player1Ki -= 100;
			}
		}
		if (player1ChargeNumber == MAX_CHARGE_NUMBER)
		{
			player1Ki = 0;
		}
		Items.addPoints(addedKi);
	}
	
	public void addMomentum(int addedMomentum) {
		player1Momentum += addedMomentum / 500;
		if (player1Momentum > 100)
		{
			player1Momentum = 100;
		}
		Items.addPoints(addedMomentum);
	}

	public String getMOMENTUM_SKILL() {
		return MOMENTUM_SKILL;
	}

	public int getHIGH_SPIRIT_STRIKE_KI_GAIN() {
		player1Momentum = 0;
		return HIGH_SPIRIT_STRIKE_KI_GAIN;
	}
	
	public int getHighSpiritStrikeDamage() {
		playerDamage = rng.nextInt(2500) + HIGH_SPIRIT_STRIKE_MIN_DAMAGE;
		return playerDamage;
	}
	
	public void sharedGrowthHyperChargeDuration() {
		hyperChargeDuration = 2;
		JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " powered up");
		System.out.println(ultimateTag + playerName1 + " powered up");
	}
	
	public int takeDamage(int damageTaken) {
		Broly dodgeCost = new Broly();
		String dodge = "no";
		boolean validAnswer = false;
		boolean canDodge = false;
		UltimateTankClass player2 = new UltimateTankClass();
		FusedPlayer fusion = new FusedPlayer();
		Items usedItem = new Items();
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
						damageTaken = fusion.takeDamage(damageTaken);
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
							fusionTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + ultimateTag + playerName1 + "\n" +
									ItemCrafter.getUltimateTag() + itemCrafterHighSpirit);
							if (fusionTurn == null)
							{
								fusionTurn = "null";
							}
							if (fusionTurn.equalsIgnoreCase(playerName1))
							{
								{
									playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
									if (playerConfirmation == null)
									{
										playerConfirmation = "null";
									}
								}
							}
							else if (fusionTurn.equalsIgnoreCase(itemCrafterHighSpirit.toString()))
							{
								if (itemCrafterHighSpirit.getPlayer4Health() <= 0)
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
						if (fusionTurn.equalsIgnoreCase(playerName1))
						{
							setDefenseUpDuration();
							fusion.addMomentum(10000);
						}
						else if (fusionTurn.equalsIgnoreCase(itemCrafterHighSpirit.toString()))
						{
							itemCrafterHighSpirit.setDefenseUpDuration();
							fusion.addMomentum(10000);
						}
					}
				}
				else
				{
					do 
					{
						fusionTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + ultimateTag + playerName1 + "\n" +
								ItemCrafter.getUltimateTag() + itemCrafterHighSpirit);
						if (fusionTurn == null)
						{
							fusionTurn = "null";
						}
						if (fusionTurn.equalsIgnoreCase(playerName1))
						{
							{
								playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
								if (playerConfirmation == null)
								{
									playerConfirmation = "null";
								}
							}
						}
						else if (fusionTurn.equalsIgnoreCase(itemCrafterHighSpirit.toString()))
						{
							if (itemCrafterHighSpirit.getPlayer4Health() <= 0)
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
					if (fusionTurn.equalsIgnoreCase(playerName1))
					{
						setDefenseUpDuration();
						fusion.addMomentum(10000);
					}
					else if (fusionTurn.equalsIgnoreCase(itemCrafterHighSpirit.toString()))
					{
						itemCrafterHighSpirit.setDefenseUpDuration();
						fusion.addMomentum(10000);
					}
					damageTaken = 0;
				}
			}
			else if (FusedPlayer.getFusionType() == fusion.getTankCrafter())
			{
				String playerConfirmation;
				String fusionTurn;
				damageTaken = fusion.takeDamage(damageTaken);
				dodgeCost.addKi(damageTaken);
				fusion.addMomentum(damageTaken);
				if (!Broly.isBrolyFullPowerUltimate())
				{
					dodgeCost.addMomentum(damageTaken);
				}
				do
				{
					JOptionPane.showMessageDialog(null, fusion + " used " + FusedPlayer.getSkill1());
					System.out.println(fusion + " used " + FusedPlayer.getSkill1());
					fusionTurn = JOptionPane.showInputDialog("Which item do you "
						+ "want to craft?\n" + usedItem.getITEM2() + " - " + FusedPlayer.getLargeHealProgress()
						+ "%\n" + usedItem.getITEM4() + " - " + FusedPlayer.getAttackUpProgress()
						+ "%\n" + usedItem.getITEM5() + " - " + FusedPlayer.getDefenseUpProgress() + "%\n" + 
						usedItem.getITEM6() + " - " + FusedPlayer.getHyperChargeProgress() + "%\n" + usedItem.getITEM7() + 
						" - " + FusedPlayer.getStaticMomentumProgress() + "%");
					if (fusionTurn == null)
					{
						fusionTurn = "null";
					}
					if (fusionTurn.equalsIgnoreCase(usedItem.getITEM2()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM4()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM5()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM6()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM7()))
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
				if (fusionTurn.equalsIgnoreCase(usedItem.getITEM2()))
				{
					fusion.addMomentum(fusion.craftLargeHealCraftersStrength(damageTaken));
				}
				else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM4()))
				{
					fusion.addMomentum(fusion.craftAttackUpCraftersStrength(damageTaken));
				}
				else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM5()))
				{
					fusion.addMomentum(fusion.craftDefenseUpCraftersStrength(damageTaken));
				}
				else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM6()))
				{
					fusion.addMomentum(fusion.craftHyperChargeCraftersStrength(damageTaken));
				}
				else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM7()))
				{
					fusion.addMomentum(fusion.craftStaticMomentumCraftersStrength(damageTaken));
				}
				damageTaken = 0;
			}
			else if (player2.getPlayer2Health() <= 0)
			{
				humanShieldTarget = false;
			}
			else if (player2.isUltimate())
			{
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName1);
				System.out.println(TankClass.getUltimateTag() + player2 + " protected " + ultimateTag + playerName1);
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
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " protected " + playerName1);
				System.out.println(TankClass.getUltimateTag() + player2 + " protected " + playerName1);
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
			if (player1ChargeNumber < 5)
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
			if (player1ChargeNumber < 4)
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
			if (player1ChargeNumber < 3)
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
			if (player1ChargeNumber < 2)
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
			if (player1ChargeNumber < 1)
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
							ultimateTag + playerName1 + " Ki: " + player1ChargeNumber + " (" + 
							player1Ki + ")\nCost"
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
							ultimateTag + playerName1 + " Ki: " + player1ChargeNumber + " (" + 
							player1Ki + ")\nCost"
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
							ultimateTag + playerName1 + " Ki: " + player1ChargeNumber + " (" + 
							player1Ki + ")\nCost"
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
						ultimateTag + playerName1 + " Ki: " + player1ChargeNumber + ",(" + 
						player1Ki + ")\nCost"
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
						ultimateTag + playerName1 + " Ki: " + player1ChargeNumber + " (" + 
						player1Ki + ")\nCost"
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
				JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " dodged"); 
				System.out.println(ultimateTag + playerName1 + " dodged");
				player1ChargeNumber -= 5;
				{
					player1ChargeNumber = 0;
				}
			}
			else if (Broly.isBrolySuperUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " dodged"); 
				System.out.println(ultimateTag + playerName1 + " dodged");
				player1ChargeNumber -= 4;
				if (player1ChargeNumber < 0)
				{
					player1ChargeNumber = 0;
				}
			}
			else if (dodgeCost.isBrolyUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " dodged"); 
				System.out.println(ultimateTag + playerName1 + " dodged");
				player1ChargeNumber -= 3;
				if (player1ChargeNumber < 0)
				{
					player1ChargeNumber = 0;
				}
			}
			else if (dodgeCost.isBrolySuper())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " dodged"); 
				System.out.println(ultimateTag + playerName1 + " dodged");
				player1ChargeNumber -= 2;
				if (player1ChargeNumber < 0)
				{
					player1ChargeNumber = 0;
				}
			}
			else
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " dodged"); 
				System.out.println(ultimateTag + playerName1 + " dodged");
				player1ChargeNumber -= 1;
				if (player1ChargeNumber < 0)
				{
					player1ChargeNumber = 0;
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
			player1Health -= damageTaken;
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " took " + 
			damageTaken + " damage");
			System.out.println(ultimateTag + playerName1 + " took " + 
			damageTaken + " damage");
		}
		if (player1Health <= 0)
		{
			JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " died");
			System.out.println(ultimateTag + playerName1 + " died");
			ultimate = false;
			ultimateTag = "";
			player1Ki = 0;
			player1ChargeNumber = 0;
			player1Momentum = 0;
			attackUpDuration = 0;
			defenseUpDuration = 0;
			hyperChargeDuration = 0;
			staticMomentumDuration = 0;
			player1Health = 0;
			damageDealt = 0;
		}
		return damageTaken;
	}
	
	public void reduceMomentum(int reducedMomentum) {
		if (staticMomentumDuration < 1)
		{
			player1Momentum -= reducedMomentum / 200;
		}
		if (player1Momentum < 0)
		{
			player1Momentum = 0;
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
		UltimateAttackerClass newHealth = new UltimateAttackerClass();
		player1Health = newHealth.getMAX_HEALTH();
		ultimate = true;
		ultimateTag = "Ultimate ";
		JOptionPane.showMessageDialog(null, playerName1 + " has awakened their potential");
		System.out.println(playerName1 + " has awakened their potential");
	}

	public boolean isUltimate() {
		return ultimate;
	}

	public static boolean isDefending() {
		return defending;
	}

	public int getATTACK_UP() {
		return ATTACK_UP;
	}
	
	public void reducePlayerKi(int kiReduction) {
		player1Ki -= kiReduction;
		if (player1Ki < 0)
		{
			if (player1ChargeNumber == 0)
			{
				player1Ki = 0;
			}
			else
			{
				player1ChargeNumber--;
				player1Ki += 100;
			}
		}
	}

	public static void setPlayer1Ki(int player1Ki) {
		AttackerClass.player1Ki = player1Ki;
	}
	
	public void reducePlayerChargeNumber() {
		player1ChargeNumber--;
	}
	
	public void addKiUltimate(int addedKi) {
		player1Ki += addedKi;
	}
	
	public void reduceKiUltimate(int reducedKi) {
		player1Ki -= reducedKi;
	}

	public static int getDamageDealt() {
		return damageDealt;
	}

	public static void setDamageDealt(int damageDealt) {
		AttackerClass.damageDealt = damageDealt;
		Items.addPoints(damageDealt);
	}

	public static void setPlayer1Health(int player1Health) {
		AttackerClass.player1Health = player1Health;
	}
	
	public void addPlayerChargeNumber() {
		player1ChargeNumber++;
	}
	
	public void reduceHyperChargeDurationUltimate() {
		hyperChargeDuration--;
	}

	public static void setPlayer1ChargeNumber(int player1ChargeNumber) {
		AttackerClass.player1ChargeNumber = player1ChargeNumber;
	}

	public static void setPlayer1Momentum(int player1Momentum) {
		AttackerClass.player1Momentum = player1Momentum;
	}

	/**
	 * @return the ultimateTag
	 */
	public static String getUltimateTag() {
		return ultimateTag;
	}
	
	public void contagiousGrowthHyperChargeDuration() {
		hyperChargeDuration = 4;
		JOptionPane.showMessageDialog(null, ultimateTag + playerName1 + " powered up");
		System.out.println(ultimateTag + playerName1 + " powered up");
	}
	
	public static void die() {
		player1Health = 0;
		JOptionPane.showMessageDialog(null, playerName1 + " died");
		System.out.println(playerName1 + " died");
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
		heldHealth = player1Health;
		player1Health = 0;
	}
	
	public void endFusion() {
		player1Health = heldHealth;
	}
	
	public void addMomentumFromMage(int addedMomentum) {
		MageClass player3 = new MageClass();
		player1Momentum += addedMomentum / 20;
		if (player1Momentum > 100)
		{
			player1Momentum = 100;
		}
		JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " gave " 
				+ ultimateTag + playerName1 + " " + addedMomentum / 20 + " momentum");
		System.out.println(MageClass.getUltimateTag() + player3 + " gave " 
				+ ultimateTag + playerName1 + " " + addedMomentum / 20 + " momentum");
	}
	
	public void reduceChargeNumberUltimateSkill1() {
		player1ChargeNumber -= 2;
	}
	
	public void addKiDragonBalls() {
		player1Ki += 50;
		if (player1Ki > 299)
		{
			player1ChargeNumber = 3;
			player1Ki = 0;
		}
		else if (player1Ki > 199)
		{
			if (player1ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player1Ki = 0;
			}
			else if (player1ChargeNumber == 2)
			{
				player1ChargeNumber++;
				player1Ki = 100;
			}
			else
			{
				player1ChargeNumber += 2;
				player1Ki -= 200;
			}
		}
		else if (player1Ki > 99)
		{
			if (player1ChargeNumber == MAX_CHARGE_NUMBER)
			{
				player1Ki = 0;
			}
			else 
			{
				player1ChargeNumber++;
				player1Ki -= 100;
			}
		}
		if (player1ChargeNumber == MAX_CHARGE_NUMBER)
		{
			player1Ki = 0;
		}
		player1Health += 500;
		if (player1Health > MAX_HEALTH)
		{
			player1Health = MAX_HEALTH;
		}
		Items.addPoints(50);
	}
}