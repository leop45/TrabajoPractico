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
	Auto autito;
	// Rayo[] rayitos;
	
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Prueba del Entorno", 850, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		perrito=new Perro(424,570);
		rayito = new Rayo (perrito.x, perrito.y);
		manzanitas = new Manzana [6];
		// rayitos = new Rayo[45];
		plantita = new Planta(550, 33);
        plantita2 = new Planta(250, 272);
        fueguito = new Bolafuego(400, 33);
		autito = new Auto(116, 518);
		int posXManzana= 100;
		int posYManzana= 128;
		for(int i = 0; i<manzanitas.length; i++) {
			manzanitas[i] = new Manzana(posXManzana+75,posYManzana+50);
			if(posXManzana <= entorno.ancho()-100) {
				posXManzana += 250;
			}
			if(posXManzana > entorno.ancho()-100) {
				posXManzana = 100;
				posYManzana += 245;
			}
		}

		// for (int i = 0; i < rayitos.length; i++){
		// 	rayitos[i] = new Rayo(perrito.x, perrito.y);
		// }

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

	public void dibujarRayos(Rayo[] rayitos) {
		for(int i=0; i<rayitos.length; i++) {
			rayitos[i].dibujarse(this.entorno);
		}
	}

	int mov=1;
    int mov2=3;
	//int movAuto=3;

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
		// autito.mover(movAuto);
		// if(autito.x==790){
        //     movAuto=3;
		// }
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
		

		plantita.mover(mov);
        // if (plantita.x<=400){
        //     fueguito.dibujarse(this.entorno);
        //     fueguito.mover(3);
        // }
        if(plantita.x==810){
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
        if(plantita2.x==810){
            mov2=3;
            plantita2.mover(mov2);
        }

		if (entorno.sePresiono(entorno.TECLA_ESPACIO)){
			perrito.disparar(perrito, rayito);
			// perrito.disparar(perrito, rayitos);
			// for (int i = 0; i < rayitos.length; i++){
			// 	perrito.disparar(perrito, rayitos[i]);
			// }
		}
		


		
		dibujarManzanas(manzanitas);
		// dibujarRayos(rayitos);
		// for (int i = 0; i < rayitos.length; i++){
		// 	rayitos[i].mover();
		// }
		rayito.dibujarse(entorno);
		rayito.mover();
		perrito.dibujarse(this.entorno);
		plantita.dibujarse(this.entorno);
		plantita2.dibujarse(this.entorno);
		// autito.dibujarse(this.entorno);
		



		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("Puntos: " + perrito.puntos,600, 30);
		entorno.escribirTexto("posicion en x:" + perrito.x, 600, 50);
		entorno.escribirTexto("posicion en y:" + perrito.y, 600, 100);
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
