/**
 * 
 */
package duke.learn.recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Kazi
 *
 */
public class TowerOfHanoi {

    static File file = new File("/opt/hanoi_data.txt");
    static FileOutputStream fileOutputStream = null;
    static {
	try {
	    if (!file.exists()) {
		file.createNewFile();
	    }
	    fileOutputStream = new FileOutputStream(file);
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Time Complexity is O(2^n) where n is the number of disks
     * 
     * @param nDisk
     * @param from
     * @param inter
     * @param to
     */
    public static void moveTowerOfHanoi(int nDisk, char from, char inter, char to) {
	if (nDisk == 1) {
	    System.out.println("Disk 1 from " + from + " to " + to);
	} else {
	    moveTowerOfHanoi(nDisk - 1, from, to, inter); // from -> inter
	    System.out.println("Disk " + nDisk + " from  " + from + " to " + to);
	    moveTowerOfHanoi(nDisk - 1, inter, from, to); // inter -> to
	}
    }

    public static void main(String[] args) throws IOException {
	moveTowerOfHanoi(10, 'S', 'I', 'D');

    }

}
