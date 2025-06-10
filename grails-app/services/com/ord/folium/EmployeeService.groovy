package com.ord.folium

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
}
