package ch02;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * �Ծ���ָ��
 * @author aVery
 *
 */
public class Ch02_8_2CreateMat {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		byte[][] javaData = {
				{1, 2},
				{3, 4},
				{5, 6},
				{7, 8}
		};
		Mat m1 = new Mat(4, 2, CvType.CV_8UC1);
		for(int i=0; i<javaData.length; i++){
			m1.put(i, 0, javaData[i]);
		}
		
		System.out.println("����m1������"+m1.cols());
		System.out.println("����m1�Ŀ�"+m1.width());
		System.out.println("����m1������"+m1.rows());
		System.out.println("����m1�ĸ�"+m1.height());
		System.out.println("����m1����Ԫ�صĸ���"+m1.total());
		System.out.println("����m1����Ԫ�ص�Size"+m1.size());
		System.out.println("����m1(1, 1)��Ԫ��  = "+m1.get(0, 0)[0]);
		System.out.println("����m1(3, 1)��Ԫ��  = "+m1.get(2, 0)[0]);
		System.out.println("����m1����Ԫ�� = :\n"+m1.dump());
		m1.create(2, 2, CvType.CV_8UC1);
		System.out.println("����m1����Ԫ�� = :\n"+m1.dump());
		
		/*
		 * ����m1������2
����m1�Ŀ�2
����m1������4
����m1�ĸ�4
����m1����Ԫ�صĸ���8
����m1����Ԫ�ص�Size2x4
����m1(1, 1)��Ԫ��  = 1.0
����m1(3, 1)��Ԫ��  = 5.0
����m1����Ԫ�� = :
[  1,   2;
   3,   4;
   5,   6;
   7,   8]
����m1����Ԫ�� = :
[  0,   0;
   0,   0]
		 */
	}

}
