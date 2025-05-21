class Ticket{
	int ticketNumber;
	String customerName;
	int seatnumber;
	int[] bookedseat=new int[10];
	int no_of_seatsbooked=0;
	int i=1;
	int canceledseats=0;
	
	Ticket(int ticketNumber,String customerName,int seatnumber){
		this.ticketNumber=ticketNumber;
		this.customerName=customerName;
		this.seatnumber=seatnumber;
	}
	
	Ticket(){
		
	}
	
	int getTicketNumber(){
		return ticketNumber;
	}
	
	String getCustomerName(){
		return customerName;
	}
	
	int getSeatNumber(){
		return seatnumber;
	}
	
	public void booking(){
		if(no_of_seatsbooked<10){
			bookedseat[no_of_seatsbooked]=i;
			no_of_seatsbooked=no_of_seatsbooked+1;
			i++;
		}
		else{
			System.out.println("Housefull no more tickets available.");
		}
		
	}
	
	public void cancelticket(int seatnumber){
		for(int j=0;j<no_of_seatsbooked;j++){
			if(bookedseat[j]==seatnumber){
				canceledseats=canceledseats+1;
				System.out.println("w");
				int a=j+1;
				while(j<no_of_seatsbooked-1 && a<no_of_seatsbooked-1){
					bookedseat[j]=bookedseat[a];
					System.out.println("a");
					j++;
					a++;
				}
			}
		}
	}
	
	public void display(){
		for(int j=0;j<no_of_seatsbooked;j++){
			System.out.println(bookedseat[j]);
		}
	}
	
	
}

class Main{
	public static void main(String[] args){
		Ticket t1=new Ticket();
		t1.booking();
		t1.booking();
		t1.booking();
		t1.display();
		t1.cancelticket(2);
		t1.display();
	}
}