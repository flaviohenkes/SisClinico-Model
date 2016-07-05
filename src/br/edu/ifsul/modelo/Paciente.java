
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Flávio
 */
@Entity
@Table(name = "paciente")
@PrimaryKeyJoinColumn(name="id")
public class Paciente extends Pessoa implements Serializable{
    @CPF(message = "O CPF deve ser válido")
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14,message = "O CPF não deve ter mais que {max} caracteres")
    @Column(name = "cpfPaciente", length = 14, nullable = false)      
    private String cpfPaciente;
    
    //@Past(message = "A data de admissao deve ser uma data no passado")
    @NotNull(message = "A data de baixa deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataBaixa", nullable = false)
    private Calendar dataBaixa;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataAlta", nullable = true)
    private Calendar dataAlta;
    
    @NotBlank(message = "O campo tipo sanguíneo deve ser informado")
    @Length(max = 3,message = "O campo tipo sanguíneo não deve ter mais que{max} caracteres")
    @Column(name = "tipoSanguíneo", length = 3, nullable = false)      
    private String tipoSanguineo;
   
    @Column(name = "prescricao")      
    private String prescricao;
    
    @Column(name = "doenca")      
    private String doenca;
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, 
            orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Exame> exames = new ArrayList<>();

    public Paciente() {
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public Calendar getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Calendar dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Calendar getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Calendar dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

}
