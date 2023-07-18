public class MaxPQ {
    /***
     *constructor: constructs a new 
     *MaxPQ with starting capacity of 10
     ***/
    public MaxPQ() {
	//TO BE IMPLEMENTED
    }

    /***
     *@param item to be inserted into PQ
     *if the array is full after the insert, 
     *resize the array to be twice as large
     ***/
    public void insert(Patient item) {
	//TO BE IMPLEMENTED
    }

    /***
     *@return and remove the max item in the PQ and re-heapify
     *throw EmptyQueueException if the PQ is empty
     ***/
    public Patient delMax() throws EmptyQueueException {
	//TO BE IMPLEMENTED
    }

    /***
     *@return but do not remove the max item in the PQ
     *throw EmptyQueueException if the PQ is empty
     ***/
    public Patient getMax() throws EmptyQueueException {
	//TO BE IMPLEMENTED
    }

    /***
     *@return the number of items currently in 
     *the PQ
     ***/
    public int size() {
	//TO BE IMPLEMENTED
    }

    /***
     *@return true if the PQ is empty and false
     *otherwise
     ***/
    public boolean isEmpty() {
	//TO BE IMPLEMENTED
    }

    /***
     *@return the patient with name s
     *remove and return the patient with name s
     ***/
    public Patient remove(String s) {
	//TO BE IMPLEMENTED
    }

    /***
     *@param s the name of the patient
     *@param urgency the patient's new urgency level
     ***/
    public void update(String s, int urgency) {
	//TO BE IMPLEMENTED
    }
}
    
