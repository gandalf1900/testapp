package no.web.rest.mock;

import no.web.model.Employee;
import no.web.model.Money;
import no.web.model.Payslip;
import javax.enterprise.inject.Produces;
import java.util.*;

public class EmployeeMockBuilder {
	
	@Produces
	public Map<Long, Employee> createEmployeesMock() {
		Map<Long,Employee> employees = new HashMap<Long, Employee>();
		employees.put(1L, createFrodo());
		employees.put(2L, createGandalf());
		employees.put(3L, createSauron());
		return employees;
	}

	public Employee createFrodo() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("Frodo");
		employee.setLastName("Baggins");
		employee.setFileNumber(666L);
		employee.setPayslips(getPayslipsOfFrodo());
		return employee;
	}

	public Employee createGandalf() {
		Employee employee = new Employee();
		employee.setId(2L);
		employee.setFirstName("Gandalf");
		employee.setLastName("White");
		employee.setFileNumber(299L);
		employee.setPayslips(getPayslipsOfGandalf());
		return employee;
	}

	public Employee createSauron() {
		Employee employee = new Employee();
		employee.setId(3L);
		employee.setFirstName("Sauron");
		employee.setLastName("Balotelli");
		employee.setFileNumber(156L);
		employee.setPayslips(getPayslipsOfSauron());
		return employee;
	}
	
	private List<Payslip> getPayslipsOfFrodo() {
		return Arrays.asList(
				createPayslip(1L, 2014, Calendar.JANUARY, 1, "250 MordorDollar"),
				createPayslip(2L, 2014, Calendar.FEBRUARY, 1, "250 MordorDollar"),
				createPayslip(3L, 2014, Calendar.MARCH, 1, "250 MordorDollar"),
				createPayslip(4L, 2014, Calendar.APRIL, 1, "500 MordorDollar"),
				createPayslip(5L, 2014, Calendar.MARCH, 1, "500 MordorDollar"),
				createPayslip(6L, 2014, Calendar.JUNE, 1, "750 MordorDollar"));
	}

	private List<Payslip> getPayslipsOfGandalf() {
		return Arrays.asList(
				createPayslip(7L, 2014, Calendar.JANUARY, 1, "150 MordorDollar"),
				createPayslip(8L, 2014, Calendar.FEBRUARY, 5, "150 MordorDollar"),
				createPayslip(9L, 2014, Calendar.MARCH, 1, "200 MordorDollar"),
				createPayslip(10L, 2014, Calendar.APRIL, 9, "200 MordorDollar"),
				createPayslip(11L, 2014, Calendar.MARCH, 1, "200 MordorDollar"),
				createPayslip(12L, 2014, Calendar.JUNE, 1, "500 MordorDollar"));
	}

	private List<Payslip> getPayslipsOfSauron() {
		return Arrays.asList(
				createPayslip(13L, 2014, Calendar.JANUARY, 1, "1350 MordorDollar"),
				createPayslip(14L, 2014, Calendar.APRIL, 5, "1350 MordorDollar"),
				createPayslip(15L, 2014, Calendar.JUNE, 1, "5000 MordorDollar"));
	}
	
	private Payslip createPayslip(Long id, int payYear, int payMonth, int payDay, String pay) {
		Payslip payslip = new Payslip();
		payslip.setId(id);
		payslip.setPayMonth(payMonth);
		payslip.setPayDate(new GregorianCalendar(payYear, payMonth, payDay).getTime());
		payslip.setPay(new Money(pay));
		return payslip;
	}
	
}
