
package ve.com.generic.views;

import ve.com.rep.controllers.EventoSiguiente;
import ve.com.rep.controllers.EventoAnterior;
import ve.com.rep.controllers.EventoCancelar;
import ve.com.rep.controllers.EventoAceptar;
import ve.com.rep.controllers.EventoModificar;
import ve.com.rep.controllers.EventoBorrar;
import ve.com.rep.controllers.EventoAgregar;
import ve.com.rep.controllers.EventoSeleccionarRegistro;
import ve.com.rep.controllers.EventoBusquedaProgresiva;
import ve.com.rep.controllers.EventoBotonCerrar;
import ve.com.rep.controllers.EventoCerrar;
import ve.com.generic.builder.Ventana;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import ve.com.generic.builder.Botonera;
import ve.com.generic.helpers.DatosBotones;
import ve.com.generic.builder.tabla;
import ve.com.generic.helpers.DatosTabla;
import ve.com.rep.model.ConsultaSQL;
import ve.com.rep.model.DatosSQL;
import ve.com.generic.builder.BotonesOpcion;
import ve.com.generic.builder.GenerarForm;
import ve.com.generic.helpers.DatosForm;
import ve.com.generic.helpers.DatosOpciones;
import ve.com.rep.controllers.CargarDatos;
import ve.com.rep.model.Nacional;


public class Principal extends Ventana {
    JLabel titulo;
    JPanel panelTitulo;
    char SEP = File.separatorChar;
    Botonera botonesCRUD;
    Botonera botonesConf;
    JPanel panelBot;
    tabla tableREP;
    JPanel panelTabla;
    //ConsultaSQL consulta;
    JPanel panelPrincipal;
    GenerarForm formulario;
    GenerarForm formBuscar;
    BotonesOpcion opcionesBuscar;
    Botonera botonesPaginar;
    JPanel panelForm;
    JPanel panelOpciones;
    JPanel panelBuscar;
    JPanel panelBotonesPaginar;
    Nacional nacional;
    CargarDatos datos;
    
    public Principal(String[] atributosVentana) {
        super(atributosVentana);
        crearGUI();
    }

    private void crearGUI() {
        //Ajuste de la Ventana 
        this.setLayout(new BorderLayout());
        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.white);
        
