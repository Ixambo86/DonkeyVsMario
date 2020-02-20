package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Herramientas;

import entorno.Entorno;

public class Barra {

	private double x;
	private double y;
	private double Ancho;
	private double Alto;
	private Image barraImagen;

	Barra(double x, double y, double ancho, double alto) {
		this.x = x;
		this.y = y;
		this.Ancho = ancho;
		this.Alto = alto;
		this.barraImagen = Herramientas.cargarImagen("barra.jpg");
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(barraImagen, this.x, this.y, 0, 2.1);
		
	}
	public double getBarraX() {
		return this.x;
	}

	public double getBarraY() {
		return this.y;
	}
	public double getAncho() {
		return this.Ancho;
	}

	public double getAlto() {
		return this.Alto;
	}
}
