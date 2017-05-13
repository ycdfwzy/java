package guittt;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class Gui_TTT extends JFrame implements ActionListener{
	
	static MyPanel panel = new MyPanel();
	
	Gui_TTT(){
		this.setTitle("Tic-Tac-Toe");
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
        
        JButton button=new JButton("Replay");
        button.addActionListener(this);
        JPanel jp = new JPanel();
        jp.add(button);
        this.getContentPane().add(jp, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args){
		JFrame frame = new Gui_TTT();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(300, 340);
        frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Replay"));
			panel.replay();
	}

}

class MyPanel extends JPanel{
	Point p;
	MouseAdapter MA;
	MouseMotionAdapter MMA;
	int[][] TTT;
	int turns;
	MyPanel(){
		p = null;
		MA = new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				int h=getHeight(),w=getWidth();
				int x=e.getX()/(w/3),y=e.getY()/(h/3);
				if(x>2 || x<0 || y>2 || y<0)
					return;
				if(TTT[x][y] != 0)
					return;
				
				if(turns == 0)
					TTT[x][y] = 1;
				else TTT[x][y] = 2;
				turns ^= 1;
				p = null;
				repaint();
				Judge();
			}
		};
		MMA = new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e){
				int h=getHeight(),w=getWidth();
				int x=e.getX()/(w/3),y=e.getY()/(h/3);
				if(x>2 || x<0 || y>2 || y<0 || TTT[x][y] != 0){
					p = null;
					repaint();
					return;
				}
				
				p = new Point(x, y);
				repaint();
				Judge();
			}
		};
		this.replay();
	}
	public void replay(){
		TTT = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
		turns = 0;
		addMouseListener(MA);
		addMouseMotionListener(MMA);
		repaint();
	}
	
	public void Judge(){
		for (int i=0; i<3; i++){
			if (TTT[i][0] == TTT[i][1] && TTT[i][1] == TTT[i][2]){
				if (TTT[i][0] != 0){
					this.Over(TTT[i][0]);
					return;
				}
			}
			if (TTT[0][i] == TTT[1][i] && TTT[1][i] == TTT[2][i]){
				if (TTT[0][i] != 0){
					this.Over(TTT[0][i]);
					return;
				}
			}
		}
		if (TTT[0][0] == TTT[1][1] && TTT[1][1] == TTT[2][2]){
			if (TTT[1][1] != 0){
				this.Over(TTT[1][1]);
				return;
			}
		}
		if (TTT[0][2] == TTT[1][1] && TTT[1][1] == TTT[2][0]){
			if (TTT[1][1] != 0){
				this.Over(TTT[1][1]);
				return;
			}
		}
		
		boolean tied = true;
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
			if (TTT[i][j] == 0)
				tied = false;
		if (tied == true)
			this.Over(0);
	}
	
	public void Over(int para){
		if (para == 0)
			JOptionPane.showMessageDialog(null, "Tied");
		else if (para == 1)
			JOptionPane.showMessageDialog(null, "Player1 Win");
		else if (para == 2)
			JOptionPane.showMessageDialog(null, "Player2 Win");
		p = null;
		removeMouseListener(MA);
		removeMouseMotionListener(MMA);
		repaint();
	}
	
	public void paintComponent(Graphics g){
		int H = getHeight(), W = getWidth();
		int h3 = H/3, w3 = W/3;
		super.paintComponent(g);
		Image imagebuff = createImage(W,H);
		Graphics gbuff = imagebuff.getGraphics();
		Graphics2D g2 = (Graphics2D)gbuff;
		g2.setStroke(new BasicStroke(10));
		g2.setColor(Color.BLUE);
		g2.drawLine(w3,0,w3,H);
		g2.drawLine(w3*2,0,w3*2,H);
		g2.drawLine(0,h3,W,h3);
		g2.drawLine(0,h3*2,W,h3*2);
		
		if (p != null && TTT[p.x][p.y]==0){
			if(turns == 0){
				g2.setColor(new Color(255,0,0,100));
				g2.drawLine(p.x*w3+20,p.y*h3+20,(p.x+1)*w3-20,(p.y+1)*h3-20);
				g2.drawLine(p.x*w3+20,(p.y+1)*h3-20,(p.x+1)*w3-20,p.y*h3+20);
			}
			else{
				g2.setColor(new Color(0,255,0,100));
				g2.draw(new Ellipse2D.Double(p.x*w3+20,p.y*h3+20,w3-40,h3-40));
			}
		}
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++){
				if (TTT[i][j] == 0) continue;
				if (TTT[i][j] == 1){
					g2.setColor(new Color(255,0,0,255));
					g2.drawLine(i*w3+20,j*h3+20,(i+1)*w3-20,(j+1)*h3-20);
					g2.drawLine(i*w3+20,(j+1)*h3-20,(i+1)*w3-20,j*h3+20);
				}else
				{
					g2.setColor(new Color(0,255,0,255));
					g2.draw(new Ellipse2D.Double(i*w3+20,j*h3+20,w3-40,h3-40));
				}
			}
		g.drawImage(imagebuff,0,0,null);
	}
}
