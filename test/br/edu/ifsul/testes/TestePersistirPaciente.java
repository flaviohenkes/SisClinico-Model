package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Paciente;
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
public class TestePersistirPaciente {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPaciente() {
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
            Paciente p = new Paciente();
            
            Exame e = em.find(Exame.class, 1);
            p.getExames().add(e);
            p.setCpfPaciente("732.112.166-69");
            p.setNome("João");
            p.setSobrenome("da Silva");
            p.setSexo("M");
            p.setDataNasc(new GregorianCalendar(1989, Calendar.OCTOBER,20));
            p.setEndereco("Rua das Oliveiras");
            p.setTelefone("(54)8798-9876");    
            p.setTipoSanguineo("B+");
            p.setDataBaixa(new GregorianCalendar(2015, Calendar.OCTOBER,15));
            p.setDataAlta(new GregorianCalendar(2015, Calendar.NOVEMBER,5));
            p.setPrescricao("Repouso absoluto");
            p.setCidade(em.find(Cidade.class, 1));
            p.setDoenca("Hipertensão");
            
            em.getTransaction().begin();
            em.persist(p);
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
