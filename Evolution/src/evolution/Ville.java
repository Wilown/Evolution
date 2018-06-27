package evolution;

import java.util.ArrayList;
import java.util.List;

public class Ville{

	private int id;
	private String name;
	private List Batiments;
	private char etat;


	public Ville() {
		// TODO Auto-generated constructor stub
		this.id = Main.compteurId();
		this.Batiments = new ArrayList();
		this.etat = 'L';
	}
	public Ville(String tmpName) {
		// TODO Auto-generated constructor stub
		this.id = Main.compteurId();
		this.name = tmpName;
		this.Batiments = new ArrayList();
		this.etat ='L';
	}
	public Ville(String tmpName, List tmpBatiments) {
		// TODO Auto-generated constructor stub
		this.id = Main.compteurId();
		this.name = tmpName;
		this.Batiments = tmpBatiments;
		this.etat ='L';
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", name=" + name + ", Batiments=" + Batiments + ", etat=" + etat + "]";
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getBatiments() {
		return Batiments;
	}
	public void addBatiments(Batiment batiments) {
		Batiments.add(batiments);
	}
	public char getEtat() {
		return etat;
	}
	public void setEtat(char etat) {
		this.etat = etat;
	}

	public void setBatiment(Batiment batiment, int i) {
		Batiments.set(i, batiment);
	}


}
