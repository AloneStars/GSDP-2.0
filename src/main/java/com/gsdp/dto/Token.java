package com.gsdp.dto;

import java.util.Random;

public class Token {
	
	static String[] Token=new String[]{"0","1","2","3","4","5","6","7","8","9"};
	
	public static String randToken(){
		String token="";
		for(int i=0;i<6;i++){
			Random rand=new Random();
			int s=rand.nextInt(10);
			token=token+Token[s];
		}
		return token;
	}

}
