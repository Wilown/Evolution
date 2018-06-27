package evolution;



public class Secteur {

	private int id;
	private String name;
	private Ville Villes[];
	private char etat = 'L';
	
	
	public Secteur () {
		this.id=Main.compteurId();
		this.name="";
		this.Villes = new Ville[2] ;
	}
	
	public Secteur (String tmpName) {
		this.id=Main.compteurId();
		this.name=tmpName;
		this.Villes= new Ville[2];
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

	public Ville[] getVilles() {
		return this.Villes;
	}
	

	public void setVilles(Ville[] villes) {
		Villes = villes;
	}

	public char getEtat() {
		return etat;
	}

	public void setEtat(char etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Secteur [id=" + id + ", name=" + name + ", Villes=" + Villes + "]";
	}
	
}
