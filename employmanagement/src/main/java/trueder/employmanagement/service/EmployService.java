package trueder.employmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import trueder.employmanagement.model.Employ;
import trueder.employmanagement.repository.EmployRepository;

@Service
public class EmployService {
	
	@Autowired
	private EmployRepository employRepository;
		
	public List<Employ> showAllEmploys(){
		
		return employRepository.findAll();
	}	
	
	public String addEmployDetails(Employ employ) {
				
		String newEmpName = "Emp - "+employ.getEmployId()+":" +employ.getEmployName();
		employ.setEmployName(newEmpName);
		employRepository.save(employ);
		return "Successfully Added...";
		
	}	
	
	public Employ searchEmploy(int empId) {
		
		try {		
			return  employRepository.findById(empId).get();	
			
		}
		catch(Exception e) {
			return null;
					
		}
	}
	
	public String updateEmployDetails(Employ newEmployData) {
       
        Optional<Employ> optionalEmploy = employRepository.findById(newEmployData.getEmployId());

        if (optionalEmploy.isPresent()) {
            Employ existingEmploy = optionalEmploy.get();

            existingEmploy.setEmployName(newEmployData.getEmployName());
            existingEmploy.setEmployDesignation(newEmployData.getEmployDesignation());
            existingEmploy.setEmploySalary(newEmployData.getEmploySalary());

            employRepository.save(existingEmploy);

            return "Successfully Updated";
        } else {
            return "Record Not Found with ID: " + newEmployData.getEmployId();
        }
    }

    public String deleteEmployDetails(int employId) {
        if (employRepository.existsById(employId)) {
            employRepository.deleteById(employId);
            return "Successfully Deleted";
        } else {
            return "Record Not Found with ID: " + employId;
        }
    }
}	
