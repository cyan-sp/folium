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

        Address address = new Address(
                state: addressData.state,
                city: addressData.city,
                zip: addressData.zip,
                employee: employee
        )

        address.save()
        employee.save(flush: true, failOnError: true)

        return employee
    }

    def Employee findEmployeeByID (String id) {
        def employee = Employee.get(id)
//        if (!employee) {
////            render (status: 404, text: "Employee not found")
////            return employee
//        }
//        render employee as JSON
        return employee
    }
}
