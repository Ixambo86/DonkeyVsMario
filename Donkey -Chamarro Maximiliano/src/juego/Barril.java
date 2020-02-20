package juego;


import java.awt.Image;
import entorno.Herramientas;


import entorno.Entorno;

public class Barril {
	private double x;
	private double y;
	private double Ancho;
	private double Alto;
	
	double velocidad;
	Image barrilImagen;

	Barril() {
		this.x = 80;
		this.y = 90;
		
		this.velocidad = 2;
		this.barrilImagen = Herramientas.cargarImagen("barril.jpg");

	}

	public void DibujarBarril(Entorno entorno) {
		entorno.dibujarImagen(barrilImagen, this.x, this.y, 0, 2);

	}

	public void avanzar() {

		if (this.x < 789 || this.x < 0) {
			if (this.y == 90 || this.y == 330
					|| this.y == 585) {
				this.x += this.velocidad;
			}

			else if (this.y == 210 || this.y == 450) {
				this.x -= this.velocidad;
			}

		}
	}

	public void caerse() {
		if (this.x > 730 && ((this.y >= 90 && this.y < 210)
				|| (this.y >= 330 && this.y < 450))) {
			this.y += 3;

		}

		if (this.x < 105 && ((this.y >= 210 && this.y < 330)
				|| (this.y >= 450 && this.y < 585))) {
			this.y += 3;
		}

	}
	public double getBarrilX() {
		return this.x;
	}
	public double getBarrilY() {
		return this.y;
	}
	public double getVelocidad() {
		return this.velocidad;
	}
}
