
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Flávio
 */
@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_tipo_usuario", 
            sequenceName = "seq_tipo_usuario_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_tipo_usuario", 
            strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotBlank(message = "A permissao deve ser informada")
    @Length(max = 30, message = "A permissao não pode ter mais de {max} caracteres")
    @Column(name = "permissao", length = 30, nullable = false)    
    private String permissao;

    public TipoUsuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final TipoUsuario other = (TipoUsuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return permissao;
    }

}
