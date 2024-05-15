package rpgRevamp;

import java.util.Random;

import javax.swing.JOptionPane;

public class UltimateItemCrafter extends ItemCrafter{

	private final String SKILL1 = "Exceptional Crafting";
	private final String SKILL2 = "Specialized Healing";
	private final int PLAYERMINATTACK = 8330;
	private final int MAX_HEALTH = 16000;
	private final String MOMENTUM_SKILL = "Knowledge of the Universe";
	private final int MAX_CHARGE_NUMBER = 5;
	private int playerDamage;
	private Random rng = new Random();
	private int increasedProgress = 0;
	private Items craft = new Items();
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
			playerDamage = rng.nextInt(PLAYERMINATTACK) + PLAYERMINATTACK;
			playerDamage *= super.getATTACK_UP();
		}
		else
		{
			playerDamage = rng.nextInt(PLAYERMINATTACK) + PLAYERMINATTACK;
		}
		return playerDamage;
	}
	
	@Override
	public void increaseHealth(int heal) {
		super.increaseHealth(heal);
		if (super.getPlayer4Health() > MAX_HEALTH)
		{
			super.setPlayer4Health(MAX_HEALTH);
		}
	}
	
	@Override
	public void revive() {
		super.setPlayer4Health(MAX_HEALTH);
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " was revived");
		System.out.println(super.getUltimateTag() + super.toString() + " was revived");
	}
	
	@Override
	public void reduceHyperChargeDuration() {
		if (super.getHyperChargeDuration() > 2)
		{
			super.addKiUltimate(15);
			while (super.getPlayer4Ki() > 99)
			{
				if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer4Ki(0);
					super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
				}
				else 
				{
					super.addPlayerChargeNumber();
					super.reduceKiUltimate(100);
				}
			}
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			super.reduceHyperChargeDurationUltimate();
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turns");
			System.out.println(super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turns");
		}
		else if (super.getHyperChargeDuration() == 2)
		{
			super.addKiUltimate(15);
			while (super.getPlayer4Ki() > 99)
			{
				if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer4Ki(0);
					super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
				}
				else 
				{
					super.addPlayerChargeNumber();
					super.reducePlayerKi(100);
				}
			}
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			super.reduceHyperChargeDuration();
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turn");
			System.out.println(super.getUltimateTag() + super.toString() + "'s hyper charge will last for " + super.getHyperChargeDuration() + " more turn");
		}
		else
		{
			super.addKiUltimate(15);
			while (super.getPlayer4Ki() > 99)
			{
				if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
				{
					super.setPlayer4Ki(0);
					super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
				}
				else 
				{
					super.addPlayerChargeNumber();
					super.reducePlayerKi(100);
				}
			}
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			super.reduceHyperChargeDuration();
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + "'s hyper charge has ended");
			System.out.println(super.getUltimateTag() + super.toString() + "'s hyper charge has ended");
		}
	}
	
	@Override
	public void addKi(int addedKi) {
		if (super.getPlayer4Health() < 1)
		{
			
		}
		else if (super.getHyperChargeDuration() > 0)
		{
			super.addKiUltimate(addedKi / 5);
		}
		else
		{
			super.addKiUltimate(addedKi / 10);
		}
		if (super.getPlayer4Ki() > 699)
		{
			super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			super.setPlayer4Ki(0);
		}
		else if (super.getPlayer4Ki() > 599)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(600);
			}
		}
		else if (super.getPlayer4Ki() > 499)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(500);
			}
		}
		else if (super.getPlayer4Ki() > 399)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(400);
			}
		}
		else if (super.getPlayer4Ki() > 299)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(300);
			}
		}
		else if (super.getPlayer4Ki() > 199)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(200);
			}
		}
		else if (super.getPlayer4Ki() > 99)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(100);
			}
		}
		if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
		{
			super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			super.setPlayer4Ki(0);
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
		if (super.getPlayer4Ki() > 699)
		{
			super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			super.setPlayer4Ki(0);
		}
		else if (super.getPlayer4Ki() > 599)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(600);
			}
		}
		else if (super.getPlayer4Ki() > 499)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(500);
			}
		}
		else if (super.getPlayer4Ki() > 399)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(400);
			}
		}
		else if (super.getPlayer4Ki() > 299)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(300);
			}
		}
		else if (super.getPlayer4Ki() > 199)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(200);
			}
		}
		else if (super.getPlayer4Ki() > 99)
		{
			if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
			{
				super.setPlayer4Ki(0);
				super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			}
			else
			{
				super.addPlayerChargeNumber();
				super.reducePlayerKi(100);
			}
		}
		if (super.getPlayer4ChargeNumber() == MAX_CHARGE_NUMBER)
		{
			super.setPlayer4ChargeNumber(MAX_CHARGE_NUMBER);
			super.setPlayer4Ki(0);
		}
	}
	
	public int craftLargeHeal() {
		if (!super.isCraftersIntuition())
		{
			super.reducePlayerKi(SKILLCOST);
		}
		increasedProgress = rng.nextInt(200) + 1;
		super.addLargeHealProgress(increasedProgress);
		super.addCraftingProgress(increasedProgress);
		if (super.getLargeHealProgress() >= 200)
		{
			craft.increaseLargeHealItemAmount();
			craft.increaseLargeHealItemAmount();
			super.reduceLargeHealProgress(200);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM2());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM2());
		}
		else if (super.getLargeHealProgress() >= 100)
		{
			craft.increaseLargeHealItemAmount();
			super.reduceLargeHealProgress(100);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM2());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM2());
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM2() + 
					" is now at " + super.getLargeHealProgress() + "% completion");
			System.out.println(craft.getITEM2() + 
					" is now at " + super.getLargeHealProgress() + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftAttackUp() {
		if (!super.isCraftersIntuition())
		{
			super.reducePlayerKi(SKILLCOST);
		}
		increasedProgress = rng.nextInt(200) + 1;
		super.addAttackUpProgress(increasedProgress);
		super.addCraftingProgress(increasedProgress);
		if (super.getLargeHealProgress() >= 200)
		{
			craft.increaseAttackUpAmount();
			craft.increaseAttackUpAmount();
			super.reduceAttackUpProgress(200);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM4());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM4());
		}
		else if (super.getAttackUpProgress() >= 100)
		{
			craft.increaseAttackUpAmount();
			super.reduceAttackUpProgress(100);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM4());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM4());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM4() + 
					" is now at " + super.getAttackUpProgress() + "% completion");
			System.out.println(craft.getITEM4() + 
					" is now at " + super.getAttackUpProgress() + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftDefenseUp() {
		if (!super.isCraftersIntuition())
		{
			super.reducePlayerKi(SKILLCOST);
		}
		increasedProgress = rng.nextInt(200) + 1;
		super.addDefenseUpProgress(increasedProgress);
		super.addCraftingProgress(increasedProgress);
		if (super.getLargeHealProgress() >= 200)
		{
			craft.increaseDefenseUpAmount();
			craft.increaseDefenseUpAmount();
			super.reduceDefenseUpProgress(200);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM5());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM5());
		}
		else if (super.getDefenseUpProgress() >= 100)
		{
			craft.increaseDefenseUpAmount();
			super.reduceDefenseUpProgress(100);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM5());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM5());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM5() + 
					" is now at " + super.getDefenseUpProgress() + "% completion");
			System.out.println(craft.getITEM5() + 
					" is now at " + super.getDefenseUpProgress() + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftHyperCharge() {
		if (!super.isCraftersIntuition())
		{
			super.reducePlayerKi(SKILLCOST);
		}
		increasedProgress = rng.nextInt(200) + 1;
		super.addHyperChargeProgress(increasedProgress);
		super.addCraftingProgress(increasedProgress);
		if (super.getLargeHealProgress() >= 200)
		{
			craft.increaseHyperChargeAmount();
			craft.increaseHyperChargeAmount();
			super.reduceHyperChargeProgress(200);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM6());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM6());
		}
		else if (super.getHyperChargeProgress() >= 100)
		{
			craft.increaseHyperChargeAmount();
			super.reduceHyperChargeProgress(100);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM6());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM6());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM6() + 
					" is now at " + super.getHyperChargeProgress() + "% completion");
			System.out.println(craft.getITEM6() + 
					" is now at " + super.getHyperChargeProgress() + "% completion");
		}
		return increasedProgress;
	}
	
	public int craftStaticMomentum() {
		if (!super.isCraftersIntuition())
		{
			super.reducePlayerKi(SKILLCOST);
		}
		increasedProgress = rng.nextInt(200) + 1;
		super.addStaticMomentumProgress(increasedProgress);
		super.addCraftingProgress(increasedProgress);
		if (super.getLargeHealProgress() >= 200)
		{
			craft.increaseStaticMomentumAmount();
			craft.increaseStaticMomentumAmount();
			super.reduceStaticMomentumProgress(200);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM7());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted two " + craft.getITEM7());
		}
		else if (super.getStaticMomentumProgress() >= 100)
		{
			craft.increaseStaticMomentumAmount();
			super.reduceStaticMomentumProgress(100);
			JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM7());
			System.out.println(super.getUltimateTag() + super.toString() + " crafted a " + craft.getITEM7());
		}
		else
		{
			JOptionPane.showMessageDialog(null, craft.getITEM7() + 
					" is now at " + super.getStaticMomentumProgress() + "% completion");
			System.out.println(craft.getITEM7() + 
					" is now at " + super.getStaticMomentumProgress() + "% completion");
		}
		return increasedProgress;
	}
	
	public void useKnowledgeOfTheUniverse() {
		JOptionPane.showMessageDialog(null, super.getUltimateTag() + super.toString() + " used " + MOMENTUM_SKILL); 
		System.out.println(super.getUltimateTag() + super.toString() + " used " + MOMENTUM_SKILL);
		super.setPlayer4Momentum(0);
	}

	/**
	 * @return the sKILLCOST
	 */
	public int getSKILLCOST() {
		return SKILLCOST;
	}
	
}