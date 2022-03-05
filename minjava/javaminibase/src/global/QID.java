package global;
import java.lang.*;

/**
 * class QID
 */
public class QID {


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
    public QID()
    {
    }

    /**
     * constructor of class
     */
    public QID(PageId pageno, int slotno) {
        pageNo = pageno;
        slotNo = slotno;
    }

    /**
     * make a copy of the given qid
     */
    public void copyQid(QID qid) {
        pageNo = qid.pageNo;
        slotNo = qid.slotNo;
    }

    /**
     * Compares two QID object, i.e, this to the qid
     *
     * @param qid QID object to be compared to
     * @return true is they are equal
     *         false if not.
     */
    public boolean equals(QID qid) {

        return (this.pageNo.pid == qid.pageNo.pid)
                && (this.slotNo == qid.slotNo);
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
