package evolution;

public abstract class Personnage {

	private int id;
	private String name;
	private byte damages;
	private byte life;
	private byte armor;
	private byte lifeMax;
	

	
	public Personnage (String tmpName) {
	this.id = Main.compteurId();
	this.name = tmpName;
	this.damages = 10;
	this.life = 75;
	this.armor = 3;
	this.lifeMax = 75;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getDamages() {
		return damages;
	}

	public void setDegats(byte tmpDamages) {
		this.damages = tmpDamages;
	}

	public byte getLife() {
		return life;
	}

	public void setLife(byte tmpLife) {
		this.life = tmpLife;
	}

	public byte getArmor() {
		return armor;
	}

	public void setArmor(byte tmpArmor) {
		this.armor = tmpArmor;
	}

	public byte getLifeMax() {
		return lifeMax;
	}

	public void setLifeMax(byte lifeMax) {
		this.lifeMax = lifeMax;
	}
	
	
}
