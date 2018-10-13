// https://stackoverflow.com/questions/29515366/how-to-display-all-possible-enum-values-in-a-dropdown-list-using-spring-and-thym
// https://dzone.com/articles/using-java-enums
package logic;

import java.io.Serializable;

public enum EBericht implements Serializable 
{
	ONGEWENSTENIVEAUDALING ("Ongewenste Niveaudaling"),	
	TANKEN ("Bijtanken"), 
	LAAGSPANNINGSNIVEAUACCU ("Laag Spanningsniveau Accu"), 
	SLOTOPEN ("Slot open buiten openingstijden");
	
	static final EBericht DEFAULT = TANKEN;
	
	private final String displayName;
	 
	EBericht (String displayName)
	{
		this.displayName = displayName;
	}
	 
	public String getDisplayName()
	{
		return displayName;
	}
}
