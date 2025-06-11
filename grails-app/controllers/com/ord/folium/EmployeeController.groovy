package com.ord.folium
import grails.converters.JSON
import grails.rest.*
import grails.converters.*

class EmployeeController {
    def EmployeeService

    static responseFormats = ['json', 'xml']

    def index() {
        render params
    }

    def listEmployees() {
        render Employee.list() as JSON
    }

    def findEmployeeByID () {
        render params
//        def employee = Employee.get(id)
//        if (!employee) {
//            render (status: 404, text: "Employee not found")
//            return
//        }
//        render employee as JSON
    }

    def mytest () {
        def employees = Employee.list()
        render employees[0].getId()
    }

}
