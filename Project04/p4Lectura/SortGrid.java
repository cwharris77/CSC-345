
public class SortGrid {
	/**
	 * Sorts the grid using insertion sort
	 * @param grid - the grid passed in
	 */
	public static void sortA(Grid grid) {
		int width = 0;
		
		// find the width of the grid
		for (int i = 0; i < grid.size(); i++) {
			int y = 0;
			if (grid.getIntVal(i, y) != -999) {
				width += 1;
			} else break;
		}
		
		int x = 0;
		int j = 0;
		// j = current index
		while (j / grid.size() < grid.size()) {
			int y = j;
			// modified insertion sort
			while (y - 1 >= 0) {
				// if a[i] < a[i - 1] swap them
				if (grid.getIntVal(x % grid.size(), y % grid.size()) < grid.getIntVal(x % grid.size(), y - 1 % grid.size())){
					grid.swap(x % grid.size(), y % grid.size(), x % grid.size(), y - 1 % grid.size());
					y--;
				} 
				// if the y val reaches the end of a row check the next one
				else if (y % 10 == width - 1) {
					if (grid.getIntVal(x % grid.size() + 1, 0) < grid.getIntVal(x % grid.size(), width - 1)){
						grid.swap(x % grid.size() + 1, 0, x % grid.size(), width - 1);
						x++;
						y=0;
					} else {
						break;
					}
				} 
				else {
					break;
				}
			}
			
			j++;
			// if j is an index at the end of the row, start checking the next row
			if (j % 10 == 0) {
				x++;
			}	
		}	
	}
	
	/**
	 * Could not get either working so use sortA
	 * @param grid
	 */
	public static void sortB(Grid grid) {
		sortA(grid);
	}
}
