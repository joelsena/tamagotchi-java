import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class Tela2 extends JFrame{
	JLabel jl;
	JTextArea jl2;
	JLabel jl3;
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4;
	JButton jb5;
	JButton jb6;
	JButton jb7;
	JScrollPane scrollPane;
	JPanel painel;
	Player ply;

	public Tela2(Tamagotchi nha) {
		super("Tamagotchi");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel();
		painel.setPreferredSize(new Dimension(380,230));
		painel.setBackground(Color.cyan.darker());
		//scrollPane = new JScrollPane(painel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//getContentPane().add(scrollPane);
		painel.setLayout(null);
		getContentPane().add(painel);

		jl2 = new JTextArea(nha.verifiNive());
		jl2.setBounds(5, 5, 200, 108);
		jl2.setForeground(Color.white);
		jl2.setBackground(Color.black);
		jl2.setFont(new Font("cONSOLAS",Font.BOLD,14));

		painel.add(jl2);
		jl3 = new JLabel(new ImageIcon("images/TmagothiGif1-2.gif"));
		jl3.setBounds(86, 16, -1, -1);

		painel.add(jl3);


		jl = new JLabel("\nEscolha uma das opçôes\n abaixo para o "+nha.getNome()+" fazer: ");
		jl.setBounds(5, 124, 392, 16);
		jl.setForeground(Color.black);
		jl.setFont(new Font("cONSOLAS",Font.BOLD,13));
		//		add(jl);
		painel.add(jl);
		jb1 = new JButton("Crescer");
		jb1.setBounds(5, 151, 93, 23);
		jb1.setForeground(Color.white);
		jb1.setBackground(Color.black);
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nha.crescer();
				jl2.setText(nha.verifiNive());
				musicUp();
			}
		});

		painel.add(jb1);
		jb2 = new JButton("Comer");
		jb2.setBounds(5, 185, 93, 23);
		jb2.setForeground(Color.white);
		jb2.setBackground(Color.black);
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nha.comer();
				jl2.setText(nha.verifiNive());
				musicEat();
			}
		});

		painel.add(jb2);
		jb3 = new JButton("Dormir");
		jb3.setBounds(108, 185, 93, 23);
		jb3.setForeground(Color.white);
		jb3.setBackground(Color.black);
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nha.dormir();
				jl2.setText(nha.verifiNive());
			}
		});

		painel.add(jb3);
		jb4 = new JButton("Tomar Remédio");
		jb4.setBounds(211, 151, 148, 23);
		jb4.setForeground(Color.white);
		jb4.setBackground(Color.black);
		jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nha.tomarReme();
				jl2.setText(nha.verifiNive());
			}
		});

		painel.add(jb4);
		jb6 = new JButton("Brincar");
		jb6.setBounds(108, 151, 93, 23);
		jb6.setForeground(Color.white);
		jb6.setBackground(Color.black);
		jb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nha.brincar();
				jl2.setText(nha.verifiNive());
			}
		});
		painel.add(jb6);

	}
	public void musicUp() {
		new Thread() {
			public void run() {
				try {
					FileInputStream in = new FileInputStream("soundEffects/UpEfe.mp3");
					ply= new Player(in);
					ply.play();
				} catch (JavaLayerException | FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
	}
	public void musicEat() {
		new Thread() {
			public void run() {
				try {
					FileInputStream in = new FileInputStream("soundEffects/EatEfe.mp3");
					ply= new Player(in);
					ply.play();
				} catch (JavaLayerException | FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}.start();
			
		
	}

}

