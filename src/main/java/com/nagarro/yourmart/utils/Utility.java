package com.nagarro.yourmart.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.List;

/**
 * @author Sanyam Goel created on 29/10/18
 */
public class Utility {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static TypeFactory typeFactory = objectMapper.getTypeFactory();

    public static <T1> List<T1> convertModelList(List<? extends Object> sourceClass, Class<T1> destinationClass) {
        try {
            CollectionType collectionType = typeFactory.constructCollectionType(List.class, destinationClass);
            return objectMapper.convertValue(sourceClass, collectionType);
        } catch (Exception exp) {
            return null;
        }
    }
}