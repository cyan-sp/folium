package com.ord.folium
import grails.converters.JSON
//import com.ord.folium.EmployeeService

class BootStrap {
    def EmployeeService

    def init = { servletContext ->
        JSON.registerObjectMarshaller(com.ord.folium.Employee, com.ord.folium.Employee.marshaller)




        if (Employee.count() == 0) {
//            def str = employeeService.greetings()


            employeeService.createEmployeeWithAddress(
                    [firstName: "cyan", lastName: "mv", curp: "cyanmv", position: "ceo"],
                    [state: "tlaxcala", city: "center", zip: "90770"]
            )

//            def empCEO = new Employee(
//                    firstName: "cyan",
//                    lastName: "mv",
//                    curp: "cyanmv",
//                    position: "ceo"
//            )
//            empCEO.id = empCEO.curp.substring(0, 4).toUpperCase()
//            new Address(
//                    state: "tlaxcala",
//                    city: "center",
//                    zip: "90770",
//                    employee: empCEO
//            ).save()
//            empCEO.save(flush: true, failOnError: true)
//
//            def empDev = new Employee(
//                    firstName: "John",
//                    lastName: "Doe",
//                    curp: "JOHNDOE123",
//                    position: "Developer",
//                    manager: empCEO
//            )
//            empDev.id = empDev.curp.substring(0, 4).toUpperCase()
//            new Address(
//                    state: "California",
//                    city: "San Francisco",
//                    zip: "94105",
//                    employee: empDev
//            ).save()
//            empDev.save(flush: true, failOnError: true)
//
//            def subordinate1 = new Employee(
//                    firstName: "Alice",
//                    lastName: "Smith",
//                    curp: "ALISMITH456",
//                    position: "Junior Developer",
//                    manager: empDev
//            )
//            subordinate1.id = subordinate1.curp.substring(0, 4).toUpperCase()
//            new Address(
//                    state: "New York",
//                    city: "New York",
//                    zip: "10001",
//                    employee: subordinate1
//            ).save()
//            subordinate1.save(flush: true, failOnError: true)
//
//            def subordinate2 = new Employee(
//                    firstName: "Bob",
//                    lastName: "Johnson",
//                    curp: "BOBJOHN789",
//                    position: "QA Engineer",
//                    manager: empDev
//            )
//            subordinate2.id = subordinate2.curp.substring(0, 4).toUpperCase()
//            new Address(
//                    state: "Texas",
//                    city: "Austin",
//                    zip: "73301",
//                    employee: subordinate2
//            ).save()
//            subordinate2.save(flush: true, failOnError: true)
//
//            empDev.refresh()

//            empDev.addToSubordinates(subordinate1)
//            empDev.addToSubordinates(subordinate2)
//            empDev.save(flush: true, failOnError: true)
        }
    }

    def destroy = {
    }
}
