package trueder.employmanagement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import trueder.employmanagement.model.Employ;


public interface EmployRepository extends JpaRepository<Employ, Integer> {

	
	List<Employ>  findByEmployDesignation(String employDesignation);	
	
	
	@Query(nativeQuery = true,value = "select * from emp_details  where employ_Designation = :empDesignation and  employ_Salary >=:empSalary  ")
	
	//@Query(value = "select e from Employ e where e.employDesignation = :empDesignation and  e.employSalary >=:empSalary  ")
	List<Employ> findByDesignationAndSalary(@Param("empDesignation") String empDesignation, @Param("empSalary") float empSalary);
	
	
	
	
	
	
}
