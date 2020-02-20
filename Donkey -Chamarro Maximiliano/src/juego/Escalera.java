package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Escalera {

	private double x;
	private double y;
	private double Ancho;
	private double Alto;
	private Image escaleraImagen;
	

	Escalera(double x, double y, double ancho, double alto) {
		this.x = x;
		this.y = y;
		this.Ancho = ancho;
		this.Alto = alto;
		this.escaleraImagen = Herramientas.cargarImagen("escalera.jpg");

	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(escaleraImagen, this.x, this.y, 0, 1.5);
		
	}

	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getAncho() {
		return this.Ancho;
	}

	public double getAlto() {
		return this.Alto;
	}
	public Image getEscaleraImagen() {
		return this.escaleraImagen;
	}
}
