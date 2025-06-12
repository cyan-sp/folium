//@version 1.0.0
//@author Elisa Adriana Aguilar Gudiño
//@lastUpdate 21/03/2025
package com.ord.folium

import grails.util.Holders
import java.text.SimpleDateFormat
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Base64

public class Utils {
    private static grailsApplication = Holders.grailsApplication
    private final static String app = grailsApplication.config.appName

    public static logger(logId, process, description, info = null, res = null) {
        def log = "${new Date().log()} | $logId | $app | $process | $description"
        if (info) log += " | $info"
        if (res) log += " | $res"
        println log
    }

    public static Boolean validateAccessProject(uuidApp) {
        return uuidApp == grailsApplication.config.id
    }

}
