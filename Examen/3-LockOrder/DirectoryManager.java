public class DirectoryManager {

    public static void main(String[] args) {
        Directory dir_A = new Directory("dir_A");
        Directory dir_B = new Directory("dir_B ");
        FileSysUtil_Rev fsRev = new FileSysUtil_Rev();

        MovementManager movementManager = new MovementManager(dir_A, dir_B, fsRev);
        movementManager.start();

    }
}

class MovementManager extends Thread {
    private Directory objDir_1;
    private Directory objDir_2;
    private FileSysUtil_Rev objFileSysUtil;

    public MovementManager(Directory dir_A, Directory dir_B, FileSysUtil_Rev fs) {
        this.objDir_1 = dir_A;
        this.objDir_2 = dir_B;
        this.objFileSysUtil = fs;

    }

    @Override
    public void run() {

        //For Thread_A objDir_1 is the source directory
        objFileSysUtil.moveContents(objDir_1, objDir_2);

        //For Thread_B objDir_2 is the source directory
        objFileSysUtil.moveContents(objDir_2, objDir_1);

    }


}
