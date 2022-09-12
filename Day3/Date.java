//
//Create a class Date with following details:
//Attributes : dd,mm,yy
//Methods: displayDate(), checkDate()
//(Use the concept of parameterized constructor, code recommendation and
//this keyword)

public class Date {
	int dd;
	int mm;
	int yy;
	public Date() {};
	public Date(int dd,int mm,int yy) {
		this.dd=dd;
		this.mm=mm;
		this.yy=yy;
	}
	public void displayDate() {
		System.out.println("Date: "+this.dd+" Month: "+this.mm+" Year "+this.yy);
	}

	public boolean checkDate() {
		while((this.dd>0&& this.dd<=31)&&(this.mm>0&&this.mm<=12)&&yy>0) {
			if((yy % 400 == 0||yy%4==0 )&& mm==2)
	        {
				//leapyear  with feb month
	            if(this.dd<=29)return true;
	        }
			//for non leap year with feb month
	        else if (yy % 100 == 0 && mm==2 &&dd<=28)return true;
	        else if((mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)&&dd<=31)return true;
	        else if((mm==4||mm==6||mm==9||mm==11)&&dd<=30)return true;
			
	        else return false;
	       
	       
		}
		//if date and month exceeding 
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date(31,4,2000);
		date.displayDate();
		if(date.checkDate()) {
			System.out.println("date is valid");
		}else {
			System.out.println("Date is invalid");
		}

	}

}
