package folium
import folium.Employee
import grails.converters.JSON

class EmployeeController {
    /*def data = request.JSON*/
    static responseFormats = ['json','xml']

    def index() {
        def employees = Employee.list()
        render employees as JSON
    }
}
