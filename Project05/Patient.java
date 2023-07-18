public class Patient {
    private String name;
    private int urgency;
    private int time_in;

    public Patient(String name, int urgency, int time_in) {
	this.name = name;
	this.urgency = urgency;
        this.time_in = time_in;
    }
    
    public String name() {
	return this.name;
    }
    
    public int urgency() {
	return this.urgency;
    }

    public void setUrgency(int urgency) {
	this.urgency = urgency;
    }

    public int time_in() {
	return this.time_in;
    }

    public int compareTo(Patient other) {
	int diff = this.urgency - other.urgency();
	if(diff == 0) {
	    diff = other.time_in()-this.time_in;
	}
	return diff;
    }

    //includes time_in
    public String toString() {
	return name + ", " + urgency + ", " + time_in;
    }
    
    //does not include time_in
    public String toStringForTesting() {
	return name + ", " + urgency;
    }
}
