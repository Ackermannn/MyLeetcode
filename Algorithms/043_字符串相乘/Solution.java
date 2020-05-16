package lc043;

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String temp = multiply_single(num1, num2.substring(i, i + 1));
            for (int j = 0; j < num2.length() - 1 - i; j++) temp = temp + "0";
            res = add(temp, res);
        }


        return res;
    }

    // 字符串加法
    public String add(String num1, String num2) {
        String res = "";
        int size1 = num1.length(), size2 = num2.length();

        // 对齐补0
        if (size1 > size2) {
            for (int i = 0; i < size1 - size2; i++) num2 = "0" + num2;
        } else {
            for (int i = 0; i < size2 - size1; i++) num2 = "0" + num1;
        }

        // 竖式加法
        int a, b, sum, carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            a = num1.charAt(i) - '0';
            b = num2.charAt(i) - '0';
            sum = a + b + carry;
            carry = sum / 10;
            char single = (char) ((sum % 10) + '0');
            res = single + res;
        }

        if (carry != 0)
            return (char) (carry + '0') + res;
        else
            return res;
    }

    // num2位数只有一位
    public String multiply_single(String num1, String num2) {
        String res = "";
        int a, b, product, carry = 0;
        b = num2.charAt(0) - '0';

        for (int i = num1.length() - 1; i >= 0; i--) {
            a = num1.charAt(i) - '0';
            product = a * b + carry;
            carry = product / 10;
            char single = (char) ((product % 10) + '0');
            res = single + res;
        }

        if (carry != 0)
            return (char) (carry + '0') + res;
        else
            return res;
    }
}
