//Pedro Salazar

			// Update Constructor for FloodZone and Subdivision

public class ResidentialProperty extends Property implements Exemption
{
	public enum Subdivision {NONE,KINGLY_ESTATES,STATELY_ESTATES,KING_MANOR,GREEN_GABLES};
	private Subdivision subdivision; //= Subdivision.NONE;
	private boolean floodZone = false;
	private double exemption;

	public ResidentialProperty()
	{
		super();
		setExemption(0.0);
	}

	public  ResidentialProperty(int n, Address a, double v, Date d, int f,double e)
	{
		
		setAccountNumber(n);
		setPropertyAddress(a);
		setMarketValue(v);
		setDatePurchased(d);
		setSquareFeet(f);
		setExemption(e);
	}

	public void setSubdivision(Subdivision s)
	{
		subdivision = s;	
	}

	public void setFloodZone(boolean z)
	{
		floodZone = z;
	}

	public void setExemption(double a)
	{
		exemption = a;

	}

	public Subdivision getSubdivision()
	{
		return subdivision;
	}

	public boolean getFloodZone()
	{
		return floodZone;
	}

	public double getExemption()
	{
		return exemption;
	}

	public String toString()
	{
		return super.toString() + "\nSubdivision: " + getSubdivision() + "\nFlood Zone: " + getFloodZone(); 


	}
	
	public double calculateTaxes()
	{
		
		double tax;

		tax = .05 * getSquareFeet();
		
		if(getPropertyTier() == Property.PropertyTier.TIER1)
			tax += getMarketValue() * TIER1 /100;

		else if(getPropertyTier() == Property.PropertyTier.TIER2)
			tax += getMarketValue() * TIER2 / 100;

		else if(getPropertyTier() == Property.PropertyTier.TIER3)
			tax += getMarketValue() * TIER3 / 100;

		else if(getPropertyTier() == Property.PropertyTier.TIER4)
			tax += getMarketValue() * TIER4 / 100;

	
		return tax;


	}

	public String calculateExemption()	
	{
		


		setExemption(getMarketValue() * COUNTY/100 + getMarketValue() * CITY/100 + getMarketValue() * SCHOOL/100 + getMarketValue() * MEDICAL/100);


		String msg = "";

		msg += String.format("      County $%,.2f    City $%,.2f    School $%,.2f    Medical $%,.2f", ((getMarketValue()*COUNTY/100)), ((getMarketValue()*CITY/100)), ((getMarketValue()*SCHOOL/100)), ((getMarketValue()*MEDICAL/100))); 
			 
		return msg ;


	}

}

	