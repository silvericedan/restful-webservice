package com.silvericedan.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DinamicFilteringController {

  @GetMapping("/d-filtering")
  public MappingJacksonValue dFiltering(){
    DinaBean dinaBean = new DinaBean("value4", "value5", "value6");

    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dinaBean);
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
    FilterProvider filters = new SimpleFilterProvider().addFilter("DinaBeanFilter",filter);
    mappingJacksonValue.setFilters(filters);
    
    return mappingJacksonValue;
  }

  @GetMapping("/d-filtering-list")
  public MappingJacksonValue dFilteringList(){
    List<DinaBean> dinaBeans = Arrays.asList(new DinaBean("value4", "value5", "value6"),
        new DinaBean("value7", "value8", "value9"));

    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dinaBeans);
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
    FilterProvider filters = new SimpleFilterProvider().addFilter("DinaBeanFilter",filter);
    mappingJacksonValue.setFilters(filters);

    return mappingJacksonValue;
  }
}
