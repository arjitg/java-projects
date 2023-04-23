package PP03;

import java.util.Date;


public class PayPeriod {
	
	private int pID;
    private Date pStartDate, pEndDate;

    public PayPeriod(int pid, Date startDate, Date endDate){
        this.pID = pid;
        this.pStartDate = startDate;
        this.pEndDate = endDate;
    }

    public int getPID(){
        return this.pID;
    }
    public void setPID(int pid){
        this.pID = pid;
    }
    public Date getpStartDate(){
        return this.pStartDate;
    }
    public void setpStartDate(Date startDate){
        this.pStartDate = startDate;
    }
    public Date getpEndDate(){
        return this.pEndDate;
    }
    public void setpEndDate(Date endDate){
        this.pEndDate = endDate;
    }

    @Override
    public String toString(){
        return "Pay period ID: " + this.pID + ", Start Date: " + this.pStartDate.toString() + ", End Date: " + this.pEndDate.toString();
    }
    
    // 1- add the class constructor
    // 2- add the setters/getters methods
    // 3- add override method toString() 
}
