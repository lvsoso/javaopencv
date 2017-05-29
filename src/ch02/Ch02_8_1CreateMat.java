package ch02;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/*
 * ��������
 */
public class Ch02_8_1CreateMat {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m1 = new Mat(3, 3, CvType.CV_8UC1);
		m1.put(0, 0, new byte[] { 1, 2, 3 });
		m1.put(1, 0, new byte[] { 4, 5, 6 });
		m1.put(2, 0, new byte[]{7, 8, 9});
		System.out.println("����m1������"+m1.rows());
		System.out.println("����m1������"+m1.cols());
		System.out.println("����m1����Ԫ�صĸ���"+m1.total());
		System.out.println("����m1(1, 1)��Ԫ��  = "+m1.get(0, 0)[0]);
		System.out.println("����m1(3, 3)��Ԫ��  = "+m1.get(2, 2)[0]);
		System.out.println("����m1����Ԫ�� = :\n"+m1.dump());
		m1.create(2, 2, CvType.CV_8UC1);
		System.out.println("����m1����Ԫ�� = :\n"+m1.dump());
	}

}
