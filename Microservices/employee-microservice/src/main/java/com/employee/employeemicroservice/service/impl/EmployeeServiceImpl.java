package com.employee.employeemicroservice.service.impl;

import com.employee.employeemicroservice.entity.APIResponseDto;
import com.employee.employeemicroservice.entity.DepartmentDto;
import com.employee.employeemicroservice.entity.Employee;
import com.employee.employeemicroservice.entity.OrganizationDto;
import com.employee.employeemicroservice.repository.EmployeeRepository;
import com.employee.employeemicroservice.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private WebClient webClient;

    //private RestTemplate restTemplate;

    //private APIClient apiClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Override
    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getByEmail(String email) {

        LOGGER.info("Inside getByEmail method");

        Employee employee = employeeRepository.findByEmail(email);

//        ResponseEntity<DepartmentDto> responseEntity =  restTemplate.getForEntity("http://localhost:8081/api/departments/" + employee.getDepartmentCode(),DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8081/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organization/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        //DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employee);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(String email, Exception ex) {

        LOGGER.info("Inside getDefaultDepartment method");

        Employee employee = employeeRepository.findByEmail(email);

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("DefaultCode");
        departmentDto.setDepartmentName("DefaultDepartmentName");
        departmentDto.setDepartmentDescription("desc");

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employee);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
