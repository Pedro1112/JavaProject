

public class Date
{
	private int month;
	private int day;
	private int year;

	public Date()
   	{

	setMonth(0);
	setDay(0);
	setYear(0);

   	}

   	public Date (int m, int d, int y)
   	{

      	setMonth (m);
      	setDay(d);
      	setYear(y);

   	}

   	public void setMonth (int m)
   	{

	if (m > 0 && m < 13)
	month = m; 
	   

	}

   	public void setDay (int d)
   	{

	if (d > 0 && d <= 31)
	day = d;    

   	}

   	public void setYear (int y)
   	{

      	if (y > 0)
	year = y;     
   	}


   	public int getMonth()
   	{

	return month;

   	}

	public int getDay()
   	{
	
	return day;

   	}

	public int getYear()
	{

	return year;

	}

	public String toString()
	{

				//date in mm/dd/yyyy format
	return String.format ("%d/%d/%d", getMonth(),getDay(),getYear());


   	}
}
