package ch04;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

/**
 * ��̬��ͼ����ʾ���Ӵ�
 * ʹ��panle
 */
public class Ch04_2_3DisplayMotionByWebCamWithPanel {

	static{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		VideoCapture camera = new VideoCapture();
		camera.open(1);
		JFrame frame = new JFrame("show image");
		frame.setTitle("��webcam��ȡͼ����Java Swing�Ӵ�");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		Panel panel1 = new Panel();
		frame.setContentPane(panel1);
		frame.setVisible(true);
		if (!camera.isOpened()) {
			System.out.println("Error");
		} else {
			Mat videoframe = new Mat();
			try {
				System.out.println("ʹ��webCam�������ղ���̬��ʾ");
				camera.read(videoframe);
				frame.setSize(videoframe.width()+40, videoframe.height()+60);
				while(true){
					camera.read(videoframe);
					System.out.println("��webcam��ȡͼ����Java Swing�Ӵ�");
					panel1.setimagewithMat(videoframe);
					frame.repaint();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			camera.release();
		}
	}


}
