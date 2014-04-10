package lightsout;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Level1 extends JFrame implements Runnable, KeyListener
{
    private static final long serialVersionUID = 1L;
    // Se declaran las variables.
    private Graphics dbg;	// Objeto grafico
    private Image dbImage;	// Imagen a proyectar
    private SoundClip fondo;
    private long tiempoActual;
    private long tiempoInicial;
    private Animacion animBuenoF;
    private Animacion animBuenoA;
    private Animacion animBuenoD;
    private Animacion animBuenoI;
    private Animacion animMalo;
    private Bueno principal;
    private Malo fantasma;
    private int direccion=0;
    private int vidas;
    private int score;
    private boolean pausa;
    
    
    public Level1()
    {
                direccion = 0;
                vidas=3;
                score=0;
                Image frente0 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/frente0.png"));
		Image frente1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/frente1.png"));
                Image frente2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/frente2.png"));
                Image atras0 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/atras0.png"));
                Image atras1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/atras1.png"));
                Image atras2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/atras2.png"));
                Image derecha0 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/derecha0.png"));
                Image derecha1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/derecha1.png"));
                Image derecha2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/derecha2.png"));
                Image izquierda0 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/izquierda0.png"));
                Image izquierda1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/izquierda1.png"));
                Image izquierda2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/izquierda2.png"));
		
		//Se crea la animación Frente
		animBuenoF = new Animacion();
		animBuenoF.sumaCuadro(frente0, 100);
                animBuenoF.sumaCuadro(frente1, 100);
                animBuenoF.sumaCuadro(frente2, 100);
                
                //Se crea la animación Atras
		animBuenoA = new Animacion();
		animBuenoA.sumaCuadro(atras0, 100);
                animBuenoA.sumaCuadro(atras1, 100);
                animBuenoA.sumaCuadro(atras2, 100);
                
                //Se crea la animación Derecha
		animBuenoD = new Animacion();
		animBuenoD.sumaCuadro(derecha0, 100);
                animBuenoD.sumaCuadro(derecha1, 100);
                animBuenoD.sumaCuadro(derecha2, 100);
                
                //Se crea la animación Izquierda
		animBuenoI = new Animacion();
		animBuenoI.sumaCuadro(izquierda0, 100);
                animBuenoI.sumaCuadro(izquierda1, 100);
                animBuenoI.sumaCuadro(izquierda2, 100);
                
                // se carg personaje
                principal= new Bueno(400,500,animBuenoA);
                
                //Pinta el fondo del Applet de color blanco		
		setBackground(Color.white);
                setSize(1200,800);
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
		while (true){
                    if(!pausa){
			actualiza();

			//checaColision();
			repaint();    // Se actualiza el <code>Applet</code> repintando el contenido.


			//checaColision();

			//checaColision(); 
                        // Se actualiza el <code>Applet</code> repintando el contenido.

			checaColision();
                    }
			repaint();    // Se actualiza el <code>Applet</code> repintando el contenido.
                        // Se actualiza el <code>Applet</code> repintando el contenido.

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
            
            if(!pausa){
            long tiempoTranscurrido= System.currentTimeMillis() - tiempoActual;
            tiempoActual += tiempoTranscurrido;
            
            
            switch(direccion){
                    case 1: {
                        principal= new Bueno(principal.getPosX(),principal.getPosY(),animBuenoD);
                        principal.setPosX(principal.getPosX() + 2);
                        animBuenoD.actualiza(tiempoTranscurrido);
                        break;
                    }
                    case 2: {
                        principal= new Bueno(principal.getPosX(),principal.getPosY(),animBuenoI);
                        principal.setPosX(principal.getPosX() - 2);
                        animBuenoI.actualiza(tiempoTranscurrido);
                        break;
                    }
                    case 3: {
                        principal= new Bueno(principal.getPosX(),principal.getPosY(),animBuenoA);
                        principal.setPosY(principal.getPosY() - 2);
                        animBuenoA.actualiza(tiempoTranscurrido);
                        break;
                    }
                    case 4: {
                        principal= new Bueno(principal.getPosX(),principal.getPosY(),animBuenoF);
                        principal.setPosY(principal.getPosY() + 2);
                        animBuenoF.actualiza(tiempoTranscurrido);
                        break;
                    }
		 
            }
        }
       }
       
        /**
	 * Metodo usado para checar las colisiones del objeto planeta y meteorito
	 * con las orillas del <code>Applet</code>.
	 */
	public void checaColision() {
		
                if (principal.getPosX() + principal.getAncho() > getWidth()) {
                     principal.setPosX(getWidth()-principal.getAncho());
                }
                 
                if (principal.getPosX() < 0) {
			principal.setPosX(0);
		}
                
		if (principal.getPosY() + principal.getAlto() > getHeight()) {
			principal.setPosY(getHeight()-principal.getAlto());
		}
                
                if (principal.getPosY() < 0) {
                     principal.setPosY(0);  
                }
                 
		 
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
                g.drawString("Vidas: " + vidas, 50, 50);
                g.drawString("Score: " + score, 50, 70);
            }
            else {

                 //Da un mensaje mientras se carga el dibujo
                 g.drawString("No se cargo la imagen..",20,20);
            }
            if(pausa){
                
                g.drawString("PAUSA", 450, 250);
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
        
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {    //Presiono flecha derecha
                direccion = 1;
            } 
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {    //Presiono tecla A izquierda
                direccion = 2;
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP){    // presion tecla W hacia arriba
                direccion = 3;
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN){    // presiono tecla S hacia abajo
                direccion = 4;
            }
            else if (e.getKeyCode() == KeyEvent.VK_P){
                
                pausa=!pausa;
            }
        
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
        direccion=0;
    }
}
