package evolution;

import java.util.ArrayList;
import java.util.Random;

public class Combat {
	public boolean combattre (Personnage heros, Batiment batiment) {

		boolean issueCombat = false;

		for (int i = 0; i<5; i++)
		{
			ArrayList<Mechants> tmpMechant= (ArrayList<Mechants>)(batiment.getMechants());
			//System.out.println(i);
			Mechants mechant = (Mechants) tmpMechant.get(i);
			while (mechant.getLife()>0||heros.getLife()>0)
			{
				Random rn = new Random();
				attaqueHeros(heros, mechant);
				if (mechant.getLife()<1)
				{
					System.out.println(heros.getName() + " is victorious.");
					if (i==4) {
						issueCombat =true;
						heros.setLife(heros.getLifeMax());
						return issueCombat;
					}
					else break;
				}			
				attaqueMechant(heros, mechant);
				if (heros.getLife()<1)
				{
					System.out.println(mechant.getName() + " is victorious.");
					heros.setLife(heros.getLifeMax());
					return issueCombat;
				}

			}

		}
		return issueCombat;
	}	



	public void attaqueHeros (Personnage heros, Mechants mechant) {
		Random rn = new Random();
		int degatsHeros = rn.nextInt((heros.getDamages())-0+1)+0;
		if ((degatsHeros-mechant.getArmor())>1)
		{
			mechant.setLife((byte)(mechant.getLife()-degatsHeros+mechant.getArmor()));
		}
		else
		{
			mechant.setLife((byte)(mechant.getLife()-1));
		}
		System.out.println(mechant.getLife() + "life points left on "+mechant.getName()+".");
	}

	public void attaqueMechant (Personnage heros, Mechants mechant) {
		Random rn = new Random();
		int degatsMechant = rn.nextInt((mechant.getDamages())-0+1)+0;
		if ((degatsMechant-heros.getArmor())>1)
		{
			heros.setLife((byte)(heros.getLife()-degatsMechant+heros.getArmor()));
		}
		else
		{
			heros.setLife((byte)(heros.getLife()-1));
		}

		System.out.println(heros.getLife() + "life points left on "+heros.getName()+ ".");
	}
}

