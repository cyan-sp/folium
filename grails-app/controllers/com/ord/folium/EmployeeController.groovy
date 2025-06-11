package com.ord.folium
import grails.converters.JSON
import grails.rest.*
import grails.converters.*

class EmployeeController {
    def EmployeeService

    static responseFormats = ['json', 'xml']

//    def index() {
//        render Test()
//    }

    def listEmployees() {
        render Employee.list() as JSON
//         render 'mmmm'
//        render TypeError.Test()
    }

    def findEmployeeByID () {

//        render params
        def employee = Employee.get(params.id)
        if (!employee) {
            render (status: 404, text: "Employee not found")
            return
        }
        render employee as JSON
    }

    def mytest () {
        render 'wtf'
//        def employees = Employee.list()
//        render employees[0].getId()
    }

}
