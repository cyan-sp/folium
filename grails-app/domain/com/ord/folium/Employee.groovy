package com.ord.folium
//import ResponseError

class Employee {
    String id
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

    static String generateIdFromCurp(curp) {
        if (!curp || curp.length() < 4) {
            throw new IllegalStateException("CURP must be at least 4 characters long")
        }
        return curp.substring(0, 4).toUpperCase()
    }

    def beforeInsert() {
        this.id = generateIdFromCurp(curp)

    }

    def beforeUpdate() {
        this.id = generateIdFromCurp(curp)

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