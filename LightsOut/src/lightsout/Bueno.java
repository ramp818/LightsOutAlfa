package lightsout;

import java.awt.Image;
public class Bueno extends Base{
    
        /**
	 * Metodo constructor que hereda los atributos de la clase <code>Universo</code>.
	 * @param posX es la <code>posiscion en x</code> del objeto Planeta.
	 * @param posY es el <code>posiscion en y</code> del objeto Planeta.
	 * @param image es la <code>imagen</code> del objeto Planeta.
	 */
       static final String PAUSADO="PAUSADO";
       static final String DESAPARECE="DESAPARECE";
       
	public Bueno(int posX,int posY,Animacion image){
		super(posX,posY,image);	
	}

    /**
     *
     * @return
     */
    public String getPausa(){
            return PAUSADO;
        }
    
    public String getDesaparece(){
        return DESAPARECE;
    }
}
