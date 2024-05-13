package rpgRevamp;
import java.util.Random;

import javax.swing.JOptionPane;

public class Broly {
	public Broly(int selectedDifficulty) {
		challengeModeAttackUp = selectedDifficulty;
		challengeModeDefenseUp = selectedDifficulty;
		if (selectedDifficulty > 1)
		{
			difficultyTag = "God Of Destruction ";
		}
		else if (selectedDifficulty < 1)
		{
			difficultyTag = "Sealed Power ";
		}
		brolyHealth = 100000 * challengeModeAttackUp;
		maxChargeNumber = 3 * challengeModeAttackUp;
		BROLY_MAX_HEALTH = 100000 * challengeModeAttackUp;
		brolyHealth90Percent = 90000 * challengeModeAttackUp;
		brolyHealth80Percent = 80000 * challengeModeAttackUp;
		brolyHealth70Percent = 70000 * challengeModeAttackUp;
		brolyHealth60Percent = 60000 * challengeModeAttackUp;
		brolyHealth50Percent = 50000 * challengeModeAttackUp;
		brolyHealth40Percent = 40000 * challengeModeAttackUp;
		brolyHealth30Percent = 30000 * challengeModeAttackUp;
		brolyHealth20Percent = 20000 * challengeModeAttackUp;
		brolyHealth10Percent = 10000 * challengeModeAttackUp;
		PLANET_CRUSHER_MIN_DAMAGE = 3333 * challengeModeAttackUp;
		ENRAGED_SHOUT_MIN_DAMAGE = 2500 * challengeModeAttackUp;
		GIGANTIC_CHARGE_RAGE_MIN_DAMAGE = 1166 * challengeModeAttackUp;
		BLASTER_METEOR_MIN_DAMAGE = 4666 * challengeModeAttackUp;
		BLASTER_CANNON_MIN_DAMAGE = 3500 * challengeModeAttackUp;
		OMEGA_BLASTER_BARRIER_MAX_HEALTH_SUPER_SAIYAN = 3000 * challengeModeAttackUp;
		GIGANTIC_CHARGE_SUPER_SAIYAN_MIN_DAMAGE = 1633 * challengeModeAttackUp;
		BLASTER_METEOR_MAX_BARRIER_HEALTH = 5000 * challengeModeAttackUp;
		BLASTER_METEOR_BARRIER_MIN = 533 * challengeModeAttackUp; 
		GIGANTIC_ROAR_MIN_DAMAGE = 6000 * challengeModeAttackUp;
		BLASTER_CANNON_FULL_POWER_MIN_DAMAGE = 4500 * challengeModeAttackUp;
		OMEGA_BLASTER_BARRIER_MAX_FULL_POWER = 5000 * challengeModeAttackUp;
		OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE = 566 * challengeModeAttackUp;
		GIGANTIC_CHARGE_FULL_POWER_MIN_DAMAGE = 2100 * challengeModeAttackUp;
	}

	
	private static int challengeModeAttackUp = 1;
	private static int challengeModeDefenseUp = 1;
	private static String difficultyTag = "";
	private final String PHASE_1_BOSS_NAME = "Broly (Rage)";//The is the name of phrase 1
	private static int brolyHealth;
	private static int bossKi = 0;
	private static int bossMomentum = 0;
	private static int bossChargeNumber = 0;
	private static int brolyHealth90Percent;
	private static int brolyHealth80Percent;
	private static int brolyHealth70Percent;
	private static int brolyHealth60Percent;
	private static int brolyHealth50Percent;
	private static int brolyHealth40Percent;
	private static int brolyHealth30Percent;
	private static int brolyHealth20Percent;
	private static int brolyHealth10Percent;
	private static int damageTook = 0;
	private static String bossName = "Broly (Rage)";
	private Random rng = new Random();
	private int brolyAttack;
	private static int PLANET_CRUSHER_MIN_DAMAGE;
	private static boolean brolySuper = false;
	private static boolean brolyUltimate = false;
	private final String RAGE_ULTIMATE = "Planet Crusher";
	private final String RAGE_SUPER = "Enraged Shout";
	private final int ENRAGED_SHOUT_KI_COST = 50;
	private static int ENRAGED_SHOUT_MIN_DAMAGE;
	private int target = 0;
	private final String RAGE_SKILL = "Gigantic Power";
	private final String RAGE_ATTACK = "Gigantic Charge (Rage)";
	private static int GIGANTIC_CHARGE_RAGE_MIN_DAMAGE;
	private final String PHASE_2_BOSS_NAME = "Broly (Super Saiyan)";
	private static int BROLY_MAX_HEALTH;
	private static int maxChargeNumber;
	private final String SUPER_SAIYAN_ULTIMATE = "Blaster Meteor";
	private final String SUPER_SAIYAN_SUPER = "Blaster Cannon";
	private final String SUPER_SAIYAN_SKILL = "Omega Blaster";
	private final String SUPER_SAIYAN_ATTACK = "Gigantic Charge (Super Saiyan)";
	private static int BLASTER_METEOR_MIN_DAMAGE;
	private static int BLASTER_CANNON_MIN_DAMAGE;
	private static int OMEGA_BLASTER_BARRIER_MAX_HEALTH_SUPER_SAIYAN;
	private static int omegaBlasterHealth = 0;
	private static int GIGANTIC_CHARGE_SUPER_SAIYAN_MIN_DAMAGE;
	private static int BLASTER_METEOR_MAX_BARRIER_HEALTH;
	private static int blasterMeteorBarrierHealth = 0;
	private final int BLASTER_CANNON_KI_COST = 35;
	private static int BLASTER_METEOR_BARRIER_MIN; 
	private final int OMEGA_BLASTER_KI_COST = 75;
	private final String PHASE_3_BOSS_NAME = "Broly (Full Power Super Saiyan)";
	private final String FULL_POWER_ULTIMATE = "Gigantic Roar";
	private static int GIGANTIC_ROAR_MIN_DAMAGE;
	private final String FULL_POWER_SUPER = "Blaster Cannon (Full Power Super Saiyan)";
	private int BLASTER_CANNON_FULL_POWER_MIN_DAMAGE;
	private static int OMEGA_BLASTER_BARRIER_MAX_FULL_POWER;
	private static int OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE;
	private final String FULL_POWER_SKILL = "Omega Blaster (Full Power Super Saiyan)";
	private final String FULL_POWER_ATTACK = "Gigantic Charge (Full Power Super Saiyan)";
	private static int GIGANTIC_CHARGE_FULL_POWER_MIN_DAMAGE;
	private static boolean brolySuperUltimate = false;
	private static boolean brolyFullPowerUltimate = false;
	
