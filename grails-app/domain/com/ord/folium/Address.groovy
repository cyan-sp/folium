package com.ord.folium

class Address {

    String state
    String city
    String zip
    Employee employee
    static belongsTo = [employee: Employee]

    static constraints = {
        zip nullable: true
    }

}