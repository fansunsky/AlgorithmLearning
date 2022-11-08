package com.dodolu.day7;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *  
 *
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 *
 */
public class MultiplyStr {

    public String multiply(String num1, String num2) {
        StringBuffer str = new StringBuffer();
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        //两非零正整数相乘，结果的长度要么等于num1.length() + num2.length()，要么等于num1.length() + num2.length() - 1，所以这里定义一个长数组
        int[] sum = new int[num1.length() + num2.length()];
        for(int i = 0; i < num1.length(); i++){
            int x = num1.charAt(num1.length() - i -1) - '0';
            for(int j = 0; j < num2.length(); j++){
                int y = num2.charAt(num2.length() - j -1) - '0';
                int a = x * y;
                //这里只记录当前位和上一个的结果，在后面会对进位进行处理
                sum[i+j] = sum[i+j] +  a % 10;
                sum[i+j+1] = sum[i+j+1] + a / 10;
            }
        }
        //1、判断最后一位是否为0，为0则不添加到字符中
        //2、对进位进行处理
        int a = 0;
        for(int i = 0; i < sum.length; i++){
            a = sum[i] + a;
            if(i == sum.length-1 && a % 10 == 0){
                continue;
            }
            str.append(a % 10);
            a = a / 10;
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        MultiplyStr multiplyStr = new MultiplyStr();
        System.out.println(multiplyStr.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        String []splits = s.split(" ");
        for(int i = 0; i < splits.length ; i++){
            char []s1 = splits[i].toCharArray();
            reverseString(s1);
            splits[i] = new String(s1);
        }
        return String.join(" ", splits);
    }

    public void reverseString(char []s)
    {
        int left = 0, right = s.length - 1;
        char temp;
        while(left < right)
        {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
