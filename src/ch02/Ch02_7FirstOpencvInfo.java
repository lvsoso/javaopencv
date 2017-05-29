package ch02;

import org.opencv.core.Core;

/**
 * OpenCV µº»Î
 * @author aVery
 *
 */
public class Ch02_7FirstOpencvInfo {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);// Java native interface  call the C/C++ interface
		System.out.println("Version: "+Core.VERSION);
		System.out.println("NATIVE_LIBRARY_NAME: "+Core.NATIVE_LIBRARY_NAME);
		
		
	}

}
