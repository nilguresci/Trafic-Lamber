package Game_Boi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Lamba{
	private int x;
	private int y;
	private int sure;
	
	public Lamba(int x, int y, int sure) {
		super();
		this.x = x;
		this.y = y;
		this.sure = sure;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSure() {
		return sure;
	}
	public void setSure(int sure) {
		this.sure = sure;
	}
	
	
}

class Serit{
	private int x1;
	private int y;
	private int x2;
	public Serit(int x1, int y, int x2) {
		super();
		this.x1 = x1;
		this.y = y;
		this.x2 = x2;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	
	
	
	
}
public class Oyun extends JPanel implements KeyListener,ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int Gecen_Sure=0;
	
	private int Hiz=6;
	
	private int Hiz_Lamba = 500;
	
	private int Skor = 0;
	
	private int Yol=50;
	
	Timer timer = new Timer(Hiz,this);
	
	
	
	
	private BufferedImage araba;
	
	private BufferedImage lamba_yesil;
	private BufferedImage lamba_sari;
	private BufferedImage lamba_kirmizi;
	
	private ArrayList<Lamba> lambalar = new ArrayList<Lamba>();
	
	private ArrayList<Serit> seritler = new ArrayList<Serit>();
	
	private int lambadirY = 1;
	
	private int seritdirY = 1;
	private OyunEkrani ekoo;
	public Oyun(OyunEkrani eko) throws FileNotFoundException, IOException {
		
		araba = ImageIO.read(new FileImageInputStream(new File("car.png")));
		
		lamba_yesil = ImageIO.read(new FileImageInputStream(new File("LG.png")));
		lamba_sari = ImageIO.read(new FileImageInputStream(new File("LY.png")));
		lamba_kirmizi = ImageIO.read(new FileImageInputStream(new File("LR.png")));
		
		setBackground(Color.darkGray);
		ekoo=eko;
		timer.start();
		
	}
	
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}



	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(araba,125,575,araba.getWidth()/3,araba.getHeight()/3,this);
		
		for (Serit serit : seritler) {
			if(serit.getY()>900) {
				seritler.remove(serit);
				Yol+=5;
			}
		}
		
		g.setColor(Color.white);
		
		for (Serit serit : seritler) {
			g.fillRect(serit.getX1(), serit.getY(), 10, 100);
			g.fillRect(serit.getX2(), serit.getY(), 10, 100);
		}
		
		for (Lamba lamba: lambalar) {
			if(lamba.getY()>900) {
				lambalar.remove(lamba);
				Skor++;
			}
		}
		
		for (Lamba lamba : lambalar) {
			int deger = lamba.getSure()%750;
			if(deger<250) {
				g.drawImage(lamba_yesil,lamba.getX(),lamba.getY(),lamba_yesil.getWidth()/2,lamba_yesil.getHeight()/2,this);
			}
			else if (deger>500) {
				g.drawImage(lamba_kirmizi,lamba.getX(),lamba.getY(),lamba_yesil.getWidth()/2,lamba_yesil.getHeight()/2,this);
				if (lamba.getY()==500) {
					timer.stop();
					String message = "Yandýnýz..\nKatettiðiniz Yol : "+Yol+"mt\nSkorunuz : "+Skor;
					JOptionPane.showMessageDialog(this,message);
					SonucEkrani sonuc=new SonucEkrani(Gecen_Sure,Skor);
					sonuc.setVisible(true);
					ekoo.kapat();
				}
			}
			else {
				g.drawImage(lamba_sari,lamba.getX(),lamba.getY(),lamba_yesil.getWidth()/2,lamba_yesil.getHeight()/2,this);
				if (lamba.getY()==500) {
					timer.stop();
					String message = "Yandýnýz..\nKatettiðiniz Yol : "+Yol+"mt\nSkorunuz : "+Skor;
					JOptionPane.showMessageDialog(this,message);
					SonucEkrani sonuc=new SonucEkrani(Gecen_Sure,Skor);
					sonuc.setVisible(true);
					ekoo.kapat();
				}
			}
		}
		//g.drawImage(lamba_yesil,350,dnm,lamba_yesil.getWidth()/2,lamba_yesil.getHeight()/2,this);
	}
	
	public static void main(String[] args) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int d = e.getKeyCode();
		if (d==KeyEvent.VK_SPACE)
		{
			for(Lamba lamba : lambalar) {
				lamba.setSure(lamba.getSure()+250);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Gecen_Sure++;
		if(Gecen_Sure%150==0) {
			seritler.add(new Serit(100,-110,250));
		}
		
		for(Serit serit : seritler) {
			serit.setY(serit.getY()+seritdirY);
		}
		
		if(Gecen_Sure%Hiz_Lamba==0) {
			Random rand = new Random();
			int p = rand.nextInt(751);
			lambalar.add(new Lamba(350,-100,p));
			System.out.println(p);
		}
		
		for(Lamba lamba : lambalar) {
			lamba.setY(lamba.getY()+lambadirY);
			lamba.setSure(lamba.getSure()+1);
		}
		if(Skor<5) {
			Hiz=6;
		}
		else if (Skor<10) {
			Hiz=5;
		}
		else if (Skor<12) {
			Hiz=4;
		}
		else if (Skor<14) {
			Hiz=3;
		}
		else if (Skor<15) {
			Hiz=2;
		}
		else if (Skor<20) {
			Hiz=1;
		}
		
		repaint();
	}

}
