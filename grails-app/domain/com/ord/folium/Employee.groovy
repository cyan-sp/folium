package com.ord.folium
//import ResponseError

class Employee {
    String ida
    String firstName
    String lastName
    String curp
    String position

    static hasOne = [address: Address]

    static hasMany = [subordinates: Employee]
    static belongsTo = [manager: Employee]

    static mapping = {
        id generator: 'assigned'
    }
    def beforeInsert() {

        if (curp && curp.length() >= 4) {
            this.id = curp.substring(0, 4).toUpperCase()
        } else {
            throw new IllegalStateException("CURP must be at least 2 characters long")
        }
    }

    def beforeUpdate() {
        if (curp && curp.length() >= 4) {
            this.id = curp.substring(0, 4).toUpperCase()
        } else {
            throw new IllegalStateException("CURP must be at least 2 characters long")
        }
    }

    static marshaller = {
        return [
                id: it.id,
                firstName: it.firstName,
                lastName: it.lastName,
                curp: it.curp,
                position: it.position,
                manager: it.manager ? it.manager.id : null,
                subordinates: it.subordinates ? it.subordinates : null,
                address: [
                        state: it.address?.state,
                        city: it.address?.city
                ]
        ]
    }
}