package juego;
import java.util.Random;
import entorno.Entorno;

import java.awt.Color;

import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// Variables y métodos propios de cada grupo
	// ...

	Barra[] barras;

	Escalera[] escaleras;

	Barril[] barril;
	int tiempo;
	Donkey donkey;
	Jumpman mario;
	boolean Termino;
	boolean Gano;
	int tiempodesalto;
	int aleatorio;

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this,
				"Donkey - Grupo Apellido1 - Apellido2 -Apellido3 - V0.01", 800,
				600);

		// Inicializar lo que haga falta para el juego
		// ...
		this.tiempo = 0;
		this.barras = new Barra[5];
		this.escaleras = new Escalera[4];
		this.barril = new Barril[10];
		this.donkey = new Donkey(80, 70);
		this.mario = new Jumpman(25, 570, 20, 50);
		this.Termino = false;
		this.Gano = false;
		this.tiempodesalto = 0;
		this.aleatorio=0;

		barras[0] = new Barra(405, 600, 800, 10);
		barras[1] = new Barra(475, 480, 680, 10);
		barras[2] = new Barra(350, 360,680, 10);
		barras[3] = new Barra(475, 240, 680,10);
		barras[4] = new Barra(350, 120, 680, 10);
		escaleras[0] = new Escalera(650, 540,20,110);
		escaleras[1] = new Escalera(150, 420,20,110);
		escaleras[2] = new Escalera(650, 300,20,110);
		escaleras[3] = new Escalera(150, 180,20,110);

		// Inicia el juego!
		this.entorno.iniciar();
	}
	public boolean marioEstaenBarra(){
		for (int i = 0;i<barras.length;i++){
			if(this.mario.getMarioY()+ mario.getAlto()/2 == barras[i].getBarraY() - barras[i].getAlto()/2){
				if(i%2!=0 && !(this.mario.getMarioX() + this.mario.getAncho()*2  <= this.barras[i].getBarraX() - this.barras[i].getAncho()/2)){
					return true;	
				}
				if(i%2==0 && !(this.mario.getMarioX() - this.mario.getAncho()*2 >= this.barras[i].getBarraX() + this.barras[i].getAncho()/2)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean marioEstaenEscalerasube() {
		for (int i = 0; i < escaleras.length; i++) {
			if (this.mario.getMarioX() > escaleras[i].getX()- escaleras[i].getAncho() / 2
					&& this.mario.getMarioX() < escaleras[i].getX() + escaleras[i].getAncho() / 2
					&& this.mario.getMarioY() + this.mario.getAlto()/2 <=escaleras[i].getY() + escaleras[i].getAlto()/2
					&& this.mario.getMarioY()+ this.mario.getAlto()/2 > escaleras[i].getY() - escaleras[i].getAlto()/2 - barras[i+1].getAlto() ) {
				return true;
			}
		}
		return false;
	}
	public boolean marioEstaenEscalerabaja() {
		for (int i = 0; i < escaleras.length; i++) {
			if (this.mario.getMarioX() > escaleras[i].getX()- escaleras[i].getAncho() / 2
					&& this.mario.getMarioX() < escaleras[i].getX() + escaleras[i].getAncho() / 2
					&& this.mario.getMarioY() + this.mario.getAlto()/2 <escaleras[i].getY() + escaleras[i].getAlto()/2
					&& this.mario.getMarioY()+ this.mario.getAlto()/2 >= escaleras[i].getY() - escaleras[i].getAlto()/2 - barras[i+1].getAlto() ) {
				return true;
			}
		}
		return false;
	}
			
		
	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por
	 * lo tanto es el método más importante de esta clase. Aquí se debe
	 * actualizar el estado interno del juego para simular el paso del tiempo
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() {

		if (!(this.Termino)) {
			tiempo += 1;
			this.donkey.dibujarDonkey(this.entorno);
			
// SALTO DE MARIO
			
			if ((entorno.sePresiono(entorno.TECLA_ESPACIO) || tiempodesalto != 0)) {
				if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)&& (this.mario.getMarioX()- this.mario.getAncho()/2)>0) {
					if (tiempodesalto < 25) {
						mario.subeizq();
						tiempodesalto += 1;
					}
					if (tiempodesalto >= 25 && tiempodesalto < 50) {
						mario.bajaizq();
						tiempodesalto += 1;
					}
					if (tiempodesalto > 49) {
						tiempodesalto = 0;
					}

				} else if (entorno.estaPresionada(entorno.TECLA_DERECHA)&&(this.mario.getMarioX()+ this.mario.getAncho()/2)<800) {

					if (tiempodesalto < 25) {
						mario.subederecha();
						tiempodesalto += 1;
					}
					if (tiempodesalto >= 25 && tiempodesalto < 50) {
						mario.bajaderecha();
						tiempodesalto += 1;
					}
					if (tiempodesalto > 49) {
						tiempodesalto = 0;
					}
				} else if (tiempodesalto < 25) {
					mario.sube();
					tiempodesalto += 1;
				}
				if (tiempodesalto >= 25 && tiempodesalto < 50) {
					mario.baja();
					tiempodesalto += 1;
				}
				if (tiempodesalto > 49) {
					tiempodesalto = 0;
				}
			}
			
// MOVIMIENTO DE MARIO
			
			if (entorno.estaPresionada(entorno.TECLA_DERECHA) && marioEstaenBarra() && (this.mario.getMarioX()+ this.mario.getAncho()/2)<800) {
				this.mario.moversederecha(entorno);
				}

			if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && marioEstaenBarra()&& (this.mario.getMarioX()- this.mario.getAncho()/2)>0) {
				this.mario.moverseizq(entorno);

			}
// MARIO SUBE Y BAJA ESCALERAS
			
			if (entorno.estaPresionada(entorno.TECLA_ARRIBA) && this.marioEstaenEscalerasube()) {
				this.mario.moversesube(entorno);
					
				}
			if (entorno.estaPresionada(entorno.TECLA_ABAJO) && this.marioEstaenEscalerabaja()) {
				this.mario.moversebaja(entorno);
					
				}		
			
			
// CAIDA DE MARIO
			
			for (int i=0;i<barras.length;i++){
				
				if(! marioEstaenBarra() && !marioEstaenEscalerabaja() && !marioEstaenEscalerasube() && tiempodesalto==0){
					this.mario.caerse(entorno);
				}
				
				
			}
			
			
			
			System.out.println(tiempo);
			for (int i = 0; i < barras.length; i++) {
				barras[i].dibujar(entorno);
			}
			for (int i = 0; i < escaleras.length; i++) {
				escaleras[i].dibujar(entorno);
			}
			this.mario.dibujarJump(entorno);

			
			
			Random aleatorio = new Random();
			int a=aleatorio.nextInt(4);
			
			
			
			if (tiempo % 40+a == 0) {
				for (int i = 0; i < barril.length; i++) {
					if (this.barril[i] == null) {
						this.barril[i] = new Barril();
						i += barril.length - 1;
					}

				}
			}
			for (int i = 0; i < barril.length; i++) {
				if (barril[i] != null) {
					barril[i].DibujarBarril(entorno);
					barril[i].avanzar();
					barril[i].caerse();
					if (barril[i].getBarrilX() > 785) {
						barril[i] = null;
					}
					if (mario.colisionaBarril(barril[i])) {
						this.Termino = true;
					}

				}
			}

			if (mario.colisionaDonkey(donkey)) {

				this.Termino = true;
				this.Gano = true;
			}
		} else {
			if (this.Gano) {
				this.donkey.dibujarDonkey(this.entorno);
				entorno.cambiarFont("Arial", 18, Color.GREEN);
				entorno.escribirTexto("Donkey Atrapado", 350, 300);
			} else {
				this.donkey.dibujarDonkey(this.entorno);
				this.mario.dibujarJump(entorno);
				entorno.cambiarFont("Arial", 18, Color.red);
				entorno.escribirTexto("Game Over", 350, 300);
			}
		}
	}

	// @SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
