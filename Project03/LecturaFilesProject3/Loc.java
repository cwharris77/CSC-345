public class Loc {
    public final int row;
    public final int col;
    private String val;
    private boolean isVisited;
    private boolean inQ;
    private boolean inPath;
    
    //constructor
    //x is row, y is column
    public Loc(int x, int y, String val) {
	this.row = x;
	this.col = y;
	this.val = val;
	this.isVisited = false;
	this.inQ = false;
	this.inPath = false;
    }

    //returns Loc in the form (row, col)
    public String toString() {
	return "(" + row + ", " + col + ")";
    }

    //returns the String value at this location
    public String getVal() {
	return val;
    }
    
    public void setVisited() {
    	this.isVisited = true;
    }
    public void removeVisited() {
    	this.isVisited = false;
    }
    
    public boolean isVisited() {
    	return this.isVisited;
    }
    
    
    public void setInQ() {
    	this.inQ = true;
    }
    
    public void removeFromQ() {
    	this.inQ = false;
    }
    
    public boolean getInQ() {
    	return this.inQ;
    }
    
    public boolean inPath() {
    	return inPath;
    }
    
    public void setInPath() {
    	inPath = true;
    }
    
    public void removeFromPath() {
    	inPath = false;
    }
    
}
