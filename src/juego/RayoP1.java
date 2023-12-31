package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class RayoP1 {
    // Variables de instancia
    double x;
	double y;
    int direccion;
	Image rayoImg;
	boolean disparando;
    	
    //constructor
	public RayoP1(double x, double y) {
		this.x = x;
		this.y = y;
        this.direccion = 0;
		this.rayoImg = Herramientas.cargarImagen("rayo.png");
		this.disparando = false;
	}

	public void disparando() {
        this.disparando = true;
    }

	public void dibujarse(Entorno entorno){
		if (this.disparando){
			entorno.dibujarImagen(rayoImg, this.x, this.y, 0, 0.1);
		}
	}

	public void mover(){
		if (this.disparando){
			if (this.direccion == 0) {
                // Mover el rayo hacia arriba
                y -= 4.5;
            } else if (this.direccion == 1) {
                // Mover el rayo hacia la derecha
                x += 4.5;
            } else if (this.direccion == 2) {
                // Mover el rayo hacia abajo
                y += 4.5;
            } else if (this.direccion == 3) {
                // Mover el rayo hacia la izquierda
                x -= 4.5;
            }

			if (this.x>829) {
				disparando = false;
			}
			if (this.x<24) {
				disparando = false;
			}
			if(this.y>582) {
				disparando = false;
			}
			if(this.y<16) {
				disparando = false;
			}
		}
	}

	public void actualizar(Perro1 perrito){
		this.x = perrito.x;
		this.y = perrito.y;
		this.direccion = perrito.direccion;
	}
	
}
