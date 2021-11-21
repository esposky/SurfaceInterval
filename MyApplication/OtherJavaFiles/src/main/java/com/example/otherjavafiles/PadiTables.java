package com.example.otherjavafiles;

public class PadiTables {
    private char pg;
    private int ss1 = 0;

    public PadiTables(int depth1, int time1) {
        pg = calcPressureGroup(depth1, time1);
    }

    public char getPG() {
        char temp = pg;
        return temp;
    }

    public int getSS1() {
        int temp = ss1;
        return temp;
    }

    public static int calcEAD(double nitrox, int depth) {
        return (int)Math.ceil((((1-nitrox/100)/0.79)*(depth + 33))-33);
    }

    private char calcPressureGroup(int depth, int diveTime)
    {
        char presGrp = ' ';
        boolean safetyStop = false;
        if(depth%10 == 0 || depth == 35)
            depth = depth/10;
        else
            depth = depth/10 + 1;

        switch(depth) {
            case 3:
                if(diveTime < 11)
                    presGrp = 'A';
                else if(diveTime < 20)
                    presGrp = 'B';
                else if(diveTime < 26)
                    presGrp = 'C';
                else if(diveTime < 30)
                    presGrp = 'D';
                else if(diveTime < 33)
                    presGrp = 'E';
                else if(diveTime < 37)
                    presGrp = 'F';
                else if(diveTime < 41)
                    presGrp = 'G';
                else if(diveTime < 45)
                    presGrp = 'H';
                else if(diveTime < 49)
                    presGrp = 'I';
                else if(diveTime < 53)
                    presGrp = 'J';
                else if(diveTime < 58)
                    presGrp = 'K';
                else if(diveTime < 63)
                    presGrp = 'L';
                else if(diveTime < 68)
                    presGrp = 'M';
                else if(diveTime < 74)
                    presGrp = 'N';
                else if(diveTime < 80)
                    presGrp = 'O';
                else if(diveTime < 86)
                    presGrp = 'P';
                else if(diveTime < 93)
                    presGrp = 'Q';
                else if(diveTime < 101)
                    presGrp = 'R';
                else if(diveTime < 109)
                    presGrp = 'S';
                else if(diveTime < 118)
                    presGrp = 'T';
                else if(diveTime < 128)
                    presGrp = 'U';
                else if(diveTime < 140)
                    presGrp = 'V';
                else if(diveTime < 153) {
                    presGrp = 'W';
                    safetyStop = true;
                }
                else if(diveTime < 169) {
                    presGrp = 'X';
                    safetyStop = true;
                }
                else if(diveTime < 189) {
                    presGrp = 'Y';
                    safetyStop = true;
                }
                else if(diveTime <= 205) {
                    presGrp = 'Z';
                    safetyStop = true;
                }
                else
                    presGrp = '!';
                break;

            case 4:
                if(diveTime < 10)
                    presGrp = 'A';
                else if(diveTime < 17)
                    presGrp = 'B';
                else if(diveTime < 23)
                    presGrp = 'C';
                else if(diveTime < 26)
                    presGrp = 'D';
                else if(diveTime < 28)
                    presGrp = 'E';
                else if(diveTime < 32)
                    presGrp = 'F';
                else if(diveTime < 35)
                    presGrp = 'G';
                else if(diveTime < 38)
                    presGrp = 'H';
                else if(diveTime < 41)
                    presGrp = 'I';
                else if(diveTime < 45)
                    presGrp = 'J';
                else if(diveTime < 48)
                    presGrp = 'K';
                else if(diveTime < 52)
                    presGrp = 'L';
                else if(diveTime < 56)
                    presGrp = 'M';
                else if(diveTime < 61)
                    presGrp = 'N';
                else if(diveTime < 65)
                    presGrp = 'O';
                else if(diveTime < 70)
                    presGrp = 'P';
                else if(diveTime < 75)
                    presGrp = 'Q';
                else if(diveTime < 80)
                    presGrp = 'R';
                else if(diveTime < 86)
                    presGrp = 'S';
                else if(diveTime < 92)
                    presGrp = 'T';
                else if(diveTime < 98)
                    presGrp = 'U';
                else if(diveTime < 105)
                    presGrp = 'V';
                else if(diveTime < 112) {
                    presGrp = 'W';
                    safetyStop = true;
                }
                else if(diveTime < 121) {
                    presGrp = 'X';
                    safetyStop = true;
                }
                else if(diveTime < 130) {
                    presGrp = 'Y';
                    safetyStop = true;
                }
                else
                    presGrp = 'Z';
                break;

            case 5:
                if(diveTime < 8)
                    presGrp = 'A';
                else if(diveTime < 14)
                    presGrp = 'B';
                else if(diveTime < 18)
                    presGrp = 'C';
                else if(diveTime < 20)
                    presGrp = 'D';
                else if(diveTime < 22)
                    presGrp = 'E';
                else if(diveTime < 25)
                    presGrp = 'F';
                else if(diveTime < 27)
                    presGrp = 'G';
                else if(diveTime < 29)
                    presGrp = 'H';
                else if(diveTime < 32)
                    presGrp = 'I';
                else if(diveTime < 34)
                    presGrp = 'J';
                else if(diveTime < 37)
                    presGrp = 'K';
                else if(diveTime < 40)
                    presGrp = 'L';
                else if(diveTime < 42)
                    presGrp = 'M';
                else if(diveTime < 45)
                    presGrp = 'N';
                else if(diveTime < 48)
                    presGrp = 'O';
                else if(diveTime < 51)
                    presGrp = 'P';
                else if(diveTime < 54)
                    presGrp = 'Q';
                else if(diveTime < 58)
                    presGrp = 'R';
                else if(diveTime < 61)
                    presGrp = 'S';
                else if(diveTime < 64)
                    presGrp = 'T';
                else if(diveTime < 68) {
                    presGrp = 'U';
                    safetyStop = true;
                }
                else if(diveTime < 72) {
                    presGrp = 'V';
                    safetyStop = true;
                }
                else if(diveTime < 76) {
                    presGrp = 'W';
                    safetyStop = true;
                }
                else if(diveTime <= 80) {
                    presGrp = 'X';
                    safetyStop = true;
                }
                else
                    presGrp = '!';
                break;

            case 6:
                if(diveTime < 7)
                    presGrp = 'A';
                else if(diveTime < 12)
                    presGrp = 'B';
                else if(diveTime < 15)
                    presGrp = 'C';
                else if(diveTime < 17)
                    presGrp = 'D';
                else if(diveTime < 18)
                    presGrp = 'E';
                else if(diveTime < 20)
                    presGrp = 'F';
                else if(diveTime < 22)
                    presGrp = 'G';
                else if(diveTime < 24)
                    presGrp = 'H';
                else if(diveTime < 26)
                    presGrp = 'I';
                else if(diveTime < 28)
                    presGrp = 'J';
                else if(diveTime < 30)
                    presGrp = 'K';
                else if(diveTime < 31)
                    presGrp = 'L';
                else if(diveTime < 34)
                    presGrp = 'M';
                else if(diveTime < 36)
                    presGrp = 'N';
                else if(diveTime < 38)
                    presGrp = 'O';
                else if(diveTime < 40)
                    presGrp = 'P';
                else if(diveTime < 43)
                    presGrp = 'Q';
                else if(diveTime < 45)
                    presGrp = 'R';
                else if(diveTime < 48)
                    presGrp = 'S';
                else if(diveTime < 50) {
                    presGrp = 'T';
                    safetyStop = true;
                }
                else if(diveTime < 53) {
                    presGrp = 'U';
                    safetyStop = true;
                }
                else if(diveTime < 55) {
                    presGrp = 'V';
                    safetyStop = true;
                }
                else if(diveTime <= 56) {
                    presGrp = 'W';
                    safetyStop = true;
                }
                else
                    presGrp = '!';
                break;

            case 7:
                if(diveTime < 6)
                    presGrp = 'A';
                else if(diveTime < 10)
                    presGrp = 'B';
                else if(diveTime < 13)
                    presGrp = 'C';
                else if(diveTime < 14)
                    presGrp = 'D';
                else if(diveTime < 16)
                    presGrp = 'E';
                else if(diveTime < 17)
                    presGrp = 'F';
                else if(diveTime < 19)
                    presGrp = 'G';
                else if(diveTime < 20)
                    presGrp = 'H';
                else if(diveTime < 22)
                    presGrp = 'I';
                else if(diveTime < 23)
                    presGrp = 'J';
                else if(diveTime < 25)
                    presGrp = 'K';
                else if(diveTime < 27)
                    presGrp = 'L';
                else if(diveTime < 28)
                    presGrp = 'M';
                else if(diveTime < 30)
                    presGrp = 'N';
                else if(diveTime < 32)
                    presGrp = 'O';
                else if(diveTime < 34)
                    presGrp = 'P';
                else if(diveTime < 36) {
                    presGrp = 'Q';
                    safetyStop = true;
                }
                else if(diveTime < 37) {
                    presGrp = 'R';
                    safetyStop = true;
                }
                else if(diveTime < 39) {
                    presGrp = 'S';
                    safetyStop = true;
                }
                else if(diveTime <= 40) {
                    presGrp = 'T';
                    safetyStop = true;
                }
                else
                    presGrp = '!';
                break;

            case 8:
                if(diveTime < 5)
                    presGrp = 'A';
                else if(diveTime < 9)
                    presGrp = 'B';
                else if(diveTime < 11)
                    presGrp = 'C';
                else if(diveTime < 12)
                    presGrp = 'D';
                else if(diveTime < 14)
                    presGrp = 'E';
                else if(diveTime < 15)
                    presGrp = 'F';
                else if(diveTime < 16)
                    presGrp = 'G';
                else if(diveTime < 18)
                    presGrp = 'H';
                else if(diveTime < 19)
                    presGrp = 'I';
                else if(diveTime < 20)
                    presGrp = 'J';
                else if(diveTime < 22)
                    presGrp = 'K';
                else if(diveTime < 23)
                    presGrp = 'L';
                else if(diveTime < 24)
                    presGrp = 'M';
                else if(diveTime < 26)
                    presGrp = 'N';
                else if(diveTime < 27) {
                    presGrp = 'O';
                    safetyStop = true;
                }
                else if(diveTime < 29) {
                    presGrp = 'P';
                    safetyStop = true;
                }
                else if(diveTime < 30) {
                    presGrp = 'Q';
                    safetyStop = true;
                }
                else if(diveTime <= 31) {
                    presGrp = 'R';
                    safetyStop = true;
                }
                else
                    presGrp = '!';
                break;

            case 9:
                if(diveTime < 5)
                    presGrp = 'A';
                else if(diveTime < 8)
                    presGrp = 'B';
                else if(diveTime < 10)
                    presGrp = 'C';
                else if(diveTime < 11)
                    presGrp = 'D';
                else if(diveTime < 12)
                    presGrp = 'E';
                else if(diveTime < 13)
                    presGrp = 'F';
                else if(diveTime < 14)
                    presGrp = 'G';
                else if(diveTime < 16)
                    presGrp = 'H';
                else if(diveTime < 17)
                    presGrp = 'I';
                else if(diveTime < 18)
                    presGrp = 'J';
                else if(diveTime < 19)
                    presGrp = 'K';
                else if(diveTime < 20)
                    presGrp = 'L';
                else if(diveTime < 22)
                    presGrp = 'M';
                else if(diveTime < 23) {
                    presGrp = 'N';
                    safetyStop = true;
                }
                else if(diveTime < 24) {
                    presGrp = 'O';
                    safetyStop = true;
                }
                else if(diveTime < 25) {
                    presGrp = 'P';
                    safetyStop = true;
                }
                else if(diveTime <= 25) {
                    presGrp = 'Q';
                    safetyStop = true;
                }
                else
                    presGrp = '!';
                break;

            case 10:
                safetyStop = true;
                if(diveTime < 4)
                    presGrp = 'A';
                else if(diveTime < 7)
                    presGrp = 'B';
                else if(diveTime < 9)
                    presGrp = 'C';
                else if(diveTime < 10)
                    presGrp = 'D';
                else if(diveTime < 11)
                    presGrp = 'E';
                else if(diveTime < 12)
                    presGrp = 'F';
                else if(diveTime < 13)
                    presGrp = 'G';
                else if(diveTime < 14)
                    presGrp = 'H';
                else if(diveTime < 15)
                    presGrp = 'I';
                else if(diveTime < 16)
                    presGrp = 'J';
                else if(diveTime < 17)
                    presGrp = 'K';
                else if(diveTime < 18)
                    presGrp = 'L';
                else if(diveTime < 19)
                    presGrp = 'M';
                else if(diveTime < 20)
                    presGrp = 'N';
                else if(diveTime <= 20)
                    presGrp = 'O';
                else
                    presGrp = '!';
                break;

            case 11:
                safetyStop = true;
                if(diveTime < 4)
                    presGrp = 'A';
                else if(diveTime < 7)
                    presGrp = 'B';
                else if(diveTime < 8)
                    presGrp = 'C';
                else if(diveTime < 9)
                    presGrp = 'D';
                else if(diveTime < 10)
                    presGrp = 'E';
                else if(diveTime < 11)
                    presGrp = 'F';
                else if(diveTime < 12)
                    presGrp = 'G';
                else if(diveTime < 13)
                    presGrp = 'H';
                else if(diveTime < 14)
                    presGrp = 'I';
                else if(diveTime < 15)
                    presGrp = 'K';
                else if(diveTime < 16)
                    presGrp = 'L';
                else if(diveTime < 17)
                    presGrp = 'M';
                else
                    presGrp = '!';
                break;

            case 12:
                safetyStop = true;
                if(diveTime < 4)
                    presGrp = 'A';
                else if(diveTime < 6)
                    presGrp = 'B';
                else if(diveTime < 7)
                    presGrp = 'C';
                else if(diveTime < 8)
                    presGrp = 'D';
                else if(diveTime < 9)
                    presGrp = 'E';
                else if(diveTime < 10)
                    presGrp = 'F';
                else if(diveTime < 11)
                    presGrp = 'G';
                else if(diveTime < 12)
                    presGrp = 'H';
                else if(diveTime < 13)
                    presGrp = 'J';
                else if(diveTime <= 13)
                    presGrp = 'K';
                else
                    presGrp = '!';
                break;

            case 13:
                safetyStop = true;
                if(diveTime < 4)
                    presGrp = 'A';
                else if(diveTime < 6)
                    presGrp = 'B';
                else if(diveTime < 7)
                    presGrp = 'C';
                else if(diveTime < 8)
                    presGrp = 'D';
                else if(diveTime < 9)
                    presGrp = 'F';
                else if(diveTime < 10)
                    presGrp = 'G';
                else if(diveTime <= 10)
                    presGrp = 'H';
                else
                    presGrp = '!';
                break;

            case 14:
                safetyStop = true;
                if(diveTime < 5)
                    presGrp = 'B';
                else if(diveTime < 6)
                    presGrp = 'C';
                else if(diveTime < 7)
                    presGrp = 'D';
                else if(diveTime < 8)
                    presGrp = 'E';
                else if(diveTime <= 8)
                    presGrp = 'F';
                else
                    presGrp = '!';
                break;

            default:
                presGrp = 'Z';
                break;
        }
        if (safetyStop)
            ss1 = 3;
        return presGrp;
    }

    public String toString() {
        return ("Pressure Group: " + getPG() + ", Safety Stop: " + getSS1());
    }

}