package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Perro {
	// Variables de instancia
	double x;
	double y;
	int direccion;
	Image[] img;

	
	//constructor
	public Perro(double x, double y) {
		this.x = x;
		this.y = y;
		this.direccion = 0;
		this.img = new Image[4];
		
		for (int i=0; i < img.length ; i++) {
			img[i] = Herramientas.cargarImagen("perrito"+i+".png");	
		}
	}
	
	public void dibujarse(Entorno entorno)
	{
		entorno.dibujarImagen(img[this.direccion], this.x, this.y, 0, 0.7);
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
		
		if (this.x>850) {
			x=-50;
		}
		if (this.x<-50) {
			x=850;
		}
		if(this.y>650) {
			y=-50;
		}
		if(this.y<-50) {
			y=650;
		}
	}
}
