/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.common;

/**
 *
 * @author lujamanandhar
 */

public class TypeChecker {
    private static DataType dt;
     
    public static DataType check (String x){
        dt = DataType.STRING;
        return dt;
    }
    public static DataType  check (byte x) {
        dt = DataType.BYTE;
        return dt;
    }
    public static DataType check(int x) {
        dt = DataType.INT;
        return dt;
    }
    public static DataType check(float x) {
        dt = DataType.FLOAT;
        return dt;
    }
    public static DataType check(double x) {
        dt = DataType.DOUBLE;
        return dt;
    }
    public static DataType  check(char x) {
        dt = DataType.CHAR;
        return dt;
    }
}
