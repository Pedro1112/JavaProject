

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class PropertyGUI extends JFrame
{
	private JLabel selectOptionLabel;
	private JLabel nameLabel;
	private JLabel streetLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel selectAnOwnerLabel;
	private JLabel accountNumberLabel;
	private JLabel marketValueLabel;
	private JLabel purchaseDateLabel;
	private JLabel squareFeetLabel;
	private JLabel propertyTierLabel;
	private JLabel subdivisionLabel;
	private JLabel floodZoneLabel;
	private JLabel businessNameLabel;
	private JLabel stateCodeLabel;

	private JPanel selectOptionPanel;
	private JPanel propertyTierPanel;
	private JPanel floodZonePanel;

	private JCheckBox addOwner;
	private JCheckBox addResidential;
	private JCheckBox addCommercial;
	private JButton submitButton;
	private JButton finishButton;
	private JTextField nameField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;

	private JComboBox <String> selectAnOwner = new JComboBox<String>();
	//private String ownerArray [] = {"None","Owner1", "Owner2"};
	
	private ArrayList<Owner> ownerList = new ArrayList<Owner>();
	private ArrayList<Property> propertiesList = new ArrayList<Property>();
	private JComboBox <String> selectSubdivision;
	private String subdivisionArray [] = {"NONE", "KINGLY_ESTATES", "STATELY_ESTATES", "KING_MANOR", "GREEN_GABLES"};

	private JTextField accountNumberField;
	private JTextField marketValueField;	
	private JTextField purchaseDateField;
	private JTextField squareFeetField;
	private JRadioButton propertyTier1Button;
	private JRadioButton propertyTier2Button;
	private JRadioButton propertyTier3Button;
	private JRadioButton propertyTier4Button;
	private JRadioButton yesFloodZoneButton;
	private JRadioButton noFloodZoneButton;
	private JTextField businessNameField;
	private JTextField stateCodeField;

	private ButtonGroup addGroup;
	private ButtonGroup tierGroup;
	private ButtonGroup yesnoGroup;
	

	//private ArrayList<Owner> ownerList = new ArrayList<Owner>();
	//private ArrayList<Property> propertyList = new ArrayList<Property>();

	public PropertyGUI()
	{
		super("Property Input Screen");

		//readOwners();
		//readProperties();

				// 17 by 2 Grid
		setLayout(new GridLayout(17,2));
		
		selectAnOwner.addItem("");
		selectOptionLabel = new JLabel("Select Option");
		nameLabel = new JLabel("Name");
		streetLabel = new JLabel("Street");
		cityLabel = new JLabel("City");
		stateLabel= new JLabel("State");
		zipLabel= new JLabel("Zip");
		selectAnOwnerLabel= new JLabel("Select an Owner");
		accountNumberLabel = new JLabel("Account Number");
		marketValueLabel = new JLabel("Market Value");
		purchaseDateLabel = new JLabel("Purchase Date");
		squareFeetLabel = new JLabel("Square Feet");
		propertyTierLabel = new JLabel("Property Tier");
		subdivisionLabel = new JLabel("Subdivision");
		floodZoneLabel = new JLabel("FloodZone");
		businessNameLabel = new JLabel("Business Name");
		stateCodeLabel = new JLabel("State Code");

		addOwner = new JCheckBox("Add Owner");
		addResidential = new JCheckBox("Add Residential");
		addCommercial = new JCheckBox("Add Commercial");
		submitButton = new JButton("SUBMIT");
		finishButton = new JButton("FINISH");
		nameField = new JTextField(15);
		streetField = new JTextField(15);
		cityField= new JTextField(15);
		stateField = new JTextField(15);
		zipField= new JTextField(15);
		accountNumberField= new JTextField(15);
		marketValueField= new JTextField(15);
		purchaseDateField= new JTextField(15);
		purchaseDateField.setToolTipText("Format xx/xx/xx");
		squareFeetField= new JTextField(15);
		propertyTier1Button = new JRadioButton("TIER 1");
		propertyTier2Button = new JRadioButton("TIER 2");
		propertyTier3Button = new JRadioButton("TIER 3");
		propertyTier4Button = new JRadioButton("TIER 4");
		yesFloodZoneButton = new JRadioButton("YES");
		noFloodZoneButton = new JRadioButton("NO");
		businessNameField= new JTextField(15);
		stateCodeField= new JTextField(15);

		floodZonePanel = new JPanel();
		floodZonePanel.setLayout(new GridLayout(1,2));
		floodZonePanel.add(yesFloodZoneButton);
		floodZonePanel.add(noFloodZoneButton);

		selectOptionPanel = new JPanel();
		selectOptionPanel.setLayout(new GridLayout(1,3));
		selectOptionPanel.add(addOwner);
		selectOptionPanel.add(addResidential);
		selectOptionPanel.add(addCommercial);

		propertyTierPanel = new JPanel();
		propertyTierPanel.setLayout(new GridLayout(1,4));
		propertyTierPanel.add(propertyTier1Button);
		propertyTierPanel.add(propertyTier2Button);
		propertyTierPanel.add(propertyTier3Button);
		propertyTierPanel.add(propertyTier4Button);


		
		addGroup = new ButtonGroup();
		tierGroup = new ButtonGroup();
		yesnoGroup = new ButtonGroup();

		addGroup.add(addOwner);
		addGroup.add(addResidential);
		addGroup.add(addCommercial);

		tierGroup.add(propertyTier1Button);
		tierGroup.add(propertyTier2Button);
		tierGroup.add(propertyTier3Button);
		tierGroup.add(propertyTier4Button);

		yesnoGroup.add(yesFloodZoneButton);
		yesnoGroup.add(noFloodZoneButton);

		//selectAnOwner = new JComboBox<String>(ownerArray);
		selectSubdivision = new JComboBox<String>(subdivisionArray);

		ButtonHandler buttonHandler = new ButtonHandler();
		finishButton.addActionListener(buttonHandler);
		submitButton.addActionListener(buttonHandler);

		// anonymous listeners
	
		addOwner.addItemListener (new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				nameLabel.setEnabled(true);
				nameField.setEnabled(true);
				streetLabel.setEnabled(true);
				streetField.setEnabled(true);
				cityLabel.setEnabled(true);
				cityField.setEnabled(true);
				stateLabel.setEnabled(true);
				stateField.setEnabled(true);
				zipLabel.setEnabled(true);
				zipField.setEnabled(true);
				selectAnOwnerLabel.setEnabled(false);  
				selectAnOwner.setEnabled(false);   
				accountNumberLabel.setEnabled(false);
				accountNumberField.setEnabled(false);
				marketValueLabel.setEnabled(false);
				marketValueField.setEnabled(false);
				purchaseDateLabel.setEnabled(false);
				purchaseDateField.setEnabled(false);
				squareFeetLabel.setEnabled(false);
				squareFeetField.setEnabled(false);
				propertyTierLabel.setEnabled(false);
				propertyTier1Button.setEnabled(false);
				propertyTier2Button.setEnabled(false);
				propertyTier3Button.setEnabled(false);
				propertyTier4Button.setEnabled(false);
				subdivisionLabel.setEnabled(false);
				selectSubdivision.setEnabled(false);
				floodZoneLabel.setEnabled(false);
				yesFloodZoneButton.setEnabled(false);
				noFloodZoneButton.setEnabled(false);
				businessNameLabel.setEnabled(false);
				businessNameField.setEnabled(false);
				stateCodeLabel.setEnabled(false);
				stateCodeField.setEnabled(false);	
		
			}
		}	
			);


		addResidential.addItemListener (new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				nameLabel.setEnabled(false);
				nameField.setEnabled(false);
				streetLabel.setEnabled(true);
				streetField.setEnabled(true);
				cityLabel.setEnabled(true);
				cityField.setEnabled(true);
				stateLabel.setEnabled(true);
				stateField.setEnabled(true);
				zipLabel.setEnabled(true);
				selectAnOwnerLabel.setEnabled(true);  
				selectAnOwner.setEnabled(true);    
				accountNumberLabel.setEnabled(true);
				accountNumberField.setEnabled(true);
				marketValueLabel.setEnabled(true);
				marketValueField.setEnabled(true);
				purchaseDateLabel.setEnabled(true);
				purchaseDateField.setEnabled(true);
				squareFeetLabel.setEnabled(true);
				squareFeetField.setEnabled(true);
				propertyTierLabel.setEnabled(true);
				propertyTier1Button.setEnabled(true);
				propertyTier2Button.setEnabled(true);
				propertyTier3Button.setEnabled(true);
				propertyTier4Button.setEnabled(true);
				subdivisionLabel.setEnabled(true);
				selectSubdivision.setEnabled(true);
				floodZoneLabel.setEnabled(true);
				yesFloodZoneButton.setEnabled(true);
				noFloodZoneButton.setEnabled(true);
				businessNameLabel.setEnabled(false);
				businessNameField.setEnabled(false);
				stateCodeLabel.setEnabled(false);
				stateCodeField.setEnabled(false);
			}
		}	
			);


		addCommercial.addItemListener (new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				nameLabel.setEnabled(false);
				nameField.setEnabled(false);
				streetLabel.setEnabled(true);
				streetField.setEnabled(true);
				cityLabel.setEnabled(true);
				cityField.setEnabled(true);
				stateLabel.setEnabled(true);
				stateField.setEnabled(true);
				zipLabel.setEnabled(true);
				selectAnOwnerLabel.setEnabled(true);  
				selectAnOwner.setEnabled(true);    
				accountNumberLabel.setEnabled(true);
				accountNumberField.setEnabled(true);
				marketValueLabel.setEnabled(true);
				marketValueField.setEnabled(true);
				purchaseDateLabel.setEnabled(true);
				purchaseDateField.setEnabled(true);
				squareFeetLabel.setEnabled(true);
				squareFeetField.setEnabled(true);
				propertyTierLabel.setEnabled(true);
				propertyTier1Button.setEnabled(true);
				propertyTier2Button.setEnabled(true);
				propertyTier3Button.setEnabled(true);
				propertyTier4Button.setEnabled(true);
				subdivisionLabel.setEnabled(false);
				selectSubdivision.setEnabled(false);
				floodZoneLabel.setEnabled(false);
				yesFloodZoneButton.setEnabled(false);
				noFloodZoneButton.setEnabled(false);
				businessNameLabel.setEnabled(true);
				businessNameField.setEnabled(true);
				stateCodeLabel.setEnabled(true);
				stateCodeField.setEnabled(true);
				
			}
		}	
			);


		// adding them in the correct order
		add(selectOptionLabel);
		add(selectOptionPanel);
		add(nameLabel);
		add(nameField);
		add(streetLabel);
		add(streetField);
		add(cityLabel);
		add(cityField);
		add(stateLabel);
		add(stateField);
		add(zipLabel);
		add(zipField);
		add(selectAnOwnerLabel);
		add(selectAnOwner);
		add(accountNumberLabel);
		add(accountNumberField);
		add(marketValueLabel);
		add(marketValueField);
		add(purchaseDateLabel);
		add(purchaseDateField);
		add(squareFeetLabel);
		add(squareFeetField);
		add(propertyTierLabel);
		add(propertyTierPanel);
		add(subdivisionLabel);
		add(selectSubdivision);
		add(floodZoneLabel);
		add(floodZonePanel);
		add(businessNameLabel);
		add(businessNameField);
		add(stateCodeLabel);
		add(stateCodeField);
		add(submitButton);	
		add(finishButton);
		
	}

	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			// declare variables for Owner and Properties
		        String name;
			String street;
			String city;
			String state;
			int zip;
			Property.PropertyTier propertyTier;
			//String [] ownerList ;
			int accountNumber;
			double marketValue;
			int month;
			int day;
			int year;
			int squareFeet;
			ResidentialProperty.Subdivision subdivison;
			String ownerSelection;
			String floodZone;
			String businessName;	
			int stateCode;
			String subdivisionString;
			String [] residentialList;
			

			if(!addOwner.isSelected() && (!addResidential.isSelected() && (!addCommercial.isSelected())))
			{	
				JOptionPane.showMessageDialog(null, "Please Select: \"Add Owner\", \"Add Residential\", or \"Add Commercial\" ");
			}
			else
			{
		
				if(ae.getSource()==submitButton)
				{
					if(addOwner.isSelected())	
					{
						if(checkOwnerInput())  
						{
							name = nameField.getText();	
							street = streetField.getText();	
							city = cityField.getText();	
							state = stateField.getText();
							zip = Integer.parseInt(zipField.getText());
		
							//ownerList.add(new Owner(name, new Address(street, city, state, zip)));
							selectAnOwner.addItem(name);
							clearOwner();		
	
						}
							
					}
						
					
					if(addResidential.isSelected())
					{
						if(checkResidentialInput())	
						{						// all except name,business name and state code
							street = streetField.getText();	
							city = cityField.getText();	
							state = stateField.getText();
							zip = Integer.parseInt(zipField.getText());
							accountNumber = Integer.parseInt(accountNumberField.getText());
							ownerSelection = selectAnOwner.getSelectedItem().toString();
							marketValue = Double.parseDouble(marketValueField.getText());
							month = Integer.parseInt(purchaseDateField.getText());
							day = Integer.parseInt(purchaseDateField.getText());
							year = Integer.parseInt(purchaseDateField.getText());
							squareFeet = Integer.parseInt(squareFeetField.getText());
							subdivisionString = subdivisionArray [selectSubdivision.getSelectedIndex()];
							//propertyTier =	tierGroup.getSelection();
							//floodZone = yesnoGroup.getSelection();
			

							//determineTier()
							if(propertyTier1Button.isSelected())
							{	
								propertyTier = Property.PropertyTier.TIER1;
							}

							else if(propertyTier2Button.isSelected())
							{
								propertyTier = Property.PropertyTier.TIER2;
							}
							else if(propertyTier3Button.isSelected())
							{
								propertyTier = Property.PropertyTier.TIER3;
							}
							else
							{
								propertyTier = Property.PropertyTier.TIER4;
							}
				
								//determineFlood()	
								if(yesFloodZoneButton.isSelected())
								{
									floodZone = "Yes";
								}
								if(noFloodZoneButton.isSelected())
								{
									floodZone = "No";
								}				

							
							
							//residentialList.add(new ResidentialProperty(account, new Address(street, city,state,zip),marketValue, new Date(month,day,year) squareFeet,propertyTier,subdivisionString,floodZone);
							clearResidential();						
						

						}
						
						
								
					}


					if(addCommercial.isSelected())
					{
						if(checkCommercialInput())	
						{				// all except name, subdivision and floodzone
							street = streetField.getText();	
							city = cityField.getText();	
							state = stateField.getText();
							zip = Integer.parseInt(zipField.getText());
							accountNumber = Integer.parseInt(accountNumberField.getText());
							ownerSelection = selectAnOwner.getSelectedItem().toString();
							marketValue = Double.parseDouble(marketValueField.getText());
							month = Integer.parseInt(purchaseDateField.getText());
							day = Integer.parseInt(purchaseDateField.getText());
							year = Integer.parseInt(purchaseDateField.getText());
							squareFeet = Integer.parseInt(squareFeetField.getText());
						

						
							if(propertyTier1Button.isSelected())
							{	
								propertyTier = Property.PropertyTier.TIER1;
							}

							else if(propertyTier2Button.isSelected())
							{
								propertyTier = Property.PropertyTier.TIER2;
							}
							else if(propertyTier3Button.isSelected())
							{
								propertyTier = Property.PropertyTier.TIER3;
							}
							else
							{
								propertyTier = Property.PropertyTier.TIER4;
							}				

							businessName = businessNameField.getText();
							stateCode = Integer.parseInt(stateCodeField.getText());

						
								/*else
								{
									System.out.println("");
									for(int i = 0; i<ownerList.size(); i++)
									{
										if(ownerList.get(i).getName().equals(nameField.getText()))
										ownerList.remove(i);
									}

								}
							
								*/
							clearCommercial();
						}	
								
							
							 	
					}  
								
			} // end else
			
			else
			{
				//System.out.println(ownerList.toString());
				System.exit(0);
			}

		}
	}
		
		
		public void readOwners()			
		{
			Scanner input; 
			String name; 
			String streetAddress;
			String city;
			String state;
			int zip;
			String line;
			String [] values;
	 
			
			try
			{
				input = new Scanner( new File("owners.txt"));
				while(input.hasNext())
				{
					line = input.nextLine();	
					values = line.split(";");
					
					name = values[0];
					streetAddress = values[1];
					city = values [2];
					state = values [3];
					zip = Integer.parseInt(values[4]);

					ownerList.add(new Owner(values[0],new Address(values[1],values[2],values[3],Integer.parseInt(values[4]))));
					selectAnOwner.addItem(values[0]);
						

					//System.out.println(ownerValues);
		
				}

				
			}		
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}	

		

		}  // end readOwners	

}  // end class for now part of read owners
	


	
/*	
		public void readProperties()			
		{
			
			Scanner input; 
			//String name;	
			int accountNumber;	
			Address address;		
			double marketValue;	
			Date datePurchased;	
			int squareFeet;		
			Property.PropertyTier propertyTier;	
			boolean floodZone;	
			ResidentialProperty.Subdivision subdivision;	
			String businessName;		
			String stateCode;	
		
			String line;
			String values[];

			try
			{
				input = new Scanner (new File("properties.txt"));
				while(input.hasNext())
				{
					line = input.nextLine();
					values = line.split(";");
					if(values[0].equals("Residential"))
					{
						accountNumber = Integer.parseInt(values[2]);
                                        	address = new Address(values[3],values[4],values[5],Integer.parseInt(values[6]));
                                       	 	marketValue = Double.parseDouble(values[7]);
                                        	datePurchased = new Date(Integer.parseInt(values[8]),Integer.parseInt(values[9]),Integer.parseInt(values[10]));
                                        	squareFeet = Integer.parseInt(values[11]);
                                        
                                        		if(values[12].equals("TIER1"))
                                        		{
                                           	 		propertyTier = Property.PropertyTier.TIER1;                           
                                        		}
                                        		else if(values[12].equals("TIER2"))
                                        		{
                                            			propertyTier = Property.PropertyTier.TIER2;
                                        		}
                                        		else if(values[12].equals("TIER3"))
                                        		{
                                            			propertyTier = Property.PropertyTier.TIER3;
                                        		}
                                        		else
                                        		{
                                            			propertyTier = Property.PropertyTier.TIER4;
                                        		}
                                        
                                        		floodZone = Boolean.parseBoolean(values[13]);
                                        
                                       			if(values[14].equals("Kingly Estate"))
                                        		{
                                            			subdivision = ResidentialProperty.Subdivision.KINGLY_ESTATES;
                                        		}
                                        		else if(values[14].equals("Stately Estates"))
                                        		{
                                            			subdivision = ResidentialProperty.Subdivision.STATELY_ESTATES;
                                        		}
                                        		else if(values[14].equals("King Manor"))
                                        		{
                                            			subdivision = ResidentialProperty.Subdivision.KING_MANOR;
                                        		}
                                        		else if(values[14].equals("Green Gables"))
                                        		{
                                            			subdivision = ResidentialProperty.Subdivision.GREEN_GABLES;
                                        		}
                                        		else
                                        		{
                                            			subdivision = ResidentialProperty.Subdivision.NONE;
                                        		}
                                        
                                        		for(int i = 0; i < ownersList.size();i++)
                                        		{
                                            			if(values[1].equals(ownersList.get(i).getName()))
                                            			{
                                               				ownersList.get(i).addProperty(new ResidentialProperty(accountNumber,address,marketValue, datePurchased,squareFeet,subdivision,floodZone));
                                            			}
                                       			}
                                        
                                        	propertiesList.add(new ResidentialProperty(accountNumber,address,marketValue, datePurchased,squareFeet,propertyTier,floodZone,subdivision));
				
				}

                                else
                                {
                                    	accountNumber = Integer.parseInt(values[2]);
                                        address = new Address(values[3],values[4],values[5],Integer.parseInt(values[6]));
                                        marketValue = Double.parseDouble(values[7]);
                                        datePurchased = new Date(Integer.parseInt(values[8]),Integer.parseInt(values[9]),Integer.parseInt(values[10]));
                                        squareFeet = Integer.parseInt(values[11]);
                                        
                                        if(values[12].equals("TIER1"))
                                        {
                                            propertyTier = Property.PropertyTier.TIER1;                           
                                        }
                                        else if(values[12].equals("TIER2"))
                                        {
                                            propertyTier = Property.PropertyTier.TIER2;
                                        }
                                        else if(values[12].equals("TIER3"))
                                        {
                                            propertyTier = Property.PropertyTier.TIER3;
                                        }
                                        else
                                        {
                                            propertyTier = Property.PropertyTier.TIER4;
                                        }
                                        
                                        businessName = values[13];
                                        stateCode = values[14];                                                                             
                                        
                                        for(int i = 0; i < ownersList.size(); i++)
                                        {
                                            if(values[1].equals(ownersList.get(i).getName()))
                                                ownersList.get(i).addProperty(new CommercialProperty(accountNumber,address,marketValue,datePurchased,squareFeet,propertyTier,businessName,stateCode));
                                        }
                                        
                                        propertiesList.add(new CommercialProperty(accountNumber,address,marketValue,datePurchased,squareFeet,propertyTier,businessName,stateCode));    
                                        
                                }
						

					}
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
								
						
		} // end readProperties

*/

	
		
