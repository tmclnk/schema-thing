package com.example.schemathing;

import com.example.schemathing.pojo.Versioned;
import com.example.schemathing.pojo.v1.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.jimblackler.jsonschemafriend.GenerationException;
import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.ValidationException;
import net.jimblackler.jsonschemafriend.Validator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.Validation;
import java.io.IOException;
import java.nio.file.Paths;

public class SchemaThingApplication {

    public static void main(String[] args) throws Exception {
//        extracted();

        ObjectMapper m = new ObjectMapper();
        var p = m.readValue(Paths.get("data/person0.json").toFile(), Versioned.class);
        System.out.println(p.version);

//        var factory = Validation.buildDefaultValidatorFactory();
//        var validator= factory.getValidator();
//
//
//        var person = new Person();
////        person.firstName = "alice";
//
//        try {
//            var violations = validator.validate(person);
//            violations.forEach(v-> {
//                System.out.println(v.getMessage());
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private static void extracted() throws GenerationException, ValidationException, IOException {
        var schemaStore = new SchemaStore(); // Initialize a SchemaStore.
        var schema = schemaStore.loadSchema(Paths.get("schemas/schema.v1.json").toUri());
        var validator = new Validator(); // Create a validator.
        validator.validate(schema, Paths.get(System.getProperty("user.dir"), "data", "person0.json").toUri());
    }

}
