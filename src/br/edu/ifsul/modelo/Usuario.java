
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Pessoa implements Serializable {    
    @NotBlank(message = "O nome de usuário deve ser informado")
    @Length(max = 15,message = "O nome de usuário não deve ter mais de {max} caracteres")
    @Column(name = "nome_usuario", length = 15, nullable = false)    
    private String nome_usuario;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPrimeiroAcesso")
    private Calendar dataPrimeiroAcesso;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataUltimoAcesso")
    private Calendar dataUltimoAcesso;
    
    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 20,message = "A senha não deve ter mais de {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)       
    private String senha;
    
    //@NotBlank(message = "A permissao deve ser informada")
    //@Length(max = 1,message = "A permissao não deve ter mais de {max} caracteres")
    //@Column(name = "permissao", length = 1, nullable = false)      
    //private String permissao;
    
    @NotNull(message = "O tipo de usuário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "tipo_usuario", referencedColumnName = "id", nullable = false)    
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public Calendar getDataPrimeiroAcesso() {
        return dataPrimeiroAcesso;
    }

    public void setDataPrimeiroAcesso(Calendar dataPrimeiroAcesso) {
        this.dataPrimeiroAcesso = dataPrimeiroAcesso;
    }

    public Calendar getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Calendar dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
