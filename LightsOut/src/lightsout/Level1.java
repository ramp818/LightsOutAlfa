package lightsout;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Level1 extends JFrame implements Runnable, KeyListener
{
    private static final long serialVersionUID = 1L;
    // Se declaran las variables.
    private Graphics dbg;	// Objeto grafico
    private Image dbImage;	// Imagen a proyectar
    private SoundClip fondo;
    private long tiempoActual;
    private long tiempoInicial;
    private Animacion animBueno;
    private Animacion animMalo;
    private Bueno principal;
    private Malo fantasma;
    private int direccion=0;
    
    
    public Level1()
    {
                direccion = 0;
                Image principal0 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/Bueno0.gif"));
		
		
		//Se crea la animación
		animBueno = new Animacion();
		animBueno.sumaCuadro(principal0, 100);
                
                //Pinta el fondo del Applet de color blanco		
		setBackground(Color.white);
                setSize(1000,800);
                addKeyListener(this);
                Thread th = new Thread (this);
		// Empieza el hilo
		th.start ();
		
    }
    
    /** 
	 * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se incrementa
     * la posicion en x o y dependiendo de la direccion, finalmente 
     * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
     * 
     */
	public void run () {
		while (true) {
			actualiza();
<<<<<<< HEAD
			//checaColision();
			repaint();    // Se actualiza el <code>Applet</code> repintando el contenido.
=======

			//checaColision();

			//checaColision(); 
                        // Se actualiza el <code>Applet</code> repintando el contenido.
>>>>>>> FETCH_HEAD
			try	{
				// El thread se duerme.
				Thread.sleep (20);
			}
			catch (InterruptedException ex)	{
				System.out.println("Error en " + ex.toString());
			}
		}
	}
	
	/**
	 * Metodo usado para actualizar la posicion de objetos planeta y meteorito.
	 * 
	 */
	public void actualiza(){
            
            long tiempoTranscurrido= System.currentTimeMillis() - tiempoActual;
            tiempoActual += tiempoTranscurrido;
            animBueno.actualiza(tiempoTranscurrido);
		 
        }
		
	/**
	 * Metodo <I>paint</I> sobrescrito de la clase <code>JFrame</code>,
	 * heredado de la clase Container.<P>
	 * En este metodo lo que hace es actualizar el contenedor
	 * @param g es el <code>objeto grafico</code> usado para dibujar.
	 */
	public void paint(Graphics g) {
		// Inicializan el DoubleBuffer
		if (dbImage == null){
			dbImage = createImage (this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics ();
		}

		// Actualiza la imagen de fondo.
		dbg.setColor(getBackground ());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

		// Actualiza el Foreground.
		dbg.setColor(getForeground());
		paint1(dbg);

		// Dibuja la imagen actualizada
		g.drawImage (dbImage, 0, 0, this);
	}
        
        /**
	 * Metodo <I>paint</I> sobrescrito de la clase <code>Applet</code>,
	 * heredado de la clase Container.<P>
	 * En este metodo se dibuja la imagen con la posicion actualizada,
	 * ademas que cuando la imagen es cargada te despliega una advertencia.
	 * @param g es el <code>objeto grafico</code> usado para dibujar.
	 */
	public void paint1(Graphics g){
            
            if(principal != null){
                g.drawImage(principal.getAnimacion().getImagen(), principal.getPosX(),principal.getPosY(), this);
            }
            else {

                 //Da un mensaje mientras se carga el dibujo
                 g.drawString("No se cargo la imagen..",20,20);
            }
         }
        
        /**
     * Metodo <I>keyPressed</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar cualquier la
     * tecla.
     *
     * @param e es el <code>evento</code> generado al presionar las teclas.
     */
    public void keyPressed(KeyEvent e) {
        
            
        
    }

    /**
     * Metodo <I>keyTyped</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una tecla que
     * no es de accion.
     *
     * @param e es el <code>evento</code> que se genera en al presionar las
     * teclas.
     */
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Metodo <I>keyReleased</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla
     * presionada.
     *
     * @param e es el <code>evento</code> que se genera en al soltar las teclas.
     */
    public void keyReleased(KeyEvent e) {
        
    }
}
