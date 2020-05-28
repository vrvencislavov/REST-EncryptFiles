package com.axway.hashing.project.beans;


import javax.persistence.*;

@Entity
@Table(name = "db")
public class DbFile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "path")
    private String path;

    @Column(name = "algorithm")
    private String algorithm;

    @Column(name = "hesh")
    private String hesh;

    public DbFile(String path, String algorithm, String hesh) {
        this.path = path;
        this.algorithm = algorithm;
        this.hesh = hesh;
    }

    public DbFile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getHesh() {
        return hesh;
    }

    public void setHesh(String hesh) {
        this.hesh = hesh;
    }
}
