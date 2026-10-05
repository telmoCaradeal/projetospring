package com.curso.projetospring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Id: " + id + ", não Localizado ");

    }
}
