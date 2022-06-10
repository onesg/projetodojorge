package br.com.projetodojorge.projetodojorge.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "paciente")
public class PacienteModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPaciente;

    @Column(name = "nome_paciente", nullable = false, length = 64)
    private String nomePaciente;

    @Column(name = "nascimento_paciente", nullable = false)
    private Date nascimentoPaciente;

    @Column(name = "telefone_paciente", nullable = true, length = 11)
    private String telefonePaciente;

//    @ManyToOne
//    private MedicoModel medicoModel;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private MedicoModel medicoModel;

    public PacienteModel() {
    }

    public PacienteModel(long idPaciente, String nomePaciente, Date nascimentoPaciente, String telefonePaciente, MedicoModel medicoModel) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.nascimentoPaciente = nascimentoPaciente;
        this.telefonePaciente = telefonePaciente;
        this.medicoModel = medicoModel;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public Date getNascimentoPaciente() {
        return nascimentoPaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public MedicoModel getMedicoModel() {
        return medicoModel;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setNascimentoPaciente(Date nascimentoPaciente) {
        this.nascimentoPaciente = nascimentoPaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public void setMedicoModel(MedicoModel medicoModel) {
        this.medicoModel = medicoModel;
    }

}
