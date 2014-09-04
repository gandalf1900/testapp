package no.web.data;

import no.web.model.Employee;
import no.web.model.Money;
import no.web.model.Payslip;
import no.web.rest.EmployeeResource;
import no.web.rest.mock.EmployeeMockBuilder;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJacksonProvider;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeResourceTest {
	
	private static final Logger log = Logger.getLogger("test");
	
	private EmployeeResource resource;

    @Inject
    EmployeeMockBuilder employeeMockBuilder;
	
	@BeforeClass
	public static void initStatic() {
		// this initialization only needs to be done once per VM
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
	}
	
	@Before
	public void init() {
        resource = ProxyFactory.create(EmployeeResource.class, "http://localhost:8080/testapp/rest/");
        Assert.assertNotNull(resource);
        final ResteasyProviderFactory instance = ResteasyProviderFactory.getInstance();
        instance.addMessageBodyReader(ResteasyJacksonProvider.class);
        instance.addMessageBodyWriter(ResteasyJacksonProvider.class);
	}
	
	@Test
	public void getAll() {

        try {
            List<Employee> employees = resource.getAll();

            Assert.assertNotNull(employees);
            Assert.assertEquals(3, employees.size());

            for (Employee employee : employees) {
                log.info(MessageFormat.format("Name: {0}, LastName: {1}",
                        employee.getFirstName(), employee.getLastName()));
                for (Payslip payslip : employee.getPayslips()) {
                    log.info(MessageFormat.format("MONTH: {0}, Salary: {1} {2}",
                            payslip.getPayMonth(), payslip.getPay().getAmount(), payslip.getPay().getCurrency()));
                }
            }

        }   catch (Exception e) {

            System.out.println("error");
        }
	}
	
	@Test
	public void add() {

        ClientResponse<Employee> response = (ClientResponse<Employee>) resource.add(createFrodo());
		
		Assert.assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
		
		Employee employee = response.getEntity(Employee.class);
		Assert.assertEquals("Frodo", employee.getFirstName());
		
		Employee frodo = resource.get(4L);
		Assert.assertEquals("Frodo", frodo.getFirstName());
		Assert.assertEquals(1, frodo.getPayslips().size());

		Response resp = resource.remove(4l);
		Assert.assertEquals(Status.OK.getStatusCode(), resp.getStatus());
	}
	
	private Employee createFrodo() {
		Employee employee = new Employee();
		employee.setId(4L);
		employee.setFirstName("Frodo");
		employee.setMiddleName("test");
		employee.setLastName("Baggins");
		employee.setFileNumber(981L);
		
		Payslip payslip = new Payslip();
		payslip.setId(25L);
		payslip.setPay(new Money("550000000 ARS"));
		payslip.setPayDate(new Date());
		payslip.setPayMonth(Calendar.AUGUST);
		employee.setPayslips(Arrays.asList(payslip));
		
		return employee;
	}
}
