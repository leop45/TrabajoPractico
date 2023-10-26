package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Auto {
	// Variables de instancia
	double x;
	double y;
	int direccion;
	Image[] img;

	
	//constructor
	public Auto(double x, double y) {
		this.x = x;
		this.y = y;
		this.direccion = 0;
		this.img = new Image[4];
		
		for (int i=0; i < img.length ; i++) {
			img[i] = Herramientas.cargarImagen("auto"+i+".png");	
		}
	}
	
	public void dibujarse(Entorno entorno)
	{
		entorno.dibujarImagen(img[this.direccion], this.x, this.y, 0, 0.14);
	}
	
	
	public void mover(int d)
	{
		this.direccion=d;
		
		if (direccion ==0)
		{
			y--;	
		}
		if (direccion ==1)
		{
			x+=2;	
		}
		if (direccion ==2)
		{
			y++;	
		}
		if (direccion ==3)
		{
			x+=2;	
		}
		
		if (this.x>790) {
			x=790;
		}
		if (this.x<48) {
			x=48;
		}
		if(this.y>650) {
			y=-50;
		}
		if(this.y<-50) {
			y=650;
		}
	}
	
}
