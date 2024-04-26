package rpgRevamp;

import java.util.Random;

import javax.swing.JOptionPane;

public class FusedPlayer {
	private static String name;
	private static int health;
	private static int maxHealth;
	private static int ki;
	private static int chargeNumber = 0;
	private static int momentum;
	private static int minimumAttack;
	private static int attackUpDuration = 0;
	private static int defenseUpDuration = 0;
	private final int ATTACK_UP = 2;
	private final int DEFENSE_UP = 2;
	private static int hyperChargeDuration = 0;
	private static int staticMomentumDuration = 0;
	private static boolean defending = false;
	private final int DEFEND_REDUCTION = 2;
	private final int MAX_CHARGE_NUMBER = 7;
	private static int fusionType;
	private static final int ATTACK_TANK = 12;
	private static final int ATTACK_MAGE = 13;
	private static final int ATTACK_CRAFTER = 14;
	private static final int TANK_MAGE = 23;
	private static final int TANK_CRAFTER = 24;
	private static final int MAGE_CRAFTER = 34;
	private Random rng = new Random();
	private static boolean fused = false;
	private boolean humanShieldTarget = false;
	private static int fusionCountdown = 30;
	private static int fusionCooldown = 0;
	private static String momentumSkill = "";
	private static String skill1 = "";
	private static String skill2 = "";
	private static String skill1Description = "";
	private static String skill2Description = "";
	private static String momentumSkillDescription = "";
	private static final String ATTACK_TANK_SKILL_1 = "Full Power Counter";
	private static final String ATTACK_TANK_SKILL_1_DESCRIPTION = "Take a hit for an ally and strike back - 250 Ki";
	private static final String ATTACK_TANK_SKILL_2 = "Rejuvenation";
	private static final String ATTACK_TANK_SKILL_2_DESCRIPTION = "Give an ally ki and health - 150 Ki";
	private static final String ATTACK_MAGE_SKILL_1 = "Energy Steal";
	private static final String ATTACK_MAGE_SKILL_1_DESCRIPTION = "If Broly has more Ki, attack Broly and steal some of his ki. If not, Grant an ally an random buff. - 200 Ki";
	private static final String ATTACK_MAGE_SKILL_2 = "Energy Assist";
	private static final String ATTACK_MAGE_SKILL_2_DESCRIPTION = "Give an ally ki and momentum - 700 Ki";
	private static final String ATTACK_CRAFTER_SKILL_1 = "Crafter's Strength";
	private static final String ATTACK_CRAFTER_SKILL_1_DESCRIPTION = "Attack Broly and craft an item - 200 Ki";
	private static final String ATTACK_CRAFTER_SKILL_2 = "Elixir of Restoration";
	private static final String ATTACK_CRAFTER_SKILL_2_DESCRIPTION = "Heal youself and give allies increased ki gain - 150 Ki";
	private static final String TANK_MAGE_SKILL_1 = "Ki Shield";
	private static final String TANK_MAGE_SKILL_1_DESCRIPTION = "Block an attack for an ally. If Broly has more ki, take reduced damage and gain ki back. If not, block the attack and give defense up to ally. - 200 Ki";
	private static final String TANK_MAGE_SKILL_2 = "Revialization";
	private static final String TANK_MAGE_SKILL_2_DESCRIPTION = "Give an ally health and momentum - 700 Ki";
	private static final String TANK_CRAFTER_SKILL_1 = "Unbreakable Concentration";
	private static final String TANK_CRAFTER_SKILL_1_DESCRIPTION = "Tank an attack for an ally and craft a item - 200 Ki";
	private static final String TANK_CRAFTER_SKILL_2 = "Medkit";
	private static final String TANK_CRAFTER_SKILL_2_DESCRIPTION = "Heal yourself and an ally - 150 Ki";
	private static final String MAGE_CRAFTER_SKILL_1 = "Development";
	private static final String MAGE_CRAFTER_SKILL_1_DESCRIPTION = "If broly has more ki, give an ally focus. If not, progress one stage on every item. - 150 Ki";
	private static final String MAGE_CRAFTER_SKILL_2 = "Medicine";
	private static final String MAGE_CRAFTER_SKILL_2_DESCRIPTION = "Heal yourself and give an ally momentum - 700 Ki";
	private static final String ATTACK_TANK_MOMENTUM_SKILL = "High Spirit Genki Shield";
	private static final String ATTACK_TANK_MOMENTUM_SKILL_DESCRIPTION = "Block the next attack and give all allies ki and health";
	private static final String ATTACK_MAGE_MOMENTUM_SKILL = "Cordinated Attack";
	private static final String ATTACK_MAGE_MOMENTUM_SKILL_DESCRIPTION = "Deal high damage and give all allies attack up and ki";
	private static final String ATTACK_CRAFTER_MOMENTUM_SKILL = "High Speed Rush";
	private static final String ATTACK_CRAFTER_MOMENTUM_SKILL_DESCRIPTION = "Deal high damage, progress one stage on every item, and craft a senzu";
	private static final String TANK_MAGE_MOMENTUM_SKILL = "Mastery of Offense and Defense";
	private static final String TANK_MAGE_MOMENTUM_SKILL_DESCRIPTION = "Block the next attack and give allies health and attack up";
	private static final String TANK_CRAFTER_MOMENTUM_SKILL = "Barricade";
	private static final String TANK_CRAFTER_MOMENTUM_SKILL_DESCRIPTION = "Block the next attack, progress one stage on all items, and craft a senzu";
	private static final String MAGE_CRAFTER_MOMENTUM_SKILL = "Prep Time";
	private static final String MAGE_CRAFTER_MOMENTUM_SKILL_DESCRIPTION = "Give all allies attack up, progress one stage on all items, and craft a senzu";
	private final int ENERGY_STEAL_MIN_ATTACK = 5000;
	private static int largeHealProgress = 0;
	private static int attackUpProgress = 0;
	private static int defenseUpProgress = 0;
	private static int hyperChargeProgress = 0;
	private static int staticMomentumProgress = 0;
	private static boolean momentumSkillActive = false;
	private final int CRAFTERS_STRENGTH_MIN_DAMAGE = 4444;
	private static int damageTaken;
	private static int damageDealt;
	private static int kiGained;
	private final int MED_KIT_MIN_HEAL = 2000;
	private int medKitHeal = 0;
	private final int HIGH_SPIRIT_GENKI_SHIELD_HEAL = 6000;
	private final int HIGH_SPIRIT_GENKI_SHIELD_KI = 150;
	private final int CORDINATED_ATTACK_MIN_DAMAGE = 10714;
	private final int HIGH_SPEED_RUSH_MIN_DAMAGE = 9522;
	private final int MASTERY_OF_OFFENSE_AND_DEFENSE_HEAL = 4000;
	private static boolean protectionSkill;
	private static boolean potaraFusion = false;
	private static int potaraBuff = 1;
	
