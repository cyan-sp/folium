package com.ord.folium
import grails.converters.JSON


class EmployeeController {

//    def index() {
//
//    }

    def listEmployees() {
        render Employee.list() as JSON
    }
}
