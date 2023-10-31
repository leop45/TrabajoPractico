package juego;

import java.awt.Color;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	Perro1 perrito;
	Perro2 perrita;
	Manzana[] manzanitas;
	RayoP1 rayito1;
	RayoP2 rayito2;
	Planta plantita1;
    Planta plantita2;
    Bolafuego fueguito1;
	Bolafuego fueguito2;
	Auto autito;
	Fondo fondo;
	boolean jugador2;
	// Rayo[] rayitos;
	
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Prueba del Entorno", 850, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		perrito=new Perro1(424,570);
		perrita=new Perro2(424,570);
		rayito1 = new RayoP1 (perrito.x, perrito.y);
		rayito2 = new RayoP2 (perrita.x, perrita.y);
		manzanitas = new Manzana [6];
		// rayitos = new Rayo[45];
		plantita1 = new Planta(550, 33);
        plantita2 = new Planta(250, 272);
        fueguito1 = new Bolafuego(plantita1.x-20, plantita1.y+20);
		fueguito2 = new Bolafuego(plantita2.x-20, plantita2.y+20);
		autito = new Auto(116, 518);
		fondo = new Fondo (425, 300);
		jugador2 = false;
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
	
	public int colisionMultiple(Manzana[] m, Perro1 a) {
		for(int i= 0; i<m.length; i++) {
			if(colision(m[i],a) != 5) {
				return colision(m[i],a);
			}
		}
		return 5;
	}

	public int colisionMultiple(Manzana[] m, Perro2 a) {
		for(int i= 0; i<m.length; i++) {
			if(colision(m[i],a) != 5) {
				return colision(m[i],a);
			}
		}
		return 5;
	}

	public int colision (Manzana m, Perro1 a) {
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

	public int colision (Manzana m, Perro2 a) {
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

	public void dibujarRayos(RayoP1[] rayitos) {
		for(int i=0; i<rayitos.length; i++) {
			rayitos[i].dibujarse(this.entorno);
		}
	}

	int mov1=1;
    int mov2=3;
	int movAuto=1;
	int cont1=0;
	int cont2=0;

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
		cont1++;
		cont2+=2;
		boolean colisiones=false;
		autito.mover(movAuto);
        if(autito.choque(autito)==1){
            movAuto=3;
        }
        if(autito.choque(autito)==2){
            movAuto=1;
        }
        if(autito.choque(autito)==3){
            movAuto=2;
        }
        if(autito.choque(autito)==4){
            movAuto=0;
        }

		if(autito.colisionAuto(autito, perrito, movAuto)!=5){
			colisiones=true;
		}

		if(plantita1.colisionPlanta(plantita1, perrito)!=5){
			colisiones=true;
		}

		if(fueguito1.colisionFuego(fueguito1, perrito)!=5){
			colisiones=true;
		}

		if(plantita1.colisionPlanta(plantita2, perrito)!=5){
			colisiones=true;
		}

		if(fueguito1.colisionFuego(fueguito2, perrito)!=5){
			colisiones=true;
		}

		if(autito.colisionAuto(autito, perrita, movAuto)!=5){
			colisiones=true;
		}

		if(plantita1.colisionPlanta(plantita1, perrita)!=5){
			colisiones=true;
		}

		if(fueguito1.colisionFuego(fueguito1, perrita)!=5){
			colisiones=true;
		}

		if(plantita1.colisionPlanta(plantita2, perrita)!=5){
			colisiones=true;
		}

		if(fueguito1.colisionFuego(fueguito2, perrita)!=5){
			colisiones=true;
		}

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

		if (entorno.estaPresionada('d') && colisionMultiple(manzanitas,perrita)!=1 ) {
			jugador2 = true;
			perrita.mover(1);
		}
			
		else if (entorno.estaPresionada('w') && colisionMultiple(manzanitas,perrita)!=0) {
			jugador2 = true;
			perrita.mover(0);
		}	
			
		else if (entorno.estaPresionada('s') && colisionMultiple(manzanitas,perrita)!=2) {
			jugador2 = true;
			perrita.mover(2);
		}
			
		else if (entorno.estaPresionada('a') && colisionMultiple(manzanitas,perrita)!=3) {
			jugador2 = true;
			perrita.mover(3);
		}
		

		plantita1.mover(mov1);
		if(plantita1.choque(plantita1)==1){
			mov1=3;
		}
		if(plantita1.choque(plantita1)==2){
			mov1=1;
		}

		plantita2.mover(mov2);
		if(plantita2.choque(plantita2)==1){
			mov2=3;
		}
		if(plantita2.choque(plantita2)==2){
			mov2=1;
		}

		autito.mover(movAuto);
		if(autito.choque(autito)==1){
		 	movAuto=3;
	 	}
		if(autito.choque(autito)==2){
		 	movAuto=1;
		}

		if (entorno.sePresiono(entorno.TECLA_ESPACIO)){
			perrito.disparar(perrito, rayito1);
		}

		if (cont1==200){
			plantita1.disparar(plantita1, fueguito1);
			cont1=0;
		}

		if (cont2==350){
			plantita1.disparar(plantita2, fueguito2);
			cont2=0;
		}

		if (entorno.sePresiono(entorno.TECLA_ESPACIO)){
			perrito.disparar(perrito, rayito1);
			// perrito.disparar(perrito);
			// perrito.actualizarDisparos();
			// perrito.disparar(perrito, rayitos);
			// for (int i = 0; i < rayitos.length; i++){
			// 	perrito.disparar(perrito, rayitos[i]);
			// }
		}

		if (entorno.sePresiono('f')){
			perrita.disparar(perrita, rayito2);
		}

		


		fondo.dibujarse(entorno);
		dibujarManzanas(manzanitas);
		// dibujarRayos(rayitos);
		// for (int i = 0; i < rayitos.length; i++){
		// 	rayitos[i].mover();
		// }
		// for (RayoP1 rayito : perrito.rayos){
		// 	rayito.dibujarse(entorno);
		// 	rayito.mover();
		// }
		
		rayito1.dibujarse(entorno);
		rayito1.mover();

		if(jugador2){
			rayito2.dibujar(entorno);
			rayito2.mover();
			perrita.dibujarse(this.entorno);
		}

		perrito.dibujarse(this.entorno);
		plantita1.dibujarse(this.entorno);
		plantita2.dibujarse(this.entorno);
		fueguito1.dibujar(entorno);
		fueguito1.mover();
		fueguito2.dibujar(entorno);
		fueguito2.mover();
		autito.dibujarse(this.entorno);
		



		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("Puntos: " + perrito.puntos,600, 30);
		entorno.escribirTexto("posicion en x:" + perrito.x, 600, 50);
		entorno.escribirTexto("posicion en y:" + perrito.y, 600, 100);
		entorno.escribirTexto("colision"+colisiones,600, 70);
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
