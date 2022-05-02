package com.basic_code;


public class DiagonalMatrixCalculation {
    public static void main(String[] args) {
        int[][] mat={{1,2,5},{3,4,2},{3,4,2}};
        int rd=0,ld=0, temp=0;
        temp=mat.length-1;
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat.length;j++){
                if(i==j){
                    rd=rd+mat[i][j];
                }if (temp==j){
                    ld=ld+mat[i][j];
                    temp--;
                }

            }
        }
        System.out.println(rd);
        System.out.println(ld);

    }
}
