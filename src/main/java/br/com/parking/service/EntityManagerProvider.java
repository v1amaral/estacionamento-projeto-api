package br.com.parking.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("estacionamentoEstudo");
    private static EntityManager em = FACTORY.createEntityManager();

    public static EntityManager getEm() {
        return em;
    }
}
