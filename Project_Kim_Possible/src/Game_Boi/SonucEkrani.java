package Game_Boi;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SonucEkrani extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SonucEkrani (int zaman,int skor) throws HeadlessException{
		super("Trafic Lamber");
		this.setResizable(false);
		this.setFocusable(false);
		
		this.setSize(250,250);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lzaman=new JLabel("Gecen sure: "+Integer.toString(zaman));
		JLabel lskor=new JLabel("Skor: "+Integer.toString(skor));
		JButton tekrarla_buton = new JButton("Tekrar Baþla");
		tekrarla_buton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GirisEkrani ekran = null;
				try {
					ekran = new GirisEkrani();
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ekran.setVisible(true);//Jframe'i görünür yapar
				kapat();
			}});
		JButton cikis_button=new JButton("Çýkýþ");
		cikis_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		this.add(lskor);
		this.add(lzaman);
		this.add(tekrarla_buton);
		this.add(cikis_button);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setLayout(new GridLayout(2,2));
		this.setVisible(true);
	}
	public void kapat()
	{
		this.dispose();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
