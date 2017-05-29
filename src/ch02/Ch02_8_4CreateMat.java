package ch02;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

/**
 * 使用Scalar
 * 全部以同一个元素指定
 * @author aVery
 *
 */
public class Ch02_8_4CreateMat {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m1 = new Mat(2, 2, CvType.CV_8UC1, new Scalar(9));
		
		System.out.println("矩阵m1的行数"+m1.rows());
		System.out.println("矩阵m1的列数"+m1.cols());
		System.out.println("矩阵m1所有元素的个数"+m1.total());
		System.out.println("矩阵m1所有元素的Size"+m1.size());
		System.out.println("矩阵m1(0, 0)的元素  = "+m1.get(0, 0)[0]);
		System.out.println("矩阵m1(1, 1)的元素  = "+m1.get(1, 1)[0]);
		System.out.println("矩阵m1所有元素 = :\n"+m1.dump());
	}

}
