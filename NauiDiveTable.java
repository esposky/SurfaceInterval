package nauiTables;


public class NauiDiveTable 
{
	private char pg;
	private int ss1 = 0;
	private int ss2 = 0;
	private int ss3 = 0;
	private int diveNum = 0;
	
	//profile constructor for single dive w/surface interval
	//(depth in feet, time in minutes, surface interval in minutes)
	NauiDiveTable(int depth1, int time1, int surfInt){
		pg = calcPressureGroup(depth1, time1);
		pg = calcPostSIPG(pg, surfInt);
	}
	
	//profile constructor for 2 dive profile w/surface interval
	//(depth1, time1, surface interval1, depth2, time2)
	NauiDiveTable(int depth1, int time1, int surfInt, int depth2, int time2){
		pg = calcPressureGroup(depth1, time1);
		pg = calcPostSIPG(pg, surfInt);
		pg = calcPressureGroup(depth2, time2 + calcResidualNitrogen(pg, depth2));
	}
	
	//profile constructor for 3 dive profile w/2 surface intervals
	//(depth1, time1, surface interval1, depth2, time2, surface interval2, depth3, time3)
	NauiDiveTable(int depth1, int time1, int surfInt1, int depth2, int time2, int surfInt2, int depth3, int time3){
		pg = calcPressureGroup(depth1, time1);
		pg = calcPostSIPG(pg, surfInt1);
		pg = calcPressureGroup(depth2, time2 + calcResidualNitrogen(pg, depth2));
		pg = calcPostSIPG(pg, surfInt2);
		pg = calcPressureGroup(depth3, time3 + calcResidualNitrogen(pg, depth3));
	}
	
	public char getPG() {
		char temp = pg;
		return temp;
	}
	
	public int getSS1() {
		int temp = ss1;
		return temp;
	}
	
	public int getSS2() {
		int temp = ss2;
		return temp;
	}
	
	public int getSS3() {
		int temp = ss3;
		return temp;
	}
	
	//Equivalent Air Depth allows conversion of depth with Nitrox into air tables
	//(oxygen percentage in whole value (32, not 0.32), depth in feet)
	public static int calcEAD(double nitrox, int depth) {
		return (int)Math.ceil((((1-nitrox/100)/0.79)*(depth + 33))-33);
	}
	
