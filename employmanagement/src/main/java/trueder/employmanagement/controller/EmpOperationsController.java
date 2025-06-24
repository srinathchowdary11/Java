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

import trueder.employmanagement.model.Employ;
import trueder.employmanagement.repository.EmployRepository;
import trueder.employmanagement.service.EmployService;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EmpOperationsController {

	
	@Autowired
	private EmployService employService;
	
	@GetMapping("/showAll")
	public List<Employ> getAllEmp(){
		return employService.showAllEmploys();
	}	
	
	@PostMapping("/addEmp")
	public String addEmpDetails(@RequestBody Employ empoy) {
				
		return employService.addEmployDetails(empoy);

	}	
	
	@GetMapping	("/searchEmp/{empId}")
	public ResponseEntity<?> searchEmploy(@PathVariable int empId){
				
			Employ employ =  employService.searchEmploy(empId);
			
			if(employ != null)
				return new ResponseEntity<>(employ,HttpStatus.OK);
			
			return new ResponseEntity<>("No Record Found..",HttpStatus.OK);				
						
	}
	
	@DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmploy(@PathVariable int empId) {
        String isDeleted = employService.deleteEmployDetails(empId);

        if (isDeleted != null) {
            return new ResponseEntity<>("Deleted...", HttpStatus.OK);
        }
        
        return new ResponseEntity<>("No Record Found..", HttpStatus.NOT_FOUND);
    }

	  
	  @PutMapping("/update")
	    public ResponseEntity<String> update(@RequestBody Employ newEmploy) {
	        String updatedEmploy = employService.updateEmployDetails(newEmploy);
	        
	        if (updatedEmploy != null) {
	            return new ResponseEntity<>("Updated.....", HttpStatus.OK);
	        }
	        
	        return new ResponseEntity<>("No Record Found..", HttpStatus.NOT_FOUND); 
	    }
	  
/*
 * @GetMapping("/getEmpDesignation/{empDesignation}") public ResponseEntity<?>
 * getEmployByDesignation(@PathVariable String empDesignation){
 * 
 * List<Employ> empList =
 * employRepository.findByEmployDesignation(empDesignation);
 * 
 * if(empList.isEmpty()) { return new
 * ResponseEntity<>("No Records with ....."+empDesignation,HttpStatus.OK); }else
 * { return new ResponseEntity<>(empList,HttpStatus.OK); }
 * 
 * }
 * 
 * @GetMapping("/search/{empDesignation}/{empSalary}") public ResponseEntity<?>
 * searchBy(@PathVariable String empDesignation,@PathVariable float empSalary){
 * 
 * List<Employ> empList =
 * employRepository.findByDesignationAndSalary(empDesignation, empSalary);
 * 
 * if(empList.isEmpty()) { return new
 * ResponseEntity<>("No Records with ....."+empDesignation
 * +" and "+empSalary,HttpStatus.OK); }else { return new
 * ResponseEntity<>(empList,HttpStatus.OK); }
 * 
 * 
 * }
 */
}