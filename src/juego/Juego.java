package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	Perro1 perrito;
	Perro2 perrita;
	Manzana[] manzanitas;
	RayoP1 rayito1;
	RayoP2 rayito2;
	Planta[] plantitas;
	Bolafuego[] fueguitos;
	Auto autito;
	Fondo fondo;
	boolean jugador1;
	boolean jugador2;
	
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
		plantitas = new Planta[6];
		fueguitos = new Bolafuego[6];
		autito = new Auto(116, 518);
		fondo = new Fondo (425, 300);
		jugador1 = true;
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

		int posXPlanta = 24;
		int posYPlanta = 72;
		for(int i = 0; i<plantitas.length; i++) {
			plantitas[i] = new Planta(posXPlanta,posYPlanta);
			if(posXPlanta <= entorno.ancho()-100) {
				posXPlanta += 250;
			}
			if(posXPlanta > entorno.ancho()-100) {
				posXPlanta = 100;
				posYPlanta += 245;
			}
		}

		for(int i = 0; i<fueguitos.length; i++) {
			fueguitos[i] = new Bolafuego(plantitas[i].x,plantitas[i].y);
			fueguitos[i].direccion = 1;
		}

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

	public void dibujarPlantas(Planta[] plantitas) {
		for(int i=0; i<plantitas.length; i++) {
			if(plantitas[i]!=null){
				plantitas[i].dibujarse(this.entorno);
			}
		}
	}

	public void dibujarBolasFuegos(Bolafuego[] fueguitos) {
		for(int i=0; i<fueguitos.length; i++) {
			if(fueguitos[i]!=null){
				fueguitos[i].dibujar(this.entorno);
			}
		}
	}

	int movAuto=1;
	int cont1=0;
	int cont2=0;
	int contMuerte=0;

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


		//COLISION PLANTA CON PERRITO Y PERRITA:
		for (int i = 0; i < plantitas.length; i++){
			if(plantitas[i] != null && plantitas[i].colisionPlanta(plantitas[i], perrito)!=5){
				colisiones=true;
				jugador1 = false;
			}

			if(plantitas[i] != null && rayito1 != null && plantitas[i].colisionPlanta(plantitas[i], rayito1)!=5){
				rayito1 = null;
				plantitas[i] = null;
				if (rayito1 == null){
					rayito1 = new RayoP1 (perrito.x, perrito.y);
				}
			}

			if(plantitas[i] != null && plantitas[i].colisionPlanta(plantitas[i], perrita)!=5){
				colisiones=true;
				jugador2 = false;
			}

			if(plantitas[i] != null && rayito2 != null && plantitas[i].colisionPlanta(plantitas[i], rayito2)!=5){
				rayito2 = null;
				plantitas[i] = null;
				if (rayito2 == null){
					rayito2 = new RayoP2 (perrita.x, perrita.y);
				}
			}
		}



		//COLISION AUTO CON PERRITO:
		if(autito.colisionAuto(autito, perrito, movAuto)!=5){
			colisiones=true;
			jugador1 = false;
		}
		
		//COLISION AUTO CON PERRITA:
		if(autito.colisionAuto(autito, perrita, movAuto)!=5){
			colisiones=true;
			jugador2 = false;
		}

		
		//COLISION BOLA DE FUEGO CON RAYITO1
		for(int i=0; i<fueguitos.length; i++) {
			if(fueguitos[i]!=null && fueguitos[i].colisionFuego(fueguitos[i], rayito1)!=5){
				rayito1 = null;
				rayito1 = new RayoP1 (perrito.x, perrito.y);
				fueguitos[i] = null;
			}
		}

		//COLISION BOLA DE FUEGO CON RAYITO2
		for(int i=0; i<fueguitos.length; i++) {
			if(fueguitos[i]!=null && fueguitos[i].colisionFuego(fueguitos[i], rayito2)!=5){
				rayito2 = null;
				rayito2 = new RayoP2 (perrita.x, perrita.y);
				fueguitos[i] = null;
			}
		}

		//COLISION BOLA DE FUEGO CON PERRO
		for(int i=0; i<fueguitos.length; i++) {
			if(fueguitos[i]!=null && fueguitos[i].colisionFuego(fueguitos[i], perrito)!=5){
				colisiones=true;
				jugador1 = false;
			}
		}

		//COLISION BOLA DE FUEGO CON PERRA
		for(int i=0; i<fueguitos.length; i++) {
			if(fueguitos[i]!=null && fueguitos[i].colisionFuego(fueguitos[i], perrita)!=5){
				colisiones=true;
				jugador2 = false;
			}
		}


		//VERIFICAR MOVIMIENTO DE PERRITO:
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


		//VERIFICAR MOVIMIENTO DE PERRITA:
		if (entorno.estaPresionada('t') && contMuerte==0){
			jugador2 = true;
			contMuerte++;
		}

		if (entorno.estaPresionada('d') && colisionMultiple(manzanitas,perrita)!=1 && jugador2) {
			perrita.mover(1);
		}
			
		else if (entorno.estaPresionada('w') && colisionMultiple(manzanitas,perrita)!=0 && jugador2) {
			perrita.mover(0);
		}	
			
		else if (entorno.estaPresionada('s') && colisionMultiple(manzanitas,perrita)!=2 && jugador2) {
			perrita.mover(2);
		}
			
		else if (entorno.estaPresionada('a') && colisionMultiple(manzanitas,perrita)!=3 && jugador2) {
			perrita.mover(3);
		}
		

		//MOVIMIENTO DE LAS PLANTAS:
		for (int i = 0; i < plantitas.length; i++){
			if (plantitas[i]!=null){
				plantitas[i].mover(plantitas[i].horizontal, plantitas[i]);
				if(plantitas[i].choque(plantitas[i])==1){
					plantitas[i].horizontal=3;
				}
				if(plantitas[i].choque(plantitas[i])==2){
					plantitas[i].horizontal=1;
				}
			}
		}


		//MOVIMIENTO DEL AUTO:
		autito.mover(movAuto);
		if(autito.choque(autito)==1){
		 	movAuto=3;
	 	}
		if(autito.choque(autito)==2){
		 	movAuto=1;
		}

		//MOVIMIENTO DE BOLA DE FUEGO
		for (int i = 0; i < fueguitos.length; i++) {
			if (fueguitos[i]!=null){
				fueguitos[i].mover(fueguitos[i]);
			} else {
				fueguitos[i] = new Bolafuego(plantitas[i].x,plantitas[i].y);
				fueguitos[i].actualizar(plantitas[i]);
			}
		}


		//DISPAROS DE LAS PLANTAS:
		if (cont1==200){
			for (int i = 0; i < plantitas.length; i++) {
				if (plantitas[i] != null){
					plantitas[i].disparar(plantitas[i], fueguitos[i]);
					cont1=0;
				}
			}
		}


		//VERIFICAR SI PERRITO DISPARA:
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)){
			if (rayito1 != null){
				perrito.disparar(perrito, rayito1);
			}
		}


		//VERIFICAR SI PERRITA DISPARA:
		if (entorno.sePresiono('f')){
			if (rayito2 != null){
				perrita.disparar(perrita, rayito2);
			} else {
				rayito2 = new RayoP2 (perrita.x, perrita.y);
			}
		}


		//DIBUJAR OBJETOS EN PANTALLA:
		fondo.dibujarse(entorno);
		dibujarManzanas(manzanitas);

		if (jugador1){
			if (rayito1 != null){
				rayito1.dibujarse(entorno);
				rayito1.mover();
			}
			perrito.dibujarse(this.entorno);
		}

		if(jugador2){
			if (rayito1 != null){
				rayito2.dibujar(entorno);
				rayito2.mover();
			}
			perrita.dibujarse(this.entorno);
		}

		dibujarPlantas(plantitas);
		
		dibujarBolasFuegos(fueguitos);

		autito.dibujarse(this.entorno);
		



		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("Puntos: " + perrito.puntos,600, 30);
		entorno.escribirTexto("posicion en x:" + perrito.x, 600, 50);
		entorno.escribirTexto("posicion en y:" + perrito.y, 600, 100);
		entorno.escribirTexto("colision"+colisiones,600, 70);
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// JFrame frame = new JFrame("Juego");

        // // Configurar la ventana
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLayout(new BorderLayout());

        // // Cargar la imagen de fondo
        // ImageIcon backgroundIcon = new ImageIcon("menu_background.png");
        // JLabel backgroundLabel = new JLabel(backgroundIcon);

        // // Botón "Jugar"
        // JButton jugarButton = new JButton("Jugar");
        // jugarButton.setFont(new Font("Goudy Stout", Font.BOLD, 60));
        // jugarButton.setBackground(Color.orange);
        // jugarButton.setForeground(Color.black);
        // jugarButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         // Coloca aquí la lógica para comenzar el juego
        //         JOptionPane.showMessageDialog(null, "Iniciando el juego");
        //         Juego juego = new Juego();
        //     }
        // });

        // // Botón "Puntajes"
        // JButton puntajesButton = new JButton("Puntajes");
        // puntajesButton.setFont(new Font("Goudy Stout", Font.BOLD, 60));
        // puntajesButton.setBackground(Color.lightGray);
        // puntajesButton.setForeground(Color.black);
        // puntajesButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         // Coloca aquí la lógica para mostrar los puntajes
        //         JOptionPane.showMessageDialog(null, "Mostrando puntajes");
        //     }
        // });

        // // Botón "Salir"
        // JButton salirButton = new JButton("Salir");
        // salirButton.setFont(new Font("Goudy Stout", Font.BOLD, 60));
        // salirButton.setBackground(Color.RED);
        // salirButton.setForeground(Color.black);
        // salirButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         int confirmExit = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir del juego?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        //         if (confirmExit == JOptionPane.YES_OPTION) {
        //             System.exit(0);
        //         }
        //     }
        // });

        // // Agregar componentes a la ventana
        // backgroundLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        // backgroundLabel.add(jugarButton);
        // backgroundLabel.add(puntajesButton);
        // backgroundLabel.add(salirButton);
        // frame.add(backgroundLabel, BorderLayout.CENTER);

        // // Establecer el tamaño de la ventana
        // frame.pack();
        // frame.setSize(850, 600);
        // frame.setVisible(true);
		Juego juego = new Juego();
    }
}
