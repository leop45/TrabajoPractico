package juego;

import java.awt.Color;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	Perro perrito;
	Manzana[] manzanitas;
	Rayo rayito;
	Planta plantita;
    Planta plantita2;
    Bolafuego fueguito;
	
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Prueba del Entorno", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		perrito=new Perro(400,570);
		rayito = new Rayo (perrito.x, perrito.y);
		manzanitas = new Manzana [6];
		plantita = new Planta(550, 390);
        plantita2 = new Planta(250, 190);
        fueguito = new Bolafuego(400, 390);
		int posXManzana= 100;
		int posYManzana= 100;
		for(int i = 0; i<manzanitas.length; i++) {
			manzanitas[i] = new Manzana(posXManzana,posYManzana);
			if(posXManzana <= entorno.ancho()-100) {
				posXManzana += 300;
			}
			if(posXManzana > entorno.ancho()-100) {
				posXManzana = 100;
				posYManzana += 330;
			}
			
		}

		// Inicia el juego!
		this.entorno.iniciar();
	}
	
	public int colisionMultiple(Manzana[] m, Perro a) {
		for(int i= 0; i<m.length; i++) {
			if(colision(m[i],a) != 5) {
				return colision(m[i],a);
			}
		}
		return 5;
		
	}

	public int colision (Manzana m, Perro a) {
		double zona1 = m.x-(m.ancho/2); //zona izquieda manzana
		double zona3 = m.x+(m.ancho/2); //zona derecha manzana
		double zona2 = m.y-(m.alto/2); //zona arriba manzana
		double zona0 = m.y+(m.alto/2);  //zona abajo manzana
		
		
		if(a.y > zona2 && a.y < zona0 && a.x>zona1-24 && a.x<zona3) {
			return 1;
		}
		
		if(a.x > zona1 && a.x < zona3 && a.y>zona2-24 && a.y<zona0) {
			return 2;
		}
		if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0+24) {
			return 0;
		}
		if(a.x > zona1 && a.x < zona3+24 && a.y>zona2 && a.y<zona0) {
			return 3;
		}
		return 5;
		
	}
	
	public void dibujarManzanas(Manzana[] manzanas) {
		for(int i=0; i<manzanitas.length; i++) {
			manzanitas[i].dibujarse(this.entorno);
		}
	}

	int mov=1;
    int mov2=3;

	// public void dibujarRayo() {
	// 	rayo.dibujarse(this.entorno);
	// }

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */

	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...
		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA) && colisionMultiple(manzanitas,perrito)!=1 ) {
			perrito.mover(1);
		}
		
		else if (entorno.estaPresionada(entorno.TECLA_ARRIBA) && colisionMultiple(manzanitas,perrito)!=0) {
			perrito.mover(0);
		}	
		
		else if (entorno.estaPresionada(entorno.TECLA_ABAJO) && colisionMultiple(manzanitas,perrito)!=2) {
			perrito.mover(2);
		}
		
		else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && colisionMultiple(manzanitas,perrito)!=3) {
			perrito.mover(3);
		}
		
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)){
			rayito.actualizar(perrito.x, perrito.y);
			rayito.disparar();
		}

		plantita.mover(mov);
        if (plantita.x<=400){
            fueguito.dibujarse(this.entorno);
            fueguito.mover(3);
            if(fueguito.x==53){

            }
        }
        if(plantita.x==745){
            mov=3;
            plantita.mover(mov);
        }
        if(plantita.x==53){
            mov=1;
            plantita.mover(mov);
        }

        plantita2.mover(mov2);
        if(plantita2.x==53){
            mov2=1;
            plantita2.mover(mov2);
        }
        if(plantita2.x==745){
            mov2=3;
            plantita2.mover(mov2);
        }

		rayito.dibujar(entorno);
		rayito.mover(perrito.direccion);
		
		dibujarManzanas(manzanitas);
		perrito.dibujarse(this.entorno);
		plantita.dibujarse(this.entorno);
		plantita2.dibujarse(this.entorno);
		
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("Puntos:",600, 30);
		entorno.escribirTexto("posicion en x:" + perrito.x, 600, 50);
		entorno.escribirTexto("posicion en y:" + perrito.y, 600, 100);
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
