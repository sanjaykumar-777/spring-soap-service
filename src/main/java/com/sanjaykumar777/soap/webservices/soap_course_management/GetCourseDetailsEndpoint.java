package com.sanjaykumar777.soap.webservices.soap_course_management;

import com.sanjaykumar777.courses.CourseDetails;
import com.sanjaykumar777.courses.GetCourseDetailsRequest;
import com.sanjaykumar777.courses.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GetCourseDetailsEndpoint {

    //method
    //input - GetCourseDetailsRequest
    //output - GetCourseDetailsResponse

    //namespace - http://sanjaykumar777.com/courses
    //GetCourseDetailsRequest
    @PayloadRoot(namespace = "http://sanjaykumar777.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request){
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("MicroServices courses");
        courseDetails.setDescription("Master microservices through this course");
        response.setCourseDetails(courseDetails);
        return  response;
    }

}