	public static void setName(String name1, String name2) {
		name = name1.substring(0, name1.length() - 1) + name2.substring(name2.length() - 2, name2.length());
		fused = true;
		fusionCountdown = 31;
		Items.addPoints(10000000);
	}

	/**
	 * @return the name
	 */
	@Override
	public String toString() {
		return name;
	}
	
	public static void setMaxHealth(int maxHealth1, int maxHealth2) {
		maxHealth = (maxHealth1 + maxHealth2) * potaraBuff;
		health = maxHealth;
	}
	
	public static void setMinimumAttack(int minAttack1, int minAttack2) {
		minimumAttack = (minAttack1 + minAttack2) * potaraBuff;
	}
	
	public static void setFusionType(int fusionType) {
		FusedPlayer.fusionType = fusionType;
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		if (potaraFusion)
		{
			potaraBuff = 2;
		}
		switch (fusionType)
		{
		case ATTACK_TANK:
		{
			skill1 = ATTACK_TANK_SKILL_1;
			skill2 = ATTACK_TANK_SKILL_2;
			momentumSkill = ATTACK_TANK_MOMENTUM_SKILL;
			skill1Description = ATTACK_TANK_SKILL_1_DESCRIPTION;
			skill2Description = ATTACK_TANK_SKILL_2_DESCRIPTION;
			momentumSkillDescription = ATTACK_TANK_MOMENTUM_SKILL_DESCRIPTION;
			player1.fuse();
			player2.fuse();
			break;
		}
		case ATTACK_MAGE:
		{
			skill1 = ATTACK_MAGE_SKILL_1;
			skill2 = ATTACK_MAGE_SKILL_2;
			momentumSkill = ATTACK_MAGE_MOMENTUM_SKILL;
			skill1Description = ATTACK_MAGE_SKILL_1_DESCRIPTION;
			skill2Description = ATTACK_MAGE_SKILL_2_DESCRIPTION;
			momentumSkillDescription = ATTACK_MAGE_MOMENTUM_SKILL_DESCRIPTION;
			player1.fuse();
			player3.fuse();
			break;
		}
		case ATTACK_CRAFTER:
		{
			skill1 = ATTACK_CRAFTER_SKILL_1;
			skill2 = ATTACK_CRAFTER_SKILL_2;
			momentumSkill = ATTACK_CRAFTER_MOMENTUM_SKILL;
			skill1Description = ATTACK_CRAFTER_SKILL_1_DESCRIPTION;
			skill2Description = ATTACK_CRAFTER_SKILL_2_DESCRIPTION;
			momentumSkillDescription = ATTACK_CRAFTER_MOMENTUM_SKILL_DESCRIPTION;
			player1.fuse();
			player4.fuse();
			break;
		}
		case TANK_MAGE:
		{
			skill1 = TANK_MAGE_SKILL_1;
			skill2 = TANK_MAGE_SKILL_2;
			momentumSkill = TANK_MAGE_MOMENTUM_SKILL;
			skill1Description = TANK_MAGE_SKILL_1_DESCRIPTION;
			skill2Description = TANK_MAGE_SKILL_2_DESCRIPTION;
			momentumSkillDescription = TANK_MAGE_MOMENTUM_SKILL_DESCRIPTION;
			player2.fuse();
			player3.fuse();
			break;
		}
		case TANK_CRAFTER:
		{
			skill1 = TANK_CRAFTER_SKILL_1;
			skill2 = TANK_CRAFTER_SKILL_2;
			momentumSkill = TANK_CRAFTER_MOMENTUM_SKILL;
			skill1Description = TANK_CRAFTER_SKILL_1_DESCRIPTION;
			skill2Description = TANK_CRAFTER_SKILL_2_DESCRIPTION;
			momentumSkillDescription = TANK_CRAFTER_MOMENTUM_SKILL_DESCRIPTION;
			player2.fuse();
			player4.fuse();
			break;
		}
		case MAGE_CRAFTER:
		{
			skill1 = MAGE_CRAFTER_SKILL_1;
			skill2 = MAGE_CRAFTER_SKILL_2;
			momentumSkill = MAGE_CRAFTER_MOMENTUM_SKILL;
			skill1Description = MAGE_CRAFTER_SKILL_1_DESCRIPTION;
			skill2Description = MAGE_CRAFTER_SKILL_2_DESCRIPTION;
			momentumSkillDescription = MAGE_CRAFTER_MOMENTUM_SKILL_DESCRIPTION;
			player3.fuse();
			player4.fuse();
			break;
		}
		}
	}

