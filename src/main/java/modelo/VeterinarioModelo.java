/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class VeterinarioModelo extends PersonaModelo {
    private int idVeterinario;
    private String numeroLicencia;
    private String especialidad;
    private String telefonoContacto;
    private String horarioAtencion;
    private int aniosExperiencia;
    private PersonaModelo idpersona;

    public VeterinarioModelo() {
    }

    public VeterinarioModelo(int idVeterinario, String numeroLicencia, String especialidad, String telefonoContacto, String horarioAtencion, int aniosExperiencia, PersonaModelo idpersona) {
        this.idVeterinario = idVeterinario;
        this.numeroLicencia = numeroLicencia;
        this.especialidad = especialidad;
        this.telefonoContacto = telefonoContacto;
        this.horarioAtencion = horarioAtencion;
        this.aniosExperiencia = aniosExperiencia;
        this.idpersona = idpersona;
    }

    public VeterinarioModelo(int idVeterinario, String numeroLicencia, String especialidad, String telefonoContacto, String horarioAtencion, int aniosExperiencia, PersonaModelo idpersona, int idPersonas, String nombres, String apellidos, String cedula, String direccion, String correoElectronico, String fechaNacimiento) {
        super(idPersonas, nombres, apellidos, cedula, direccion, correoElectronico, fechaNacimiento);
        this.idVeterinario = idVeterinario;
        this.numeroLicencia = numeroLicencia;
        this.especialidad = especialidad;
        this.telefonoContacto = telefonoContacto;
        this.horarioAtencion = horarioAtencion;
        this.aniosExperiencia = aniosExperiencia;
        this.idpersona = idpersona;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public PersonaModelo getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(PersonaModelo idpersona) {
        this.idpersona = idpersona;
    }

    @Override
    public String toString() {
        return "DATOS PERSONALES\n" +
                "ID Persona:" + getIdPersonas() + "\n" +
                "Nombres:" + getNombres() + "\n" +
                "Apellidos:" + getApellidos() + "\n" +
                "Cédula:" + getCedula() + "\n" +
                "Dirección:" + getDireccion() + "\n" +
                "Correo Electrónico:" + getCorreoElectronico() + "\n" +
                "Fecha de Nacimiento:" + getFechaNacimiento() + "\n" +
                "DATOS DEL VETERINARIO:\n" +
                "ID Veterinario:" + getIdVeterinario() + "\n" +
                "Número de Licencia:" + getNumeroLicencia() + "\n" +
                "Especialidad:" + getEspecialidad() + "\n" +
                "Teléfono de Contacto:" + getTelefonoContacto() + "\n" +
                "Horario de Atención:" + getHorarioAtencion() + "\n" +
                "Años de Experiencia:" + getAniosExperiencia() + "\n";
    }
}
