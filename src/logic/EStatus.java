// https://stackoverflow.com/questions/29515366/how-to-display-all-possible-enum-values-in-a-dropdown-list-using-spring-and-thym
// https://dzone.com/articles/using-java-enums
package logic;

import java.io.Serializable;

public enum EStatus implements Serializable 
{
	ACTIEF ("Actief"),	
	NONACTIEF ("Non actief"), 
	INGEBRUIK ("In gebruik"), 
	INREPARATIE ("In reparatie");
	
	static final EStatus DEFAULT = ACTIEF;
	
	private final String displayName;
	 
	EStatus (String displayName)
	{
		this.displayName = displayName;
	}
	 
	public String getDisplayName()
	{
		return displayName;
	}
}
