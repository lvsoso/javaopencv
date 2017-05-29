package ch04;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

public class Ch04_1_1ReadImgAndSave {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		try{
			Mat source = Imgcodecs.imread("C://opencv//samples//7.png");
			List<Mat> bgrList = new ArrayList<Mat>(3);
			System.out.println("channels="+source.channels());// »Ò½×=1£¬ RGB=3£»
			System.out.println("total="+source.total()); // col*row;
			System.out.println("rows="+source.rows()); // rows;
			System.out.println("cols="+source.cols()); // cols;
			System.out.println("size="+source.size()); // size;
			System.out.println("depth="+source.depth()); // depth;
			System.out.println("type="+source.type()); // type;
			System.out.println("m="+source.dump()); // type;
			//(BGR, BGR ...... 9×é£¬ ¹² 9x3-27£¨col£©, row=10)
			Core.split(source, bgrList); // split 3 channels, R(2), G(1), B(0)
			System.out.println("blue="+bgrList.get(0).dump());
			// get only blue channel mat
			System.out.println("green="+bgrList.get(1).dump());
			// get only green channel mat
			System.out.println("red="+bgrList.get(2).dump());
			// get only red channel mat
			Imgcodecs.imwrite("c://opencv//samples//7.jpg", source);
		}catch (Exception e){
			System.out.println("error: "+e.getMessage());
		}
	}

}