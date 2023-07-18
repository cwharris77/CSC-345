public class Puzzle {
    private Grid grid;

    //constructor--may be updated as necessary
    public Puzzle(Grid grid) {
    	this.grid = grid;
    }

    //required method to be implemented
    //find "word" in the grid starting at location (r, c)
    //return the path as a String
    public String find(String word, int r, int c) {
    	String letter = String.valueOf(word.charAt(0));
    	Loc location = new Loc(r, c, grid.getVal(r, c));
    	Deque<Loc> path = null;
    	
    	try {
			path = bfs(letter, location, word);
		} catch (EmptyDequeException e) {
			e.printStackTrace();
		}
    	
    	String ret = "";
    	while (!path.isEmpty()) {
    		try {
				ret += path.getLast().toString();
			} catch (EmptyDequeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		return ret;
	//TO BE IMPLEMENTED
    }
    
    public Deque<Loc> bfs(String letter, Loc location, String word) throws EmptyDequeException {
    	Deque<Loc> queue     = new Deque<>();
    	Deque<Loc> toBeReset = new Deque<>();
    	Deque<Loc> path      = new Deque<>();
    	Deque<Loc> dfsResets = new Deque<>();
    	
//    	System.out.println("Starting location: " + location.toString());
//    	System.out.println("Starting val: " + location.getVal());
    	
    	queue.addToBack(location);
    	location.setInQ();
    	
    	while (!queue.isEmpty()) {
    		Loc v = queue.getFirst();

    		// visit v and set its isVisited field to true 
    		v.setVisited();
    		
    		
    		// if the value of v matches the one that is being searched for start 
    		// the dfs function at that letter
    		if (v.getVal().equals(letter)) {
    			// an empty stack to push locations onto
    			path = new Deque<Loc>();
    			Deque<Loc> foundPath = depthFirst(word.substring(1), v, path, dfsResets);
//    			System.out.println("found: " + foundPath.stringValueOf());
//    			System.out.println("full word: " + word);
    			if (foundPath.stringValueOf().equals(word)) {
    				// resetting the nodes that have been marked as visited at
    				// the end of each search
    				while (!toBeReset.isEmpty()) {
    		    		Loc temp = toBeReset.getFirst();
    		    		temp.removeFromQ();
    		    		temp.removeVisited();
    		    	}
    				return foundPath;
    			} 
    		}
    		
    		
    		// UP, RIGHT, DOWN, LEFT
    		// row and col mod control which space next to location to search 
    		int rowMod = -1;
    		int colMod = 0;
    		int col = v.col;
			int row = v.row;
			
    		for (int i = 0; i < 4; i++) {
    			if (i == 1) {
    				rowMod = 0;
    				colMod = 1;
    			} else if(i == 2) {
    				rowMod = 1;
    				colMod = 0;
    			} else if (i == 3) {
    				rowMod = 0;
    				colMod = -1;
    			}
    			Loc tempLoc = grid.getLoc(row + rowMod, col + colMod);
    			// if the location exists and has not been searched put it in the queue
    			if (tempLoc != null) {
    				if (!tempLoc.getInQ() && !tempLoc.isVisited()) {
        				queue.addToBack(tempLoc);
        				tempLoc.setInQ();
        				toBeReset.addToBack(tempLoc);
        			}
    			}
    		}
    	}
    	// If a path is not found reset visited nodes for next search
    	while (!toBeReset.isEmpty()) {
    		Loc temp = toBeReset.getFirst();
    		temp.removeFromQ();
    		temp.removeVisited();
    	}
    	
    	return path;
    }
   
    public Deque<Loc> depthFirst(String word, Loc l, Deque<Loc> path, Deque<Loc> resetVals) throws EmptyDequeException {
    	path.addToFront(l);
    	// if the word is empty the correct path has been found
    	if (word.isEmpty() || path.isFound()) {
    		path.setFound();
    		return path;
    	}
    	else {
    		Deque<String> vals = new Deque<>();
    		Deque<Loc> neighbors = new Deque<>();
    		// the value of the current location's neighbors
    		vals.addToBack(grid.getVal(l.row - 1, l.col));  
    		vals.addToBack(grid.getVal(l.row, l.col + 1));
    		vals.addToBack(grid.getVal(l.row + 1, l.col));
    		vals.addToBack(grid.getVal(l.row, l.col - 1));
    		// the loc objects that are the current loc's neighbors
    		neighbors.addToBack(grid.getLoc(l.row - 1, l.col));  
    		neighbors.addToBack(grid.getLoc(l.row, l.col + 1));
    		neighbors.addToBack(grid.getLoc(l.row + 1, l.col));
    		neighbors.addToBack(grid.getLoc(l.row, l.col - 1));
    		// while there are still neighbors left to search
    		while (!neighbors.isEmpty()) {
    			String temp = vals.getFirst();
    			Loc neighbor = neighbors.getFirst();
    			// if the neighbor is the value of the letter call dfs on it
    			if (temp != null && temp.equals(String.valueOf(word.charAt(0))) && !neighbor.inPath()) {
    				depthFirst(word.substring(1), neighbor, path, resetVals);
    				// return immediately, don't search anything else
    				if (path.isFound()) {
    					return path;
    				}
    			}
    		}
    		// if a path fails, remove it from the stack
    		path.getFirst();
    	}
    	// if no path is found return an empty path
    	return path;
    }
}
    
