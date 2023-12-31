package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
    double x;
    double y;
    int direccion;
    double ancho;
    double alto;
    double escala;
    Image[] img;
    int horizontal;
    int vertical;
    boolean debeEliminarse;

    public Planta(double x, double y) {
        this.escala = 0.1;
        this.x = x;
        this.y = y;
        this.direccion = 0;
        this.img = new Image[4];

        for (int i = 0; i < img.length; i++) {
            img[i] = Herramientas.cargarImagen("planta" + i + ".png");
        }

        this.ancho = img[0].getWidth(null) * this.escala;
        this.alto = img[0].getHeight(null) * this.escala;
        this.horizontal = 1;
        this.vertical = 0;
        this.debeEliminarse = false;
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(img[this.direccion], this.x, this.y, 0, 0.2);
    }

    public void eliminar(){
        this.debeEliminarse = true;
    }

    public void mover(int d, Planta plantita) {
        this.direccion = d;
        if (direccion == 0) {
            y -= 0.9;
        }
        if (direccion == 1) {
            x += 0.9;
        }
        if (direccion == 2) {
            y += 0.9;
        }
        if (direccion == 3) {
            x -= 0.9;
        }
    }

    public int choque(Planta plantita) {

        if (plantita.x >= 810) {
            return 1;
        }
        if (plantita.x <= 53) {
            return 2;
        } else{
            return 0;
        }

    }

    public int colisionPlanta(Planta m, Perro1 a) {
        double zona1 = m.x - (m.ancho / 2); // zona izquieda manzana
        double zona3 = m.x + (m.ancho / 2); // zona derecha manzana
        double zona2 = m.y - (m.alto / 2); // zona arriba manzana
        double zona0 = m.y + (m.alto / 2); // zona abajo manzana

        if (a.y > zona2 && a.y < zona0 && a.x > zona1 && a.x < zona3) {
            return 1;
        }

        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 2;
        }
        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 0;
        }
        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 3;
        }
        return 5;
    }

    public int colisionPlanta(Planta m, Perro2 a) {
        double zona1 = m.x - (m.ancho / 2); // zona izquieda manzana
        double zona3 = m.x + (m.ancho / 2); // zona derecha manzana
        double zona2 = m.y - (m.alto / 2); // zona arriba manzana
        double zona0 = m.y + (m.alto / 2); // zona abajo manzana

        if (a.y > zona2 && a.y < zona0 && a.x > zona1 && a.x < zona3) {
            return 1;
        }

        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 2;
        }
        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 0;
        }
        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 3;
        }
        return 5;
    }

    public int colisionPlanta(Planta m, RayoP1 a) {
        double zona1 = m.x - (m.ancho / 2); // zona izquieda manzana
        double zona3 = m.x + (m.ancho / 2); // zona derecha manzana
        double zona2 = m.y - (m.alto / 2); // zona arriba manzana
        double zona0 = m.y + (m.alto / 2); // zona abajo manzana

        if (a.y > zona2 && a.y < zona0 && a.x > zona1 && a.x < zona3) {
            return 1;
        }

        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 2;
        }
        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 0;
        }
        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 3;
        }
        return 5;
    }

    public int colisionPlanta(Planta m, RayoP2 a) {
        double zona1 = m.x - (m.ancho / 2); // zona izquieda manzana
        double zona3 = m.x + (m.ancho / 2); // zona derecha manzana
        double zona2 = m.y - (m.alto / 2); // zona arriba manzana
        double zona0 = m.y + (m.alto / 2); // zona abajo manzana

        if (a.y > zona2 && a.y < zona0 && a.x > zona1 && a.x < zona3) {
            return 1;
        }

        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 2;
        }
        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 0;
        }
        if (a.x > zona1 && a.x < zona3 && a.y > zona2 && a.y < zona0) {
            return 3;
        }
        return 5;
    }

    public void disparar(Planta plantita, Bolafuego fueguito) {
        fueguito.actualizar(plantita);
    }
}