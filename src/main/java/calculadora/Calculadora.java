package calculadora;
import java.awt.*;
import java.awt.event.*;

/**
 * @date 6 nov. 2021
 * @author Jhoan López
 * @email Jhoanlopezclase@gmail.com
 */

public class Calculadora extends Frame implements ActionListener, WindowListener {
    protected String numeros [] = new String[]{"7", "8", "9","4", "5", "6","1", "2", "3","c", "0", ""};   
    protected String signos [] = new String[]{"/","*","-","+","="};
    protected String primerNumero, segundoNumero, textoDisplay, numeroIntroducido, numerosIntroducidos;
    protected int operacion;
    protected int resultado;
    
    Label display = null;
    Button boton = null;
    Panel numbersPanel = null;
    Panel opsPanel = null;
    Panel displayPanel = null;
    
    
    //Método para crear los botonones de números que van a ir en el numbersPanel
    public void crearBotonNumero (String nombre, GridBagLayout gbl, GridBagConstraints gbc) {   
        //Creo el nuevo objeto de tipo Button
        boton = new Button (nombre);
        
        //Añado unos pequeños espaciadps para los botones
        gbc.insets.bottom = 2;
        gbc.insets.top = 2;
        gbc.insets.left = 2;
        gbc.insets.right = 2;

        //Asigno caracteristicas cómo el tipo de letra, el tamaño, background...
        boton.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        boton.addActionListener(this);
        boton.setVisible( true );
        boton.setForeground(new Color(28, 40, 51));
        boton.setBackground(new Color(248, 249, 249 ));
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Recorro el array de numeros con este for
                for (int i = 0; 1 < numeros.length; i++) {
                    /*
                    Cuando el nombre del botón coincida con la posición del array
                    entro en el if(), obtengo el texto que hay en el display,
                    igualo un String a la posición del array que coincidio con el nombre,
                    igualo un nuevo String con la suma de los Strings anteriores
                    y lo envio al display
                    */
                    if(nombre == numeros[i]){
                        textoDisplay = display.getText();
                        numeroIntroducido = numeros[i];
                        numerosIntroducidos = textoDisplay + numeroIntroducido;
                        display.setText(numerosIntroducidos);
                    }
                    //En el caso de que sea "c" envio un String vacio
                    if(nombre == "c"){
                        display.setText("");
                    }
                }
            }
        });
        /*
        Hay un String vacio en el array, este botón lo declar setEnable(false)
        para que no se pueda pulsar
        */
        if (nombre == "") {
            boton.setEnabled(false);    
        }
        //Añado cada botón al Panel numbersPanel
        numbersPanel.add(boton);
    }
    
    //Método para crear los botonones de signos que van a ir en el opsPanel
    public void crearBotonSigno (String nombre, GridBagLayout gbl, GridBagConstraints gbc) {
        //Creo el nuevo objeto de tipo Button
        boton = new Button (nombre);
        
        //Añado unos pequeños espaciadps para los botones
        gbc.insets.bottom = 2;
        gbc.insets.top = 2;
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        
        //Asigno caracteristicas cómo el tipo de letra, el tamaño, background...
        boton.setForeground(new Color(28, 40, 51));
        boton.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
        boton.addActionListener(this);
        boton.setVisible( true );
        boton.setForeground(new Color(28, 40, 51));
        boton.setBackground(new Color(230, 230, 230));
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Recorro el array de numeros con este for
                for (int i = 0; i < signos.length; i++) {  
                    /*
                    Si el nombre coincide con algunas de las posiciones del String
                    menos con el signo "=", entro en el if(), obtengo el texto
                    que hay en el display y envío un String vacio al display,
                    dependiendo del cual sea el signo pulsado le asigno un valor
                    a la variable operacion
                    */
                    if(nombre == signos[i] && nombre != "="){
                    primerNumero = display.getText();
                    display.setText("");
                        switch (nombre) {
                            case "+":
                                operacion = 1;
                                break;
                            case "-":
                                operacion = 2;
                                break;
                            case "*":
                                operacion = 3;
                                break;
                            case "/":
                                operacion = 4;   
                                break;
                        }
                    }  
                }
                /*
                Si el nombre coincide con el signo "=" obtengo el texto que 
                hay en la pantalla y dependiendo del valor que haya asignado
                antes a la variable operacion realizo una operación u otra
                */
                if(nombre == "="){
                    segundoNumero = display.getText();
                    switch (operacion) {
                        case 1:
                            resultado = Integer.parseInt(primerNumero) + 
                                Integer.parseInt(segundoNumero);
                            display.setText(String.valueOf(resultado));
                            break;
                        case 2:
                            resultado = Integer.parseInt(primerNumero) - 
                                Integer.parseInt(segundoNumero);
                            display.setText(String.valueOf(resultado));
                            break;
                        case 3:
                            resultado = Integer.parseInt(primerNumero) *
                                Integer.parseInt(segundoNumero);
                            display.setText(String.valueOf(resultado));
                            break;
                        case 4:
                            resultado = Integer.parseInt(primerNumero) / 
                                Integer.parseInt(segundoNumero);
                            display.setText(String.valueOf(resultado));   
                            break;
                    }                    
                }  
            }
        });
        //Este if() es para cambiar el color de Background del botón con el signo "="
        if (nombre == "=") {
            boton.setBackground(new Color(210, 210, 210));
        }
        //Añado cada botón al Panel numbersPanel
        opsPanel.add(boton);
    }
    
    public Calculadora() {
        
        /*
        Esto me pide el "height" y "width" de la pantalla, con esas medidas
        me posiciona la ventana en el centro de la pantalla
        */
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;	
	int width = pantalla.width;
	setSize(height/2, width/2);		
	setLocationRelativeTo(null);
        
        // Creo el GridBagLayout y el GridBagConstraints
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        //Muestro el GrifBagLayout
        setLayout(gbl);
        
        //Creo el displayPanel y el display
        displayPanel = new Panel();
        display = new Label ();

        //Establezco las características del display
        display.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
        display.setForeground(Color.BLACK);
        display.setBackground(new Color(229, 231, 233));
        
        displayPanel.setLayout(new GridLayout(1,1));
        displayPanel.add(display);

        gbc.weightx = 4;
        gbc.weighty = 5;
        gbc.fill = GridBagConstraints.BOTH;
        

        //Creo en panel donde van a ir los números
        numbersPanel = new Panel();
        numbersPanel.setLayout(new GridLayout(5,3, 2, 2));
        //Recorro el array numeros y creo los botones
        for (int i = 0; i < numeros.length; i++) {
            crearBotonNumero(numeros[i], gbl, gbc);
        }
        
        //Creo en panel donde van a ir los signos
        opsPanel = new Panel();
        opsPanel.setLayout(new GridLayout(5,1, 2, 2)); 
        //Recorro el array signos y creo los botones
        for (int i = 0; i < signos.length; i++) {
            crearBotonSigno(signos[i], gbl, gbc);
        }
   
        /*
        Indico las posiciones de las filas, columnas, y lo que va a cupar cada elemento.
        Posteriormente envio el Constraints y añado el displayPanel
        */
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbl.setConstraints(displayPanel, gbc);
        add(displayPanel);
        
        /*
        Indico las posiciones de las filas, columnas, y lo que va a cupar cada elemento.
        Posteriormente envio el Constraints y añado el numbersPanel
        */
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 4;
        gbl.setConstraints(numbersPanel, gbc);
        add(numbersPanel);
        
        /*
        Indico las posiciones de las filas, columnas, y lo que va a cupar cada elemento.
        Posteriormente envio el Constraints y añado el aopsPanel
        */
        gbc.gridy = 1;
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(opsPanel, gbc);
        add(opsPanel);
        
        /*
        Establezco el color de BackGround, el título de la ventana, 
        indico si se puede modificar su tamaño, las medidadas iniciales de la ventana
        y si esta es visible
        */
        this.addWindowListener(this);
        setBackground(new Color(229, 231, 233 ));
        setTitle("Calculadora");
        setResizable(true);
        setSize (350,550);
        setVisible(true);  
    }  
    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void windowClosing (WindowEvent e){
        System.exit(0);
    }

    public static void main (String [] args){
        Calculadora app = new Calculadora();
        app.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}