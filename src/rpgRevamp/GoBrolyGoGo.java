package rpgRevamp;
import javax.swing.JOptionPane;
public class GoBrolyGoGo {

	public static void main(String[] args) {
		  //This is the boss name
		String player1Name,//This is player 1's name
			   player2Name,//This is player 2's name
			   player3Name,//This is player 3's name
			   player4Name;//This is player 4's name
		AttackerClass p1 = new AttackerClass();//This variable calls the Player1 class
		TankClass p2 = new TankClass();//This variable calls the Player2 class
		MageClass p3 = new MageClass();//This variable calls the Player3 class
		ItemCrafter p4 = new ItemCrafter();//This variable calls the Player4 class
		String selectedDifficulty = "1";
		String modeSelect = "";
		boolean validChoice = false;
		player1Name = JOptionPane.showInputDialog("What's player 1's name?");//This asks the user to pick a name for player 1
		if (player1Name == null)
		{
			player1Name = "Lora";
		}
		p1.setName1(player1Name);//This sets the name for player 1
		player2Name = JOptionPane.showInputDialog("What's player 2's name?");//This asks the user to pick a name for player 2
		if (player2Name == null)
		{
			player2Name = "Bayo";
		}
		p2.setName2(player2Name);//This sets the name for player 2
		player3Name = JOptionPane.showInputDialog("What's player 3's name?");//This asks the user to pick a name for player 39
		if (player3Name == null)
		{
			player3Name = "2B";
		}
		p3.setName3(player3Name);//This sets the name for player 3
		player4Name = JOptionPane.showInputDialog("What's player 4's name?");//This asks the user to pick a name for player 4
		if (player4Name == null)
		{
			player4Name = "Eve";
		}
		p4.setName4(player4Name);//This sets the name for player 4
		do {
			modeSelect = JOptionPane.showInputDialog("What mode do you want to play?\n\nStandard\nChallenge Mode\nCustom");
			if (modeSelect == null)
			{
				modeSelect = "Standard";
				validChoice = true;
			}
			else if (modeSelect.equalsIgnoreCase("Standard"))
			{
				validChoice = true;
			}
			else if (modeSelect.equalsIgnoreCase("Challenge Mode"))
			{
				validChoice = true;
			}
			else if (modeSelect.equalsIgnoreCase("Custom"))
			{
				validChoice = true;
			}
			else
			{
				validChoice = false;
			}
		}while (!validChoice);
		if (modeSelect.equalsIgnoreCase("Challenge Mode"))
		{
			selectedDifficulty = "2";
		}
		if (modeSelect.equalsIgnoreCase("Custom"))
		{
			String playerConfirmation;
			do {
				selectedDifficulty = JOptionPane.showInputDialog("Pick a interger to choice te difficulty. 1 is normal, higher makes it harder.");
				if (selectedDifficulty == null)
				{
					selectedDifficulty = "1";
				}
				String smallHealAmount = JOptionPane.showInputDialog("Challenge Mode\nHow many small heals do you want to start with?");
				if (smallHealAmount == null)
				{
					smallHealAmount = "1";
				}
				String largeHealAmount = JOptionPane.showInputDialog("Challenge Mode\nHow many large heals do you want to start with?");
				if (largeHealAmount == null)
				{
					largeHealAmount = "1";
				}
				String senzuAmount = JOptionPane.showInputDialog("Challenge Mode\nHow many senzu beans do you want to start with?");
				if (senzuAmount == null)
				{
					senzuAmount = "1";
				}
				String attackUpAmount = JOptionPane.showInputDialog("Challenge Mode\nHow many attack ups do you want to start with?");
				if (attackUpAmount == null)
				{
					attackUpAmount = "1";
				}
				String defenseUpAmount = JOptionPane.showInputDialog("Challenge Mode\nHow many defense ups do you want to start with?");
				if (defenseUpAmount == null)
				{
					defenseUpAmount = "1";
				}
				String hyperChargeAmount = JOptionPane.showInputDialog("Challenge Mode\nHow many hyper charges do you want to start with?");
				if (hyperChargeAmount == null)
				{
					hyperChargeAmount = "1";
				}
				String staticMomentumAmount = JOptionPane.showInputDialog("Challenge Mode\nHow many static momentums do you want to start with?");
				if (staticMomentumAmount == null)
				{
					staticMomentumAmount = "1";
				}
				String dragonBallsAmount = JOptionPane.showInputDialog("Challenge Mode\nHow many Dragon Balls do you want to start with?");
				if (dragonBallsAmount == null)
				{
					dragonBallsAmount = "1";
				}
				String potaras;
				do {
					potaras = JOptionPane.showInputDialog("Challenge Mode\nDo you want potara earrings?");
					if (potaras == null)
					{
						potaras = "";
					}
					else if (potaras.equalsIgnoreCase("yes"))
					{
						validChoice = true;
					}
					else if (potaras.equalsIgnoreCase("no"))
					{
						validChoice = true;
					}
					else
					{
						validChoice = false;
					}
				}while (!validChoice);
				try {
					Items.itemAmountSelect(Integer.parseInt(smallHealAmount), Integer.parseInt(largeHealAmount), Integer.parseInt(senzuAmount), Integer.parseInt(attackUpAmount), Integer.parseInt(defenseUpAmount), Integer.parseInt(hyperChargeAmount), Integer.parseInt(staticMomentumAmount), Integer.parseInt(dragonBallsAmount), potaras);
				}
				catch (Exception e) {
					Items.itemAmountSelect(1, 1, 1, 1, 1, 1, 1, 0, "no");
				}
				playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
				if (playerConfirmation == null)
				{
					playerConfirmation = "no";
				}
			} while ((!(playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
		}
		try {
			Broly broly = new Broly(Integer.parseInt(selectedDifficulty));//This variable calls the BrolyRage class
			phase1(broly, p1, p2, p3, p4);
		}
		catch (Exception e) {
			Broly broly = new Broly(1);//This variable calls the BrolyRage class
			phase1(broly, p1, p2, p3, p4);
		}
		Broly broly = new Broly();
		if (broly.getBrolyHealth() < 1 && modeSelect.equalsIgnoreCase("Challenge Mode"))
		{
			JOptionPane.showMessageDialog(null, "Impressive! You earned " + Items.getPoints() + " points");
		}
		else if (broly.getBrolyHealth() < 1)
		{
			JOptionPane.showMessageDialog(null, "Return Broly back to the planet he grew up on!");
			JOptionPane.showMessageDialog(null, "You win!\nNow try challenge mode.");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Game Over\n You've been wiped out.");
		}
	}
	
	/**
	 * This method runs phase 1
	 * @param rage Broly object
	 * @param user1 Player1 object
	 * @param user2 Player2 object
	 * @param user3 Player3 object
	 * @param user4 Player4 object
	 */
	public static void phase1(Broly rage, AttackerClass user1, TankClass user2, MageClass user3, ItemCrafter user4) {
		PlayerStatus gameOver = new PlayerStatus();
		do//This loop runs the game
		{
			if (gameOver.getPlayerStatus())
			{
				playerMenu(rage, user1, user2, user3, user4);
			}
			if (gameOver.getPlayerStatus())
			{
				brolyRageTurn(rage, user1, user2, user3, user4);
			}
			rage.setBrolyName();
		} while (rage.toString().equalsIgnoreCase(rage.getPHASE_1_BOSS_NAME()) && ((gameOver.getPlayerStatus())));//This condition decides when phase 1 ends
		if (gameOver.getPlayerStatus())
		{
			JOptionPane.showMessageDialog(null, "Broly, look!");
			JOptionPane.showMessageDialog(null, "It's such a tragedy! Your father has been killed!");
			JOptionPane.showMessageDialog(null, "Broly: AHHHHHHHHHH!");
		}
		phase2(rage, user1, user2, user3, user4);
	}
	/**
	 * This method displays battle information
	 * @param bossName Broly object
	 * @param player1Name AttackerClass object
	 * @param player2Name Player2 object
	 * @param player3Name Player3 object
	 * @param player4Name Player4 object
	 */
	public static void playerMenu(Broly boss, AttackerClass AttackClass, TankClass tankClass, MageClass mageClass, ItemCrafter itemCrafter) {
		String attackerAction = "null",
			   tankAction = "null",
			   mageAction = "null",
			   itemCrafterAction = "null",
			   endTurn = "no",
			   fusedPlayerAction = "null";
		UltimateAttackerClass ultimateAttacker = new UltimateAttackerClass();
		UltimateTankClass ultimateTank = new UltimateTankClass();
		UltimateMageClass ultimateMage = new UltimateMageClass();
		UltimateItemCrafter ultimateItemCrafter = new UltimateItemCrafter();
		FusedPlayer fusion = new FusedPlayer();
		PlayerStatus comeBack = new PlayerStatus();
		do
		{
			if (Broly.getBlasterMeteorBarrierHealth() > 0 && Broly.getOmegaBlasterHealth() > 0)
			{
				JOptionPane.showMessageDialog(null, boss + "\nBarrier: " + (Broly.getBlasterMeteorBarrierHealth() + Broly.getOmegaBlasterHealth()) + " Hp: " + boss.getBrolyHealth() + "/" + boss.getBROLY_MAX_HEALTH() + "\nKi: " 
						+ boss.getBrolyChargeNumber() + " ("+ boss.getBrolyKi() + ")\nMomentum: " + boss.getBrolyMomentum());
				System.out.println(boss + "\nBarrier: " + (Broly.getBlasterMeteorBarrierHealth() + Broly.getOmegaBlasterHealth()) + " Hp: " + boss.getBrolyHealth() + "/" + boss.getBROLY_MAX_HEALTH() + "\nKi: " 
						+ boss.getBrolyChargeNumber() + " ("+ boss.getBrolyKi() + ")\nMomentum: " + boss.getBrolyMomentum());
			}
			else if (Broly.getBlasterMeteorBarrierHealth() > 0)
			{
				JOptionPane.showMessageDialog(null, boss + "\nBarrier: " + Broly.getBlasterMeteorBarrierHealth() + " Hp: " + boss.getBrolyHealth() + "/" + boss.getBROLY_MAX_HEALTH() + "\nKi: " 
						+ boss.getBrolyChargeNumber() + " ("+ boss.getBrolyKi() + ")\nMomentum: " + boss.getBrolyMomentum());
				System.out.println(boss + "\nBarrier: " + Broly.getBlasterMeteorBarrierHealth() + " Hp: " + boss.getBrolyHealth() + "/" + boss.getBROLY_MAX_HEALTH() + "\nKi: " 
						+ boss.getBrolyChargeNumber() + " ("+ boss.getBrolyKi() + ")\nMomentum: " + boss.getBrolyMomentum());
			}
			else if (Broly.getOmegaBlasterHealth() > 0)
			{
				JOptionPane.showMessageDialog(null, boss + "\nBarrier: " + Broly.getOmegaBlasterHealth() + " Hp: " + boss.getBrolyHealth() + "/" + boss.getBROLY_MAX_HEALTH() + "\nKi: " 
						+ boss.getBrolyChargeNumber() + " ("+ boss.getBrolyKi() + ")\nMomentum: " + boss.getBrolyMomentum());
				System.out.println(boss + "\nBarrier: " + Broly.getOmegaBlasterHealth() + " Hp: " + boss.getBrolyHealth() + "/" + boss.getBROLY_MAX_HEALTH() + "\nKi: " 
						+ boss.getBrolyChargeNumber() + " ("+ boss.getBrolyKi() + ")\nMomentum: " + boss.getBrolyMomentum());
			}
			else
			{
				JOptionPane.showMessageDialog(null, boss + "\nHp: " + boss.getBrolyHealth() + "/" + boss.getBROLY_MAX_HEALTH() + "\nKi: " 
					+ boss.getBrolyChargeNumber() + " ("+ boss.getBrolyKi() + ")\nMomentum: " + boss.getBrolyMomentum());
				System.out.println(boss + "\nHp: " + boss.getBrolyHealth() + "/" + boss.getBROLY_MAX_HEALTH() + "\nKi: " 
						+ boss.getBrolyChargeNumber() + " ("+ boss.getBrolyKi() + ")\nMomentum: " + boss.getBrolyMomentum());
			}
			if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getAttackCrafter())
			{
			}
			else if (AttackClass.isUltimate())
			{
				JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + AttackClass + " Hp: " + AttackClass.getPlayer1Health() + "/" + ultimateAttacker.getMAX_HEALTH() + "\nKi: " + 
					AttackClass.getPlayer1ChargeNumber() + " (" + AttackClass.getPlayer1Ki() + ")\nMomentum: " + 
					AttackClass.getPlayer1Momentum());
				System.out.println(AttackerClass.getUltimateTag() + AttackClass + " Hp: " + AttackClass.getPlayer1Health() + "/" + ultimateAttacker.getMAX_HEALTH() + "\nKi: " + 
					AttackClass.getPlayer1ChargeNumber() + " (" + AttackClass.getPlayer1Ki() + ")\nMomentum: " + 
					AttackClass.getPlayer1Momentum());
			}
			else
			{
				JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + AttackClass + " Hp: " + AttackClass.getPlayer1Health() + "/" + AttackClass.getMAX_HEALTH() + "\nKi: " + 
					AttackClass.getPlayer1ChargeNumber() + " (" + AttackClass.getPlayer1Ki() + ")\nMomentum: " + 
					AttackClass.getPlayer1Momentum());
				System.out.println(AttackerClass.getUltimateTag() + AttackClass + " Hp: " + AttackClass.getPlayer1Health() + "/" + AttackClass.getMAX_HEALTH() + "\nKi: " + 
					AttackClass.getPlayer1ChargeNumber() + " (" + AttackClass.getPlayer1Ki() + ")\nMomentum: " + 
					AttackClass.getPlayer1Momentum());
			}
			if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getTankCrafter())
			{
			}
			else if (tankClass.isUltimate())
			{
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + tankClass + " Hp: "+ tankClass.getPlayer2Health() 
					+ "/" + ultimateTank.getMAX_HEALTH() + "\nKi: " + tankClass.getPlayer2ChargeNumber() + " (" + tankClass.getPlayer2Ki() + 
				")\nMomentum: " + tankClass.getPlayer2Momentum());
				System.out.println(TankClass.getUltimateTag() + tankClass + " Hp: "+ tankClass.getPlayer2Health() 
					+ "/" + ultimateTank.getMAX_HEALTH() + "\nKi: " + tankClass.getPlayer2ChargeNumber() + " (" + tankClass.getPlayer2Ki() + 
				")\nMomentum: " + tankClass.getPlayer2Momentum());
			}
			else
			{
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + tankClass + " Hp: "+ tankClass.getPlayer2Health() 
					+ "/" + tankClass.getMAX_HEALTH() + "\nKi: " + tankClass.getPlayer2ChargeNumber() + " (" + tankClass.getPlayer2Ki() + 
				")\nMomentum: " + tankClass.getPlayer2Momentum());
				System.out.println(TankClass.getUltimateTag() + tankClass + " Hp: "+ tankClass.getPlayer2Health() 
					+ "/" + tankClass.getMAX_HEALTH() + "\nKi: " + tankClass.getPlayer2ChargeNumber() + " (" + tankClass.getPlayer2Ki() + 
				")\nMomentum: " + tankClass.getPlayer2Momentum());
			}
			if (FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
			{
			}
			else if (mageClass.isUltimate())
			{
				JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + mageClass + " Hp: " + mageClass.getPlayer3Health() + 
						"/" + ultimateMage.getMAX_HEALTH() + "\nKi: " + mageClass.getPlayer3ChargeNumber() + " (" + mageClass.getPlayer3Ki() 
						+ ")\nMomentum: " + mageClass.getPlayer3Momentum());
				System.out.println(MageClass.getUltimateTag() + mageClass + " Hp: " + mageClass.getPlayer3Health() + 
						"/" + ultimateMage.getMAX_HEALTH() + "\nKi: " + mageClass.getPlayer3ChargeNumber() + " (" + mageClass.getPlayer3Ki() 
						+ ")\nMomentum: " + mageClass.getPlayer3Momentum());
			}
			else
			{
				JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + mageClass + " Hp: " + mageClass.getPlayer3Health() + 
				"/" + mageClass.getMAX_HEALTH() + "\nKi: " + mageClass.getPlayer3ChargeNumber() + " (" + mageClass.getPlayer3Ki() 
				+ ")\nMomentum: " + mageClass.getPlayer3Momentum());
				System.out.println(MageClass.getUltimateTag() + mageClass + " Hp: " + mageClass.getPlayer3Health() + 
				"/" + mageClass.getMAX_HEALTH() + "\nKi: " + mageClass.getPlayer3ChargeNumber() + " (" + mageClass.getPlayer3Ki() 
				+ ")\nMomentum: " + mageClass.getPlayer3Momentum());
			}
			if (FusedPlayer.getFusionType() == fusion.getAttackCrafter() || FusedPlayer.getFusionType() == fusion.getTankCrafter() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
			{
			}
			else if (itemCrafter.isUltimate())
			{
				JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + itemCrafter + " Hp: " + itemCrafter.getPlayer4Health() + 
						"/" + ultimateItemCrafter.getMAX_HEALTH() + "\nKi: " + itemCrafter.getPlayer4ChargeNumber() + " (" + itemCrafter.getPlayer4Ki() 
						+ ")\nMomentum: " + itemCrafter.getPlayer4Momentum());
				System.out.println(ItemCrafter.getUltimateTag() + itemCrafter + " Hp: " + itemCrafter.getPlayer4Health() + 
						"/" + ultimateItemCrafter.getMAX_HEALTH() + "\nKi: " + itemCrafter.getPlayer4ChargeNumber() + " (" + itemCrafter.getPlayer4Ki() 
						+ ")\nMomentum: " + itemCrafter.getPlayer4Momentum());
			}
			else if (comeBack.isOnePlayer() && itemCrafter.getPlayer4Health() < 1)
			{
				JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + itemCrafter + " will revive in " + ItemCrafter.getRevivalTimer() + " turns");
				System.out.println(ItemCrafter.getUltimateTag() + itemCrafter + " will revive in " + ItemCrafter.getRevivalTimer() + " turns");
			}
			else
			{
				JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + itemCrafter + " Hp: " + itemCrafter.getPlayer4Health() + 
					"/" + itemCrafter.getMAX_HEALTH() + "\nKi: " + itemCrafter.getPlayer4ChargeNumber() + " (" + itemCrafter.getPlayer4Ki() 
					+ ")\nMomentum: " + itemCrafter.getPlayer4Momentum());
				System.out.println(ItemCrafter.getUltimateTag() + itemCrafter + " Hp: " + itemCrafter.getPlayer4Health() + 
					"/" + itemCrafter.getMAX_HEALTH() + "\nKi: " + itemCrafter.getPlayer4ChargeNumber() + " (" + itemCrafter.getPlayer4Ki() 
					+ ")\nMomentum: " + itemCrafter.getPlayer4Momentum());
			}
			if (FusedPlayer.isFused())
			{
				JOptionPane.showMessageDialog(null, fusion + " Hp: " + FusedPlayer.getHealth() + 
					"/" + FusedPlayer.getMaxHealth() + "\nKi: " + FusedPlayer.getChargeNumber() + " (" + FusedPlayer.getKi()
					+ ")\nMomentum: " + FusedPlayer.getMomentum());
				System.out.println(fusion + " Hp: " + FusedPlayer.getHealth() + 
						"/" + FusedPlayer.getMaxHealth() + "\nKi: " + FusedPlayer.getChargeNumber() + " (" + FusedPlayer.getKi()
						+ ")\nMomentum: " + FusedPlayer.getMomentum());
			}
			if (AttackClass.getPlayer1Health() <= 0)
			{
			}
			else if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getAttackCrafter())
			{
			}
			else
			{
				attackerAction = attackClassAction(AttackClass, ultimateAttacker);
			}
			if (tankClass.getPlayer2Health() <= 0)
			{
			}
			else if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getTankCrafter())
			{
			}
			else
			{
				tankAction = TankClassAction(tankClass, ultimateTank);
			}
			if (mageClass.getPlayer3Health() <= 0) 
			{	
			}
			else
			{
				mageAction = mageClassAction(mageClass, ultimateMage);
			}
			if (itemCrafter.getPlayer4Health() <= 0)
			{
			}
			else if (FusedPlayer.getFusionType() == fusion.getAttackCrafter() || FusedPlayer.getFusionType() == fusion.getTankCrafter() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
			{
			}
			else
			{
				itemCrafterAction = itemCrafterAction(itemCrafter, ultimateItemCrafter);
			}
			if (FusedPlayer.isFused())
			{
				fusionAction(AttackClass, tankClass, mageClass, itemCrafter);
			}
			endTurn = JOptionPane.showInputDialog("End your turn?\nYes  No");
			if (endTurn == null)
			{
				endTurn = "no";
			}
		} while (!((endTurn.equalsIgnoreCase("yes"))) &&(!(endTurn.equalsIgnoreCase("y"))));
		if (comeBack.isOnePlayer() && itemCrafter.getPlayer4Health() < 1 && !FusedPlayer.isFused())
		{
			itemCrafter.reviveItemCrafter();
		}
		else
		{
			ItemCrafter.resetRevivalTimer();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getAttackCrafter())
		{
		}
		else if (AttackClass.getAttackUpDuration() > 0)
		{
			AttackClass.reduceAttackUpDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getTankCrafter())
		{
		}
		else if (tankClass.getAttackUpDuration() > 0)
		{
			tankClass.reduceAttackUpDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (mageClass.getAttackUpDuration() > 0)
		{
			mageClass.reduceAttackUpDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackCrafter() || FusedPlayer.getFusionType() == fusion.getTankCrafter() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (itemCrafter.getAttackUpDuration() > 0)
		{
			itemCrafter.reduceAttackUpDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getAttackCrafter())
		{
		}
		else if (AttackClass.getDefenseUpDuration() > 0)
		{
			AttackClass.reduceDefenseUpDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getTankCrafter())
		{
		}
		else if (tankClass.getDefenseUpDuration() > 0)
		{
			tankClass.reduceDefenseUpDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (mageClass.getDefenseUpDuration() > 0)
		{
			mageClass.reduceDefenseUpDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackCrafter() || FusedPlayer.getFusionType() == fusion.getTankCrafter() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (itemCrafter.getDefenseUpDuration() > 0)
		{
			itemCrafter.reduceDefenseUpDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getAttackCrafter())
		{
		}
		else if (AttackClass.getHyperChargeDuration() > 0)
		{
			AttackClass.reduceHyperChargeDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getTankCrafter())
		{
		}
		else if (tankClass.getHyperChargeDuration() > 0)
		{
			tankClass.reduceHyperChargeDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (mageClass.getHyperChargeDuration() > 0)
		{
			mageClass.reduceHyperChargeDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackCrafter() || FusedPlayer.getFusionType() == fusion.getTankCrafter() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (itemCrafter.getHyperChargeDuration() > 0)
		{
			itemCrafter.reduceHyperChargeDuration();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getAttackCrafter())
		{
		}
		else if (AttackClass.getStaticMomentumDuration() > 0)
		{
			AttackClass.reduceStaticMomentumDuration();;
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getTankCrafter())
		{
		}
		else if (tankClass.getStaticMomentumDuration() > 0)
		{
			tankClass.reduceStaticMomentumDuration();;
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (mageClass.getStaticMomentumDuration() > 0)
		{
			mageClass.reduceStaticMomentumDuration();;
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackCrafter() || FusedPlayer.getFusionType() == fusion.getTankCrafter() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (itemCrafter.getStaticMomentumDuration() > 0)
		{
			itemCrafter.reduceStaticMomentumDuration();;
		}
		if (AttackClass.isHumanShieldTarget())
		{
			AttackClass.removeHumanShieldTarget();
		}
		if (mageClass.isHumanShieldTarget())
		{
			mageClass.removeHumanShieldTarget();
		}
		if (itemCrafter.isHumanShieldTarget())
		{
			itemCrafter.removeHumanShieldTarget();
		}
		if (tankClass.isGenkiShieldDuration())
		{
			tankClass.reduceGenkiShieldDuration();
		}
		if (tankClass.isHumanShieldSkill())
		{
			tankClass.deactivateHumanShieldSkill();
		}
		if (AttackerClass.isDefending())
		{
			AttackClass.endDefending();
		}
		if (TankClass.isDefending())
		{
			tankClass.endDefending();
		}
		if (MageClass.isDefending())
		{
			mageClass.endDefending();
		}
		if (ItemCrafter.isDefending())
		{
			itemCrafter.endDefending();
		}
		if (ultimateTank.getUltimateGenkiShieldDuration() > 0)
		{
			ultimateTank.reduceUltimateGenkiShieldDuration();
		}
		if (FusedPlayer.getAttackUpDuration() > 0)
		{
			fusion.reduceAttackUpDuration();
		}
		if (FusedPlayer.getDefenseUpDuration() > 0)
		{
			fusion.reduceDefenseUpDuration();
		}
		if (FusedPlayer.getHyperChargeDuration() > 0)
		{
			fusion.reduceHyperChargeDuration();
		}
		if (FusedPlayer.getStaticMomentumDuration() > 0)
		{
			fusion.reduceStaticMomentumDuration();
		}
		if (FusedPlayer.isDefending())
		{
			fusion.endDefending();
		}
		if (fusion.isHumanShieldTarget())
		{
			fusion.removeHumanShieldTarget();
		}
		if ((!(FusedPlayer.isFused())))
		{
			FusedPlayer.reduceCooldown();
		}
		if (FusedPlayer.isProtectionSkill())
		{
			FusedPlayer.deactivateProtectionSkill();
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getAttackCrafter())
		{
		}
		else if (AttackClass.isUltimate())
		{
			ultimatePlayer1Turn(attackerAction, boss, ultimateAttacker, tankClass, mageClass, itemCrafter);
		}
		else
		{
			player1Turn(attackerAction, boss, AttackClass, tankClass, mageClass, itemCrafter);
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getTankCrafter())
		{
		}
		else if (tankClass.isUltimate())
		{
			ultimatePlayer2Turn(tankAction, boss, AttackClass, ultimateTank, mageClass, itemCrafter);
		}
		else
		{
			player2Turn(tankAction, boss, AttackClass, tankClass, mageClass, itemCrafter);
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getTankMage() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (mageClass.isUltimate())
		{
			ultimatePlayer3Turn(mageAction, boss, AttackClass, tankClass, ultimateMage, itemCrafter);
		}
		else
		{
			player3Turn(mageAction, boss, AttackClass, tankClass, mageClass, itemCrafter);
		}
		if (FusedPlayer.getFusionType() == fusion.getAttackCrafter() || FusedPlayer.getFusionType() == fusion.getTankCrafter() || FusedPlayer.getFusionType() == fusion.getMageCrafter())
		{
		}
		else if (itemCrafter.isUltimate())
		{
			ultimatePlayer4Turn(itemCrafterAction, boss, AttackClass, tankClass, mageClass, ultimateItemCrafter);
		}
		else
		{
			player4Turn(itemCrafterAction, boss, AttackClass, tankClass, mageClass, itemCrafter);
		}
		if (FusedPlayer.isFused())
		{
			fusedPlayerTurn(fusedPlayerAction, boss);
		}
		if (FusedPlayer.isFused())
		{
			FusedPlayer.reduceCountdown();
		}
	}
	public static String attackClassAction(AttackerClass attacker, UltimateAttackerClass ultimateAttacker) {
		String playerConfirmation = "no",
			   p1Action = "null";
		Broly phase = new Broly();
		PlayerStatus onePlayer = new PlayerStatus(); 
		do {
			if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()) && !FusedPlayer.isFused() && attacker.isUltimate())
			{
				p1Action = JOptionPane.showInputDialog("What will " + AttackerClass.getUltimateTag() + attacker + " do?\n\nAttack\nSkill\nItems\nDefend\n" + ultimateAttacker.getMOMENTUM_SKILL() + "\nFuse");
				if (p1Action == null)
				{
					p1Action = "";
				}
			}
			else if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()) && !FusedPlayer.isFused())
			{
				p1Action = JOptionPane.showInputDialog("What will " + AttackerClass.getUltimateTag() + attacker + " do?\n\nAttack\nSkill\nItems\nDefend\n" + attacker.getMOMENTUM_SKILL() + "\nFuse");
				if (p1Action == null)
				{
					p1Action = "";
				}
			}
			else if (attacker.isUltimate())
			{
				p1Action = JOptionPane.showInputDialog("What will " + AttackerClass.getUltimateTag() + attacker + " do?\n\nAttack\nSkill\nItems\nDefend\n" + ultimateAttacker.getMOMENTUM_SKILL());
				if (p1Action == null)
				{
					p1Action = "";
				}
			}
			else
			{
				p1Action = JOptionPane.showInputDialog("What will " + AttackerClass.getUltimateTag() + attacker + " do?\n\nAttack\nSkill\nItems\nDefend\n" + attacker.getMOMENTUM_SKILL());
				if (p1Action == null)
				{
					p1Action = "";
				}
			}
			if (p1Action.equalsIgnoreCase("Attack"))
			{
				playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
				if (playerConfirmation == null)
				{
					playerConfirmation = "";
				}
			}
			else if (p1Action.equalsIgnoreCase("SKILL"))
			{
				p1Action = attackClassSkills(attacker, ultimateAttacker);
				if (p1Action.equalsIgnoreCase(attacker.getSkill1()) || p1Action.equalsIgnoreCase(attacker.getSkill2()))
				{
				}
				else if (attacker.isUltimate())
				{
					if (p1Action.equalsIgnoreCase(ultimateAttacker.getSkill1()) || p1Action.equalsIgnoreCase(ultimateAttacker.getSkill2()))
					{
					}
					else
					{
						p1Action = "null";
					}
				}
				else
				{
					p1Action = "null";
				}
				if (p1Action.equalsIgnoreCase("null"))
				{
					playerConfirmation = "no";
				}
				else
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "";
					}
				}
			}
			else if (p1Action.equalsIgnoreCase("Items"))
			{
				p1Action = items();
				if (p1Action.equalsIgnoreCase("null"))
				{
					playerConfirmation = "no";
				}
				else
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "";
					}
				}
			}
			else if (p1Action.equalsIgnoreCase("Defend"))
			{
				playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
				if (playerConfirmation == null)
				{
					playerConfirmation = "";
				}
			}
			else if (p1Action.equalsIgnoreCase(attacker.getMOMENTUM_SKILL()))
			{
				if (attacker.getPlayer1Momentum() >= 100 && !attacker.isUltimate())
				{
					playerConfirmation = JOptionPane.showInputDialog(attacker.getMOMENTUM_SKILL()
							+ " - Grant all allies " + attacker.getHIGH_SPIRIT_STRIKE_KI_GAIN() 
							+ " ki and deals high damage\nAre you sure?\n"
							+ "Yes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "";
					}
				}
				else if (attacker.isUltimate())
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You need full momentum to use it");
					playerConfirmation = "no";
				}
			}
			else if (p1Action.equalsIgnoreCase(ultimateAttacker.getMOMENTUM_SKILL()))
			{
				if (attacker.isUltimate() && attacker.getPlayer1Momentum() >= 100)
				{
					playerConfirmation = JOptionPane.showInputDialog(ultimateAttacker.getMOMENTUM_SKILL()
							+ " - Grant all allies " + ultimateAttacker.getMAX_SPIRIT_STRIKE_KI_GAIN() 
							+ " ki and deals high damage\nAre you sure?\n"
							+ "Yes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "";
					}
				}
				else if (!attacker.isUltimate())
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You need full momentum to use it");
					playerConfirmation = "no";
				}
			}
			else if (p1Action.equalsIgnoreCase("Fuse"))
			{
				if (FusedPlayer.isFused())
				{
					JOptionPane.showMessageDialog(null, "There is still an active fusion");
				}
				else if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()))
				{
					if (FusedPlayer.getFusionCooldown() > 0)
					{
						if (FusedPlayer.getFusionCooldown() > 1)
						{
							JOptionPane.showMessageDialog(null, "You need to wait " + FusedPlayer.getFusionCooldown() + " more turns");
							playerConfirmation = "no";
						}
						else
						{
							JOptionPane.showMessageDialog(null, "You need to wait " + FusedPlayer.getFusionCooldown() + " more turn");
							playerConfirmation = "no";
						}
					}
					else if (onePlayer.isOnePlayer())
					{
						JOptionPane.showMessageDialog(null, "There are no other players");
					}
					else
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "";
						}
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
				JOptionPane.showMessageDialog(null, "Error");
				playerConfirmation = "no";
			}
		} while (!(playerConfirmation.equalsIgnoreCase("yes")) && (!(playerConfirmation.equalsIgnoreCase("y"))));
		return p1Action;
	}
	public static String attackClassSkills(AttackerClass attackerS, UltimateAttackerClass ultimateAttackerS) {
		String attackSkill;
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		if (attackerS.isUltimate())
		{
			attackSkill = JOptionPane.showInputDialog("Skills\n" + ultimateAttackerS.getSkill1() + " - Deals limit breaking damage - 200 Ki\n" + 
					ultimateAttackerS.getSkill2() + " - Give an ally Ki two times damage dealt (" + AttackerClass.getDamageDealt() * 2 / 100 + ") - 100 Ki");
			if (attackSkill == null)
			{
				attackSkill = "null";
			}
		}
		else
		{	
			attackSkill = JOptionPane.showInputDialog("Skills\n" + attackerS.getSkill1() + " - Deals high damage - 100 Ki\n" + 
					attackerS.getSkill2() + " - Give an ally Ki based on damage dealt (" + AttackerClass.getDamageDealt() / 100 + ") - 50 Ki");
			if (attackSkill == null)
			{
				attackSkill = "null";
			}
		}	
		if (attackerS.getPlayer1ChargeNumber() <= 0)
		{
			if (attackerS.isUltimate())
			{
				if (attackerS.getPlayer1Ki() < ultimateAttackerS.getSKILLCOST())
				{
					attackSkill = "null";
					JOptionPane.showMessageDialog(null, "You do not have enough ki");
				}
			}
			else
			{
				if (attackerS.getPlayer1Ki() < attackerS.getSKILLCOST())
				{
					attackSkill = "null";
					JOptionPane.showMessageDialog(null, "You do not have enough ki");
				}
			}
		}
		if (attackSkill.equalsIgnoreCase(attackerS.getSkill1()))
		{
			if (attackerS.getPlayer1ChargeNumber() < 1)
			{
				attackSkill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
		}
		if (attackSkill.equalsIgnoreCase(ultimateAttackerS.getSkill1()))
		{
			if (attackerS.getPlayer1ChargeNumber() < 2)
			{
				attackSkill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
		}
		if(attackSkill.equalsIgnoreCase(attackerS.getSkill2()) || attackSkill.equalsIgnoreCase(ultimateAttackerS.getSkill2()))
		{
			if (player2.getPlayer2Health() <= 0)
			{
				if (player3.getPlayer3Health() <= 0)
				{
					if (player4.getPlayer4Health() <= 0)
					{
						attackSkill = "null";
						JOptionPane.showMessageDialog(null, "This skill is unusable");
					}
				}
			}
		}
		return attackSkill;
	}
	public static String items() {
		Items useItem = new Items();
		String chosenItem;
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		Broly boss = new Broly();
		PlayerStatus dragonBalls = new PlayerStatus();
		if (Items.isPotaras())
		{
			if (boss.toString().equalsIgnoreCase(boss.getPHASE_1_BOSS_NAME()))
			{
				chosenItem = JOptionPane.showInputDialog("Items\n" + useItem.getITEM1() + " - heals " + useItem.getSmallHealAmount()  + " amount (" + useItem.getSmallHealItemAmount() + ") left\n" 
						 + useItem.getITEM2() + " - heals " + useItem.getLargeHealAmount() + " amount (" + useItem.getLargeHealItemAmount() + ") left\n" + useItem.getITEM3()
						 + " - revive a teamate to full health(" + useItem.getSenzuAmount() + ") left\n" + useItem.getITEM4() 
						 + " - Increases attack for next three turns (" + useItem.getAttackUpAmount() + ") left\n" + useItem.getITEM5() + " - Increases"
				 		 + " defense for three turns (" + useItem.getDefenseUpAmount() + ") left\n" + useItem.getITEM6() + " - Increases Ki gain for three turns (" 
				         + useItem.getHyperChargeAmount() + ") left\n" + useItem.getITEM7() + " - Prevents momentum"
				 		 + " from decreasing (" + useItem.getStaticMomentumAmount() + ") left");
				if (chosenItem == null)
				{
					chosenItem = "null";
				}
			}
			else if (useItem.getDragonBallAmount() == useItem.getTOTAL_DRAGON_BALLS())
			{
				chosenItem = JOptionPane.showInputDialog("Items\n" + useItem.getITEM1() + " - heals " + useItem.getSmallHealAmount()  + " amount (" + useItem.getSmallHealItemAmount() + ") left\n" 
						 + useItem.getITEM2() + " - heals " + useItem.getLargeHealAmount() + " amount (" + useItem.getLargeHealItemAmount() + ") left\n" + useItem.getITEM3()
						 + " - revive a teamate to full health(" + useItem.getSenzuAmount() + ") left\n" + useItem.getITEM4() 
						 + " - Increases attack for next three turns (" + useItem.getAttackUpAmount() + ") left\n" + useItem.getITEM5() + " - Increases"
				 		 + " defense for three turns (" + useItem.getDefenseUpAmount() + ") left\n" + useItem.getITEM6() + " - Increases Ki gain for three turns (" 
				         + useItem.getHyperChargeAmount() + ") left\n" + useItem.getITEM7() + " - Prevents momentum"
				 		 + " from decreasing (" + useItem.getStaticMomentumAmount() + ") left\nUse " + useItem.getITEM8() + " - Make a wish to power up a character\n" + useItem.getITEM9() 
				 		 + " - Fuse with the Potara Earrings");
				if (chosenItem == null)
				{
					chosenItem = "null";
				}
			}
			else if (useItem.getDragonBallAmount() > useItem.getTOTAL_DRAGON_BALLS())
			{
				chosenItem = JOptionPane.showInputDialog("Items\n" + useItem.getITEM1() + " - heals " + useItem.getSmallHealAmount()  + " amount (" + useItem.getSmallHealItemAmount() + ") left\n" 
						 + useItem.getITEM2() + " - heals " + useItem.getLargeHealAmount() + " amount (" + useItem.getLargeHealItemAmount() + ") left\n" + useItem.getITEM3()
						 + " - revive a teamate to full health(" + useItem.getSenzuAmount() + ") left\n" + useItem.getITEM4() 
						 + " - Increases attack for next three turns (" + useItem.getAttackUpAmount() + ") left\n" + useItem.getITEM5() + " - Increases"
				 		 + " defense for three turns (" + useItem.getDefenseUpAmount() + ") left\n" + useItem.getITEM6() + " - Increases Ki gain for three turns (" 
				         + useItem.getHyperChargeAmount() + ") left\n" + useItem.getITEM7() + " - Prevents momentum"
				 		 + " from decreasing (" + useItem.getStaticMomentumAmount() + ") left\n" + useItem.getITEM9() 
				 		 + " - Fuse with the Potara Earrings");
				if (chosenItem == null)
				{
					chosenItem = "null";
				}
			}
			else
			{
				chosenItem = JOptionPane.showInputDialog("Items\n" + useItem.getITEM1() + " - heals " + useItem.getSmallHealAmount()  + " amount (" + useItem.getSmallHealItemAmount() + ") left\n" 
						 + useItem.getITEM2() + " - heals " + useItem.getLargeHealAmount() + " amount (" + useItem.getLargeHealItemAmount() + ") left\n" + useItem.getITEM3()
						 + " - revive a teamate to full health(" + useItem.getSenzuAmount() + ") left\n" + useItem.getITEM4() 
						 + " - Increases attack for next three turns (" + useItem.getAttackUpAmount() + ") left\n" + useItem.getITEM5() + " - Increases"
				 		 + " defense for three turns (" + useItem.getDefenseUpAmount() + ") left\n" + useItem.getITEM6() + " - Increases Ki gain for three turns (" 
				         + useItem.getHyperChargeAmount() + ") left\n" + useItem.getITEM7() + " - Prevents momentum"
				 		 + " from decreasing (" + useItem.getStaticMomentumAmount() + ") left\n" + useItem.getITEM8() + " - Make a wish to power up a character (" + useItem.getDragonBallAmount()
				 		 + ") found\n" + useItem.getITEM9() + " - Fuse with the Potara Earrings");
				if (chosenItem == null)
				{
					chosenItem = "null";
				}
			}
		}
		else if (boss.toString().equalsIgnoreCase(boss.getPHASE_1_BOSS_NAME()))
		{
			chosenItem = JOptionPane.showInputDialog("Items\n" + useItem.getITEM1() + " - heals " + useItem.getSmallHealAmount()  + " amount (" + useItem.getSmallHealItemAmount() + ") left\n" 
				 + useItem.getITEM2() + " - heals " + useItem.getLargeHealAmount() + " amount (" + useItem.getLargeHealItemAmount() + ") left\n" + useItem.getITEM3()
				 + " - revive a teamate to full health(" + useItem.getSenzuAmount() + ") left\n" + useItem.getITEM4() 
				 + " - Increases attack for next three turns (" + useItem.getAttackUpAmount() + ") left\n" + useItem.getITEM5() + " - Increases"
		 		 + " defense for three turns (" + useItem.getDefenseUpAmount() + ") left\n" + useItem.getITEM6() + " - Increases Ki gain for three turns (" 
		         + useItem.getHyperChargeAmount() + ") left\n" + useItem.getITEM7() + " - Prevents momentum"
		 		 + " from decreasing (" + useItem.getStaticMomentumAmount() + ") left");
			if (chosenItem == null)
			{
				chosenItem = "null";
			}
		}
		else if (useItem.getDragonBallAmount() == useItem.getTOTAL_DRAGON_BALLS())
		{
			chosenItem = JOptionPane.showInputDialog("Items\n" + useItem.getITEM1() + " - heals " + useItem.getSmallHealAmount()  + " amount (" + useItem.getSmallHealItemAmount() + ") left\n" 
					 + useItem.getITEM2() + " - heals " + useItem.getLargeHealAmount() + " amount (" + useItem.getLargeHealItemAmount() + ") left\n" + useItem.getITEM3()
					 + " - revive a teamate to full health(" + useItem.getSenzuAmount() + ") left\n" + useItem.getITEM4() 
					 + " - Increases attack for next three turns (" + useItem.getAttackUpAmount() + ") left\n" + useItem.getITEM5() + " - Increases"
			 		 + " defense for three turns (" + useItem.getDefenseUpAmount() + ") left\n" + useItem.getITEM6() + " - Increases Ki gain for three turns (" 
			         + useItem.getHyperChargeAmount() + ") left\n" + useItem.getITEM7() + " - Prevents momentum"
			 		 + " from decreasing (" + useItem.getStaticMomentumAmount() + ") left\n" + useItem.getITEM8() + " - Make a wish to power up a character");
			if (chosenItem == null)
			{
				chosenItem = "null";
			}
		}
		else if (useItem.getDragonBallAmount() > useItem.getTOTAL_DRAGON_BALLS())
		{
			chosenItem = JOptionPane.showInputDialog("Items\n" + useItem.getITEM1() + " - heals " + useItem.getSmallHealAmount()  + " amount (" + useItem.getSmallHealItemAmount() + ") left\n" 
					 + useItem.getITEM2() + " - heals " + useItem.getLargeHealAmount() + " amount (" + useItem.getLargeHealItemAmount() + ") left\n" + useItem.getITEM3()
					 + " - revive a teamate to full health(" + useItem.getSenzuAmount() + ") left\n" + useItem.getITEM4() 
					 + " - Increases attack for next three turns (" + useItem.getAttackUpAmount() + ") left\n" + useItem.getITEM5() + " - Increases"
			 		 + " defense for three turns (" + useItem.getDefenseUpAmount() + ") left\n" + useItem.getITEM6() + " - Increases Ki gain for three turns (" 
			         + useItem.getHyperChargeAmount() + ") left\n" + useItem.getITEM7() + " - Prevents momentum"
			 		 + " from decreasing (" + useItem.getStaticMomentumAmount() + ") left");
			if (chosenItem == null)
			{
				chosenItem = "null";
			}
		}
		else
		{
			chosenItem = JOptionPane.showInputDialog("Items\n" + useItem.getITEM1() + " - heals " + useItem.getSmallHealAmount()  + " amount (" + useItem.getSmallHealItemAmount() + ") left\n" 
					 + useItem.getITEM2() + " - heals " + useItem.getLargeHealAmount() + " amount (" + useItem.getLargeHealItemAmount() + ") left\n" + useItem.getITEM3()
					 + " - revive a teamate to full health(" + useItem.getSenzuAmount() + ") left\n" + useItem.getITEM4() 
					 + " - Increases attack for next three turns (" + useItem.getAttackUpAmount() + ") left\n" + useItem.getITEM5() + " - Increases"
			 		 + " defense for three turns (" + useItem.getDefenseUpAmount() + ") left\n" + useItem.getITEM6() + " - Increases Ki gain for three turns (" 
			         + useItem.getHyperChargeAmount() + ") left\n" + useItem.getITEM7() + " - Prevents momentum"
			 		 + " from decreasing (" + useItem.getStaticMomentumAmount() + ") left\n" + useItem.getITEM8() + " - Make a wish to power up a character (" + useItem.getDragonBallAmount()
			 		  + ") found");
			if (chosenItem == null)
			{
				chosenItem = "null";
			}
		}
		if (chosenItem.equalsIgnoreCase(useItem.getITEM1()))
		{
			if (useItem.getSmallHealItemAmount() <= 0)
			{
				chosenItem = "null";
				JOptionPane.showMessageDialog(null, "There are no more " + useItem.getITEM1());
			}
		}
		else if (chosenItem.equalsIgnoreCase(useItem.getITEM2()))
		{
			if (useItem.getLargeHealItemAmount() <= 0)
			{
				chosenItem = "null";
				JOptionPane.showMessageDialog(null, "There are no more " + useItem.getITEM2());
			}
		}
		else if (chosenItem.equalsIgnoreCase(useItem.getITEM3()))
		{
			if (useItem.getSenzuAmount() <= 0)
			{
					chosenItem = "null";
					JOptionPane.showMessageDialog(null, "There are no more " + useItem.getITEM3());
			}
			else if (player1.getPlayer1Health() > 0)
			{
				if (player2.getPlayer2Health() > 0)
				{
					if (player3.getPlayer3Health() > 0)
					{
						if (player4.getPlayer4Health() > 0)
						{
								chosenItem = "null";
								JOptionPane.showMessageDialog(null, "There are no dead player.");
						}
					}
				}
			}
		}
		else if (chosenItem.equalsIgnoreCase(useItem.getITEM4()))
		{
			if (useItem.getAttackUpAmount() <= 0)
			{
				chosenItem = "null";
				JOptionPane.showMessageDialog(null, "There are no more " + useItem.getITEM4());
			}
		}
		else if (chosenItem.equalsIgnoreCase(useItem.getITEM5()))
		{
			if (useItem.getDefenseUpAmount() <= 0)
			{
				chosenItem = "null";
				JOptionPane.showMessageDialog(null, "There are no more " + useItem.getITEM5());
			}
		}
		else if (chosenItem.equalsIgnoreCase(useItem.getITEM6()))
		{
			if (useItem.getHyperChargeAmount() <= 0)
			{
				chosenItem = "null";
				JOptionPane.showMessageDialog(null, "There are no more " + useItem.getITEM6());
			}
		}
		else if (chosenItem.equalsIgnoreCase(useItem.getITEM7()))
		{
			if (useItem.getStaticMomentumAmount() <= 0)
			{
				chosenItem = "null";
				JOptionPane.showMessageDialog(null, "There are no more " + useItem.getITEM7());
			}
		}
		else if (chosenItem.equalsIgnoreCase(useItem.getITEM8()))
		{
			if (boss.toString().equalsIgnoreCase(boss.getPHASE_1_BOSS_NAME()))
			{
				JOptionPane.showMessageDialog(null, "Error");
				chosenItem = "null";
			}
			else if (!dragonBalls.isDragonBallsUsable())
			{
				JOptionPane.showMessageDialog(null, "Error");
				chosenItem = "null";
			}
		}
		else if (chosenItem.equalsIgnoreCase(useItem.getITEM9()))
		{
			if (!Items.isPotaras() || !boss.toString().equalsIgnoreCase(boss.getPHASE_3_BOSS_NAME()))
			{
				chosenItem = "null";
				JOptionPane.showMessageDialog(null, "There are no potara earrings");
			}
		}
		else
		{
			chosenItem = "null";
			JOptionPane.showMessageDialog(null, "Error");
		}
		return chosenItem;
	}
	public static String TankClassAction(TankClass tankClass, UltimateTankClass ultimateTank) {
		String playerConfirmation = "no",
			   p2Action = "null";
		Broly phase = new Broly();
		PlayerStatus onePlayer = new PlayerStatus(); 
		do {
			if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()) && !FusedPlayer.isFused() && tankClass.isUltimate())
			{
				p2Action = JOptionPane.showInputDialog("What will " + TankClass.getUltimateTag() + tankClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + ultimateTank.getMOMENTUM_SKILL() + "\nFuse");
				if (p2Action == null)
				{
					p2Action = "null";
				}
			}
			else if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()) && !FusedPlayer.isFused())
			{
				p2Action = JOptionPane.showInputDialog("What will " + TankClass.getUltimateTag() + tankClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + tankClass.getMOMENTUM_SKILL() + "\nFuse");
				if (p2Action == null)
				{
					p2Action = "null";
				}
			}
			else if (tankClass.isUltimate())
			{
				p2Action = JOptionPane.showInputDialog("What will " + TankClass.getUltimateTag() + tankClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + ultimateTank.getMOMENTUM_SKILL());
				if (p2Action == null)
				{
					p2Action = "null";
				}
			}
			else
			{
				p2Action = JOptionPane.showInputDialog("What will " + TankClass.getUltimateTag() + tankClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + tankClass.getMOMENTUM_SKILL());
				if (p2Action == null)
				{
					p2Action = "null";
				}
			}
			if (p2Action.equalsIgnoreCase("Attack"))
			{
				playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
				if (playerConfirmation == null)
				{
					playerConfirmation = "null";
				}
			}
			else if (p2Action.equalsIgnoreCase("SKILL"))
			{
				p2Action = tankClassSkills(tankClass, ultimateTank);
				if (p2Action.equalsIgnoreCase(tankClass.getSkill1()) || p2Action.equalsIgnoreCase(tankClass.getSkill2()))
				{
				}
				else if (tankClass.isUltimate())
				{
					if (p2Action.equalsIgnoreCase(ultimateTank.getSkill1()) || p2Action.equalsIgnoreCase(ultimateTank.getSkill2()))
					{
					}
					else
					{
						p2Action = "null";
					}
				}
				else
				{
					p2Action = "null";
				}
				if (p2Action.equalsIgnoreCase("null"))
				{
					playerConfirmation = "no";
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
			else if (p2Action.equalsIgnoreCase("Items"))
			{
				p2Action = items();
				if (p2Action.equalsIgnoreCase("null"))
				{
					playerConfirmation = "no";
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
			else if (p2Action.equalsIgnoreCase("Defend"))
			{
				playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
				if (playerConfirmation == null)
				{
					playerConfirmation = "null";
				}
			}
			else if (p2Action.equalsIgnoreCase(tankClass.getMOMENTUM_SKILL()))
			{
				if (tankClass.getPlayer2Momentum() >= 100 && !tankClass.isUltimate())
				{
					playerConfirmation = JOptionPane.showInputDialog(tankClass.getMOMENTUM_SKILL()
							+ " - Protect all allies from incoming attack and heals all allies"
							+ "\nAre you sure?\n"
							+ "Yes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankClass.isUltimate())
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You need full momentum to use it");
					playerConfirmation = "no";
				}
			}
			else if (p2Action.equalsIgnoreCase(ultimateTank.getMOMENTUM_SKILL()))
			{
				if (tankClass.isUltimate() && tankClass.getPlayer2Momentum() >= 100)
				{
					playerConfirmation = JOptionPane.showInputDialog(ultimateTank.getMOMENTUM_SKILL()
							+ " - Protect all allies from two attack and heals all allies"
							+ "\nAre you sure?\n"
							+ "Yes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (!tankClass.isUltimate())
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You need full momentum to use it");
					playerConfirmation = "no";
				}
			}
			else if (p2Action.equalsIgnoreCase("Fuse"))
			{
				if (FusedPlayer.isFused())
				{
					JOptionPane.showMessageDialog(null, "There is still an active fusion");
				}
				else if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()))
				{
					if (FusedPlayer.getFusionCooldown() > 0)
					{
						if (FusedPlayer.getFusionCooldown() > 1)
						{
							JOptionPane.showMessageDialog(null, "You need to wait " + FusedPlayer.getFusionCooldown() + " more turns");
							playerConfirmation = "no";
						}
						else
						{
							JOptionPane.showMessageDialog(null, "You need to wait " + FusedPlayer.getFusionCooldown() + " more turn");
							playerConfirmation = "no";
						}
					}
					else if (onePlayer.isOnePlayer())
					{
						JOptionPane.showMessageDialog(null, "There are no other players");
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
			else
			{
				JOptionPane.showMessageDialog(null, "Error");
				playerConfirmation = "no";
			}
		} while (!(playerConfirmation.equalsIgnoreCase("yes")) && (!(playerConfirmation.equalsIgnoreCase("y"))));
		return p2Action;
	}
	public static String tankClassSkills(TankClass tankS, UltimateTankClass ultimateTankS) {
		String tankSkill;
		AttackerClass player1 = new AttackerClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		if (tankS.isUltimate())
		{
			tankSkill = JOptionPane.showInputDialog("Skills\n" + ultimateTankS.getSkill1() + " - Take an attack for an ally and tank half the damage - 200 Ki\n" + 
					ultimateTankS.getSkill2() + " - Heal an ally based on two times damage taken (" + tankS.getDamageTaken() * 2 + ") - 100 Ki");
			if (tankSkill == null)
			{
				tankSkill = "null";
			}
		}
		else
		{
			tankSkill = JOptionPane.showInputDialog("Skills\n" + tankS.getSkill1() + " - Take an attack for an ally - 100 Ki\n" + 
					tankS.getSkill2() + " - Heal an ally based on damage taken (" + tankS.getDamageTaken() + ") - 50 Ki");
			if (tankSkill == null)
			{
				tankSkill = "null";
			}
		}
		if (tankS.getPlayer2ChargeNumber() <= 0)
		{
			if (tankS.isUltimate())
			{
				if (tankS.getPlayer2Ki() < ultimateTankS.getSKILLCOST())
				{
					tankSkill = "null";
					JOptionPane.showMessageDialog(null, "You do not have enough ki");
				}
			}
			else
			{
				if (tankS.getPlayer2Ki() < tankS.getSKILLCOST())
				{
					tankSkill = "null";
					JOptionPane.showMessageDialog(null, "You do not have enough ki");
				}
			}
		}
		if (tankSkill.equalsIgnoreCase(tankS.getSkill1()))
		{
			if (tankS.getPlayer2ChargeNumber() < 1)
			{
				tankSkill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
		}
		if (tankSkill.equalsIgnoreCase(ultimateTankS.getSkill1()))
		{
			if (tankS.getPlayer2ChargeNumber() < 2)
			{
				tankSkill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
		}
		if(player1.getPlayer1Health() <= 0)
		{
			if (player3.getPlayer3Health() <= 0)
			{
				if (player4.getPlayer4Health() <= 0)
				{
					tankSkill = "null";
					JOptionPane.showMessageDialog(null, "This skill is unusable");
				}
			}
		}
		return tankSkill;
	}
	public static String mageClassAction(MageClass mageClass, UltimateMageClass ultimateMage) {
		String playerConfirmation = "no",
				   p3Action = "null";
		Broly phase = new Broly();
		PlayerStatus onePlayer = new PlayerStatus(); 
			do {
				if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()) && !FusedPlayer.isFused() && mageClass.isUltimate())
				{
					p3Action = JOptionPane.showInputDialog("What will " + MageClass.getUltimateTag() + mageClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + ultimateMage.getMOMENTUM_SKILL() + "\nFuse");
					if (p3Action == null)
					{
						p3Action = "null";
					}
				}
				else if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()) && !FusedPlayer.isFused())
				{
					p3Action = JOptionPane.showInputDialog("What will " + MageClass.getUltimateTag() + mageClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + mageClass.getMOMENTUM_SKILL() + "\nFuse");
					if (p3Action == null)
					{
						p3Action = "null";
					}
				}
				else if (mageClass.isUltimate())
				{
					p3Action = JOptionPane.showInputDialog("What will " + MageClass.getUltimateTag() + mageClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + ultimateMage.getMOMENTUM_SKILL());
					if (p3Action == null)
					{
						p3Action = "null";
					}
				}
				else
				{
					p3Action = JOptionPane.showInputDialog("What will " + MageClass.getUltimateTag() + mageClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + mageClass.getMOMENTUM_SKILL());
					if (p3Action == null)
					{
						p3Action = "null";
					}
				}
				if (p3Action.equalsIgnoreCase("Attack"))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (p3Action.equalsIgnoreCase("SKILL"))
				{
					p3Action = mageClassSkills(mageClass, ultimateMage);
					if (p3Action.equalsIgnoreCase(mageClass.getSkill1()) || p3Action.equalsIgnoreCase(mageClass.getSkill2()))
					{
					}
					else if (mageClass.isUltimate())
					{
						if (p3Action.equalsIgnoreCase(ultimateMage.getSkill1()) || p3Action.equalsIgnoreCase(ultimateMage.getSkill2()))
						{
						}
						else
						{
							p3Action = "null";
						}
					}
					else
					{
						p3Action = "null";
					}
					if (p3Action.equalsIgnoreCase("null"))
					{
						playerConfirmation = "no";
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
				else if (p3Action.equalsIgnoreCase("Items"))
				{
					p3Action = items();
					if (p3Action.equalsIgnoreCase("null"))
					{
						playerConfirmation = "no";
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
				else if (p3Action.equalsIgnoreCase("Defend"))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (p3Action.equalsIgnoreCase(mageClass.getMOMENTUM_SKILL()))
				{
					if (mageClass.getPlayer3Momentum() >= 100 && !mageClass.isUltimate())
					{
						playerConfirmation = JOptionPane.showInputDialog(mageClass.getMOMENTUM_SKILL()
								+ " - Gives you max ki and grants all allies increase ki gain for the next"
								+ " turn\nAre you sure?\n"
								+ "Yes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageClass.isUltimate())
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You need full momentum to use it");
						playerConfirmation = "no";
					}
				}
				else if (p3Action.equalsIgnoreCase(ultimateMage.getMOMENTUM_SKILL()))
				{
					if (mageClass.isUltimate() && mageClass.getPlayer3Momentum() >= 100)
					{
						playerConfirmation = JOptionPane.showInputDialog(ultimateMage.getMOMENTUM_SKILL()
								+ " - Gives you max ki and grants all allies increased ki gain for the next"
								+ " three turn\nAre you sure?\n"
								+ "Yes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (!mageClass.isUltimate())
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You need full momentum to use it");
						playerConfirmation = "no";
					}
				}
				else if (p3Action.equalsIgnoreCase("Fuse"))
				{
					if (FusedPlayer.isFused())
					{
						JOptionPane.showMessageDialog(null, "There is still an active fusion");
					}
					else if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()))
					{
						if (FusedPlayer.getFusionCooldown() > 0)
						{
							if (FusedPlayer.getFusionCooldown() > 1)
							{
								JOptionPane.showMessageDialog(null, "You need to wait " + FusedPlayer.getFusionCooldown() + " more turns");
								playerConfirmation = "no";
							}
							else
							{
								JOptionPane.showMessageDialog(null, "You need to wait " + FusedPlayer.getFusionCooldown() + " more turn");
								playerConfirmation = "no";
							}
						}
						else if (onePlayer.isOnePlayer())
						{
							JOptionPane.showMessageDialog(null, "There are no other players");
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
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			} while (!(playerConfirmation.equalsIgnoreCase("yes")) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			return p3Action;
	}
	public static String mageClassSkills(MageClass mageS, UltimateMageClass ultimateMageS) {
		String mageSkill;
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		ItemCrafter player4 = new ItemCrafter();
		Broly kiTest = new Broly();
		if (mageS.isUltimate())
		{
			mageSkill = JOptionPane.showInputDialog("Skills\n" + ultimateMageS.getSkill1() + " - Build up Ki if Broly has more. If Broly has less, grant an"
					+ " ally defense up - 100 Ki\n" + ultimateMageS.getSkill2() + " - Build a"
					+ " ally's momentum based on two times Ki gained (" + mageS.getKiGained() / 20 + ") - 500 Ki");
			if (mageSkill == null)
			{
				mageSkill = "null";
			}
		}
		else
		{
			mageSkill = JOptionPane.showInputDialog("Skills\n" + mageS.getSkill1() + " - Build up Ki if Broly has more. If Broly has less, grant an"
				+ " ally defense up - 50 Ki\n" + mageS.getSkill2() + " - Build a"
				+ " ally's momentum based on Ki gained (" + mageS.getKiGained() / 20 + ") - 300 Ki");
			if (mageSkill == null)
			{
				mageSkill = "null";
			}
		}
		if (mageSkill.equalsIgnoreCase(mageS.getSkill1()) || mageSkill.equalsIgnoreCase(ultimateMageS.getSkill1()))
		{
			if (mageS.getPlayer3ChargeNumber() <= 0)
			{
				if (mageS.isUltimate())
				{
					if (mageS.getPlayer3Ki() < ultimateMageS.getSKILL1COST())
					{
						mageSkill = "null";
						JOptionPane.showMessageDialog(null, "You do not have enough ki");
					}
				}
				else
				{
					if (mageS.getPlayer3Ki() < mageS.getSKILL1COST())
					{
						mageSkill = "null";
						JOptionPane.showMessageDialog(null, "You do not have enough ki");
					}
				}
					
			}
		}
		if (mageSkill.equalsIgnoreCase(mageS.getSkill2()))
		{
			if (mageS.getPlayer3ChargeNumber() < 3)
			{
				mageSkill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
		}
		if (mageSkill.equalsIgnoreCase(ultimateMageS.getSkill2()))
		{
			if (mageS.getPlayer3ChargeNumber() < 5)
			{
				mageSkill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
		}
		if (mageSkill.equalsIgnoreCase(mageS.getSkill2()) || mageSkill.equalsIgnoreCase(ultimateMageS.getSkill2()))
		{
			if(player1.getPlayer1Health() <= 0)
			{
				if (player2.getPlayer2Health() <= 0)
				{
					if (player4.getPlayer4Health() <= 0)
					{
						mageSkill = "null";
						JOptionPane.showMessageDialog(null, "This skill is unusable");
					}
				}
			}
		}
		
		if (mageSkill.equalsIgnoreCase(mageS.getSkill1()) || mageSkill.equalsIgnoreCase(ultimateMageS.getSkill1()))
		{
			if(player1.getPlayer1Health() <= 0)
			{
				if (player2.getPlayer2Health() <= 0)
				{
					if (player4.getPlayer4Health() <= 0)
					{
						if (mageS.getPlayer3ChargeNumber() < kiTest.getBrolyChargeNumber())
						{
						}
						else if (mageS.getPlayer3Ki() < kiTest.getBrolyKi() && mageS.getPlayer3ChargeNumber() == kiTest.getBrolyChargeNumber())
						{
						}
						else
						{
							mageSkill = "null";
							JOptionPane.showMessageDialog(null, "This skill is unusable");
						}
					}
				}
			}
		}
		
		return mageSkill;
	}
	public static String itemCrafterAction(ItemCrafter itemClass, UltimateItemCrafter ultimateItemCrafter) {
		String playerConfirmation = "no",
			   p4Action = "null";
		Broly phase = new Broly();
		PlayerStatus onePlayer = new PlayerStatus(); 
			do {
				if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()) && !FusedPlayer.isFused() && itemClass.isUltimate())
				{
					p4Action = JOptionPane.showInputDialog("What will " + ItemCrafter.getUltimateTag() + itemClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + ultimateItemCrafter.getMOMENTUM_SKILL() + "\nFuse");
					if (p4Action == null)
					{
						p4Action = "null";
					}
				}
				else if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()) && !FusedPlayer.isFused())
				{
					p4Action = JOptionPane.showInputDialog("What will " + ItemCrafter.getUltimateTag() + itemClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + itemClass.getMOMENTUM_SKILL() + "\nFuse");
					if (p4Action == null)
					{
						p4Action = "null";
					}
				}
				else if (itemClass.isUltimate())
				{
					p4Action = JOptionPane.showInputDialog("What will " + ItemCrafter.getUltimateTag() + itemClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + ultimateItemCrafter.getMOMENTUM_SKILL());
					if (p4Action == null)
					{
						p4Action = "null";
					}
				}
				else
				{
					p4Action = JOptionPane.showInputDialog("What will " + ItemCrafter.getUltimateTag() + itemClass + " do?\n\nAttack\nSkill\nItems\nDefend\n" + itemClass.getMOMENTUM_SKILL());
					if (p4Action == null)
					{
						p4Action = "null";
					}
				}
				if (p4Action.equalsIgnoreCase("Attack"))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (p4Action.equalsIgnoreCase("Skill"))
				{
					p4Action = itemCrafterSkills(itemClass, ultimateItemCrafter);
					if (p4Action.equalsIgnoreCase(itemClass.getSkill1()) || p4Action.equalsIgnoreCase(itemClass.getSkill2()))
					{
					}
					else if (itemClass.isUltimate())
					{
						if (p4Action.equalsIgnoreCase(ultimateItemCrafter.getSkill1()) || p4Action.equalsIgnoreCase(ultimateItemCrafter.getSkill2()))
						{
						}
						else
						{
							p4Action = "null";
						}
					}
					else
					{
						p4Action = "null";
					}
					if (p4Action.equalsIgnoreCase("null"))
					{
						playerConfirmation = "no";
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
				else if (p4Action.equalsIgnoreCase("Items"))
				{
					p4Action = items();
					if (p4Action.equalsIgnoreCase("null"))
					{
						playerConfirmation = "no";
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
				else if (p4Action.equalsIgnoreCase("Defend"))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (p4Action.equalsIgnoreCase(itemClass.getMOMENTUM_SKILL()))
				{
					if (itemClass.getPlayer4Momentum() >= 100 && !itemClass.isUltimate())
					{
						playerConfirmation = JOptionPane.showInputDialog(itemClass.getMOMENTUM_SKILL()
								+ " - Progress one stage on all items and produce a senzu"
								+ "\nAre you sure?\n"
								+ "Yes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemClass.isUltimate())
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You need full momentum to use it");
						playerConfirmation = "no";
					}
				}
				else if (p4Action.equalsIgnoreCase(ultimateItemCrafter.getMOMENTUM_SKILL()))
				{
					if (itemClass.isUltimate() || itemClass.getPlayer4Momentum() >= 100)
					{
							playerConfirmation = JOptionPane.showInputDialog(ultimateItemCrafter.getMOMENTUM_SKILL()
									+ " - Boost progress on all items and produce a senzu"
									+ "\nAre you sure?\n"
									+ "Yes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
					}
					else if (!itemClass.isUltimate())
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You need full momentum to use it");
						playerConfirmation = "no";
					}
				}
				else if (p4Action.equalsIgnoreCase("Fuse"))
				{
					if (FusedPlayer.isFused())
					{
						JOptionPane.showMessageDialog(null, "There is still an active fusion");
					}
					else if (phase.toString().equalsIgnoreCase(phase.getPHASE_3_BOSS_NAME()))
					{
						if (FusedPlayer.getFusionCooldown() > 0)
						{
							if (FusedPlayer.getFusionCooldown() > 1)
							{
								JOptionPane.showMessageDialog(null, "You need to wait " + FusedPlayer.getFusionCooldown() + " more turns");
								playerConfirmation = "no";
							}
							else
							{
								JOptionPane.showMessageDialog(null, "You need to wait " + FusedPlayer.getFusionCooldown() + " more turn");
								playerConfirmation = "no";
							}
						}
						else if (onePlayer.isOnePlayer())
						{
							JOptionPane.showMessageDialog(null, "There are no other players");
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
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			} while (!(playerConfirmation.equalsIgnoreCase("yes")) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			return p4Action;
	}
	public static String itemCrafterSkills(ItemCrafter itemCrafterS, UltimateItemCrafter ultimateItemCrafterS) {
		String itemCrafterSkill;
		if (itemCrafterS.isUltimate())
		{
			itemCrafterSkill = JOptionPane.showInputDialog("Skills\n" + ultimateItemCrafterS.getSkill1() + " - Craft an item - 100 Ki\n" + 
					ultimateItemCrafterS.getSkill2() + " - Heal yourself based on crafting progress (" + ItemCrafter.getCraftingProgress() + ")- 100 Ki");
			if (itemCrafterSkill == null)
			{
				itemCrafterSkill = "null";
			}
		}
		else
		{
			itemCrafterSkill = JOptionPane.showInputDialog("Skills\n" + itemCrafterS.getSkill1() + " - Craft an item - 50 Ki\n" + 
					itemCrafterS.getSkill2() + " - Heal yourself based on crafting progress (" + ItemCrafter.getCraftingProgress() + ") - 50 Ki");
			if (itemCrafterSkill == null)
			{
				itemCrafterSkill = "null";
			}
		}
		if (itemCrafterS.getPlayer4ChargeNumber() <= 0)
		{
			if (itemCrafterS.isUltimate())
			{
				if (itemCrafterS.getPlayer4Ki() < ultimateItemCrafterS.getSKILLCOST())
				{
					itemCrafterSkill = "null";
					JOptionPane.showMessageDialog(null, "You do not have enough ki");
				}
			}
			else
			{
				if (itemCrafterS.getPlayer4Ki() < itemCrafterS.getSKILLCOST())
				{
					itemCrafterSkill = "null";
					JOptionPane.showMessageDialog(null, "You do not have enough ki");
				}
			}
		}
		return itemCrafterSkill;
	}
	public static void player1Turn(String attackerTurn, Broly boss, AttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4) {
		int attackerAttack;
		Items usedItem = new Items();
		String playerConfirmation = "no";
		String fusedPlayer1 = "null";
		String fusedPlayer2 = "null";
		String fusionType = "null";
		String playerOutsideOfFusion = "null";
		FusedPlayer fusion = new FusedPlayer();
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
		if (attackerTurn.equalsIgnoreCase("Attack"))
		{
			JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " attacked");
			System.out.println(AttackerClass.getUltimateTag() + player1 + " attacked");
			attackerAttack = boss.reduceBrolyHealth(player1.getPlayerAttack());
			player1.addKi(attackerAttack);
			player1.addMomentum(attackerAttack);
			player1.setDamageDealt();
			boss.addKi(attackerAttack);
		}
		else if (attackerTurn.equalsIgnoreCase(player1.getSkill1()))
		{
			JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " used " + player1.getSkill1());
			System.out.println(AttackerClass.getUltimateTag() + player1 + " used " + player1.getSkill1());
			attackerAttack = boss.reduceBrolyHealth(player1.getFullPowerStrike());
			player1.addMomentum(attackerAttack);
			player1.setDamageDealt();
			boss.addKi(attackerAttack);
		}
		else if (attackerTurn.equalsIgnoreCase(player1.getSkill2()))
		{
			JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " used " + player1.getSkill2());
			System.out.println(AttackerClass.getUltimateTag() + player1 + " used " + player1.getSkill2());
			player1.useHighSpirit();
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM1()))
		{
			if (usedItem.getSmallHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM1() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM2()))
		{
			if (usedItem.getLargeHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM2() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM3()))
		{
			if (usedItem.getSenzuAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = playerOutsideOfFusion;
				}
				else
				{
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM3() + "\nWho do you want to revive?\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" + 
						ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
				if (attackerTurn.equalsIgnoreCase(player2.toString()))
				{
					if (player2.getPlayer2Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
				{
					if (player3.getPlayer3Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM3() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM4()))
		{
			if (usedItem.getAttackUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM5()))
		{
			if (usedItem.getDefenseUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM5() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM6()))
		{
			if (usedItem.getHyperChargeAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM6() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM7()))
		{
			if (usedItem.getStaticMomentumAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM7() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase("Defend"))
		{
			player1.startDefending();
		}
		else if (attackerTurn.equalsIgnoreCase(player1.getMOMENTUM_SKILL()))
		{
			if (FusedPlayer.isFused())
			{
				JOptionPane.showMessageDialog(null, player1 + " used " + player1.getMOMENTUM_SKILL());
				System.out.println(player1 + " used " + player1.getMOMENTUM_SKILL());
				fusion.addKi(player1.getHIGH_SPIRIT_STRIKE_KI_GAIN());
				if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
				{
					if (player2.getPlayer2Health() > 0)
					{
						player2.addKi(player1.getHIGH_SPIRIT_STRIKE_KI_GAIN());
						JOptionPane.showMessageDialog(null, player2 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
						System.out.println(player2 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player3.toString()))
				{
					if (player3.getPlayer3Health() > 0)
					{
						player3.addKi(player1.getHIGH_SPIRIT_STRIKE_KI_GAIN());
						JOptionPane.showMessageDialog(null, player3 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
						System.out.println(player3 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						player4.addKi(player1.getHIGH_SPIRIT_STRIKE_KI_GAIN());
						JOptionPane.showMessageDialog(null, player4 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
						System.out.println(player4 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
					}
				}
				attackerAttack = boss.reduceBrolyHealth(player1.getHighSpiritStrikeDamage());
				player1.addKi(attackerAttack);
				boss.addKi(attackerAttack);
			}
			else
			{
				JOptionPane.showMessageDialog(null, player1 + " used " + player1.getMOMENTUM_SKILL());
				System.out.println(player1 + " used " + player1.getMOMENTUM_SKILL());
				if (player2.getPlayer2Health() > 0)
				{
					player2.addKi(player1.getHIGH_SPIRIT_STRIKE_KI_GAIN());
					JOptionPane.showMessageDialog(null, player2 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
					System.out.println(player2 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
				}
				if (player3.getPlayer3Health() > 0)
				{
					player3.addKi(player1.getHIGH_SPIRIT_STRIKE_KI_GAIN());
					JOptionPane.showMessageDialog(null, player3 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
					System.out.println(player3 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
				}
				if (player4.getPlayer4Health() > 0)
				{
					player4.addKi(player1.getHIGH_SPIRIT_STRIKE_KI_GAIN());
					JOptionPane.showMessageDialog(null, player4 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
					System.out.println(player4 + " gained " + player1.getHIGH_SPIRIT_STRIKE_KI_GAIN() + " ki");
				}
				attackerAttack = boss.reduceBrolyHealth(player1.getHighSpiritStrikeDamage());
				player1.addKi(attackerAttack);
				boss.addKi(attackerAttack);
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM8()))
		{
			if (usedItem.getDragonBallAmount() == usedItem.getTOTAL_DRAGON_BALLS())
			{
				JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " summoned Shenron");
				System.out.println(AttackerClass.getUltimateTag() + player1 + " summoned Shenron");
				usedItem.useDragonBalls(player1, player2, player3, player4);
			}
			else
			{
				JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " is searching for the Dragon Balls");
				System.out.println(AttackerClass.getUltimateTag() + player1 + " is searching for the Dragon Balls");
				usedItem.findDragonBall();
				player1.addKiDragonBalls();
			}
		}
		else if (attackerTurn.equalsIgnoreCase("Fuse"))
		{
			do
			{
			attackerTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (attackerTurn == null)
			{
				attackerTurn = "null";
			}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			attackerTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (attackerTurn == null)
			{
				attackerTurn = "null";
			}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM9()))
		{
			do
			{
			attackerTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (attackerTurn == null)
			{
				attackerTurn = "null";
			}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			attackerTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (attackerTurn == null)
			{
				attackerTurn = "null";
			}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
	}
	public static void player2Turn(String tankTurn, Broly boss, AttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4) {
		Items usedItem = new Items();
		String playerConfirmation = "no";
		int attack = 0;
		String fusedPlayer1 = "null";
		String fusedPlayer2 = "null";
		String fusionType = "null";
		String playerOutsideOfFusion = "null";
		FusedPlayer fusion = new FusedPlayer();
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
		if (tankTurn.equalsIgnoreCase("Attack"))
		{
			JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " attacked");
			System.out.println(TankClass.getUltimateTag() + player2 + " attacked");
			attack = boss.reduceBrolyHealth(player2.getPlayerAttack());
			player2.addKi(attack);
			boss.addKi(attack);
		}
		else if (tankTurn.equalsIgnoreCase(player2.getSkill1()))
		{
			JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " used " + player2.getSkill1());
			System.out.println(TankClass.getUltimateTag() + player2 + " used " + player2.getSkill1());
			player2.activateHumanShieldSkill();
			player1.setHumanShieldTarget();
			player3.setHumanShieldTarget();
			player4.setHumanShieldTarget();
			fusion.setHumanShieldTarget();
		}
		else if (tankTurn.equalsIgnoreCase(player2.getSkill2()))
		{
			player2.useGenkiTransfer();
			do 
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog("Who do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(player2.getDamageTaken());
				player2.resetDamageTaken();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(player2.getDamageTaken());
				player2.resetDamageTaken();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(player2.getDamageTaken());
				player2.resetDamageTaken();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(player2.getDamageTaken());
				player2.resetDamageTaken();
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM1()))
		{
			if (usedItem.getSmallHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + TankClass.getUltimateTag() + player2 + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM1() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM2()))
		{
			if (usedItem.getLargeHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player2.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM2() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM3()))
		{
			if (usedItem.getSenzuAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = playerOutsideOfFusion;
				}
				else
				{
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM3() + "\nWho do you want to revive?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + MageClass.getUltimateTag() + player3 + "\n" + 
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
				{
					if (player3.getPlayer3Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM3() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM4()))
		{
			if (usedItem.getAttackUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (tankTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM5()))
		{
			if (usedItem.getDefenseUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (tankTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM5() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM6()))
		{
			if (usedItem.getHyperChargeAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM6() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM7()))
		{
			if (usedItem.getStaticMomentumAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM7() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase("Defend"))
		{
			player2.startDefending();
		}
		else if (tankTurn.equalsIgnoreCase(player2.getMOMENTUM_SKILL()))
		{
			if (FusedPlayer.isFused())
			{
				player2.activateGenkiShield();
				fusion.increaseHealth(player2.getGENKI_SHIELD_HEAL());
				if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						player1.increaseHealth(player2.getGENKI_SHIELD_HEAL());
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player3.toString()))
				{
					if (player3.getPlayer3Health() > 0)
					{
						player3.increaseHealth(player2.getGENKI_SHIELD_HEAL());
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						player4.increaseHealth(player2.getGENKI_SHIELD_HEAL());
					}
				}
			}
			else
			{
				player2.activateGenkiShield();
				if (player1.getPlayer1Health() > 0)
				{
					player1.increaseHealth(player2.getGENKI_SHIELD_HEAL());
				}
				if (player3.getPlayer3Health() > 0)
				{
					player3.increaseHealth(player2.getGENKI_SHIELD_HEAL());
				}
				if (player4.getPlayer4Health() > 0)
				{
					player4.increaseHealth(player2.getGENKI_SHIELD_HEAL());
				}
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM8()))
		{
			if (usedItem.getDragonBallAmount() == usedItem.getTOTAL_DRAGON_BALLS())
			{
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " summoned Shenron");
				System.out.println(TankClass.getUltimateTag() + player2 + " summoned Shenron");
				usedItem.useDragonBalls(player1, player2, player3, player4);
			}
			else
			{
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " is searching for the Dragon Balls");
				System.out.println(TankClass.getUltimateTag() + player2 + " is searching for the Dragon Balls");
				usedItem.findDragonBall();
				player2.addKiDragonBalls();
			}
		}
		else if (tankTurn.equalsIgnoreCase("Fuse"))
		{
			do
			{
			tankTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (tankTurn == null)
			{
				tankTurn = "null";
			}
					if (tankTurn.equalsIgnoreCase(player1.toString()))
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
					else if (tankTurn.equalsIgnoreCase(player2.toString()))
					{ 
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
					}
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			tankTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (tankTurn == null)
			{
				tankTurn = "null";
			}
					if (tankTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM9()))
		{
			do
			{
			tankTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (tankTurn == null)
			{
				tankTurn = "null";
			}
					if (tankTurn.equalsIgnoreCase(player1.toString()))
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
					else if (tankTurn.equalsIgnoreCase(player2.toString()))
					{ 
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
					}
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			tankTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (tankTurn == null)
			{
				tankTurn = "null";
			}
					if (tankTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
	}
	public static void player3Turn(String mageTurn, Broly boss, AttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4) {
		Items usedItem = new Items();
		String playerConfirmation = "no";
		int attack;
		String fusedPlayer1 = "null";
		String fusedPlayer2 = "null";
		String fusionType = "null";
		String playerOutsideOfFusion = "null";
		FusedPlayer fusion = new FusedPlayer();
		if (FusedPlayer.isFused())
		{
			if (FusedPlayer.getFusionType() == fusion.getAttackTank())
			{
				playerOutsideOfFusion = player4.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getAttackCrafter())
			{
				playerOutsideOfFusion = player2.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getTankCrafter())
			{
				playerOutsideOfFusion = player1.toString();
			}
		}
		if (mageTurn.equalsIgnoreCase("Attack"))
		{
			JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " attacked");
			System.out.println(MageClass.getUltimateTag() + player3 + " attacked");
			attack = boss.reduceBrolyHealth(player3.getPlayerAttack());
			player3.addKi(attack);
			boss.addKi(attack);
		}
		else if (mageTurn.equalsIgnoreCase(player3.getSkill1()))
		{
			JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " used " + player3.getSkill1());
			System.out.println(MageClass.getUltimateTag() + player3 + " used " + player3.getSkill1());
			player3.useRapidGrowth();
			if (player3.getPlayer3Ki() > boss.getBrolyKi())
			{
				if (player3.getPlayer3ChargeNumber() < boss.getBrolyChargeNumber())
				{
					player3.addPlayerChargeNumber(boss.getBrolyChargeNumber());
					player3.addKi(boss.getBrolyKi());
				}
				else
				{
					do 
					{
						if (FusedPlayer.isFused())
						{
							mageTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + fusion + "\n"
									+ playerOutsideOfFusion);
							if (mageTurn == null)
							{
								mageTurn = "null";
							}
							if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
							else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
							{
								if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
										mageTurn = player1.toString();
									}
								}
								else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
										mageTurn = player2.toString();
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
										mageTurn = player4.toString();
									}
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
						mageTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" +
								ItemCrafter.getUltimateTag() + player4);
						if (mageTurn == null)
						{
							mageTurn = "null";
						}
						if (mageTurn.equalsIgnoreCase(player1.toString()))
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
						else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
							}
						}
						else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Error");
							playerConfirmation = "no";
						}
						}
					} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
					if (mageTurn.equalsIgnoreCase(player1.toString()))
					{
						player1.setDefenseUpDuration();
						player3.addMomentum(1000);
					}
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
					{
						player2.setDefenseUpDuration();
						player3.addMomentum(1000);
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
					{
						player4.setDefenseUpDuration();
						player3.addMomentum(1000);
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
					{
						fusion.setDefenseUpDuration();
						player3.addMomentum(1000);
					}
				}
			}
			else if (player3.getPlayer3ChargeNumber() <= boss.getBrolyChargeNumber())
			{
				player3.addPlayerChargeNumber(boss.getBrolyChargeNumber());
				player3.addKi(boss.getBrolyKi());
			}
			else
			{
				do 
				{
					if (FusedPlayer.isFused())
					{
						mageTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + fusion + "\n"
								+ playerOutsideOfFusion);
						if (mageTurn == null)
						{
							mageTurn = "null";
						}
						if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
						else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
						{
							if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
									mageTurn = player1.toString();
								}
							}
							else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
									mageTurn = player2.toString();
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
									mageTurn = player4.toString();
								}
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
					mageTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" +
							ItemCrafter.getUltimateTag() + player4);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (mageTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setDefenseUpDuration();
					player3.addMomentum(1000);
				}
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setDefenseUpDuration();
					player3.addMomentum(1000);
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setDefenseUpDuration();
					player3.addMomentum(1000);
				}
				else if (mageTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setDefenseUpDuration();
					player3.addMomentum(1000);
				}
			}
		}
		else if (mageTurn.equalsIgnoreCase(player3.getSkill2()))
		{
			do 
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog("Who do you want to give momentum to?\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog("Who do you want to give momentum to?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.addMomentumFromMage(player3.getKiGained());
				player3.resetKiGained();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.addMomentumFromMage(player3.getKiGained());
				player3.resetKiGained();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.addMomentumFromMage(player3.getKiGained());
				player3.resetKiGained();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.addMomentumFromMage(player3.getKiGained());
				player3.resetKiGained();
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM1()))
		{
			if (usedItem.getSmallHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + MageClass.getUltimateTag() + player3 + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM1() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM2()))
		{
			if (usedItem.getLargeHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player2.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM2() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM3()))
		{
			if (usedItem.getSenzuAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = playerOutsideOfFusion;
				}
				else
				{
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM3() + "\nWho do you want to revive?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + 
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
				{
					if (player2.getPlayer2Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM3() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM4()))
		{
			if (usedItem.getAttackUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (mageTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setAttackUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseAttackUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setAttackUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseAttackUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString().toLowerCase()))
				{
					player4.setAttackUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseAttackUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(fusion.toString().toLowerCase()))
				{
					fusion.setAttackUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseAttackUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM5()))
		{
			if (usedItem.getDefenseUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (mageTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setDefenseUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseDefenseUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setDefenseUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseDefenseUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setDefenseUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseDefenseUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setDefenseUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseDefenseUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM5() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM6()))
		{
			if (usedItem.getHyperChargeAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setHyperChargeDuration();
				player3.addMomentum(2000);
				usedItem.decreaseHyperChargeAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setHyperChargeDuration();
				player3.addMomentum(2000);
				usedItem.decreaseHyperChargeAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setHyperChargeDuration();
				player3.addMomentum(2000);
				usedItem.decreaseHyperChargeAmount();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setHyperChargeDuration();
				player3.addMomentum(2000);
				usedItem.decreaseHyperChargeAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM6() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM7()))
		{
			if (usedItem.getStaticMomentumAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setStaticMomentumDuration();
				player3.addMomentum(2000);
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setStaticMomentumDuration();
				player3.addMomentum(2000);
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setStaticMomentumDuration();
				player3.addMomentum(2000);
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setStaticMomentumDuration();
				player3.addMomentum(2000);
				usedItem.decreaseStaticMomentumAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM7() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase("Defend"))
		{
			player3.startDefending();
		}
		else if (mageTurn.equalsIgnoreCase(player3.getMOMENTUM_SKILL()))
		{
			if (FusedPlayer.isFused())
			{
				player3.useSharedGrowth();
				fusion.sharedGrowthHyperChargeDuration();
				if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						player1.sharedGrowthHyperChargeDuration();
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
				{
					if (player2.getPlayer2Health() > 0)
					{
						player2.sharedGrowthHyperChargeDuration();
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						player4.sharedGrowthHyperChargeDuration();
					}
				}
			}
			else
			{
				player3.useSharedGrowth();
				if (player1.getPlayer1Health() > 0)
				{
					player1.sharedGrowthHyperChargeDuration();
				}
				if (player2.getPlayer2Health() > 0)
				{
					player2.sharedGrowthHyperChargeDuration();
				}
				if (player4.getPlayer4Health() > 0)
				{
					player4.sharedGrowthHyperChargeDuration();
				}
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM8()))
		{
			if (usedItem.getDragonBallAmount() == usedItem.getTOTAL_DRAGON_BALLS())
			{
				JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " summoned Shenron");
				System.out.println(MageClass.getUltimateTag() + player3 + " summoned Shenron");
				usedItem.useDragonBalls(player1, player2, player3, player4);
			}
			else
			{
				JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " is searching for the Dragon Balls");
				System.out.println(MageClass.getUltimateTag() + player3 + " is searching for the Dragon Balls");
				usedItem.findDragonBall();
				player3.addKiDragonBalls();
			}
		}
		else if (mageTurn.equalsIgnoreCase("Fuse"))
		{
			do
			{
			mageTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (mageTurn == null)
			{
				mageTurn = "null";
			}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			mageTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (mageTurn == null)
			{
				mageTurn = "null";
			}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM9()))
		{
			do
			{
			mageTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (mageTurn == null)
			{
				mageTurn = "null";
			}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			mageTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (mageTurn == null)
			{
				mageTurn = "null";
			}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		}
	public static void player4Turn(String itemCrafterTurn,  Broly boss, AttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4){
		Items usedItem = new Items();
		String playerConfirmation = "no";
		int attack;
		String fusedPlayer1 = "null";
		String fusedPlayer2 = "null";
		String fusionType = "null";
		String playerOutsideOfFusion = "null";
		FusedPlayer fusion = new FusedPlayer();
		if (FusedPlayer.isFused())
		{
			if (FusedPlayer.getFusionType() == fusion.getAttackTank())
			{
				playerOutsideOfFusion = player3.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getAttackMage())
			{
				playerOutsideOfFusion = player2.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getTankMage())
			{
				playerOutsideOfFusion = player1.toString();
			}
		}
		if (itemCrafterTurn.equalsIgnoreCase("Attack"))
		{
			JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + player4 + " attacked");
			System.out.println(ItemCrafter.getUltimateTag() + player4 + " attacked");
			attack = boss.reduceBrolyHealth(player4.getPlayerAttack());
			player4.addKi(attack);
			boss.addKi(attack);
		}
		else if (itemCrafterTurn.equalsIgnoreCase(player4.getSkill1()))
		{
			do
			{
				JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + player4 + " used " + player4.getSkill1());
				System.out.println(ItemCrafter.getUltimateTag() + player4 + " used " + player4.getSkill1());
				itemCrafterTurn = JOptionPane.showInputDialog("Which item do you "
					+ "want to craft?\n" + usedItem.getITEM2() + " - " + player4.getLargeHealProgress()
					+ "%\n" + usedItem.getITEM4() + " - " + player4.getAttackUpProgress()
					+ "%\n" + usedItem.getITEM5() + " - " + player4.getDefenseUpProgress() + "%\n" + 
					usedItem.getITEM6() + " - " + player4.getHyperChargeProgress() + "%\n" + usedItem.getITEM7() + 
					" - " + player4.getStaticMomentumProgress() + "%");
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM2()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM4()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM5()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM6()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM7()))
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
			if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM2()))
			{
				player4.addMomentum(player4.craftLargeHeal());
			}
			else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM4()))
			{
				player4.addMomentum(player4.craftAttackUp());
			}
			else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM5()))
			{
				player4.addMomentum(player4.craftDefenseUp());
			}
			else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM6()))
			{
				player4.addMomentum(player4.craftHyperCharge());
			}
			else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM7()))
			{
		
				player4.addMomentum(player4.craftStaticMomentum());
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(player4.getSkill2()))
		{
			player4.increaseHealth(ItemCrafter.getCraftingProgress());
			ItemCrafter.resetCraftingProgress();
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM1()))
		{
			if (usedItem.getSmallHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + ItemCrafter.getUltimateTag() + player4 + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM1() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM2()))
		{
			if (usedItem.getLargeHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player2.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM2() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM3()))
		{
			if (usedItem.getSenzuAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = playerOutsideOfFusion;
				}
				else
				{
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM3() + "\nWho do you want to revive?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + 
						MageClass.getUltimateTag() + player3);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
				{
					if (player2.getPlayer2Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
				{
					if (player3.getPlayer3Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM3() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM4()))
		{
			if (usedItem.getAttackUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM5()))
		{
			if (usedItem.getDefenseUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM5() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM6()))
		{
			if (usedItem.getHyperChargeAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM6() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM7()))
		{
			if (usedItem.getStaticMomentumAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM7() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase("Defend"))
		{
			player4.startDefending();
		}
		else if (itemCrafterTurn.equalsIgnoreCase(player4.getMOMENTUM_SKILL()))
		{
			player4.useCrafterIntuition();
			player4.setCraftersIntuition();
			player4.craftLargeHeal();
			player4.craftAttackUp();
			player4.craftDefenseUp();
			player4.craftHyperCharge();
			player4.craftStaticMomentum();
			JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + player4 + " crafted "
					+ "a " + usedItem.getITEM3());
			System.out.println(ItemCrafter.getUltimateTag() + player4 + " crafted "
					+ "a " + usedItem.getITEM3());
			usedItem.increaseSenzuHealItemAmount();
			player4.endCraftersIntuition();
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM8()))
		{
			if (usedItem.getDragonBallAmount() == usedItem.getTOTAL_DRAGON_BALLS())
			{
				JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + player4 + " summoned Shenron");
				System.out.println(ItemCrafter.getUltimateTag() + player4 + " summoned Shenron");
				usedItem.useDragonBalls(player1, player2, player3, player4);
			}
			else
			{
				JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + player4 + " is searching for the Dragon Balls");
				System.out.println(ItemCrafter.getUltimateTag() + player4 + " is searching for the Dragon Balls");
				usedItem.findDragonBall();
				player4.addKiDragonBalls();
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase("Fuse"))
		{
			do
			{
			itemCrafterTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (itemCrafterTurn == null)
			{
				itemCrafterTurn = "null";
			}
					if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
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
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			itemCrafterTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (itemCrafterTurn == null)
			{
				itemCrafterTurn = "null";
			}
					if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}	
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM9()))
		{
			do
			{
			itemCrafterTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (itemCrafterTurn == null)
			{
				itemCrafterTurn = "null";
			}
					if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
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
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			itemCrafterTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (itemCrafterTurn == null)
			{
				itemCrafterTurn = "null";
			}
					if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}	
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		}
	public static void brolyRageTurn(Broly rage, AttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4) {
		int brolyAction;
		int damageDealt = 0; 
		boolean validChoice = false;
		int brolyAttack = 0;
		String humanShieldTarget;
		brolyAction = rage.getBrolyAction();
		int target = 0;
		if (brolyAction == 4 || brolyAction == 5 || brolyAction == 6)
		{
			if (rage.getBrolyMomentum() < 100)
			{
				brolyAction = rage.getBrolyActionFailure1();
			}
			else
			{
				JOptionPane.showMessageDialog(null, rage + 
						" used " + rage.getRAGE_ULTIMATE());
				System.out.println(rage + 
						" used " + rage.getRAGE_ULTIMATE());
				brolyAttack = rage.getPlanetCrusherDamage();
				rage.activateUltimate();
				player1.removeHumanShieldTarget();
				player3.removeHumanShieldTarget();
				player4.removeHumanShieldTarget();
				while (!(validChoice) && ((player2.isHumanShieldSkill()))) {
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
				else
				{
					damageDealt = player1.takeDamage(brolyAttack);
					rage.addKi(damageDealt);
					player1.addKi(damageDealt);
					player1.reduceMomentum(damageDealt);
					brolyAttack = rage.getPlanetCrusherDamage();
				}
				if (player2.getPlayer2Health() <= 0)
				{
				}
				else
				{
					damageDealt = player2.takeDamage(brolyAttack);
					rage.addKi(damageDealt);
					player2.addKi(damageDealt);
					brolyAttack = rage.getPlanetCrusherDamage();
				}
				if (player3.getPlayer3Health() <= 0)
				{
				}
				else
				{
					damageDealt = player3.takeDamage(brolyAttack);
					rage.addKi(damageDealt);
					player3.addKi(damageDealt);
					player3.reduceMomentum(damageDealt);
					brolyAttack = rage.getPlanetCrusherDamage();
				}
				if (player4.getPlayer4Health() <= 0)
				{
				}
				else
				{
					damageDealt = player4.takeDamage(brolyAttack);
					rage.addKi(damageDealt);
					player4.addKi(damageDealt);
					player4.reduceMomentum(damageDealt);
				}
				Broly.resetMomentum();
				rage.deactivateUltimate();
			}
		}
		if (brolyAction == 3)
		{
			if (rage.getBrolyChargeNumber() > 0)
			{
				JOptionPane.showMessageDialog(null, rage + " used "
						+ rage.getRAGE_SUPER());
				System.out.println(rage + " used "
						+ rage.getRAGE_SUPER());
				rage.activateSuper();
				brolyAttack = rage.getEnragedShoutDamage();
				do
				{
					target = rage.getTarget();
					if (target == 1)
					{
						if (player1.getPlayer1Health() <= 0)
						{
							validChoice = false;
						}
						else
						{
							damageDealt = player1.takeDamage(brolyAttack);
							rage.addKi(damageDealt);
							player1.addKi(damageDealt);
							player1.reduceMomentum(damageDealt);
							rage.addMomentum(damageDealt);
							rage.deactivateSuper();
							validChoice = true;
						}
					}
					else if (target == 2)
					{
						if (player2.getPlayer2Health() <= 0)
						{
							validChoice = false;
						}
						else
						{
							damageDealt = player2.takeDamage(brolyAttack);
							rage.addKi(damageDealt);
							player2.addKi(damageDealt);
							rage.addMomentum(damageDealt);
							rage.deactivateSuper();
							validChoice = true;
						}
					}
					else if (target == 3)
					{
						if (player3.getPlayer3Health() <= 0)
						{
							validChoice = false;
						}
						else
						{
							damageDealt = player3.takeDamage(brolyAttack);
							rage.addKi(damageDealt);
							player3.addKi(damageDealt);
							player3.reduceMomentum(damageDealt);
							rage.addMomentum(damageDealt);
							rage.deactivateSuper();
							validChoice = true;
						}
					}
					else if (target == 4)
					{
						if (player4.getPlayer4Health() <= 0)
						{
							validChoice = false;
						}
						else
						{
							damageDealt = player4.takeDamage(brolyAttack);
							rage.addKi(damageDealt);
							player4.addKi(damageDealt);
							player4.reduceMomentum(damageDealt);
							rage.addMomentum(damageDealt);
							rage.deactivateSuper();
							validChoice = true;
						}
					}
				} while (!(validChoice));
			}
			else
			{
				brolyAction = rage.getBrolyActionFailure2();
			}
		}
		if (brolyAction == 2)
		{
			JOptionPane.showMessageDialog(null, rage +
					" used " + rage.getRAGE_SKILL());
			System.out.println(rage +
					" used " + rage.getRAGE_SKILL());
			rage.useGiganticPower();
		}
		if (brolyAction == 1)
		{
			JOptionPane.showMessageDialog(null, rage + " used " +
					rage.getRAGE_ATTACK());
			System.out.println(rage + " used " +
					rage.getRAGE_ATTACK());
			brolyAttack = rage.getGiganticChargeRage();
			do
			{
				target = rage.getTarget();
				if (target == 1)
				{
					if (player1.getPlayer1Health() <= 0)
					{
						validChoice = false;
					}
					else
					{
						damageDealt = player1.takeDamage(brolyAttack);
						rage.addKi(damageDealt);
						player1.addKi(damageDealt);
						player1.reduceMomentum(damageDealt);
						rage.addMomentum(damageDealt);
						validChoice = true;
					}
				}
				else if (target == 2)
				{
					if (player2.getPlayer2Health() <= 0)
					{
						validChoice = false;
					}
					else
					{
						damageDealt = player2.takeDamage(brolyAttack);
						rage.addKi(damageDealt);
						player2.addKi(damageDealt);
						rage.addMomentum(damageDealt);
						validChoice = true;
					}
				}
				else if (target == 3)
				{
					if (player3.getPlayer3Health() <= 0)
					{
						validChoice = false;
					}
					else
					{
						damageDealt = player3.takeDamage(brolyAttack);
						rage.addKi(damageDealt);
						player3.addKi(damageDealt);
						player3.reduceMomentum(damageDealt);
						rage.addMomentum(damageDealt);
						validChoice = true;
					}
				}
				else if (target == 4)
				{
					if (player4.getPlayer4Health() <= 0)
					{
						validChoice = false;
					}
					else
					{
						damageDealt = player4.takeDamage(brolyAttack);
						rage.addKi(damageDealt);
						player4.addKi(damageDealt);
						player4.reduceMomentum(damageDealt);
						rage.addMomentum(damageDealt);
						validChoice = true;
					}
				}
			} while (!(validChoice));
		}
	}
	public static void phase2(Broly superSaiyan, AttackerClass user1, TankClass user2, MageClass user3, ItemCrafter user4) {
		PlayerStatus gameOver = new PlayerStatus();
		
		do//This loop runs the game
		{
			if (gameOver.getPlayerStatus())
			{
				playerMenu(superSaiyan, user1, user2, user3, user4);
			}
			if (Broly.getBlasterMeteorBarrierHealth() > 0)
			{
				superSaiyan.reduceBlasterMeteorBarrierHealth();
			}
			if (Broly.getOmegaBlasterHealth() > 0)
			{
				superSaiyan.reduceOmegaBlasterHealth();
			}
			if (gameOver.getPlayerStatus())
			{
				brolySuperSaiyanTurn(superSaiyan, user1, user2, user3, user4, gameOver);
			}
				superSaiyan.setBrolyName();
		} while (superSaiyan.toString().equalsIgnoreCase(superSaiyan.getPHASE_2_BOSS_NAME()) && ((gameOver.getPlayerStatus())));//This condition decides when phase 2 ends
		if (gameOver.getPlayerStatus())
		{
			JOptionPane.showMessageDialog(null, "Broly: AHHHHHHHHHHH!");
			JOptionPane.showMessageDialog(null, "We have to use the fusion technique!");
		}
		phase3(superSaiyan, user1, user2, user3, user4, gameOver);
	}
	public static void ultimatePlayer1Turn(String attackerTurn, Broly boss, UltimateAttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4) {
		AttackerClass antiSoftlock = new AttackerClass();
		int attackerAttack;
		Items usedItem = new Items();
		String playerConfirmation = "no";
		String fusedPlayer1 = "null";
		String fusedPlayer2 = "null";
		String fusionType = "null";
		String playerOutsideOfFusion = "null";
		FusedPlayer fusion = new FusedPlayer();
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
		if (attackerTurn.equalsIgnoreCase("Attack"))
		{
			JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " attacked");
			System.out.println(AttackerClass.getUltimateTag() + player1 + " attacked");
			attackerAttack = boss.reduceBrolyHealth(player1.getPlayerAttack());
			player1.addKi(attackerAttack);
			player1.addMomentum(attackerAttack);
			player1.setDamageDealt();
		}
		else if (attackerTurn.equalsIgnoreCase(player1.getSkill1()) || attackerTurn.equalsIgnoreCase(antiSoftlock.getSkill1()))
		{
			JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " used " + player1.getSkill1());
			System.out.println(AttackerClass.getUltimateTag() + player1 + " used " + player1.getSkill1());
			attackerAttack = boss.reduceBrolyHealth(player1.getLimitBreakingStrike());
			player1.addMomentum(attackerAttack);
			player1.setDamageDealt();
		}
		else if (attackerTurn.equalsIgnoreCase(player1.getSkill2()) || attackerTurn.equalsIgnoreCase(antiSoftlock.getSkill2()))
		{
			JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " used " + player1.getSkill2());
			System.out.println(AttackerClass.getUltimateTag() + player1 + " used " + player1.getSkill2());
			player1.useMaxSpirit();
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM1()))
		{
			if (usedItem.getSmallHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM1() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM2()))
		{
			if (usedItem.getLargeHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM2() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM3()))
		{
			if (usedItem.getSenzuAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = playerOutsideOfFusion;
				}
				else
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM3() + "\nWho do you want to revive?\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" + 
						ItemCrafter.getUltimateTag() + player4);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
				if (attackerTurn.equalsIgnoreCase(player2.toString()))
				{
					if (player2.getPlayer2Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
				{
					if (player3.getPlayer3Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM3() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM4()))
		{
			if (usedItem.getAttackUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM5()))
		{
			if (usedItem.getDefenseUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");if (playerConfirmation == null)
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
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM5() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM6()))
		{
			if (usedItem.getHyperChargeAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}

			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM6() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM7()))
		{
			if (usedItem.getStaticMomentumAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (attackerTurn == null)
					{
						attackerTurn = "null";
					}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (attackerTurn.equalsIgnoreCase(playerOutsideOfFusion))
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
								attackerTurn = player2.toString();
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
								attackerTurn = player3.toString();
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
								attackerTurn = player4.toString();
							}
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
				attackerTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (attackerTurn == null)
				{
					attackerTurn = "null";
				}
				if (attackerTurn.equalsIgnoreCase(player1.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (attackerTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM7() + "s");
			}
		}
		else if (attackerTurn.equalsIgnoreCase("Defend"))
		{
			player1.startDefending();
		}
		else if (attackerTurn.equalsIgnoreCase(player1.getMOMENTUM_SKILL()))
		{
			JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " used " + player1.getMOMENTUM_SKILL());
			System.out.println(AttackerClass.getUltimateTag() + player1 + " used " + player1.getMOMENTUM_SKILL());
			if (player2.getPlayer2Health() > 0)
			{
				player2.addKi(player1.getMAX_SPIRIT_STRIKE_KI_GAIN());
				JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " gained " + player1.getMAX_SPIRIT_STRIKE_KI_GAIN() + " ki");
				System.out.println(TankClass.getUltimateTag() + player2 + " gained " + player1.getMAX_SPIRIT_STRIKE_KI_GAIN() + " ki");
			}
			if (player3.getPlayer3Health() > 0)
			{
				player3.addKi(player1.getMAX_SPIRIT_STRIKE_KI_GAIN());
				JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " gained " + player1.getMAX_SPIRIT_STRIKE_KI_GAIN() + " ki");
				System.out.println(MageClass.getUltimateTag() + player3 + " gained " + player1.getMAX_SPIRIT_STRIKE_KI_GAIN() + " ki");
			}
			if (player4.getPlayer4Health() > 0)
			{
				player4.addKi(player1.getMAX_SPIRIT_STRIKE_KI_GAIN());
				JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + player4 + " gained " + player1.getMAX_SPIRIT_STRIKE_KI_GAIN() + " ki");
				System.out.println(ItemCrafter.getUltimateTag() + player4 + " gained " + player1.getMAX_SPIRIT_STRIKE_KI_GAIN() + " ki");
			}
			attackerAttack = boss.reduceBrolyHealth(player1.getMaxSpiritStrikeDamage());
			player1.addKi(attackerAttack);
			boss.addKi(attackerAttack);
		}
		else if (attackerTurn.equalsIgnoreCase("Fuse"))
		{
			do
			{
			attackerTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (attackerTurn == null)
			{
				attackerTurn = "null";
			}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			attackerTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (attackerTurn == null)
			{
				attackerTurn = "null";
			}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		else if (attackerTurn.equalsIgnoreCase(usedItem.getITEM9()))
		{
			do
			{
			attackerTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (attackerTurn == null)
			{
				attackerTurn = "null";
			}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			attackerTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (attackerTurn == null)
			{
				attackerTurn = "null";
			}
					if (attackerTurn.equalsIgnoreCase(player1.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (attackerTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (attackerTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (attackerTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (attackerTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (attackerTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
	}
	public static void ultimatePlayer2Turn(String tankTurn, Broly boss, AttackerClass player1, UltimateTankClass player2, MageClass player3, ItemCrafter player4) {
		Items usedItem = new Items();
		String playerConfirmation = "no";
		int attack;
		String fusedPlayer1 = "null";
		String fusedPlayer2 = "null";
		String fusionType = "null";
		String playerOutsideOfFusion = "null";
		FusedPlayer fusion = new FusedPlayer();
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
		if (tankTurn.equalsIgnoreCase("Attack"))
		{
			JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " attacked");
			System.out.println(TankClass.getUltimateTag() + player2 + " attacked");
			attack = boss.reduceBrolyHealth(player2.getPlayerAttack());
			player2.addKi(attack);
			boss.addKi(attack);
		}
		else if (tankTurn.equalsIgnoreCase(player2.getSkill1()))
		{
			JOptionPane.showMessageDialog(null, TankClass.getUltimateTag() + player2 + " used " + player2.getSkill1());
			System.out.println(TankClass.getUltimateTag() + player2 + " used " + player2.getSkill1());
			player2.activateHumanShieldSkillUltimate();
			player1.setHumanShieldTarget();
			player3.setHumanShieldTarget();
			player4.setHumanShieldTarget();
			fusion.setHumanShieldTarget();
		}
		else if (tankTurn.equalsIgnoreCase(player2.getSkill2()))
		{
			player2.useGenkiTransfer();
			do 
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog("Who do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(player2.getDamageTaken());
				player2.resetDamageTaken();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(player2.getDamageTaken());
				player2.resetDamageTaken();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(player2.getDamageTaken());
				player2.resetDamageTaken();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(player2.getDamageTaken());
				player2.resetDamageTaken();
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM1()))
		{
			if (usedItem.getSmallHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + TankClass.getUltimateTag() + player2 + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM1() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM2()))
		{
			if (usedItem.getLargeHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player2.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM2() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM3()))
		{
			if (usedItem.getSenzuAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = playerOutsideOfFusion;
				}
				else
				{
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM3() + "\nWho do you want to revive?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + MageClass.getUltimateTag() + player3 + "\n" + 
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
				{
					if (player3.getPlayer3Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM3() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM4()))
		{
			if (usedItem.getAttackUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
				ItemCrafter.getUltimateTag() + player4);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
				if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (tankTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
			}
			}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM5()))
		{
			if (usedItem.getDefenseUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (tankTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (tankTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM5() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM6()))
		{
			if (usedItem.getHyperChargeAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM6() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM7()))
		{
			if (usedItem.getStaticMomentumAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					tankTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (tankTurn == null)
					{
						tankTurn = "null";
					}
					if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (tankTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (tankTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								tankTurn = player1.toString();
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
								tankTurn = player3.toString();
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
								tankTurn = player4.toString();
							}
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
				tankTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (tankTurn == null)
				{
					tankTurn = "null";
				}
				if (tankTurn.equalsIgnoreCase(player2.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (tankTurn.equalsIgnoreCase(player1.toString()))
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
				else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (tankTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM7() + "s");
			}
		}
		else if (tankTurn.equalsIgnoreCase("Defend"))
		{
			player2.startDefending();
		}
		else if (tankTurn.equalsIgnoreCase(player2.getMOMENTUM_SKILL()))
		{
			if (FusedPlayer.isFused())
			{
				player2.activateGenkiShield();
				fusion.increaseHealth(player2.getULTIMATE_GENKI_SHIELD_HEAL());
				if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						player1.increaseHealth(player2.getULTIMATE_GENKI_SHIELD_HEAL());
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player3.toString()))
				{
					if (player3.getPlayer3Health() > 0)
					{
						player3.increaseHealth(player2.getULTIMATE_GENKI_SHIELD_HEAL());
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						player4.increaseHealth(player2.getULTIMATE_GENKI_SHIELD_HEAL());
					}
				}
			}
			else
			{
			player2.activateUltimateGenkiShield();
			if (player1.getPlayer1Health() > 0)
			{
				player1.increaseHealth(player2.getULTIMATE_GENKI_SHIELD_HEAL());
			}
			if (player3.getPlayer3Health() > 0)
			{
				player3.increaseHealth(player2.getULTIMATE_GENKI_SHIELD_HEAL());
			}
			if (player4.getPlayer4Health() > 0)
			{
				player4.increaseHealth(player2.getULTIMATE_GENKI_SHIELD_HEAL());
			}
			}
		}
		else if (tankTurn.equalsIgnoreCase("Fuse"))
		{
			do
			{
			tankTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (tankTurn == null)
			{
				tankTurn = "null";
			}
					if (tankTurn.equalsIgnoreCase(player1.toString()))
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
					else if (tankTurn.equalsIgnoreCase(player2.toString()))
					{ 
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
					}
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			tankTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (tankTurn == null)
			{
				tankTurn = "null";
			}
					if (tankTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		else if (tankTurn.equalsIgnoreCase(usedItem.getITEM9()))
		{
			do
			{
			tankTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (tankTurn == null)
			{
				tankTurn = "null";
			}
					if (tankTurn.equalsIgnoreCase(player1.toString()))
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
					else if (tankTurn.equalsIgnoreCase(player2.toString()))
					{ 
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
					}
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			tankTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (tankTurn == null)
			{
				tankTurn = "null";
			}
					if (tankTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player2.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (tankTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (tankTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (tankTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (tankTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (tankTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
	}
	public static void ultimatePlayer3Turn(String mageTurn, Broly boss, AttackerClass player1, TankClass player2, UltimateMageClass player3, ItemCrafter player4) {
		Items usedItem = new Items();
		String playerConfirmation = "no";
		int attack;
		String fusedPlayer1 = "null";
		String fusedPlayer2 = "null";
		String fusionType = "null";
		String playerOutsideOfFusion = "null";
		FusedPlayer fusion = new FusedPlayer();
		if (FusedPlayer.isFused())
		{
			if (FusedPlayer.getFusionType() == fusion.getAttackTank())
			{
				playerOutsideOfFusion = player4.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getAttackCrafter())
			{
				playerOutsideOfFusion = player2.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getTankCrafter())
			{
				playerOutsideOfFusion = player1.toString();
			}
		}
		if (mageTurn.equalsIgnoreCase("Attack"))
		{
			JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " attacked");
			System.out.println(MageClass.getUltimateTag() + player3 + " attacked");
			attack = boss.reduceBrolyHealth(player3.getPlayerAttack());
			player3.addKi(attack);
			boss.addKi(attack);
		}
		else if (mageTurn.equalsIgnoreCase(player3.getSkill1()))
		{
			JOptionPane.showMessageDialog(null, MageClass.getUltimateTag() + player3 + " used " + player3.getSkill1());
			System.out.println(MageClass.getUltimateTag() + player3 + " used " + player3.getSkill1());
			player3.useExplosiveGrowth();
			if (player3.getPlayer3Ki() > boss.getBrolyKi())
			{
				if (player3.getPlayer3ChargeNumber() < boss.getBrolyChargeNumber())
				{
					player3.addPlayerChargeNumber(boss.getBrolyChargeNumber() * 2);
					player3.addKi(boss.getBrolyKi() * 2);
				}
				else
				{
					do 
					{
						if (FusedPlayer.isFused())
						{
							mageTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + fusion + "\n"
									+ playerOutsideOfFusion);
							if (mageTurn == null)
							{
								mageTurn = "null";
							}
							if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
							else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
							{
								if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
										mageTurn = player1.toString();
									}
								}
								else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
										mageTurn = player2.toString();
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
										mageTurn = player4.toString();
									}
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
						mageTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" +
								ItemCrafter.getUltimateTag() + player4);
						if (mageTurn == null)
						{
							mageTurn = "null";
						}
						if (mageTurn.equalsIgnoreCase(player1.toString()))
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
						else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
							}
						}
						else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Error");
							playerConfirmation = "no";
						}
						}
					} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
					if (mageTurn.equalsIgnoreCase(player1.toString()))
					{
						player1.setDefenseUpDuration();
						player3.addMomentum(2000);
					}
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
					{
						player2.setDefenseUpDuration();
						player3.addMomentum(2000);
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
					{
						player4.setDefenseUpDuration();
						player3.addMomentum(2000);
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
					{
						fusion.setDefenseUpDuration();
						player3.addMomentum(2000);
					}
				}
			}
			else if (player3.getPlayer3ChargeNumber() <= boss.getBrolyChargeNumber())
			{
				player3.addPlayerChargeNumber(boss.getBrolyChargeNumber() * 2);
				player3.addKi(boss.getBrolyKi() * 2);
			}
			else
			{
				do 
				{
					if (FusedPlayer.isFused())
					{
						mageTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + fusion + "\n"
								+ playerOutsideOfFusion);
						if (mageTurn == null)
						{
							mageTurn = "null";
						}
						if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
						else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
						{
							if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
									mageTurn = player1.toString();
								}
							}
							else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
									mageTurn = player2.toString();
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
									mageTurn = player4.toString();
								}
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
					mageTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" +
							ItemCrafter.getUltimateTag() + player4);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (mageTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setDefenseUpDuration();
					player3.addMomentum(2000);
				}
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setDefenseUpDuration();
					player3.addMomentum(2000);
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setDefenseUpDuration();
					player3.addMomentum(2000);
				}
				else if (mageTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setDefenseUpDuration();
					player3.addMomentum(2000);
				}
			}
		}
		else if (mageTurn.equalsIgnoreCase(player3.getSkill2()))
		{
			do 
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog("Who do you want to give momentum to?\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog("Who do you want to give momentum to?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.addMomentumFromMage(player3.getKiGained() * 2);
				player3.resetKiGainedUltimate();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.addMomentumFromMage(player3.getKiGained() * 2);
				player3.resetKiGainedUltimate();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.addMomentumFromMage(player3.getKiGained() * 2);
				player3.resetKiGainedUltimate();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.addMomentumFromMage(player3.getKiGained() * 2);
				player3.resetKiGainedUltimate();
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM1()))
		{
			if (usedItem.getSmallHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + MageClass.getUltimateTag() + player3 + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM1() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM2()))
		{
			if (usedItem.getLargeHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player2.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM2() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM3()))
		{
			if (usedItem.getSenzuAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = playerOutsideOfFusion;
				}
				else
				{
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM3() + "\nWho do you want to revive?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + 
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
				{
					if (player2.getPlayer2Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM3() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM4()))
		{
			if (usedItem.getAttackUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
							ItemCrafter.getUltimateTag() + player4);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (mageTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setAttackUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseAttackUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setAttackUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseAttackUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setAttackUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseAttackUpAmount();
				}
				else if (mageTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setAttackUpDuration();
					player3.addMomentum(2000);
					usedItem.decreaseAttackUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
			}
	}
	else if (mageTurn.equalsIgnoreCase(usedItem.getITEM5()))
	{
		if (usedItem.getDefenseUpAmount() > 0)
		{
		do
		{
			if (FusedPlayer.isFused())
			{
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
						+ playerOutsideOfFusion);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
				else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
				{
					if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
							mageTurn = player1.toString();
						}
					}
					else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
							mageTurn = player2.toString();
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
							mageTurn = player4.toString();
						}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setDefenseUpDuration();
				player3.addMomentum(2000);
				usedItem.decreaseDefenseUpAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setDefenseUpDuration();
				player3.addMomentum(2000);
				usedItem.decreaseDefenseUpAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setDefenseUpDuration();
				usedItem.decreaseDefenseUpAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setDefenseUpDuration();
				player3.addMomentum(2000);
				usedItem.decreaseDefenseUpAmount();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setDefenseUpDuration();
				player3.addMomentum(2000);
				usedItem.decreaseDefenseUpAmount();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM5() + "s");
		}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM6()))
		{
			if (usedItem.getHyperChargeAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setHyperChargeDuration();
				player3.addMomentum(2000);
				usedItem.decreaseHyperChargeAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setHyperChargeDuration();
				player3.addMomentum(2000);
				usedItem.decreaseHyperChargeAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setHyperChargeDuration();
				player3.addMomentum(2000);
				usedItem.decreaseHyperChargeAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				fusion.setHyperChargeDuration();
				player3.addMomentum(2000);
				usedItem.decreaseHyperChargeAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM6() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM7()))
		{
			if (usedItem.getStaticMomentumAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					mageTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + MageClass.getUltimateTag() + player3 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (mageTurn == null)
					{
						mageTurn = "null";
					}
					if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (mageTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								mageTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								mageTurn = player2.toString();
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
								mageTurn = player4.toString();
							}
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
				mageTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (mageTurn == null)
				{
					mageTurn = "null";
				}
				if (mageTurn.equalsIgnoreCase(player3.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (mageTurn.equalsIgnoreCase(player1.toString()))
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
				else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setStaticMomentumDuration();
				player3.addMomentum(2000);
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setStaticMomentumDuration();
				player3.addMomentum(2000);
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setStaticMomentumDuration();
				player3.addMomentum(2000);
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (mageTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setStaticMomentumDuration();
				player3.addMomentum(2000);
				usedItem.decreaseStaticMomentumAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM7() + "s");
			}
		}
		else if (mageTurn.equalsIgnoreCase("Defend"))
		{
			player3.startDefending();
		}
		else if (mageTurn.equalsIgnoreCase(player3.getMOMENTUM_SKILL()))
		{
			if (FusedPlayer.isFused())
			{
				player3.useContagiousGrowth();
				fusion.contagiousGrowthHyperChargeDuration();
				if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						player1.contagiousGrowthHyperChargeDuration();
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
				{
					if (player2.getPlayer2Health() > 0)
					{
						player2.contagiousGrowthHyperChargeDuration();
					}
				}
				else if (playerOutsideOfFusion.equalsIgnoreCase(player4.toString()))
				{
					if (player4.getPlayer4Health() > 0)
					{
						player4.contagiousGrowthHyperChargeDuration();
					}
				}
			}
			else
			{
				player3.useContagiousGrowth();
				if (player1.getPlayer1Health() > 0)
				{
					player1.contagiousGrowthHyperChargeDuration();
				}
				if (player2.getPlayer2Health() > 0)
				{
					player2.contagiousGrowthHyperChargeDuration();
				}
				if (player4.getPlayer4Health() > 0)
				{
					player4.contagiousGrowthHyperChargeDuration();
				}
			}
		}
		else if (mageTurn.equalsIgnoreCase("Fuse"))
		{
			do
			{
			mageTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (mageTurn == null)
			{
				mageTurn = "null";
			}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			mageTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (mageTurn == null)
			{
				mageTurn = "null";
			}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		else if (mageTurn.equalsIgnoreCase(usedItem.getITEM9()))
		{
			do
			{
			mageTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (mageTurn == null)
			{
				mageTurn = "null";
			}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			mageTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (mageTurn == null)
			{
				mageTurn = "null";
			}
					if (mageTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player3.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (mageTurn.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (mageTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (mageTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (mageTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (mageTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
	}
	public static void ultimatePlayer4Turn(String itemCrafterTurn,  Broly boss, AttackerClass player1, TankClass player2, MageClass player3, UltimateItemCrafter player4) {
		Items usedItem = new Items();
		String playerConfirmation = "no";
		int attack;
		String fusedPlayer1 = "null";
		String fusedPlayer2 = "null";
		String fusionType = "null";
		String playerOutsideOfFusion = "null";
		FusedPlayer fusion = new FusedPlayer();
		if (FusedPlayer.isFused())
		{
			if (FusedPlayer.getFusionType() == fusion.getAttackTank())
			{
				playerOutsideOfFusion = player3.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getAttackMage())
			{
				playerOutsideOfFusion = player2.toString();
			}
			else if (FusedPlayer.getFusionType() == fusion.getTankMage())
			{
				playerOutsideOfFusion = player1.toString();
			}
		}
		if (itemCrafterTurn.equalsIgnoreCase("Attack"))
		{
			JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + player4 + " attacked");
			System.out.println(ItemCrafter.getUltimateTag() + player4 + " attacked");
			attack = boss.reduceBrolyHealth(player4.getPlayerAttack());
			player4.addKi(attack);
			boss.addKi(attack);
		}
		else if (itemCrafterTurn.equalsIgnoreCase(player4.getSkill1()))
		{
			do
			{
				JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + player4 + " used " + player4.getSkill1());
				System.out.println(ItemCrafter.getUltimateTag() + player4 + " used " + player4.getSkill1());
				itemCrafterTurn = JOptionPane.showInputDialog("Which item do you "
					+ "want to craft?\n" + usedItem.getITEM2() + " - " + player4.getLargeHealProgress()
					+ "%\n" + usedItem.getITEM4() + " - " + player4.getAttackUpProgress()
					+ "%\n" + usedItem.getITEM5() + " - " + player4.getDefenseUpProgress() + "%\n" + 
					usedItem.getITEM6() + " - " + player4.getHyperChargeProgress() + "%\n" + usedItem.getITEM7() + 
					" - " + player4.getStaticMomentumProgress() + "%");
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM2()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM4()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM5()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM6()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM7()))
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
			if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM2()))
			{
				player4.addMomentum(player4.craftLargeHeal());
			}
			else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM4()))
			{
				player4.addMomentum(player4.craftAttackUp());
			}
			else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM5()))
			{
				player4.addMomentum(player4.craftDefenseUp());
			}
			else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM6()))
			{
				player4.addMomentum(player4.craftHyperCharge());
			}
			else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM7()))
			{
		
				player4.addMomentum(player4.craftStaticMomentum());
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(player4.getSkill2()))
		{
			player4.increaseHealth(ItemCrafter.getCraftingProgress());
			ItemCrafter.resetCraftingProgress();
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM1()))
		{
			if (usedItem.getSmallHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + ItemCrafter.getUltimateTag() + player4 + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM1() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM2()))
		{
			if (usedItem.getLargeHealItemAmount() > 0)
			{
			do 
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player2.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				fusion.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM2() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM3()))
		{
			if (usedItem.getSenzuAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = playerOutsideOfFusion;
				}
				else
				{
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM3() + "\nWho do you want to revive?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + 
						MageClass.getUltimateTag() + player3);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
				{
					if (player1.getPlayer1Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
				{
					if (player2.getPlayer2Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
				{
					if (player3.getPlayer3Health() > 0)
					{
						playerConfirmation = "no";
						JOptionPane.showMessageDialog(null, "This player is alive");
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
					playerConfirmation = "no";
					JOptionPane.showMessageDialog(null, "Error");
				}
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM3() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM4()))
		{
			if (usedItem.getAttackUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
							ItemCrafter.getUltimateTag() + player4);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
			}
			}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM5()))
		{
			if (usedItem.getDefenseUpAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
							ItemCrafter.getUltimateTag() + player4);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
				{
					player1.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
				{
					player3.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
				else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setDefenseUpDuration();
					usedItem.decreaseDefenseUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM5() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM6()))
		{
			if (usedItem.getHyperChargeAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setHyperChargeDuration();
				usedItem.decreaseHyperChargeAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM6() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM7()))
		{
			if (usedItem.getStaticMomentumAmount() > 0)
			{
			do
			{
				if (FusedPlayer.isFused())
				{
					itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + ItemCrafter.getUltimateTag() + player4 + "\n" + fusion + "\n"
							+ playerOutsideOfFusion);
					if (itemCrafterTurn == null)
					{
						itemCrafterTurn = "null";
					}
					if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
						if (playerConfirmation == null)
						{
							playerConfirmation = "null";
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(playerOutsideOfFusion))
					{
						if (playerOutsideOfFusion.equalsIgnoreCase(player1.toString()))
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
								itemCrafterTurn = player1.toString();
							}
						}
						else if (playerOutsideOfFusion.equalsIgnoreCase(player2.toString()))
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
								itemCrafterTurn = player2.toString();
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
								itemCrafterTurn = player3.toString();
							}
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
				itemCrafterTurn = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (itemCrafterTurn == null)
				{
					itemCrafterTurn = "null";
				}
				if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
				else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				player1.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				player3.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			else if (itemCrafterTurn.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setStaticMomentumDuration();
				usedItem.decreaseStaticMomentumAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM7() + "s");
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase("Defend"))
		{
			player4.startDefending();
		}
		else if (itemCrafterTurn.equalsIgnoreCase(player4.getMOMENTUM_SKILL()))
		{
			player4.useKnowledgeOfTheUniverse();
			player4.setCraftersIntuition();
			player4.craftLargeHeal();
			player4.craftAttackUp();
			player4.craftDefenseUp();
			player4.craftHyperCharge();
			player4.craftStaticMomentum();
			JOptionPane.showMessageDialog(null, ItemCrafter.getUltimateTag() + player4 + " crafted "
					+ "a " + usedItem.getITEM3());
			System.out.println(ItemCrafter.getUltimateTag() + player4 + " crafted "
					+ "a " + usedItem.getITEM3());
			usedItem.increaseSenzuHealItemAmount();
			player4.endCraftersIntuition();
		}
		else if (itemCrafterTurn.equalsIgnoreCase("Fuse"))
		{
			do
			{
			itemCrafterTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (itemCrafterTurn == null)
			{
				itemCrafterTurn = "null";
			}
					if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
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
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			itemCrafterTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (itemCrafterTurn == null)
			{
				itemCrafterTurn = "null";
			}
					if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}	
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
		else if (itemCrafterTurn.equalsIgnoreCase(usedItem.getITEM9()))
		{
			do
			{
			itemCrafterTurn = JOptionPane.showInputDialog("Pick the first player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (itemCrafterTurn == null)
			{
				itemCrafterTurn = "null";
			}
					if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
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
						}
					}
					else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
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
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer1 = "Attack";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer1 = "Tank";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer1 = "Mage";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer1 = "Item";
			}
			do
			{
			itemCrafterTurn = JOptionPane.showInputDialog("Pick the second player to be fused\n" + AttackerClass.getUltimateTag() + player1 + "\n" + TankClass.getUltimateTag() + player2 + "\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (itemCrafterTurn == null)
			{
				itemCrafterTurn = "null";
			}
					if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Attack"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (fusedPlayer1.equalsIgnoreCase("Tank"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() <= 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is dead");
						}	
						else if (fusedPlayer1.equalsIgnoreCase("Mage"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
					else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
					{
						if (fusedPlayer1.equalsIgnoreCase("Item"))
						{
							JOptionPane.showMessageDialog(null, "This player is already in the fusion");
							playerConfirmation = "no";
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
			if (itemCrafterTurn.equalsIgnoreCase(player1.toString()))
			{
				fusedPlayer2 = "Attack";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player2.toString()))
			{
				fusedPlayer2 = "Tank";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player3.toString()))
			{
				fusedPlayer2 = "Mage";
			}
			else if (itemCrafterTurn.equalsIgnoreCase(player4.toString()))
			{
				fusedPlayer2 = "Item";
			}
			fusionType = fusedPlayer1 + fusedPlayer2;
			switch (fusionType)
			{
			case "AttackTank":
			case "TankAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(12);
				FusedPlayer.setName(player1.toString(), player2.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player2.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player2.getPLAYERMINATTACK());
				break;
			}
			case "AttackMage":
			case "MageAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(13);
				FusedPlayer.setName(player1.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "AttackItem":
			case "ItemAttack":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(14);
				FusedPlayer.setName(player1.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player1.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player1.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "TankMage":
			case "MageTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(23);
				FusedPlayer.setName(player2.toString(), player3.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player3.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player3.getPLAYERMINATTACK());
				break;
			}
			case "TankItem":
			case "ItemTank":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(24);
				FusedPlayer.setName(player2.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player2.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player2.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			case "MageItem":
			case "ItemMage":
			{
				FusedPlayer.setPotaraFusion();
				FusedPlayer.setFusionType(34);
				FusedPlayer.setName(player3.toString(), player4.toString());
				FusedPlayer.setMaxHealth(player3.getMAX_HEALTH(), player4.getMAX_HEALTH());
				FusedPlayer.setMinimumAttack(player3.getPLAYERMINATTACK(), player4.getPLAYERMINATTACK());
				break;
			}
			}
		}
	}
	public static void brolySuperSaiyanTurn(Broly superSaiyan, AttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4, PlayerStatus onePlayer) {
		int brolyAction;
		int damageDealt = 0; 
		boolean validChoice = false;
		int brolyAttack = 0;
		String humanShieldTarget = "null";
		brolyAction = superSaiyan.getBrolyAction();
		int target = 0;
		int target1 = 0;
		int target2 = 0;
		String target1Name = "null",
				target2Name = "";
		boolean player2Target1 = false,
		player2Target2 = false;
		UltimateAttackerClass ultimate1 = new UltimateAttackerClass();
		UltimateTankClass ultimate2 = new UltimateTankClass();
		UltimateMageClass ultimate3 = new UltimateMageClass();
		UltimateItemCrafter ultimate4 = new UltimateItemCrafter();
		if (brolyAction == 4 || brolyAction == 5 || brolyAction == 6)
		{
			if (superSaiyan.getBrolyMomentum() < 100)
			{
				brolyAction = superSaiyan.getBrolyActionFailure1();
			}
			else
			{
				JOptionPane.showMessageDialog(null, superSaiyan + 
						" used " + superSaiyan.getSUPER_SAIYAN_ULTIMATE());
				System.out.println(superSaiyan + 
						" used " + superSaiyan.getSUPER_SAIYAN_ULTIMATE());
				brolyAttack = superSaiyan.getBlasterMeteorDamage();
				Broly.activateBrolySuperUltimate();
				player1.removeHumanShieldTarget();
				player3.removeHumanShieldTarget();
				player4.removeHumanShieldTarget();
				superSaiyan.activateBlasterMeteorBarrier();
				while (!(validChoice) && ((player2.isHumanShieldSkill()))) {
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
					damageDealt = ultimate1.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate1.addKi(damageDealt);
					ultimate1.reduceMomentum(damageDealt);
					brolyAttack = superSaiyan.getBlasterMeteorDamage();
				}
				else
				{
					damageDealt = player1.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player1.addKi(damageDealt);
					player1.reduceMomentum(damageDealt);
					brolyAttack = superSaiyan.getBlasterMeteorDamage();
				}
				if (player2.getPlayer2Health() <= 0)
				{
				}
				else if (player2.isUltimate())
				{
					damageDealt = ultimate2.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate2.addKi(damageDealt);
					brolyAttack = superSaiyan.getBlasterMeteorDamage();
				}
				else
				{
					damageDealt = player2.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player2.addKi(damageDealt);
					brolyAttack = superSaiyan.getBlasterMeteorDamage();
				}
				if (player3.getPlayer3Health() <= 0)
				{
				}
				else if (player3.isUltimate())
				{
					damageDealt = ultimate3.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate3.addKi(damageDealt);
					ultimate3.reduceMomentum(damageDealt);
					brolyAttack = superSaiyan.getBlasterMeteorDamage();
				}
				else
				{
					damageDealt = player3.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player3.addKi(damageDealt);
					player3.reduceMomentum(damageDealt);
					brolyAttack = superSaiyan.getBlasterMeteorDamage();
				}
				if (player4.getPlayer4Health() <= 0)
				{
				}
				else if (player4.isUltimate())
				{
					damageDealt = ultimate4.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate4.addKi(damageDealt);
					ultimate4.reduceMomentum(damageDealt);
				}
				else
				{
					damageDealt = player4.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player4.addKi(damageDealt);
					player4.reduceMomentum(damageDealt);
				}
				Broly.resetMomentum();
			}
			Broly.deactivateBrolySuperUltimate();
		}
		if (brolyAction == 3)
		{
			if (superSaiyan.getBrolyChargeNumber() > 2)
			{
				JOptionPane.showMessageDialog(null, superSaiyan +
						" used " + superSaiyan.getSUPER_SAIYAN_SKILL());
				System.out.println(superSaiyan +
						" used " + superSaiyan.getSUPER_SAIYAN_SKILL());
				superSaiyan.activateOmegaBlaster();
			}
			else
			{
				brolyAction = superSaiyan.getBrolyActionFailure2();
			}
		}
		if (brolyAction == 2)
		{
			if (superSaiyan.getBrolyChargeNumber() > 1)
			{
				JOptionPane.showMessageDialog(null, superSaiyan + " used "
						+ superSaiyan.getSUPER_SAIYAN_SUPER());
				System.out.println(superSaiyan + " used "
						+ superSaiyan.getSUPER_SAIYAN_SUPER());
				superSaiyan.activateUltimate();
				brolyAttack = superSaiyan.getBlasterCannonDamage();
				do
				{
					target = superSaiyan.getTarget();
					if (target == 1)
					{
						if (player1.getPlayer1Health() <= 0)
						{
							validChoice = false;
						}
						else if (player1.isUltimate())
						{
							damageDealt = ultimate1.takeDamage(brolyAttack);
							superSaiyan.addKi(damageDealt);
							ultimate1.addKi(damageDealt);
							ultimate1.reduceMomentum(damageDealt);
							superSaiyan.addMomentum(damageDealt);
							superSaiyan.deactivateUltimate();
							validChoice = true;
						}
						else
						{
							damageDealt = player1.takeDamage(brolyAttack);
							superSaiyan.addKi(damageDealt);
							player1.addKi(damageDealt);
							player1.reduceMomentum(damageDealt);
							superSaiyan.addMomentum(damageDealt);
							superSaiyan.deactivateUltimate();
							validChoice = true;
						}
					}
					else if (target == 2)
					{
						if (player2.getPlayer2Health() <= 0)
						{
							validChoice = false;
						}
						else if (player2.isUltimate())
						{
							damageDealt = ultimate2.takeDamage(brolyAttack);
							superSaiyan.addKi(damageDealt);
							ultimate2.addKi(damageDealt);
							superSaiyan.addMomentum(damageDealt);
							superSaiyan.deactivateUltimate();
							validChoice = true;
						}
						else
						{
							damageDealt = player2.takeDamage(brolyAttack);
							superSaiyan.addKi(damageDealt);
							player2.addKi(damageDealt);
							superSaiyan.addMomentum(damageDealt);
							superSaiyan.deactivateUltimate();
							validChoice = true;
						}
					}
					else if (target == 3)
					{
						if (player3.getPlayer3Health() <= 0)
						{
							validChoice = false;
						}
						else if (player3.isUltimate())
						{
							damageDealt = ultimate3.takeDamage(brolyAttack);
							superSaiyan.addKi(damageDealt);
							ultimate3.addKi(damageDealt);
							ultimate3.reduceMomentum(damageDealt);
							superSaiyan.addMomentum(damageDealt);
							superSaiyan.deactivateUltimate();
							validChoice = true;
						}
						else
						{
							damageDealt = player3.takeDamage(brolyAttack);
							superSaiyan.addKi(damageDealt);
							player3.addKi(damageDealt);
							player3.reduceMomentum(damageDealt);
							superSaiyan.addMomentum(damageDealt);
							superSaiyan.deactivateUltimate();
							validChoice = true;
						}
					}
					else if (target == 4)
					{
						if (player4.getPlayer4Health() <= 0)
						{
							validChoice = false;
						}
						else if (player4.isUltimate())
						{
							damageDealt = ultimate4.takeDamage(brolyAttack);
							superSaiyan.addKi(damageDealt);
							ultimate4.addKi(damageDealt);
							ultimate4.reduceMomentum(damageDealt);
							superSaiyan.addMomentum(damageDealt);
							superSaiyan.deactivateUltimate();
							validChoice = true;
						}
						else
						{
							damageDealt = player4.takeDamage(brolyAttack);
							superSaiyan.addKi(damageDealt);
							player4.addKi(damageDealt);
							player4.reduceMomentum(damageDealt);
							superSaiyan.addMomentum(damageDealt);
							superSaiyan.deactivateUltimate();
							validChoice = true;
						}
					}
				} while (!(validChoice));
			}
			else
			{
				brolyAction = superSaiyan.getBrolyActionFailure3();
			}
		}
		if (brolyAction == 1)
		{
			JOptionPane.showMessageDialog(null, superSaiyan + " used " +
					superSaiyan.getSUPER_SAIYAN_ATTACK());
			System.out.println(superSaiyan + " used " +
					superSaiyan.getSUPER_SAIYAN_ATTACK());
			brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
			superSaiyan.activateSuper();
			do
			{
				target1 = superSaiyan.getTarget();
				if (target1 == 1)
				{
					if (player1.getPlayer1Health() <= 0)
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target1Name = player1.toString();
					}
				}
				else if (target1 == 2)
				{
					if (player2.getPlayer2Health() <= 0)
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target1Name = player2.toString();
						player2Target1 = true;
					}
				}
				else if (target1 == 3)
				{
					if (player3.getPlayer3Health() <= 0)
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target1Name = player3.toString();
					}
				}
				else if (target1 == 4)
				{
					if (player4.getPlayer4Health() <= 0)
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target1Name = player4.toString();
					}
				}
			} while (!(validChoice));
			validChoice = false;
			while (!validChoice && !onePlayer.isOnePlayer())
			{
				target2 = superSaiyan.getTarget();
				if (target2 == 1)
				{
					if (player1.getPlayer1Health() <= 0 || target1 == 1)
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target2Name = player1.toString();
					}
				}
				else if (target2 == 2)
				{
					if (player2.getPlayer2Health() <= 0 || target1 == 2)
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target2Name = player2.toString();
						player2Target2 = true;
					}
				}
				else if (target2 == 3)
				{
					if (player3.getPlayer3Health() <= 0 || target1 == 3)
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target2Name = player3.toString();
					}
				}
				else if (target2 == 4)
				{
					if (player4.getPlayer4Health() <= 0 || target1 == 4)
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target2Name = player4.toString();
					}
				}
			}
			validChoice = false;
			if (player2.isHumanShieldSkill())
			{
				player1.removeHumanShieldTarget();
				player3.removeHumanShieldTarget();
				player4.removeHumanShieldTarget();
				do 
				{
					if (player2Target1 && onePlayer.isOnePlayer())
					{
						validChoice = true;
					}
					else if (player2Target1)
					{
						humanShieldTarget = target2Name;
					}
					else if (player2Target2)
					{
						humanShieldTarget = target1Name;
					}
					else
					{
						humanShieldTarget = JOptionPane.showInputDialog("Who do you want to protect?\n" 
							+ target1Name + "\n" + target2Name);
						if (humanShieldTarget == null)
						{
							humanShieldTarget = "null";
						}
					}
					if (humanShieldTarget.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (target1 != 1 && target2 != 1)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, player1 + " is not being attacked");
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
						else if (target1 != 3 && target2 != 3)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, player3 + " is not being attacked");
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
						else if (target1 != 4 && target2 != 4)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, player4 + " is not being attacked");
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
				} while (!validChoice);
			} 
			if (target1 == 1)
			{
				if (player1.isUltimate())
				{
					damageDealt = ultimate1.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate1.addKi(damageDealt);
					ultimate1.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
				else 
				{
					damageDealt = player1.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player1.addKi(damageDealt);
					player1.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
			}
			else if (target1 == 2)
			{
				if (player2.isUltimate())
				{
					damageDealt = ultimate2.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate2.addKi(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
				else 
				{
					damageDealt = player2.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player2.addKi(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
			}
			else if (target1 == 3)
			{
				if (player3.isUltimate())
				{
					damageDealt = ultimate3.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate3.addKi(damageDealt);
					ultimate3.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
				else 
				{
					damageDealt = player3.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player3.addKi(damageDealt);
					player3.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
			}
			else
			{
				if (player4.isUltimate())
				{
					damageDealt = ultimate4.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate4.addKi(damageDealt);
					ultimate4.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
				else 
				{
					damageDealt = player4.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player4.addKi(damageDealt);
					player4.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
			}
			if (target2 == 1)
			{
				if (player1.isUltimate())
				{
					damageDealt = ultimate1.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate1.addKi(damageDealt);
					ultimate1.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
				else 
				{
					damageDealt = player1.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player1.addKi(damageDealt);
					player1.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
			}
			else if (target2 == 2)
			{
				if (player2.isUltimate())
				{
					damageDealt = ultimate2.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate2.addKi(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
				else 
				{
					damageDealt = player2.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player2.addKi(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
			}
			else if (target2 == 3)
			{
				if (player3.isUltimate())
				{
					damageDealt = ultimate3.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate3.addKi(damageDealt);
					ultimate3.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
				else 
				{
					damageDealt = player3.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player3.addKi(damageDealt);
					player3.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
					brolyAttack = superSaiyan.getGiganticChargeSuperSaiyanDamage();
				}
			}
			else if (target2 == 4)
			{
				if (player4.isUltimate())
				{
					damageDealt = ultimate4.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					ultimate4.addKi(damageDealt);
					ultimate4.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
				}
				else 
				{
					damageDealt = player4.takeDamage(brolyAttack);
					superSaiyan.addKi(damageDealt);
					player4.addKi(damageDealt);
					player4.reduceMomentum(damageDealt);
					superSaiyan.addMomentum(damageDealt);
				}
			}
			superSaiyan.deactivateSuper();
		}
	}
	public static String fusionAction(AttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4) {
		String playerConfirmation = "no",
			   fusionAction = "null";
		FusedPlayer fusion = new FusedPlayer();
		do {
			fusionAction = JOptionPane.showInputDialog("What will " + fusion + " do?\n\nAttack\nSkill\nItems\nDefend\n" + FusedPlayer.getMomentumSkill());
			if (fusionAction == null)
			{
				fusionAction = "null";
			}
			if (fusionAction.equalsIgnoreCase("Attack"))
			{
				playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
				if (playerConfirmation == null)
				{
					playerConfirmation = "null";
				}
			}
			else if (fusionAction.equalsIgnoreCase("SKILL"))
			{
				fusionAction = fusedPlayerSkills();
				if (fusionAction.equalsIgnoreCase(FusedPlayer.getSkill1()) || fusionAction.equalsIgnoreCase(FusedPlayer.getSkill2()))
				{
				}
				else
				{
					fusionAction = "null";
				}
				if (fusionAction.equalsIgnoreCase("null"))
				{
					playerConfirmation = "no";
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
			else if (fusionAction.equalsIgnoreCase("Items"))
			{
				fusionAction = items();
				if (fusionAction.equalsIgnoreCase("null"))
				{
					playerConfirmation = "no";
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
			else if (fusionAction.equalsIgnoreCase("Defend"))
			{
				playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
				if (playerConfirmation == null)
				{
					playerConfirmation = "null";
				}
			}
			else if (fusionAction.equalsIgnoreCase(FusedPlayer.getMomentumSkill()))
			{
				if (FusedPlayer.getMomentum() < 100);
				{
					JOptionPane.showMessageDialog(null, "You need full momentum to use it");
				}
				if (FusedPlayer.getMomentum() >= 100)
				{
					playerConfirmation = JOptionPane.showInputDialog(FusedPlayer.getMomentumSkill()
							+ " - " + FusedPlayer.getMomentumSkillDescription() + "\nAre you sure?\n"
							+ "Yes  No");
				}
			}
		} while (!(playerConfirmation.equalsIgnoreCase("yes")) && (!(playerConfirmation.equalsIgnoreCase("y"))));
		return fusionAction;
	}
	public static String fusedPlayerSkills() {
		String skill;
		PlayerStatus onePlayer = new PlayerStatus();
		skill = JOptionPane.showInputDialog("Skills\n" + FusedPlayer.getSkill1() + " - " + FusedPlayer.getSkill1Description() + "\n" + 
		FusedPlayer.getSkill2() + " - " + FusedPlayer.getSkill2Description());
		if (skill == null)
		{
			skill = "null";
		}
		if (FusedPlayer.getChargeNumber() >= 0)
		{
			if (FusedPlayer.getKi() < 50)
			{
				skill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
		}
		else
		{
			skill = "null";
			JOptionPane.showMessageDialog(null, "You do not have enough ki");
		}
		if(skill.equalsIgnoreCase(FusedPlayer.getAttackTankSkill1()) || skill.equalsIgnoreCase(FusedPlayer.getAttackTankSkill2()) || skill.equalsIgnoreCase(FusedPlayer.getAttackMageSkill1()) || skill.equalsIgnoreCase(FusedPlayer.getAttackMageSkill2()) || skill.equalsIgnoreCase(FusedPlayer.getAttackCrafterSkill2()) || skill.equalsIgnoreCase(FusedPlayer.getTankMageSkill1()) || skill.equalsIgnoreCase(FusedPlayer.getTankMageSkill2()) || skill.equalsIgnoreCase(FusedPlayer.getTankCrafterSkill1()) || skill.equalsIgnoreCase(FusedPlayer.getTankCrafterSkill2()) || skill.equalsIgnoreCase(FusedPlayer.getMageCrafterSkill1()) || skill.equalsIgnoreCase(FusedPlayer.getMageCrafterSkill2()))
		{
			if (onePlayer.isOnePlayer())
			{
				skill = "null";
				JOptionPane.showMessageDialog(null, "This skill is unusable");
			}
		}
		if (skill.equalsIgnoreCase(FusedPlayer.getAttackTankSkill1()))
		{
			if (FusedPlayer.getChargeNumber() < 2)
			{
				skill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
			else if (FusedPlayer.getKi() < 50)
			{
				if (FusedPlayer.getChargeNumber() < 3)
				{
					skill = "null";
					JOptionPane.showMessageDialog(null, "You do not have enough ki");
				}
			}
		}
		if (skill.equalsIgnoreCase(FusedPlayer.getAttackMageSkill1()) || skill.equalsIgnoreCase(FusedPlayer.getAttackCrafterSkill1()) || skill.equalsIgnoreCase(FusedPlayer.getTankCrafterSkill1()) || skill.equalsIgnoreCase(FusedPlayer.getTankMageSkill1()))
		{
			if (FusedPlayer.getChargeNumber() < 2)
			{
				skill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
		}
		if (skill.equalsIgnoreCase(FusedPlayer.getAttackMageSkill2()) || skill.equalsIgnoreCase(FusedPlayer.getTankMageSkill2()) || skill.equalsIgnoreCase(FusedPlayer.getMageCrafterSkill2()))
		{
			if (FusedPlayer.getChargeNumber() < 7)
			{
				skill = "null";
				JOptionPane.showMessageDialog(null, "You do not have enough ki");
			}
		}
		return skill;
	}
	public static void fusedPlayerTurn(String fusedPlayerAction, Broly boss) {
		int attack;
		Items usedItem = new Items();
		String playerConfirmation = "no";
		FusedPlayer fusion = new FusedPlayer();
		String playerOutsideOfFusion1 = "null",
			playerOutsideOfFusion2 = "null";
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
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
		if (fusedPlayerAction.equalsIgnoreCase("Attack"))
		{
			JOptionPane.showMessageDialog(null, fusion + " attacked");
			System.out.println(fusion + " attacked");
			attack = boss.reduceBrolyHealth(fusion.getPlayerAttack());
			fusion.addKi(attack);
			if (FusedPlayer.getFusionType() == fusion.getAttackTank() || FusedPlayer.getFusionType() == fusion.getAttackMage() || FusedPlayer.getFusionType() == fusion.getAttackCrafter())
			{
				fusion.addMomentum(attack);
			}
			boss.addKi(attack);
		}
		else if (fusedPlayerAction.equalsIgnoreCase(FusedPlayer.getSkill1()))
		{
			JOptionPane.showMessageDialog(null, fusion + " used " + FusedPlayer.getSkill1());
			System.out.println(fusion + " used " + FusedPlayer.getSkill1());
			if (FusedPlayer.getSkill1().equalsIgnoreCase(FusedPlayer.getAttackTankSkill1()))
			{
				fullPowerCounter(fusion);
			}
			else if (FusedPlayer.getSkill1().equalsIgnoreCase(FusedPlayer.getAttackMageSkill1()))
			{
				energySteal(fusion, boss);
			}
			else if (FusedPlayer.getSkill1().equalsIgnoreCase(FusedPlayer.getAttackCrafterSkill1()))
			{
				craftersStrength(fusion, boss, usedItem);
			}
			else if (FusedPlayer.getSkill1().equalsIgnoreCase(FusedPlayer.getTankMageSkill1()))
			{
				kiShield();
			}
			else if (FusedPlayer.getSkill1().equalsIgnoreCase(FusedPlayer.getTankCrafterSkill1()))
			{
				unbreakableConcentration();
			}
			else if (FusedPlayer.getSkill1().equalsIgnoreCase(FusedPlayer.getMageCrafterSkill1()))
			{
				development(fusion, boss);
			}
		}
		else if (fusedPlayerAction.equalsIgnoreCase(FusedPlayer.getSkill2()))
		{
			JOptionPane.showMessageDialog(null, fusion + " used " + FusedPlayer.getSkill2());
			System.out.println(fusion + " used " + FusedPlayer.getSkill2());
			if (FusedPlayer.getSkill2().equalsIgnoreCase(FusedPlayer.getAttackTankSkill2()))
			{
				rejuvenation(fusion);
			}
			else if (FusedPlayer.getSkill2().equalsIgnoreCase(FusedPlayer.getAttackMageSkill2()))
			{
				energyAssist();
			}
			else if (FusedPlayer.getSkill2().equalsIgnoreCase(FusedPlayer.getAttackCrafterSkill2()))
			{
				elixirOfRestoration(fusion);
			}
			else if (FusedPlayer.getSkill2().equalsIgnoreCase(FusedPlayer.getTankMageSkill2()))
			{
				revialization();
			}
			else if (FusedPlayer.getSkill2().equalsIgnoreCase(FusedPlayer.getTankCrafterSkill2()))
			{
				medKit(fusion);
			}
			else if (FusedPlayer.getSkill2().equalsIgnoreCase(FusedPlayer.getMageCrafterSkill2()))
			{
				medicine(fusion);
			}
		}
		else if (fusedPlayerAction.equalsIgnoreCase(usedItem.getITEM1()))
		{
			if (usedItem.getSmallHealItemAmount() > 0)
			{
			do 
			{
				fusedPlayerAction = JOptionPane.showInputDialog(usedItem.getITEM1() + "\nWho do you want to heal?\n" + fusion + "\n" + playerOutsideOfFusion1 + "\n" + playerOutsideOfFusion2);
				if (fusedPlayerAction == null)
				{
					fusedPlayerAction = "null";
				}
				if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion1))
				{
					if (playerOutsideOfFusion1.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion2))
				{
					if (playerOutsideOfFusion2.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (fusedPlayerAction.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getSmallHealAmount());
				usedItem.decreaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM1() + "s");
			}
		}
		else if (fusedPlayerAction.equalsIgnoreCase(usedItem.getITEM2()))
		{
			if (usedItem.getLargeHealItemAmount() > 0)
			{
			do 
			{
				fusedPlayerAction = JOptionPane.showInputDialog(usedItem.getITEM2() + "\nWho do you want to heal?\n" + fusion + "\n" + playerOutsideOfFusion1 + "\n" + playerOutsideOfFusion2);
				if (fusedPlayerAction == null)
				{
					fusedPlayerAction = "null";
				}
				if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion1))
				{
					if (playerOutsideOfFusion1.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion2))
				{
					if (playerOutsideOfFusion2.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (fusedPlayerAction.equalsIgnoreCase(player1.toString()))
			{
				player1.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player2.toString()))
			{
				player2.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player3.toString()))
			{
				player3.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player4.toString()))
			{
				player4.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
			{
				fusion.increaseHealth(usedItem.getLargeHealAmount());
				usedItem.decreaseLargeHealItemAmount();
				usedItem.increaseSmallHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM2() + "s");
			}
		}
		else if (fusedPlayerAction.equalsIgnoreCase(usedItem.getITEM3()))
		{
			if (usedItem.getSenzuAmount() > 0)
			{
			do
			{
				fusedPlayerAction = JOptionPane.showInputDialog(usedItem.getITEM3() + "\nWho do you want to revive?\n" + playerOutsideOfFusion1 + "\n" + playerOutsideOfFusion2);
				if (fusedPlayerAction == null)
				{
					fusedPlayerAction = "null";
				}
				if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion1))
				{
					if (playerOutsideOfFusion1.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() > 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is alive");
						}
						else 
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() > 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is alive");
						}
						else 
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() > 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is alive");
						}
						else 
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() > 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is alive");
						}
						else 
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion2))
				{
					if (playerOutsideOfFusion2.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() > 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is alive");
						}
						else 
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player2.toString()))
					{
						if (player2.getPlayer2Health() > 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is alive");
						}
						else 
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player3.toString()))
					{
						if (player3.getPlayer3Health() > 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is alive");
						}
						else 
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player4.toString()))
					{
						if (player4.getPlayer4Health() > 0)
						{
							playerConfirmation = "no";
							JOptionPane.showMessageDialog(null, "This player is alive");
						}
						else 
						{
							playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
							if (playerConfirmation == null)
							{
								playerConfirmation = "null";
							}
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (fusedPlayerAction.equalsIgnoreCase(player1.toString()))
			{
				player1.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player2.toString()))
			{
				player2.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player3.toString()))
			{
				player3.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player4.toString()))
			{
				player4.revive();
				usedItem.decreaseSenzuHealItemAmount();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM3() + "s");
			}
		}
		else if (fusedPlayerAction.equalsIgnoreCase(usedItem.getITEM4()))
		{
			if (usedItem.getAttackUpAmount() > 0)
			{
			do
			{
				fusedPlayerAction = JOptionPane.showInputDialog(usedItem.getITEM4() + "\nWho do you want to buff?\n" + fusion + "\n" + playerOutsideOfFusion1 + "\n" + playerOutsideOfFusion2);
				if (fusedPlayerAction == null)
				{
					fusedPlayerAction = "null";
				}
				if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion1))
				{
					if (playerOutsideOfFusion1.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion2))
				{
					if (playerOutsideOfFusion2.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (fusedPlayerAction.equalsIgnoreCase(player1.toString()))
				{
					player1.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(player2.toString()))
				{
					player2.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(player3.toString()))
				{
					player3.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(player4.toString()))
				{
					player4.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setAttackUpDuration();
					usedItem.decreaseAttackUpAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
			}
		}
		else if (fusedPlayerAction.equalsIgnoreCase(usedItem.getITEM5()))
		{
			if (usedItem.getDefenseUpAmount() > 0)
			{
			do
			{
				fusedPlayerAction = JOptionPane.showInputDialog(usedItem.getITEM5() + "\nWho do you want to buff?\n" + fusion + "\n" + playerOutsideOfFusion1 + "\n" + playerOutsideOfFusion2);
				if (fusedPlayerAction == null)
				{
					fusedPlayerAction = "null";
				}
				if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion1))
				{
					if (playerOutsideOfFusion1.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion2))
				{
					if (playerOutsideOfFusion2.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			} while(!(playerConfirmation.equalsIgnoreCase("Yes")));
			if (fusedPlayerAction.equalsIgnoreCase(player1.toString()))
			{
				player1.setDefenseUpDuration();
				usedItem.decreaseDefenseUpAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player2.toString()))
			{
				player2.setDefenseUpDuration();
				usedItem.decreaseDefenseUpAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player3.toString()))
			{
				player3.setDefenseUpDuration();
				usedItem.decreaseDefenseUpAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(player4.toString()))
			{
				player4.setDefenseUpDuration();
				usedItem.decreaseDefenseUpAmount();
			}
			else if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
			{
				fusion.setDefenseUpDuration();
				usedItem.decreaseDefenseUpAmount();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM4() + "s");
		}
		}	
		else if (fusedPlayerAction.equalsIgnoreCase(usedItem.getITEM6()))
		{
			if (usedItem.getHyperChargeAmount() > 0)
			{
			do
			{
				fusedPlayerAction = JOptionPane.showInputDialog(usedItem.getITEM6() + "\nWho do you want to buff?\n" + fusion + "\n" + playerOutsideOfFusion1 + "\n" + playerOutsideOfFusion2);
				if (fusedPlayerAction == null)
				{
					fusedPlayerAction = "null";
				}
				if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion1))
				{
					if (playerOutsideOfFusion1.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion2))
				{
					if (playerOutsideOfFusion2.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (fusedPlayerAction.equalsIgnoreCase(player1.toString()))
				{
					player1.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(player2.toString()))
				{
					player2.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(player3.toString()))
				{
					player3.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(player4.toString()))
				{
					player4.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setHyperChargeDuration();
					usedItem.decreaseHyperChargeAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM6() + "s");
			}
		}
		else if (fusedPlayerAction.equalsIgnoreCase(usedItem.getITEM7()))
		{
			if (usedItem.getStaticMomentumAmount() > 0)
			{
			do
			{
				fusedPlayerAction = JOptionPane.showInputDialog(usedItem.getITEM7() + "\nWho do you want to buff?\n" + fusion + "\n" + playerOutsideOfFusion1 + "\n" + playerOutsideOfFusion2);
				if (fusedPlayerAction == null)
				{
					fusedPlayerAction = "null";
				}
				if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
				{
					playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
					if (playerConfirmation == null)
					{
						playerConfirmation = "null";
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion1))
				{
					if (playerOutsideOfFusion1.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion1.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else if (fusedPlayerAction.equalsIgnoreCase(playerOutsideOfFusion2))
				{
					if (playerOutsideOfFusion2.equalsIgnoreCase(player1.toString()))
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
							fusedPlayerAction = player1.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player2.toString()))
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
							fusedPlayerAction = player2.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player3.toString()))
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
							fusedPlayerAction = player3.toString();
						}
					}
					else if (playerOutsideOfFusion2.equalsIgnoreCase(player4.toString()))
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
							fusedPlayerAction = player4.toString();
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (fusedPlayerAction.equalsIgnoreCase(player1.toString()))
				{
					player1.setStaticMomentumDuration();
					usedItem.decreaseStaticMomentumAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(player2.toString()))
				{
					player2.setStaticMomentumDuration();
					usedItem.decreaseStaticMomentumAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(player3.toString()))
				{
					player3.setStaticMomentumDuration();
					usedItem.decreaseStaticMomentumAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(player4.toString()))
				{
					player4.setStaticMomentumDuration();
					usedItem.decreaseStaticMomentumAmount();
				}
				else if (fusedPlayerAction.equalsIgnoreCase(fusion.toString()))
				{
					fusion.setStaticMomentumDuration();
					usedItem.decreaseStaticMomentumAmount();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No more " + usedItem.getITEM7() + "s");
			}
		}
		else if (fusedPlayerAction.equalsIgnoreCase("Defend"))
		{
			fusion.startDefending();
		}
		else if (fusedPlayerAction.equalsIgnoreCase(FusedPlayer.getMomentumSkill()))
		{
			JOptionPane.showMessageDialog(null, fusion + " used " + FusedPlayer.getMomentumSkill());
			System.out.println(fusion + " used " + FusedPlayer.getMomentumSkill());
			if (FusedPlayer.getMomentumSkill().equalsIgnoreCase(FusedPlayer.getAttackTankMomentumSkill()))
			{
				highSpiritGenkShield(fusion);
			}
			else if (FusedPlayer.getMomentumSkill().equalsIgnoreCase(FusedPlayer.getAttackMageMomentumSkill()))
			{
				cordinatedAttack(boss, fusion);
			}
			else if (FusedPlayer.getMomentumSkill().equalsIgnoreCase(FusedPlayer.getAttackCrafterMomentumSkill()))
			{
				highSpeedRush(boss, fusion);
			}
			else if (FusedPlayer.getMomentumSkill().equalsIgnoreCase(FusedPlayer.getTankMageMomentumSkill()))
			{
				masteryOfOffenseAndDefense(fusion);
			}
			else if (FusedPlayer.getMomentumSkill().equalsIgnoreCase(FusedPlayer.getTankCrafterMomentumSkill()))
			{
				barricade(fusion);
			}
			else if (FusedPlayer.getMomentumSkill().equalsIgnoreCase(FusedPlayer.getMageCrafterMomentumSkill()))
			{
				prepTime(fusion);
			}
		}
		else if (fusedPlayerAction.equalsIgnoreCase(usedItem.getITEM8()))
		{
			if (usedItem.getDragonBallAmount() == usedItem.getTOTAL_DRAGON_BALLS())
			{
				JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " summoned Shenron");
				System.out.println(AttackerClass.getUltimateTag() + player1 + " summoned Shenron");
				usedItem.useDragonBalls(player1, player2, player3, player4);
			}
			else
			{
				JOptionPane.showMessageDialog(null, AttackerClass.getUltimateTag() + player1 + " is searching for the Dragon Balls");
				System.out.println(AttackerClass.getUltimateTag() + player1 + " is searching for the Dragon Balls");
				usedItem.findDragonBall();
				fusion.addKiDragonBalls();
			}
		}
	}
	public static void fullPowerCounter(FusedPlayer fusion) {
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		player3.setHumanShieldTarget();
		player4.setHumanShieldTarget();
		FusedPlayer.reduceKiFullPowerCounter();
	}
	public static void energySteal(FusedPlayer fusion, Broly boss) {
		int attack;
		int ki;
		String playerConfirmation,
			fusionTurn;
		TankClass player2 = new TankClass();
		ItemCrafter player4 = new ItemCrafter();
		JOptionPane.showMessageDialog(null, fusion + " used " + FusedPlayer.getSkill1());
		System.out.println(fusion + " used " + FusedPlayer.getSkill1());
		FusedPlayer.reduceKiEnergySteal();
		FusedPlayer.addTenMomentum();
		if (FusedPlayer.getKi() > boss.getBrolyKi())
		{
			if (FusedPlayer.getChargeNumber() < boss.getBrolyChargeNumber())
			{
				attack = boss.reduceBrolyHealth(fusion.getEnergyStealDamage());
				FusedPlayer.addDamageDealt(attack);
				ki = fusion.addKiSkill(attack);
				Broly.reduceKi(ki);
				fusion.addMomentum(attack);
			}
			else
			{
				do 
				{
					fusionTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" +
							ItemCrafter.getUltimateTag() + player4);
					if (fusionTurn == null)
					{
						fusionTurn = "null";
					}
					if (fusionTurn.equalsIgnoreCase(player2.toString()))
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
						}
					}
					else if (fusionTurn.equalsIgnoreCase(player4.toString()))
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
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						playerConfirmation = "no";
					}
				} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
				if (fusionTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.gainRandomBuff();
					fusion.addMomentum(10000);
				}
				else if (fusionTurn.equalsIgnoreCase(player4.toString()))
				{
					player4.gainRandomBuff();
					fusion.addMomentum(10000);
				}
			}
		}
		else
		{
			do 
			{
				fusionTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + TankClass.getUltimateTag() + player2 + "\n" +
						ItemCrafter.getUltimateTag() + player4);
				if (fusionTurn == null)
				{
					fusionTurn = "null";
				}
				if (fusionTurn.equalsIgnoreCase(player2.toString()))
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
					}
				}
				else if (fusionTurn.equalsIgnoreCase(player4.toString()))
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
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
					playerConfirmation = "no";
				}
			} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
			if (fusionTurn.equalsIgnoreCase(player2.toString()))
			{
				player2.gainRandomBuff();
				fusion.addMomentum(10000);
			}
			else if (fusionTurn.equalsIgnoreCase(player4.toString()))
			{
				player4.gainRandomBuff();
				fusion.addMomentum(10000);
			}
		}
	}
	public static void craftersStrength(FusedPlayer fusion, Broly boss, Items usedItem) {
		int attack;
		String playerConfirmation;
		String fusionTurn;
		FusedPlayer.reduceKiCrafterStrength();
		attack = boss.reduceBrolyHealth(fusion.getCraftersStrengthDamage());
		FusedPlayer.addDamageDealt(attack);
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
				playerConfirmation = JOptionPane.showInputDialog("Are you sure?\nYes  No");
				if (playerConfirmation == null)
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
			fusion.addMomentum(fusion.craftLargeHealCraftersStrength(attack));
		}
		else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM4()))
		{
			fusion.addMomentum(fusion.craftAttackUpCraftersStrength(attack));
		}
		else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM5()))
		{
			fusion.addMomentum(fusion.craftDefenseUpCraftersStrength(attack));
		}
		else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM6()))
		{
			fusion.addMomentum(fusion.craftHyperChargeCraftersStrength(attack));
		}
		else if (fusionTurn.equalsIgnoreCase(usedItem.getITEM7()))
		{
			fusion.addMomentum(fusion.craftStaticMomentumCraftersStrength(attack));
		}
	}
	public static void kiShield() {
		FusedPlayer.addTenMomentum();
		AttackerClass player1 = new AttackerClass();
		ItemCrafter player4 = new ItemCrafter();
		FusedPlayer.reduceKiEnergySteal();
		player1.setHumanShieldTarget();
		player4.setHumanShieldTarget();
	}
	public static void unbreakableConcentration() {
		AttackerClass player1 = new AttackerClass();
		MageClass player3 = new MageClass();
		FusedPlayer.reduceKiEnergySteal();
		player1.setHumanShieldTarget();
		player3.setHumanShieldTarget();
	}
	public static void development(FusedPlayer fusion, Broly boss) {
		String playerConfirmation, 
			fusionTurn;
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		FusedPlayer.reduceKi();
		FusedPlayer.addTenMomentum();
		if (FusedPlayer.getKi() > boss.getBrolyKi())
		{
			if (FusedPlayer.getChargeNumber() < boss.getBrolyChargeNumber())
			{
				do 
				{
					fusionTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" +
						TankClass.getUltimateTag() + player2);
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
					else if (fusionTurn.equalsIgnoreCase(player2.toString()))
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
					player1.setStaticMomentumDuration();
					fusion.addMomentum(10000);
				}
				else if (fusionTurn.equalsIgnoreCase(player2.toString()))
				{
					player2.setStaticMomentumDuration();
					fusion.addMomentum(10000);
				}
			}
			else
			{
				fusion.activateMomentumSkill();
				fusion.addMomentum(fusion.craftLargeHeal());
				fusion.addMomentum(fusion.craftAttackUp());
				fusion.addMomentum(fusion.craftDefenseUp());
				fusion.addMomentum(fusion.craftHyperCharge());
				fusion.addMomentum(fusion.craftStaticMomentum());
				fusion.deactivateMomentumSkill();
			}
			}
			else
			{
				fusion.activateMomentumSkill();
				fusion.addMomentum(fusion.craftLargeHeal());
				fusion.addMomentum(fusion.craftAttackUp());
				fusion.addMomentum(fusion.craftDefenseUp());
				fusion.addMomentum(fusion.craftHyperCharge());
				fusion.addMomentum(fusion.craftStaticMomentum());
				fusion.deactivateMomentumSkill();
			}
		}
	public static void rejuvenation(FusedPlayer fusion) {
		String playerConfirmation,
			fusionTurn;
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		FusedPlayer.reduceKi();
		do 
		{
			fusionTurn = JOptionPane.showInputDialog("Who do you want to support?\n" + MageClass.getUltimateTag() + player3 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (fusionTurn == null)
			{
				fusionTurn = "null";
			}
			if (fusionTurn.equalsIgnoreCase(player3.toString()))
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
				}
			}
			else if (fusionTurn.equalsIgnoreCase(player4.toString()))
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
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error");
				playerConfirmation = "no";
			}
		} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
		if (fusionTurn.equalsIgnoreCase(player3.toString()))
		{
			player3.increaseHealth(FusedPlayer.getDamageTaken());
			fusion.addMomentum(FusedPlayer.getDamageTaken());
			FusedPlayer.resetDamageTaken();
			player3.addKiFromHighSpirit(FusedPlayer.getDamageDealt());
			FusedPlayer.resetDamageDealt();
		}
		else if (fusionTurn.equalsIgnoreCase(player4.toString()))
		{
			player4.increaseHealth(FusedPlayer.getDamageTaken());
			fusion.addMomentum(FusedPlayer.getDamageTaken());
			FusedPlayer.resetDamageTaken();
			player4.addKiFromHighSpirit(FusedPlayer.getDamageDealt());
			FusedPlayer.resetDamageDealt();
		}
	}
	public static void energyAssist() {
		String playerConfirmation,
		fusionTurn;
		TankClass player2 = new TankClass();
		ItemCrafter player4 = new ItemCrafter();
		FusedPlayer.reduceKiEnergyAssist();
		do 
		{
			fusionTurn = JOptionPane.showInputDialog("Who do you want to support?\n" + TankClass.getUltimateTag() + player2 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
			if (fusionTurn == null)
			{
				fusionTurn = "null";
			}
			if (fusionTurn.equalsIgnoreCase(player2.toString()))
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
				}
			}
			else if (fusionTurn.equalsIgnoreCase(player4.toString()))
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
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error");
				playerConfirmation = "no";
			}
		} while (!((playerConfirmation.equalsIgnoreCase("yes"))) && (!(playerConfirmation.equalsIgnoreCase("y"))));
		if (fusionTurn.equalsIgnoreCase(player2.toString()))
		{
			player2.addKiFromHighSpirit(FusedPlayer.getDamageDealt());
			FusedPlayer.resetDamageDealt();
			player2.addMomentumFromMage(FusedPlayer.getKiGained());
			FusedPlayer.resetKiGained();
		}
		else if (fusionTurn.equalsIgnoreCase(player4.toString()))
		{
			player4.addKiFromHighSpirit(FusedPlayer.getDamageDealt());
			FusedPlayer.resetDamageDealt();
			player4.addMomentumFromMage(FusedPlayer.getKiGained());
			FusedPlayer.resetKiGained();
		}
	}
	public static void elixirOfRestoration(FusedPlayer fusion) {
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		FusedPlayer.reduceKi();
		fusion.increaseHealth(FusedPlayer.getCraftingProgress());
		FusedPlayer.resetCraftingProgress();
		player2.setHyperChargeDuration();
		player3.setHyperChargeDuration();
	}
	public static void revialization() {
		String playerConfirmation,
		fusionTurn;
		AttackerClass player1 = new AttackerClass();
		ItemCrafter player4 = new ItemCrafter();
		FusedPlayer.reduceKiEnergyAssist();
		do 
		{
			fusionTurn = JOptionPane.showInputDialog("Who do you want to support?\n" + AttackerClass.getUltimateTag() + player1 + "\n" +
					ItemCrafter.getUltimateTag() + player4);
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
			else if (fusionTurn.equalsIgnoreCase(player4.toString()))
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
			player1.increaseHealth(FusedPlayer.getDamageTaken());
			FusedPlayer.resetDamageTaken();
			player1.addMomentumFromMage(FusedPlayer.getKiGained());
			FusedPlayer.resetKiGained();
		}
		else if (fusionTurn.equalsIgnoreCase(player4.toString()))
		{
			player4.increaseHealth(FusedPlayer.getDamageTaken());
			FusedPlayer.resetDamageTaken();
			player4.addMomentumFromMage(FusedPlayer.getKiGained());
			FusedPlayer.resetKiGained();
		}
	}
	public static void medKit(FusedPlayer fusion) {
		String playerConfirmation,
		fusionTurn;
		int heal;
		AttackerClass player1 = new AttackerClass();
		MageClass player3 = new MageClass();
		FusedPlayer.reduceKi();
		heal = FusedPlayer.getCraftingProgress();
		fusion.increaseHealth(heal);
		do 
		{
			fusionTurn = JOptionPane.showInputDialog("Who do you want to heal?\n" + AttackerClass.getUltimateTag() + player1 + "\n" +
					MageClass.getUltimateTag() + player3);
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
			else if (fusionTurn.equalsIgnoreCase(player3.toString()))
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
			player1.increaseHealth(heal);
		}
		else if (fusionTurn.equalsIgnoreCase(player3.toString()))
		{
			player3.increaseHealth(heal);
		}
		FusedPlayer.resetCraftingProgress();
	}
	public static void medicine(FusedPlayer fusion) {
		String playerConfirmation,
		fusionTurn;
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		fusion.useMedcine();
		fusion.increaseHealth(FusedPlayer.getCraftingProgress());
		do 
		{
			fusionTurn = JOptionPane.showInputDialog("Who do you want to buff?\n" + AttackerClass.getUltimateTag() + player1 + "\n" +
					TankClass.getUltimateTag() + player2);
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
			else if (fusionTurn.equalsIgnoreCase(player2.toString()))
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
			player1.addMomentumFromMage(FusedPlayer.getKiGained());
		}
		else if (fusionTurn.equalsIgnoreCase(player2.toString()))
		{
			player2.addMomentumFromMage(FusedPlayer.getKiGained());
		}
	}
	public static void highSpiritGenkShield(FusedPlayer fusion) {
		TankClass player2 = new TankClass();
		MageClass player3 = new MageClass();
		ItemCrafter player4 = new ItemCrafter();
		FusedPlayer.resetMomentum();
		player2.activateGenkiShield();
		player3.increaseHealth(fusion.getHIGH_SPIRIT_GENKI_SHIELD_HEAL());
		player3.addKiFromHighSpirit(fusion.getHIGH_SPIRIT_GENKI_SHIELD_KI());
		player4.increaseHealth(fusion.getHIGH_SPIRIT_GENKI_SHIELD_HEAL());
		player4.addKiFromHighSpirit(fusion.getHIGH_SPIRIT_GENKI_SHIELD_KI());
	}
	public static void cordinatedAttack(Broly boss, FusedPlayer fusion) {
		TankClass player2 = new TankClass();
		ItemCrafter player4 = new ItemCrafter();
		FusedPlayer.resetMomentum();
		int ki = boss.reduceBrolyHealth(fusion.getCordinatedAttack());
		fusion.addKi(ki);
		boss.addKi(ki);
		player2.addKiFromHighSpirit(fusion.getHIGH_SPIRIT_GENKI_SHIELD_KI());
		player2.setAttackUpDuration();
		player4.addKiFromHighSpirit(fusion.getHIGH_SPIRIT_GENKI_SHIELD_KI());
		player4.setAttackUpDuration();
	}
	public static void highSpeedRush(Broly boss, FusedPlayer fusion) {
		Items craft =  new Items();
		FusedPlayer.resetMomentum();
		int ki = boss.reduceBrolyHealth(fusion.getHighSpeedRushAttack());
		boss.addKi(ki);
		fusion.addKi(ki);
		fusion.activateMomentumSkill();
		fusion.craftLargeHeal();
		fusion.craftAttackUp();
		fusion.craftDefenseUp();
		fusion.craftHyperCharge();
		fusion.craftStaticMomentum();
		craft.increaseSenzuHealItemAmount();
		fusion.deactivateMomentumSkill();
	}
	public static void masteryOfOffenseAndDefense(FusedPlayer fusion) {
		TankClass player2 = new TankClass();
		AttackerClass player1 = new AttackerClass();
		ItemCrafter player4 = new ItemCrafter();
		player2.activateGenkiShield();
		player1.increaseHealth(fusion.getMASTERY_OF_OFFENSE_AND_DEFENSE_HEAL());
		player1.setAttackUpDuration();
		player4.increaseHealth(fusion.getMASTERY_OF_OFFENSE_AND_DEFENSE_HEAL());
		player4.setAttackUpDuration();
	}
	public static void barricade(FusedPlayer fusion) {
		TankClass player2 = new TankClass();
		Items craft =  new Items();
		player2.activateGenkiShield();
		fusion.activateMomentumSkill();
		fusion.craftLargeHeal();
		fusion.craftAttackUp();
		fusion.craftDefenseUp();
		fusion.craftHyperCharge();
		fusion.craftStaticMomentum();
		craft.increaseSenzuHealItemAmount();
		fusion.deactivateMomentumSkill();
	}
	public static void prepTime(FusedPlayer fusion) {
		AttackerClass player1 = new AttackerClass();
		TankClass player2 = new TankClass();
		Items craft =  new Items();
		player1.setAttackUpDuration();
		player2.setAttackUpDuration();
		fusion.activateMomentumSkill();
		fusion.craftLargeHeal();
		fusion.craftAttackUp();
		fusion.craftDefenseUp();
		fusion.craftHyperCharge();
		fusion.craftStaticMomentum();
		craft.increaseSenzuHealItemAmount();
		fusion.deactivateMomentumSkill();
	}
	public static void brolyFullPowerSuperSaiyanTurn(Broly fullPower, AttackerClass player1, TankClass player2, MageClass player3, ItemCrafter player4) {
		int brolyAction;
		int damageDealt = 0; 
		boolean validChoice = false;
		int brolyAttack = 0;
		String humanShieldTarget = "null";
		brolyAction = fullPower.getBrolyAction();
		int target = 0;
		int target1 = 0;
		int target2 = 0;
		String target1Name = "null",
				target2Name = "";
		boolean player2Target1 = false,
		player2Target2 = false;
		PlayerStatus onePlayer = new PlayerStatus();
		FusedPlayer fusion = new FusedPlayer();
		UltimateAttackerClass ultimate1 = new UltimateAttackerClass();
		UltimateTankClass ultimate2 = new UltimateTankClass();
		UltimateMageClass ultimate3 = new UltimateMageClass();
		UltimateItemCrafter ultimate4 = new UltimateItemCrafter();
		if (brolyAction == 4 || brolyAction == 5 || brolyAction == 6)
		{
			if (fullPower.getBrolyMomentum() >= 100)
			{
				JOptionPane.showMessageDialog(null, fullPower + " used "
						+ fullPower.getFULL_POWER_ULTIMATE());
				System.out.println(fullPower + " used "
						+ fullPower.getFULL_POWER_ULTIMATE());
				Broly.activateBrolyFullPowerUltimate();
				brolyAttack = fullPower.getGiganticRoarDamage();
				do
				{
					target = fullPower.getTarget();
					if (target == 1)
					{
						if (player1.getPlayer1Health() <= 0 
								|| FusedPlayer.getFusionType() == fusion.getAttackTank() 
								|| FusedPlayer.getFusionType() == fusion.getAttackMage() 
								|| FusedPlayer.getFusionType() == fusion.getAttackCrafter())
						{
							validChoice = false;
						}
						else if (player1.isUltimate())
						{
							damageDealt = ultimate1.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							ultimate1.addKi(damageDealt);
							ultimate1.reduceMomentum(damageDealt);
							Broly.deactivateBrolyFullPowerUltimate();
							validChoice = true;
						}
						else
						{
							damageDealt = player1.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							player1.addKi(damageDealt);
							player1.reduceMomentum(damageDealt);
							Broly.deactivateBrolyFullPowerUltimate();
							validChoice = true;
						}
					}
					else if (target == 2)
					{
						if (player2.getPlayer2Health() <= 0 
								|| FusedPlayer.getFusionType() == fusion.getAttackTank() 
								|| FusedPlayer.getFusionType() == fusion.getTankMage() 
								|| FusedPlayer.getFusionType() == fusion.getTankCrafter())
						{
							validChoice = false;
						}
						else if (player2.isUltimate())
						{
							damageDealt = ultimate2.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							ultimate2.addKi(damageDealt);
							Broly.deactivateBrolyFullPowerUltimate();
							validChoice = true;
						}
						else
						{
							damageDealt = player2.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							player2.addKi(damageDealt);
							Broly.deactivateBrolyFullPowerUltimate();
							validChoice = true;
						}
					}
					else if (target == 3)
					{
						if (player3.getPlayer3Health() <= 0 
								|| FusedPlayer.getFusionType() == fusion.getAttackMage() 
								|| FusedPlayer.getFusionType() == fusion.getTankMage() 
								|| FusedPlayer.getFusionType() == fusion.getMageCrafter())
						{
							validChoice = false;
						}
						else if (player3.isUltimate())
						{
							damageDealt = ultimate3.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							ultimate3.addKi(damageDealt);
							ultimate3.reduceMomentum(damageDealt);
							Broly.deactivateBrolyFullPowerUltimate();
							validChoice = true;
						}
						else
						{
							damageDealt = player3.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							player3.addKi(damageDealt);
							player3.reduceMomentum(damageDealt);
							Broly.deactivateBrolyFullPowerUltimate();
							validChoice = true;
						}
					}
					else if (target == 4)
					{
						if (player4.getPlayer4Health() <= 0 
								|| FusedPlayer.getFusionType() == fusion.getAttackCrafter() 
								|| FusedPlayer.getFusionType() == fusion.getTankCrafter() 
								|| FusedPlayer.getFusionType() == fusion.getMageCrafter())
						{
							validChoice = false;
						}
						else if (player4.isUltimate())
						{
							damageDealt = ultimate4.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							ultimate4.addKi(damageDealt);
							ultimate4.reduceMomentum(damageDealt);
							Broly.deactivateBrolyFullPowerUltimate();
							validChoice = true;
						}
						else
						{
							damageDealt = player4.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							player4.addKi(damageDealt);
							player4.reduceMomentum(damageDealt);
							Broly.deactivateBrolyFullPowerUltimate();
							validChoice = true;
						}
					}
					else if (target == 5)
					{
						damageDealt = fusion.takeDamage(brolyAttack);
						fullPower.addKi(damageDealt);
						fusion.addKi(damageDealt);
						fusion.reduceMomentum(damageDealt);
						Broly.deactivateBrolyFullPowerUltimate();
						validChoice = true;
					}
				} while (!(validChoice));
				Broly.resetMomentum();
			}
			else
			{
				brolyAction = fullPower.getBrolyActionFailure1();
			}
		}
		if (brolyAction == 3)
		{
			if (fullPower.getBrolyChargeNumber() >= 4)
			{
				JOptionPane.showMessageDialog(null, fullPower +
						" used " + fullPower.getFULL_POWER_SKILL());
				System.out.println(fullPower +
						" used " + fullPower.getFULL_POWER_SKILL());
				fullPower.activateOmegaBlasterFullPower();
			}
			else
			{
				brolyAction = fullPower.getBrolyActionFailure2();
			}
		}
		if (brolyAction == 2)
		{
			if (fullPower.getBrolyChargeNumber() >= 3)
			{
				JOptionPane.showMessageDialog(null, fullPower + " used "
						+ fullPower.getFULL_POWER_SUPER());
				System.out.println(fullPower + " used "
						+ fullPower.getFULL_POWER_SUPER());
				fullPower.activateSuper();
				brolyAttack = fullPower.getBlasterCannonFullPowerDamage();
				do
				{
					target = fullPower.getTarget();
					if (target == 1)
					{
						if (player1.getPlayer1Health() <= 0 
								|| FusedPlayer.getFusionType() == fusion.getAttackTank() 
								|| FusedPlayer.getFusionType() == fusion.getAttackMage() 
								|| FusedPlayer.getFusionType() == fusion.getAttackCrafter())
						{
							validChoice = false;
						}
						else if (player1.isUltimate())
						{
							damageDealt = ultimate1.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							ultimate1.addKi(damageDealt);
							ultimate1.reduceMomentum(damageDealt);
							Broly.deactivateBrolyFullPowerUltimate();
							validChoice = true;
						}
						else
						{
							damageDealt = player1.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							player1.addKi(damageDealt);
							player1.reduceMomentum(damageDealt);
							fullPower.addMomentum(damageDealt);
							fullPower.deactivateSuper();
							validChoice = true;
						}
					}
					else if (target == 2)
					{
						if (player2.getPlayer2Health() <= 0 
								|| FusedPlayer.getFusionType() == fusion.getAttackTank() 
								|| FusedPlayer.getFusionType() == fusion.getTankMage() 
								|| FusedPlayer.getFusionType() == fusion.getTankCrafter())
						{
							validChoice = false;
						}
						else if (player2.isUltimate())
						{
							damageDealt = ultimate2.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							ultimate2.addKi(damageDealt);
							fullPower.addMomentum(damageDealt);
							fullPower.deactivateSuper();
							validChoice = true;
						}
						else
						{
							damageDealt = player2.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							player2.addKi(damageDealt);
							fullPower.addMomentum(damageDealt);
							fullPower.deactivateSuper();
							validChoice = true;
						}
					}
					else if (target == 3)
					{
						if (player3.getPlayer3Health() <= 0 
								|| FusedPlayer.getFusionType() == fusion.getAttackMage() 
								|| FusedPlayer.getFusionType() == fusion.getTankMage() 
								|| FusedPlayer.getFusionType() == fusion.getMageCrafter())
						{
							validChoice = false;
						}
						else if (player3.isUltimate())
						{
							damageDealt = ultimate3.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							ultimate3.addKi(damageDealt);
							ultimate3.reduceMomentum(damageDealt);
							fullPower.addMomentum(damageDealt);
							fullPower.deactivateSuper();
							validChoice = true;
						}
						else
						{
							damageDealt = player3.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							player3.addKi(damageDealt);
							player3.reduceMomentum(damageDealt);
							fullPower.addMomentum(damageDealt);
							fullPower.deactivateSuper();
							validChoice = true;
						}
					}
					else if (target == 4)
					{
						if (player4.getPlayer4Health() <= 0 
								|| FusedPlayer.getFusionType() == fusion.getAttackCrafter() 
								|| FusedPlayer.getFusionType() == fusion.getTankCrafter() 
								|| FusedPlayer.getFusionType() == fusion.getMageCrafter())
						{
							validChoice = false;
						}
						else if (player4.isUltimate())
						{
							damageDealt = ultimate4.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							ultimate4.addKi(damageDealt);
							ultimate4.reduceMomentum(damageDealt);
							fullPower.addMomentum(damageDealt);
							fullPower.deactivateSuper();
							validChoice = true;
						}
						else
						{
							damageDealt = player4.takeDamage(brolyAttack);
							fullPower.addKi(damageDealt);
							player4.addKi(damageDealt);
							player4.reduceMomentum(damageDealt);
							fullPower.addMomentum(damageDealt);
							fullPower.deactivateSuper();
							validChoice = true;
						}
					}
					else if (target == 5)
					{
						damageDealt = fusion.takeDamage(brolyAttack);
						fullPower.addKi(damageDealt);
						fusion.addKi(damageDealt);
						fusion.reduceMomentum(damageDealt);
						fullPower.addMomentum(damageDealt);
						fullPower.deactivateSuper();
						validChoice = true;
					}
				} while (!(validChoice));
			}
			else
			{
				brolyAction = fullPower.getBrolyActionFailure3();
			}
		}
		if (brolyAction == 1)
		{
			JOptionPane.showMessageDialog(null, fullPower + " used " +
					fullPower.getFULL_POWER_ATTACK());
			System.out.println(fullPower + " used " +
					fullPower.getFULL_POWER_ATTACK());
			brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
			do
			{
				target1 = fullPower.getTarget();
				if (target1 == 1)
				{
					if (player1.getPlayer1Health() <= 0 
							|| FusedPlayer.getFusionType() == fusion.getAttackTank() 
							|| FusedPlayer.getFusionType() == fusion.getAttackMage() 
							|| FusedPlayer.getFusionType() == fusion.getAttackCrafter())
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target1Name = player1.toString();
					}
				}
				else if (target1 == 2)
				{
					if (player2.getPlayer2Health() <= 0 
							|| FusedPlayer.getFusionType() == fusion.getAttackTank() 
							|| FusedPlayer.getFusionType() == fusion.getTankMage() 
							|| FusedPlayer.getFusionType() == fusion.getTankCrafter())
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target1Name = player2.toString();
						player2Target1 = true;
					}
				}
				else if (target1 == 3)
				{
					if (player3.getPlayer3Health() <= 0 
							|| FusedPlayer.getFusionType() == fusion.getAttackMage() 
							|| FusedPlayer.getFusionType() == fusion.getTankMage() 
							|| FusedPlayer.getFusionType() == fusion.getMageCrafter())
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target1Name = player3.toString();
					}
				}
				else if (target1 == 4)
				{
					if (player4.getPlayer4Health() <= 0 
							|| FusedPlayer.getFusionType() == fusion.getAttackCrafter() 
							|| FusedPlayer.getFusionType() == fusion.getTankCrafter() 
							|| FusedPlayer.getFusionType() == fusion.getMageCrafter())
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target1Name = player4.toString();
					}
				}
				else if (target1 == 5)
				{
					validChoice = true;
					target1Name = fusion.toString();
				}
			} while (!(validChoice));
			validChoice = false;
			while (!validChoice && !onePlayer.isOnePlayer())
			{
				target2 = fullPower.getTarget();
				if (target2 == 1)
				{
					if (player1.getPlayer1Health() <= 0 || target1 == 1 
							|| FusedPlayer.getFusionType() == fusion.getAttackTank() 
							|| FusedPlayer.getFusionType() == fusion.getAttackMage() 
							|| FusedPlayer.getFusionType() == fusion.getAttackCrafter())
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target2Name = player1.toString();
					}
				}
				else if (target2 == 2)
				{
					if (player2.getPlayer2Health() <= 0 || target1 == 2 
							|| FusedPlayer.getFusionType() == fusion.getAttackTank() 
							|| FusedPlayer.getFusionType() == fusion.getTankMage() 
							|| FusedPlayer.getFusionType() == fusion.getTankCrafter())
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target2Name = player2.toString();
						player2Target2 = true;
					}
				}
				else if (target2 == 3)
				{
					if (player3.getPlayer3Health() <= 0 || target1 == 3 
							|| FusedPlayer.getFusionType() == fusion.getAttackMage() 
							|| FusedPlayer.getFusionType() == fusion.getTankMage() 
							|| FusedPlayer.getFusionType() == fusion.getMageCrafter())
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target2Name = player3.toString();
					}
				}
				else if (target2 == 4)
				{
					if (player4.getPlayer4Health() <= 0 || target1 == 4 
							|| FusedPlayer.getFusionType() == fusion.getAttackCrafter() 
							|| FusedPlayer.getFusionType() == fusion.getTankCrafter() 
							|| FusedPlayer.getFusionType() == fusion.getMageCrafter())
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target2Name = player4.toString();
					}
				}
				else if (target2 == 5)
				{
					if (target1 == 5)
					{
						validChoice = false;
					}
					else
					{
						validChoice = true;
						target2Name = fusion.toString();
					}
				}
			}
			validChoice = false;
			if (player2.isHumanShieldSkill())
			{
				player1.removeHumanShieldTarget();
				player3.removeHumanShieldTarget();
				player4.removeHumanShieldTarget();
				fusion.removeHumanShieldTarget();
				do 
				{
					if (player2Target1 && onePlayer.isOnePlayer())
					{
					}
					else if (player2Target1)
					{
						humanShieldTarget = target2Name;
					}
					else if (player2Target2)
					{
						humanShieldTarget = target1Name;
					}
					else
					{
						humanShieldTarget = JOptionPane.showInputDialog("Who do you want to protect?\n" 
							+ target1Name + "\n" + target2Name);
						if (humanShieldTarget == null)
						{
							humanShieldTarget = "null";
						}
					}
					if (humanShieldTarget.equalsIgnoreCase(player1.toString()))
					{
						if (player1.getPlayer1Health() <= 0)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is dead");
						}
						else if (target1 != 1 && target2 != 1)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is not being attacked");
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
						else if (target1 != 3 && target2 != 3)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is not being attacked");
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
						else if (target1 != 4 && target2 != 4)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is not being attacked");
						}
						else
						{
							validChoice = true;
							player4.setHumanShieldTarget();
						}
					else if (humanShieldTarget.equalsIgnoreCase(fusion.toString()))
						if (target1 != 5 && target2 != 5)
						{
							validChoice = false;
							JOptionPane.showMessageDialog(null, "This player is not being attacked");
						}
						else
						{
							validChoice = true;
							fusion.setHumanShieldTarget();
						}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
						validChoice = false;
					}
				} while (!validChoice);
			} 
			if (target1 == 1)
			{
				if (player1.isUltimate())
				{
					damageDealt = ultimate1.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					ultimate1.addKi(damageDealt);
					ultimate1.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
				else
				{
					damageDealt = player1.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					player1.addKi(damageDealt);
					player1.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
			}
			else if (target1 == 2)
			{
				if (player2.isUltimate())
				{
					damageDealt = ultimate2.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					ultimate2.addKi(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
				else
				{
					damageDealt = player2.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					player2.addKi(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
			}
			else if (target1 == 3)
			{
				if (player3.isUltimate())
				{
					damageDealt = ultimate3.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					ultimate3.addKi(damageDealt);
					ultimate3.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
				else
				{
					damageDealt = player3.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					player3.addKi(damageDealt);
					player3.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
			}
			else if (target1 == 4)
			{
				if (player4.isUltimate())
				{
					damageDealt = ultimate4.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					ultimate4.addKi(damageDealt);
					ultimate4.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
				else
				{
					damageDealt = player4.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					player4.addKi(damageDealt);
					player4.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
			}
			else if (target1 == 5)
			{
				damageDealt = fusion.takeDamage(brolyAttack);
				fullPower.addKi(damageDealt);
				fusion.addKi(damageDealt);
				fusion.reduceMomentum(damageDealt);
				fullPower.addMomentum(damageDealt);
				brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
			}
			if (target2 == 1)
			{
				if (player1.isUltimate())
				{
					damageDealt = ultimate1.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					ultimate1.addKi(damageDealt);
					ultimate1.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
				else
				{
					damageDealt = player1.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					player1.addKi(damageDealt);
					player1.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
			}
			else if (target2 == 2)
			{
				if (player2.isUltimate())
				{
					damageDealt = ultimate2.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					ultimate2.addKi(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
				else
				{
					damageDealt = player2.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					player2.addKi(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
			}
			else if (target2 == 3)
			{
				if (player3.isUltimate())
				{
					damageDealt = ultimate3.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					ultimate3.addKi(damageDealt);
					ultimate3.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
				else
				{
					damageDealt = player3.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					player3.addKi(damageDealt);
					player3.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
			}
			else if (target2 == 4)
			{
				if (player4.isUltimate())
				{
					damageDealt = ultimate4.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					ultimate4.addKi(damageDealt);
					ultimate4.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
				else
				{
					damageDealt = player4.takeDamage(brolyAttack);
					fullPower.addKi(damageDealt);
					player4.addKi(damageDealt);
					player4.reduceMomentum(damageDealt);
					fullPower.addMomentum(damageDealt);
					brolyAttack = fullPower.getGiganticChargeFullPowerDamage();
				}
			}
			else if (target2 == 5)
			{
				damageDealt = fusion.takeDamage(brolyAttack);
				fullPower.addKi(damageDealt);
				fusion.addKi(damageDealt);
				fusion.reduceMomentum(damageDealt);
				fullPower.addMomentum(damageDealt);
			}
		}
	}
	public static void phase3(Broly fullPower, AttackerClass user1, TankClass user2, MageClass user3, ItemCrafter user4, PlayerStatus onePlayer) {
		PlayerStatus gameOver = new PlayerStatus();
		do//This loop runs the game
		{
				playerMenu(fullPower, user1, user2, user3, user4);
				if (Broly.getOmegaBlasterHealth() > 0)
				{
					fullPower.reduceOmegaBlasterBarrierHealthFullPower();
				}
				if (gameOver.getPlayerStatus())
				{
					brolyFullPowerSuperSaiyanTurn(fullPower, user1, user2, user3, user4);
				}
		} while (fullPower.getBrolyHealth() > 0 && ((gameOver.getPlayerStatus())));//This condition decides when phase 3 ends
	}
}