package no.web.rest;

import no.web.model.Employee;
import no.web.rest.mock.EmployeeMockBuilder;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeResource {

    @Inject
    EmployeeMockBuilder employeeMockBuilder;

    @Inject
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAll() {
        Map<Long, Employee> employees = employeeMockBuilder.createEmployeesMock();

        final List<Employee> all = repository.getAll();
        return all;
    }

    @Override
    public Employee get(Long id) {
        final Employee employee = repository.get(id);
        return employee;
    }

    @Override
    public Response add(Employee employee) {
        Employee result = repository.add(employee);
        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    @Override
    public Response update(Long id, Employee employee) {
        Employee original = repository.get(id);
        employee.setId(original.getId());
        Employee result = repository.update(employee);
        return Response.ok(result).build();
    }

    @Override
    public Response remove(Long id) {
        repository.remove(id);
        return Response.ok().build();
    }

}