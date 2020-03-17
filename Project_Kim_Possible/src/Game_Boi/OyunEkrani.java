package Game_Boi;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;


public class OyunEkrani extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OyunEkrani () throws HeadlessException, FileNotFoundException, IOException{
		super("Trafic Lamber");
		this.setResizable(false);
		this.setFocusable(false);
		
		this.setSize(400,800); 
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Oyun oyun = new Oyun(this);
	 	oyun.requestFocus();
		oyun.addKeyListener(oyun);
		oyun.setFocusable(true);
		oyun.setFocusTraversalKeysEnabled(false);
		
		this.add(oyun);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setVisible(true);
	}
	
	public void kapat() 
	{
		this.dispose();
	}
	
}
