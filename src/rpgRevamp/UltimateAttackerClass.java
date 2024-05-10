package rpgRevamp;

import java.util.Random;

import javax.swing.JOptionPane;

public class UltimateAttackerClass extends AttackerClass{
	private final String SKILL1 = "Limit Breaking Strike";
	private final String SKILL2 = "Max Spirit";
	private final int PLAYERMINATTACK = 5000;
	private final int LIMIT_BREAKING_STRIKE_MIN_DAMAGE = 7500;
	private final int MAX_HEALTH = 10000;
	private final String MOMENTUM_SKILL = "Max Spirit Strike";
	private final int MAX_SPIRIT_STRIKE_KI_GAIN = 200;
	private final int MAX_SPIRIT_STRIKE_MIN_DAMAGE = 10000;
	private final int MAX_CHARGE_NUMBER = 5;
	private int playerDamage;
	private Random rng = new Random();
	private final int SKILLCOST = 100;
	
	@Override
	public String getSkill1() {
		return SKILL1;
	}
	
	@Override
	public String getSkill2() {
		return SKILL2;
	}
	
	@Override
	public int getPlayerAttack() {
		if (super.getAttackUpDuration() > 0)
		{
			playerDamage = rng.nextInt(5000) + PLAYERMINATTACK;
			playerDamage *= super.getATTACK_UP();
		}
		else
		{
			playerDamage = rng.nextInt(5000) + PLAYERMINATTACK;
		}
		return playerDamage;
	}
	
	public int getLimitBreakingStrike() {
		super.reduceChargeNumberUltimateSkill1();
		if (super.getAttackUpDuration() > 0)
		{
			playerDamage = rng.nextInt(LIMIT_BREAKING_STRIKE_MIN_DAMAGE) + LIMIT_BREAKING_STRIKE_MIN_DAMAGE;
			playerDamage *= super.getATTACK_UP();
		}
		else
		{
			playerDamage = rng.nextInt(LIMIT_BREAKING_STRIKE_MIN_DAMAGE) + LIMIT_BREAKING_STRIKE_MIN_DAMAGE;
		}
		return playerDamage;
	}
	
	public void useMaxSpirit() {
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
		super.reducePlayerKi(SKILLCOST);
		if (super.getPlayer1Ki() < 0)
		{
			if (super.getPlayer1ChargeNumber() == 0)
			{
				super.setPlayer1Ki(0);
			}
			else
			{
				super.reducePlayerChargeNumber();
				super.addKiUltimate(100);
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
								playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes\tNo");
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
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes\tNo");
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
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes\tNo");
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
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes\tNo");
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
			}
		} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
		if (playerSupported.equalsIgnoreCase(tankHighSpirit.toString()))
		{
			tankHighSpirit.addKiFromHighSpirit(super.getDamageDealt() * 2);
		}
		else if (playerSupported.equalsIgnoreCase(mageHighSpirit.toString()))
		{
			mageHighSpirit.addKiFromHighSpirit(super.getDamageDealt() * 2);
		}
		else if (playerSupported.equalsIgnoreCase(itemCrafterHighSpirit.toString()))
		{
			itemCrafterHighSpirit.addKiFromHighSpirit(super.getDamageDealt() * 2);
		}
		else if (playerSupported.equalsIgnoreCase(fusion.toString()))
		{
			fusion.addKiSkill(super.getDamageDealt());
		}
		super.setDamageDealt(0);
	}
	
	@Override
	public void increaseHealth(int heal) {
		super.increaseHealth(heal);
		if (super.getPlayer1Health() > MAX_HEALTH)
		{
			super.setPlayer1Health(MAX_HEALTH);;
		}
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " healed " + heal + " health");
		System.out.println(super.getUltimateTag() + super.toString() + " healed " + heal + " health");
	}
	
	@Override
	public void revive() {
		super.setPlayer1Health(MAX_HEALTH);
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " was revived");
		System.out.println(super.getUltimateTag() + super.toString() + " was revived");
	}
	
	@Override
	public void reduceHyperChargeDuration() {
		if (super.getHyperChargeDuration() > 2)
		{
			super.addKiUltimate(15);
			while (super.getPlayer1Ki() > 99)
			{
				if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer1Ki(0);
				}
				else 
				{
					super.addPlayerChargeNumber();
					super.reduceKiUltimate(100);
				}
			}
			if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer1Ki(0);
				super.setPlayer1ChargeNumber(MAX_CHARGE_NUMBER);
			}
			super.reduceHyperChargeDurationUltimate();
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turns");
			System.out.println(super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turns");
		}
		else if (super.getHyperChargeDuration() == 2)
		{
			super.addKiUltimate(15);
			while (super.getPlayer1Ki() > 99)
			{
				if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer1Ki(0);
				}
				else 
				{
					super.addPlayerChargeNumber();
					super.reducePlayerKi(100);
				}
			}
			if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer1Ki(0);
				super.setPlayer1ChargeNumber(MAX_CHARGE_NUMBER);
			}
			super.reduceHyperChargeDuration();
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turn");
			System.out.println(super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turn");
		}
		else
		{
			super.addKiUltimate(15);
			while (super.getPlayer1Ki() > 99)
			{
				if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer1Ki(0);
				}
				else 
				{
					super.addPlayerChargeNumber();
					super.reducePlayerKi(100);
				}
			}
			if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer1Ki(0);
				super.setPlayer1ChargeNumber(MAX_CHARGE_NUMBER);
			}
			super.reduceHyperChargeDuration();
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + "'s hyper charge has ended");
			System.out.println(super.getUltimateTag() + super.toString() + "'s hyper charge has ended");
		}
	}
	
	@Override
	public void addKi(int addedKi) {
		if (super.getPlayer1Health() < 1)
		{
			
		}
		else if (super.getHyperChargeDuration() > 0)
		{
			super.addKiUltimate(addedKi / 10);
		}
		else
		{
			super.addKiUltimate(addedKi / 100);
		}
		if (super.getPlayer1Ki() > 699)
		{
			super.setPlayer1ChargeNumber(7);
			super.setPlayer1Ki(0);
		}
		else if (super.getPlayer1Ki() > 599)
		{
			if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer1Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(600);
			}
		}
		else if (super.getPlayer1Ki() > 499)
		{
			if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer1Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(500);
			}
		}
		else if (super.getPlayer1Ki() > 399)
		{
			if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer1Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(400);
			}
		}
		else if (super.getPlayer1Ki() > 299)
		{
			if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer1Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(300);
			}
		}
		else if (super.getPlayer1Ki() > 199)
		{
			if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer1Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(200);
			}
		}
		else if (super.getPlayer1Ki() > 99)
		{
			if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer1Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(100);
			}
		}
		if (super.getPlayer1ChargeNumber() == MAX_CHARGE_NUMBER)
		{
			super.setPlayer1ChargeNumber(MAX_CHARGE_NUMBER);
			super.setPlayer1Ki(0);
		}
	}
	
	@Override
	public String getMOMENTUM_SKILL() {
		return MOMENTUM_SKILL;
	}

	public int getMAX_SPIRIT_STRIKE_KI_GAIN() {
		super.setPlayer1Momentum(0);
		return MAX_SPIRIT_STRIKE_KI_GAIN;
	}
	
	public int getMaxSpiritStrikeDamage() {
		playerDamage = rng.nextInt(2500) + MAX_SPIRIT_STRIKE_MIN_DAMAGE;
		return playerDamage;
	}
	
	@Override
	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}

	/**
	 * @return the sKILLCOST
	 */
	public int getSKILLCOST() {
		return SKILLCOST;
	}
	
	
}