/*

	public static void writeOwnerList()
	{

		// writes the owner list to ownerList.txt
		Formatter output;
	
		try
		{
			output = new Formatter("ownerList.txt");

			output.format("%s;%s;%.2f\n", "First Last", "Arlington", 500.00);
			output.format("%s;%s;%.2f\n", "First Last", "Arlington", 500.00);
			output.format("%s;%s;%.2f\n", "First Last", "Arlington", 500.00);

			output.close();
		}

		catch(IOException ioe)
		{
			ioe.printstackTrace();
		}
	}

	public void writePropertyList()
	{
		// writes the property list to propertyList.txt

		Formatter output;
	
		try
		{
			output = new Formatter("propertyList.txt");

			output.format("%s;%s;%.2f\n", "property type...", "Arlington", 500.00);
			output.format("%s;%s;%.2f\n", "commercial...", "Arlington", 500.00);
			output.format("%s;%s;%.2f\n", "residential...", "Arlington", 500.00);

			output.close();
		}

		catch(IOException ioe)
		{
			ioe.printstackTrace();
		}

	}
*/



		public void clearOwner()
		{
			nameField.setText("");
			streetField.setText("");
			cityField.setText("");
			stateField.setText("");
			zipField.setText("");   

			nameField.requestFocus(); 
		}


	
		public void clearResidential()		
		{
			streetField.setText("");
			cityField.setText("");
			stateField.setText("");
			zipField.setText("");
			selectAnOwner.setSelectedIndex(0);
			accountNumberField.setText("");
			marketValueField.setText("");
			purchaseDateField.setText("");
			squareFeetField.setText("");
			tierGroup.clearSelection();
			selectSubdivision.setSelectedIndex(0);
			yesnoGroup.clearSelection();
			
		}
		
		public void clearCommercial()
		{
			streetField.setText("");
			cityField.setText("");
			stateField.setText("");
			zipField.setText("");
			selectAnOwner.setSelectedIndex(0);
			accountNumberField.setText("");
			marketValueField.setText("");
			purchaseDateField.setText("");
			squareFeetField.setText("");
			tierGroup.clearSelection();
			businessNameField.setText("");
			stateCodeField.setText("");
		}
		   				

		public boolean checkOwnerInput() 
		{
			boolean input = true;
			
			if(nameField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter name");
				nameField.requestFocus();
				input = false;
			}

			else if(streetField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Street");
				streetField.requestFocus();
				input = false;
			} 
			
			else if(cityField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter City");
				cityField.requestFocus();
				input = false;
			} 

			else if(stateField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter State");
				stateField.requestFocus();
				input = false;
			} 
			
			else if(zipField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Zip Code");
				zipField.requestFocus();
				input = false;

			}
					
			
			else if(!zipField.getText().isEmpty())
			{
				try
				{
					Integer.parseInt(zipField.getText());
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null,"Please Enter an Integer for Zip Code");
					zipField.setText("");
					zipField.requestFocus();
					input = false;
				}		
										
			} 
				
			return input;		
			
		}

		public boolean checkResidentialInput()
		{
			boolean input = true;

			
			if(streetField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Street");
				streetField.requestFocus();
				input = false;
			} 
			
			else if(cityField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter City");
				cityField.requestFocus();
				input = false;
			} 

			else if(stateField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter State");
				stateField.requestFocus();
				input = false;
			} 
			
			else if(zipField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Zip Code");
				zipField.requestFocus();
				input = false;
			} 
				
			else if(selectAnOwner.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Select an Owner");
				input = false;
			}
		

			else if (accountNumberField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Account Number");
				accountNumberField.requestFocus();
				input = false;
			}

			
			else if (marketValueField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Market Value");
				marketValueField.requestFocus();
				input = false;

			}

			
			else if (purchaseDateField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Purchase Date");
				purchaseDateField.requestFocus();
				input = false;
			}

			
			else if (squareFeetField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Square Feet");
				squareFeetField.requestFocus();
				input = false;

			}
		
			
			else if(!propertyTier1Button.isSelected() && !propertyTier2Button.isSelected() && !propertyTier3Button.isSelected() && !propertyTier4Button.isSelected())
			{
				JOptionPane.showMessageDialog(null, "Please Select TIER");
				input = false;
			}
			else if(selectSubdivision.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Enter Subdivision");
			}
			else if(!yesFloodZoneButton.isSelected() && !noFloodZoneButton.isSelected())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Flood Zone");
			}
			else if(!checkDate())
            		{
                		JOptionPane.showMessageDialog(null, "Please enter a valid purchase date in the following format: xx/xx/xx");
                		purchaseDateField.setText("");
                		purchaseDateField.requestFocus();
                		input = false;
            		}

			
		        else
				input = checkNumberInput();


			
			return input;	
		}


		public boolean checkCommercialInput()
		{
	
			boolean input = true;
			boolean checkDate = true;
			

			if(streetField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Street");
				streetField.requestFocus();
				input = false;
			} 

			
			else if(cityField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter City");
				cityField.requestFocus();
				input = false;
			} 

			else if(stateField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter State");
				stateField.requestFocus();
				input = false;
			} 
			
			else if(zipField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Zip Code");
				zipField.requestFocus();
				input = false;
			} 
			
			else if(selectAnOwner.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Select an Owner");
				input = false;
			}

			else if (accountNumberField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Account Number");
				accountNumberField.requestFocus();
				input = false;
	
			}
			
			
			else if (marketValueField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Market Value");
				marketValueField.requestFocus();
				input = false;
			
		
			}
			
			else if (purchaseDateField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Purchase Date");
				purchaseDateField.requestFocus();
				input = false;
			}
			
			else if (squareFeetField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Square Feet");
				squareFeetField.requestFocus();
				input = false;

			}
			
			else if(!propertyTier1Button.isSelected() && !propertyTier2Button.isSelected() && !propertyTier3Button.isSelected() && !propertyTier4Button.isSelected())
			{
				JOptionPane.showMessageDialog(null, "Please Select TIER");
				input = false;
			}
			else if(businessNameField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter Business Name");
				businessNameField.requestFocus();
				input = false;
			}
			else if(stateCodeField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Enter State Code");
				stateCodeField.requestFocus();
				input = false;
			}
			else if(!checkDate())
            		{
                		JOptionPane.showMessageDialog(null, "Please enter a valid purchase date in the following format: xx/xx/xx");
                		purchaseDateField.setText("");
                		purchaseDateField.requestFocus();
                		input = false;
            		}

			else
				input = checkNumberInput();
				



				return input;  	

		}//end check CommercialInput  

	
	
	public boolean checkNumberInput()
	{

				try
				{
					Integer.parseInt(zipField.getText());
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null,"Please Enter an Integer for Zip Code");
					zipField.setText("");
					zipField.requestFocus();
					return false;
				}



				try
				{
					Integer.parseInt(accountNumberField.getText());
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null,"Please Enter an Integer for Account Number");
					accountNumberField.setText("");
					accountNumberField.requestFocus();
					return false;
				}


				try
				{
					Double.parseDouble(marketValueField.getText());
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null,"Enter a Double for Market Value");
					marketValueField.setText("");
					marketValueField.requestFocus();
					return false;
				}
				


				try
				{
					Integer.parseInt(squareFeetField.getText());
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null,"Enter an Integer for Square Feet");
					squareFeetField.setText("");
					squareFeetField.requestFocus();
					return false;
								
				}


			return true;

	
	}


	public boolean checkDate()
	{
		boolean input = true;
		String line = purchaseDateField.getText();
		String [] values = line.split("/");
		
		if(values.length >3)
		{
			input = false;
		}
		else if(values[0].length() != 2)
            {
                input = false;
            }
            else if(values[1].length() != 2)
            {
                input = false;
            }
            else if(values[2].length() != 2)
            {
                input = false;
            }
            
            return input;
        }

	
	public Date createDate(String d)
	{

		String [] values;
		values = d.split("/");

		return(new Date(Integer.parseInt(values[0]),Integer.parseInt(values[1]), Integer.parseInt(values[2])));


	}

	public boolean determineFlood()
	{	
		boolean floodZone = true;
		
		if(yesFloodZoneButton.isSelected())
		{

			return floodZone;
		}
	
		if(noFloodZoneButton.isSelected())
		{
			floodZone = false;
	
			return floodZone;
		}
			
			return floodZone;
	}


	public ResidentialProperty.Subdivision determineDivision(String s)
	{
		ResidentialProperty.Subdivision subdivision;

	    if(s.equals("KINGLY_ESTATES"))
                	subdivision = ResidentialProperty.Subdivision.KINGLY_ESTATES;
            else if(s.equals("STATELY_ESTATES"))
                	subdivision = ResidentialProperty.Subdivision.STATELY_ESTATES;
            else if(s.equals("KING_MANOR"))
                	subdivision = ResidentialProperty.Subdivision.KING_MANOR;
            else
                subdivision = ResidentialProperty.Subdivision.GREEN_GABLES;
            
            return subdivision;


	}

	public Property.PropertyTier determineTier()
	{
		Property.PropertyTier propertyTier;

		if(propertyTier1Button.isSelected())
		{
			propertyTier = Property.PropertyTier.TIER1;
			
		}

		else if(propertyTier2Button.isSelected())
		{

			propertyTier = Property.PropertyTier.TIER2;
		}

		else if(propertyTier3Button.isSelected())
		{

			propertyTier = Property.PropertyTier.TIER3;
		}

		else 
		{//if(propertyTier4Button.isSelected())

			propertyTier = Property.PropertyTier.TIER4;
		}
		
		return propertyTier;

	}


	

} 
	//va}



/*
	   		


	*/	








//}// end class
