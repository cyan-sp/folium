//@version 1.0.0
//@author Elisa Adriana Aguilar Gudiño
//@lastUpdate 21/03/2025
package com.ord.folium

import grails.util.Holders
import org.slf4j.Logger
import org.slf4j.LoggerFactory

public class Log {
    private static grailsApplication = Holders.grailsApplication
    private final static String app = grailsApplication.config.appName
    private static Logger log = LoggerFactory.getLogger(Log)
    public static String TRACE = "TRACE" // Información muy detallada, útil para depuración profunda.
    public static String DEBUG = "DEBUG" // Información de depuración, útil durante el desarrollo.
    public static String INFO = "INFO" // Información general sobre el funcionamiento de la aplicación.
    public static String WARN = "WARN" // Advertencias sobre situaciones inesperadas, pero que no impiden el funcionamiento.
    public static String ERROR = "ERROR" // Errores que han ocurrido y que pueden afectar el funcionamiento.

    public static logger(logLevel, logId, process, description, info = null, res = null) {
        def logInfo = "${new Date().log()} | $logId | $app | $process | $description"
        if (info) logInfo += " | $info"
        if (res) logInfo += " | $res"
        log."${logLevel.toLowerCase()}"(logInfo)
    }
}