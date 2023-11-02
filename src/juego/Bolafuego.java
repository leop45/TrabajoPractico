package juego;

import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Bolafuego {

    double x;
	double y;
    int direccion;
	double ancho;
	double alto;
	double escala;
	Image[] img;
    	
    //constructor
	public Bolafuego(double x, double y) {
		this.x = x;
		this.y = y;
        this.direccion = 0;
		this.escala=0.07;
		this.img = new Image[4];
		for (int i=0; i < img.length ; i++) {
            img[i] = Herramientas.cargarImagen("bolaFuego"+i+".png");
    }
		this.ancho=img[0].getWidth(null)*this.escala;
		this.alto=img[0].getHeight(null)*this.escala;
	}

	public void dibujar(Entorno entorno){
		entorno.dibujarImagen(img[this.direccion], this.x, this.y, 0, 0.07);
	}

	public void mover(Bolafuego fueguito){
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
			fueguito = null;
		}
		if (this.x<24) {
			fueguito = null;
		}
		if(this.y>582) {
			fueguito = null;
		}
		if(this.y<16) {
			fueguito = null;
		}
	}

	public void actualizar(Planta plantita){
		this.x = plantita.x;
		this.y = plantita.y;
		this.direccion = plantita.direccion;
	}
	
	public int TiempoRandom(){
		Random generadorAleatorio = new Random();

        int minimo = 1;
        int maximo = 400;

        int numeroAleatorio = generadorAleatorio.nextInt(maximo - minimo + 1) + minimo;
		int numeroAleatorio2 = generadorAleatorio.nextInt(maximo - minimo + 1) + minimo;

		if (numeroAleatorio>numeroAleatorio2){
			return numeroAleatorio;
		}
		else{
			return numeroAleatorio2;
		}
		
	}

	public int colisionFuego (Bolafuego m, Perro1 a) {
		double zona1 = m.x-(m.ancho); //zona izquieda manzana
		double zona3 = m.x+(m.ancho); //zona derecha manzana
		double zona2 = m.y-(m.alto/2-25); //zona arriba manzana
		double zona0 = m.y+(m.alto/2-25);  //zona abajo manzana
	   
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

    public int colisionFuego (Bolafuego m, Perro2 a) {
		double zona1 = m.x-(m.ancho); //zona izquieda manzana
		double zona3 = m.x+(m.ancho); //zona derecha manzana
		double zona2 = m.y-(m.alto/2-25); //zona arriba manzana
		double zona0 = m.y+(m.alto/2-25);  //zona abajo manzana
	   
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

	public int colisionFuego (Bolafuego m, RayoP1 a) {
		double zona1 = m.x-(m.ancho); //zona izquieda manzana
		double zona3 = m.x+(m.ancho); //zona derecha manzana
		double zona2 = m.y-(m.alto/2-25); //zona arriba manzana
		double zona0 = m.y+(m.alto/2-25);  //zona abajo manzana
	   
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

}
