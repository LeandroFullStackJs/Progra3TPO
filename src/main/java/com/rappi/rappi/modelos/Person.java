package com.rappi.rappi.modelos;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Node("Person")
public class Person {
    @Id
    private final String name;
    private final Integer born;

    //@Relationship(type = "ACTED_IN", direction = OUTGOING)
   // private Set<Movie> movies = new HashSet<>();

    public Person(Integer born, String name) {
        this.born = born;
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + ", born=" + born;
    }

    public String getName() {
        return name;
    }

    public Integer getBorn() {
        return born;
    }

   // public Set<Movie> getMovies() {
   //     return movies;
   // }

   // public void setMovies(Set<Movie> movies) {
    //    this.movies = movies;
   // }
}