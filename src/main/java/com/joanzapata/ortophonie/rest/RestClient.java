
package com.joanzapata.ortophonie.rest;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.StringHttpMessageConverter;

@Rest(rootUrl = "http://speech-therapy-webapp.herokuapp.com", converters = StringHttpMessageConverter.class)
public interface RestClient {

    @Get("/activities")
    void getActivities();

}
