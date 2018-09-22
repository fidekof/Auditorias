package mva.api.taller.bodega.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class UtilsTransform
{
    String toJson(ArrayList<Object> listaBodegas) {
        String resultJson = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            resultJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listaBodegas);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultJson;
    }
}
