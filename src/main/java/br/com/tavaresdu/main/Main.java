package br.com.tavaresdu.main;

import br.com.tavaresdu.dao.HashUriDAO;
import br.com.tavaresdu.model.HashUri;
import br.com.tavaresdu.service.HashUriService;
import org.hashids.Hashids;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        HashUri hashUri = new HashUri("http://facebook.com/");

        HashUriService service = new HashUriService();
        service.persist(hashUri);
        Hashids hashid = new Hashids(hashUri.getUri(), 2);
        hashUri.setHash(hashid.encode(hashUri.getId()));

        System.out.println("ID: " + hashUri.getId());
        System.out.println("URI: " + hashUri.getUri());
        System.out.println("Hash: " + hashUri.getHash());
        System.out.println("Date:" + hashUri.getCreatedAt().get(Calendar.MINUTE));
    }
}
