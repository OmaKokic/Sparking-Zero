package rpgRevamp;

import java.util.Random;

import javax.swing.JOptionPane;

public class UltimateTankClass extends TankClass{

	private final String SKILL1 = "Human Tanking";
	private final String SKILL2 = "Excess Genki Transfer";
	private final int MAX_HEALTH = 20000;
	private int playerDamage;
	private final int PLAYERMINATTACK = 1250;
	private final String MOMENTUM_SKILL = "Ultimate Genki Shield";
	private static int ultimateGenkiShieldDuration = 0;
	private final int ULTIMATE_GENKI_SHIELD_HEAL = 12000;
	private final int MAX_CHARGE_NUMBER = 5;
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
			playerDamage = rng.nextInt(1250) + PLAYERMINATTACK;
			playerDamage *= super.getATTACK_UP();
		}
		else
		{
			playerDamage = rng.nextInt(1250) + PLAYERMINATTACK;
		}
		return playerDamage;
	}
	
	@Override
	public void increaseHealth(int heal) {
		super.increaseHealth(heal);
		if (super.getPlayer2Health() > MAX_HEALTH)
		{
			super.setPlayer2Health(MAX_HEALTH);;
		}
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " healed " + heal + " health");
		System.out.println(super.getUltimateTag() + super.toString() + " healed " + heal + " health");
	}
	
	@Override
	public void revive() {
		super.setPlayer2Health(MAX_HEALTH);
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " was revived");
		System.out.println(super.getUltimateTag() + super.toString() + " was revived");
	}
	
	@Override
	public void reduceHyperChargeDuration() {
		if (super.getHyperChargeDuration() > 1)
		{
			super.addKiUltimate(15);
			while (super.getPlayer2Ki() > 99)
			{
				if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer2Ki(0);
				}
				else 
				{
					super.addPlayerChargeNumber();
					super.reduceKiUltimate(100);
				}
			}
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
				super.setPlayer2ChargeNumber(MAX_CHARGE_NUMBER);
			}
			super.reduceHyperChargeDurationUltimate();
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turns");
			System.out.println(super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turns");
		}
		else if (super.getHyperChargeDuration() == 1)
		{
			super.addKiUltimate(15);
			while (super.getPlayer2Ki() > 99)
			{
				if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer2Health(0);
				}
				else 
				{
					super.addPlayerChargeNumber();
					super.reducePlayerKi(100);
				}
			}
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
				super.setPlayer2ChargeNumber(MAX_CHARGE_NUMBER);
			}
			super.reduceHyperChargeDuration();
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turn");
			System.out.println(super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turn");
		}
	}
	
	@Override
	public void addKi(int addedKi) {
		if (super.getHyperChargeDuration() > 0)
		{
			super.addKiUltimate(addedKi / 10);
		}
		else
		{
			super.addKiUltimate(addedKi / 100);
		}
		if (super.getPlayer2Ki() > 699)
		{
			super.setPlayer2ChargeNumber(7);
			super.setPlayer2Ki(0);
		}
		else if (super.getPlayer2Ki() > 599)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(600);
			}
		}
		else if (super.getPlayer2Ki() > 499)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(500);
			}
		}
		else if (super.getPlayer2Ki() > 399)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(400);
			}
		}
		else if (super.getPlayer2Ki() > 299)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(300);
			}
		}
		else if (super.getPlayer2Ki() > 199)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(200);
			}
		}
		else if (super.getPlayer2Ki() > 99)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(100);
			}
		}
		if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
		{
			super.setPlayer2Ki(0);
			super.setPlayer2ChargeNumber(MAX_CHARGE_NUMBER);
		}
	}
	
	@Override
	public String getMOMENTUM_SKILL() {
		return MOMENTUM_SKILL;
	}
	
	@Override
	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}
	
	@Override
	public void addKiFromHighSpirit(int addedKi) {
		super.addKiUltimateHighSpirit(addedKi);
		if (super.getPlayer2Ki() > 699)
		{
			super.setPlayer2ChargeNumber(7);
			super.setPlayer2Ki(0);
		}
		else if (super.getPlayer2Ki() > 599)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(600);
			}
		}
		else if (super.getPlayer2Ki() > 499)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(500);
			}
		}
		else if (super.getPlayer2Ki() > 399)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(400);
			}
		}
		else if (super.getPlayer2Ki() > 299)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(300);
			}
		}
		else if (super.getPlayer2Ki() > 199)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(200);
			}
		}
		else if (super.getPlayer2Ki() > 99)
		{
			if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(100);
			}
		}
		if (super.getPlayer2ChargeNumber() == MAX_CHARGE_NUMBER)
		{
			super.setPlayer2Ki(0);
			super.setPlayer2ChargeNumber(MAX_CHARGE_NUMBER);
		}
	}
	
	public void activateUltimateGenkiShield() {
		ultimateGenkiShieldDuration = 2;
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " used " + MOMENTUM_SKILL);
		System.out.println(super.getUltimateTag() + super.toString() + " used " + MOMENTUM_SKILL);
		super.setPlayer2Momentum(0);
	}
	
	public void reduceUltimateGenkiShieldDuration() {
		if (ultimateGenkiShieldDuration > 1)
		{
			ultimateGenkiShieldDuration--;
			JOptionPane.showMessageDialog(null, MOMENTUM_SKILL + " will last for "
					+ ultimateGenkiShieldDuration +  " more turn");
		}
		else
		{
			ultimateGenkiShieldDuration--;
			JOptionPane.showMessageDialog(null, MOMENTUM_SKILL + " has ended");
			System.out.println(MOMENTUM_SKILL + " has ended");
		}
	}

	public int getULTIMATE_GENKI_SHIELD_HEAL() {
		return ULTIMATE_GENKI_SHIELD_HEAL;
	}

	public int getUltimateGenkiShieldDuration() {
		return ultimateGenkiShieldDuration;
	}
	
	@Override
	public int getDamageTaken() {
		return super.getDamageTaken() * 2;
	}

	/**
	 * @return the sKILLCOST
	 */
	public int getSKILLCOST() {
		return SKILLCOST;
	}
	
	public void useGenkiTransfer() {
		super.reducePlayerKi(SKILLCOST);
		if (super.getPlayer2Ki() < 0)
		{
			if (super.getPlayer2ChargeNumber() == 0)
			{
				super.setPlayer2Ki(0);
			}
			else
			{
				super.reducePlayerChargeNumber();
				super.addKiUltimate(100);
			}
		}
	}
}
