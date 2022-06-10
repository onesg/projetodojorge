package br.com.projetodojorge.projetodojorge.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medico")
public class MedicoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMedico;

    @Column(name = "nome_medico", nullable = false, length = 64)
    private String nomeMedico;

    @Column(name = "crm_medico", nullable = false, length = 9)
    private String crmMedico;

    @Column(name = "especialidade_medico", nullable = false, length = 64)
    private String especialidadeMedico;

    @Column(name = "telefone_medico", nullable = true, length = 11)
    private String telefoneMedico;

    public MedicoModel() {
    }

    public MedicoModel(long idMedico, String nomeMedico, String crmMedico, String especialidadeMedico, String telefoneMedico) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.crmMedico = crmMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.telefoneMedico = telefoneMedico;
    }

    public long getIdMedico() {
        return idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public String getTelefoneMedico() {
        return telefoneMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }

    public void setTelefoneMedico(String telefoneMedico) {
        this.telefoneMedico = telefoneMedico;
    }

}