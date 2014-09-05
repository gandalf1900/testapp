package no.web.rest;

import no.web.exception.NotFoundException;
import no.web.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ApplicationScoped
public class EmployeeRepository implements Serializable {

	private static final long serialVersionUID = 3328595299837968623L;

    private HashMap<Long, Employee> employees = new HashMap<Long, Employee>();
	
	public List<Employee> getAll() {
		return new ArrayList<Employee>(employees.values());
	}
	
	public Employee get(Long id) {
		Employee employee = employees.get(id);
		if (employee == null) {
			throw new NotFoundException();
		}
		return employee;
	}
	
	public Employee add(Employee employee) {
		if (employee.getId() == null || employee.getId().equals(0L)) {
			throw new InvalidParameterException();
		}
		employees.put(employee.getId(), employee);
		return employee;
	}
	
	public Employee update(Employee employee) {
		return add(employee);		
	}
	
	public void remove(Long id) {
		employees.remove(id);
	}
	
}