	/**
	 * @return the fusionType
	 */
	public static int getFusionType() {
		return fusionType;
	}

	/**
	 * @return the attackTank
	 */
	public int getAttackTank() {
		return ATTACK_TANK;
	}

	/**
	 * @return the attackMage
	 */
	public int getAttackMage() {
		return ATTACK_MAGE;
	}

	/**
	 * @return the attackCrafter
	 */
	public int getAttackCrafter() {
		return ATTACK_CRAFTER;
	}

	/**
	 * @return the tankMage
	 */
	public int getTankMage() {
		return TANK_MAGE;
	}

	/**
	 * @return the tankCrafter
	 */
	public int getTankCrafter() {
		return TANK_CRAFTER;
	}

	/**
	 * @return the mageCrafter
	 */
	public int getMageCrafter() {
		return MAGE_CRAFTER;
	}

	/**
	 * @return the health
	 */
	public static int getHealth() {
		return health;
	}

	/**
	 * @return the maxHealth
	 */
	public static int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @return the ki
	 */
	public static int getKi() {
		return ki;
	}

	/**
	 * @return the momentum
	 */
	public static int getMomentum() {
		return momentum;
	}

	/**
	 * @return the attackUpDuration
	 */
	public static int getAttackUpDuration() {
		return attackUpDuration;
	}

	/**
	 * @return the defenseUpDuration
	 */
	public static int getDefenseUpDuration() {
		return defenseUpDuration;
	}

	/**
	 * @return the hyperChargeDuration
	 */
	public static int getHyperChargeDuration() {
		return hyperChargeDuration;
	}

	/**
	 * @return the staticMomentumDuration
	 */
	public static int getStaticMomentumDuration() {
		return staticMomentumDuration;
	}

	/**
	 * @return the defending
	 */
	public static boolean isDefending() {
		return defending;
	}
	
	public int getPlayerAttack() {
		int playerDamage;
		if (attackUpDuration > 0)
		{
			playerDamage = rng.nextInt(minimumAttack) + minimumAttack * potaraBuff;
			playerDamage *= ATTACK_UP;
		}
		else
		{
			playerDamage = rng.nextInt(minimumAttack) + minimumAttack * potaraBuff;
		}
		return playerDamage;
	}
	
	public void increaseHealth(int heal) {
		health += heal;
		Items.addPoints(heal);
		if (health > maxHealth)
		{
			health = maxHealth;
		}
		JOptionPane.showMessageDialog(null, name + " healed " + heal + " health");
		System.out.println(name + " healed " + heal + " health");
	}
	
