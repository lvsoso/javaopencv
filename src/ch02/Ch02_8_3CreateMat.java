package ch02;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * �Ե�һԪ��ָ��
 * @author aVery
 *
 */
public class Ch02_8_3CreateMat {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m1 = new Mat(2, 2, CvType.CV_8UC1);
		m1.put(0, 0, 1);
		m1.put(0, 1, 2);
		m1.put(1, 0, 3);
		m1.put(1, 1, 4);
		
		System.out.println("����m1������"+m1.rows());
		System.out.println("����m1�Ŀ�"+m1.width());
		System.out.println("����m1������"+m1.cols());
		System.out.println("����m1�ĸ�"+m1.height());
		System.out.println("����m1����Ԫ�صĸ���"+m1.total());
		System.out.println("����m1����Ԫ�ص�Size"+m1.size());
		System.out.println("����m1(0, 0)��Ԫ��  = "+m1.get(0, 0)[0]);
		System.out.println("����m1(1, 1)��Ԫ��  = "+m1.get(1, 1)[0]);
		System.out.println("����m1����Ԫ�� = :\n"+m1.dump());
		m1.create(2, 2, CvType.CV_8UC1);
		System.out.println("����m1����Ԫ�� = :\n"+m1.dump());
	}

}
