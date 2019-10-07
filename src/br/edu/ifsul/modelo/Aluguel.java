
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name = "aluguel")
public class Aluguel implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = ("decimal(10,2)"))
    private Double valor;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "inicioContrato", nullable = false)
    private Calendar inicioContrato;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "fimContrato", nullable = false)
    private Calendar fimContrato;
    @NotNull(message = "O dia do vencimento deve ser informado")
    @Column(name = "diaVencimento", nullable = false, columnDefinition = ("integer"))
    private Integer diaVencimento;
    @NotNull(message = "O locatario deve ser informado")
    @ManyToOne
    @JoinColumn(name = "locatario", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_aluguel_locatario")
    private Locatario locatario;
    @NotNull(message = "A unidade condomicional deve ser informada")
    @ManyToOne
    @JoinColumn(name = "unidade_condominial", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_aluguel_unidadeCondominial")
    private UnidadeCondominial uc;
    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Mensalidades> mensalidades = new ArrayList<>();

    public Aluguel() {
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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the inicioContrato
     */
    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    /**
     * @param inicioContrato the inicioContrato to set
     */
    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    /**
     * @return the fimContrato
     */
    public Calendar getFimContrato() {
        return fimContrato;
    }

    /**
     * @param fimContrato the fimContrato to set
     */
    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    /**
     * @return the diaVencimento
     */
    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    /**
     * @param diaVencimento the diaVencimento to set
     */
    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the locatario
     */
    public Locatario getLocatario() {
        return locatario;
    }

    /**
     * @param locatario the locatario to set
     */
    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    /**
     * @return the uc
     */
    public UnidadeCondominial getUc() {
        return uc;
    }

    /**
     * @param uc the uc to set
     */
    public void setUc(UnidadeCondominial uc) {
        this.uc = uc;
    }

    /**
     * @return the mensalidades
     */
    public List<Mensalidades> getMensalidades() {
        return mensalidades;
    }

    /**
     * @param mensalidades the mensalidades to set
     */
    public void setMensalidades(List<Mensalidades> mensalidades) {
        this.mensalidades = mensalidades;
    }
    
}
