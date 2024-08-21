package com.sanjaykumar777.soap.webservices.soap_course_management;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

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

    /*
    requirement 1 - Xsdschema
    requirement 2 - locationURI
    requirement 3 - porttype
    requirement 4 - targetnamespace
     */
    @Bean(name = "courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("CoursePort");
        definition.setSchema(coursesSchema);
        definition.setTargetNamespace("http://sanjaykumar777.com/courses");
        definition.setLocationUri("/ws");
        return definition;
    }
    @Bean
    public XsdSchema coursesSchema(){
        return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
    }
}
