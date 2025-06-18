package trueder.employmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import trueder.employmanagement.EmployRepository;
import trueder.employmanagement.model.Employ;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class EmpOperationsController {

	
	@Autowired
	private EmployRepository employRepository;
	
	@GetMapping("/showAll")
	public List<Employ> getAllEmp(){
		return employRepository.findAll();
	}	
	
	@PostMapping("/addEmp")
	public String addEmpDetails(@RequestBody Employ empoy) {
		employRepository.save(empoy);
		return "added...";	
	}
		
	@GetMapping	("/searchEmp/{empId}")
	public ResponseEntity<?> searchEmploy(@PathVariable int empId){
		
		try {		
			Employ employ =  employRepository.findById(empId).get();		
			return new ResponseEntity<>(employ,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("No Record Found..",HttpStatus.OK);
					
		}
				
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> deleteEmploy(@PathVariable int empId){
		
		try {		
			Employ employ =  employRepository.findById(empId).get();
			employRepository.delete(employ);
			return new ResponseEntity<>("Deleted...",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("No Record Found..",HttpStatus.OK);					
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update( @RequestBody Employ newEmploy) {
		try {		
			Employ employ =  employRepository.findById(newEmploy.getEmployId()).get();			
			employ.setEmployName(newEmploy.getEmployName());
			employ.setEmployDesignation(newEmploy.getEmployDesignation());
			employ.setEmploySalary(newEmploy.getEmploySalary());
			employRepository.save(employ);			
			return new ResponseEntity<>("updated.....",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("No Record Found..",HttpStatus.OK);					
		}
	}

	@GetMapping("/getEmpDesignation/{empDesignation}")
	public ResponseEntity<?> getEmployByDesignation(@PathVariable String empDesignation){
				
		  List<Employ> empList =  employRepository.findByEmployDesignation(empDesignation);
		  
		  if(empList.isEmpty()) {
			  return new ResponseEntity<>("No Records with ....."+empDesignation,HttpStatus.OK);
		  }else {			  
			  return new ResponseEntity<>(empList,HttpStatus.OK);
		  }
		
	}
	
	@GetMapping("/search/{empDesignation}/{empSalary}")
public ResponseEntity<?> searchBy(@PathVariable String empDesignation,@PathVariable float empSalary){
		
			 List<Employ> empList =  employRepository.findByDesignationAndSalary(empDesignation, empSalary);
			  
			  if(empList.isEmpty()) {
				  return new ResponseEntity<>("No Records with ....."+empDesignation +" and "+empSalary,HttpStatus.OK);
			  }else {			  
				  return new ResponseEntity<>(empList,HttpStatus.OK);
			  }
			
				
	}
	
}