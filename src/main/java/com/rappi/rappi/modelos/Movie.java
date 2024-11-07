package com.rappi.rappi.modelos;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node("Movie")
public class Movie {
    @Id
    private final String title;
    @Property("tagline")
    private final String description;
    @Relationship(type = "ACTED_IN", direction = INCOMING)
    private Set<Person> actors = new HashSet<>();
    @Relationship(type = "DIRECTED", direction = INCOMING)
    private Set<Person> directors = new HashSet<>();
    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "title='" + title+", description='" + description+", actors=" + actors +", directors=" + directors;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<Person> getActors() {
        return actors;
    }

    public void setActors(Set<Person> actors) {
        this.actors = actors;
    }

    public Set<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Person> directors) {
        this.directors = directors;
    }
}