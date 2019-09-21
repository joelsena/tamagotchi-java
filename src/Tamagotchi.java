import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class Tamagotchi {
	
	Player ply;
	private String nome;
	private int nDeCom = 8;
	private int nDeHum = 8;
	private int nDeSau = 8;
	private int nDeEner = 8;
	private int idade = 0;
	public void crescer() {
		idade++;
	}
	public void comer() {
		nDeCom++;
		if(nDeEner<10) {
			nDeEner++;
		}if(nDeCom>10) {
			adoecer();
		}
	}
	public void dormir() {
		if(nDeSau<10) {
			nDeSau++;
		}
		if(nDeEner<10) {
			nDeEner++;
		}
	}
	public void tomarReme() {
		if(nDeCom<10) {
			nDeSau=10;
		}
		
	}
	public void adoecer() {
		nDeSau--;
		if(nDeSau==0) {
			musicDeath();
			JOptionPane.showMessageDialog(null, "Ele morreu!!!", "MORREU!!!", JOptionPane.ERROR_MESSAGE);
			
			System.exit(0);
		}
	}
	public void brincar() {
		if(nDeHum<10) {
			nDeHum++;
		}
		nDeEner--;
		if(nDeEner==0) {
			musicDeath();
			JOptionPane.showMessageDialog(null, "Ele morreu!!!", "MORREU!!!", JOptionPane.ERROR_MESSAGE);
			
			System.exit(0);
		}
		nDeCom--;
		if(nDeCom==0) {
			musicDeath();
			JOptionPane.showMessageDialog(null, "Ele morreu!!!", "MORREU!!!", JOptionPane.ERROR_MESSAGE);
			
			System.exit(0);
		}
	}

	public String verifiNive() {
		if(nDeCom<6||nDeEner<6||nDeHum<6) {
			adoecer();
		}
		nome.toLowerCase();
		String cap = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
		return "Nome: "+cap+"\nN�vel De Comida: " + nDeCom + "\nN�vel De Humor: " + nDeHum + "\nN�vel De Sa�de: " + nDeSau + "\nN�vel De Energia: " + nDeEner
				+ "\nIdade: "+idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void musicDeath() {
		new Thread() {
			public void run() {
				try {
					FileInputStream in = new FileInputStream("soundEffects/game over you failed.mp3");
					ply= new Player(in);
					ply.play();
				} catch (JavaLayerException | FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	

}
