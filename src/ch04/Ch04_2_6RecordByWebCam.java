package ch04;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.IRational;

/**
 * 使用 xuggle 包 将图像进行保存
 * 
 * @author aVery
 *
 */
public class Ch04_2_6RecordByWebCam {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	static boolean isWhile = true;
	private static IRational FRAME_RATE = IRational.make(33, 1);

	private JFrame frame;

	public static void main(String[] args) throws InterruptedException {

		VideoCapture capture = new VideoCapture();
		capture.open(1);

		// UI
		JFrame frame1 = new JFrame("show image");
		frame1.setTitle("从webcam录像并保存");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(680, 480);
		frame1.setBounds(0, 0, frame1.getWidth(), frame1.getHeight());
		frame1.getContentPane().setLayout(null);
		Panel panel1 = new Panel();
		frame1.setContentPane(panel1);
		panel1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("停止錄影");
		btnNewButton_1.setBounds(561, 408, 93, 23);
		
		
		panel1.add(btnNewButton_1);
		
		
		frame1.setVisible(true);

		// 处理视频
		if (!capture.isOpened()) {
			System.out.println("Error");
		} else {
			final Mat videoFrame = new Mat();
			capture.read(videoFrame);
			frame1.setSize(videoFrame.width() + 40, videoFrame.height() + 60);

			// 保存视频
			String outFile = "c:\\opencv\\temp\\output2b.mp4";
			final IMediaWriter writer = ToolFactory.makeWriter(outFile);

			// 绑定事件
			btnNewButton_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					isWhile = false;
					writer.close();
					capture.release();
				}
			});
			
			
			writer.addVideoStream(0, 0, FRAME_RATE, 680, 480);
			long startTime = System.nanoTime();
			int index = 0;

			// 录像过程
			while (isWhile) {
				capture.read(videoFrame);
				System.out.println("记录中。。。。。。");
				panel1.setimagewithMat(videoFrame);
				frame1.repaint();

				writer.encodeVideo(0, panel1.matToBufferedImage(videoFrame), System.nanoTime() - startTime,
						TimeUnit.NANOSECONDS);
				System.out.println(FRAME_RATE.getDouble());
				Thread.sleep((long) (1000 / FRAME_RATE.getDouble()));
				index++;
				System.out.println("encoded image: " + index);
			}
		}
	}

}
