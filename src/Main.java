import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
	Tamagotchi nha = new Tamagotchi();
	JTextField tf;
	JLabel jl;
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4;
	JButton jb5;
	JButton jb6;
	JButton jb7;
	static Main jay1;
	public Main() {
		super("Início");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		jl = new JLabel("Digite o nome do seu Tamagotchi:");
		jl.setForeground(Color.black);
		jl.setFont(new Font("Arial", Font.BOLD, 13));
		add(jl);
		tf = new JTextField(20);
		add(tf);
		jb1 = new JButton("Start");
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nha.setNome(tf.getText());
				jay1.dispose();
				Tela2 jay = new Tela2(nha);
				jay.setSize(400,270);
				jay.setVisible(true);
				//jay.getContentPane().setBackground(Color.cyan.darker());
				jay.setLocationRelativeTo(null);
			}
		});
		jb1.setBackground(Color.black);
		jb1.setForeground(Color.white);
		add(jb1);
	}
	public static void main(String[] args) {
		jay1 = new Main();
		jay1.setSize(250,120);
		jay1.setVisible(true);
		jay1.getContentPane().setBackground(Color.cyan.darker());
		jay1.setLocationRelativeTo(null);

	}
}

/*Crie uma classe que modele um Tamagoshi:
 * Atributos: nome, npivel comida, nï¿½vel humor, nï¿½vel saï¿½de, nï¿½vel energia, idade
 * Mï¿½todos: comer, dormir, tomar remï¿½dio, crescer, adoecer, brincar, verificar nï¿½veis.
 */
