package ch04;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Ch04_1_2SwingReadImg {

	/**
	 * 加载OpenCV库
	 */
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
					Ch04_1_2SwingReadImg window = new Ch04_1_2SwingReadImg();
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
	public Ch04_1_2SwingReadImg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Mat source = Imgcodecs.imread("C://opencv//samples//lena.jpg");
		BufferedImage image = matToBufferedImage(source);

		frame = new JFrame();
		frame.setTitle("读取影像至Java Swing视窗");
		frame.setBounds(10, 10, image.getHeight()+100, image.getWidth()+100);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, image.getHeight()+10, image.getWidth()+10);
		lblNewLabel.setIcon(new ImageIcon(image));
		frame.getContentPane().add(lblNewLabel);
	}

	/**
	 * mat 转换为 BufferedImage
	 * @param source
	 * @return
	 */
	private BufferedImage matToBufferedImage(Mat source) {
		int cols = source.cols();
		int rows = source.rows();
		int elemSize = (int) source.elemSize();
		byte[] data = new byte[cols * rows * elemSize];
		int type;
		source.get(0, 0, data);
		switch (source.channels()) {
		case 1:
			type = BufferedImage.TYPE_BYTE_GRAY;
			break;
		case 3:
			type = BufferedImage.TYPE_3BYTE_BGR;
			// BGR TO RGB
			byte b;
			for (int i = 0; i < data.length; i = i + 3) {
				b = data[i];
				data[i] = data[i+2];
				data[i+2] = b;
			}
			break;
		default:
			return null;
		}
		BufferedImage image2 = new BufferedImage(cols, rows, type);
		image2.getRaster().setDataElements(0, 0, cols, rows, data);
		return image2;
	}

}
