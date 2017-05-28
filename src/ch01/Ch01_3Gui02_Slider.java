package ch01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;

public class Ch01_3Gui02_Slider {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ch01_3Gui02_Slider window = new Ch01_3Gui02_Slider();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ch01_3Gui02_Slider() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSlider slider = new JSlider();
		
		slider.setValue(1);
		slider.setMinimum(1);
		slider.setBounds(40, 15, 200, 15);
		frame.getContentPane().add(slider);
		
		JLabel lblNewLabel = new JLabel("Test");
		lblNewLabel.setBounds(7, 10, 30, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("1");
		label.setBounds(245, 10, 54, 20);
		frame.getContentPane().add(label);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				label.setText(slider.getValue()+"");
			}
		});
	}
}
