package rpgRevamp;

import java.util.Random;

import javax.swing.JOptionPane;

public class UltimateMageClass extends MageClass{

	private final String SKILL1 = "Explosive Growth";
	private final String SKILL2 = "Moral Boost";
	private final int PLAYERMINATTACK = 2500;
	private final int MAX_HEALTH = 12000;
	private final String MOMENTUM_SKILL = "Contagious Growth";
	private int playerDamage;
	private Random rng = new Random();
	private final int MAX_CHARGE_NUMBER = 5;
	private final int SKILL1COST = 100;
	
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
			playerDamage = rng.nextInt(2500) + PLAYERMINATTACK;
			playerDamage *= super.getATTACK_UP();
		}
		else
		{
			playerDamage = rng.nextInt(2500) + PLAYERMINATTACK;
		}
		return playerDamage;
	}
	
	@Override
	public void increaseHealth(int heal) {
		super.increaseHealth(heal);
		if (super.getPlayer3Health() > MAX_HEALTH)
		{
			super.setPlayer3Health(MAX_HEALTH);;
		}
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " healed " + heal + " health");
		System.out.println(super.getUltimateTag() + super.toString() + " healed " + heal + " health");
	}
	
	@Override
	public void revive() {
		super.setPlayer3Health(MAX_HEALTH);
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " was revived");
		System.out.println(super.getUltimateTag() + super.toString() + " was revived");
	}
	
	@Override
	public void reduceHyperChargeDuration() {
		if (super.getHyperChargeDuration() > 1)
		{
			super.addKiUltimate(15);;
			super.addToKiGained(15);
			while (super.getPlayer3Ki() > 99)
			{
				if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer3Ki(0);
				}
				else 
				{
					super.addPlayerChargeNumberUltimate();
					super.reduceKiUltimate(100);
				}
			}
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
				super.setPlayer3ChargeNumber(MAX_CHARGE_NUMBER);
			}
			super.reduceHyperChargeDurationUltimate();
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turns");
			System.out.println(super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turns");
		}
		else if (super.getHyperChargeDuration() == 1)
		{
			super.addKiUltimate(15);
			while (super.getPlayer3Ki() > 99)
			{
				if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer3Ki(0);
				}
				else 
				{
					super.addPlayerChargeNumberUltimate();
					super.reducePlayerKi(100);
				}
			}
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
				super.setPlayer3ChargeNumber(MAX_CHARGE_NUMBER);
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
			addedKi /= 10;
			super.addKiUltimate(addedKi);
		}
		else
		{
			addedKi /= 100;
			super.addKiUltimate(addedKi);
		}
		if (super.getPlayer3Ki() > 699)
		{
			super.setPlayer3ChargeNumber(7);
			super.setPlayer3Ki(0);
		}
		else if (super.getPlayer3Ki() > 599)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(600);
			}
		}
		else if (super.getPlayer3Ki() > 499)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(500);
			}
		}
		else if (super.getPlayer3Ki() > 399)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(400);
			}
		}
		else if (super.getPlayer3Ki() > 299)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(300);
			}
		}
		else if (super.getPlayer3Ki() > 199)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(200);
			}
		}
		else if (super.getPlayer3Ki() > 99)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(100);
			}
		}
		if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
		{
			super.setPlayer3ChargeNumber(MAX_CHARGE_NUMBER);
			super.setPlayer3Ki(0);
		}
		super.addToKiGained(addedKi);
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
		if (super.getPlayer3Ki() > 699)
		{
			super.setPlayer3ChargeNumber(7);
			super.setPlayer3Ki(0);
		}
		else if (super.getPlayer3Ki() > 599)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(600);
			}
		}
		else if (super.getPlayer3Ki() > 499)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(500);
			}
		}
		else if (super.getPlayer3Ki() > 399)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(400);
			}
		}
		else if (super.getPlayer3Ki() > 299)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(300);
			}
		}
		else if (super.getPlayer3Ki() > 199)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(200);
			}
		}
		else if (super.getPlayer3Ki() > 99)
		{
			if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.addPlayerChargeNumberUltimate();
				super.reducePlayerKi(100);
			}
		}
		if (super.getPlayer3ChargeNumber() == MAX_CHARGE_NUMBER)
		{
			super.setPlayer3ChargeNumber(MAX_CHARGE_NUMBER);
			super.setPlayer3Ki(0);
		}
		super.addToKiGained(addedKi);
	}
	
	@Override
	public int getKiGained() {
		return super.getKiGained() * 2;
	}
	
	public void useContagiousGrowth() {
		super.setPlayer3Ki(100);
		super.setPlayer3ChargeNumber(7);
		super.setPlayer3Momentum(0);
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " used " + MOMENTUM_SKILL);
		System.out.println(super.getUltimateTag() + super.toString() + " used " + MOMENTUM_SKILL);
	}
	
	/**
	 * @return the sKILL1COST
	 */
	public int getSKILL1COST() {
		return SKILL1COST;
	}
	
	@Override
	public void addPlayerChargeNumber(int chargeNumberIncrease) {
		super.addPlayerChargeNumberUltimate(chargeNumberIncrease);
		if (super.getPlayer3ChargeNumber() > MAX_CHARGE_NUMBER)
		{
			super.setPlayer3ChargeNumber(MAX_CHARGE_NUMBER);
		}
	}
	
	public void useExplosiveGrowth() {
		super.reducePlayerKi(SKILL1COST);
		if (super.getPlayer3Ki() < 0)
		{
			if (super.getPlayer3ChargeNumber() == 0)
			{
				super.setPlayer3Ki(0);
			}
			else
			{
				super.reducePlayerChargeNumber();
				super.addKiUltimate(100);
			}
		}
	}
	
}
