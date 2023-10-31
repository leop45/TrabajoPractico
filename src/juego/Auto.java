package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Auto {
	// Variables de instancia
	double x;
	double y;
	int direccion;
	double ancho;
	double alto;
	double escala;
	Image[] img;

	
	//constructor
	public Auto(double x, double y) {
		this.x = x;
		this.y = y;
		this.escala=0.14;
		this.direccion = 0;
		this.img = new Image[4];

		for (int i=0; i < img.length ; i++) {
			img[i] = Herramientas.cargarImagen("auto"+i+".png");	
		}

		this.ancho=img[0].getWidth(null)*this.escala;
		this.alto=img[0].getHeight(null)*this.escala;
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

        if (this.x>790) {
            x=790;
        }
        if (this.x<48) {
            x=48;
        }
        if(this.y>550) {
            y=550;
        }
        if(this.y<50) {
            y=50;
        }
    }
	
	public int choque(Auto autito){
        if (autito.x>=790){
            return 1;
        }
        if (autito.x<=48){
            return 2;
        }
        if(autito.y<=50){
            return 3;
        }
        if(autito.y>=550){
            return 4;
        }
        else{
            return 0;
        }
    }

	public int colisionAuto (Auto m, Perro1 a, int movAuto) {
		if (movAuto==1 || movAuto==3){
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
    }
        if (movAuto==0 || movAuto==2){
			double zona1 = m.x-(m.ancho-20); //zona izquieda manzana
			double zona3 = m.x+(m.ancho-20); //zona derecha manzana
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
    }
        return 5;
    }

	public int colisionAuto (Auto m, Perro2 a, int movAuto) {
		if (movAuto==1 || movAuto==3){
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
    }
        if (movAuto==0 || movAuto==2){
			double zona1 = m.x-(m.ancho-20); //zona izquieda manzana
			double zona3 = m.x+(m.ancho-20); //zona derecha manzana
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
    }
        return 5;
    }

}
