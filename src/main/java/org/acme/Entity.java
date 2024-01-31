package org.acme;

import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(registerFullHierarchy = true)
public record Entity(String name, List<SubEntity> subEntities) {

}