	//calc Residual Nitrogen going into 2nd dive 
	//(Pressure Group, depth in feet of 2nd dive)
	private int calcResidualNitrogen(char presGrp, int depth) 
	{
		
		if(depth%10 == 0)
			depth = depth/10;
		else
			depth = depth/10 + 1;
		
		switch(presGrp) 
		{
		case 'A':
			switch(depth) {
			case 4:
				return 7;
			case 5:
				return 6;
			case 6:
				return 5;
			case 7:
				return 4;
			case 8:
				return 3;
			case 9:
				return 3;
			case 10:
				return 3;
			case 11:
				return 3;
			case 12:
				return 3;
			case 13: 
				return 3;
			default:
				return 200;
			}
		case 'B':
			switch(depth) {
			case 4:
				return 17;
			case 5:
				return 13;
			case 6:
				return 11;
			case 7:
				return 9;
			case 8:
				return 8;
			case 9:
				return 7;
			case 10:
				return 7;
			case 11:
				return 6;
			case 12:
				return 6;
			case 13: 
				return 6;
			default:
				return 200;
			}
		case 'C':
			switch(depth) {
			case 4:
				return 25;
			case 5:
				return 21;
			case 6:
				return 17;
			case 7:
				return 15;
			case 8:
				return 13;
			case 9:
				return 11;
			case 10:
				return 10;
			case 11:
				return 10;
			case 12:
				return 9;
			case 13: 
				return 8;
			default:
				return 200;
			}
		case 'D':
			switch(depth) {
			case 4:
				return 37;
			case 5:
				return 29;
			case 6:
				return 24;
			case 7:
				return 20;
			case 8:
				return 18;
			case 9:
				return 16;
			case 10:
				return 14;
			case 11:
				return 13;
			case 12:
				return 12;
			case 13: 
				return 11;
			default:
				return 200;
			}
		case 'E':
			switch(depth) {
			case 4:
				return 49;
			case 5:
				return 38;
			case 6:
				return 30;
			case 7:
				return 26;
			case 8:
				return 23;
			case 9:
				return 20;
			case 10:
				return 18;
			case 11:
				return 16;
			case 12:
				return 15;
			case 13: 
				return 13;
			default:
				return 200;
			}
		case 'F':
			switch(depth) {
			case 4:
				return 61;
			case 5:
				return 47;
			case 6:
				return 36;
			case 7:
				return 31;
			case 8:
				return 28;
			case 9:
				return 24;
			case 10:
				return 22;
			case 11:
				return 20;
			case 12:
				return 18;
			case 13: 
				return 16;
			default:
				return 200;
			}
		case 'G':
			switch(depth) {
			case 4:
				return 73;
			case 5:
				return 56;
			case 6:
				return 44;
			case 7:
				return 37;
			case 8:
				return 32;
			case 9:
				return 29;
			case 10:
				return 26;
			case 11:
				return 24;
			case 12:
				return 21;
			case 13: 
				return 19;
			default:
				return 200;
			}
		case 'H':
			switch(depth) {
			case 4:
				return 87;
			case 5:
				return 66;
			case 6:
				return 52;
			case 7:
				return 43;
			case 8:
				return 38;
			case 9:
				return 33;
			case 10:
				return 30;
			case 11:
				return 27;
			case 12:
				return 25;
			case 13: 
				return 22;
			default:
				return 200;
			}
		case 'I':
			switch(depth) {
			case 4:
				return 101;
			case 5:
				return 76;
			case 6:
				return 61;
			case 7:
				return 50;
			case 8:
				return 43;
			case 9:
				return 38;
			case 10:
				return 34;
			case 11:
				return 31;
			case 12:
				return 28;
			case 13: 
				return 25;
			default:
				return 200;
			}
		case 'J':
			switch(depth) {
			case 4:
				return 116;
			case 5:
				return 87;
			case 6:
				return 70;
			case 7:
				return 57;
			case 8:
				return 48;
			case 9:
				return 43;
			case 10:
				return 38;
			default:
				return 200;
			}
		case 'K':
			switch(depth) {
			case 4:
				return 138;
			case 5:
				return 99;
			case 6:
				return 79;
			case 7:
				return 64;
			case 8:
				return 54;
			case 9:
				return 47;
			default:
				return 200;
			}
		case 'L':
			switch(depth) {
			case 4:
				return 161;
			case 5:
				return 111;
			case 6:
				return 88;
			case 7:
				return 72;
			case 8:
				return 61;
			case 9:
				return 53;
			default:
				return 200;
			}
		default:
			return 200;
		}
	}
	
