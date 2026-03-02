import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Interfaz grafica
 *
 * @version 3.3
 * @author John Ever - Jhoem mathias
 */
public class InterfazHospital {
    /**
     * Componentes
     */
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton agregarMedicoPanel;
    private JButton consultarMedicosPanel;
    private JButton agregarPacientePanel;
    private JButton asignarPrioridadPanel;
    private JPanel medico;
    private JPanel panelBotones;
    private JPanel panelMedicos;
    private JTextField campoNombreMedico;
    private JTextField campoDNImedico;
    private JTextField campoEdadMedico;
    private JTextField campoNumeroRegistroMedico;
    private JButton añadirMedicoButton;
    private JPanel panelFormularioMedico;
    private JButton volverPanelMedicos;
    private JTextField campoNumeroQuirofano;
    private JButton añadirCiruganoButton;
    private JComboBox listaGeneroMedico;
    private JPanel panelListaMedicos;
    private JList listaMedicos;
    private JButton volverPanelConsultaMedicos;
    private JComboBox listaEspecialidades;
    private JPanel panelAgregarPacientesMedico;
    private JComboBox listaNombresPacientesAsignacion;
    private JComboBox listaNombresMedicosAsignacion;
    private JButton agregarPacienteMedico;
    private JButton volverAgregarPacienteMedico;
    private JPanel panelPacientes;
    private JPanel panelBotonesPacientes;
    private JButton agregarPaciente;
    private JButton mostrarListaPacientes;
    private JPanel panelFormularioPacientes;
    private JTextField campoNombrePaciente;
    private JTextField campoDNIPaciente;
    private JTextField campoEdadPaciente;
    private JComboBox listaGeneroPaciente;
    private JTextField campoNumeroHistorial;
    private JComboBox listaEps;
    private JTextField campoSaldo;
    private JComboBox listaSintomas;
    private JButton agregarPacientes;
    private JButton volverPanelPacientes;
    private JComboBox listaPacientesPago;
    private JPanel panelListaPacientes;
    private JButton volverListaPacientes;
    private JList listaPanelPacientes;
    private JPanel panelListaPrioriades;
    private JComboBox listaMedicosPanelPrioridades;
    private JList listaPrioridades;
    private JButton asignarPrioridadesButton;
    private JButton volverPanelPrioridades;
    private JComboBox listaCiruganos;
    private JButton consultarQuirofanoButton;
    private JComboBox estadoQuirofano;
    private JComboBox listaPacientesAtencion;
    private JButton procesarIngresoButton;
    private JTextField campoCostoConsulta;
    private JButton verificarPresupuestoButton;

    /**
     * estado booleno para verificar si es medico o cirugano
     */
    private boolean esMedico = true;
    /**
     * Lista de medicos
     */
    ArrayList<Medico> medicos = new ArrayList<>();
    /**
     * Lista de ciruganos
     */
    ArrayList<MedicoCirugano> ciruganos = new ArrayList<>();

    /**
     * Lista pacientes
     */
    ArrayList<Paciente> pacientes = new ArrayList<>();