	public Broly() {
		
	}
	
	/**
	 * This method sets the name of phase 1 boss
	 * @return The name is returned
	 */
	public String toString() {
		return difficultyTag + bossName;
	}
	
	/**
	 * sets the boss health
	 * @param health the boss health
	 */
	public void setBossHealth(int health) {
		brolyHealth = health;
	}
	
	/**
	 * @return broly health
	 */
	public int getBrolyHealth() {
		return brolyHealth;
	}
	
	 /**
	 * @return broly ki
	 */
	public int getBrolyKi() {
		 return bossKi;
	 }
	
	/**
	 * @return broly momentum
	 */
	public int getBrolyMomentum() {
		return bossMomentum;
	}
	
	/**
	 * @return charge number
	 */
	public int getBrolyChargeNumber() {
		return bossChargeNumber;
	}
	
	public int reduceBrolyHealth(int playerAttack) {
		if (blasterMeteorBarrierHealth > 0)
		{
			blasterMeteorBarrierHealth -= playerAttack / 5 / challengeModeDefenseUp;
			if (blasterMeteorBarrierHealth <= 0)
			{
				JOptionPane.showMessageDialog(null, "Broly's barrier was destroyed");
				System.out.println("Broly's barrier was destroyed");
			}
			else
			{
				JOptionPane.showMessageDialog(null, SUPER_SAIYAN_ULTIMATE + "'s Barrier has been reduced to "
					+ blasterMeteorBarrierHealth);
				System.out.println(SUPER_SAIYAN_ULTIMATE + "'s Barrier has been reduced to "
						+ blasterMeteorBarrierHealth);
			}
		}
		else if (omegaBlasterHealth > 0)
		{
			omegaBlasterHealth -= playerAttack / 5 / challengeModeDefenseUp;
			if (omegaBlasterHealth <= 0)
			{
				JOptionPane.showMessageDialog(null, "Broly's barrier was destroyed");
				System.out.println("Broly's barrier was destroyed");
			}
			else
			{
				JOptionPane.showMessageDialog(null, SUPER_SAIYAN_SKILL + "'s Barrier has been reduced to "
					+ omegaBlasterHealth);
				System.out.println(SUPER_SAIYAN_SKILL + "'s Barrier has been reduced to "
						+ omegaBlasterHealth);
			}
		}
		else if (brolyHealth > brolyHealth90Percent)
		{
			brolyHealth -= playerAttack / challengeModeDefenseUp;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		else if (brolyHealth > brolyHealth80Percent)
		{
			playerAttack /= 2 / challengeModeDefenseUp;
			brolyHealth -= playerAttack;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		else if (brolyHealth > brolyHealth70Percent)
		{
			playerAttack /= 3 / challengeModeDefenseUp;
			brolyHealth -= playerAttack;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		else if (brolyHealth > brolyHealth60Percent)
		{
			playerAttack /= 4 / challengeModeDefenseUp;
			brolyHealth -= playerAttack;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		else if (brolyHealth > brolyHealth50Percent)
		{
			playerAttack /= 5 / challengeModeDefenseUp;
			brolyHealth -= playerAttack;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		else if (brolyHealth > brolyHealth40Percent)
		{
			playerAttack /= 6 / challengeModeDefenseUp;
			brolyHealth -= playerAttack;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		else if (brolyHealth > brolyHealth30Percent)
		{
			playerAttack /= 7 / challengeModeDefenseUp;
			brolyHealth -= playerAttack;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		else if (brolyHealth > brolyHealth20Percent)
		{
			playerAttack /= 8 / challengeModeDefenseUp;
			brolyHealth -= playerAttack;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		else if (brolyHealth > brolyHealth10Percent)
		{
			playerAttack /= 9 / challengeModeDefenseUp;
			brolyHealth -= playerAttack;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		else
		{
			playerAttack /= 10 / challengeModeDefenseUp;
			brolyHealth -= playerAttack;
			JOptionPane.showMessageDialog(null, "Broly took " + playerAttack + " damage");
			System.out.println("Broly took " + playerAttack + " damage");
			damageTook = playerAttack;
			bossMomentum -= playerAttack / 1000;
		}
		if (bossMomentum < 0)
		{
			bossMomentum = 0;
		}
		Items.addPoints(playerAttack);
		return playerAttack;
	}

	public int getDamageTook() {
		return damageTook;
	}
	
	public void setBrolyName() {
		if (brolyHealth > brolyHealth70Percent) 
		{
			bossName = PHASE_1_BOSS_NAME;
		}
		else if (brolyHealth > brolyHealth40Percent)
		{
			bossName = PHASE_2_BOSS_NAME;
			maxChargeNumber = 5 * challengeModeAttackUp;
		}
		else
		{
			bossName = PHASE_3_BOSS_NAME;
			maxChargeNumber = 7 * challengeModeAttackUp;
		}
	}
	
	public int getBrolyAction() {
		return rng.nextInt(6) + 1;
	}
	
	public int getBrolyActionFailure1() {
		return rng.nextInt(3) + 1;
	}
	
	public int getBrolyActionFailure2() {
		return rng.nextInt(2) + 1;
	}
	
	public int getBrolyActionFailure3() {
		return 1;
	}
	
	public int getPlanetCrusherDamage() {
		bossMomentum = 0;
		brolyAttack = rng.nextInt(1667) + PLANET_CRUSHER_MIN_DAMAGE;
		return brolyAttack;
	}
	
	public void activateSuper() {
		brolySuper = true;
	}
	
	public void deactivateSuper() {
		brolySuper = false;
	}
	
	public void activateUltimate() {
		brolyUltimate = true;
	}
	
	public void deactivateUltimate() {
		brolyUltimate = false;
	}

	public boolean isBrolySuper() {
		return brolySuper;
	}

	public boolean isBrolyUltimate() {
		return brolyUltimate;
	}

	public String getRAGE_ULTIMATE() {
		return RAGE_ULTIMATE;
	}
	
	public void addMomentum(int addedMomentum) {
		bossMomentum += addedMomentum / 200;
		if (bossMomentum > 100)
		{
			bossMomentum = 100;
		}
	}
	
	public void addKi(int addedKi) {
			if (blasterMeteorBarrierHealth <= 0 || omegaBlasterHealth <= 0)
			{
				bossKi += addedKi / 100;
			}
			if (bossKi > 699)
			{
				bossChargeNumber = maxChargeNumber;
				bossKi = 0;
			}
			else if (bossKi > 599)
			{
				if (bossChargeNumber == maxChargeNumber)
				{
					bossKi = 0;
				}
				else
				{
					bossChargeNumber++;
					bossKi -= 600;
				}
			}
			else if (bossKi > 499)
			{
				if (bossChargeNumber == maxChargeNumber)
				{
					bossKi = 0;
				}
				else
				{
					bossChargeNumber++;
					bossKi -= 500;
				}
			}
			else if (bossKi > 399)
			{
				if (bossChargeNumber == maxChargeNumber)
				{
					bossKi = 0;
				}
				else
				{
					bossChargeNumber++;
					bossKi -= 400;
				}
			}
			else if (bossKi > 299)
			{
				if (bossChargeNumber == maxChargeNumber)
				{
					bossKi = 0;
				}
				else
				{
					bossChargeNumber++;
					bossKi -= 300;
				}
			}
			else if (bossKi > 199)
			{
				if (bossChargeNumber == maxChargeNumber)
				{
					bossKi = 0;
				}
				else
				{
					bossChargeNumber++;
					bossKi -= 200;
				}
			}
			else if (bossKi > 99)
			{
				if (bossChargeNumber == maxChargeNumber)
				{
					bossKi = 0;
				}
				else
				{
					bossChargeNumber++;
					bossKi -= 100;
				}
			}
			if (bossChargeNumber == maxChargeNumber)
			{
				bossKi = 0;
			}
	}

	public String getRAGE_SUPER() {
		return RAGE_SUPER;
	}

	public int getENRAGED_SHOUT_KI_COST() {
		return ENRAGED_SHOUT_KI_COST;
	}
	
	public int getEnragedShoutDamage() {
		bossChargeNumber--;
		brolyAttack = rng.nextInt(1250) + ENRAGED_SHOUT_MIN_DAMAGE;
		return brolyAttack;
	}
	
	public int getTarget() {
		if (FusedPlayer.isFused())
		{
			target = rng.nextInt(5) + 1;
		}
		else
		{
			target = rng.nextInt(4) + 1;
		}
		return target;
	}

	public String getRAGE_SKILL() {
		return RAGE_SKILL;
	}
	
	public void useGiganticPower() {
		if (bossChargeNumber == maxChargeNumber)
		{
			if (bossMomentum == 100)
			{
			}
			else
			{
				bossMomentum += rng.nextInt(50) + 1;
				if (bossMomentum > 100)
				{
					bossMomentum = 100;
				}
			}
		}
		else
		{
			bossChargeNumber++;
			if (bossChargeNumber == maxChargeNumber)
			{
				bossKi = 0;
			}
		}
	}

	public String getRAGE_ATTACK() {
		return RAGE_ATTACK;
	}
	
	public int getGiganticChargeRage() {
		brolyAttack = rng.nextInt(584) + GIGANTIC_CHARGE_RAGE_MIN_DAMAGE;
		return brolyAttack;
	}

	public int getBROLY_MAX_HEALTH() {
		return BROLY_MAX_HEALTH;
	}

	public String getPHASE_1_BOSS_NAME() {
		return difficultyTag + PHASE_1_BOSS_NAME;
	}

	public String getPHASE_2_BOSS_NAME() {
		return difficultyTag + PHASE_2_BOSS_NAME;
	}
	
	public void setBrolySuperSaiyanMaxChargeNumber() {
		maxChargeNumber = 5;
	}

	/**
	 * @return the sUPER_SAIYAN_ULTIMATE
	 */
	public String getSUPER_SAIYAN_ULTIMATE() {
		return SUPER_SAIYAN_ULTIMATE;
	}
	
	public int getBlasterMeteorDamage() {
		bossMomentum = 0;
		return rng.nextInt(2334) + BLASTER_METEOR_MIN_DAMAGE;
	}

	/**
	 * @return the bLASTER_CANNON_KI_COST
	 */
	public int getBLASTER_CANNON_KI_COST() {
		return BLASTER_CANNON_KI_COST;
	}

	/**
	 * @return the sUPER_SAIYAN_SUPER
	 */
	public String getSUPER_SAIYAN_SUPER() {
		return SUPER_SAIYAN_SUPER;
	}
	
	public void activateBlasterMeteorBarrier() {
		blasterMeteorBarrierHealth = BLASTER_METEOR_MAX_BARRIER_HEALTH;
	}
	
	public int getBlasterCannonDamage() {
		bossChargeNumber -= 2;
		return rng.nextInt(1750) + BLASTER_CANNON_MIN_DAMAGE;
	}

	/**
	 * @return the sUPER_SAIYAN_SKILL
	 */
	public String getSUPER_SAIYAN_SKILL() {
		return SUPER_SAIYAN_SKILL;
	}
	
	public void activateOmegaBlaster() {
		bossChargeNumber -= 3;
		omegaBlasterHealth = OMEGA_BLASTER_BARRIER_MAX_HEALTH_SUPER_SAIYAN;
	}

	/**
	 * @return the sUPER_SAIYAN_ATTACK
	 */
	public String getSUPER_SAIYAN_ATTACK() {
		return SUPER_SAIYAN_ATTACK;
	}
	
	public int getGiganticChargeSuperSaiyanDamage() {
		return rng.nextInt(817) + GIGANTIC_CHARGE_SUPER_SAIYAN_MIN_DAMAGE;
	}

	/**
	 * @return the omegaBlasterHealth
	 */
	public static int getOmegaBlasterHealth() {
		return omegaBlasterHealth;
	}

	/**
	 * @return the blasterMeteorBarrierHealth
	 */
	public static int getBlasterMeteorBarrierHealth() {
		return blasterMeteorBarrierHealth;
	}
	
	public void reduceBlasterMeteorBarrierHealth() {
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		UltimateAttackerClass ultimatePlayer1 = new UltimateAttackerClass();
		UltimateTankClass ultimatePlayer2 = new UltimateTankClass();
		UltimateMageClass ultimatePlayer3 = new UltimateMageClass();
		UltimateItemCrafter ultimatePlayer4 = new UltimateItemCrafter();
		int damageDealt = 0; 
		boolean validChoice = false;
		int brolyAttack = 0;
		String humanShieldTarget = "null";
		boolean humanShieldUnusable = false;
		brolyAttack = rng.nextInt(267) + BLASTER_METEOR_BARRIER_MIN;
		blasterMeteorBarrierHealth -= 1000;
		player1.removeHumanShieldTarget();
		player3.removeHumanShieldTarget();
		player4.removeHumanShieldTarget();
		if (player1.getPlayer1Health() < 1)
		{
			if (player3.getPlayer3Health() < 1)
			{
				if (player4.getPlayer4Health() < 1)
				{
					humanShieldUnusable = true;
				}
			}
		}
		while (!(validChoice) && ((player2.isHumanShieldSkill())) && (!(humanShieldUnusable))) {
			humanShieldTarget = JOptionPane.showInputDialog("Who do you want to protect?\n" 
					+ player1 + "\n" + player3 + "\n" + player4);
			if (humanShieldTarget == null)
			{
				humanShieldTarget = "null";
			}
			if (humanShieldTarget.equalsIgnoreCase(player1.toString()))
			{
				if (player1.getPlayer1Health() <= 0)
				{
					validChoice = false;
					JOptionPane.showMessageDialog(null, "This player is dead");
				}
				else
				{
					player1.setHumanShieldTarget();
					validChoice = true;
				}
			}
			else if (humanShieldTarget.equalsIgnoreCase(player3.toString()))
				if (player3.getPlayer3Health() <= 0)
				{
					validChoice = false;
					JOptionPane.showMessageDialog(null, "This player is dead");
				}
				else
				{
					validChoice = true;
					player3.setHumanShieldTarget();
				}
			else if (humanShieldTarget.equalsIgnoreCase(player4.toString()))
				if (player4.getPlayer4Health() <= 0)
				{
					validChoice = false;
					JOptionPane.showMessageDialog(null, "This player is dead");
				}
				else
				{
					validChoice = true;
					player4.setHumanShieldTarget();
				}
			else
			{
				JOptionPane.showMessageDialog(null, "Error");
				validChoice = false;
			}
		}
		if (player1.getPlayer1Health() <= 0)
		{
		}
		else if (player1.isUltimate())
		{
			damageDealt = ultimatePlayer1.takeDamage(brolyAttack);
			addKi(damageDealt);
			ultimatePlayer1.addKi(damageDealt);
			ultimatePlayer1.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(267) + BLASTER_METEOR_BARRIER_MIN;
		}
		else
		{
			damageDealt = player1.takeDamage(brolyAttack);
			addKi(damageDealt);
			player1.addKi(damageDealt);
			player1.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(267) + BLASTER_METEOR_BARRIER_MIN;
		}
		if (player2.getPlayer2Health() <= 0)
		{
		}
		else if (player2.isUltimate())
		{
			damageDealt = ultimatePlayer2.takeDamage(brolyAttack);
			addKi(damageDealt);
			ultimatePlayer2.addKi(damageDealt);
			brolyAttack = rng.nextInt(267) + BLASTER_METEOR_BARRIER_MIN;
		}
		else
		{
			damageDealt = player2.takeDamage(brolyAttack);
			addKi(damageDealt);
			player2.addKi(damageDealt);
			brolyAttack = rng.nextInt(267) + BLASTER_METEOR_BARRIER_MIN;
		}
		if (player3.getPlayer3Health() <= 0)
		{
		}
		else if (player3.isUltimate())
		{
			damageDealt = ultimatePlayer3.takeDamage(brolyAttack);
			addKi(damageDealt);
			ultimatePlayer3.addKi(damageDealt);
			ultimatePlayer3.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(267) + BLASTER_METEOR_BARRIER_MIN;
		}
		else
		{
			damageDealt = player3.takeDamage(brolyAttack);
			addKi(damageDealt);
			player3.addKi(damageDealt);
			player3.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(267) + BLASTER_METEOR_BARRIER_MIN;
		}
		if (player4.getPlayer4Health() <= 0)
		{
		}
		else if (player4.isUltimate())
		{
			damageDealt = ultimatePlayer4.takeDamage(brolyAttack);
			addKi(damageDealt);
			ultimatePlayer4.addKi(damageDealt);
			ultimatePlayer4.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(267) + BLASTER_METEOR_BARRIER_MIN;
		}
		else
		{
			damageDealt = player4.takeDamage(brolyAttack);
			addKi(damageDealt);
			player4.addKi(damageDealt);
			player4.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(267) + BLASTER_METEOR_BARRIER_MIN;
		}
		if (player2.isHumanShieldSkill())
		{
			player1.setHumanShieldTarget();
			player3.setHumanShieldTarget();
			player4.setHumanShieldTarget();
		}
	}
	
	public void reduceOmegaBlasterHealth() {
		omegaBlasterHealth -= 1000;
	}

	/**
	 * @return the oMEGA_BLASTER_KI_COST
	 */
	public int getOMEGA_BLASTER_KI_COST() {
		return OMEGA_BLASTER_KI_COST;
	}

	/**
	 * @return the pHASE_3_BOSS_NAME
	 */
	public String getPHASE_3_BOSS_NAME() {
		return PHASE_3_BOSS_NAME;
	}
	
	public static void reduceKi(int reducedKi) {
		bossKi -= reducedKi;
		if (bossKi < 0)
		{
			if (bossChargeNumber == 0)
			{
				bossKi = 0;
			}
			else
			{
				bossChargeNumber--;
				bossKi += 100;
			}
		}
	}

	/**
	 * @return the fULL_POWER_ULTIMATE
	 */
	public String getFULL_POWER_ULTIMATE() {
		return FULL_POWER_ULTIMATE;
	}
	
	public int getGiganticRoarDamage() {
		bossMomentum = 0;
		return rng.nextInt(3000) + GIGANTIC_ROAR_MIN_DAMAGE;
	}

	/**
	 * @return the fULL_POWER_SUPER
	 */
	public String getFULL_POWER_SUPER() {
		return FULL_POWER_SUPER;
	}
	
	public int getBlasterCannonFullPowerDamage() {
		bossChargeNumber -= 3;
		return rng.nextInt(2250) + BLASTER_CANNON_FULL_POWER_MIN_DAMAGE;
	}
	
	public void activateOmegaBlasterFullPower() {
		bossChargeNumber -= 5;
		omegaBlasterHealth = OMEGA_BLASTER_BARRIER_MAX_FULL_POWER;
	}
	
	public void reduceOmegaBlasterBarrierHealthFullPower() {
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		FusedPlayer fusion = new FusedPlayer();
		UltimateAttackerClass ultimatePlayer1 = new UltimateAttackerClass();
		UltimateTankClass ultimatePlayer2 = new UltimateTankClass();
		UltimateMageClass ultimatePlayer3 = new UltimateMageClass();
		UltimateItemCrafter ultimatePlayer4 = new UltimateItemCrafter();
		int damageDealt = 0; 
		boolean validChoice = false;
		int brolyAttack = 0;
		String humanShieldTarget = "null";
		boolean humanShieldUnusable = false;
		brolyAttack = rng.nextInt(284) + OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE;
		omegaBlasterHealth -= 1000;
		player1.removeHumanShieldTarget();
		player3.removeHumanShieldTarget();
		player4.removeHumanShieldTarget();
		String playerOutsideOfFusion = "null";
		if (FusedPlayer.isFused())
		{
			if (FusedPlayer.getFusionType() == fusion.getAttackMage())
			{
				playerOutsideOfFusion = player4.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getAttackCrafter())
			{
				playerOutsideOfFusion = player3.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getMageCrafter())
			{
				playerOutsideOfFusion = player1.toString();
			}
		}
		String playerOutsideOfFusion1 = "null",
				playerOutsideOfFusion2 = "null";
		if (FusedPlayer.getFusionType() == fusion.getAttackTank())
		{
			playerOutsideOfFusion1 = player3.toString();
			playerOutsideOfFusion2 = player4.toString();
		}
		else if (FusedPlayer.getFusionType() == fusion.getAttackMage())
		{
			playerOutsideOfFusion1 = player2.toString();
			playerOutsideOfFusion2 = player4.toString();
		}
		else if (FusedPlayer.getFusionType() == fusion.getAttackCrafter())
		{
			playerOutsideOfFusion1 = player2.toString();
			playerOutsideOfFusion2 = player3.toString();
		}
		else if (FusedPlayer.getFusionType() == fusion.getTankMage())
		{
			playerOutsideOfFusion1 = player1.toString();
			playerOutsideOfFusion2 = player4.toString();
		}
		else if (FusedPlayer.getFusionType() == fusion.getTankCrafter())
		{
			playerOutsideOfFusion1 = player1.toString();
			playerOutsideOfFusion2 = player3.toString();
		}
		else if (FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
			playerOutsideOfFusion1 = player1.toString();
			playerOutsideOfFusion2 = player2.toString();
		}
		if (player1.getPlayer1Health() < 1)
		{
			if (player3.getPlayer3Health() < 1)
			{
				if (player4.getPlayer4Health() < 1)
				{
					humanShieldUnusable = true;
				}
			}
		}
		if (player2.isHumanShieldSkill())
		{
			if (FusedPlayer.isFused())
			{
				while (!(validChoice) && (!(humanShieldUnusable))) {
					humanShieldTarget = JOptionPane.showInputDialog("Who do you want to protect?\n" 
							+ fusion + "\n" + playerOutsideOfFusion);
					if (humanShieldTarget == null)
					{
						humanShieldTarget = "null";
					}
					if (humanShieldTarget.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
						{
							if (player1.getPlayer1Health() <= 0)
							{
								validChoice = false;
								JOptionPane.showMessageDialog(null, "This player is dead");
							}
							else
							{
								player1.setHumanShieldTarget();
								validChoice = true;
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player3.toString()))
						{
							if (player3.getPlayer3Health() <= 0)
							{
								validChoice = false;
								JOptionPane.showMessageDialog(null, "This player is dead");
							}
							else
							{
								player3.setHumanShieldTarget();
								validChoice = true;
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player4.toString()))
						{
							if (player4.getPlayer4Health() <= 0)
							{
								validChoice = false;
								JOptionPane.showMessageDialog(null, "This player is dead");
							}
							else
							{
								player4.setHumanShieldTarget();
								validChoice = true;
							}
						}
					}
					else if (humanShieldTarget.equalsIgnoreCase(fusion.toString()))
					{
						player1.setHumanShieldTarget();
						validChoice = true;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						validChoice = false;
					}
				}
			}
			else
			{
				while (!(validChoice) && humanShieldUnusable) {
					humanShieldTarget = JOptionPane.showInputDialog("Who do you want to protect?\n" 
							+ player1 + "\n" + player3 + "\n" + player4);
					if (humanShieldTarget == null)
					{
						humanShieldTarget = "null";
					}
					if (humanShieldTarget.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							player1.setHumanShieldTarget();
							validChoice = true;
						}
					}
					else if (humanShieldTarget.equalsIgnoreCase(player3.toString()))
						if (player3.getPlayer3Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							validChoice = true;
							player3.setHumanShieldTarget();
						}
					else if (humanShieldTarget.equalsIgnoreCase(player4.toString()))
						if (player4.getPlayer4Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							validChoice = true;
							player4.setHumanShieldTarget();
						}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						validChoice = false;
					}
				}
			}
		}
		else if (FusedPlayer.isProtectionSkill())
		{
			while (!(validChoice) && (!(humanShieldUnusable))) {
				humanShieldTarget = JOptionPane.showInputDialog("Who do you want to protect?\n" 
						+ playerOutsideOfFusion1 + "\n" + playerOutsideOfFusion2);
				if (humanShieldTarget == null)
				{
					humanShieldTarget = "null";
				}
				if (humanShieldTarget.equalsIgnoreCase(playerOutsideOfFusion1))
				{
					if (playerOutsideOfFusion1.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							player1.setHumanShieldTarget();
							validChoice = true;
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							player3.setHumanShieldTarget();
							validChoice = true;
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							player4.setHumanShieldTarget();
							validChoice = true;
						}
					}
				}
				else if (humanShieldTarget.equalsIgnoreCase(playerOutsideOfFusion2))
				{
					if (playerOutsideOfFusion2.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							player1.setHumanShieldTarget();
							validChoice = true;
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							player3.setHumanShieldTarget();
							validChoice = true;
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							player4.setHumanShieldTarget();
							validChoice = true;
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					validChoice = false;
				}
			}
		}
		if (player1.getPlayer1Health() <= 0)
		{
		}
		else if (player1.isUltimate())
		{
			damageDealt = ultimatePlayer1.takeDamage(brolyAttack);
			addKi(damageDealt);
			ultimatePlayer1.addKi(damageDealt);
			ultimatePlayer1.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(284) + OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE;
		}
		else
		{
			damageDealt = player1.takeDamage(brolyAttack);
			addKi(damageDealt);
			player1.addKi(damageDealt);
			player1.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(284) + OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE;
		}
		if (player2.getPlayer2Health() <= 0)
		{
		}
		else if (player2.isUltimate())
		{
			damageDealt = ultimatePlayer2.takeDamage(brolyAttack);
			addKi(damageDealt);
			ultimatePlayer2.addKi(damageDealt);
			brolyAttack = rng.nextInt(284) + OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE;
		}
		else
		{
			damageDealt = player2.takeDamage(brolyAttack);
			addKi(damageDealt);
			player2.addKi(damageDealt);
			brolyAttack = rng.nextInt(284) + OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE;
		}
		if (player3.getPlayer3Health() <= 0)
		{
		}
		else if (player3.isUltimate())
		{
			damageDealt = ultimatePlayer3.takeDamage(brolyAttack);
			addKi(damageDealt);
			ultimatePlayer3.addKi(damageDealt);
			ultimatePlayer3.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(284) + OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE;
		}
		else
		{
			damageDealt = player3.takeDamage(brolyAttack);
			addKi(damageDealt);
			player3.addKi(damageDealt);
			player3.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(284) + OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE;
		}
		if (player4.getPlayer4Health() <= 0)
		{
		}
		else if (player4.isUltimate())
		{
			damageDealt = ultimatePlayer4.takeDamage(brolyAttack);
			addKi(damageDealt);
			ultimatePlayer4.addKi(damageDealt);
			ultimatePlayer4.reduceMomentum(damageDealt);
			brolyAttack = rng.nextInt(284) + OMEGA_BLASTER_FULL_POWER_MIN_DAMAGE;
		}
		else
		{
			damageDealt = player4.takeDamage(brolyAttack);
			addKi(damageDealt);
			player4.addKi(damageDealt);
			player4.reduceMomentum(damageDealt);
		}
		if (FusedPlayer.isFused())
		{
			if (FusedPlayer.getHealth() >= 0)
			{
				damageDealt = fusion.takeDamage(brolyAttack);
				addKi(damageDealt);
				fusion.addKi(damageDealt);
				fusion.reduceMomentum(damageDealt);
			}
		}
	}

	/**
	 * @return the fULL_POWER_SKILL
	 */
	public String getFULL_POWER_SKILL() {
		return FULL_POWER_SKILL;
	}

	/**
	 * @return the fULL_POWER_ATTACK
	 */
	public String getFULL_POWER_ATTACK() {
		return FULL_POWER_ATTACK;
	}
	
	public int getGiganticChargeFullPowerDamage() {
		return rng.nextInt(1050) + GIGANTIC_CHARGE_FULL_POWER_MIN_DAMAGE;
	}
	
	public void difficultySelect(int selectedDifficulty) {
		challengeModeAttackUp = selectedDifficulty;
		challengeModeDefenseUp = selectedDifficulty;
		if (selectedDifficulty > 1)
		{
			difficultyTag = "God Of Destruction ";
		}
		else if (selectedDifficulty < 1)
		{
			difficultyTag = "Sealed Power ";
		}
	}

	public static String getDifficultyTag() {
		return difficultyTag;
	}

	/**
	 * @return the brolySuperUltimate
	 */
	public static boolean isBrolySuperUltimate() {
		return brolySuperUltimate;
	}

	/**
	 * @return the brolyFullPowerUltimate
	 */
	public static boolean isBrolyFullPowerUltimate() {
		return brolyFullPowerUltimate;
	}
	
	public static void activateBrolySuperUltimate() {
		brolySuperUltimate = true;
	}
	
	public static void deactivateBrolySuperUltimate() {
		brolySuperUltimate = false;
	}
	
	public static void activateBrolyFullPowerUltimate() {
		brolyFullPowerUltimate = true;
	}
	
	public static void deactivateBrolyFullPowerUltimate() {
		brolyFullPowerUltimate = false;
	}
	
	public static void resetMomentum() {
		bossMomentum = 0;
	}
}