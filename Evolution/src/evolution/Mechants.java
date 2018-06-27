package evolution;

import java.util.Random;

public class Mechants extends Personnage {
	

	
	public Mechants (String tmpName) {
		super(tmpName);
		Random rn = new Random();
		super.setDegats((byte) (rn.nextInt((6-1)+1)+1));
		super.setLife ((byte) (rn.nextInt((25-5)+1)+5));
		super.setArmor ((byte)1);
		super.setLifeMax(super.getLife());
	}
	
	public Mechants (String tmpName, byte tmpDamages, byte tmpLife, byte tmpArmor) {
		super(tmpName);
		super.setDegats(tmpDamages);
		this.setLife(tmpLife);
		this.setArmor(tmpArmor);
		super.setLifeMax(super.getLife());
	}
	
}
