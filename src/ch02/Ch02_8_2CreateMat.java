package ch02;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * 以矩阵指定
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
		
		System.out.println("矩阵m1的行数"+m1.cols());
		System.out.println("矩阵m1的宽"+m1.width());
		System.out.println("矩阵m1的列数"+m1.rows());
		System.out.println("矩阵m1的高"+m1.height());
		System.out.println("矩阵m1所有元素的个数"+m1.total());
		System.out.println("矩阵m1所有元素的Size"+m1.size());
		System.out.println("矩阵m1(1, 1)的元素  = "+m1.get(0, 0)[0]);
		System.out.println("矩阵m1(3, 1)的元素  = "+m1.get(2, 0)[0]);
		System.out.println("矩阵m1所有元素 = :\n"+m1.dump());
		m1.create(2, 2, CvType.CV_8UC1);
		System.out.println("矩阵m1所有元素 = :\n"+m1.dump());
		
		/*
		 * 矩阵m1的行数2
矩阵m1的宽2
矩阵m1的列数4
矩阵m1的高4
矩阵m1所有元素的个数8
矩阵m1所有元素的Size2x4
矩阵m1(1, 1)的元素  = 1.0
矩阵m1(3, 1)的元素  = 5.0
矩阵m1所有元素 = :
[  1,   2;
   3,   4;
   5,   6;
   7,   8]
矩阵m1所有元素 = :
[  0,   0;
   0,   0]
		 */
	}

}
