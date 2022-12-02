package December1Lab;

public class Main {
	public static void main(String[] args) throws Exception {
		EmployeeUploader obj= new EmployeeUploader();
		obj.storeDepartmentDetails();
		obj.storeEmployeeDetails();
		obj.retrieveEmployeeDetails(2);
		obj.calculatePF(3);
		
	}
}
