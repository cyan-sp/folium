package com.ord.folium
import grails.converters.JSON
import grails.rest.*
import grails.converters.*
import com.ord.folium.Utils



class EmployeeController {
    def EmployeeService

    static responseFormats = ['json', 'xml']
    def logId = UUID.randomUUID().toString().replaceAll('\\-', '')

    def save() {
        def json = request.JSON
        if(!json) {
            return respond([error: 'what went wrong ?'])
        } else {
            render json as JSON
        }
//        try {
//            def json = request.JSON
//            return json as JSON
//
//        } catch (e) {
//
//        }
    }

    def listEmployees() {
        // TODO: JSON: Implement interal error
        try {
            render Employee.list() as JSON

        } catch (e) {
            Utils.logger(logId, 'Listar empleados', 'All bad')
            return TypeError.internalError(logId)
        }
    }

    def findEmployeeByID () {
        try {
            def employee = Employee.get(params.id)
            if (!employee) {
                TypeError.informationNotFound(params.id)
                return
            }
            render employee as JSON
        } catch (e) {
            Utils.logger(logId, 'Listar empleados', 'All bad')
            return TypeError.internalError(logId)
        }

    }

}
