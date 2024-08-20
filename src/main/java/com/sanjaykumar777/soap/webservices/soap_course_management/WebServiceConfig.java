package com.sanjaykumar777.soap.webservices.soap_course_management;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

//Enable Spring Web services
@EnableWs
//Spring configuration
@Configuration
public class WebServiceConfig {

    /*
    MessageDispatcherServlet- used by SOAP messages to
    figure out which controllers the web service request
    to be sent to
     */
    //ApplicationContext
    //url -> /ws/*
    @Bean
    ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
    }
}
