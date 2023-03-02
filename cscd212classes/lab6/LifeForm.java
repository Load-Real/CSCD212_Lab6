package cscd212classes.lab6;

public class LifeForm {
	private String name;
	private int currentLifePoints;
	
	public LifeForm (final String name, final int currentLifePoints) {
		if (name == null || name.isEmpty()) throw new IllegalArgumentException("Bad Params in LifeForm Constructor");
		if (currentLifePoints <= 0) throw new IllegalArgumentException("Bad Params in LifeForm Constructor");
		this.name = name;
		this.currentLifePoints = currentLifePoints;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCurrentLifePoints() {
		return this.currentLifePoints;
	}
}
