package alu.instruction;

import cpu.Registers;
import memory.MCU;
import util.MachineFaultException;

public class STX extends AbstractInstruction {

	@Override
	public void execute(String instruction, Registers registers, MCU mcu) throws MachineFaultException {
		// TODO Auto-generated method stub
		System.out.println("this is a STX instruction!");
	}

	@Override
	public String getExecuteMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
