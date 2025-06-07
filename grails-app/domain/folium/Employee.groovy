package folium
import folium.Address

class Employee {
    Long id

    String firstName
    String lastName
    String curp
    String position
    static hasOne = [address: Address]

    static constraints = {

    }


}
