
package it.polimi.mad.seedgame2;


public class Slot {

	/**
	 * Type of the slot. It can be B1, B2, T1, T2, N. Where N is a not allowed position. 
	 */
	String type="";
	int numSeed=0;
	
	
	
	
	/**
	 * Constructor	
	 * @param type
	 */
	public Slot(String typeS, int seed)
	{
	  type =typeS; 
	  numSeed=seed;
	  
	  
	}




	public String getType() {
		return type;
	}




	public void setType(String typeS) {
		type = typeS;
	}




	public int getNumSeed() {
		return numSeed;
	}




	public void setNumSeed(int numSeedS) {
		numSeed = numSeedS;
	}
	
	public void sumSeed(int numSeedS) {
		numSeed = numSeed+ numSeedS;
	}

}
