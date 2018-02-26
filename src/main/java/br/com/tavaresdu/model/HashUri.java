package br.com.tavaresdu.model;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="hash_uri")
public class HashUri {

    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition="varchar(8)")
    private String hash;
    @Column(columnDefinition="text")
    private String uri;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    private Calendar createdAt;

    public HashUri() {
    }

    public HashUri(String uri) {
        this.uri = uri;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Calendar getCreatedAt() {
        return this.createdAt;
    }
}
