package ch02;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
/**
 * ʹ��һά������о����ʼ��
 * @author aVery
 *
 */
public class Ch02_8_6CreateMat {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m1 = new Mat(4, 4, CvType.CV_32F, new Scalar(0));
		float[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		m1.put(0, 0, data);
		System.out.println("����m1����Ԫ�� = :\n"+m1.dump());
	}

}
