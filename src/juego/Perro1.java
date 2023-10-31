package juego;

import java.awt.Image;
import java.util.LinkedList;
import entorno.Entorno;
import entorno.Herramientas;

public class Perro1 {
	// Variables de instancia
	double x;
	double y;
	int direccion;
	Image[] img;
	int puntos;
	// LinkedList<RayoP1> rayos;
	
	//constructor
	public Perro1(double x, double y) {
		this.x = x;
		this.y = y;
		this.direccion = 0;
		this.img = new Image[4];
		
		for (int i=0; i < img.length ; i++) {
			img[i] = Herramientas.cargarImagen("perrito"+i+".png");	
		}

		this.puntos = 0;
		// this.rayos = new LinkedList<>();
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
		
		if (this.x>825) {
			x=825;
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

	public void disparar(Perro1 perrito, RayoP1 rayito) {
		// RayoP1 nuevoRayito = new RayoP1(perrito.x, perrito.y);
		// rayos.add(nuevoRayito);
		rayito.actualizar(perrito);
		rayito.disparando();
	}

	// public void actualizarDisparos(){
	// 	for (RayoP1 rayito : rayos){
	// 		rayito.actualizar(this.x, this.y, this.direccion);
	// 		rayito.disparando();
	// 	}
	// }

	public void sumarPuntos(){
		this.puntos += 5;
	}
}
