package util;

import java.util.HashMap;

public class Const {

    public static final Integer MEMORY_RESERVE_LOCATION = 5;
    public static final Integer MEMORY_WORDS_BOUND = 2048;
    public static final Integer MEMORY_WORDS_BOUND_EXPANDED = 4096;
    public static final Integer CACHE_LINES = 16;
    public static final Integer BOOT_PROG_BASE = 8;
    public static final Integer BOOT_PROG1_BASE = 101;
    public static final HashMap<String, Integer> ROM = new HashMap<>();
    static {
        // address-value pair Boot Program
        ROM.put("8", 0x69f); // LDR 2, 2, 31
        ROM.put("9", 0x75b); // LDR 3, 1, 27
        ROM.put("10", 0xa9e); // STR 2, 2, 30
        ROM.put("11", 0x943); // STR 1, 1, 3
        ROM.put("12", 0xf87); // LDA 3, 2, 7
        ROM.put("13", 0xecb); // LDA 2, 3,11
        ROM.put("14", 0xa595); // LDX 1, 2, 21
        ROM.put("15", 0xa7c5); // LDX 3, 3, 5
        ROM.put("16", 0xa947); // STX 1, 1, 7
        ROM.put("17", 0xa9ca); // STX 1, 3, 10

    }
    public static final HashMap<String, Integer> Pro1 = new HashMap<>();
    static {
        // address-value pair Boot Program
        Pro1.put("101",0x401 );
        Pro1.put("102",0x1400  );
        Pro1.put("103",0x4426  );
        Pro1.put("104",0x400  );
        Pro1.put("105",0x1401  );
        Pro1.put("106",0x816  );
        Pro1.put("107",0x402  );
        Pro1.put("108",0x1400  );
        Pro1.put("109",0x442c  );
        Pro1.put("110",0x400  );
        Pro1.put("111",0x1402  );
        Pro1.put("112",0x817  );
        Pro1.put("113",0x416  );
        Pro1.put("114",0x1417  );
        Pro1.put("115",0x4432  );
        Pro1.put("116",0x417  );
        Pro1.put("117",0x816  );
        Pro1.put("118",0x403  );
        Pro1.put("119",0x1400  );
        Pro1.put("120",0x4437  );
        Pro1.put("121",0x400  );
        Pro1.put("122",0x1402  );
        Pro1.put("123",0x817  );
        Pro1.put("124",0x416  );
        Pro1.put("125",0x1417  );
        Pro1.put("126",0x443d  );
        Pro1.put("127",0x417  );
        Pro1.put("128",0x816  );
        Pro1.put("129",0x404  );
    }
    
    public static final HashMap<String, Integer> Pre = new HashMap<>();
    static {
        Pre.put("6", 106 );
        Pre.put("12", 112 );
        Pre.put("18", 118);  
        Pre.put("18", 118); 
        Pre.put("23", 123);
        Pre.put("29", 129);

    }

    public static final HashMap<String, Integer> TB = new HashMap<>();
    static {
        TB.put("0", 500);
        TB.put("500", 516);
        TB.put("501", 517);
        TB.put("502", 518);
        TB.put("503", 519);
        TB.put("504", 520);
        TB.put("505", 521);
        TB.put("506", 522);
        TB.put("507", 523);
        TB.put("508", 524);
        TB.put("509", 525);
        TB.put("510", 526);
        TB.put("511", 527);
        TB.put("512", 527);
        TB.put("513", 527);
        TB.put("514", 527);
        TB.put("515", 527);

        // routine 1
        // routine 2
        // routine 3
        // routine 4
        // routine 5
        // routine 6
        // routine 7
        // routine 8
        // routine 9
        // routine 10
        // routine 11
        // routine 12
        // routine 13
        // routine 14
        // routine 15
        // routine 16

    }

    /**
     * 0 - OVERFLOW</br>
     * 1 - UNDERFLOW</br>
     * 2 - DIVZERO</br>
     * 3 - EQUALORNOT
     */
    public enum ConditionCode {
        OVERFLOW(0), UNDERFLOW(1), DIVZERO(2), EQUALORNOT(3);
        int value;

        private ConditionCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    /**
     * Machine Fault</br>
     * 0 - ILL_MEM_RSV: Illegal Memory Address to Reserved Locations</br>
     * 1 - ILL_TRPC: Illegal TRAP code</br>
     * 2 - ILL_OPRC: Illegal Operation Code</br>
     * 3 - ILL_MEM_BYD: Illegal Memory Address beyond 2048 (memory installed)
     */
    public enum FaultCode {
        ILL_MEM_RSV(0), ILL_TRPC(1), ILL_OPRC(2), ILL_MEM_BYD(3);
        int value;

        private FaultCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum DevId {
        KEYBOARD(0), PRINTER(1);
        int value;

        private DevId(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    /**
     * 000000 - HLT</br>
     * 000001 - LDR</br>
     * 000010 - STR</br>
     * 000011 - LDA</br>
     * 101001 - LDX</br>
     * 101010 - STX</br>
     */
    public static final HashMap<String, String> OPCODE = new HashMap<String, String>();
    static {
        OPCODE.put("000000", "HLT");
        OPCODE.put("011110", "TRAP");
        OPCODE.put("000001", "LDR");
        OPCODE.put("000010", "STR");
        OPCODE.put("000011", "LDA");
        OPCODE.put("101001", "LDX");
        OPCODE.put("101010", "STX");
        OPCODE.put("111101", "IN");
        OPCODE.put("111110", "OUT");
        OPCODE.put("001010", "JZ");
        OPCODE.put("001011", "JNE");
        OPCODE.put("001100", "JCC");
        OPCODE.put("001101", "JMA");
        OPCODE.put("001110", "JSR");
        OPCODE.put("001111", "RFS");
        OPCODE.put("010000", "SOB");
        OPCODE.put("010001", "JGE");
        OPCODE.put("011111", "SRC");
        OPCODE.put("100000", "RRC");
        OPCODE.put("000100", "AMR");
        OPCODE.put("000101", "SMR");
        OPCODE.put("010111", "AND");
        OPCODE.put("011000", "ORR");
        OPCODE.put("011001", "NOT");
        OPCODE.put("000110", "AIR");
        OPCODE.put("000111", "SIR");
        OPCODE.put("010100", "MLT");
        OPCODE.put("010101", "DVD");
        OPCODE.put("010110", "TRR");
    }

}
