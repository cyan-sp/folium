package folium
import folium.Employee


class BootStrap {

    /*def init = { servletContext ->
        new Employee(firstName: "first name", lastName: "last name", curp: "curp", position: "position").save(flush: true, failOnError: true)
        new Employee(firstName: "2", lastName: "2", curp: "2", position: "2").save(flush: true, failOnError: true)
    }*/

    def init = { servletContext ->
    // Check if there are any employees in the DB
    if (Employee.count() == 0) {
        // Only insert if table is empty
        new Employee(firstName: "first name", lastName: "last name", curp: "curp", position: "position")
            .save(flush: true, failOnError: true)
        new Employee(firstName: "2", lastName: "2", curp: "2", position: "2")
            .save(flush: true, failOnError: true)
    }
}

    def destroy = {
    }
}
