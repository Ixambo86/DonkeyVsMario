package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Donkey {
	private double x;
	private double y;
	private Image donkeyImagen;

	Donkey(double x, double y) {
		this.x = x;
		this.y = y;
		this.donkeyImagen = Herramientas.cargarImagen("donkey.gif");

	}

	public void dibujarDonkey(Entorno entorno) {

		entorno.dibujarImagen(donkeyImagen, this.x, this.y, 0, .3);

	}
	public double getDonkeyX() {
		return this.x;
	}
	public double getDonkeyY() {
		return this.y;
	}
	public Image getDonkeyImagen() {
		return this.donkeyImagen;
	}
}