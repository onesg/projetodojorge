package br.com.projetodojorge.projetodojorge.model;

public class Paciente {

    private long idPaciente;

    private String nomePaciente;

    private String nascimentoPaciente;

    private String telefonePaciente;

    public Paciente() {
    }

    public Paciente(long idPaciente, String nomePaciente, String nascimentoPaciente, String telefonePaciente) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.nascimentoPaciente = nascimentoPaciente;
        this.telefonePaciente = telefonePaciente;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNascimentoPaciente() {
        return nascimentoPaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setNascimentoPaciente(String nascimentoPaciente) {
        this.nascimentoPaciente = nascimentoPaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }
}
