package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.TipoUsuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirTipoUsuario {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirTipoUsuario() {
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
            TipoUsuario t1 = new TipoUsuario();
            t1.setPermissao("Administrador");
            TipoUsuario t2 = new TipoUsuario();
            t2.setPermissao("Funcionário");
            em.getTransaction().begin();
            em.persist(t1);
            em.persist(t2);
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
