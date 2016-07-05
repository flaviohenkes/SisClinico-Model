package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Categoria;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
public class TestePersistirEndereco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TA-2016-1-6M1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Categoria c = new Categoria();
        c.setNome("Mouses");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Categoria>> erros = validador.validate(c);
        if (erros.size() > 0) {
            for (ConstraintViolation<Categoria> erro : erros){
                System.out.println("Erro: "+erro.getMessage());
            }
        } else {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }

}
