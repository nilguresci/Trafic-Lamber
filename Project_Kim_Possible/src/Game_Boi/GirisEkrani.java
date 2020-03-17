package Game_Boi;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class GirisEkrani extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GirisEkrani () throws HeadlessException, FileNotFoundException, IOException{
		super("Trafic Lamber");//Title belirler
		this.setResizable(false);//Boyutland�r�labilirli�i kapat�r
		this.setFocusable(false);//Tam ekran modunu kapat�r
		
		this.setSize(250,250);//Ekran boyutunu ayarlar
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Frame kapat�ld���nda program�n son bulmas�n� sa�lar
		
		JButton basla_buton = new JButton("Ba�la");//Buton yarat�r
		basla_buton.addActionListener(new ActionListener() {//Butona aksiyon verir
			
			@Override
			public void actionPerformed(ActionEvent e) {//Yeni aksiyon yarat�r
				
				OyunEkrani ekran = null;
				try {
					ekran = new OyunEkrani();
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ekran.setVisible(true);//Jframe'i g�r�n�r yapar
				kapat();//�zel metod
			}});//"basla_buton" ad�nda bir buton yarat�p, �zerinde "Ba�la" yazd�ktan sonra; �zerine t�kland���nda �nce
		//OyunEkrani s�n�f�ndan bir de�i�ken olu�turduk ve onu �a��rd�k sonras�nda kendi metodumuzla GirisEkranini kapatt�k
		JButton cikis_button=new JButton("��k��");//Buton yarat�r
		cikis_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//Program�n kapanmas�n� sa�lar
			}
		});
		JLabel lMerhaba=new JLabel("Trafic Lamber'a Ho� Geldiniz");//Label yarat�r
		this.add(lMerhaba);//Label� ekrana ekler
		this.add(basla_buton);//Butonu ekrana ekler
		this.add(cikis_button);//Butonu ekrana ekler
		this.setLayout(new GridLayout(3,1));//Ekran layoutunu (yerle�imini) d�zenler (Yukar�dan a�a��ya 3 sat�r, Soldan sa�a 1 sut�n)
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Ekran boyutunu de�i�kene atar
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//JFame'i ekran boyutuna g�re konumlar
		this.setVisible(true);//JFrame'i g�r�r�n� yapar
	}
	public void kapat()//�zel metod
	{
		this.dispose();//JFrame'i kapat�r
	}
	public void basla()
	{
		System.out.print("Oyun Ba�lad�");
	}
	public static void main(String[] args) throws HeadlessException, FileNotFoundException, IOException 
	{
		GirisEkrani giris = new GirisEkrani();//Kurucu metodu �a��r�r
		//Oyun bu ekrandan ba�l�yaca�� i�in burada kurucu metod �a��r�lmal�
		giris.basla();//Sar� �nlemi kaybeder
	}

}
