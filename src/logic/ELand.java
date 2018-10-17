// https://stackoverflow.com/questions/29515366/how-to-display-all-possible-enum-values-in-a-dropdown-list-using-spring-and-thym
// https://dzone.com/articles/using-java-enums

package logic;

import java.io.Serializable;

public enum ELand implements Serializable 
{
	NEDERLAND ("Nederland"),	
	BELGIE ("Belgie"),
	LUXEMBURG ("Luxemburg"), 
	INREPARATIE ("In reparatie");
	
	static final ELand DEFAULT = NEDERLAND;
	
	private final String displayName;
	 
	ELand (String displayName)
	{
		this.displayName = displayName;
	}
	 
	public String getDisplayName()
	{
		return displayName;
	}
}