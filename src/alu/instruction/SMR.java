package alu.instruction;

import cpu.Registers;
import memory.MCU;
import util.MachineFaultException;
import util.StringUtil;

public class SMR extends AbstractInstruction {

	@Override
	public void execute(String instruction, Registers registers, MCU mcu) throws MachineFaultException {
		// -----------------------------------
		// 005: SMR -> Subtract Memory From Register
		// r <- c(r) - c(EA)
		// -----------------------------------
		int r = StringUtil.binaryToDecimal(instruction.substring(6, 8));

		// first, we store the effective address in memory address register
		registers.setMAR(util.EffectiveAddress.EA(instruction, mcu, registers));
				
		// now we store what we fetched from memory into the memory buffer register
		registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
				
		registers.setRnByNum(r, registers.getRnByNum(r) - registers.getMBR());
				
		registers.increasePCByOne();
	}

	@Override
	public String getExecuteMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
