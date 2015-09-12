
public class CommercialProperty extends Property implements TaxRates
{
	private String businessName;
	private String stateCode;

	public CommercialProperty()
	{
		super();
		setBusinessName("");
		setStateCode("");
	}
									//f and s in class Property= squareFeet
	public CommercialProperty(int n, Address a, double v, Date d, int f, String b, String c)
	{
		setAccountNumber(n);
		setPropertyAddress(a);
		setMarketValue(v);
		setDatePurchased(d);
		setSquareFeet(f);
		setBusinessName(b);
		setStateCode(c);
	}

	public void setBusinessName (String b)
	{
		businessName = b;
	
	}

	public void setStateCode (String c)
	{
		stateCode = c;
	}

	public String getBusinessName()
	{
		return businessName;
	}

	public String getStateCode()
	{
		return stateCode;
	}

	public String toString()
	{
		return(super.toString() + "\nBusiness Name: " +getBusinessName() +
			"\nState Code: " + getStateCode());
	}


	public double calculateTaxes()
	{	
		double tax;

		tax = .25 * getSquareFeet();
		
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
		


  
}
