package folium
import folium.Employee

class Address {

    String state
    String city
    String zip
    static belongsTo = [employee: Employee]

    static constraints = {
    }
}
