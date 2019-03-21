package dao;

import entity.Country;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CountryDao {

    @PersistenceContext
    EntityManager em;
    
    public void addCountry(Country c) {
        em.persist(c);
    }
    
    public void edit(Country c) {
        em.merge(c);
    }
    
    public List<Country> getAll() {
        return em.createQuery("SELECT c from Country c").getResultList();
    }
    
    public Country findById(Integer id) {
        return em.find(Country.class, id);
    }
    
    public void delete(Integer id) {
        em.remove(em.find(Country.class, id));
    } 
    
}
