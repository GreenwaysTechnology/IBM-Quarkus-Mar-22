package org.acme.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

//mapper class for incoming response
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Serializable {
    public List<String> capital;
}
