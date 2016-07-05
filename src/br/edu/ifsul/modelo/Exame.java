
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Flávio
 */
@Entity
@Table(name = "exame")
@Inheritance(strategy = InheritanceType.JOINED)
public class Exame implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_exame", sequenceName = "seq_exame_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_exame", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    
    @NotNull(message = "A data do exame deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataExame", nullable = false)
    private Calendar dataExame;
    
//    @NotNull(message = "A hora do exame deve ser informada")
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "hora", nullable = false)
//    private Calendar hora;
    
    @NotBlank(message = "O convenio deve ser informado")
    @Length(max = 20,message = "O convenio não deve ter mais de {max} caracteres")
    @Column(name = "convenio", length = 20, nullable = false)      
    private String convenio;
    
    @Column(name = "resultado")      
    private String resultado;
    
    @NotBlank(message = "O status deve ser informado")
    @Length(max = 15,message = "O status não deve ter mais de {max} caracteres")
    @Column(name = "status", length = 15, nullable = false)      
    private String status;
    
    @ManyToMany
    @JoinTable(name = "exame_doutor",
            joinColumns = 
            @JoinColumn(name = "exame", referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "doutor", referencedColumnName = "id"))    
    private List<Doutor> exame_doutor = new ArrayList<>();
    
    @NotNull(message = "O paciente deve ser informada")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
//    
//    @NotNull(message = "A categoria deve ser informada")
//    @ManyToOne
//    @JoinColumn(name = "categoria", referencedColumnName = "id", nullable = false)
//    private Categoria categoria;

    public Exame() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
public Calendar getDataExame() {
        return dataExame;
    }

    public void setDataExame(Calendar dataExame) {
        this.dataExame = dataExame;
    }

//    public Calendar getHora() {
//        return hora;
//    }
//
//    public void setHora(Calendar hora) {
//        this.hora = hora;
//    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exame other = (Exame) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return status;
    }

    public List<Doutor> getExame_doutor() {
        return exame_doutor;
    }

    public void setExame_doutor(List<Doutor> exame_doutor) {
        this.exame_doutor = exame_doutor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
