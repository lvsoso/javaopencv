package ch02;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/*
 * 建立矩阵
 */
public class Ch02_8_1CreateMat {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m1 = new Mat(3, 3, CvType.CV_8UC1);
		m1.put(0, 0, new byte[] { 1, 2, 3 });
		m1.put(1, 0, new byte[] { 4, 5, 6 });
		m1.put(2, 0, new byte[]{7, 8, 9});
		System.out.println("矩阵m1的行数"+m1.rows());
		System.out.println("矩阵m1的列数"+m1.cols());
		System.out.println("矩阵m1所有元素的个数"+m1.total());
		System.out.println("矩阵m1(1, 1)的元素  = "+m1.get(0, 0)[0]);
		System.out.println("矩阵m1(3, 3)的元素  = "+m1.get(2, 2)[0]);
		System.out.println("矩阵m1所有元素 = :\n"+m1.dump());
		m1.create(2, 2, CvType.CV_8UC1);
		System.out.println("矩阵m1所有元素 = :\n"+m1.dump());
	}

}
