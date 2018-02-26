package practice.concurrent.thread;

public class CtlTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;//29
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;//00011111111111111111111111111111 29

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;//11100000000000000000000000000000   32
    private static final int SHUTDOWN   =  0 << COUNT_BITS;//0
    private static final int STOP       =  1 << COUNT_BITS;//00100000000000000000000000000000     30
    private static final int TIDYING    =  2 << COUNT_BITS;//01000000000000000000000000000000    31
    private static final int TERMINATED =  3 << COUNT_BITS;//01100000000000000000000000000000    31

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    public static void main(String[] args){
        String capacity1=Integer.toBinaryString(1<<COUNT_BITS);
        String capacity2=Integer.toBinaryString(1);
       String capacity3=Integer.toBinaryString(CAPACITY);
       String capacity4=Integer.toBinaryString(~CAPACITY);// 11100000000000000000000000000000  32
       // String count_bits=Integer.toBinaryString(COUNT_BITS);
       String count_bits=Integer.toBinaryString(-1);
        String a=Integer.toBinaryString(runStateOf(2));
        String run=Integer.toBinaryString(RUNNING);
        String shut=Integer.toBinaryString(SHUTDOWN);
        String stop=Integer.toBinaryString(STOP);
        String tidying=Integer.toBinaryString(TIDYING);
        String termindated=Integer.toBinaryString(TERMINATED);
    }
}