    public InterfazHospital() {
        /**
         * obtener el panel de medicos
         */
        CardLayout layoutPanelMedicos = (CardLayout) panelMedicos.getLayout();
        CardLayout layoutPanelPacientes = (CardLayout) panelPacientes.getLayout();
        /**
         * añadir los paneles correspondientes a cada boton del panel Medicos
         */
        panelMedicos.add(panelBotones, "panelBotones");
        panelMedicos.add(panelFormularioMedico, "panelFormularioMedico");
        panelMedicos.add(panelListaMedicos, "panelListaMedicos");
        panelMedicos.add(panelAgregarPacientesMedico, "panelAgregarPacientesMedico");
        panelMedicos.add(panelListaPrioriades, "panelListaPrioridades");
        /**
         * establecer panel ppal
         */
        layoutPanelMedicos.show(panelMedicos, "panelBotones");
        /**
         * añadir los paneles correspondientes a cada boton del panel Pacientes
         */
        panelPacientes.add(panelBotonesPacientes, "panelBotonesPacientes");
        panelPacientes.add(panelFormularioPacientes, "panelFormularioPacientes");
        panelPacientes.add(panelListaPacientes, "panelListaPacientes");
        layoutPanelPacientes.show(panelPacientes, "panelBotonesPacientes");
        /**
         * agregar las opciones de seleccion de genero en medicos
         */
        listaGeneroMedico.addItem("Masculino");
        listaGeneroMedico.addItem("Femenino");
        /**
         * agregar las opciones de seleccion de genero en pacientes
         */
        listaGeneroPaciente.addItem("Masculino");
        listaGeneroPaciente.addItem("Femenino");
        /**
         * Agregar opciones de especialidades
         */
        listaEspecialidades.addItem("Cardiologo");
        listaEspecialidades.addItem("Oncologo");
        listaEspecialidades.addItem("Pediatra");
        listaEspecialidades.addItem("Ginecologo");
        listaEspecialidades.addItem("Nutriologo");
        listaEspecialidades.addItem("Medico General");
        listaEspecialidades.addItem("Dermatologo");
        listaEspecialidades.addItem("Urologo");
        listaEspecialidades.addItem("Neurocirugano");
        /**
         * Agregar opciones a la lista de eps
         */
        listaEps.addItem("Sura");
        listaEps.addItem("Sanitas");
        listaEps.addItem("Nueva EPS");
        listaEps.addItem("Compensar");
        /**
         * Agregar opciones a lista de sintomas
         */
        listaSintomas.addItem("Fiebre");
        listaSintomas.addItem("Infarto");
        listaSintomas.addItem("Dolor");
        /**
         * lista estado quirofano
         */
        estadoQuirofano.addItem("Libre");
        estadoQuirofano.addItem("Ocupado");
        /**
         * Boton agregar medico
         *
         * muestra el panel que contiene el formulario para registrar al medico
         */
        agregarMedicoPanel.addActionListener(e -> {
            layoutPanelMedicos.show(panelMedicos, "panelFormularioMedico");
        });
        /**
         * Evento ppal para volver al menu de botones
         *
         * una vez en el panel del formulario se manda al panel ppal de medicos
         */
        ActionListener volverMenuMedicos = e -> {
            layoutPanelMedicos.show(panelMedicos, "panelBotones");
        };
        volverPanelMedicos.addActionListener(volverMenuMedicos);
        volverPanelConsultaMedicos.addActionListener(volverMenuMedicos);
        volverAgregarPacienteMedico.addActionListener(volverMenuMedicos);
        volverPanelPrioridades.addActionListener(volverMenuMedicos);
        /**
         * Evento volver a menu pacientes
         */
        ActionListener volverMenuPacientes = e -> {
            layoutPanelPacientes.show(panelPacientes, "panelBotonesPacientes");
        };
        volverPanelPacientes.addActionListener(volverMenuPacientes);
        volverListaPacientes.addActionListener(volverMenuPacientes);
        añadirMedicoButton.addActionListener(e -> {
            esMedico = true;
            agregarMedico();
        });
        añadirCiruganoButton.addActionListener(e -> {
            esMedico = false;
            agregarMedico();
        });
        consultarMedicosPanel.addActionListener(e -> {
            layoutPanelMedicos.show(panelMedicos, "panelListaMedicos");
            cargarListaMedicos();
        });
        agregarPacientePanel.addActionListener(e -> {
            layoutPanelMedicos.show(panelMedicos, "panelAgregarPacientesMedico");
        });

        agregarPaciente.addActionListener(e -> {
            layoutPanelPacientes.show(panelPacientes, "panelFormularioPacientes");
        });

        agregarPacientes.addActionListener(e -> {
            boolean datosValidos = true;
            String nombre = campoNombrePaciente.getText();
            String documentoPaciente = campoDNIPaciente.getText();
            if (documentoPaciente.length() < 7) {
                JOptionPane.showMessageDialog(null, "La longitud del documento debe ser mayor a 7 digitos");
                datosValidos = false;
            }
            int edad = 0;
            try {
                edad = Integer.parseInt(campoEdadPaciente.getText());
                if (edad < 18) {
                    JOptionPane.showMessageDialog(null, "La edad debe ser mayor a 18");
                    datosValidos = false;
                }
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Ingrese numeros en vez de letras");
            }
            String genero = (String) listaGeneroPaciente.getSelectedItem();
            int numeroHistorial = 0;
            try {
                numeroHistorial = Integer.parseInt(campoNumeroHistorial.getText());
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Ingrese numeros en vez de letras");
            }
            String eps = (String) listaEps.getSelectedItem();
            double saldoDisponible = 0;
            try {
                saldoDisponible = Double.parseDouble(campoSaldo.getText());
                if (saldoDisponible <= 0) {
                    JOptionPane.showMessageDialog(null, "El saldo debe ser mayor a 0");
                }
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Ingrese numeros en vez de texto");
            }
            String sintoma = (String) listaSintomas.getSelectedItem();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No deje campos vacios");
            }
            if (datosValidos) {
                Paciente paciente = new Paciente(nombre, documentoPaciente, edad, genero, numeroHistorial, eps, saldoDisponible, sintoma);
                pacientes.add(paciente);
                listaNombresPacientesAsignacion.addItem(nombre);
                listaPacientesAtencion.addItem(nombre);
                listaPacientesPago.addItem(nombre);
                JOptionPane.showMessageDialog(null, "Se ha ingresado el paciente " + nombre + " de forma correcta");
                limpiarCamposPaciente();
            }
        });

        mostrarListaPacientes.addActionListener(e -> {
            layoutPanelPacientes.show(panelPacientes, "panelListaPacientes");
            cargarListaPacientes();
        });

