//Pedro Salazar

		// Update Constructor for PropertyTier 

public abstract class Property implements TaxRates
{
	private int accountNumber;
	private Address propertyAddress;
	private double marketValue;
	private Date datePurchased;
	private int squareFeet;
	public enum PropertyTier {TIER1, TIER2, TIER3, TIER4};
	private PropertyTier propertyTier; //= PropertyTier.TIER1;

	public Property()		
	{
		setAccountNumber(0);
		setPropertyAddress(new Address()); 	
		setMarketValue(0.0);
		setDatePurchased(new Date());	
		setSquareFeet(0);	
	}

	public Property(int n, Address a, double v, Date d, int s)
	{
		setAccountNumber(n);
		setPropertyAddress(a);
		setMarketValue(v);
		setDatePurchased(d);
		setSquareFeet(s);

	}
	
	public void setAccountNumber(int n)
	{
		accountNumber = n;
	}

	public void setPropertyAddress(Address a)
	{
		propertyAddress = a;
	}

	public void setMarketValue(double v)
	{
		marketValue = v;
	}

	public void setDatePurchased(Date d)
	{
		datePurchased = d;
	}

	public void setSquareFeet(int f)
	{
		squareFeet = f;
	}

	public void setPropertyTier(PropertyTier t)
	{
		propertyTier = t;
	}


	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public Address getPropertyAddress()
	{
		return propertyAddress;
	}

	public double getMarketValue()
	{
		return marketValue;
	}

	public Date getDatePurchased()
	{
		return datePurchased;
	}

	public int getSquareFeet()
	{
		return squareFeet;
	}

	public PropertyTier getPropertyTier()
	{
		return propertyTier;  	
	}	

	public String toString()
	{
															
		return("Account Number: " + getAccountNumber() + "\nProperty Address: " + getPropertyAddress()+
			"\nMarket Value: " + getMarketValue() + "\nDate Purchased: " + getDatePurchased() +
			"\nSquare Feet: " + getSquareFeet() + "Property Tier: " + getPropertyTier() );


	}

	public abstract double calculateTaxes();
	{
		
	}








}