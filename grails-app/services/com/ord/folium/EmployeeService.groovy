package com.ord.folium
import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class EmployeeService {

//    def serviceMethod() {
//
//    }

    def save(data) {
        def employee = Employee.findByid(data.id)
    }


    Employee createEmployeeWithAddress(Map employeeData, Map addressData) {
        Employee employee = new Employee(
                firstName: employeeData.firstName,
                lastName: employeeData.lastName,
                curp: employeeData.curp,
                position: employeeData.position
        )

        employee.id = Employee.generateIdFromCurp(employeeData.curp)


        if (employeeData.manager) {
            employee.manager = employeeData.manager

            employeeData.manager.addToSubordinates(employee)
            employeeData.manager.save(flush: true)
        }


        Address address = new Address(
                state: addressData.state,
                city: addressData.city,
                zip: addressData.zip,
                employee: employee
        )

        employee.save(flush: true, failOnError: true)
        address.save(flush: true, failOnError: true)

        return employee
    }

    def Employee findEmployeeByID(String id) {
        def employee = Employee.get(id)
        return employee
    }


    def List<Employee> getAllEmployeesWithRelationships() {
        return Employee.createCriteria().list {
            fetchMode('subordinates', org.hibernate.FetchMode.JOIN)
            fetchMode('address', org.hibernate.FetchMode.JOIN)
        }
    }
}