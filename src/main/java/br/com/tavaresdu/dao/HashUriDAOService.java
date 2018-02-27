package br.com.tavaresdu.dao;

import br.com.tavaresdu.dao.HashUriDAO;
import br.com.tavaresdu.model.HashUri;

import java.util.List;

public class HashUriDAOService {
    private static HashUriDAO hashUriDAO;

    public HashUriDAOService() {
        hashUriDAO = new HashUriDAO();
    }

    public void persist(HashUri hashuri) {
        hashUriDAO.openCurrentSessionwithTransaction();
        hashUriDAO.persist(hashuri);
        hashUriDAO.closeCurrentSessionwithTransaction();
    }

    public void update(HashUri hashuri) {
        hashUriDAO.openCurrentSessionwithTransaction();
        hashUriDAO.update(hashuri);
        hashUriDAO.closeCurrentSessionwithTransaction();
    }

    public HashUri findById(int id) {
        hashUriDAO.openCurrentSession();
        HashUri hashuri = hashUriDAO.findById(id);
        hashUriDAO.closeCurrentSession();
        return hashuri;
    }

    public void delete(int id) {
        hashUriDAO.openCurrentSessionwithTransaction();
        HashUri hashuri = hashUriDAO.findById(id);
        hashUriDAO.delete(hashuri);
        hashUriDAO.closeCurrentSessionwithTransaction();
    }

    public List<HashUri> findAll() {
        hashUriDAO.openCurrentSession();
        List<HashUri> hashUris = hashUriDAO.findAll();
        hashUriDAO.closeCurrentSession();
        return hashUris;
    }

    public HashUriDAO hashUriDAO() {
        return hashUriDAO;
    }
}
