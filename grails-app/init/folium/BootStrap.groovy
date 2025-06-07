package folium
import folium.Employee
import folium.Address

class BootStrap {

    /*def init = { servletContext ->
        new Employee(firstName: "first name", lastName: "last name", curp: "curp", position: "position").save(flush: true, failOnError: true)
        new Employee(firstName: "2", lastName: "2", curp: "2", position: "2").save(flush: true, failOnError: true)
    }*/

    def init = { servletContext ->
    // Check if there are any employees in the DB
    /*if (Address.count() == 0) {

    }*/
    /*if (Employee.count() == 0) {
        // Only insert if table is empty
        new Employee(firstName: "first name", lastName: "last name", curp: "curp", position: "position")
            .save(flush: true, failOnError: true,
            address: new Address(state: "tlaxcala", city:"center", zip:"90770"))
        *//*new Employee(firstName: "2", lastName: "2", curp: "2", position: "2")
            .save(flush: true, failOnError: true)*//*
    }*/
if (Employee.count() == 0) {

    // 1 Create the Employee (do not save yet)
    def emp = new Employee(
        firstName: "first name",
        lastName: "last name",
        curp: "curp",
        position: "position"
    )

    // 2. Create the Address, assign the Employee
    def addr = new Address(
        state: "tlaxcala",
        city: "center",
        zip: "90770",
        employee: emp // <-- Set the employee for Address
    )

    // 3. Assign the Address to the Employee
    emp.address = addr

    // 4. Save the Employee (will save Address as well)
    emp.save(flush: true, failOnError: true)
}
}

    def destroy = {
    }
}
