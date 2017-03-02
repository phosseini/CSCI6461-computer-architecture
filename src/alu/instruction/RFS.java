package alu.instruction;

import cpu.Registers;
import memory.MCU;
import util.EffectiveAddress;
import util.MachineFaultException;

public class RFS extends AbstractInstruction {

	@Override
	public void execute(String instruction, Registers registers, MCU mcu) throws MachineFaultException {
		//-----------------------------------
		// 015: RFS -> Return From Subroutine w/ return code as Immed portion
		// (optional) stored in the instruvtion's address field
		//registers.setR0(Immed));?????????????????
		//-----------------------------------
		registers.setPC(mcu.fetchFromMemory(registers.getR3()));
		// System.out.println("this is a RFS instruction!");
	}

	@Override
	public String getExecuteMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}