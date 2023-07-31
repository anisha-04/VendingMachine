
public class VendingMachine {

	private int OPTIONS = 4;
	private int serialNumber;
	private String location;
	private int[] itemCounts;
	private int[] orderCounts;
	private int[] soldCounts;
	private double[] itemCosts;
	private String[] itemLabels;
	
	public VendingMachine(int serialNumber){
		this.serialNumber = serialNumber;
		this.location = "UNKNOWN";
		this.itemCounts = new int[4];
		this.orderCounts = new int[4];
		this.soldCounts = new int[4];
		this.itemCosts = new double[]{1.50,2.0,1.0,2.5};
		this.itemLabels = new String[]{"Water", "Coffee", "Fritos", "Lily's"};
		}
	
	public VendingMachine(int serialNumber, String location){
		this.serialNumber = serialNumber;
		this.location = location;
		this.itemCounts = new int[4];
		this.orderCounts = new int[4];
		this.soldCounts = new int[4];
		this.itemCosts = new double[]{1.50,2.0,1.0,2.50};
		this.itemLabels = new String[]{"Water", "Coffee", "Fritos", "Lily's"};
		}
	
	public String toString(){
		return "===== Vending Machine Information =====\nSerial Number : " + this.serialNumber + " \nLocation: " + this.location + "\nContents:\n" +
		"1." +itemLabels[0] + "\t\t$" + itemCosts[0] +"\t"+this.itemCounts[0] + "\t(sold : "+soldCounts[0]+")"+ "\n" +
		"2." +itemLabels[1] + "\t$" + itemCosts[1]   +"\t"+this.itemCounts[1] + "\t(sold : "+soldCounts[1]+")"+ "\n" +
		"3." +itemLabels[2] + "\t$" + itemCosts[2] 	 +"\t"+this.itemCounts[2]+ "\t(sold : "+soldCounts[2]+")"+ "\n" +
		"4." +itemLabels[3] + "\t$" + itemCosts[3]   +"\t"+this.itemCounts[3]+ "\t(sold : "+soldCounts[3]+")"+ "\n";
		}
	public boolean buyItem(int itemIndex){
		System.out.println("You selected : "+this.itemLabels[itemIndex-1]+" Quantity : 1");
		if(this.itemCounts[itemIndex-1]>=1)
				{
				//System.out.println(this.itemLabels[itemIndex-1]+" buyItem  "+this.itemCounts[itemIndex-1]);
					this.itemCounts[itemIndex-1]-=1;
				//System.out.println(this.itemLabels[itemIndex-1]+" buyItem  "+this.itemCounts[itemIndex-1]);
					this.orderCounts[itemIndex-1] += 1;
					return true;
				}
		else
		{
			System.out.println("Selection failed. We don't have enough "+this.itemLabels[itemIndex-1]);
			return false;
		}
		}
	
	public boolean buyItem(int item, int quantity){
		System.out.println("You selected : "+this.itemLabels[item-1]+" Quantity : "+quantity);
		if(itemCounts[item-1]>=quantity)
		{
			this.orderCounts[item-1] +=quantity ;
			this.itemCounts[item-1] -= quantity;
			return true;
		}
		else
		{
			System.out.println("Selection failed. We don't have enough "+this.itemLabels[item-1]);
			return false;
		}
	}
	public boolean pay(double payment){
		System.out.println("Order Receipt:");
		double total=0;
		for(int i=0;i<orderCounts.length;i++)
		{
			if(orderCounts[i]!=0)
			{
				double result=orderCounts[i]*itemCosts[i];
				total=total+result;
				System.out.println(itemLabels[i]+" : "+orderCounts[i]+" X "+toDollars(itemCosts[i])+" = "+toDollars(result));
			}
		}
			double tax=0.10*total;
			System.out.println("Tax (10%) : "+toDollars(tax));
			total=total+tax;
			System.out.println("Total : "+toDollars(total));
			System.out.println("Paying for order with "+toDollars(payment));
			
			if(total<=payment)
			{
				double balance=payment-total;
				System.out.println("Sufficient money."+toDollars(balance)+" returned");
				
				

				
				soldCounts[0] += orderCounts[0];
				soldCounts[1] += orderCounts[1];
				soldCounts[2] += orderCounts[2];
				soldCounts[3] += orderCounts[3];
				
				orderCounts[0] =0;
				orderCounts[1] =0;
				orderCounts[2] =0;
				orderCounts[3] =0;
				
				
				
				return true;
				
			}else
			{
				System.out.println("Insufficient money."+toDollars(payment)+" returned");
				return false;
			}
	}
		
	public void displayReceipt()
	{
		double total = 0;
		for(int i=0;i<orderCounts.length;i++)
		{
			if(orderCounts[i]!=0)
			{
				double result=orderCounts[i]*itemCosts[i];
				total=total+result;
				System.out.println(itemLabels[i]+" : "+orderCounts[i]+" X "+toDollars(itemCosts[i])+" = "+toDollars(result));
			}
		}
			double tax=0.10*total;
			System.out.println("Tax (10%) : "+toDollars(tax));
			total=total+tax;
			System.out.println("Total : "+toDollars(total));
	}
	
	public void returnItem(int item, int quantity)
		{
			System.out.println("You Selected "+this.itemLabels[item-1]+" . Quantity : "+quantity);
			if(this.orderCounts[item-1]<quantity)
			{
				this.itemCounts[item-1] += this.orderCounts[item-1];
				this.orderCounts[item-1] = 0;
				
			}
			else
			{
				this.orderCounts[item-1] -= quantity;
				this.itemCounts[item-1] += quantity;
				
			}
		}

		public boolean equals(VendingMachine vm)
		{
			if((this.orderCounts[0] == vm.orderCounts[0]) && (this.orderCounts[1] == vm.orderCounts[1]) &&(this.orderCounts[2] == vm.orderCounts[2]) && this.orderCounts[3] == vm.orderCounts[3])
				return true;
			return false;
		}

	public void resetItems(int count1, int count2, int count3, int count4){
			this.itemCounts[0] = count1;
			this.itemCounts[1] = count2;
			this.itemCounts[2] = count3;
			this.itemCounts[3] = count4;
		}
	
	public void addItems(int item1, int item2, int item3, int item4){
			this.itemCounts[0] = this.itemCounts[0]+item1;
			this.itemCounts[1] = this.itemCounts[1]+item2;
			this.itemCounts[2] = this.itemCounts[2]+item3;
			this.itemCounts[3] = this.itemCounts[3]+item4;
		}

		public int getSerialNumber(){
			return this.serialNumber;
		}

		public void setSerialNumber(int serialNumber){
			this.serialNumber = serialNumber;
		}

		public String getLocation(){
			return this.location;
		}

		public void setLocation(String location){
			this.location = location;
		}
		
		public double orderTotal(){
			double total=0;
			for(int i=0;i<orderCounts.length;i++)
			{
				if(orderCounts[i]!=0)
				{
					double result=orderCounts[i]*itemCosts[i];
					total=total+result;
					//System.out.println(itemLabels[i]+" : "+orderCounts[i]+" X "+toDollars(itemCosts[i])+" = "+toDollars(result));
				}
			}
				double tax=0.10*total;
				//System.out.println("Tax (10%) : "+toDollars(tax));
				total=total+tax;
				//System.out.println("Total : "+toDollars(total));
			return total;
		}
		
		public String toDollars(double amount){
			return ("$" + String.format("%.2f",amount));
		}
		
}
