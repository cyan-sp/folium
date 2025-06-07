package folium
import folium.Employee

class Address {

    String state
    String city
    String zip
    Employee employee
    static belongsTo = [employee: Employee]

    static constraints = {
    }
}
