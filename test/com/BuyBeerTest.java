package com;

/**
 * Created by zhaoqi on 2016/6/16.
 */
public class BuyBeerTest {
    static int totalNum = 10;
    public static void main(String[] args) {
        System.out.println("啤酒总数为"+getNum(totalNum));
    }

    private static int getNum(int i) {
        return i+calculateNumber(i,i);
    }

    private static int calculateNumber(int bottelNum,int capNum) {
        System.out.println("此时啤酒瓶和瓶盖为"+bottelNum+","+capNum);
        if (bottelNum==0 && capNum <= 1) {
            System.out.println("无啤酒可换，计算结束");
            return 0;
        }
        if (bottelNum == 1 ) {
            totalNum++;
            System.out.println("借一个空瓶换了一瓶啤酒后归还空瓶" + "此时啤酒总数为" + totalNum);
            return 1 + calculateNumber(0, capNum + 1);
        }
        if (capNum == 3) {
            totalNum++;
            System.out.println("借一个瓶盖换了一瓶啤酒后归还瓶盖"+"此时啤酒总数为"+totalNum);
            return 1+calculateNumber(bottelNum+1,0);
        }
        if (bottelNum ==0 && capNum==2) {
            totalNum +=2;
            System.out.println("借两瓶啤酒喝掉后用2个空瓶和4个瓶盖换2瓶酒啤酒并归还"+"此时啤酒总数为"+totalNum);
            return 2;
        }
        else {
            int transferNum = bottelNum/2+capNum/4;
            totalNum += transferNum;
            System.out.println("用空瓶换了"+bottelNum/2+"瓶啤酒，用瓶盖换了"+capNum/4+"瓶啤酒"+"此时啤酒总数为"+totalNum);
            return transferNum+calculateNumber(bottelNum%2+transferNum,capNum%4+transferNum);
        }
    }
}
