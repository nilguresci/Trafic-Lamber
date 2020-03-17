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
		this.setResizable(false);//Boyutlandýrýlabilirliði kapatýr
		this.setFocusable(false);//Tam ekran modunu kapatýr
		
		this.setSize(250,250);//Ekran boyutunu ayarlar
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Frame kapatýldýðýnda programýn son bulmasýný saðlar
		
		JButton basla_buton = new JButton("Baþla");//Buton yaratýr
		basla_buton.addActionListener(new ActionListener() {//Butona aksiyon verir
			
			@Override
			public void actionPerformed(ActionEvent e) {//Yeni aksiyon yaratýr
				
				OyunEkrani ekran = null;
				try {
					ekran = new OyunEkrani();
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ekran.setVisible(true);//Jframe'i görünür yapar
				kapat();//Özel metod
			}});//"basla_buton" adýnda bir buton yaratýp, üzerinde "Baþla" yazdýktan sonra; üzerine týklandýðýnda önce
		//OyunEkrani sýnýfýndan bir deðiþken oluþturduk ve onu çaðýrdýk sonrasýnda kendi metodumuzla GirisEkranini kapattýk
		JButton cikis_button=new JButton("Çýkýþ");//Buton yaratýr
		cikis_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//Programýn kapanmasýný saðlar
			}
		});
		JLabel lMerhaba=new JLabel("Trafic Lamber'a Hoþ Geldiniz");//Label yaratýr
		this.add(lMerhaba);//Labelý ekrana ekler
		this.add(basla_buton);//Butonu ekrana ekler
		this.add(cikis_button);//Butonu ekrana ekler
		this.setLayout(new GridLayout(3,1));//Ekran layoutunu (yerleþimini) düzenler (Yukarýdan aþaðýya 3 satýr, Soldan saða 1 sutün)
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Ekran boyutunu deðiþkene atar
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//JFame'i ekran boyutuna göre konumlar
		this.setVisible(true);//JFrame'i görürünü yapar
	}
	public void kapat()//Özel metod
	{
		this.dispose();//JFrame'i kapatýr
	}
	public void basla()
	{
		System.out.print("Oyun Baþladý");
	}
	public static void main(String[] args) throws HeadlessException, FileNotFoundException, IOException 
	{
		GirisEkrani giris = new GirisEkrani();//Kurucu metodu çaðýrýr
		//Oyun bu ekrandan baþlýyacaðý için burada kurucu metod çaðýrýlmalý
		giris.basla();//Sarý ünlemi kaybeder
	}

}
