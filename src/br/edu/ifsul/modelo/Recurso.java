
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "recurso")
public class Recurso implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A descrição não pode ser nulo")
    @Length(max = 50, message = "A descrição não pode ter mais que {max} caracteres")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", nullable = false, length = 50) 
    private String descricao;
    @ManyToMany
    @JoinTable(name = "rec_con",
            joinColumns = @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"recurso", "condominio"})})
     private List<Condominio> condominios = new ArrayList<>();

    public Recurso() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Recurso other = (Recurso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the condominios
     */
    public List<Condominio> getCondominios() {
        return condominios;
    }

    /**
     * @param condominios the condominios to set
     */
    public void setCondominios(List<Condominio> condominios) {
        this.condominios = condominios;
    }
    
    
}
