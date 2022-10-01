package com.example.schemathing.pojo.v1;

import javax.validation.constraints.NotNull;

public class Person {
    @NotNull(message = "firstName can't be null")
    public String firstName;
}
