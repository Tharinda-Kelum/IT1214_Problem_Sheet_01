class Ticket{
	int ticketNumber;
	String customerName;
	int seatnumber;
	int[] bookedseat=new int[10];
	int[] canceledseat=new int[10];
	int no_of_seatsbooked=0;
	int i=1;
	int canceledseats=0;
	int b=0;
	
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
		if(canceledseats==0){
			if(no_of_seatsbooked<10){
				bookedseat[no_of_seatsbooked]=i;
				no_of_seatsbooked=no_of_seatsbooked+1;
				i++;
			}
			else{
				System.out.println("Housefull no more tickets available.");
			}
		}
		else{
			for(int c=0;c<canceledseats;c++){
				System.out.println("Seat no "+canceledseat[c]+" is available.");
			}
		}
	}
	
	public void booking(int seatnumber){
		for(int c=0;c<canceledseats;c++){
			System.out.println("a");
			if(canceledseat[c]==seatnumber){
				bookedseat[no_of_seatsbooked-1]=seatnumber;
				System.out.println("b");
			}
		}
	}
	
	public void cancelticket(int seatnumber){
		for(int j=0;j<no_of_seatsbooked;j++){
			if(bookedseat[j]==seatnumber){
				canceledseats=canceledseats+1;
				canceledseat[b]=seatnumber;
				int a=j+1;
				while(j<no_of_seatsbooked && a<no_of_seatsbooked){
					bookedseat[j]=bookedseat[a];
					j++;
					a++;
				}
				bookedseat[no_of_seatsbooked-1]=0;
				b++;
			}
		}
	}
	
	public void display(){
		for(int j=0;j<no_of_seatsbooked;j++){
			if(bookedseat[j]!=0){
				System.out.println(bookedseat[j]);
			}
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
		t1.booking(2);
		t1.display();
	}
}