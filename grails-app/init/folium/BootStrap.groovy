package com.ord.folium
import grails.converters.JSON
//import com.ord.folium.EmployeeService
import groovy.json.JsonBuilder;

class BootStrap {
    def EmployeeService

    def init = { servletContext ->
        JSON.registerObjectMarshaller(com.ord.folium.Employee, com.ord.folium.Employee.marshaller)

        Date.metaClass.log = {
            delegate.format("yyyy-MM-dd HH:mm:ss")
        }
        Object.metaClass.toPrettyString = {
            try {
                return new JsonBuilder(delegate).toPrettyString().replaceAll('\n', '').replaceAll('    ', '')
            }catch(e) {
                return '{ERROR-AL-GENERAL-JSON}'
            }
        }

        if (Employee.count() == 0) {
            def empCEO = employeeService.createEmployeeWithAddress(
                    [firstName: "cyan", lastName: "mv", curp: "cyanmv", position: "ceo"],
                    [state: "tlaxcala", city: "center", zip: "90770"]
            )

            // Create Developer with CEO as manager
            def empDev = employeeService.createEmployeeWithAddress(
                    [firstName: "John", lastName: "Doe", curp: "JOHNDOE123", position: "Developer", manager: empCEO],
                    [state: "California", city: "San Francisco", zip: "94105"]
            )

            // Create Junior Developer with Dev as manager
            def subordinate1 = employeeService.createEmployeeWithAddress(
                    [firstName: "Alice", lastName: "Smith", curp: "ALISMITH456", position: "Junior Developer", manager: empDev],
                    [state: "New York", city: "New York", zip: "10001"]
            )

            // Create QA Engineer with Dev as manager
            def subordinate2 = employeeService.createEmployeeWithAddress(
                    [firstName: "Bob", lastName: "Johnson", curp: "BOBJOHN789", position: "QA Engineer", manager: empDev],
                    [state: "Texas", city: "Austin", zip: "73301"]
            )

        }
    }

    def destroy = {
    }
}
