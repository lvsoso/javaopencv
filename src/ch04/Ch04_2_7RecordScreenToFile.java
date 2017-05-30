package ch04;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.IRational;
/**
 * ¼����Ļ
 * û��ʹ�� openCvApi
 * @author aVery
 *
 */
public class Ch04_2_7RecordScreenToFile {

	private static IRational FRAME_RATE = IRational.make(33, 1);
	private static final int SECONDS_TO_RUN_FOR = 15;// ¼�� 15 ��

	public static void main(String[] args) {
		try {
			final String outFile;
			if (args.length > 0)
				outFile = args[0];
			else
				outFile = "c:\\opencv\\temp\\RecordScreenToFile.mp4";

			// ʹ��Java Robot ȥץ������Ļ����
			final Robot robot = new Robot();
			final Toolkit toolkit = Toolkit.getDefaultToolkit();
			final Rectangle screenBounds = new Rectangle(toolkit.getScreenSize());

			// ����IMediaWriter
			final IMediaWriter writer = ToolFactory.makeWriter(outFile);

			// ʹ��video stream API
			writer.addVideoStream(0, 0, FRAME_RATE, screenBounds.width, screenBounds.height);

			// ѭ��
			long startTime = System.nanoTime();
			for (int index = 0; index < SECONDS_TO_RUN_FOR * FRAME_RATE.getDouble(); index++) {
				// ץ����������Ļ
				BufferedImage screen = robot.createScreenCapture(screenBounds);

				// ת����ʽ
				BufferedImage bgrScreen = convertToType(screen, BufferedImage.TYPE_3BYTE_BGR);

				// ���a
				writer.encodeVideo(0, bgrScreen, System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

				System.out.println("encoded image: " + index);

				// ���
				Thread.sleep((long) (1000 / FRAME_RATE.getDouble()));

			}
			// �Y��
			writer.close();

		} catch (Throwable e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static BufferedImage convertToType(BufferedImage sourceImage, int targetType) {
		BufferedImage image;

		if (sourceImage.getType() == targetType) {
			image = sourceImage;
		} else {
			image = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), targetType);
			image.getGraphics().drawImage(sourceImage, 0, 0, null);
		}

		return image;
	}
}
