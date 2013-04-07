package com.jzap.ortophonie.rest;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;
import com.jzap.ortophonie.model.TherapyActivity.TherapyActivityList;

@Rest(rootUrl = "http://speech-therapy-webapp.herokuapp.com", converters = { MappingJacksonHttpMessageConverter.class })
public interface RestClient {

	@Get("/activities")
	public abstract TherapyActivityList getActivities();

}
