
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "unidade_condominial")
public class UnidadeCondominial implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_u_condominial", sequenceName = "seq_u_condominial_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_u_condominial", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O número não pode ser nulo")
    @NotBlank(message = "O número não pode ser em branco")
    @Length(max = 10, message = "O número não pode ter mais de {max} caracteres")
    @Column(name = "numero", length = 10, nullable = false) 
    private String numero;
    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", columnDefinition = "text") 
    private String descricao;
    @NotNull(message = "A area deve ser informada")
    @Column(name = "area", nullable = false, columnDefinition = ("decimal(10,2)"))
    private Double area;
    @NotNull(message = "O numero do quarto deve ser informado")
    @Column(name = "numeroQuarto", nullable = false, columnDefinition = ("integer"))
    private Integer numeroQuarto;
    @ManyToMany
    @JoinTable(name = "proprietario",
            joinColumns = 
            @JoinColumn(name = "unidade_condominial", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false), 
            uniqueConstraints = {@UniqueConstraint(columnNames = {"unidade_condominial", "pessoa"})})
    private List<Pessoa> prorietario = new ArrayList<>();
    @NotNull(message = "O condominio deve ser informado")
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_unidadeCondominial_condominio")
    private Condominio condominio;
    
    public UnidadeCondominial() {
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
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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

    /**
     * @return the area
     */
    public Double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * @return the numeroQuarto
     */
    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    /**
     * @param numeroQuarto the numeroQuarto to set
     */
    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final UnidadeCondominial other = (UnidadeCondominial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the prorietario
     */
    public List<Pessoa> getProrietario() {
        return prorietario;
    }

    /**
     * @param prorietario the prorietario to set
     */
    public void setProrietario(List<Pessoa> prorietario) {
        this.prorietario = prorietario;
    }

    /**
     * @return the condominio
     */
    public Condominio getCondominio() {
        return condominio;
    }

    /**
     * @param condominio the condominio to set
     */
    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
    
}
