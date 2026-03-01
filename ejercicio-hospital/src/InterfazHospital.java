import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class InterfazHospital {
    /**
     * Componentes
     */
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton agregarMedicoPanel;
    private JButton consultarMedicosPanel;
    private JButton agregarPacientePanel;
    private JButton revisarPacientesPanel;
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
    private JComboBox listaNombresPacientes;
    private JComboBox listaNombresMedicos;
    private JButton agregarPacienteButton;
    private JButton volverAgregarPacienteMedico;
    private JPanel panelPacientes;
    private JPanel panelBotonesPacientes;
    private JButton agregarPaciente;
    private JButton mostrarPacientesButton;
    private JPanel panelFormularioPacientes;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox listaGeneroPaciente;
    private JTextField textField4;
    private JComboBox listaEps;
    private JTextField textField5;
    private JComboBox listaSintomas;

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
        /**
         * establecer panel ppal
         */
        layoutPanelMedicos.show(panelMedicos, "panelBotones");
        /**
         * añadir los paneles correspondientes a cada boton del panel Pacientes
         */
        panelPacientes.add(panelBotonesPacientes, "panelBotonesPacientes");
        panelPacientes.add(panelFormularioPacientes, "panelFormularioPacientes");
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
        ActionListener volver = e -> {
            layoutPanelMedicos.show(panelMedicos, "panelBotones");
        };
        volverPanelMedicos.addActionListener(volver);
        volverPanelConsultaMedicos.addActionListener(volver);
        volverAgregarPacienteMedico.addActionListener(volver);
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
                listaNombresMedicos.addItem(nombreMedico + " [" + especialidad + "]");
                JOptionPane.showMessageDialog(null, "Medico " + nombreMedico + " añadido correctamente");
                limpiarCamposMedico();
            } else {
                MedicoCirugano cirugano = new MedicoCirugano(nombreMedico, documentoMedico, edadMedico, generoMedico, especialidad, numeroRegistro, numeroQuirofanoCirugano);
                ciruganos.add(cirugano);
                listaNombresMedicos.addItem(nombreMedico + "[" + especialidad + "]");
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
        panelBotones.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
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
        agregarMedicoPanel.setRolloverEnabled(false);
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
        consultarMedicosPanel.setRolloverEnabled(false);
        consultarMedicosPanel.setText("Consultar Medicos");
        panelBotones.add(consultarMedicosPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 65), new Dimension(400, 65), 0, false));
        agregarPacientePanel = new JButton();
        agregarPacientePanel.setBackground(new Color(-4944836));
        agregarPacientePanel.setFocusable(false);
        Font agregarPacientePanelFont = this.$$$getFont$$$("Consolas", -1, 20, agregarPacientePanel.getFont());
        if (agregarPacientePanelFont != null) agregarPacientePanel.setFont(agregarPacientePanelFont);
        agregarPacientePanel.setForeground(new Color(-16777216));
        agregarPacientePanel.setRolloverEnabled(false);
        agregarPacientePanel.setText("Agregar Paciente");
        panelBotones.add(agregarPacientePanel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 65), new Dimension(400, 65), 0, false));
        revisarPacientesPanel = new JButton();
        revisarPacientesPanel.setBackground(new Color(-4944836));
        revisarPacientesPanel.setFocusPainted(false);
        revisarPacientesPanel.setFocusable(false);
        Font revisarPacientesPanelFont = this.$$$getFont$$$("Consolas", -1, 20, revisarPacientesPanel.getFont());
        if (revisarPacientesPanelFont != null) revisarPacientesPanel.setFont(revisarPacientesPanelFont);
        revisarPacientesPanel.setForeground(new Color(-16777216));
        revisarPacientesPanel.setRolloverEnabled(false);
        revisarPacientesPanel.setText("Revisar pacientes");
        panelBotones.add(revisarPacientesPanel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 65), new Dimension(400, 65), 0, false));
        asignarPrioridadPanel = new JButton();
        asignarPrioridadPanel.setBackground(new Color(-4944836));
        asignarPrioridadPanel.setFocusable(false);
        Font asignarPrioridadPanelFont = this.$$$getFont$$$("Consolas", -1, 20, asignarPrioridadPanel.getFont());
        if (asignarPrioridadPanelFont != null) asignarPrioridadPanel.setFont(asignarPrioridadPanelFont);
        asignarPrioridadPanel.setForeground(new Color(-16777216));
        asignarPrioridadPanel.setRolloverEnabled(false);
        asignarPrioridadPanel.setText("Asignar prioridad");
        panelBotones.add(asignarPrioridadPanel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 65), new Dimension(400, 65), 0, false));
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
        añadirMedicoButton.setRolloverEnabled(false);
        añadirMedicoButton.setText("Añadir Medico");
        panelFormularioMedico.add(añadirMedicoButton, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(280, 50), new Dimension(280, 50), 1, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelFormularioMedico.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 6, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        volverPanelMedicos = new JButton();
        volverPanelMedicos.setBackground(new Color(-16777216));
        volverPanelMedicos.setFocusPainted(false);
        volverPanelMedicos.setFocusable(false);
        volverPanelMedicos.setForeground(new Color(-1));
        volverPanelMedicos.setRolloverEnabled(false);
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
        listaNombresPacientes = new JComboBox();
        listaNombresPacientes.setBackground(new Color(-5852181));
        panelAgregarPacientesMedico.add(listaNombresPacientes, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 40), new Dimension(400, 40), 0, false));
        final JLabel label11 = new JLabel();
        label11.setForeground(new Color(-1));
        label11.setText("Medico");
        panelAgregarPacientesMedico.add(label11, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listaNombresMedicos = new JComboBox();
        listaNombresMedicos.setBackground(new Color(-5852181));
        panelAgregarPacientesMedico.add(listaNombresMedicos, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 40), new Dimension(400, 40), 0, false));
        agregarPacienteButton = new JButton();
        agregarPacienteButton.setBackground(new Color(-16777216));
        agregarPacienteButton.setFocusPainted(false);
        agregarPacienteButton.setFocusable(false);
        agregarPacienteButton.setForeground(new Color(-1));
        agregarPacienteButton.setRolloverEnabled(false);
        agregarPacienteButton.setText("Agregar Paciente");
        panelAgregarPacientesMedico.add(agregarPacienteButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 50), new Dimension(400, 50), 1, false));
        volverAgregarPacienteMedico = new JButton();
        volverAgregarPacienteMedico.setBackground(new Color(-16777216));
        volverAgregarPacienteMedico.setFocusPainted(false);
        volverAgregarPacienteMedico.setFocusable(false);
        volverAgregarPacienteMedico.setForeground(new Color(-1));
        volverAgregarPacienteMedico.setRolloverEnabled(false);
        volverAgregarPacienteMedico.setText("Volver");
        panelAgregarPacientesMedico.add(volverAgregarPacienteMedico, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(400, 50), new Dimension(400, 50), 1, false));
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
        agregarPaciente.setRolloverEnabled(false);
        agregarPaciente.setText("Agregar Paciente");
        panelBotonesPacientes.add(agregarPaciente, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 65), new Dimension(500, 65), 0, false));
        mostrarPacientesButton = new JButton();
        mostrarPacientesButton.setBackground(new Color(-4944836));
        mostrarPacientesButton.setFocusable(false);
        Font mostrarPacientesButtonFont = this.$$$getFont$$$("Consolas", -1, 20, mostrarPacientesButton.getFont());
        if (mostrarPacientesButtonFont != null) mostrarPacientesButton.setFont(mostrarPacientesButtonFont);
        mostrarPacientesButton.setForeground(new Color(-16777216));
        mostrarPacientesButton.setRolloverEnabled(false);
        mostrarPacientesButton.setText("Mostrar Pacientes");
        panelBotonesPacientes.add(mostrarPacientesButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 65), new Dimension(500, 65), 0, false));
        panelFormularioPacientes = new JPanel();
        panelFormularioPacientes.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelFormularioPacientes.setBackground(new Color(-15787726));
        panelPacientes.add(panelFormularioPacientes, "Card2");
        final JLabel label12 = new JLabel();
        Font label12Font = this.$$$getFont$$$("Consolas", -1, 20, label12.getFont());
        if (label12Font != null) label12.setFont(label12Font);
        label12.setForeground(new Color(-1));
        label12.setText("Nombre");
        panelFormularioPacientes.add(label12, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        panelFormularioPacientes.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label13 = new JLabel();
        Font label13Font = this.$$$getFont$$$("Consolas", -1, 20, label13.getFont());
        if (label13Font != null) label13.setFont(label13Font);
        label13.setForeground(new Color(-1));
        label13.setText("Documento Paciente");
        panelFormularioPacientes.add(label13, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField2 = new JTextField();
        panelFormularioPacientes.add(textField2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label14 = new JLabel();
        Font label14Font = this.$$$getFont$$$("Consolas", -1, 20, label14.getFont());
        if (label14Font != null) label14.setFont(label14Font);
        label14.setForeground(new Color(-1));
        label14.setText("Edad");
        panelFormularioPacientes.add(label14, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField3 = new JTextField();
        panelFormularioPacientes.add(textField3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label15 = new JLabel();
        Font label15Font = this.$$$getFont$$$("Consolas", -1, 20, label15.getFont());
        if (label15Font != null) label15.setFont(label15Font);
        label15.setForeground(new Color(-1));
        label15.setText("Genero");
        panelFormularioPacientes.add(label15, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listaGeneroPaciente = new JComboBox();
        panelFormularioPacientes.add(listaGeneroPaciente, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label16 = new JLabel();
        Font label16Font = this.$$$getFont$$$("Consolas", -1, 20, label16.getFont());
        if (label16Font != null) label16.setFont(label16Font);
        label16.setForeground(new Color(-1));
        label16.setText("Numero De Historial");
        panelFormularioPacientes.add(label16, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField4 = new JTextField();
        panelFormularioPacientes.add(textField4, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label17 = new JLabel();
        Font label17Font = this.$$$getFont$$$("Consolas", -1, 20, label17.getFont());
        if (label17Font != null) label17.setFont(label17Font);
        label17.setForeground(new Color(-1));
        label17.setText("Eps");
        panelFormularioPacientes.add(label17, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listaEps = new JComboBox();
        panelFormularioPacientes.add(listaEps, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label18 = new JLabel();
        Font label18Font = this.$$$getFont$$$("Consolas", -1, 20, label18.getFont());
        if (label18Font != null) label18.setFont(label18Font);
        label18.setForeground(new Color(-1));
        label18.setText("Saldo Disponible");
        panelFormularioPacientes.add(label18, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField5 = new JTextField();
        panelFormularioPacientes.add(textField5, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label19 = new JLabel();
        Font label19Font = this.$$$getFont$$$("Consolas", -1, 20, label19.getFont());
        if (label19Font != null) label19.setFont(label19Font);
        label19.setForeground(new Color(-1));
        label19.setText("Sintoma");
        panelFormularioPacientes.add(label19, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listaSintomas = new JComboBox();
        panelFormularioPacientes.add(listaSintomas, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Cirujias", panel3);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Atencion", panel4);
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
