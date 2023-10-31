package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class RayoP2 {
    // Variables de instancia
    double x;
    double y;
    int direccion;
    Image rayoImg;
    // boolean disparando;
    String disparando;
        
    //constructor
    public RayoP2(double x, double y) {
        this.x = x;
        this.y = y;
        this.direccion = 0;
        this.rayoImg = Herramientas.cargarImagen("rayo2.png");
        this.disparando = null;
    }

    public void disparando() {
        disparando = "1";
    }

    public void dibujar(Entorno entorno){
        if (disparando == "1"){
            entorno.dibujarImagen(rayoImg, this.x, this.y, 0, 0.1);
        }
    }

    public void mover(){
        if (this.disparando == "1"){
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
                disparando = null;
            }
            if (this.x<24) {
                disparando = null;
            }
            if(this.y>582) {
                disparando = null;
            }
            if(this.y<16) {
                disparando = null;
            }
        }
    }

    public void actualizar(Perro2 perra){
        this.x = perra.x;
        this.y = perra.y;
        this.direccion = perra.direccion;
    }
}
