package com.ord.folium
import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class EmployeeService {

    def serviceMethod() {
    }

    Employee createEmployeeWithAddress(Map employeeData, Map addressData) {
        Employee employee = new Employee(
                firstName: employeeData.firstName,
                lastName: employeeData.lastName,
                curp: employeeData.curp,
                position: employeeData.position
        )

        employee.id = Employee.generateIdFromCurp(employeeData.curp)

        // Handle manager relationship
        if (employeeData.manager) {
            employee.manager = employeeData.manager
            // Add this employee to manager's subordinates
            employeeData.manager.addToSubordinates(employee)
            employeeData.manager.save(flush: true)
        }

        // Create and save address
        Address address = new Address(
                state: addressData.state,
                city: addressData.city,
                zip: addressData.zip,
                employee: employee
        )

        // Save employee first, then address
        employee.save(flush: true, failOnError: true)
        address.save(flush: true, failOnError: true)

        return employee
    }

    def Employee findEmployeeByID(String id) {
        def employee = Employee.get(id)
        return employee
    }

    // Add this method to get employees with their relationships loaded
    def List<Employee> getAllEmployeesWithRelationships() {
        return Employee.createCriteria().list {
            fetchMode('subordinates', org.hibernate.FetchMode.JOIN)
            fetchMode('address', org.hibernate.FetchMode.JOIN)
        }
    }
}