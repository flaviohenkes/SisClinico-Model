
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "doutor")
public class Doutor extends Pessoa implements Serializable{
    @NotBlank(message = "O CRM deve ser informado")
    @Length(max = 10,message = "O CRM não deve ter mais que {max} caracteres")
    @Column(name = "crm", length = 10, nullable = false)      
    private String crm;
    
    @Email(message = "O email deve ser válido")
    @NotBlank(message = "O Email deve ser informado")
    @Length(max = 50,message = "O Email não deve ter mais de {max} caracteres")
    @Column(name = "email", length = 50, nullable = false, unique = true)         
    private String email;
    
    @NotBlank(message = "O telefone deve ser informado")
    @Length(max = 14,message = "O telefone não deve ter mais de {max} caracteres")
    @Column(name = "telefoneEmergencia", length = 14, nullable = false)      
    private String telefoneEmergencia;
    
    @NotBlank(message = "O campo especialidade deve ser informado")
    @Length(max = 50,message = "O campo especialidade não deve ter mais que{max} caracteres")
    @Column(name = "especialidade", length = 50, nullable = false)      
    private String especialidade;
    
    @NotBlank(message = "O cargo deve ser informado")
    @Length(max = 20,message = "O cargo não deve ter mais que{max} caracteres")
    @Column(name = "cargo", length = 20, nullable = false)      
    private String cargo;
    
    @ManyToMany
    @JoinTable(name = "exame_doutor",
            joinColumns = 
            @JoinColumn(name = "doutor", referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "exame", referencedColumnName = "id"))
    private List<Exame> exames_doutor = new ArrayList<>();

    public Doutor() {
    }

   public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneEmergencia() {
        return telefoneEmergencia;
    }

    public void setTelefoneEmergencia(String telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Exame> getExames_doutor() {
        return exames_doutor;
    }

    public void setExames_doutor(List<Exame> exames_doutor) {
        this.exames_doutor = exames_doutor;
    }

}
