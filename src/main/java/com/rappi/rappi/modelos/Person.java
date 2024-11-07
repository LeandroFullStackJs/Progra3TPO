package com.rappi.rappi.modelos;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Person")
public class Person {
    @Id
    private final String name;
    private final Integer born;
    public Person(Integer born, String name) {
        this.born = born;
        this.name = name;
    }

    @Override
    public String toString() {
        return  "name='" + name+", born=" + born;
    }

    public String getName() {
        return name;
    }

    public Integer getBorn() {
        return born;
    }
}