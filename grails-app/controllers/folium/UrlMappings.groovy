package com.ord.folium

class UrlMappings {
    static mappings = {
        // Specific employee mappings - these should come first
        get "/employee"(controller: 'employee', action: 'listEmployees')
        get "/employee/$id"(controller: 'employee', action: 'findEmployeeByID')

        // Generic mapping for other controllers
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // Add any constraints here if needed
            }
        }

        // Default mappings
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}

