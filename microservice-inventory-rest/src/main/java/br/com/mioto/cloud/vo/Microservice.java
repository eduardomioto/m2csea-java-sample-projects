package br.com.mioto.cloud.vo;

import java.util.Set;

/**
 * Created by mioto on 30/05/17.
 */
public class Microservice {

    private String name;

    private String version;

    private Set<Microservice> dependencies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Set<Microservice> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<Microservice> dependencies) {
        this.dependencies = dependencies;
    }
}
