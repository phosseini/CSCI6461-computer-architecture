package alu.instruction;

import cpu.Registers;
import memory.MCU;
import util.MachineFaultException;
import util.StringUtil;

public class RRC extends AbstractInstruction{
	int AL, LR, Bd, Ct, r;
	@Override
	public void execute(String instruction, Registers registers, MCU mcu) throws MachineFaultException {
		// TODO Auto-generated method stub
		this.AL=StringUtil.binaryToDecimal(instruction.substring(7,8));
		this.LR=StringUtil.binaryToDecimal(instruction.substring(8,9));
		this.r=StringUtil.binaryToDecimal(instruction.substring(5,7));
		this.Bd=registers.getRnByNum(r);
		this.Ct=StringUtil.binaryToDecimal(instruction.substring(11,15));
		
		if(AL==1){
			if(LR==0){
				Bd= (Bd>>Ct|Bd<<(16-Ct));
			}
			if(LR==1){
				Bd= (Bd<<Ct|Bd>>(16-Ct));
			}
		}
		registers.setRnByNum(r,(byte)Bd);
	}

	@Override
	public String getExecuteMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}	