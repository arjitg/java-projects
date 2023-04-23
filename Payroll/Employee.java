package PP03;


public class Employee extends Person{
	
	private int eID;
    private Status empStatus;
    
    public Employee(){}

    public Employee(int eID, Status empStatus){
        this.eID = eID;
        this.empStatus = empStatus;
    }

    public Status getEmpStatus(){
        return this.empStatus;
    }

    public void setEmpStatus(Status empStatus){
        this.empStatus = empStatus;
    }

    public void setEid(int eID){
        this.eID = eID;
    }

    @Override
    public String toString(){
        return "EmployeeID: " + this.eID + ", Employee Status: " + this.empStatus.toString()
            + ", First Name: " + this.fName + ", Last Name: " + this.lName;
    }

    // 1- The Employee class extends superclass Person
    // 2- add the subclass Employee constructor that calls the supper Person class constructor, you should provide input data for all parent class data fields
   // 3- add setters/getters methods
   // 4- add override toString() method that overrides toString() in the superclass Person 

	
}
