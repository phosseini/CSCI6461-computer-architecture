package alu.instruction;

import cpu.Registers;
import memory.MCU;
import util.MachineFaultException;
import util.StringUtil;

public class AND extends AbstractInstruction{
	int x, y, rx, ry;
	@Override
	public void execute(String instruction, Registers registers, MCU mcu) throws MachineFaultException {
		// -----------------------------------
		// 023: AND-> Logical And of Register and Register
		//c(rx) <- c(rx) AND c(ry)
		// -----------------------------------
		// TODO Auto-generated method stub
		
		this.rx=StringUtil.binaryToDecimal(instruction.substring(6,8));
		this.ry=StringUtil.binaryToDecimal(instruction.substring(8,10));
		this.x=registers.getRnByNum(rx);
		this.y=registers.getRnByNum(ry);
		x=x&y;
		registers.setRnByNum(rx, x);
		
		registers.increasePCByOne();
	}

	@Override
	public String getExecuteMessage() {
		return "AND " + this.rx+ ", " + this.ry;
	}
	
}