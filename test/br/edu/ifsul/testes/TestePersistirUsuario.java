package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.TipoUsuario;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistirUsuario {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirUsuario() {
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
            Usuario u = new Usuario();
            u.setNome("Maria");
            u.setSobrenome("Santos");
            u.setSexo("F");
            u.setDataNasc(new GregorianCalendar(1985, Calendar.JANUARY,8));
            u.setEndereco("Rua das Limeiras");
            u.setTelefone("(54)9887-7698"); 
            u.setCidade(em.find(Cidade.class, 1));
            u.setNome_usuario("maria");
            u.setSenha("123456");
            u.setDataPrimeiroAcesso(new GregorianCalendar(2014, Calendar.JUNE,10));
            u.setDataUltimoAcesso(Calendar.getInstance());
            u.setTipoUsuario(em.find(TipoUsuario.class, 1));
            
            em.getTransaction().begin();
            em.persist(u);
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
