package folium

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }

            get "/employee"(controller: 'employee', action: 'listEmployees')
//            get "/employee/{id}"(controller: 'employee', action: 'findEmployeeByID')

//            findEmployeeByID below

//            group "/employee", {
//
//                get "/list"(controller: 'employee', action: 'listEmployees')
////
////                get "/paginator"(controller: 'employee', action: 'paginator')
////
////                post "/save" (controller: 'employee', action: 'register')
////
////                group "/$uuid",{
////
////                    get "/read" (controller: 'employee', action: 'listOne')
////
////                    group "/update",{
////                        patch "/boss" (controller: 'employee', action: 'updateBoss')
////
////                        patch "/position" (controller: 'employee', action: 'updatePosition')
////                    }
////
////                    delete "/delete"(controller: 'employee', action: 'deleteEmpleado')
////
////                }
////                constraints {
////                    uuid(matches: /[a-zA-Z0-9]{32}/)
////                }
//
//            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
