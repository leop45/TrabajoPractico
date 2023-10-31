package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Fondo {
	// Variables de instancia
	double x;
	double y;
	Image fondoimg;
    double ancho;
	double alto;
	double escala;
	
	
	public Fondo(double x, double y) {
		this.escala=1;
		this.x = x;
		this.y = y;
		this.fondoimg = Herramientas.cargarImagen("fondo.png");
        this.ancho=fondoimg.getWidth(null)*this.escala;
		this.alto=fondoimg.getHeight(null)*this.escala;
	}
	
	public void dibujarse(Entorno entorno)
	{
		entorno.dibujarImagen(fondoimg, this.x, this.y, 0, this.escala);
	}
}
