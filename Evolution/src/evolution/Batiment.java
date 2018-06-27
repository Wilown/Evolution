package evolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Batiment {
	
	private int id;
	private String name;
	private Ressource ressource;
	private List mechants;
	private byte stock;
	private byte vie;
	private char etat;
	
	
	public Batiment () {
		this.id= Main.compteurId();
		this.name="";
		Random rn = new Random();
		int b = rn.nextInt((4-1)+1)+1;
		String c= String.valueOf(b);
		this.ressource= Ressource.valueOf(c);		
		this.mechants = new ArrayList();
		this.stock = (byte) (rn.nextInt((100-1)+1)+1);
		this.vie = (byte) (rn.nextInt((100-1)+1)+1);
		this.etat = 'L';
	}
	
	public Batiment (String tmpName) {
		this.id= Main.compteurId();
		this.name=tmpName;
		Random rn = new Random();
		int b = rn.nextInt((4-1)+1)+1;
		String c= String.valueOf(b);
		this.ressource= Ressource.fromString(c);
		this.mechants = new ArrayList();
		this.stock = (byte) (rn.nextInt((100-1)+1)+1);
		this.vie = (byte) (rn.nextInt((100-1)+1)+1);
		this.etat = 'L';
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
	
	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public List getMechants() {
		return mechants;
	}

	public void setMechants(List mechants) {
		this.mechants  = mechants;
	}

	public byte getStock() {
		return stock;
	}

	public void setStock(byte stock) {
		this.stock = stock;
	}

	public byte getVie() {
		return vie;
	}

	public void setVie(byte vie) {
		this.vie = vie;
	}

	public char getEtat() {
		return etat;
	}

	public void setEtat(char etat) {
		this.etat = etat;
	}
	
	
}
