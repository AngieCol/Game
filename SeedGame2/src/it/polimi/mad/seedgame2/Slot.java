
package it.polimi.mad.seedgame2;


public class Slot {

	/**
	 * Type of the slot. It can be B1, B2, T1, T2, N. Where N is a not allowed position. 
	 */
	String type="";
	int numSeed=0;
	static int initialSeed=3;
	
	
	
	
	/**
	 * Constructor	
	 * @param type
	 */
	public Slot(String type)
	{
	  this.type =type; 
	  this.numSeed=initialSeed;
	  
	  
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public int getNumSeed() {
		return numSeed;
	}




	public void setNumSeed(int numSeed) {
		this.numSeed = numSeed;
	}

}
