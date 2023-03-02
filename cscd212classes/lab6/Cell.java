package cscd212classes.lab6;

public class Cell {
	private LifeForm entity;
	
	//Returns the LifeForm in the Cell.
	public LifeForm getLifeForm() {
		return this.entity;
	}
	
	/*
	 * Add a LifeForm as a private data member, store it in class level variable (static)
	 * Adds a LifeForm to this Cell. 
	 * Will not add if LifeForm is already in the Cell. 
	 * Returns true if added, false otherwise.
	 */
	public boolean addLifeForm(final LifeForm entity) {
		if (this.entity == null) {
			/*Set the passed in null entity to the bob entity passed
			 * into this method
			 */
			this.entity = entity;
			return true;
		}
		return false;
	}
	
	/*
	 * – Removes the LifeForm in the Cell. 
	 * - Returns the LifeForm removed, null 
	 * if no LifeForm in the Cell.
	 */
	public LifeForm removeLifeForm() {
		if (this.entity != null) {
			LifeForm removedLF = this.entity;
			this.entity = null;
			return removedLF;
		}
		return null;
	}
}