	public void setAttackUpDuration() {
		attackUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, name + " powered up");
		System.out.println(name + " powered up");
	}

	/**
	 * @return the fused
	 */
	public static boolean isFused() {
		return fused;
	}
	
	public void reduceAttackUpDuration() {
		if (attackUpDuration > 1)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, name + "'s attack up will last for " 
			+ attackUpDuration + " more turns");
			System.out.println(name + "'s attack up will last for " 
			+ attackUpDuration + " more turns");
		}
		else if (attackUpDuration == 1)
		{
			attackUpDuration--;
			JOptionPane.showMessageDialog(null, name + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
			System.out.println(name + "'s attack up will last for " 
					+ attackUpDuration + " more turn");
		}
	}
	
	public void setDefenseUpDuration() {
		defenseUpDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, name + "'s body got tougher");
		System.out.println(name + "'s body got tougher");
	}
	
	public void reduceDefenseUpDuration() {
		if (defenseUpDuration > 1)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, name + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
			System.out.println(name + "'s defense up will last for " 
					+ defenseUpDuration + " turns");
		}
		else if (defenseUpDuration == 1)
		{
			defenseUpDuration--;
			JOptionPane.showMessageDialog(null, name + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
			System.out.println(name + "'s defense up will last for " 
					+ defenseUpDuration + " turn");
		}
	}
	
	public void setHyperChargeDuration() {
		hyperChargeDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, name + " is overflowing with ki");
		System.out.println(name + " is overflowing with ki");
	}
	
	public void reduceHyperChargeDuration() {
		if (hyperChargeDuration > 1)
		{
			ki += 15;
			if (ki > 100)
			{
				if (chargeNumber == MAX_CHARGE_NUMBER)
				{
					ki = 100;
				}
				else 
				{
					chargeNumber++;
					ki -= 100;
				}
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, name + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
			System.out.println(name + "'s hyper charge will last for " + hyperChargeDuration + " more turns");
		}
		else if (hyperChargeDuration == 1)
		{
			ki += 15;
			if (ki > 100)
			{
				if (chargeNumber == MAX_CHARGE_NUMBER)
				{
					ki = 100;
				}
				else 
				{
					chargeNumber++;
					ki -= 100;
				}
			}
			hyperChargeDuration--;
			JOptionPane.showMessageDialog(null, name + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
			System.out.println(name + "'s hyper charge will last for " + hyperChargeDuration + " more turn");
		}
	}

	/**
	 * @return the chargeNumber
	 */
	public static int getChargeNumber() {
		return chargeNumber;
	}
	
	public void setStaticMomentumDuration() {
		staticMomentumDuration = 4;
		Items.addPoints(2000);
		JOptionPane.showMessageDialog(null, name + " is now focused");
		System.out.println(name + " is now focused");
	}
	
	public void reduceStaticMomentumDuration() {
		if (staticMomentumDuration > 1)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, name + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
			System.out.println(name + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turns");
		}
		else if (staticMomentumDuration == 1)
		{
			staticMomentumDuration--;
			JOptionPane.showMessageDialog(null, name + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
			System.out.println(name + "'s static momentum"
					+ " will last for " + staticMomentumDuration + " more turn");
		}
	}
	
	public void startDefending() {
		defending = true;
	}
	
	public void endDefending() {
		defending = false;
	}
	
	public void addKi(int addedKi) {
		if (health <= 0)
		{
		}
		else if (hyperChargeDuration > 0)
		{
			ki += addedKi / 10;
			kiGained += addedKi / 10;
		}
		else
		{
			ki += addedKi / 100;
			kiGained += addedKi / 100;
		}
		if (ki > 699)
		{
			chargeNumber = 7;
			ki = 0;
		}
		else if (ki > 599)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 600;
			}
		}
		else if (ki > 499)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 500;
			}
		}
		else if (ki > 399)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 400;
			}
		}
		else if (ki > 299)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 300;
			}
		}
		else if (ki > 199)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 200;
			}
		}
		else if (ki > 99)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 100;
			}
		}
		if (chargeNumber == MAX_CHARGE_NUMBER)
		{
			ki = 0;
		}
		Items.addPoints(addedKi);
	}
	
	public void addMomentum(int addedMomentum) {
		momentum += addedMomentum / 500;
		if (momentum > 100)
		{
			momentum = 100;
		}
		Items.addPoints(addedMomentum);
	}
	
	public void sharedGrowthAttackUpDuration() {
		attackUpDuration = 2;
		JOptionPane.showMessageDialog(null, name + " powered up");
		System.out.println(name + " powered up");
	}
	
	public int takeDamage(int damageTaken) {
		Broly dodgeCost = new Broly();
		String dodge = "no";
		boolean validAnswer = false;
		boolean canDodge = false;
		UltimateTankClass player2 = new UltimateTankClass();
		if (humanShieldTarget)
		{
			if (player2.getPlayer2Health() <= 0)
			{
				humanShieldTarget = false;
			}
			else if (player2.isUltimate())
			{
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " protected " + name);
				System.out.println(TankClass.getUltimateTag() + player2 + " protected " + name);
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
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " protected " + name);
				System.out.println(TankClass.getUltimateTag() + player2 + " protected " + name);
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
		}
		else if (player2.getUltimateGenkiShieldDuration() > 0)
		{
		}
		else if (Broly.isBrolyFullPowerUltimate())
		{
			if (chargeNumber < 5)
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
			if (chargeNumber < 4)
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
			if (chargeNumber < 3)
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
			if (chargeNumber < 2)
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
			if (chargeNumber < 1)
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
							name + " Ki: " + chargeNumber + " (" + 
							ki + ")\nCost"
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
							name + " Ki: " + chargeNumber + " (" + 
							ki + ")\nCost"
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
							name + " Ki: " + chargeNumber + " (" + 
							ki + ")\nCost"
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
						name + " Ki: " + chargeNumber + ",(" + 
						ki + ")\nCost"
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
						name + " Ki: " + chargeNumber + " (" + 
						ki + ")\nCost"
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
			if (dodge.equalsIgnoreCase("yes") || dodge.equalsIgnoreCase("y"))
			{
				if (Broly.isBrolyFullPowerUltimate())
				{
					damageTaken = 0;
					JOptionPane.showMessageDialog(null, name + " dodged"); 
					System.out.println(name + " dodged");
					chargeNumber -= 5;
					if (chargeNumber < 0)
					{
						chargeNumber = 0;
					}
				}
				else if (Broly.isBrolySuperUltimate())
				{
					damageTaken = 0;
					JOptionPane.showMessageDialog(null, name + " dodged"); 
					System.out.println(name + " dodged");
					chargeNumber -= 4;
					if (chargeNumber < 0)
					{
						chargeNumber = 0;
					}
				}
				else if (dodgeCost.isBrolyUltimate())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, name + " dodged"); 
				System.out.println(name + " dodged");
				chargeNumber -= 3;
				if (chargeNumber < 0)
				{
					chargeNumber = 0;
				}
			}
			else if (dodgeCost.isBrolySuper())
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, name + " dodged"); 
				System.out.println(name + " dodged");
				chargeNumber -= 2;
				if (chargeNumber < 0)
				{
					chargeNumber = 0;
				}
			}
			else
			{
				damageTaken = 0;
				JOptionPane.showMessageDialog(null, name + " dodged"); 
				System.out.println(name + " dodged");
				chargeNumber -= 1;
				if (chargeNumber < 0)
				{
					chargeNumber = 0;
				}
			}
		}
		}
		else if(defenseUpDuration > 0)
		{
			if (defending)
			{
				damageTaken /= DEFENSE_UP * potaraBuff;
				damageTaken /= DEFEND_REDUCTION * potaraBuff;
			}
			else
			{
				damageTaken /= DEFENSE_UP * potaraBuff;
			}
		}
		else if (defending)
		{
			damageTaken /= DEFEND_REDUCTION * potaraBuff;
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
			health -= damageTaken;
			JOptionPane.showMessageDialog(null, name + " took " + 
			damageTaken + " damage");
			System.out.println(name + " took " + 
			damageTaken + " damage");
		}
		if (health <= 0)
		{
			JOptionPane.showMessageDialog(null, name + " died");
			System.out.println(name + " died");
			ki = 0;
			chargeNumber = 0;
			momentum = 0;
			attackUpDuration = 0;
			defenseUpDuration = 0;
			hyperChargeDuration = 0;
			staticMomentumDuration = 0;
			fused = false;
			switch (fusionType)
			{
			case ATTACK_TANK:
			{
				AttackerClass.die();
				TankClass.die();
				break;
			}
			case ATTACK_MAGE:
			{
				AttackerClass.die();
				MageClass.die();
				break;
			}
			case ATTACK_CRAFTER:
			{
				AttackerClass.die();
				ItemCrafter.die();
				break;
			}
			case TANK_MAGE:
			{
				TankClass.die();
				MageClass.die();
				break;
			}
			case TANK_CRAFTER:
			{
				TankClass.die();
				ItemCrafter.die();
				break;
			}
			case MAGE_CRAFTER:
			{
				MageClass.die();
				ItemCrafter.die();
				break;
			}
			}
			fusionType = 0;
			fusionCooldown = 30;
			damageTaken = 0;
			damageDealt = 0;
			kiGained = 0;
			potaraFusion = false;
			potaraBuff = 1;
		}
		FusedPlayer.damageTaken += damageTaken;
		return damageTaken;
	}
	
	public void reduceMomentum(int reducedMomentum) {
		momentum -= reducedMomentum / 200;
		if (momentum < 0)
		{
			momentum = 0;
		}
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
	
	public static void reduceCountdown() {
		if (!potaraFusion)
		{
			fusionCountdown--;
			if (fusionCountdown <= 0)
			{
				endFusion();
			}
		}
	}

	/**
	 * @return the fusionCountdown
	 */
	public static int getFusionCountdown() {
		return fusionCountdown;
	}

	/**
	 * @return the fusionCooldown
	 */
	public static int getFusionCooldown() {
		return fusionCooldown;
	}
	
	public static void reduceCooldown() {
		fusionCooldown--;
	}
	
	public static void endFusion() {
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		switch (fusionType)
		{
		case ATTACK_TANK:
		{
			player1.endFusion();
			player2.endFusion();
			break;
		}
		case ATTACK_MAGE:
		{
			player1.endFusion();
			player3.endFusion();
			break;
		}
		case ATTACK_CRAFTER:
		{
			player1.endFusion();
			player4.endFusion();
			break;
		}
		case TANK_MAGE:
		{
			player2.endFusion();
			player3.endFusion();
			break;
		}
		case TANK_CRAFTER:
		{
			player2.endFusion();
			player4.endFusion();
			break;
		}
		case MAGE_CRAFTER:
		{
			player3.endFusion();
			player4.endFusion();
			break;
		}
		}
		fusionType = 0;
		fused = false;
		fusionCooldown = 30;
		damageTaken = 0;
		damageDealt = 0;
		kiGained = 0;
		JOptionPane.showMessageDialog(null, "The fusion has ended");
		System.out.println("The fusion has ended");
	}

	public static String getMomentumSkill() {
		return momentumSkill;
	}

	public static String getSkill1() {
		return skill1;
	}

	public static String getSkill2() {
		return skill2;
	}

	public static String getSkill1Description() {
		return skill1Description;
	}

	public static String getSkill2Description() {
		return skill2Description;
	}

	public static String getMomentumSkillDescription() {
		return momentumSkillDescription;
	}

	public static String getAttackTankSkill1() {
		return ATTACK_TANK_SKILL_1;
	}

	public static String getAttackTankSkill2() {
		return ATTACK_TANK_SKILL_2;
	}

	public static String getAttackMageSkill1() {
		return ATTACK_MAGE_SKILL_1;
	}

	public static String getAttackMageSkill2() {
		return ATTACK_MAGE_SKILL_2;
	}

	public static String getAttackCrafterSkill2() {
		return ATTACK_CRAFTER_SKILL_2;
	}

	public static String getTankMageSkill1() {
		return TANK_MAGE_SKILL_1;
	}

	public static String getTankMageSkill2() {
		return TANK_MAGE_SKILL_2;
	}

	public static String getTankCrafterSkill1() {
		return TANK_CRAFTER_SKILL_1;
	}

	public static String getTankCrafterSkill2() {
		return TANK_CRAFTER_SKILL_2;
	}

	public static String getMageCrafterSkill1() {
		return MAGE_CRAFTER_SKILL_1;
	}

	public static String getMageCrafterSkill2() {
		return MAGE_CRAFTER_SKILL_2;
	}

	public static void reduceKi() {
		chargeNumber--;
		ki -= 50;
		if (ki < 0)
		{
			if (chargeNumber == 0)
			{
				ki = 0;
			}
			else
			{
				chargeNumber--;
				ki += 100;
			}
		}
	}
	
	public int getEnergyStealDamage() {
		if (attackUpDuration > 0)
		{
			return (rng.nextInt(ENERGY_STEAL_MIN_ATTACK) + ENERGY_STEAL_MIN_ATTACK) * ATTACK_UP * potaraBuff; 
		}
		else
		{
			return rng.nextInt(ENERGY_STEAL_MIN_ATTACK) + ENERGY_STEAL_MIN_ATTACK * potaraBuff;
		}
	}
	
	public int addKiSkill(int addedKi) {
		if (health < 0)
		{
		}
		else if (hyperChargeDuration > 0)
		{
			ki += addedKi;
		}
		else
		{
			ki += addedKi / 10;
		}
		if (ki > 699)
		{
			chargeNumber = 7;
			ki = 0;
		}
		else if (ki > 599)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 600;
			}
		}
		else if (ki > 499)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 500;
			}
		}
		else if (ki > 399)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 400;
			}
		}
		else if (ki > 299)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 300;
			}
		}
		else if (ki > 199)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 200;
			}
		}
		else if (ki > 99)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 100;
			}
		}
		if (chargeNumber == MAX_CHARGE_NUMBER)
		{
			ki = 0;
		}
		return addedKi;
	}
	
	public int craftLargeHeal() {
		int increasedProgress;
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100) + 1;
		largeHealProgress += increasedProgress;
		if (largeHealProgress >= 100)
		{
			craft.increaseLargeHealItemAmount();
			largeHealProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM2());
			System.out.println(name + " crafted a " + craft.getITEM2());
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
		int increasedProgress;
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100) + 1;
		attackUpProgress += increasedProgress;
		if (attackUpProgress >= 100)
		{
			craft.increaseAttackUpAmount();
			attackUpProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM4());
			System.out.println(name + " crafted a " + craft.getITEM4());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM4() + 
					" is now at " + attackUpProgress + "% completion");
			System.out.println(craft.getITEM4() + 
					" is now at " + attackUpProgress + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftDefenseUp() {
		int increasedProgress;
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100) + 1;
		defenseUpProgress += increasedProgress;
		if (defenseUpProgress >= 100)
		{
			craft.increaseDefenseUpAmount();
			defenseUpProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM5());
			System.out.println(name + " crafted a " + craft.getITEM5());
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
		int increasedProgress;
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100) + 1;
		hyperChargeProgress += increasedProgress;
		if (hyperChargeProgress >= 100)
		{
			craft.increaseHyperChargeAmount();
			hyperChargeProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM6());
			System.out.println(name + " crafted a " + craft.getITEM6());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM6() + 
					" is now at " + hyperChargeProgress + "% completion");
			System.out.println(craft.getITEM6() + 
					" is now at " + hyperChargeProgress + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftStaticMomentum() {
		int increasedProgress;
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		increasedProgress = rng.nextInt(100) + 1;
		staticMomentumProgress += increasedProgress;
		if (staticMomentumProgress >= 100)
		{
			craft.increaseStaticMomentumAmount();
			staticMomentumProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM7());
			System.out.println(name + " crafted a " + craft.getITEM7());
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
	
	public void activateMomentumSkill() {
		momentumSkillActive = true;
	}
	
	public void deactivateMomentumSkill() {
		momentumSkillActive = false;
	}
	
	public int craftLargeHealCraftersStrength(int increasedProgress) {
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		largeHealProgress += increasedProgress;
		if (largeHealProgress >= 100)
		{
			craft.increaseLargeHealItemAmount();
			largeHealProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM2());
			System.out.println(name + " crafted a " + craft.getITEM2());
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
	
	public int craftAttackUpCraftersStrength(int increasedProgress) {
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		attackUpProgress += increasedProgress;
		if (attackUpProgress >= 100)
		{
			craft.increaseAttackUpAmount();
			attackUpProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM4());
			System.out.println(name + " crafted a " + craft.getITEM4());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM4() + 
					" is now at " + attackUpProgress + "% completion");
			System.out.println(craft.getITEM4() + 
					" is now at " + attackUpProgress + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftDefenseUpCraftersStrength(int increasedProgress) {
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		defenseUpProgress += increasedProgress;
		if (defenseUpProgress >= 100)
		{
			craft.increaseDefenseUpAmount();
			defenseUpProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM5());
			System.out.println(name + " crafted a " + craft.getITEM5());
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
	
	public int craftHyperChargeCraftersStrength(int increasedProgress) {
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		hyperChargeProgress += increasedProgress;
		if (hyperChargeProgress >= 100)
		{
			craft.increaseHyperChargeAmount();
			hyperChargeProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM6());
			System.out.println(name + " crafted a " + craft.getITEM6());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM6() + 
					" is now at " + hyperChargeProgress + "% completion");
			System.out.println(craft.getITEM6() + 
					" is now at " + hyperChargeProgress + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftStaticMomentumCraftersStrength(int increasedProgress) {
		Items craft = new Items();
		if (!momentumSkillActive)
		{
			chargeNumber--;
			ki -= 50;
			if (ki < 0)
			{
				if (chargeNumber == 0)
				{
					ki = 0;
				}
				else
				{
					chargeNumber--;
					ki += 100;
				}
			}
		}
		staticMomentumProgress += increasedProgress;
		if (staticMomentumProgress >= 100)
		{
			craft.increaseStaticMomentumAmount();
			staticMomentumProgress = 0;
			JOptionPane.showMessageDialog(null, name + " crafted a " + craft.getITEM7());
			System.out.println(name + " crafted a " + craft.getITEM7());
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
	
	public int getCraftersStrengthDamage() {
		if (attackUpDuration > 0)
		{
			return (rng.nextInt(CRAFTERS_STRENGTH_MIN_DAMAGE) + CRAFTERS_STRENGTH_MIN_DAMAGE) * ATTACK_UP * potaraBuff;
		}
		else
		{
			return rng.nextInt(CRAFTERS_STRENGTH_MIN_DAMAGE) + CRAFTERS_STRENGTH_MIN_DAMAGE * potaraBuff;
		}
	}

	/**
	 * @return the largeHealProgress
	 */
	public static int getLargeHealProgress() {
		return largeHealProgress;
	}

	/**
	 * @return the attackUpProgress
	 */
	public static int getAttackUpProgress() {
		return attackUpProgress;
	}

	/**
	 * @return the defenseUpProgress
	 */
	public static int getDefenseUpProgress() {
		return defenseUpProgress;
	}

	/**
	 * @return the hyperChargeProgress
	 */
	public static int getHyperChargeProgress() {
		return hyperChargeProgress;
	}

	/**
	 * @return the staticMomentumProgress
	 */
	public static int getStaticMomentumProgress() {
		return staticMomentumProgress;
	}

	/**
	 * @return the damageTaken
	 */
	public static int getDamageTaken() {
		return damageTaken;
	}
	
	public static void resetDamageTaken() {
		damageTaken = 0;
	}
	
	public static void addDamageDealt(int addedDamage) {
		damageDealt += addedDamage;
		Items.addPoints(addedDamage);
	}

	/**
	 * @return the damageDealt
	 */
	public static int getDamageDealt() {
		return damageDealt;
	}
	
	public static void resetDamageDealt() {
		damageDealt = 0;
	}

	/**
	 * @return the kiGained
	 */
	public static int getKiGained() {
		return kiGained;
	}
	
	public static void resetKiGained() {
		kiGained = 0;
	}
	
	public int useElixir() {
		chargeNumber--;
		ki -= 50;
		if (ki < 0)
		{
			if (chargeNumber == 0)
			{
				ki = 0;
			}
			else 
			{
				chargeNumber--;
				ki += 100;
			}
		}
		medKitHeal = rng.nextInt(MED_KIT_MIN_HEAL) + MED_KIT_MIN_HEAL;
		return medKitHeal;
	}
	
	public static void resetMomentum() {
		momentum = 0;
	}

	/**
	 * @return the hIGH_SPIRIT_GENKI_SHIELD_HEAL
	 */
	public int getHIGH_SPIRIT_GENKI_SHIELD_HEAL() {
		return HIGH_SPIRIT_GENKI_SHIELD_HEAL;
	}

	/**
	 * @return the hIGH_SPIRIT_GENKI_SHIELD_KI
	 */
	public int getHIGH_SPIRIT_GENKI_SHIELD_KI() {
		return HIGH_SPIRIT_GENKI_SHIELD_KI;
	}
	
	public int getCordinatedAttack() {
		if (attackUpDuration > 0)
		{
			return (rng.nextInt(CORDINATED_ATTACK_MIN_DAMAGE) + CORDINATED_ATTACK_MIN_DAMAGE) * ATTACK_UP * potaraBuff;
		}
		else
		{
			return rng.nextInt(CORDINATED_ATTACK_MIN_DAMAGE) + CORDINATED_ATTACK_MIN_DAMAGE * potaraBuff;
		}
	}
	
	public int getHighSpeedRushAttack() {
		if (attackUpDuration > 0)
		{
			return (rng.nextInt(HIGH_SPEED_RUSH_MIN_DAMAGE) + HIGH_SPEED_RUSH_MIN_DAMAGE) * ATTACK_UP * potaraBuff;
		}
		else
		{
			return rng.nextInt(HIGH_SPEED_RUSH_MIN_DAMAGE) + HIGH_SPEED_RUSH_MIN_DAMAGE * potaraBuff;
		}
	}

	/**
	 * @return the mASTERY_OF_OFFENSE_AND_DEFENSE_HEAL
	 */
	public int getMASTERY_OF_OFFENSE_AND_DEFENSE_HEAL() {
		return MASTERY_OF_OFFENSE_AND_DEFENSE_HEAL;
	}

	/**
	 * @return the attackCrafterSkill1
	 */
	public static String getAttackCrafterSkill1() {
		return ATTACK_CRAFTER_SKILL_1;
	}

	/**
	 * @return the attackTankMomentumSkill
	 */
	public static String getAttackTankMomentumSkill() {
		return ATTACK_TANK_MOMENTUM_SKILL;
	}

	/**
	 * @return the attackMageMomentumSkill
	 */
	public static String getAttackMageMomentumSkill() {
		return ATTACK_MAGE_MOMENTUM_SKILL;
	}

	/**
	 * @return the attackCrafterMomentumSkill
	 */
	public static String getAttackCrafterMomentumSkill() {
		return ATTACK_CRAFTER_MOMENTUM_SKILL;
	}

	/**
	 * @return the tankMageMomentumSkill
	 */
	public static String getTankMageMomentumSkill() {
		return TANK_MAGE_MOMENTUM_SKILL;
	}

	/**
	 * @return the tankCrafterMomentumSkill
	 */
	public static String getTankCrafterMomentumSkill() {
		return TANK_CRAFTER_MOMENTUM_SKILL;
	}

	/**
	 * @return the mageCrafterMomentumSkill
	 */
	public static String getMageCrafterMomentumSkill() {
		return MAGE_CRAFTER_MOMENTUM_SKILL;
	}
	
	public void addKiFromHighSpirit(int addedKi) {
		ki += addedKi / 100;
		if (ki > 699)
		{
			chargeNumber = 7;
			ki = 0;
		}
		else if (ki > 599)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 600;
			}
		}
		else if (ki > 499)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 500;
			}
		}
		else if (ki > 399)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 400;
			}
		}
		else if (ki > 299)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 300;
			}
		}
		else if (ki > 199)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 200;
			}
		}
		else if (ki > 99)
		{
			if (chargeNumber == MAX_CHARGE_NUMBER)
			{
				ki = 0;
			}
			else
			{
				chargeNumber++;
				ki -= 100;
			}
		}
		if (chargeNumber == MAX_CHARGE_NUMBER)
		{
			ki = 0;
		}
	}
	
	public void contagiousGrowthAttackUpDuration() {
		attackUpDuration = 4;
		JOptionPane.showMessageDialog(null, name + " powered up");
		System.out.println(name + " powered up");
	}
	
	public static void activateProtectionSkill() {
		protectionSkill = true;
	}
	
	public static void deactivateProtectionSkill() {
		protectionSkill = false;
	}

	/**
	 * @return the protectionSkill
	 */
	public static boolean isProtectionSkill() {
		return protectionSkill;
	}
	
	public void addMomentumFromMage(int addedMomentum) {
		MageClass player3 = new MageClass();
		momentum += addedMomentum / 20;
		if (momentum > 100)
		{
			momentum = 100;
		}
		JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " gave " 
				+ name + " " + addedMomentum / 20 + " momentum");
		System.out.println(MageClass.getUltimateTag() + player3 + " gave " 
				+ name + " " + addedMomentum / 20 + " momentum");
	}
	
	public static void reduceKiFullPowerCounter() {
		chargeNumber -= 2;
		ki -= 50;
		if (ki < 0)
		{
			if (chargeNumber == 0)
			{
				ki = 0;
			}
			else
			{
				chargeNumber--;
				ki += 100;
			}
		}
	}
	
	public static void reduceKiEnergySteal() {
		chargeNumber -= 2;
	}
	
	public static void reduceKiCrafterStrength() {
		ki -= 50;
		if (ki < 0)
		{
			if (chargeNumber == 0)
			{
				ki = 0;
			}
			else
			{
				chargeNumber--;
				ki += 100;
			}
		}
	}
	
	public static void reduceKiEnergyAssist() {
		chargeNumber -= 7;
	}
	public int useMedcine() {
		chargeNumber -= 7;
		medKitHeal = rng.nextInt(MED_KIT_MIN_HEAL) + MED_KIT_MIN_HEAL;
		return medKitHeal;
	}
	
	public static void setPotaraFusion() {
		potaraFusion = true;
	}
}
