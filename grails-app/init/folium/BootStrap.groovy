package folium
import folium.Employee


class BootStrap {

    def init = { servletContext ->
        def emp = new Employee (firstName: "first name", lastName: "ln", curp:"curp", position:"position")
        emp.save(flush:true)
    }
    def destroy = {
    }
}
