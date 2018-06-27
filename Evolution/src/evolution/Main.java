package evolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.Destination;

public class Main {

	private static int compteurId=0;
	private static int position[] = {0,0,0};
	private static Secteur[] tabSecteurs = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Condition to win, setted in gamecheck.
		boolean victory = false;

		tabSecteurs = generateworld();
		System.out.println("Welcome in EVOLUTION");
		Personnage Heros = generateCharacter();


		//Game is working, ennemies doesnt play yet, you can't build yet, and fifth building have a really tough boss.
		while (victory == false) {
			action(Heros);

			gamecheck(victory);
		}
	}

	/**
	 * Incomplete.
	 */
	private static boolean gamecheck(Boolean victory) {
		//check gamestatus
		boolean owning = true;
		for (int i = 0; i<tabSecteurs[position[0]].getVilles()[position[1]].getBatiments().size(); i++)
		{
			if (((Batiment)tabSecteurs[position[0]].getVilles()[position[1]].getBatiments().get(i)).getEtat()!='W') {
				owning = false;
				break;
			}
		}
		if (owning == true) {
			tabSecteurs[position[0]].getVilles()[position[1]].setEtat('W');
			System.out.println("vous avez conquis la ville "+ tabSecteurs[position[0]].getVilles()[position[1]].getName());
		}

		for (int i = 0; i<tabSecteurs[position[0]].getVilles().length; i++) {
			if (tabSecteurs[position[0]].getVilles()[position[i]].getEtat()!='W') {
				owning =false;
				break;
			}

		}
		if (owning == true) {
			tabSecteurs[position[0]].setEtat('W');
			System.out.println("Vous avez conquis "+tabSecteurs[position[0]].getName());
		}
		for (int i = 0; i<tabSecteurs.length;i++) {
			if(tabSecteurs[position[i]].getEtat()!='W') {
				owning = false;
			}
		}
		if (owning == true) {
			victory = true;
			return victory;
		}
		return victory;
	}

	/**
	 * @param Heros
	 * Menu of actions for the hero and actions management.
	 */
	private static void action(Personnage Heros) {
		System.out.println("What will be your next action ?");
		System.out.println("Press 1 to move to another location.\nPress 2 to attack your location\nPress 3 to build new facilities.\nPress 4 to know the status of the city and the building on your position.");
		Scanner input = new Scanner (System.in);
		byte answer = input.nextByte();
		switch (answer) {
		case 1:
			System.out.print("Your position is sector "+(position[0]+1)+" city "+(position[1]+1)+" building "+(position[2]+1)+".\nSelect your destination.\nSector : ");
			answer =-1;
			while (answer<1||answer>2) {
				input.nextLine();
				answer = input.nextByte();
				if (answer<1||answer>2) {
					System.out.println("There are two sectors. Select either the first one or the second one.");
				}
			}
			position[0]=answer-1;
			answer=-1;
			System.out.print("City : ");
			while (answer<1||answer>5) {
				answer = input.nextByte();
				if (answer<1||answer>5) {
					System.out.println("There are 5 cities on each sector. Select one of them.");
				}
			}
			position[1]=answer-1;
			answer =-1;
			System.out.print("Building : ");
			while (answer<1||answer>(tabSecteurs[position[0]].getVilles()[position[1]].getBatiments().size())) {
				input.nextLine();
				answer = input.nextByte();
				if (answer<1||answer>5) {
					System.out.println("There are "+(tabSecteurs[position[0]].getVilles()[position[1]].getBatiments().size())+" buildings on each sector. Select one of them.");
				}
			}
			position[2]= answer-1;
			break;
		case 2 :
			Batiment tmpBatiment = (Batiment)(tabSecteurs[position[0]].getVilles()[position[1]].getBatiments().get(position[2]));
			if (((Batiment)(tabSecteurs[position[0]].getVilles()[position[1]].getBatiments()).get(position[2])).getEtat()=='L') {
				Combat attaque = new Combat();
				boolean victoire = attaque.combattre(Heros, tmpBatiment);


				if (victoire == true) {
					System.out.println(tmpBatiment.getName() +" is now yours.");
					tmpBatiment.setEtat('W');

				}
				else {
					System.out.println("You are running home.");
					position[0]=0;
					position[1]=0;
					position[2]=0;
				}
			}
			else
			{
				System.out.println("You already conquered this Building.");
			}
			break;
		case 3 : 
			System.out.println("To be implemented");
			break;
		case 4 :
			System.out.print("The city's status is : "+tabSecteurs[position[0]].getVilles()[position[1]].getEtat());
			tmpBatiment =(Batiment)(tabSecteurs[position[0]].getVilles()[position[1]].getBatiments().get(position[3]));
			System.out.print("The building's status is : "+tmpBatiment);
		default:
			System.out.println("Bad command.");
			break;
		}
	}

	/**
	 * generate the world of the game.
	 */
	private static Secteur[] generateworld() {

		// mechants des batiments 1 à 4 de chaque ville. Chaque ville aura donc les mêmes méchants.
		List badguys = new ArrayList();
		badguys.add(new Mechants ("Mechant 1"));
		badguys.add(new Mechants ("Mechant 2"));
		badguys.add(new Mechants ("Mechant 3"));
		badguys.add(new Mechants ("Mechant 4"));
		badguys.add(new Mechants ("Boss", (byte)5, (byte)25, (byte) 2));


		//mechant du batiment 5 'big boss'
		List badguysbat5 = new ArrayList();
		badguysbat5.add(new Mechants ("Mechant 1"));
		badguysbat5.add(new Mechants ("Mechant 2"));
		badguysbat5.add(new Mechants ("Mechant 3"));
		badguysbat5.add(new Mechants ("Mechant 4"));
		badguysbat5.add(new Mechants("Saitama", (byte)20, (byte) 125, (byte) 3));

		// Creation de la première ville, de ses batiments aléatoires et ajout de la liste de méchant dans chaque batiment
		Ville ville1 = new Ville ("Ville1");
		ville1.addBatiments(new Batiment("Batiment1"));
		Batiment battemp = (Batiment)(ville1.getBatiments().get(0));
		battemp.setMechants(badguys);
		ville1.setBatiment(battemp, 0);
		ville1.addBatiments(new Batiment("Batiment2"));
		battemp = (Batiment)(ville1.getBatiments().get(1));
		battemp.setMechants(badguys);
		ville1.setBatiment(battemp, 1);
		ville1.addBatiments(new Batiment("Batiment3"));
		battemp = (Batiment)(ville1.getBatiments().get(2));
		battemp.setMechants(badguys);
		ville1.setBatiment(battemp, 2);
		ville1.addBatiments(new Batiment("Batiment4"));
		battemp = (Batiment)(ville1.getBatiments().get(3));
		battemp.setMechants(badguys);
		ville1.setBatiment(battemp, 3);
		ville1.addBatiments(new Batiment("Batiment5"));
		battemp = (Batiment)(ville1.getBatiments().get(4));
		battemp.setMechants(badguysbat5);
		ville1.setBatiment(battemp, 4);



		// Creation de la seconde ville sur le même principe.	
		Ville ville2 = new Ville ("Ville2");
		ville2.addBatiments(new Batiment("Batiment1"));
		battemp = (Batiment)(ville1.getBatiments().get(0));
		battemp.setMechants(badguys);
		ville2.setBatiment(battemp, 0);
		ville2.addBatiments(new Batiment("Batiment2"));
		battemp = (Batiment)(ville1.getBatiments().get(1));
		battemp.setMechants(badguys);
		ville2.setBatiment(battemp, 1);
		ville2.addBatiments(new Batiment("Batiment3"));
		battemp = (Batiment)(ville1.getBatiments().get(2));
		battemp.setMechants(badguys);
		ville2.setBatiment(battemp, 2);
		ville2.addBatiments(new Batiment("Batiment4"));
		battemp = (Batiment)(ville1.getBatiments().get(3));
		battemp.setMechants(badguys);
		ville2.setBatiment(battemp, 3);
		ville2.addBatiments(new Batiment("Batiment5"));
		battemp = (Batiment)(ville1.getBatiments().get(4));
		battemp.setMechants(badguysbat5);
		ville2.setBatiment(battemp, 4);

		// Creation du premier secteur et ajout du tableau des deux premières villes.				
		Secteur secteur1 = new Secteur ("secteur1");
		Ville tabvilles[] = new Ville[] {ville1, ville2};
		secteur1.setVilles(tabvilles);


		//Création de la troisième ville.
		Ville ville3 = new Ville ("Ville3");
		ville3.addBatiments(new Batiment("Batiment1"));
		battemp = (Batiment)(ville1.getBatiments().get(0));
		battemp.setMechants(badguys);
		ville3.setBatiment(battemp, 0);
		ville3.addBatiments(new Batiment("Batiment2"));
		battemp = (Batiment)(ville1.getBatiments().get(1));
		battemp.setMechants(badguys);
		ville3.setBatiment(battemp, 1);
		ville3.addBatiments(new Batiment("Batiment3"));
		battemp = (Batiment)(ville1.getBatiments().get(2));
		battemp.setMechants(badguys);
		ville3.setBatiment(battemp, 2);
		ville3.addBatiments(new Batiment("Batiment4"));
		battemp = (Batiment)(ville1.getBatiments().get(3));
		battemp.setMechants(badguys);
		ville3.setBatiment(battemp, 3);
		ville3.addBatiments(new Batiment("Batiment5"));
		battemp = (Batiment)(ville1.getBatiments().get(4));
		battemp.setMechants(badguysbat5);
		ville3.setBatiment(battemp, 4);


		//Création de la quatrième ville.
		Ville ville4 = new Ville ("Ville4");
		ville4.addBatiments(new Batiment("Batiment1"));
		battemp = (Batiment)(ville1.getBatiments().get(0));
		battemp.setMechants(badguys);
		ville4.setBatiment(battemp, 0);
		ville4.addBatiments(new Batiment("Batiment2"));
		battemp = (Batiment)(ville1.getBatiments().get(1));
		battemp.setMechants(badguys);
		ville4.setBatiment(battemp, 1);
		ville4.addBatiments(new Batiment("Batiment3"));
		battemp = (Batiment)(ville1.getBatiments().get(2));
		battemp.setMechants(badguys);
		ville4.setBatiment(battemp, 2);
		ville4.addBatiments(new Batiment("Batiment4"));
		battemp = (Batiment)(ville1.getBatiments().get(3));
		battemp.setMechants(badguys);
		ville4.setBatiment(battemp, 3);
		ville4.addBatiments(new Batiment("Batiment5"));
		battemp = (Batiment)(ville1.getBatiments().get(4));
		battemp.setMechants(badguysbat5);
		ville4.setBatiment(battemp, 4);


		//Deuxième secteur avec deuxième tableau composé des villes 3 et 4.
		Secteur secteur2 = new Secteur ("secteur2");
		Ville tabvilles2[] = new Ville[] {ville3, ville4};
		secteur2.setVilles(tabvilles2);

		Secteur tabsecteurs[] = new Secteur[] {secteur1, secteur2};
		return tabsecteurs;
	}


	/**
	 * Create the main character.
	 */
	private static Personnage generateCharacter() {
		System.out.print("We will start by creating your character.\nSelect a name for your character: ");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		Heros MC = new Heros (name);
		return MC;
	}

	public static int compteurId () {
		compteurId++;
		return compteurId;

	}
}
