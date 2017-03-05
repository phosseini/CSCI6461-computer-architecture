package cpu;

public class Registers {

    /**
     * Condition Code: set when arithmetic/logical operations are executed.<br/>
     * 4 bits.
     */
    int cc;

    /**
     * General Purpose Register R0. <br/>
     * 16 bits.
     */
    int r0;
    /**
     * General Purpose Register R1. <br/>
     * 16 bits.
     */
    int r1;
    /**
     * General Purose Register R2. <br/>
     * 16 bits.
     */
    int r2;
    /**
     * General Purpose Register R3. <br/>
     * 16 bits.
     */
    int r3;

    /**
     * Instruction Register: holds the instruction to be executed. <br/>
     * 16 bits
     */
    int ir;

    /**
     * Memory Address Register: holds the address of the word to be fetched from
     * memory.<br/>
     * 16 bits
     */
    int mar;

    /**
     * Memory Buffer Register: holds the word just fetched from or the word to
     * be /last stored into memory.<br/>
     * 16 bits
     */
    int mbr;

    /**
     * Machine Fault Register: contains the ID code if a machine fault after it
     * occurs.<br/>
     * 4 bits.<br/>
     * 0 - Illegal Memory Address to Reserved Locations;<br/>
     * 1 - Illegal TRAP code;<br/>
     * 2 - Illegal Operation Code;<br/>
     * 3 - Illegal Memory Address beyond 2048 (memory installed).
     */
    int mfr;

    /**
     * Machine Status Register: certain bits record the status of the health of
     * the machine.<br/>
     * 16 bits.
     */
    int msr;

    /**
     * Program Counter: address of next instruction to be executed. <br/>
     * 12 bits
     */
    int pc;

    /**
     * Index Register X1. <br/>
     * 16 bits.
     */
    int x1;
    /**
     * Index Register X2. <br/>
     * 16 bits.
     */
    int x2;
    /**
     * Index Register X3. <br/>
     * 16 bits.
     */
    int x3;

    /**
     * initialize all the registers
     */
    public Registers() {
        this.cc = 0;
        this.ir = 0;
        this.mar = 0;
        this.mbr = 0;
        this.mfr = 0;
        this.msr = 0;
        this.pc = 0;
        this.r0 = 0;
        this.r1 = 0;
        this.r2 = 0;
        this.r3 = 0;
        this.x1 = 0;
        this.x2 = 0;
        this.x3 = 0;
    }

    /**
     * reset all the registers
     */
    public void init() {
        this.cc = 0;
        this.ir = 0;
        this.mar = 0;
        this.mbr = 0;
        this.mfr = 0;
        this.msr = 0;
        this.pc = 0;
        this.r0 = 0;
        this.r1 = 0;
        this.r2 = 0;
        this.r3 = 0;
        this.x1 = 0;
        this.x2 = 0;
        this.x3 = 0;
    }

    public int getCC() {
        return cc;
    }

    public void setCC(int cc) {
        this.cc = cc;
    }

    /**
     * 
     * @param bitNum
     *            </br>
     *            0 - OVERFLOW</br>
     *            1 - UNDERFLOW</br>
     *            2 - DIVZERO</br>
     *            3 - EQUALORNOT
     * @return
     */
    public boolean getCCElementByBit(int bitNum) {
        return ((this.cc & (1 << bitNum)) != 0);
    }

    /**
     * @param bitNum
     *            </br>
     *            0 - OVERFLOW</br>
     *            1 - UNDERFLOW</br>
     *            2 - DIVZERO</br>
     *            3 - EQUALORNOT
     * @param flag set either 1 or 0
     * 
     */
    public void setCCElementByBit(int bitNum, boolean flag) {
        if(flag){
            this.cc = (this.cc | (1 << bitNum));
        }else{
            int mask = ~(1 << bitNum);
            this.cc = this.cc & mask;
        }
    }

    public int getR0() {
        return r0;
    }

