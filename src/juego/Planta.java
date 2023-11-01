package juego;

import java.awt.Image;
import java.security.PublicKey;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
    double x;
    double y;
    int direccion;
    double ancho;
	double alto;
    double escala;
    Image[] img;
    boolean aparece;

    public Planta(double x, double y){
        this.escala=0.2;
        this.x = x;
        this.y = y;
        this.direccion = 0;
        this.img = new Image[4];

        for (int i=0; i < img.length ; i++) {
            img[i] = Herramientas.cargarImagen("planta"+i+".png");

        this.aparece = true;
    }

    this.ancho=img[0].getWidth(null)*this.escala;
	this.alto=img[0].getHeight(null)*this.escala;
 }
    public void dibujarse(Entorno entorno) {
        if (this.aparece){
            entorno.dibujarImagen(img[this.direccion], this.x, this.y, 0, 0.2);
        }
    }
 public void mover(int d)
    {
        if(this.aparece){
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

    public int choque(Planta plantita){
        if (plantita.x>=810){
            return 1;
        }
        if (plantita.x<=53){
            return 2;
        }
        else{
            return 0;
        }
    }

    public int colisionPlanta (Planta m, Perro1 a) {
        double zona1 = m.x-(m.ancho/2); //zona izquieda manzana
        double zona3 = m.x+(m.ancho/2); //zona derecha manzana
        double zona2 = m.y-(m.alto/2); //zona arriba manzana
        double zona0 = m.y+(m.alto/2);  //zona abajo manzana
       
        if(a.y > zona2 && a.y < zona0 && a.x>zona1 && a.x<zona3) {
            return 1;
        }
       
        if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0) {
            return 2;
        }
        if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0) {
            return 0;
        }
        if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0) {
            return 3;
        }
        return 5;
    }

    public int colisionPlanta (Planta m, Perro2 a) {
        double zona1 = m.x-(m.ancho/2); //zona izquieda manzana
        double zona3 = m.x+(m.ancho/2); //zona derecha manzana
        double zona2 = m.y-(m.alto/2); //zona arriba manzana
        double zona0 = m.y+(m.alto/2);  //zona abajo manzana
       
        if(a.y > zona2 && a.y < zona0 && a.x>zona1 && a.x<zona3) {
            return 1;
        }
       
        if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0) {
            return 2;
        }
        if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0) {
            return 0;
        }
        if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0) {
            return 3;
        }
        return 5;
    }

    public int colisionPlanta (Planta m, RayoP1 a) {
        double zona1 = m.x-(m.ancho/2); //zona izquieda manzana
        double zona3 = m.x+(m.ancho/2); //zona derecha manzana
        double zona2 = m.y-(m.alto/2); //zona arriba manzana
        double zona0 = m.y+(m.alto/2);  //zona abajo manzana
       
        if(a.y > zona2 && a.y < zona0 && a.x>zona1 && a.x<zona3) {
            return 1;
        }
       
        if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0) {
            return 2;
        }
        if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0) {
            return 0;
        }
        if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0) {
            return 3;
        }
        return 5;
    }

    public void disparar(Planta plantita, Bolafuego fueguito) {
		fueguito.actualizar(plantita);
		fueguito.disparando();
        if (plantita.aparece == false){
            fueguito.disparando = false;
        }
	}
}