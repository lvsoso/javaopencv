package ch02;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

/**
 * ʹ��Scalar
 * ȫ����ͬһ��Ԫ��ָ��
 * @author aVery
 *
 */
public class Ch02_8_4CreateMat {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m1 = new Mat(2, 2, CvType.CV_8UC1, new Scalar(9));
		
		System.out.println("����m1������"+m1.rows());
		System.out.println("����m1������"+m1.cols());
		System.out.println("����m1����Ԫ�صĸ���"+m1.total());
		System.out.println("����m1����Ԫ�ص�Size"+m1.size());
		System.out.println("����m1(0, 0)��Ԫ��  = "+m1.get(0, 0)[0]);
		System.out.println("����m1(1, 1)��Ԫ��  = "+m1.get(1, 1)[0]);
		System.out.println("����m1����Ԫ�� = :\n"+m1.dump());
	}

}
