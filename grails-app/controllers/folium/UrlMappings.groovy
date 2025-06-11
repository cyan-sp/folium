package com.ord.folium

class UrlMappings {
    static mappings = {

        get "/employee"(controller: 'employee', action: 'listEmployees')
        get "/employee/$id"(controller: 'employee', action: 'findEmployeeByID')
//        get "/employee"
//        "/"(view:"/index")
//        "500"(view:'/error')
//        "404"(view:'/notFound')
    }
}

