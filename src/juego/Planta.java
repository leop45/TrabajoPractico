package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
    double x;
    double y;
    int direccion;
    Image[] img;

    public Planta(double x, double y){
        this.x = x;
        this.y = y;
        this.direccion = 0;
        this.img = new Image[4];

        for (int i=0; i < img.length ; i++) {
            img[i] = Herramientas.cargarImagen("planta"+i+".png");
    }
 }
 public void dibujarse(Entorno entorno)
 {
     entorno.dibujarImagen(img[this.direccion], this.x, this.y, 0, 0.2);
 }
 public void mover(int d)
    {
        this.direccion=d;

        if (direccion ==0)
        {
            y-=0.7;
        }
        if (direccion ==1)
        {
            x+=0.7;
        }
        if (direccion ==2)
        {
            y+=0.7;
        }
        if (direccion ==3)
        {
            x-=0.7;
        }

        if (this.x>810) {
            x=810;
        }
        if (this.x<53) {
            x=53;
        }
        if(this.y>545) {
            y=545;
        }
        if(this.y<57) {
            y=57;
        }
    }
}
