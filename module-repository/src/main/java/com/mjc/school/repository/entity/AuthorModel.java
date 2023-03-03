package com.mjc.school.repository.entity;

import java.util.Objects;

public class AuthorModel {
    private long id;
    private String name;

    public AuthorModel() {
    }

    public AuthorModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorModel(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorModel authorModel = (AuthorModel) o;
        return id == authorModel.id && name.equals(authorModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name;
    }
}
