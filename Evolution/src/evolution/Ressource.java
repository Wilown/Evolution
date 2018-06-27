package evolution;

/**
 * @author PC29
 *
 */
public enum Ressource {

	Nouriture("1"),
	Materiel("2"),
	Energie("3");

	private int id;
	private String value;

	Ressource (String random){
		this.value=random;
	}

	public static Ressource fromString(String random) {
		for (Ressource reader : Ressource.values())
		{
			if(reader.value.equals(random)) {
				return reader;
			}
		}
		return null;
	}
}