    public void setR0(int r0) {
        this.r0 = r0;
    }

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public int getR3() {
        return r3;
    }

    public void setR3(int r3) {
        this.r3 = r3;
    }

    /**
     * 
     * @param num
     *            from 0 to 3
     * @param r
     *            the value of the GPR
     */
    public void setRnByNum(int num, int r) {
        if (num == 0)
            this.r0 = r;
        if (num == 1)
            this.r1 = r;
        if (num == 2)
            this.r2 = r;
        if (num == 3)
            this.r3 = r;
    }

    /**
     * @param num
     *            from 0 to 3
     * @return the value of the GPR
     */
    public int getRnByNum(int num) {
        if (num == 0)
            return this.r0;
        if (num == 1)
            return this.r1;
        if (num == 2)
            return this.r2;
        if (num == 3)
            return this.r3;
        return 0;
    }

    public int getIR() {
        return ir;
    }

    /**
     * @return the value of IR in 16 bit binary String
     */
    public String getBinaryStringIr() {
        if (this.ir <= 0xffff) {
            return String.format("%16s", Integer.toBinaryString(this.ir)).replace(" ", "0");
        }
        return null;
    }

    public void setIR(int ir) {
        this.ir = ir;
    }

    public int getMAR() {
        return mar;
    }

    public void setMAR(int mar) {
        this.mar = mar;
    }

    public int getMBR() {
        return mbr;
    }

    public void setMBR(int mbr) {
        this.mbr = mbr;
    }

    public int getMFR() {
        return mfr;
    }

    public void setMFR(int mfr) {
        this.mfr = mfr;
    }

    public int getMSR() {
        return msr;
    }

    public void setMSR(int msr) {
        this.msr = msr;
    }

    public int getPC() {
        return pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public void increasePCByOne() {
        this.pc++;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    /**
     * @param num
     *            from 1 to 3
     * @return the value of Index Register
     */
    public int getXnByNum(int num) {
        if (num == 1)
            return this.x1;
        if (num == 2)
            return this.x2;
        if (num == 3)
            return this.x3;
        return 0;
    }

    /**
     * @param num
     *            from 1 to 3
     * @param x
     *            the value of Index Register
     */
    public void setXnByNum(int num, int x) {
        if (num == 1)
            this.x1 = x;
        if (num == 2)
            this.x2 = x;
        if (num == 3)
            this.x3 = x;

    }

    public int getRegistersByName(String name) {
        if (name.equals("CC"))
            return this.cc;
        if (name.equals("R0"))
            return this.r0;
        if (name.equals("R1"))
            return this.r1;
        if (name.equals("R2"))
            return this.r2;
        if (name.equals("R3"))
            return this.r3;
        if (name.equals("IR"))
            return this.ir;
        if (name.equals("MAR"))
            return this.mar;
        if (name.equals("MBR"))
            return this.mbr;
        if (name.equals("MFR"))
            return this.mfr;
        if (name.equals("MSR"))
            return this.msr;
        if (name.equals("PC"))
            return this.pc;
        if (name.equals("X1"))
            return this.x1;
        if (name.equals("X2"))
            return this.x2;
        if (name.equals("X3"))
            return this.x3;
        return 0;
    }

    public int getBitLongByName(String name) {
        if (name.equals("CC"))
            return 4;
        if (name.equals("R0"))
            return 16;
        if (name.equals("R1"))
            return 16;
        if (name.equals("R2"))
            return 16;
        if (name.equals("R3"))
            return 16;
        if (name.equals("IR"))
            return 16;
        if (name.equals("MAR"))
            return 16;
        if (name.equals("MBR"))
            return 16;
        if (name.equals("MFR"))
            return 4;
        if (name.equals("MSR"))
            return 16;
        if (name.equals("PC"))
            return 12;
        if (name.equals("X1"))
            return 16;
        if (name.equals("X2"))
            return 16;
        if (name.equals("X3"))
            return 16;
        return 0;
    }

}
