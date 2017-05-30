package ch04;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

/**
 * 动态将图像显示到视窗
 * 不使用panle
 */
public class Ch04_2_4DisplayMotionByWebCamNoPanel {

	static{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Ch04_2_4DisplayMotionByWebCamNoPanel ch04_2_4DisplayMotionByWebCamNoPanel = new Ch04_2_4DisplayMotionByWebCamNoPanel();
		VideoCapture camera = new VideoCapture();
		camera.open(1);
		JFrame frame = new JFrame("show image");
		frame.setTitle("从webcam读取图像至Java Swing视窗");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(672, 480);
		frame.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		
		JLabel jlabel = new JLabel("");
		jlabel.setBounds(21, 23, 571, 413);
		frame.add(jlabel);
		frame.setVisible(true);
		if(!camera.isOpened()){
			System.out.println("Error");
		}else{
			Mat videoFrame = new Mat();
			camera.read(videoFrame);
			frame.setSize(videoFrame.width(), videoFrame.height());
			while(true){
				camera.read(videoFrame);
				BufferedImage newImage = ch04_2_4DisplayMotionByWebCamNoPanel.matToBufferedImage(videoFrame);
				jlabel.setIcon(new ImageIcon(newImage));
			}
		}	
	}

	
	/**
	 * mat 转换为 BufferedImage
	 * 
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
				data[i] = data[i + 2];
				data[i + 2] = b;
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
