package trueder.employmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import trueder.employmanagement.model.Employ;

@RestController
public class EmployController {
	
	@Value("myproperty.name")
	private String name;
	private static  ArrayList<Employ> empList = new ArrayList<>();	
	
	@GetMapping("/getText")
	public String getText() {
		return "Service called successfully..";
	}	
	@GetMapping("/showAllEmploys")
	public List<Employ>  getAllEmps(){
		System.out.println(empList);
		return empList;
	}
	
	@PostMapping("/add")
	public String addeEmp(@RequestBody Employ employ) {
		
		empList.add(employ);
		System.out.println(empList);
		return "Record inserted successfully..";
		
	}
	
	@GetMapping("/search/{empId}")
	public ResponseEntity<?> serachEmploy(@PathVariable int empId) {
		
		if(empList.isEmpty()) {
			return new ResponseEntity<>("List is Empty",HttpStatus.OK);
		}else {
			for (Employ employ : empList) {
				if(employ.getEmployId() == empId) {
					return new ResponseEntity<>(employ,HttpStatus.OK);
				}
			}
		}

		return new ResponseEntity<>("No Record Found",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmploy/{empId}")
	public String deleteEmploy(@PathVariable int empId) {
		if(empList.isEmpty()) {
			return null;
		}else {
			for (Employ employ : empList) {
				if(employ.getEmployId() == empId) {
					empList.remove(employ);
					return "Successfully Deleted";
				}
			}
		}
		return null;
	}
	
	@PutMapping("/updateEmploy")
	public String updateEmploy(@RequestBody Employ newEmploy) {
		
		if(empList.isEmpty()) {
			return "List is Empty";
		}else {
			for (Employ employ : empList) {
				if(employ.getEmployId() == newEmploy.getEmployId()) {
					
					employ.setEmployName(newEmploy.getEmployName());
					employ.setEmployDesignation(newEmploy.getEmployDesignation());
					employ.setEmploySalary(newEmploy.getEmploySalary());
					
					return "Successfully Updated";
				}
			}
		}
		return "Record Not Found";
	}
	
}