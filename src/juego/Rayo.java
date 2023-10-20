package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import juego.Perro;

public class Rayo {
    // Variables de instancia
    double x;
	double y;
    int direccion;
	Image rayoImg;

    	
    //constructor
	public Rayo(double x, double y) {
		this.x = x;
		this.y = y;
        this.direccion = 0;
		this.rayoImg = Herramientas.cargarImagen("rayo.png");
	}

    public void dibujarse(Entorno entorno)
	{
		entorno.dibujarImagen(rayoImg, this.x, this.y, 0, 0.1);
	}

    public void mover(int d)
	{
		this.direccion=d;
		
		if (direccion ==0)
		{
			y-=2;	
		}
		if (direccion ==1)
		{
			x+=2;	
		}
		if (direccion ==2)
		{
			y+=2;	
		}
		if (direccion ==3)
		{
			x-=2;	
		}
		
		if (this.x>774) {
			x=774;
		}
		if (this.x<24) {
			x=24;
		}
		if(this.y>582) {
			y=582;
		}
		if(this.y<28) {
			y=28;
		}
	}
}
