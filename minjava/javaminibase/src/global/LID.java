package global;
import java.lang.*;

/**
 * class LID
 */
public class LID {
    /**
     * public int slotNo
     */
    public int slotNo;

    /**
     * public PageId pageNo
     */
    public PageId pageNo = new PageId();

    /**
     * default constructor of class
     */
    public LID()
    {
    }

    /**
     * constructor of class
     */
    public LID(PageId pageno, int slotno) {
        pageNo = pageno;
        slotNo = slotno;
    }

    /**
     * make a copy of the given lid
     */
    public void copyLid(LID lid) {
        pageNo = lid.pageNo;
        slotNo = lid.slotNo;
    }

    /**
     * Compares two LID object, i.e, this to the qid
     *
     * @param lid LID object to be compared to
     * @return true is they are equal
     *         false if not.
     */
    public boolean equals(LID lid) {

        return (this.pageNo.pid == lid.pageNo.pid)
                && (this.slotNo == lid.slotNo);
    }

    /**
     * Write the qid into a byte array at offset
     *
     * @param array    the specified byte array
     * @param offset the offset of byte array to write
     * @exception java.io.IOException I/O errors
     */
    public void writeToByteArray(byte[] array, int offset)
            throws java.io.IOException {
        Convert.setIntValue(slotNo, offset, array);
        Convert.setIntValue(pageNo.pid, offset + 4, array);
    }

    /**
     *
     * @return Returns the corresponding EID
     */

    public EID returnEID ()
    {

        return new EID(this);
    }

    /**
     *
     * @return Returns the corresponding PID
     */

    public PID returnPID ()
    {

        return new PID(this);
    }
}
