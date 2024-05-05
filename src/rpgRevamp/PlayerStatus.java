package rpgRevamp;

public class PlayerStatus {
	private boolean playerAlive;
	AttackerClass player1 = new AttackerClass();
	TankClass player2 = new TankClass();
	MageClass player3 = new MageClass();
	ItemCrafter player4 = new ItemCrafter();
	
	public boolean getPlayerStatus() {
		if (FusedPlayer.isFused())
		{
			return true;
		}
		if (player1.getPlayer1Health() <= 0)
		{
			if (player2.getPlayer2Health() <= 0)
			{
				if (player3.getPlayer3Health() <= 0)
				{
					if (player4.getPlayer4Health() <= 0)
					{
						playerAlive = false;
					}
					else 
					{
						playerAlive = true;
					}
				}
				else 
				{
					playerAlive = true;
				}
			}
			else 
			{
				playerAlive = true;
			}
		}
		else 
		{
			playerAlive = true;
		}
		return playerAlive;
	}
	
	public boolean isOnePlayer() {
		if (player1.getPlayer1Health() < 1)
		{
			if (player2.getPlayer2Health() < 1)
			{
				if (player3.getPlayer3Health() < 1)
				{
					return true;
				}
				else if (player4.getPlayer4Health() < 1)
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
			else if (player3.getPlayer3Health() < 1)
			{
				if (player4.getPlayer4Health() < 1)
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else if (player2.getPlayer2Health() < 1)
		{
			if (player3.getPlayer3Health() < 1)
			{
				if (player4.getPlayer4Health() < 1)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	public boolean isDragonBallsUsable() {
		if (player1.getPlayer1Health() <= 0)
		{
			if (player2.getPlayer2Health() <= 0)
			{
				if (player3.getPlayer3Health() <= 0)
				{
					if (player4.getPlayer4Health() <= 0)
					{
						playerAlive = false;
					}
					else 
					{
						playerAlive = true;
					}
				}
				else 
				{
					playerAlive = true;
				}
			}
			else 
			{
				playerAlive = true;
			}
		}
		else 
		{
			playerAlive = true;
		}
		return playerAlive;
	}
}