        agregarPacienteMedico.addActionListener(e -> {
            String paciente = (String) listaNombresPacientesAsignacion.getSelectedItem();
            String medico = (String) listaNombresMedicosAsignacion.getSelectedItem();

            if (paciente != null && medico != null) {
                for (Medico medicoLista : medicos) {
                    for (Paciente pacienteLista : pacientes) {
                        if (pacienteLista.nombre.equals(paciente) && medico.contains(medicoLista.nombre)) {
                            medicoLista.asignarPaciente(pacienteLista);
                            listaNombresPacientesAsignacion.removeItem(paciente);
                            JOptionPane.showMessageDialog(null, "Se ha asignado de forma correcta");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor no ingrese valores vacios");
            }
        });

        asignarPrioridadPanel.addActionListener(e -> {
            layoutPanelMedicos.show(panelMedicos, "panelListaPrioridades");
        });

        asignarPrioridadesButton.addActionListener(e -> {
            String nombreMedico = (String) listaMedicosPanelPrioridades.getSelectedItem();
            if (nombreMedico != null) {
                DefaultListModel<String> lista = new DefaultListModel<>();
                for (Medico medico : medicos) {
                    if (medico.nombre == nombreMedico) {
                        medico.asignarPrioridad();
                        ;
                        lista.addElement("Prioridad asignada");
                        listaPrioridades.setModel(lista);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No ingrese valores vacios");
            }
        });

        consultarQuirofanoButton.addActionListener(e -> {
            String estado = (String) estadoQuirofano.getSelectedItem();
            boolean estadoQuirofano;
            if (estado.equals("Libre")) {
                estadoQuirofano = true;
            } else {
                estadoQuirofano = false;
            }
            String nombreCirugano = (String) listaCiruganos.getSelectedItem();
            for (MedicoCirugano cirugano : ciruganos) {
                if (cirugano.nombre.equals(nombreCirugano)) {
                    JOptionPane.showMessageDialog(null, cirugano.validarQuirofano(estadoQuirofano));
                }
            }
        });

        procesarIngresoButton.addActionListener(e -> {
            String nombrePaciente = (String) listaPacientesAtencion.getSelectedItem();
            Atencion atencion = new Atencion();
            for (Paciente paciente : pacientes) {
                if (paciente.nombre.equals(nombrePaciente)) {
                    JOptionPane.showMessageDialog(null, atencion.procesarIngreso(paciente));
                }
            }
        });

        verificarPresupuestoButton.addActionListener(e -> {
            String nombrePaciente = (String) listaPacientesPago.getSelectedItem();
            int saldo = 0;
            try {
                saldo = Integer.parseInt(campoCostoConsulta.getText());
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Ingrese numeros, no letras");
            }
            for (Paciente paciente : pacientes) {
                if (paciente.nombre.equals(nombrePaciente)) {
                    JOptionPane.showMessageDialog(null, paciente.verificarPresupuesto(saldo));
                }
            }
        });

    }

    /**
     * Metodo para actualizar la lista de los medicos y ciruganos
     */
    public void cargarListaMedicos() {
        DefaultListModel<String> lista = new DefaultListModel<>();
        if (!medicos.isEmpty()) {
            lista.addElement("Lista de medicos\n");
        } else {
            lista.addElement("No hay medicos disponibles");
        }
        for (Medico medico : medicos) {
            lista.addElement(medico.presentacion());
        }
        if (!ciruganos.isEmpty()) {
            lista.addElement("Lista de ciruganos\n");
        } else {
            lista.addElement("No hay ciruganos disponibles");
        }
        for (Medico medico : ciruganos) {
            lista.addElement(medico.presentacion());
        }
        listaMedicos.setModel(lista);
    }

    public void cargarListaPacientes() {
        DefaultListModel<String> lista = new DefaultListModel<>();
        if (!pacientes.isEmpty()) {
            lista.addElement("Lista de pacientes\n");
        } else {
            lista.addElement("No hay pacientes");
        }
        for (Paciente paciente : pacientes) {
            lista.addElement(paciente.presentacion());
        }
        listaPanelPacientes.setModel(lista);
    }

    /**
     * Metodo para agregar medicos
     */
    public void agregarMedico() {
        boolean datosValidos = true;
        String nombreMedico = campoNombreMedico.getText();
        String documentoMedico = campoDNImedico.getText();
        if (documentoMedico.length() < 7) {
            JOptionPane.showMessageDialog(null, "La longitud del documento debe ser mayor a 7 digitos");
            datosValidos = false;
        }
        int edadMedico = 0;
        try {
            edadMedico = Integer.parseInt(campoEdadMedico.getText());
            if (edadMedico < 18) {
                JOptionPane.showMessageDialog(null, "La edad debe ser mayor a 18");
                datosValidos = false;
            }
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "La edad debe ser un numero");
            datosValidos = false;
        }
        String generoMedico = (String) listaGeneroMedico.getSelectedItem();
        String especialidad = (String) listaEspecialidades.getSelectedItem();
        String numeroRegistro = campoNumeroRegistroMedico.getText();
        int numeroQuirofanoCirugano = 0;
        if (!esMedico) {
            try {
                numeroQuirofanoCirugano = Integer.parseInt(campoNumeroQuirofano.getText());
                if (numeroQuirofanoCirugano <= 0) {
                    datosValidos = false;
                    JOptionPane.showMessageDialog(null, "El numero de quirofano debe ser mayor a 0");
                }
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "El numero de quirofano debe de ser un numero");
                datosValidos = false;
            }
        }
        if (nombreMedico.isEmpty() || documentoMedico.isEmpty() || generoMedico.isEmpty() || numeroRegistro.isEmpty()) {
            datosValidos = false;
            JOptionPane.showMessageDialog(null, "No deje campos vacios");
        }
        if (datosValidos) {
            if (esMedico) {
                Medico medico = new Medico(nombreMedico, documentoMedico, edadMedico, generoMedico, especialidad, numeroRegistro);
                medicos.add(medico);
                listaNombresMedicosAsignacion.addItem(nombreMedico + " [" + especialidad + "]");
                listaMedicosPanelPrioridades.addItem(nombreMedico);
                JOptionPane.showMessageDialog(null, "Medico " + nombreMedico + " añadido correctamente");
                limpiarCamposMedico();
            } else {
                MedicoCirugano cirugano = new MedicoCirugano(nombreMedico, documentoMedico, edadMedico, generoMedico, especialidad, numeroRegistro, numeroQuirofanoCirugano);
                ciruganos.add(cirugano);
                listaNombresMedicosAsignacion.addItem(nombreMedico + "[" + especialidad + "]");
                listaMedicosPanelPrioridades.addItem(nombreMedico);
                listaCiruganos.addItem(nombreMedico);
                JOptionPane.showMessageDialog(null, "Cirugano " + nombreMedico + " añadido correctamente");
                limpiarCamposMedico();
            }
        }
    }

    public void limpiarCamposMedico() {
        campoNombreMedico.setText("");
        campoDNImedico.setText("");
        campoEdadMedico.setText("");
        campoNumeroRegistroMedico.setText("");
        campoNumeroQuirofano.setText("");
    }

    public void limpiarCamposPaciente() {
        campoNombrePaciente.setText("");
        campoDNIPaciente.setText("");
        campoEdadPaciente.setText("");
        campoNumeroHistorial.setText("");
        campoSaldo.setText("");
    }

    /**
     * ejecutador main
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("InterfazHospital");
        frame.setContentPane(new InterfazHospital().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(900, 600);
        frame.setResizable(false);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-1));
        tabbedPane1 = new JTabbedPane();
        panel1.add(tabbedPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        medico = new JPanel();
        medico.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        medico.setBackground(new Color(-15787726));
        medico.setForeground(new Color(-15787726));
        tabbedPane1.addTab("Medicos", medico);
        panelMedicos = new JPanel();
        panelMedicos.setLayout(new CardLayout(0, 0));
        medico.add(panelMedicos, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panelBotones = new JPanel();
        panelBotones.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelBotones.setBackground(new Color(-15787726));
        panelMedicos.add(panelBotones, "Card1");
        agregarMedicoPanel = new JButton();
        agregarMedicoPanel.setBackground(new Color(-4944836));
        agregarMedicoPanel.setFocusPainted(false);
        agregarMedicoPanel.setFocusable(false);
        Font agregarMedicoPanelFont = this.$$$getFont$$$("Consolas", -1, 20, agregarMedicoPanel.getFont());
        if (agregarMedicoPanelFont != null) agregarMedicoPanel.setFont(agregarMedicoPanelFont);
        agregarMedicoPanel.setForeground(new Color(-16777216));
        agregarMedicoPanel.setMargin(new Insets(0, 0, 0, 0));
        agregarMedicoPanel.setOpaque(true);
        agregarMedicoPanel.setRequestFocusEnabled(true);
        agregarMedicoPanel.setRolloverEnabled(true);
        agregarMedicoPanel.setText("Agregar Medicos");
        panelBotones.add(agregarMedicoPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 65), new Dimension(400, 65), 0, false));
        consultarMedicosPanel = new JButton();
        consultarMedicosPanel.setBackground(new Color(-4944836));
        consultarMedicosPanel.setFocusPainted(false);
        consultarMedicosPanel.setFocusable(false);
        Font consultarMedicosPanelFont = this.$$$getFont$$$("Consolas", -1, 20, consultarMedicosPanel.getFont());
        if (consultarMedicosPanelFont != null) consultarMedicosPanel.setFont(consultarMedicosPanelFont);
        consultarMedicosPanel.setForeground(new Color(-16777216));
        consultarMedicosPanel.setOpaque(true);
        consultarMedicosPanel.setRolloverEnabled(true);
        consultarMedicosPanel.setText("Consultar Medicos");
        panelBotones.add(consultarMedicosPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 65), new Dimension(400, 65), 0, false));
        agregarPacientePanel = new JButton();
        agregarPacientePanel.setBackground(new Color(-4944836));
        agregarPacientePanel.setFocusable(false);
        Font agregarPacientePanelFont = this.$$$getFont$$$("Consolas", -1, 20, agregarPacientePanel.getFont());
        if (agregarPacientePanelFont != null) agregarPacientePanel.setFont(agregarPacientePanelFont);
        agregarPacientePanel.setForeground(new Color(-16777216));
        agregarPacientePanel.setRolloverEnabled(true);
        agregarPacientePanel.setText("Agregar Paciente");
        panelBotones.add(agregarPacientePanel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 65), new Dimension(400, 65), 0, false));
        asignarPrioridadPanel = new JButton();
        asignarPrioridadPanel.setBackground(new Color(-4944836));
        asignarPrioridadPanel.setFocusable(false);
        Font asignarPrioridadPanelFont = this.$$$getFont$$$("Consolas", -1, 20, asignarPrioridadPanel.getFont());
        if (asignarPrioridadPanelFont != null) asignarPrioridadPanel.setFont(asignarPrioridadPanelFont);
        asignarPrioridadPanel.setForeground(new Color(-16777216));
        asignarPrioridadPanel.setRolloverEnabled(true);
        asignarPrioridadPanel.setText("Asignar prioridad");
        panelBotones.add(asignarPrioridadPanel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 65), new Dimension(400, 65), 0, false));
        panelListaMedicos = new JPanel();
        panelListaMedicos.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelListaMedicos.setBackground(new Color(-15787726));
        panelMedicos.add(panelListaMedicos, "Card2");
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-12500154));
        label1.setForeground(new Color(-1));
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setText("Lista de medicos disponibles");
        panelListaMedicos.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panelListaMedicos.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        listaMedicos = new JList();
        listaMedicos.setBackground(new Color(-5852181));
        scrollPane1.setViewportView(listaMedicos);
        volverPanelConsultaMedicos = new JButton();
        volverPanelConsultaMedicos.setBackground(new Color(-16777216));
        volverPanelConsultaMedicos.setForeground(new Color(-1));
        volverPanelConsultaMedicos.setMargin(new Insets(0, 0, 0, 0));
        volverPanelConsultaMedicos.setText("Volver");
        panelListaMedicos.add(volverPanelConsultaMedicos, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 45), new Dimension(500, 45), 1, false));
        panelFormularioMedico = new JPanel();
        panelFormularioMedico.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 5, new Insets(0, 0, 0, 0), -1, -1));
        panelFormularioMedico.setBackground(new Color(-15787726));
        panelMedicos.add(panelFormularioMedico, "Card3");
        campoNombreMedico = new JTextField();
        campoNombreMedico.setBackground(new Color(-5852181));
        campoNombreMedico.setForeground(new Color(-16777216));
        panelFormularioMedico.add(campoNombreMedico, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 1, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Consolas", -1, 14, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-657931));
        label2.setText("Nombre");
        panelFormularioMedico.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Consolas", -1, 14, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-657931));
        label3.setText("Dni (Documento)");
        panelFormularioMedico.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        campoDNImedico = new JTextField();
        campoDNImedico.setBackground(new Color(-5852181));
        campoDNImedico.setForeground(new Color(-16777216));
        panelFormularioMedico.add(campoDNImedico, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 1, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Consolas", -1, 14, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-657931));
        label4.setText("Edad");
        panelFormularioMedico.add(label4, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        campoEdadMedico = new JTextField();
        campoEdadMedico.setBackground(new Color(-5852181));
        campoEdadMedico.setForeground(new Color(-16777216));
        panelFormularioMedico.add(campoEdadMedico, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 1, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("Consolas", -1, 14, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-657931));
        label5.setText("Genero");
        panelFormularioMedico.add(label5, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Consolas", -1, 14, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-657931));
        label6.setText("Especialidad");
        panelFormularioMedico.add(label6, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        final JLabel label7 = new JLabel();
        Font label7Font = this.$$$getFont$$$("Consolas", -1, 14, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setForeground(new Color(-657931));
        label7.setText("Numero de registro");
        panelFormularioMedico.add(label7, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        campoNumeroRegistroMedico = new JTextField();
        campoNumeroRegistroMedico.setBackground(new Color(-5852181));
        campoNumeroRegistroMedico.setForeground(new Color(-16777216));
        panelFormularioMedico.add(campoNumeroRegistroMedico, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 1, false));
        añadirMedicoButton = new JButton();
        añadirMedicoButton.setBackground(new Color(-16777216));
        añadirMedicoButton.setFocusPainted(false);
        añadirMedicoButton.setFocusable(false);
        añadirMedicoButton.setForeground(new Color(-1));
        añadirMedicoButton.setRolloverEnabled(true);
        añadirMedicoButton.setText("Añadir Medico");
        panelFormularioMedico.add(añadirMedicoButton, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(280, 50), new Dimension(280, 50), 1, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelFormularioMedico.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 6, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        volverPanelMedicos = new JButton();
        volverPanelMedicos.setBackground(new Color(-16777216));
        volverPanelMedicos.setFocusPainted(false);
        volverPanelMedicos.setFocusable(false);
        volverPanelMedicos.setForeground(new Color(-1));
        volverPanelMedicos.setRolloverEnabled(true);
        volverPanelMedicos.setText("Volver");
        panelFormularioMedico.add(volverPanelMedicos, new com.intellij.uiDesigner.core.GridConstraints(7, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(280, 50), new Dimension(280, 50), 0, false));
        final JLabel label8 = new JLabel();
        Font label8Font = this.$$$getFont$$$("Consolas", -1, 14, label8.getFont());
        if (label8Font != null) label8.setFont(label8Font);
        label8.setForeground(new Color(-657931));
        label8.setText("Numero quirofano (cirugano)");
        panelFormularioMedico.add(label8, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        campoNumeroQuirofano = new JTextField();
        campoNumeroQuirofano.setBackground(new Color(-5852181));
        campoNumeroQuirofano.setForeground(new Color(-16777216));
        panelFormularioMedico.add(campoNumeroQuirofano, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 1, false));
        añadirCiruganoButton = new JButton();
        añadirCiruganoButton.setBackground(new Color(-16777216));
        añadirCiruganoButton.setForeground(new Color(-1));
        añadirCiruganoButton.setText("Añadir cirugano");
        panelFormularioMedico.add(añadirCiruganoButton, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(280, 50), new Dimension(280, 50), 0, false));
        listaGeneroMedico = new JComboBox();
        listaGeneroMedico.setBackground(new Color(-5852181));
        listaGeneroMedico.setForeground(new Color(-16777216));
        panelFormularioMedico.add(listaGeneroMedico, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 1, false));
        listaEspecialidades = new JComboBox();
        listaEspecialidades.setBackground(new Color(-5852181));
        listaEspecialidades.setForeground(new Color(-16777216));
        panelFormularioMedico.add(listaEspecialidades, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 1, false));
        panelAgregarPacientesMedico = new JPanel();
        panelAgregarPacientesMedico.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 3, new Insets(0, 0, 0, 0), -1, -1));
        panelAgregarPacientesMedico.setBackground(new Color(-15787726));
        panelMedicos.add(panelAgregarPacientesMedico, "Card4");
        final JLabel label9 = new JLabel();
        label9.setForeground(new Color(-1));
        label9.setText("Agregar un paciente a un medico");
        panelAgregarPacientesMedico.add(label9, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panelAgregarPacientesMedico.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(400, 40), new Dimension(400, 40), 0, false));
        final JLabel label10 = new JLabel();
        label10.setForeground(new Color(-1));
        label10.setText("Paciente");
        panelAgregarPacientesMedico.add(label10, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listaNombresPacientesAsignacion = new JComboBox();
        listaNombresPacientesAsignacion.setBackground(new Color(-5852181));
        panelAgregarPacientesMedico.add(listaNombresPacientesAsignacion, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 40), new Dimension(400, 40), 0, false));
        final JLabel label11 = new JLabel();
        label11.setForeground(new Color(-1));
        label11.setText("Medico");
        panelAgregarPacientesMedico.add(label11, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listaNombresMedicosAsignacion = new JComboBox();
        listaNombresMedicosAsignacion.setBackground(new Color(-5852181));
        panelAgregarPacientesMedico.add(listaNombresMedicosAsignacion, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 40), new Dimension(400, 40), 0, false));
        agregarPacienteMedico = new JButton();
        agregarPacienteMedico.setBackground(new Color(-16777216));
        agregarPacienteMedico.setFocusPainted(false);
        agregarPacienteMedico.setFocusable(false);
        agregarPacienteMedico.setForeground(new Color(-1));
        agregarPacienteMedico.setRolloverEnabled(true);
        agregarPacienteMedico.setText("Agregar Paciente");
        panelAgregarPacientesMedico.add(agregarPacienteMedico, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 50), new Dimension(400, 50), 1, false));
        volverAgregarPacienteMedico = new JButton();
        volverAgregarPacienteMedico.setBackground(new Color(-16777216));
        volverAgregarPacienteMedico.setFocusPainted(false);
        volverAgregarPacienteMedico.setFocusable(false);
        volverAgregarPacienteMedico.setForeground(new Color(-1));
        volverAgregarPacienteMedico.setRolloverEnabled(true);
        volverAgregarPacienteMedico.setText("Volver");
        panelAgregarPacientesMedico.add(volverAgregarPacienteMedico, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 50), new Dimension(400, 50), 1, false));
        panelListaPrioriades = new JPanel();
        panelListaPrioriades.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelListaPrioriades.setBackground(new Color(-15787726));
        panelMedicos.add(panelListaPrioriades, "Card5");
        final JLabel label12 = new JLabel();
        label12.setForeground(new Color(-1));
        label12.setText("Lista de prioridades");
        panelListaPrioriades.add(label12, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listaMedicosPanelPrioridades = new JComboBox();
        listaMedicosPanelPrioridades.setBackground(new Color(-5852181));
        panelListaPrioriades.add(listaMedicosPanelPrioridades, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane2 = new JScrollPane();
        panelListaPrioriades.add(scrollPane2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        listaPrioridades = new JList();
        listaPrioridades.setBackground(new Color(-5852181));
        scrollPane2.setViewportView(listaPrioridades);
        asignarPrioridadesButton = new JButton();
        asignarPrioridadesButton.setBackground(new Color(-16777216));
        asignarPrioridadesButton.setFocusable(false);
        asignarPrioridadesButton.setForeground(new Color(-1));
        asignarPrioridadesButton.setRolloverEnabled(false);
        asignarPrioridadesButton.setText("Asignar prioridades");
        panelListaPrioriades.add(asignarPrioridadesButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        volverPanelPrioridades = new JButton();
        volverPanelPrioridades.setBackground(new Color(-16777216));
        volverPanelPrioridades.setFocusable(false);
        volverPanelPrioridades.setForeground(new Color(-1));
        volverPanelPrioridades.setRolloverEnabled(false);
        volverPanelPrioridades.setText("Volver");
        panelListaPrioriades.add(volverPanelPrioridades, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Pacientes", panel2);
        panelPacientes = new JPanel();
        panelPacientes.setLayout(new CardLayout(0, 0));
        panel2.add(panelPacientes, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panelBotonesPacientes = new JPanel();
        panelBotonesPacientes.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelBotonesPacientes.setBackground(new Color(-15787726));
        panelPacientes.add(panelBotonesPacientes, "Card1");
        agregarPaciente = new JButton();
        agregarPaciente.setBackground(new Color(-4944836));
        agregarPaciente.setFocusable(false);
        Font agregarPacienteFont = this.$$$getFont$$$("Consolas", -1, 20, agregarPaciente.getFont());
        if (agregarPacienteFont != null) agregarPaciente.setFont(agregarPacienteFont);
        agregarPaciente.setForeground(new Color(-16777216));
        agregarPaciente.setRolloverEnabled(true);
        agregarPaciente.setText("Agregar Paciente");
        panelBotonesPacientes.add(agregarPaciente, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 65), new Dimension(500, 65), 0, false));
        mostrarListaPacientes = new JButton();
        mostrarListaPacientes.setBackground(new Color(-4944836));
        mostrarListaPacientes.setFocusable(false);
        Font mostrarListaPacientesFont = this.$$$getFont$$$("Consolas", -1, 20, mostrarListaPacientes.getFont());
        if (mostrarListaPacientesFont != null) mostrarListaPacientes.setFont(mostrarListaPacientesFont);
        mostrarListaPacientes.setForeground(new Color(-16777216));
        mostrarListaPacientes.setRolloverEnabled(true);
        mostrarListaPacientes.setText("Mostrar Pacientes");
        panelBotonesPacientes.add(mostrarListaPacientes, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 65), new Dimension(500, 65), 0, false));
        panelFormularioPacientes = new JPanel();
        panelFormularioPacientes.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelFormularioPacientes.setBackground(new Color(-15787726));
        panelPacientes.add(panelFormularioPacientes, "Card2");
        final JLabel label13 = new JLabel();
        Font label13Font = this.$$$getFont$$$("Consolas", -1, 14, label13.getFont());
        if (label13Font != null) label13.setFont(label13Font);
        label13.setForeground(new Color(-1));
        label13.setText("Nombre");
        panelFormularioPacientes.add(label13, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 8, false));
        campoNombrePaciente = new JTextField();
        campoNombrePaciente.setBackground(new Color(-5852181));
        panelFormularioPacientes.add(campoNombrePaciente, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
        final JLabel label14 = new JLabel();
        Font label14Font = this.$$$getFont$$$("Consolas", -1, 14, label14.getFont());
        if (label14Font != null) label14.setFont(label14Font);
        label14.setForeground(new Color(-1));
        label14.setText("Documento Paciente");
        panelFormularioPacientes.add(label14, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 8, false));
        campoDNIPaciente = new JTextField();
        campoDNIPaciente.setBackground(new Color(-5852181));
        panelFormularioPacientes.add(campoDNIPaciente, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
        final JLabel label15 = new JLabel();
        Font label15Font = this.$$$getFont$$$("Consolas", -1, 14, label15.getFont());
        if (label15Font != null) label15.setFont(label15Font);
        label15.setForeground(new Color(-1));
        label15.setText("Edad");
        panelFormularioPacientes.add(label15, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 8, false));
        campoEdadPaciente = new JTextField();
        campoEdadPaciente.setBackground(new Color(-5852181));
        panelFormularioPacientes.add(campoEdadPaciente, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
        final JLabel label16 = new JLabel();
        Font label16Font = this.$$$getFont$$$("Consolas", -1, 14, label16.getFont());
        if (label16Font != null) label16.setFont(label16Font);
        label16.setForeground(new Color(-1));
        label16.setText("Genero");
        panelFormularioPacientes.add(label16, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 8, false));
        listaGeneroPaciente = new JComboBox();
        listaGeneroPaciente.setBackground(new Color(-5852181));
        panelFormularioPacientes.add(listaGeneroPaciente, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
        final JLabel label17 = new JLabel();
        Font label17Font = this.$$$getFont$$$("Consolas", -1, 14, label17.getFont());
        if (label17Font != null) label17.setFont(label17Font);
        label17.setForeground(new Color(-1));
        label17.setText("Numero De Historial");
        panelFormularioPacientes.add(label17, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 8, false));
        campoNumeroHistorial = new JTextField();
        campoNumeroHistorial.setBackground(new Color(-5852181));
        panelFormularioPacientes.add(campoNumeroHistorial, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
        final JLabel label18 = new JLabel();
        Font label18Font = this.$$$getFont$$$("Consolas", -1, 14, label18.getFont());
        if (label18Font != null) label18.setFont(label18Font);
        label18.setForeground(new Color(-1));
        label18.setText("Eps");
        panelFormularioPacientes.add(label18, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 8, false));
        listaEps = new JComboBox();
        listaEps.setBackground(new Color(-5852181));
        panelFormularioPacientes.add(listaEps, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
        final JLabel label19 = new JLabel();
        Font label19Font = this.$$$getFont$$$("Consolas", -1, 14, label19.getFont());
        if (label19Font != null) label19.setFont(label19Font);
        label19.setForeground(new Color(-1));
        label19.setText("Saldo Disponible");
        panelFormularioPacientes.add(label19, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 8, false));
        campoSaldo = new JTextField();
        campoSaldo.setBackground(new Color(-5852181));
        panelFormularioPacientes.add(campoSaldo, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
        final JLabel label20 = new JLabel();
        Font label20Font = this.$$$getFont$$$("Consolas", -1, 14, label20.getFont());
        if (label20Font != null) label20.setFont(label20Font);
        label20.setForeground(new Color(-1));
        label20.setText("Sintoma");
        panelFormularioPacientes.add(label20, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 8, false));
        listaSintomas = new JComboBox();
        listaSintomas.setBackground(new Color(-5852181));
        panelFormularioPacientes.add(listaSintomas, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 0, -1));
        panel3.setBackground(new Color(-15787726));
        panelFormularioPacientes.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        agregarPacientes = new JButton();
        agregarPacientes.setBackground(new Color(-16777216));
        agregarPacientes.setFocusable(false);
        agregarPacientes.setForeground(new Color(-394241));
        agregarPacientes.setRolloverEnabled(false);
        agregarPacientes.setText("Agregar");
        panel3.add(agregarPacientes, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 50), new Dimension(400, 50), 0, false));
        volverPanelPacientes = new JButton();
        volverPanelPacientes.setBackground(new Color(-16777216));
        volverPanelPacientes.setFocusable(false);
        volverPanelPacientes.setForeground(new Color(-394241));
        volverPanelPacientes.setRolloverEnabled(false);
        volverPanelPacientes.setText("Volver");
        panel3.add(volverPanelPacientes, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 50), new Dimension(400, 50), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panelFormularioPacientes.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(-1, 20), new Dimension(-1, 20), 0, false));
        panelListaPacientes = new JPanel();
        panelListaPacientes.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelListaPacientes.setBackground(new Color(-15787726));
        panelPacientes.add(panelListaPacientes, "Card3");
        final JLabel label21 = new JLabel();
        label21.setForeground(new Color(-1));
        label21.setText("Lista de pacientes");
        panelListaPacientes.add(label21, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane3 = new JScrollPane();
        scrollPane3.setBackground(new Color(-5852181));
        panelListaPacientes.add(scrollPane3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        listaPanelPacientes = new JList();
        listaPanelPacientes.setBackground(new Color(-5852181));
        scrollPane3.setViewportView(listaPanelPacientes);
        volverListaPacientes = new JButton();
        volverListaPacientes.setBackground(new Color(-16777216));
        volverListaPacientes.setFocusable(false);
        volverListaPacientes.setForeground(new Color(-1));
        volverListaPacientes.setRolloverEnabled(false);
        volverListaPacientes.setText("Volver");
        panelListaPacientes.add(volverListaPacientes, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 50), new Dimension(500, 50), 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel4.setBackground(new Color(-15787726));
        tabbedPane1.addTab("Cirujias", panel4);
        listaCiruganos = new JComboBox();
        listaCiruganos.setBackground(new Color(-5852181));
        panel4.add(listaCiruganos, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 50), new Dimension(500, 50), 0, false));
        consultarQuirofanoButton = new JButton();
        consultarQuirofanoButton.setBackground(new Color(-16777216));
        consultarQuirofanoButton.setForeground(new Color(-1));
        consultarQuirofanoButton.setText("Consultar quirofano");
        panel4.add(consultarQuirofanoButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
        estadoQuirofano = new JComboBox();
        estadoQuirofano.setBackground(new Color(-5852181));
        panel4.add(estadoQuirofano, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 50), new Dimension(500, 50), 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel5.setBackground(new Color(-15787726));
        tabbedPane1.addTab("Atencion", panel5);
        listaPacientesAtencion = new JComboBox();
        listaPacientesAtencion.setBackground(new Color(-5852181));
        panel5.add(listaPacientesAtencion, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 50), new Dimension(500, 50), 0, false));
        procesarIngresoButton = new JButton();
        procesarIngresoButton.setBackground(new Color(-16777216));
        procesarIngresoButton.setFocusable(false);
        procesarIngresoButton.setForeground(new Color(-1));
        procesarIngresoButton.setRolloverEnabled(false);
        procesarIngresoButton.setText("Procesar Ingreso");
        panel5.add(procesarIngresoButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 50), new Dimension(500, 50), 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel6.setBackground(new Color(-15787726));
        tabbedPane1.addTab("Pagos", panel6);
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panel6.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        listaPacientesPago = new JComboBox();
        listaPacientesPago.setBackground(new Color(-5852181));
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        listaPacientesPago.setModel(defaultComboBoxModel1);
        panel6.add(listaPacientesPago, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 50), new Dimension(500, 50), 0, false));
        campoCostoConsulta = new JTextField();
        campoCostoConsulta.setBackground(new Color(-5852181));
        panel6.add(campoCostoConsulta, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 50), new Dimension(500, 50), 0, false));
        final JLabel label22 = new JLabel();
        label22.setBackground(new Color(-5852181));
        label22.setForeground(new Color(-1));
        label22.setText("Ingrese el valor");
        panel6.add(label22, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 50), new Dimension(500, 50), 0, false));
        verificarPresupuestoButton = new JButton();
        verificarPresupuestoButton.setBackground(new Color(-16777216));
        verificarPresupuestoButton.setFocusable(false);
        verificarPresupuestoButton.setForeground(new Color(-1));
        verificarPresupuestoButton.setText("Verificar presupuesto");
        panel6.add(verificarPresupuestoButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 40), new Dimension(500, 40), 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
