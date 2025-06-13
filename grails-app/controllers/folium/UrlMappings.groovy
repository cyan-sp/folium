package com.ord.folium

class UrlMappings {
    static mappings = {

        get "/employee"(controller: 'employee', action: 'listEmployees')
        get "/employee/$id"(controller: 'employee', action: 'findEmployeeByID')
gi//        get "/employee/save"(controller: 'employee', action: 'save')
        post "/employee/save"(controller: 'employee', action: 'save')

//        get "/employee"
//        "/"(view:"/index")
//        "500"(view:'/error')
//        "404"(view:'/notFound')
    }
}

