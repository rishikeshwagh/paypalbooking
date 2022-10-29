package com.paypal.bfs.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import org.jsonschema2pojo.AbstractAnnotator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class HibernateAnnotator extends AbstractAnnotator {

    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        super.propertyField(field, clazz, propertyName, propertyNode);

        if(propertyName.equals("id")){
            clazz.annotate(Entity.class);
            field.annotate(Id.class);
            field.annotate(GeneratedValue.class).param("strategy ",GenerationType.IDENTITY);
        }
        if(clazz.name().equals("Booking") && propertyName.equals("address")){
            field.annotate(OneToOne.class);
        }

    }
}
