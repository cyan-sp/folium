package com.ord.folium
import grails.converters.JSON


class EmployeeController {

//    def index() {
//
//    }

    def listEmployees() {
        render Employee.list() as JSON
    }

    def findEmployeeByID (String id) {
        def employee = Employee.get(id)
        if (!employee) {
            render (status: 404, text: "Employee not found")
            return
        }
        render employee as JSON


    }
}
