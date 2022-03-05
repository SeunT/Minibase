package global;
import java.lang.*;

/**
 * class PID
 */
public class PID {
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
    public PID()
    {
    }

    /**
     * constructor of class
     */
    public PID(LID lid) {
        pageNo = lid.pageNo;
        slotNo = lid.slotNo;
    }
    /**
     * make a copy of the given eid
     */
    public void copyEid(EID eid) {
        pageNo = eid.pageNo;
        slotNo = eid.slotNo;
    }

    /**
     * Compares two EID object, i.e, this to the eid
     *
     * @param eid EID object to be compared to
     * @return true is they are equal
     *         false if not.
     */
    public boolean equals(EID eid) {

        return (this.pageNo.pid == eid.pageNo.pid)
                && (this.slotNo == eid.slotNo);
    }

    /**
     *
     * @return Returns the corresponding LID
     */

    public LID returnLID ()
    {

        return new LID(this.pageNo, this.slotNo);
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

}
