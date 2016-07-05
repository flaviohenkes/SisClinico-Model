package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Doutor;
import br.edu.ifsul.modelo.Exame;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersistirExame {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirExame() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("SisClinico-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        // o teste não deve gerar exceção se tudo estiver correto
        boolean exception = false;
        try {
            Exame e = new Exame();
            Doutor d = em.find(Doutor.class, 1);
            e.getExame_doutor().add(d);
            e.setConvenio("SUS");
            e.setDataExame(new GregorianCalendar(2016, Calendar.MARCH, 10));
            e.setResultado("");
            e.setStatus("Em espera");
           
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        }catch (Exception e){
            // se gerar exceção 
            exception = true;
            e.printStackTrace();
        }
        // compara se não ocorreu erro
        Assert.assertEquals(false, exception);
    }
    
}
