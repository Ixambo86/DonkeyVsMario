package juego;

import entorno.Entorno;

import java.awt.Color;
import java.awt.Image;
import entorno.Herramientas;

public class Jumpman {

	private double x;
	private double y;
	private double Ancho;
	private double Alto;
	private Image marioImagen;

	Jumpman(double x, double y, double ancho, double alto) {
		this.x = x;
		this.y = y;
		this.Ancho = ancho;
		this.Alto = alto;
		this.marioImagen = Herramientas.cargarImagen("mario.jpg");
	}

	public void dibujarJump(Entorno entorno) {

		entorno.dibujarImagen(marioImagen, this.x, this.y, 0, 0.3);
		
	}

	public void moverseizq(Entorno entorno) {
		this.x -= 2;
	}
	public void moversederecha(Entorno entorno) {
		this.x += 2;
	}
	public void moversesube(Entorno entorno) {
		this.y -= 1;
	}
	public void moversebaja(Entorno entorno) {
		this.y += 1;
	}


		
	public void caerse(Entorno entorno) {
		this.y += 1;

	}

	public boolean colisionaBarril(Barril barril) {
		if (this.y <= barril.getBarrilY() + 20 && this.y >= barril.getBarrilY() - 20
				&& this.x <= barril.getBarrilX() + 20 && this.x >= barril.getBarrilX() - 20) {
			return true;
		}

		return false;
	}

	public boolean colisionaDonkey(Donkey donkey) {
		if (this.y <= donkey.getDonkeyY() + 20 && this.y >= donkey.getDonkeyY() - 20
				&& this.x <= donkey.getDonkeyX() + 20 && this.x >= donkey.getDonkeyX() - 20) {
			return true;
		}

		return false;
	}

	public double getMarioX() {
		return this.x;
	}

	public double getMarioY() {
		return this.y;
	}
	public double getAncho() {
		return this.Ancho;
	}

	public double getAlto() {
		return this.Alto;
	}

	/*public Image getMarioImagen() {
		return marioImagen;
	}*/
	
	public void sube(){
		this.y-=3;
	}
	
	public void baja(){
		this.y+=3;
	}
	public void subederecha(){
		this.y-=3;
		this.x+=3;
	}
	
	public void bajaderecha(){
		this.y+=3;
		this.x+=3;
	}
	public void subeizq(){
		this.y-=3;
		this.x-=3;
	}
	
	public void bajaizq(){
		this.y+=3;
		this.x-=3;
	}
}