	//calc post surface interval pressure group
	//(Pressure Group, surface time in minutes)
	private char calcPostSIPG(char presGrp, int surfInt) 
	{
		switch(presGrp) 
		{
		case 'A':
			return presGrp;
		case 'B':
			if(surfInt < 201)
				return 'B';
			else
				return 'A';
		case 'C':
			if(surfInt < 100)
				return 'C';
			else if(surfInt < 290)
				return 'B';
			else
				return 'A';
		case 'D':
			if(surfInt < 70)
				return 'D';
			else if(surfInt < 159)
				return 'C';
			else if(surfInt < 349)
				return 'B';
			else
				return 'A';
		case 'E':
			if(surfInt < 55)
				return 'E';
			else if(surfInt < 118)
				return 'D';
			else if(surfInt < 205)
				return 'C';
			else if(surfInt < 395)
				return 'B';
			else
				return 'A';
		case 'F':
			if(surfInt < 46)
				return 'F';
			else if(surfInt < 90)
				return 'E';
			else if(surfInt < 149)
				return 'D';
			else if(surfInt < 237)
				return 'C';
			else if(surfInt < 426)
				return 'B';
			else
				return 'A';
		case 'G':
			if(surfInt < 41)
				return 'G';
			else if(surfInt < 76)
				return 'F';
			else if(surfInt < 120)
				return 'E';
			else if(surfInt < 179)
				return 'D';
			else if(surfInt < 266)
				return 'C';
			else if(surfInt < 456)
				return 'B';
			else
				return 'A';
		case 'H':
			if(surfInt < 37)
				return 'H';
			else if(surfInt < 67)
				return 'G';
			else if(surfInt < 102)
				return 'F';
			else if(surfInt < 144)
				return 'E';
			else if(surfInt < 201)
				return 'D';
			else if(surfInt < 290)
				return 'C';
			else if(surfInt < 480)
				return 'B';
			else
				return 'A';
		case 'I':
			if(surfInt < 34)
				return 'I';
			else if(surfInt < 60)
				return 'H';
			else if(surfInt < 90)
				return 'G';
			else if(surfInt < 123)
				return 'F';
			else if(surfInt < 165)
				return 'E';
			else if(surfInt < 224)
				return 'D';
			else if(surfInt < 313)
				return 'C';
			else if(surfInt < 502)
				return 'B';
			else
				return 'A';
		case 'J':
			if(surfInt < 32)
				return 'J';
			else if(surfInt < 55)
				return 'I';
			else if(surfInt < 80)
				return 'H';
			else if(surfInt < 108)
				return 'G';
			else if(surfInt < 141)
				return 'F';
			else if(surfInt < 185)
				return 'E';
			else if(surfInt < 243)
				return 'D';
			else if(surfInt < 341)
				return 'C';
			else if(surfInt < 531)
				return 'B';
			else
				return 'A';
		case 'K':
			if(surfInt < 29)
				return 'K';
			else if(surfInt < 50)
				return 'J';
			else if(surfInt < 72)
				return 'I';
			else if(surfInt < 96)
				return 'H';
			else if(surfInt < 124)
				return 'G';
			else if(surfInt < 159)
				return 'F';
			else if(surfInt < 202)
				return 'E';
			else if(surfInt < 260)
				return 'D';
			else if(surfInt < 349)
				return 'C';
			else if(surfInt < 539)
				return 'B';
			else
				return 'A';
		case 'L':
			if(surfInt < 27)
				return 'L';
			else if(surfInt < 46)
				return 'K';
			else if(surfInt < 65)
				return 'J';
			else if(surfInt < 86)
				return 'I';
			else if(surfInt < 110)
				return 'H';
			else if(surfInt < 140)
				return 'G';
			else if(surfInt < 174)
				return 'F';
			else if(surfInt < 217)
				return 'E';
			else if(surfInt < 276)
				return 'D';
			else if(surfInt < 363)
				return 'C';
			else if(surfInt < 553)
				return 'B';
			else
				return 'A';
		default:
			return 'Z';
		}
	}
	
	
	//calc pressure group after dive
	//(depth in feet, time in minutes)
 	private char calcPressureGroup(int depth, int diveTime) 
	{
 		diveNum++;
		char presGrp = ' ';
		int safetyStop = 0;
		if(depth%10 == 0)
			depth = depth/10;
		else
			depth = depth/10 + 1;
		
		switch(depth) {
		case 4:
			if(diveTime < 6)
				presGrp = 'A';
			else if(diveTime < 16)
				presGrp = 'B';
			else if(diveTime < 26)
				presGrp = 'C';
			else if(diveTime < 31)
				presGrp = 'D';
			else if(diveTime < 41)
				presGrp = 'E';
			else if(diveTime < 51)
				presGrp = 'F';
			else if(diveTime < 71)
				presGrp = 'G';
			else if(diveTime < 81)
				presGrp = 'H';
			else if(diveTime < 101)
				presGrp = 'I';
			else if(diveTime < 111)
				presGrp = 'J';
			else if(diveTime < 131)
				presGrp = 'K';
			else if(diveTime <= 150) {
				presGrp = 'L';
				safetyStop = 5;
			}
			else
				presGrp = 'Z';
			break;
		case 5:
			if(diveTime < 11)
				presGrp = 'B';
			else if(diveTime < 16)
				presGrp = 'C';
			else if(diveTime < 26)
				presGrp = 'D';
			else if(diveTime < 31)
				presGrp = 'E';
			else if(diveTime < 41)
				presGrp = 'F';
			else if(diveTime < 51)
				presGrp = 'G';
			else if(diveTime < 61)
				presGrp = 'H';
			else if(diveTime < 71)
				presGrp = 'I';
			else if(diveTime < 81)
				presGrp = 'J';
			else if(diveTime <= 100) {
				presGrp = 'L';
				safetyStop = 5;
			}
			else
				presGrp = 'Z';
			break;
		case 6:
			if(diveTime < 11)
				presGrp = 'B';
			else if(diveTime < 16)
				presGrp = 'C';
			else if(diveTime < 21)
				presGrp = 'D';
			else if(diveTime < 26)
				presGrp = 'E';
			else if(diveTime < 31)
				presGrp = 'F';
			else if(diveTime < 41)
				presGrp = 'G';
			else if(diveTime < 51)
				presGrp = 'H';
			else if(diveTime < 56)
				presGrp = 'I';
			else if(diveTime < 61) {
				presGrp = 'J';
				safetyStop = 5;
			}
			else if(diveTime <= 80) {
				presGrp = 'L';
				safetyStop = 7;
			}
			else
				presGrp = 'Z';
			break;
		case 7:
			if(diveTime < 6)
				presGrp = 'B';
			else if(diveTime < 11)
				presGrp = 'C';
			else if(diveTime < 16)
				presGrp = 'D';
			else if(diveTime < 21)
				presGrp = 'E';
			else if(diveTime < 31)
				presGrp = 'F';
			else if(diveTime < 36)
				presGrp = 'G';
			else if(diveTime < 41)
				presGrp = 'H';
			else if(diveTime < 46)
				presGrp = 'I';
			else if(diveTime < 51) {
				presGrp = 'J';
				safetyStop = 5;
			}
			else if(diveTime < 61) {
				presGrp = 'K';
				safetyStop = 8;
			}
			else if(diveTime <= 70) {
				presGrp = 'L';
				safetyStop = 14;
			}
			else
				presGrp = 'Z';
			break;
		case 8:
			if(diveTime < 6)
				presGrp = 'B';
			else if(diveTime < 11)
				presGrp = 'C';
			else if(diveTime < 16)
				presGrp = 'D';
			else if(diveTime < 21)
				presGrp = 'E';
			else if(diveTime < 26)
				presGrp = 'F';
			else if(diveTime < 31)
				presGrp = 'G';
			else if(diveTime < 36)
				presGrp = 'H';
			else if(diveTime < 41) {
				presGrp = 'I';
				safetyStop = 5;
			}
			else if(diveTime < 51) {
				presGrp = 'K';
				safetyStop = 10;
			}
			else if(diveTime <= 60) {
				presGrp = 'L';
				safetyStop = 17;
			}
			else
				presGrp = 'Z';
			break;
		case 9:
			if(diveTime < 6)
				presGrp = 'B';
			else if(diveTime < 11)
				presGrp = 'C';
			else if(diveTime < 13)
				presGrp = 'D';
			else if(diveTime < 16)
				presGrp = 'E';
			else if(diveTime < 21)
				presGrp = 'F';
			else if(diveTime < 26)
				presGrp = 'G';
			else if(diveTime < 31) {
				presGrp = 'H';
				safetyStop = 5;
			}
			else if(diveTime < 41) {
				presGrp = 'J';
				safetyStop = 7;
			}
			else if(diveTime <= 50) {
				presGrp = 'L';
				safetyStop = 18;
			}
			else
				presGrp = 'Z';
			break;
		case 10:
			if(diveTime < 6)
				presGrp = 'B';
			else if(diveTime < 8)
				presGrp = 'C';
			else if(diveTime < 11)
				presGrp = 'D';
			else if(diveTime < 16)
				presGrp = 'E';
			else if(diveTime < 21)
				presGrp = 'F';
			else if(diveTime < 23)
				presGrp = 'G';
			else if(diveTime < 26) {
				presGrp = 'H';
				safetyStop = 5;
			}
			else if(diveTime <= 40) {
				presGrp = 'K';
				safetyStop = 15;
			}
			else
				presGrp = 'Z';
			break;
		case 11:
			if(diveTime < 6)
				presGrp = 'C';
			else if(diveTime < 11)
				presGrp = 'D';
			else if(diveTime < 14)
				presGrp = 'E';
			else if(diveTime < 16)
				presGrp = 'F';
			else if(diveTime < 21) {
				presGrp = 'G';
				safetyStop = 5;
			}
			else if(diveTime <= 30) {
				presGrp = 'J';
				safetyStop = 7;
			}
			else
				presGrp = 'Z';
			break;
		case 12:
			if(diveTime < 6)
				presGrp = 'C';
			else if(diveTime < 11)
				presGrp = 'D';
			else if(diveTime < 13)
				presGrp = 'E';
			else if(diveTime < 16) {
				presGrp = 'F';
				safetyStop = 5;
			}
			else if(diveTime < 26) {
				presGrp = 'I';
				safetyStop = 6;
			}
			else if(diveTime <= 30) {
				presGrp = 'J';
				safetyStop = 14;
			}
			else
				presGrp = 'Z';
			break;
		case 13:
			if(diveTime < 6)
				presGrp = 'C';
			else if(diveTime < 9)
				presGrp = 'D';
			else if(diveTime < 11) {
				presGrp = 'E';
				safetyStop = 5;
			}
			else if(diveTime <= 25) {
				presGrp = 'J';
				safetyStop = 10;
			}
			else
				presGrp = 'Z';
			break;
		default:
			presGrp = 'Z';
			break;
		}
		if(diveNum == 1)
			ss1 = safetyStop;
		else if(diveNum == 2)
			ss2 = safetyStop;
		else 
			ss3 = safetyStop;
		return presGrp;
	}

}
