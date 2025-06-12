package com.ord.folium
import grails.converters.JSON
import grails.rest.*
import grails.converters.*
import com.ord.folium.Utils

class EmployeeController {
    def EmployeeService

    static responseFormats = ['json', 'xml']

    def listEmployees() {
        def logId = UUID.randomUUID().toString().replaceAll('\\-', '')
        Utils.logger(logId, 'lista empleados', 'inicia proceso')
        render Employee.list() as JSON
//        log.error "mmmmmm"
//        render Employee.list() as TODO
// JSON: Implement interal error
//        try {
////            throw new RuntimeException("Forced failure for testing") // This line will always throw
//            render Employee.list() as JSON
//            log.info "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"
////            utils.logger(logId, "test", "test", "Error :" + e.getMessage())
//        }
//        catch (e) {
////            render e
////            Log.logger(logId, "Listar Profesores", "Ha ocurrido una excepción", "ERROR: ${e.getMessage()}")
////            com.ord.folium.Log.logger(com.ord.folium.Log.ERROR, 'string', "Listar Profesores", "Ha ocurrido una excepción", "ERROR: ${e.getMessage()}")
////            Log.logger(logId, "test", "test", "", "Error :" + e.getMessage)
//        }
    }

    def findEmployeeByID () {

        def employee = Employee.get(params.id)
        if (!employee) {
            TypeError.informationNotFound(params.id)
            return
        }
        render employee as JSON
    }

}
