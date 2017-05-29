package ch02;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * Matalab方式进行初始化
 * 单一元素指定
 * @author aVery
 *
 */
public class Ch02_8_5CreateMat {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m1 = new Mat(2, 2, CvType.CV_8UC1){
			{
				put(0, 0, 1);
				put(0, 1, 2);
				put(1, 0, 3);
				put(1, 1, 4);
			}
		};
		System.out.println("矩阵m1所有元素 = :\n"+m1.dump());
		Mat m2 = Mat.zeros(1, 3, CvType.CV_8UC1);
		System.out.println("矩阵m2所有元素 = :\n"+m2.dump());
		Mat m3 = Mat.ones(1, 3, CvType.CV_8UC1);
		System.out.println("矩阵m31所有元素 = :\n"+m3.dump());
	}

}
