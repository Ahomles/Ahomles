package com.cn.javaFrame.common.util.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cn.javaFrame.common.util.mvc.Controller;
import com.cn.javaFrame.common.util.mvc.Model;
import com.cn.javaFrame.common.util.mvc.observer.BPMObserver;
import com.cn.javaFrame.common.util.mvc.observer.BeatObserver;

public class DJView implements ActionListener, BeatObserver, BPMObserver {
	Model model;
	Controller controller;
	JFrame viewFrame;
	JPanel viewPanel;
	BeatBar beatBar;

	JLabel bpmOutputLabel;
	JFrame controllerFrame;
	JPanel controllerPanel;
	JLabel bpmLabel;
	JTextField bpmTextField;
	JButton setBPMButton;
	JButton increaseBPMButton;
	JButton decreaseBPMButton;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem startMenuItem;
	JMenuItem stopMenuItem;
	
	
	public DJView(Controller controller,Model model) {
		this.controller=controller;
		this.model=model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
	}
	public void createView(){
		viewPanel = new JPanel(new GridLayout(1,2));
		viewFrame = new JFrame("View");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setSize(new Dimension(100,80));
		bpmOutputLabel = new JLabel("offline",SwingConstants.CENTER);
		beatBar=new BeatBar();
		beatBar.setValue(0);
		JPanel bpmPanel=new JPanel(new GridLayout(2,1));
		bpmPanel.add(bpmOutputLabel);
		viewPanel.add(beatBar);
		viewPanel.add(bpmPanel);
		viewFrame.add(viewPanel);
		viewFrame.getContentPane().add(viewPanel,BorderLayout.CENTER);
		viewFrame.pack();
		viewFrame.setVisible(true);
	}
	
	
	@Override
	public void updateBPM() {
		
	}

	@Override
	public void updateBeat() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
