
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "locatario")
public class Locatario extends Pessoa implements Serializable{
    @NotNull(message = "A renda deve ser informada")
    @Column(name = "renda", nullable = false, columnDefinition = ("decimal(10,2)"))
    private Double renda;
    @NotNull(message = "O local de trabalho não pode ser nulo")
    @Length(max = 50, message = "O local de trabalho não pode ter mais que {max} caracteres")
    @NotBlank(message = "O local de trabalho não pode ser em branco")
    @Column(name = "localTrabalho", nullable = false, length = 50) 
    private String localTrabalho;
    @NotNull(message = "O telefone não pode ser nulo")
    @Length(max = 16, message = "O telefone não pode ter mais que {max} caracteres")
    @NotBlank(message = "O telefone não pode ser em branco")
    @Column(name = "telefoneTrabalho", nullable = false, length = 16) 
    private String telefoneTrabalho;

    public Locatario() {
    }

    
    /**
     * @return the renda
     */
    public Double getRenda() {
        return renda;
    }

    /**
     * @param renda the renda to set
     */
    public void setRenda(Double renda) {
        this.renda = renda;
    }

    /**
     * @return the localTrabalho
     */
    public String getLocalTrabalho() {
        return localTrabalho;
    }

    /**
     * @param localTrabalho the localTrabalho to set
     */
    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    /**
     * @return the telefoneTrabalho
     */
    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    /**
     * @param telefoneTrabalho the telefoneTrabalho to set
     */
    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }
    
    
}
