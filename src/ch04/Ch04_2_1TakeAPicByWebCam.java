package ch04;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

/**
 * 使用webcam进行拍照，并存储
 * @author aVery
 *
 */
public class Ch04_2_1TakeAPicByWebCam {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ch04_2_1TakeAPicByWebCam window = new Ch04_2_1TakeAPicByWebCam();
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
	public Ch04_2_1TakeAPicByWebCam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VideoCapture camera = new VideoCapture();
		camera.open(1);
		if (!camera.isOpened()) {
			System.out.println("Error");
		} else {
			Mat videoframe = new Mat();
			try {
				System.out.println("使用webCam进行拍照");
				Thread.sleep(2000);
				camera.read(videoframe);
				Imgcodecs.imwrite("c:\\opencv\\temp\\cameraTakeApicture.jpg", videoframe);
				System.out.println("拍照完成！");
			} catch (Exception e) {
				e.printStackTrace();
			}
			camera.release();
		}
		
	}

}
