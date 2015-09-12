

import java.util.ArrayList;
public class Owner
{
	private String name;
	private Address ownerAddress;
	private ArrayList<Property> propertyList = new ArrayList<Property>();		
	private double totalTaxes;

	public Owner ()
	{
		setName("");
		setOwnerAddress(new Address());		
		setTotalTaxes(0.0);
	}

	public Owner(String n, Address a)
	{
		setName(n);
		setOwnerAddress(a);
	}

	public void setName(String n)
	{
		name = n;
	}

	public void setOwnerAddress(Address a)
	{
		ownerAddress = a;
	}


	public void setTotalTaxes(double t)
	{
		totalTaxes = t;

	}

	public String getName()
	{
		return name;
	}

	public Address getAddress()
	{
		return ownerAddress;
	}

	public double getTotalTaxes()
	{
		return totalTaxes;
	}

	public String toString()
	{
		return ("Name: " + getName() + "\nAddress: " + getAddress() +
			"\nProperty List: " + makeList() + "\nTotal Taxes: " + getTotalTaxes());
	}

	public void addProperty(Property p)  
	{
		propertyList.add(p);
	}

	public ArrayList<Property> getPropertyList()
	{
		return propertyList;
	}

	public String makeList()
	{
		String message = "";
		for(Property p:propertyList)
		   message += p.toString() +"\n";

		return message;
	}





}
	
