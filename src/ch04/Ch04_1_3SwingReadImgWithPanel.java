package ch04;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Ch04_1_3SwingReadImgWithPanel {

	/**
	 * 加载OpenCV库
	 */
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String arg[]) {
		try {
			Ch04_1_3SwingReadImgWithPanel window = new Ch04_1_3SwingReadImgWithPanel();
			Mat source = Imgcodecs.imread("C://opencv//samples//lena.jpg");

			JFrame frame1 = new JFrame("show image");
			frame1.setTitle("读取图像至 Java Swing 视窗");
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setSize(640, 600);
			frame1.setBounds(0, 0, frame1.getWidth(), frame1.getHeight());
			Panel panel1 = new Panel();
			frame1.setContentPane(panel1);
			frame1.setVisible(true);
			panel1.setimagewithMat(source);
			frame1.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
