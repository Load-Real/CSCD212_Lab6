package cscd212classes.lab6;

public class Environment {
	private Cell[][] cells;
	
	public Environment(final Cell[][] cells) {
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[0].length; col++) {
				cells[row][col] = new Cell();
			}
		}
		this.cells = cells;
	}
	
	public boolean addLifeForm(final int row, final int col, final LifeForm entity) {
		if(row < 0 || col < 0) throw new IllegalArgumentException("Bad Params in addLifeForm");
		if(row > this.cells.length || col > this.cells.length) throw new ArrayIndexOutOfBoundsException("Row and Col Params OutOfBounds");
		if (entity != null) {
			cells[row][col].addLifeForm(entity);
			return true;
		}
		return false;
	}
	
	public LifeForm getLifeForm(final int row, final int col) {
		if (row < 0 || col < 0) throw new IllegalArgumentException("Bad Params in getLifeForm");
		if(this.cells[row][col] == null) return null;
		return this.cells[row][col].getLifeForm();
		
	}
	
	public LifeForm removeLifeForm(final int row, final int col) {
		if (row < 0 || col < 0) throw new IllegalArgumentException("Bad Params in removeLifeForm");
		if (this.cells[row][col] != null) {
			LifeForm tempCells = this.cells[row][col].getLifeForm();
			this.cells[row][col].removeLifeForm();
			return tempCells;
		}
		return null;
	}
}