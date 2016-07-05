package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_cidade", strategy = GenerationType.SEQUENCE)
    private Integer id;
    // anotações validação
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais de {max} caracteres")
    // anotações jpa
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    // anotações validação
    @NotNull(message = "O estado deve ser informado")

    @NotBlank(message = "O estado deve ser informado")
    @Length(max = 50, message = "O estado deve ter no máximo {max} caracteres")
    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @NotBlank(message = "A UF deve ser informada")
    @Length(max = 2, message = "A UF não deve ter no máximo {max} caracteres")
    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @NotBlank(message = "O país deve ser informado")
    @Length(max = 50, message = "O país deve ter no máximo {max} caracteres")
    @Column(name = "pais", length = 50, nullable = false)
    private String pais;

    public Cidade() {

    }

   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
