package practice.tree;

import java.awt.BorderLayout;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * 使用Swing控件展示tree
 * 实现AbstractTree 抽象类tree可以使用该程序进行可视化测试
 * @author lh
 * @date 2017年10月18日
 * @version 
 */
public class DisplayTree extends JApplet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2591691423449267048L;
	public DisplayTree() {
		// TODO Auto-generated constructor stub
		//这个位置修改具体的实现类
    	add(new Test(new MyAvlTree<Integer>()));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame jFrame=new JFrame("Tree GUI");
        jFrame.add(new DisplayTree());
        jFrame.setSize(400,400);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
	}
 
	
}

class Test extends JPanel{
	AbstractTree<Integer> tree;
     TreeView treeView=new TreeView();
    private JTextField jtField=new JTextField(5);
    private JButton jbtInsert=new JButton("Insert");
    private JButton jbtDelete=new JButton("Delete");
    public Test(AbstractTree<Integer> tree) {
    	this.tree=tree;
    	setUI();
	}
	private void setUI() {
		// TODO Auto-generated method stub
	this.setLayout(new BorderLayout())	;
	add(treeView, BorderLayout.CENTER);
		JPanel panel=new JPanel();
		//this.setVisible(true);
		panel.add(new JLabel("Enter a key :"));
		panel.add(jtField);
		panel.add(jbtInsert);
		panel.add(jbtDelete);
		add(panel, BorderLayout.SOUTH);
		jbtInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int key=Integer.parseInt(jtField.getText());
					tree.insert(key);
					treeView.repaint();
				
			}
		});
		jbtDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int key=Integer.parseInt(jtField.getText());
				if (tree.search(key)) {
					tree.delete(key);
					treeView.repaint();
				} else {
                 JOptionPane.showMessageDialog(null, key+"is not in the tree");
				}
			}
		});
	
	}
	class TreeView extends JPanel{
		private int radius=20;
		private int vGap=50;
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if (tree.getRoot()!=null) {
				diaplay(g,tree.getRoot(),getWidth()/2,30,getWidth()/4);
			}
		}
		private void diaplay(Graphics g, TreeNode<Integer> root, int x, int y, int hGap) {
			// TODO Auto-generated method stub
			g.drawOval(x-radius, y-radius, 2*radius,  2*radius);
			g.drawString(root.element+"", x-6, y+4);
			if(root.left!=null){
				connectLeftChild(g,x-hGap,y+vGap,x,y);
				diaplay(g, root.left, x-hGap, y+vGap, hGap/2);
			}
			if (root.right!=null) {
				connectRightChild(g,x+hGap,y+vGap,x,y);
				diaplay(g, root.right, x+hGap, y+vGap, hGap/2);
			}
		}
		private void connectRightChild(Graphics g, int x1, int y1, int x2, int y2) {
			// TODO Auto-generated method stub
		   double d=Math.sqrt(vGap*vGap+(x2-x1)*(x2-x1));
		   int x11=(int)(x1-radius*(x1-x2)/d);
		   int y11=(int)(y1-radius*vGap/d);
		   int x21=(int)(x2+radius*(x1-x2)/d);
		   int y21=(int)(y2+radius*vGap/d);
		   g.drawLine(x11, y11, x21, y21);
		}
		private void connectLeftChild(Graphics g, int x1, int y1, int x2, int y2) {
			// TODO Auto-generated method stub
			  double d=Math.sqrt(vGap*vGap+(x2-x1)*(x2-x1));
			   int x11=(int)(x1+radius*(x2-x1)/d);
			   int y11=(int)(y1-radius*vGap/d);
			   int x21=(int)(x2-radius*(x2-x1)/d);
			   int y21=(int)(y2+radius*vGap/d);
			   g.drawLine(x11, y11, x21, y21);
		}
	}
 
} 

 

