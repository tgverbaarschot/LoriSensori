package logic;

import java.io.Serializable;

public enum EBerichtType implements Serializable 
{
	ONGEWENSTE_NIVEAU_DALING("diefstal alarm"),
	TANKEN("tank bericht"),
	GEGEVENS_WIJZINGING_WERKNEMER("werknemergegevens gewijzigd"),
	LAAG_SPANNINGS_NIVEAU_ACCU("accu bericht"),
	SLOT_OPEN("slot status gewijzigd");
	
	static final EBerichtType DEFAULT = null;
	
	private final String displayName;
	 
	EBerichtType (String displayName)
	{
		this.displayName = displayName;
	}
	 
	public String getDisplayName()
	{
		return displayName;
	}
}