        //Agregar Titulo
        titulo = new JLabel(".:Registro Electoral Permanente [REP]:.", JLabel.CENTER);//Para centrar el titulo
        titulo.setFont(new Font("Verdana", Font.BOLD, 24));//Para cambiar la fuente de la letra, tamaño estilo 
        titulo.setIcon(new ImageIcon("imagenes" + SEP + "Eventos64x64.png"));//Agregar Icono
        titulo.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));//Agragarle color al Tiltulo
        
        //Generar Formulario
        formulario = new GenerarForm(DatosForm.ETIQUETAS_FORMULARIO,"Datos del elector: ",0);
        formulario.activarForm(false);
        panelForm = new JPanel(new BorderLayout());
        panelForm.add(formulario);
        panelForm.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
        panelPrincipal.add(panelForm,BorderLayout.NORTH);
        //Agragar titulo a panelTitulo
        panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.add(titulo);
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        //Agregar Tabla
        tableREP = new tabla(DatosTabla.NOMBRE_COLUMNAS, 0);
        tableREP.setPreferredSize(new Dimension(100,312));
        panelTabla = new JPanel(new BorderLayout());
        panelTabla.add(tableREP, BorderLayout.NORTH);
        panelTabla.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        //Generar Botones de Opcion
        opcionesBuscar = new BotonesOpcion(DatosOpciones.NOMBRE_OPCIONES,0);
        panelOpciones = new JPanel(new FlowLayout());
        panelOpciones.add(opcionesBuscar);
        panelTabla.add(panelOpciones,BorderLayout.CENTER);
        //Formulario Buscar
        formBuscar = new GenerarForm(DatosForm.ETIQUETA_BUSCAR,null,1);
        panelBuscar = new JPanel(new BorderLayout());
        panelBuscar.setBorder(BorderFactory.createEmptyBorder(5,550,5,550));
        panelBuscar.add(formBuscar);
        panelTabla.add(panelBuscar,BorderLayout.SOUTH);
        //Botones Paginar
        botonesPaginar = new Botonera(DatosBotones.BOTONES_PAGINAR,DatosBotones.LETRAS_PAGINAR,DatosBotones.ICONOS_PAGINAR);
        botonesPaginar.activarBoton(false, 0);
        panelBotonesPaginar = new JPanel(new BorderLayout());
        panelBotonesPaginar.add(botonesPaginar);
        panelPrincipal.add(panelBotonesPaginar,BorderLayout.SOUTH);
        //Agregar Botones
        botonesCRUD = new Botonera(DatosBotones.BOTONES_CRUD, DatosBotones.LETRAS_CRUD, DatosBotones.ICONOS_CRUD);
        botonesConf = new Botonera(DatosBotones.BOTONES_CONF, DatosBotones.LETRAS_CONF, DatosBotones.ICONOS_CONF);
        botonesConf.activarBoton(false, 0);
        botonesConf.activarBoton(false, 1);
        panelBot = new JPanel(new BorderLayout());
        panelBot.add(botonesCRUD, BorderLayout.WEST);
        panelBot.add(botonesConf, BorderLayout.EAST);
        //Cargar de datos a la tabla y el formulario.
        datos = new CargarDatos(formulario,tableREP);
        datos.cargaDatosTabla();
        datos.cargarFormulario();
        //Instancia de Clase Nacional
        nacional = new Nacional();
        recordarDatosForm();
        //Agregar manejo de eventos
        this.addWindowListener(new EventoCerrar());
        botonesCRUD.asignarOyente(new EventoBotonCerrar(botonesConf),3);
        formBuscar.cuadrosTexto[0].addKeyListener(new EventoBusquedaProgresiva(formBuscar,opcionesBuscar,tableREP));
        tableREP.table.addMouseListener(new EventoSeleccionarRegistro(tableREP,nacional,formulario));
        botonesCRUD.asignarOyente(new EventoAgregar(botonesConf,botonesCRUD,formulario),0);
        botonesCRUD.asignarOyente(new EventoBorrar(botonesConf,botonesCRUD), 1);
        botonesCRUD.asignarOyente(new EventoModificar(botonesConf,botonesCRUD,formulario), 2);
        botonesConf.asignarOyente(new EventoAceptar(botonesCRUD,botonesConf,formulario,nacional,datos,tableREP.tablaModel),0);
        botonesConf.asignarOyente(new EventoCancelar(botonesCRUD,botonesConf,formulario,nacional),1);
        botonesPaginar.asignarOyente(new EventoAnterior(tableREP.tablaModel,botonesPaginar),0);
        botonesPaginar.asignarOyente(new EventoSiguiente(tableREP.tablaModel,botonesPaginar),1);
        //Agregar Componentes a la Ventana
        panelPrincipal.add(panelTabla,BorderLayout.CENTER);
        this.add(panelTitulo, BorderLayout.NORTH);
        this.add(panelPrincipal, BorderLayout.CENTER);
        this.add(panelBot, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //En caso de haber muchos componentes se habilitaria un scroll
        this.add(new JScrollPane(panelPrincipal));
        this.setVisible(true);
    }
    //Crear metodo para recordar los datos del formulario.
    public void recordarDatosForm(){
    
        nacional.setNacionalidad(formulario.cuadrosTexto[0].getText());
        nacional.setCedula(formulario.cuadrosTexto[1].getText());
        nacional.setPrimerNombre(formulario.cuadrosTexto[2].getText());
        nacional.setSegundoNombre(formulario.cuadrosTexto[3].getText());
        nacional.setPrimerApellido(formulario.cuadrosTexto[4].getText());
        nacional.setSegundoApellido(formulario.cuadrosTexto[5].getText());
        nacional.setCodigoCentro(formulario.cuadrosTexto[6].getText());
       
    }
}